import React, { Component } from 'react';
// import { Map, GoogleApiWrapper, Marker } from 'google-maps-react';
// import {
//     GoogleMap, DrawingManager
// } from '@react-google-maps/api'
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from 'react-google-maps'
import PropTypes from 'prop-types'

import apikey from '../gmapsApiKey'


export default class MapContainer extends Component {
    constructor(props) {
        super(props);

        this.state = {
            lat: props.lat,
            lng: props.lng
        }
        this.mapStyles = {
            width: '80%',
            height: '90%',
        };

        this.ExampleDrawingPropTypes = {
            styles: PropTypes.shape({
                container: PropTypes.object.isRequired
            }).isRequired
        }

        this.MapComponent = withScriptjs(withGoogleMap((props) => 
            <GoogleMap
                defaultZoom={8}
                defaultCenter={{ lat: -34.397, lng: 150.644 }}
            >
                {props.isMarkerShown && <Marker position={{lat:-34.397, lng: 150.644}} />}
            </GoogleMap>
            ))
        

    }



    render() {
        return (
            this.MapComponent
            // <div style={{ zIndex: -1 }}>
            //     <GoogleMap
            //         id="drawing-manager-example"
            //         mapContainerStyle={{
            //             height: "400px",
            //             width: "800px"
            //         }}
            //         zoom={2.5}
            //         center={{
            //             lat: 38.685,
            //             lng: -115.234
            //         }}
            //     >
            //         {/* <DrawingManager
            //             onLoad={drawingManager => {
            //                 console.log("drawingManager: " + drawingManager)
            //             }}
            //             onPolygonComplete={(polygon) => console.log({ polygon })}
            //         /> */}
            //     </GoogleMap>
            // </div>
        );
    }
}
// export default GoogleApiWrapper({
//     apiKey: apikey
// })(MapContainer);
{/* <Map
    google={this.props.google}
    zoom={10}
    style={this.mapStyles}
    initialCenter={{ lat: 51.4506501, lng: -2.5940406 }}
>
    <Marker position={{ lat: 51.4506501, lng: -2.5940406 }} />
    <DrawingManager />
    </Map> */}