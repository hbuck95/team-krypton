import React, { Component } from 'react'
import { GoogleMap, withScriptjs, withGoogleMap, Marker, InfoWindow } from 'react-google-maps';
import { DrawingManager } from 'react-google-maps/lib/components/drawing/DrawingManager';
import apikey from '../gmapsApiKey'

class Map extends Component {
constructor(props){
    super(props)

    this.state
}


    render() {
        return (
            <GoogleMap
                defaultZoom={10}
                defaultCenter={{ lat: 51.454514, lng: -2.587910 }}
            >

                <Marker
                    position={{ lat: 51.454514, lng: -2.587910 }}
                    onClick={(e) => { console.log(e) }}
                    icon={{}}
                />

                <DrawingManager
                    onCircleComplete={(e) => { console.log("lat: " + e.center.lat() + ", long: " + e.center.lng()) }}
                    onMarkerComplete={(e) => { console.log("lat: " + e.position.lat() + ", long: " + e.position.lng()) }}
                />
            </GoogleMap>
        )
    }
}


export default function WrappedMap() {
    const WrappedMap = withScriptjs(withGoogleMap(Map));

    return (
        <div style={{ width: '1200px', height: "800px", maxWidth: '1800px', maxHeight: "1200px", minWidth: '400px', minHeight: '300px' }}>
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