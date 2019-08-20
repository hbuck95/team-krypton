import React, { Component } from 'react'

import { Table } from 'reactstrap'

import MapContainer from '../MapContainer'
import MapTest from '../MapTest'

export default class SearchPersonResult extends Component {

    render() {
        return (
            <div >

                <Table style={{width:"50%", marginLeft:50, marginTop: 50}} hover responsive bordered>
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
                <MapContainer height="400px" width="400px" data={[{ lat: 50.809310, lng: -1.070670 }]} />
            </div>
        )
    }
}