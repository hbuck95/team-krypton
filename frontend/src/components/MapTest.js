import React, { Component, useState } from 'react'
import ReactMapGL from 'react-map-gl'


export default class MapTest extends Component {
    
    constructor() {
        super();
        
        this.viewport= useState({
            latitude: 51,
            longitude: -2.5,
            width: "100vw",
            height: "100vh",
            zoom: 10
        })

        this.key = 'pk.eyJ1Ijoiam1jbGFyayIsImEiOiJjanpqeW16a2cwMWtzM2RvMzhhOGF3cmxjIn0.xEQ-Ddc3s6UL6ef83JKbQg';
    }
    render() {
        return (
            <div>
                <ReactMapGL {...this.viewport} mapboxApiAccessToken={this.key}>
                </ReactMapGL>
            </div>
        )
    }
}