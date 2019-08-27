import React, { Component } from 'react';

import { TabPane, Spinner } from 'reactstrap'

import ResultTableHorizontal from '../ResultTableHorizontal'


export default class AssociatesTab extends Component {

    constructor(props) {
        super(props);
        this.state = {
            uniqueAssociates: props.associatesData
        }
    }

    render() {
        if (this.props.dataLoaded) {
            return (
                <TabPane tabId='3'>
                    <h2>Associates</h2>
                    <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={this.props.associatesData}
                        headers={['Forenames', 'Surnames', 'Date of Birth', 'Home Address', 'Phone Number', 'Service Provider']}
                    />
                </TabPane>
            )
        }
        if (this.props.error === '500') {
            return (
                <TabPane tabId='3'>
                    <h1>uh oh</h1>
                </TabPane>
            )
        }

        return (
            <TabPane tabId='3' >
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}