import React, { Component } from 'react'

import { Row, Col, TabContent, TabPane, Nav, NavItem, NavLink, Spinner } from 'reactstrap'
import axios from 'axios';

import MapContainer from '../../MapContainer'
import SearchPersonResultTableVertical from './SearchPersonResultTableVertical'
import TransactionsTab from './TransactionsTab';
import AssociatesTab from '../Person/AssociatesTab';
import MainDetailTab from './MainDetailTab';


export default class SearchPersonResult extends Component {
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
            associatesData: []
        };
        
        
        this.toggle = (tab) => {
            if (this.state.activeTab !== tab) {
                this.setState({
                    activeTab: tab
                });
            }
        }
        
        this.componentDidMount = () => {
            
            props.resetRedirect();

            let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

            axios.post('http://35.197.200.12:9000/api/citizen/getCitizen', {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "homeAddress": this.state.searchData.homeAddress
            }, { headers: HEADERS })
                .then(res => {
                    console.log("citizen post success!")
                    console.log("res", res)
                    console.log("payload", res.data.payload);
                    this.setState({
                        dataLoaded: true,
                        data: res.data.payload
                    })
                }).catch(res => {
                    console.log("citizen post failed!")
                    console.log(sessionStorage.getItem('authKey'))
                    this.setState({
                        dataLoaded: false
                    })
                })

            axios.post('http://35.197.200.12:9000/api/transactions/getTransactionsForCitizen', {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "homeAddress": this.state.searchData.homeAddress
            }, { headers: HEADERS })
                .then(res => {
                    
                    this.setState({
                        transactionDataLoaded: true,
                        transactionData: res.data.payload
                    });
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
                    this.setState({
                        associateDataLoaded: true,
                        associatesData: res.data.associates
                    })
                }).catch(() =>
                    console.log("associates post failed!")
                )
        }

        this.handleAddress = (address) => {


        }
    }

    render() {
        console.log("render: ", this.state.data, this.state.transactionData)
        if (this.state.dataLoaded) {
            return (
                <div >
                    <Nav tabs>
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
                        <TabContent activeTab={this.state.activeTab}>
                            <MainDetailTab dataLoaded={this.state.dataLoaded} data={this.state.data} />
                            {/* <TabPane tabId="1">
                                <Row style={{ marginLeft: 0, marginRight: 0 }}>
                                    <Col >
                                        <SearchPersonResultTableVertical passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                                            data={{
                                                'Forenames': this.state.data.forenames,
                                                'Surname': this.state.data.surname,
                                                'Sex': this.state.data.sex,
                                                'Address': this.state.data.homeAddress,
                                                'Date of birth': this.state.data.dateOfBirth,
                                                'Place of birth': this.state.data.placeOfBirth
                                            }}
                                            topHeaders={['Fields', 'Data']}
                                        />
                                    </Col>
                                    <Col md="auto">
                                        <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                                    </Col>
                                </Row>
                            </TabPane> */}
                            <TransactionsTab dataLoaded={this.state.transactionDataLoaded} transactionData={this.state.transactionData} />
                            <AssociatesTab dataLoaded={this.state.associateDataLoaded} associatesData={this.state.associatesData} />
                        </TabContent>

                    </Nav>
                </div>
            )
        } else {
            return (
                <div>
                    <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
                </div>
            )
        }

    }
}