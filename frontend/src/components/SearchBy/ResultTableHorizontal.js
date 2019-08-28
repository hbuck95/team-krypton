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
        console.log("no data:", this.props.noData)
        if (this.props.data !== undefined && !this.props.data.noData) {
            console.log("error handle" , this.props.data)
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
                        {this.props.data.map((data, i) => {
                            return <tr key={`data-${i}`}>
                                {Object.values(data).map((value) =>
                                    <td key={`data-${value}`}>{value}</td>
                                )}
                            </tr>
                        })
                        }
                    </tbody>
                </Table>

            )
        }
        return (
            <Table style={this.state.passedStyle}>
                <thead>
                    <tr>
                        {this.props.headers.map((header) =>
                            <th key={header}>{header}</th>
                        )}
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        {this.props.data.noData ? this.props.data.noData : "no data found"}
                    </tr>
                </tbody>
            </Table>
        )
    }

}