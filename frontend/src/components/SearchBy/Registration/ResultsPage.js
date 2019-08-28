import React, { Component } from 'react';
import axios from 'axios'

import { Spinner, TabContent, Nav, NavItem, NavLink, TabPane, Col, Row } from 'reactstrap'
import ResultTableHorizontal from '../ResultTableHorizontal';
import ResultTableVertical from '../ResultTableVertical';

import MapContainer from '../../MapContainer'

import IP from '../../../ipaddress'

export default class RegistrationResultPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            activeTab: '1',
            data: {},
            locationsData: {},
            searchData: JSON.parse(localStorage.getItem('searchData')),
            dataLoaded: false
        }

        this.componentDidMount = () => {

            props.resetRedirect();
            console.log("search data", this.state.searchData.vehicleRegistrationNo)
            let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

            axios.post(`${IP}/api/vehicle/getVehicle`, {
                "vehicleRegistrationNo": this.state.searchData.vehicleRegistrationNo
            }, { headers: HEADERS })
                .then(res => {
                    console.log("vehicle post success!")
                    console.log("res", res)
                    console.log("payload", res.data.vehicle);
                    this.setState({
                        dataLoaded: true,
                        data: res.data.vehicle
                    })

                    axios.post(`${IP}/api/vehicle/getANPRCameras`,
                        {
                            "forenames": res.data.vehicle.forenames,
                            "surname": res.data.vehicle.surname,
                            "address": res.data.vehicle.address
                        },
                        { headers: HEADERS })
                        .then(res => {
                            console.log("anpr", res);
                            let locationsArr = res.data.anprCamera.map((x, i) => {
                                let temp = res.data.anprObservations.find(e => e.anprpointId === x.anprId)
                                if (temp.timeStamp) {
                                    x.timeStamp = temp.timeStamp
                                }
                                return x;
                            })
                            console.log(locationsArr)
                            this.setState({
                                locationsData: locationsArr
                            })
                        })
                        .catch(res => {
                            console.log("anpr", res);
                        })

                }).catch(res => {
                    console.log("vehicle post failed!")
                    this.setState({
                        dataLoaded: false
                    })
                })
        }

        this.toggle = (tab) => {
            if (this.state.activeTab !== tab) {
                this.setState({
                    activeTab: tab
                });
            }
        }
    }


    render() {
        if (this.state.dataLoaded) {
            console.log(this.state.data)
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
                                Known Locations
                            </NavLink>
                        </NavItem>

                    </Nav>
                    <TabContent activeTab={this.state.activeTab}>
                        <TabPane tabId='1'>
                            <ResultTableHorizontal passedStyle={{ width: "80%", marginLeft: 50, marginTop: 50 }}
                                data={[
                                    {
                                        "ID": this.state.data.registrationId,
                                        "Registration Date": this.state.data.registrationDate,
                                        "Vehicle Registration No.": this.state.data.vehicleRegistrationNo,
                                        "make": this.state.data.make,
                                        "model": this.state.data.model,
                                        "colour": this.state.data.colour,
                                    }
                                ]}
                                headers={['ID', 'Registration Date', 'Registration Number', 'Make', 'Model', 'Colour']}
                            />
                            <ResultTableVertical passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                                data={{
                                    'Forenames': this.state.data.forenames,
                                    'Surname': this.state.data.surname,
                                    'Address': this.state.data.address,
                                    'Date of birth': this.state.data.dateOfBirth,
                                    'Driver Licence ID': this.state.data.driverLicenceID
                                }}
                                topHeaders={['Fields', 'Data']}
                            />
                        </TabPane>
                        <TabPane tabId='2'>
                            <h2>ANPR Cameras</h2>
                            <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                                data={this.state.locationsData !== {} ?{
                                    timeStamp: this.state.locationsData.timeStamp,
                                    streetName: this.state.locationsData.streetName,
                                    latitude: this.state.locationsData.latitude,
                                    longitude: this.state.locationsData.longitude,
                                    anprId: this.state.locationsData.anprId
                                } :{noData: 'No ANPR Camera locations' }}
                                headers={['Time Stamp', 'Street Name', 'Longitude', 'Latitude', 'ANPR ID']} />
                            <Col md="auto">
                                <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                            </Col>
                        </TabPane>
                    </TabContent>


                </div>
            )
        }
        return (
            <div>
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </div>
        )
    }
}