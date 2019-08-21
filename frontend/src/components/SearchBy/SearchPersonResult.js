import React, { Component } from 'react'

import { Table, Row, Col, TabContent, TabPane, Nav, NavItem, NavLink, Spinner } from 'reactstrap'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';

import MapContainer from '../MapContainer'

const HEADERS = { 'Content-Type': 'application.json', "Authorization": "Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwiaWQiOiI1ZDVhY2QxMGUyMzlkNDE0YTYxYWU4YWQiLCJleHAiOjE1NzE1NjQ0OTQsImlhdCI6MTU2NjM4MDQ5NH0.snvDQIxmjUl_PuMAbTctBZZrLfWxq1qThdh9pyFrIuA"}

export default class SearchPersonResult extends Component {
    constructor(props) {
        super(props);

        this.state = {
            activeTab: '1',
            searchData: props.searchData,
            dataLoaded: false,
            data: {}
        };


        this.toggle = (tab) => {
            if (this.state.activeTab !== tab) {
                this.setState({
                    activeTab: tab
                });
            }
        }

        this.componentDidMount = () => {
            axios.post('http://localhost:9000/citizen/getCitizen', {forenames:'Garry Roger', surname:'Donnelly', homeAddress: '71 NEW ROAD, PORTSMOUTH, PO2 7QN'}, { headers: HEADERS })
                .then(res => {
                    this.setState({
                        dataLoaded: true,
                        data: res.data.payload
                    })
                }).catch(res => {
                    this.setState({
                        dataLoaded: false
                    })
                    if(res)
                        console.log(res.data.error)
                })
        }
    }

    render() {
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
                                More Details
                        </NavLink>
                        </NavItem>
                        <TabContent activeTab={this.state.activeTab}>
                            <TabPane tabId="1">
                                <Row style={{ marginLeft: 0, marginRight: 0 }}>
                                    <Col >
                                        <Table style={{ width: "95%", marginLeft: 50, marginTop: 50 }} hover bordered>
                                            <thead>
                                                <tr>
                                                    <th>Field</th>
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
                                                    <td>Thornton</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Sex</th>
                                                    <td>No</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Address</th>
                                                    <td><p>71 NEW ROAD</p><p>PORTSMOUTH</p><p>PO2 7QN</p></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Date of birth</th>
                                                    <td>18/02/1979</td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Place of birth</th>
                                                    <td>Edgeware</td>
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

                                <Table style={{ width: "95%", marginLeft: 50, marginTop: 50 }} hover bordered>
                                    <thead>
                                        <tr>
                                            <th>Field</th>
                                            <th>Data</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row" width={"20%"}>Forenames</th>
                                            <td>Otto</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Surname</th>
                                            <td>Thornton</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Sex</th>
                                            <td>No</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Address</th>
                                            <td><p>71 NEW ROAD</p><p>PORTSMOUTH</p><p>PO2 7QN</p></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Date of birth</th>
                                            <td>18/02/1979</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Place of birth</th>
                                            <td>Edgeware</td>
                                        </tr>
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