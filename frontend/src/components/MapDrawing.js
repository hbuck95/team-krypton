import React from 'react'
import { GoogleMap, withScriptjs, withGoogleMap } from "react-google-maps"
import apikey from '../gmapsApiKey'

function Map() {
    return (
        <GoogleMap
            defaultZoom={10}
            defaultCenter={{ lat: 12, lng: 12 }}

        />
    )
}

export default function WrappedMap() {
    const WrappedMap = withScriptjs(withGoogleMap(Map));

    return (
        <WrappedMap
            googleMapURL={`https://maps.googleapis.com/maps/api/js?key=${apikey}&v=3.exp&
                            libraries=geometry,drawing,places`}
            loadingElement={<div style={{ height: "100%" }} />}
            containerElement={<div style={{ height: "100%" }} />}
            mapElement={<div style={{ height: "100%" }} />}
        />
    )
}