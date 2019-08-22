import React, { Component } from 'react';
import _ from 'lodash'

import { Table } from 'reactstrap';



export default class SearchPersonResultTableVertical extends Component {
    constructor(props) {
        super(props)
        this.state = {
            topHeaders: props.topHeaders,
            sideHeaders: props.sideHeaders,
            data: props.data,
            style: props.passedStyle
        }


    }

    render() {
        console.log("data", this.state.data)
        return (
            <Table hover bordered >
                <thead>
                    <tr>
                        {this.state.topHeaders.map((header) =>
                            <th>{header}</th>
                        )}
                    </tr>
                </thead>
                <tbody>
                    {
                        // _.zipWith(this.state.sideHeaders, Object.values(this.state.data), (a, b) => 
                        // <tr>
                        //     <th scope="row" width={"20%"}>{a}</th>
                        //     <td>{b}</td>
                        // </tr>)
                    }
                    {Object.entries(this.state.data).map((value) =>
                        <tr>
                            <th scope="row" width={"20%"}>{value[0]}</th>
                            {/* <th scope="row" width={"20%"}>{this.state.sideHeaders}</th> */}
                            <td>{value[1]}</td>
                        </tr>
                    )}
                </tbody>
            </Table>
        )
    }

}