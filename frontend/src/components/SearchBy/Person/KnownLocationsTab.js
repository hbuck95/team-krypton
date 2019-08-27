import React, { Component } from 'react';

import { TabPane, Spinner, Row, Col } from 'reactstrap'
import ResultTableHorizontal from '../ResultTableHorizontal';
import MapContainer from '../../MapContainer'

export default class KnownLocationsTab extends Component {

    constructor(props) {
        super(props);

        this.state = {
            data: [],
            transactionData: []
        }
    }

    render() {
        console.log("known location data:", this.props.data)
        if (this.props.dataLoaded) {
            return (

                <TabPane tabId='4'>
                    <h2>Transactions</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={this.props.data.atm.transactionLocations.map((x, i) => {
                            this.setState({
                                transactionData: [...this.state.transactionData, {
                                    'timestamp': this.props.data.epos.transactions[i].timestamp,
                                    'vendor': x.vendor,
                                    'Street name': x.streetName,
                                    'Post code': x.postcode,
                                    'longitude': x.longitude,
                                    'latitude': x.latitude
                                }]
                            })
                        })
                        }



                        headers={['Time Stamp', 'Vendor', 'Street Name', 'Post Code', 'Longitude', 'Latitude']} />

                    <h2>ANPR Cameras</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}

                        headers={['Time Stamp', 'Street Name', 'Longitude', 'Latitude']} />
                    <MapContainer />
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