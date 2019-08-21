import React, { Component } from 'react'

import { Table, Row, Col, TabContent, TabPane, Nav, NavItem, NavLink, Spinner } from 'reactstrap'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';

import MapContainer from '../MapContainer'

const HEADERS = { "Content-Type": "application/json", "Authorization": "Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwiaWQiOiI1ZDVhY2QxMGUyMzlkNDE0YTYxYWU4YWQiLCJleHAiOjE1NzE1NjQ0OTQsImlhdCI6MTU2NjM4MDQ5NH0.snvDQIxmjUl_PuMAbTctBZZrLfWxq1qThdh9pyFrIuA" }

export default class SearchPersonResult extends Component {
    constructor(props) {
        super(props);

        this.state = {
            activeTab: '1',
            searchData: localStorage.getItem('searchData'),
            dataLoaded: false,
            data: {},
            transactionData: {}
        };


        this.toggle = (tab) => {
            if (this.state.activeTab !== tab) {
                this.setState({
                    activeTab: tab
                });                
            }
        }

        this.componentDidMount = () => {
            console.log("search data");
            console.log(this.state.searchData);

            props.resetRedirect();

            axios.post('http://35.197.200.12:9000/api/citizen/getCitizen', {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "homeAddress": this.state.searchData.homeAddress
            }, { headers: HEADERS })
                .then(res => {
                    console.log("citizen post success!")
                    console.log(res)
                    console.log(res.data.payload);
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
                            console.log(res);
                            console.log(res.data.payload);
                            console.log(res.data.payload.atmTransactions[0]);
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
                            <NavLink
                                onClick={() => { this.toggle('1') }}
                            >
                                Main Details
                        </NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink
                                onClick={() => { this.toggle('2') }}
                            >
                                Transactions
                        </NavLink>                        
                        </NavItem>
                        <NavItem>
                            <NavLink
                                onClick={() => { this.toggle('3') }}
                            >
                                Associates
                        </NavLink>                        
                        </NavItem>
                        <TabContent activeTab={this.state.activeTab}>
                            <TabPane tabId="1">
                                <Row style={{ marginLeft: 0, marginRight: 0 }}>
                                    <Col >
                                        <Table style={{ width: "95%", marginLeft: 50, marginTop: 50 }} hover bordered>
                                            <thead>
                                                <tr>
                                                    <th>Time Stamp</th>
                                                    <th>Data</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th scope="row" width={"20%"}>Forenames</th>
                                                    <td>{this.state.data.forenames}</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Surname</th>
                                                    <td>{this.state.data.surname}</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Sex</th>
                                                    <td>{this.state.data.sex}</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Address</th>
                                                    <td>{this.state.data.homeAddress}</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Date of birth</th>
                                                    <td>{this.state.data.dateOfBirth}</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Place of birth</th>
                                                    <td>{this.state.data.placeOfBirth}</td>
                                                </tr>
                                            </tbody>
                                        </Table>
                                    </Col>
                                    <Col md="auto">
                                        <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                                    </Col>
                                </Row>
                            </TabPane>
                            <TabPane tabId="2">
                                <h2>EPOS Transactions</h2>
                                <Table style={{ width: "95%", marginLeft: 50, marginTop: 50 }} hover bordered>
                                    <thead>
                                        <tr>
                                            <th>Time Stamp</th>
                                            <th>ID</th>
                                            <th>Card Number</th>
                                            <th>Payee Account</th>
                                            <th>Amount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.transactionData.eposTransactions.map((data) =>
                                            <tr>
                                                <td>{data.timestamp}</td>
                                                <td>{data.eposId}</td>
                                                <td>{data.bankCardNumber}</td>
                                                <td>{data.payeeAccount}</td>
                                                <td>£{data.amount}</td>
                                            </tr>
                                        )}
                                    </tbody>

                                </Table>
                                <h2>ATM Transactions</h2>
                                <Table style={{ width: "95%", marginLeft: 50, marginTop: 50 }} hover bordered>
                                    <thead>
                                        <tr>
                                            <th>Time Stamp</th>
                                            <th>ID</th>
                                            <th>Card Number</th>
                                            <th>Type</th>
                                            <th>Amount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.transactionData.atmTransactions.map((data) =>
                                            <tr>
                                                <td>{data.timeStamp}</td>
                                                <td>{data.atmId}</td>
                                                <td>{data.bankCardNumber}</td>
                                                <td>{data.type}</td>
                                                <td>£{data.amount}</td>
                                            </tr>
                                        )}
                                    </tbody>
                                </Table>
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