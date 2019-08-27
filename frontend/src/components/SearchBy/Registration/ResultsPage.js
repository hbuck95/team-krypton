import React, { Component } from 'react';
import axios from 'axios'

import { Spinner, TabContent, Nav, NavItem, NavLink } from 'reactstrap'
import ResultTableHorizontal from '../ResultTableHorizontal';
import ResultTableVertical from '../ResultTableVertical';

export default class RegistrationResultPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            data: {},
            searchData: JSON.parse(localStorage.getItem('searchData')),
            dataLoaded: false
        }

        this.componentDidMount = () => {

            props.resetRedirect();
            console.log("search data", this.state.searchData.vehicleRegistrationNo)
            let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

            axios.post('http://35.197.200.12:9000/api/vehicle/getVehicle', {
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
                }).catch(res => {
                    console.log("vehicle post failed!")
                    console.log(sessionStorage.getItem('authKey'))
                    this.setState({
                        dataLoaded: false
                    })
                })
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
                        headers={['ID', 'Registration Date', 'Registration Number', 'Make', 'Model', 'Colour']}// 'Forenames', 'Surname', 'Address', 'Date of Birth', 'Driver Licence ID']}
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