import React, { Component } from 'react';

import { TabPane, Spinner, Row, Col } from 'reactstrap'

import ResultTableVertical from '../ResultTableVertical'
import MapContainer from '../../MapContainer'

export default class MainDetailTab extends Component {
    

    render() {

        console.log("main tab render: ", this.props.transactionData)
        if(this.props.dataLoaded){
        return (
            <TabPane tabId="1">
                                <Row style={{ marginLeft: 0, marginRight: 0 }}>
                                    <Col >
                                        <ResultTableVertical passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                                            data={{
                                                'Forenames': this.props.data.forenames,
                                                'Surname': this.props.data.surname,
                                                'Sex': this.props.data.sex,
                                                'Address': this.props.data.homeAddress,
                                                'Date of birth': this.props.data.dateOfBirth,
                                                'Place of birth': this.props.data.placeOfBirth
                                            }}
                                            topHeaders={['Fields', 'Data']}
                                        />
                                    </Col>
                                    <Col md="auto">
                                        <MapContainer height="400px" width="500px" style={{ marginTop: 50, marginRight: 50 }} data={[{ lat: 50.809310, lng: -1.070670 }]} />
                                    </Col>
                                </Row>
                            </TabPane>
        )
        }
        return(
            <TabPane tabId='3'>
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}