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

    // componentDidMount = () => {
    //     sessionStorage.setItem('mapStyle', JSON.stringify( {zIndex: 0, position: 'absolute', left:500, top: 50}))
    // }

    render() {
        
        if (this.props.dataLoaded) {
            return (

                <TabPane tabId='4'>
                    <h2>Transactions</h2>
                    <br />
                    <h3>EPOS</h3>
                    <ResultTableHorizontal passedStyle={{ width: "80%", marginLeft: 50, marginTop: 50 }}
                    
                        data={this.props.transactiondata.epos.transactionLocations.length !== 0 ? this.props.transactiondata.epos.transactionLocations : { noData: 'No ATM Transactions found' }}
                        headers={['Time Stamp', 'Vendor', 'Street Name', 'Post Code', 'Longitude', 'Latitude']} />
                        
                    <h3>ATM</h3>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}

                        data={this.props.transactiondata.atm.transactionLocations.length !== 0 ? this.props.transactiondata.atm.transactionLocations : { noData: 'No ATM Transactions found' }}
                        headers={['Time Stamp', 'Vendor', 'Street Name', 'Post Code', 'Longitude', 'Latitude']} />


                    <h3>ANPR Cameras</h3>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={this.props.anprLocationsData ? this.props.anprLocationsData : { noData: <Spinner style={{ width: '2rem', height: '2rem' }} /> }}
                        headers={['Time Stamp', 'ANPR ID', 'Street Name', 'Longitude', 'Latitude']} />

                    <h3>Cell Towers</h3>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                    data={this.props.celltowerdata ? this.props.celltowerdata : { noData: <Spinner style={{ width: '2rem', height: '2rem' }} />}} 
                    headers={['Time Stamp', 'Cell Tower ID', 'Operator',  'Type', 'Longitude', 'Latitude']}/>
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