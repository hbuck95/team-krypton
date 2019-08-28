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

        if (this.props.dataLoaded) {
            return (

                <TabPane tabId='4'>
                    <h2>Transactions</h2>
                    <h3>EPOS</h3>
                    <ResultTableHorizontal passedStyle={{ width: "80%", marginLeft: 50, marginTop: 50 }}
                    
                        data={this.props.data.epos.transactionLocations.length !== 0 ? this.props.data.epos.transactionLocations : { noData: 'No ATM Transactions found' }}
                        headers={['Time Stamp', 'Vendor', 'Street Name', 'Post Code', 'Longitude', 'Latitude']} />
                        
                    <h3>ATM</h3>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}

                        data={this.props.data.atm.transactionLocations.length !== 0 ? this.props.data.atm.transactionLocations : { noData: 'No ATM Transactions found' }}
                        headers={['Time Stamp', 'Vendor', 'Street Name', 'Post Code', 'Longitude', 'Latitude']} />


                    <h2>ANPR Cameras</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={{ noData: 'No ANPR Camera locations' }}
                        headers={['Time Stamp', 'Street Name', 'Longitude', 'Latitude']} />
                    <Col md="auto">
                        <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                    </Col>
                </TabPane>

            )
        }
        return (
            <TabPane tabId='4'>
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}