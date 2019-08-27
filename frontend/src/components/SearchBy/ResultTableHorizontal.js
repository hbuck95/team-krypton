import React, { Component } from 'react';

import { Table } from 'reactstrap';



export default class ResultTableHorizontal extends Component {
    constructor(props) {
        super(props)
        this.state = {
            headers: props.headers,
            data: props.data,
            style: props.passedStyle
        }
    }

    render() {
        console.log("horizontal render: ", this.state.data, this.props.data)
        if (this.state.data) {

            return (
                <Table hover bordered style={this.state.passedStyle}>
                    <thead>
                        <tr>
                            {this.props.headers.map((header) =>
                                <th key={header}>{header}</th>
                            )}
                        </tr>
                    </thead>
                    <tbody>
                        {(!this.props.data.noData) ? this.props.data.map((data, i) =>
                        <tr key={`data-${i}`}>
                            {Object.values(data).map((value) =>
                                <td key={`data-${value}`}>{value}</td>
                            )}
                        </tr>
                        ) : <td>No transactions on record...</td>}
                    </tbody>
                </Table>
            )
        }
        return (
            <Table>
                <thead>
                    <tr>
                        {this.props.headers.map((header) =>
                            <th key={header}>{header}</th>
                        )}
                    </tr>
                </thead>
                <tbody>
                    Error, no data
                    </tbody>
            </Table>
        )
    }

}