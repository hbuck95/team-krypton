import React, { Component } from 'react';

import { TabPane, Spinner, Row, Col } from 'reactstrap'
import ResultTableHorizontal from '../ResultTableHorizontal';

export default class KnownLocationsTab extends Component {

    render() {
        console.log("known location data:", this.props.data)
        if (this.props.dataLoaded) {
            return (

                <TabPane tabId='4'>
                    <h2>Cell Towers</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}

                        headers={['Time Stamp', 'Longitude', 'Latitude']} />
                    <h2>Transactions</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={[{
                            'timestamp': this.props.data.epos.transactions.timestamp,
                            'vendor': this.props.data.epos.transactionLocations.vendor,
                            'Street name': this.props.data.epos.transactionLocations.streetName,
                            'Post code': this.props.data.epos.transactionLocations.postCode,
                            'longitude': this.props.data.epos.transactionLocations.longitude,
                            'latitude': this.props.data.epos.transactionLocations.latitude
                        }]}
                        headers={['Time Stamp', 'Vendor', 'Street Name', 'Post Code', 'Longitude', 'Latitude']} />

                    <h2>ANPR Cameras</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}

                        headers={['Time Stamp', 'Street Name', 'Longitude', 'Latitude']} />

                </TabPane>

            )
        }
        return (
            <TabPane tabId='3'>
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}