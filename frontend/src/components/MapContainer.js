import React, { Component } from 'react'
import { GoogleMap, withScriptjs, withGoogleMap, Marker, Circle } from 'react-google-maps';
import { DrawingManager } from 'react-google-maps/lib/components/drawing/DrawingManager';
import apikey from '../gmapsApiKey'

class Map extends Component {
    constructor(props) {
        super(props)

        this.state = {
            lat: 51.45,
            lng: -2.58,
            radius: 5000,
            prevLat: [],
            prevLng: [],
            undos: 0,
            viewLat: 51.45,
            viewLng: -2.58
        }

        this.onSubmit = (e) => {
            e.preventDefault();
            console.log(e.target[0].value)
            this.setState({
                lat: parseFloat(e.target[0].value),
                lng: parseFloat(e.target[1].value),
                radius: parseFloat(e.target[2].value)
            })
        }

        this.undo = () => {
            if((this.state.lat !== this.state.prevLat) &&(this.state.lng !== this.state.prevLng))
            this.setState({
                lat: this.state.prevLat[this.state.prevLat.length-1], 
                lng: this.state.prevLng[this.state.prevLng.length -1]
            })
        }
    }


    render() {
        return (
            <div>
                <GoogleMap
                    defaultZoom={10}
                    defaultCenter={{ lat: this.state.viewLat, lng: this.state.viewLng }}
                    center={{ lat: this.state.viewLat, lng: this.state.viewLng }}
                >

                    <Marker
                        position={{ lat: this.state.lat, lng: this.state.lng }}
                        draggable={true}
                        onDragStart={(e) => {
                            this.setState(state => {
                                const prevLat = [...state.prevLat, parseFloat(e.latLng.lat())];
                                const prevLng = [...state.prevLng, parseFloat(e.latLng.lng())];
                                return {
                                  prevLat,
                                  prevLng
                                };
                              });
                            // this.setState({
                            //     prevLat: parseFloat(e.latLng.lat()),
                            //     prevLng: parseFloat(e.latLng.lng())
                            // })
                        }}
                        
                        onDrag={(e) => {
                            this.setState({
                                lat: parseFloat(Math.round(e.latLng.lat() * 100) / 100),
                                lng: parseFloat(Math.round(e.latLng.lng() * 100) / 100),
                                //viewLat: parseFloat(e.latLng.lat()), 
                                //viewLng: parseFloat(e.latLng.lng())
                            })
                        }}

                    />

                    <Circle
                        defaultCenter={{ lat: this.state.lat, lng: this.state.lng }}
                        center={{ lat: this.state.lat, lng: this.state.lng }}
                        defaultRadius={10000}
                        radius={this.state.radius}
                        visible={true}
                        editable={true}

                    />
                    <DrawingManager
                        onCircleComplete={(e) => { console.log("lat: " + e.center.lat() + ", long: " + e.center.lng() + ", radius: " + e.radius) }}
                        onMarkerComplete={(e) => { console.log("lat: " + e.position.lat() + ", long: " + e.position.lng()) }}
                    />
                </GoogleMap>
                <form onSubmit={(e) => { this.onSubmit(e) }}>
                    Latitude:
                    <input type="number" step="0.01" value={this.state.lat} onChange={(e)=>{this.setState({lat: parseFloat(e.target.value)})}}></input>
                    Longitude:
                    <input type="number" step="0.01" value={this.state.lng} onChange={(e)=>{this.setState({lng: parseFloat(e.target.value)})}}></input>
                    <br/>
                    Radius:
                    <input type="number" value={this.state.radius} onChange={(e)=>{this.setState({radius: parseFloat(e.target.value)})}}></input>

                    <input type="submit" value="Submit"></input>
                </form>

                <button onClick={this.undo} >Undo</button>
            </div>
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