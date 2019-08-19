import React, { Component } from 'react';
import { Map, GoogleApiWrapper } from 'google-maps-react';


class MapContainer extends Component {
    constructor(props) {
        super(props);

        this.state = {
            lat: props.lat,
            lng: props.lng
        }
        this.mapStyles = {
            width: '100%',
            height: '100%',
        };
    }

    render() {
        return (
            <div style={{zIndex:-1}}>
                <Map
                    google={this.props.google}
                    zoom={8}
                    style={this.mapStyles}
                    initialCenter={{ lat: 51.4506501, lng: -2.5940406 }}
                />
            </div>
        );
    }
}

export default GoogleApiWrapper({
    apiKey: 'AIzaSyD94ENnmni6iOiBBJAPuDFtPiOg6Bw8IPY'
})(MapContainer);