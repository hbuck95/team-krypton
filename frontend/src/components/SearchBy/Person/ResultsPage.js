import React, { Component } from 'react'

import { TabContent, Nav, NavItem, NavLink, Spinner } from 'reactstrap'
import axios from 'axios';


import TransactionsTab from './TransactionsTab';
import AssociatesTab from './AssociatesTab';
import MainDetailTab from './MainDetailTab';

import GEO_API_KEY from '../../../geocoderApiKey';
import KnownLocationsTab from './KnownLocationsTab';


export default class SearchPersonResult extends Component {
    _isMounted = false;


    constructor(props) {
        super(props);

        this.state = {
            activeTab: '1',
            searchData: JSON.parse(localStorage.getItem('searchData')),
            dataLoaded: false,
            transactionDataLoaded: false,
            associateDataLoaded: false,
            data: {},
            transactionData: {
                eposTransactions: [],
                atmTransactions: []
            },
            associatesData: [],
            knownLocationsData: []
        };


        this.toggle = (tab) => {
            if (this.state.activeTab !== tab) {
                this.setState({
                    activeTab: tab
                });
            }
        }

        this.componentDidMount = () => {
            this._isMounted = true;
            props.resetRedirect();

            let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

            let splitaddress = this.state.searchData.homeAddress.split(', ')
            let address = {
                street: splitaddress[0].replace(' ', '+'),
                area: splitaddress[1].replace(' ', '+')
            }
            axios.post(`https://maps.googleapis.com/maps/api/geocode/json?address=${address.street},${address.area}&key=${GEO_API_KEY}`)
                .then(res => {
                    console.log("geocoder res: ", res)
                    if (this._isMounted) {
                        localStorage.setItem('latSearch', res.data.results[0].geometry.location.lat);
                        localStorage.setItem('lngSearch', res.data.results[0].geometry.location.lng);
                    }
                })
                .catch(res => {
                    console.log("geocoder fail", res);
                })
            axios.post('http://35.197.200.12:9000/api/citizen/getCitizen', {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "homeAddress": this.state.searchData.homeAddress
            }, { headers: HEADERS })
                .then(res => {
                    console.log("citizen post success!")
                    console.log("res", res)
                    console.log("payload", res.data.payload);
                    if (this._isMounted) {
                        this.setState({
                            dataLoaded: true,
                            data: res.data.payload
                        })
                    }

                }).catch(res => {
                    console.log("citizen post failed!")
                    console.log(sessionStorage.getItem('authKey'))
                    if (this._isMounted) {
                        this.setState({
                            dataLoaded: false
                        })
                    }
                })

            axios.post('http://35.197.200.12:9000/api/transactions/getTransactionsForCitizen', {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "homeAddress": this.state.searchData.homeAddress
            }, { headers: HEADERS })
                .then(res => {
                    if (this._isMounted) {
                        console.log("transaction data", res.data.payload)
                        this.setState({
                            transactionDataLoaded: true,
                            transactionData: res.data.payload
                        });
                    }
                }).catch(res => {
                    console.log("transaction post failed!");
                    if (res) {
                        console.log("error!")
                    }
                })

            axios.post('http://35.197.200.12:9000/api/callrecords/getAssociates', {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "address": this.state.searchData.homeAddress
            }, { headers: HEADERS })
                .then(res => {
                    console.log("associates post success!");
                    console.log("data: ", res.data.associates);
                    if (this._isMounted) {
                        this.setState({
                            associateDataLoaded: true,
                            associatesData: res.data.associates
                        })
                    }
                }).catch(() =>
                    console.log("associates post failed!")
                )

            axios.post('http://35.197.200.12:9000/api/callrecords/getCellTowers',
                {},
                { headers: HEADERS })
                .then()
                .catch()

            axios.post('http://35.197.200.12:9000/api/vehicle/getANPRCameras',
                {
                    "forenames": this.state.searchData.forenames,
                    "surname": this.state.searchData.surname,
                    "address": this.state.searchData.homeAddress
                },
                { headers: HEADERS })
                .then(res => {
                    console.log(res);
                })
                .catch()


        }

        this.componentWillUnmount = () => {
            this._isMounted = false;
        }

        this.handleAddress = (address) => {


        }
    }

    render() {
        console.log("render: ", this.state.data, this.state.transactionData)
        // if (this.state.dataLoaded) {
            return (
                <div>
                    <Nav tabs style={{ width: "100%" }}>
                        <NavItem>
                            <NavLink onClick={() => { this.toggle('1') }}>
                                Main Details
                            </NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink onClick={() => { this.toggle('2') }}>
                                Transactions
                            </NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink onClick={() => { this.toggle('3') }}>
                                Associates
                            </NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink onClick={() => { this.toggle('4') }}>
                                Known locations
                            </NavLink>
                        </NavItem>
                    </Nav>
                    <TabContent activeTab={this.state.activeTab}>
                        <MainDetailTab style={{ marginTop: "100px" }} dataLoaded={this.state.dataLoaded} data={this.state.data} />
                        <TransactionsTab style={{ marginTop: "100px" }} dataLoaded={this.state.transactionDataLoaded} transactionData={this.state.transactionData} />
                        <AssociatesTab style={{ marginTop: "100px" }} dataLoaded={this.state.associateDataLoaded} associatesData={this.state.associatesData} />
                        <KnownLocationsTab style={{ marginTop: "100px" }} dataLoaded={this.state.transactionDataLoaded} data={this.state.transactionData} />
                    </TabContent>
                </div>
            )
        // } else {
        //     return (
        //         <div>
        //             <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
        //         </div>
        //     )
        // }

    }
}