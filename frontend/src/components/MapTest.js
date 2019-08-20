import React, { Component } from 'react'
import { GoogleMap, withScriptjs, withGoogleMap, Marker} from 'react-google-maps';
import { DrawingManager } from 'react-google-maps/lib/components/drawing/DrawingManager';
import apikey from '../gmapsApiKey'
const google = window.google;

function Map() {
    

    return (
        <GoogleMap
            defaultZoom={10}
            defaultCenter={{ lat: 51.507351, lng: -0.127758 }}
        >

            <Marker
                position={{ lat: 51.507351, lng: -0.127758 }}
            />
    <DrawingManager />
        </GoogleMap>
    )
}


export default function WrappedMap() {
    const WrappedMap = withScriptjs(withGoogleMap(Map));

    return (
        <div style={{ width: '600px', height: "400px" }}>
            <WrappedMap
                googleMapURL={`https://maps.googleapis.com/maps/api/js?key=${apikey}
                &v=3.exp&libraries=geometry,drawing,places`}
                loadingElement={<div style={{ height: "100%" }} />}
                containerElement={<div style={{ height: "100%" }} />}
                mapElement={<div style={{ height: "100%" }} />}
            />
        </div>
    )
}