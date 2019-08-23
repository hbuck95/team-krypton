import React, { Component } from 'react';

import { TabPane, Spinner } from 'reactstrap'

import ResultTableHorizontal from './SearchPersonResultTableHorizontal'

export default class TransactionsTab extends Component {

    render() {

        console.log("transactions tab render: ", this.props.transactionData)
        if(this.props.dataLoaded){
        return (
            <TabPane tabId='2'>
                <h2>EPOS Transactions</h2>
                <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                    data={this.props.transactionData.eposTransactions}
                    headers={['Time Stamp', 'ID', 'Card Number', 'Payee Account', 'Amount']}
                />

                <h2>ATM Transactions</h2>

                <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                    data={this.props.transactionData.atmTransactions}
                    headers={['Time Stamp', 'ID', 'Card Number', 'Type', 'Amount']}
                />
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