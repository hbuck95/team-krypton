import React, { Component } from 'react';
import axios from 'axios'

import { Spinner, TabPane, Col, Row } from 'reactstrap'
import ResultTableHorizontal from '../ResultTableHorizontal';

import MapContainer from '../../MapContainer'

export default class LocationsTab extends Component {
    render() {
        if (this.props.dataLoaded) {
            return (
                <TabPane tabId='2'>
                    <h2>ANPR Cameras</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={this.props.locationsData ?
                            this.props.locationsData : { noData: 'No ANPR Camera locations' }}
                        headers={['Time Stamp', 'ANPR ID', 'Street Name', 'Longitude', 'Latitude']} />
                    <Col md="auto">
                        <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                    </Col>
                </TabPane>
            )
        }
        return (
            <TabPane tabId='2'>
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}