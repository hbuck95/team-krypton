import React, { Component } from 'react'

import { Table, Row, Col, TabContent, TabPane, Nav, NavItem, NavLink, Spinner } from 'reactstrap'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';

import MapContainer from '../MapContainer'
import SearchPersonResultTableVertical from './SearchPersonResultTableVertical'
import SearchPersonResultTableHorizontal from './SearchPersonResultTableHorizontal'

const HEADERS = { "Content-Type": "application/json", "Authorization": "Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwiaWQiOiI1ZDVhY2QxMGUyMzlkNDE0YTYxYWU4YWQiLCJleHAiOjE1NzE1NjQ0OTQsImlhdCI6MTU2NjM4MDQ5NH0.snvDQIxmjUl_PuMAbTctBZZrLfWxq1qThdh9pyFrIuA" }

export default class SearchPersonResult extends Component {
    constructor(props) {
        super(props);

        this.state = {
            activeTab: '1',
            searchData: JSON.parse(localStorage.getItem('searchData')),
            dataLoaded: false,
            data: {},
            transactionData: {
                eposTransactions: [],
                atmTransactions: []
            }
        };


        this.toggle = (tab) => {
            if (this.state.activeTab !== tab) {
                this.setState({
                    activeTab: tab
                });
            }
        }

        this.componentDidMount = () => {
            console.log("search data", this.state.searchData);
            console.log("localstorage", localStorage.getItem('searchData'))

            props.resetRedirect();

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
                        data: res.data.payload
                    },
                        () => { })
                    axios.post('http://35.197.200.12:9000/api/transactions/getTransactionsForCitizen', {
                        "forenames": this.state.searchData.forenames,
                        "surname": this.state.searchData.surname,
                        "homeAddress": this.state.searchData.homeAddress
                    }, { headers: HEADERS })
                        .then(res => {
                            console.log("transaction post success!");
                            console.log("res", res);
                            console.log("payload", res.data.payload);
                            console.log("atm", res.data.payload.atmTransactions[0]);
                            this.setState({
                                dataLoaded: true,
                                transactionData: res.data.payload
                            });
                        }).catch(res => {
                            console.log("transaction post failed!");
                            if (res) {
                                console.log("error!")
                            }
                        })
                }).catch(res => {
                    console.log("citizen post failed!")
                    this.setState({
                        dataLoaded: false
                    })
                    if (res) {
                        console.log("error!")
                    }
                })



        }

        this.handleAddress = (address) => {


        }
    }

    render() {
        console.log("render: ", this.state.transactionData)
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
                            <TabPane tabId="1">
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
                                            sideHeaders={['Forenames', 'Surname', 'Sex', 'Address', 'Date of birth', 'Place of birth']}
                                        />
                                    </Col>
                                    <Col md="auto">
                                        <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                                    </Col>
                                </Row>
                            </TabPane>
                            <TabPane tabId="2">
                                <h2>EPOS Transactions</h2>
                                <SearchPersonResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                                    data={this.state.transactionData.eposTransactions}
                                    headers={['Time Stamp', 'ID', 'Card Number', 'Payee Account', 'Amount']}
                                />

                                <h2>ATM Transactions</h2>

                                <SearchPersonResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                                    data={this.state.transactionData.atmTransactions}
                                    headers={['Time Stamp', 'ID', 'Card Number', 'Type', 'Amount']}
                                />
                            </TabPane>
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