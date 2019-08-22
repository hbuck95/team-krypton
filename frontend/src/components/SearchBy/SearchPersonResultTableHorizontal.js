import React, { Component } from 'react';

import { Table } from 'reactstrap';



export default class SearchPersonResultTableHorizontal extends Component {
    constructor(props) {
        super(props)
        this.state = {
            headers: props.headers,
            data: props.data,
            style: props.passedStyle
        }
    }

    render() {
        if (this.state.data) {

            return (
                <Table hover bordered style={this.state.passedStyle}>
                    <thead>
                        <tr>
                            {this.state.headers.map((header) =>
                                <th>{header}</th>
                            )}
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.data.map((data) =>
                        <tr>
                            {Object.values(data).map((value) =>
                                <td>{value}</td>
                            )}
                        </tr>
                        )}
                    </tbody>
                </Table>
            )
        }
        return (
            <Table>
                <thead>
                    <tr>
                        {this.state.headers.map((header) =>
                            <th>{header}</th>
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