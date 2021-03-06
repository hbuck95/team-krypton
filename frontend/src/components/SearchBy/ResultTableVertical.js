import React, { Component } from 'react';
// import _ from 'lodash'

import { Table } from 'reactstrap';



export default class ResultTableVertical extends Component {
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
        
        return (
            <Table hover bordered >
                <thead>
                    <tr>
                        {this.state.topHeaders.map((header, i) =>
                            <th key={header + i}>{header}</th>
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
                    {Object.entries(this.props.data).map((value, i) =>
                        <tr>
                            <th scope="row" width={"20%"} key={i}>{value[0]}</th>
                            {/* <th scope="row" width={"20%"}>{this.state.sideHeaders}</th> */}
                            <td key={value[1]}>{value[1]}</td>
                        </tr>
                    )}
                </tbody>
            </Table>
        )
    }

}