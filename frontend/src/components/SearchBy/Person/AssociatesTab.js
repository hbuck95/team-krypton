import React, { Component } from 'react';

import { TabPane, Spinner } from 'reactstrap'

import ResultTableHorizontal from './SearchPersonResultTableHorizontal'


export default class AssociatesTab extends Component {

    constructor(props) {
        super(props);
        this.state = {
            uniqueAssociates: props.associatesData
        }

        // const result = [];
        // const map = new Map();
        // for(const item of props.associatesData) {
        //     if(!map.has(item.forenames)){
        //         map.set(item.forenames, true);
        //         result.push({
        //             forenames: item.forenames,
        //             surname: item.surname,
        //             dateOfBirth: item.dateOfBirth,
        //             address: item.address,
        //             phoneNumber: item.phoneNumber,
        //             network: item.network
        //         })
        //     }
        // }
        // this.setState({
        //     uniqueAssociates: result
        // })
        
    }

    render() {

        console.log("associates tab render: ", this.props.associatesData);
        console.log("data loaded: ", this.props.dataLoaded);
        console.log("unique: ", this.state.uniqueAssociates);
        // console.log("reduce", this.props.associatesData.reduce((a, curr) => {
        //     const x = a.find(item => item.forenames === curr.forenames);
        //     if(!x){
        //         return a.concat([curr]);
        //     } else {
        //         return a;
        //     }
        // }, []))
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
        return (
            <TabPane tabId='3'>
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}