import React, { Component, Fragment } from 'react';
import { Row, Col } from 'reactstrap';
import axios from 'axios';
import { withScriptjs, withGoogleMap, Marker, Circle } from 'react-google-maps';
//import { DrawingManager } from 'react-google-maps/lib/components/drawing/DrawingManager';
import API_KEY from '../gmapsApiKey';
import IP from '../ipaddress';

import '../css/SearchBoxes.css'
const { GoogleMap } = require("react-google-maps");
const defaultLatLng = { lat: 52.3555, lng: -1.1743, radius: 5000 };


class Map extends Component {
    constructor(props) {
        super(props)

        this.state = {
            searchData: (localStorage.getItem('mapSearchData') ? JSON.parse(localStorage.getItem('mapSearchData')) : {}),
            lat: (localStorage.getItem('latSearch') ? parseFloat(localStorage.getItem('latSearch')) : defaultLatLng.lat),
            lng: (localStorage.getItem('lngSearch') ? parseFloat(localStorage.getItem('lngSearch')) : defaultLatLng.lng),
            radius: (localStorage.getItem('radiusSearch') ? parseFloat(localStorage.getItem('radiusSearch')) : defaultLatLng.radius),
            defaultZoom: (localStorage.getItem('latSearch') && localStorage.getItem('lngSearch') ? 12 : 6),
            newLat: (localStorage.getItem('latSearch') ? parseFloat(localStorage.getItem('latSearch')) : defaultLatLng.lat),
            newLng: (localStorage.getItem('lngSearch') ? parseFloat(localStorage.getItem('lngSearch')) : defaultLatLng.lng),
            prevLat: [(localStorage.getItem('latSearch') ? parseFloat(localStorage.getItem('latSearch')) : defaultLatLng.lat)],
            prevLng: [(localStorage.getItem('lngSearch') ? parseFloat(localStorage.getItem('lngSearch')) : defaultLatLng.lng)],
            undos: 0,
            changeView: false,
            viewLat: (localStorage.getItem('latSearch') ? parseFloat(localStorage.getItem('latSearch')) : defaultLatLng.lat),
            viewLng: (localStorage.getItem('lngSearch') ? parseFloat(localStorage.getItem('lngSearch')) : defaultLatLng.lng),
            editcircle: false,
            data: [
                {
                    id: 1,
                    name: "Park Slope",
                    latitude: "40.6710729",
                    longitude: "-73.9988001"
                },
                {
                    id: 2,
                    name: "Bushwick",
                    latitude: "40.6942861",
                    longitude: "-73.9389312"
                },
                {
                    id: 3,
                    name: "East New York",
                    latitude: "40.6577799",
                    longitude: "-73.9147716"
                }
            ]
        }


        this.onSubmit = (e) => {
            e.preventDefault();
            this.setState({
                lat: parseFloat(e.target[0].value),
                lng: parseFloat(e.target[1].value),
                radius: parseFloat(e.target[2].value)
            });
        }

        this.undo = () => {
            if ((this.state.lat !== this.state.prevLat.length - (this.state.undos + 1)) && (this.state.lng !== this.state.prevLng.length - (this.state.undos + 1))) {
                // console.log(this.state.prevLat, this.state.lat, this.state.undos)
                this.setState({
                    lat: this.state.prevLat[this.state.prevLat.length - (this.state.undos + 1)],
                    lng: this.state.prevLng[this.state.prevLng.length - (this.state.undos + 1)],
                    undos: (this.state.undos + 1)
                });
            }
        }

        this.componentDidMount = () => {

            let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

            if (sessionStorage.getItem('scenario') === '3' && sessionStorage.getItem('mapDataLoaded') !== 'true') {
                let splitaddress = this.state.searchData.address.split(', ')
                let address = {
                    street: splitaddress[0].replace(' ', '+'),
                    area: splitaddress[1].replace(' ', '+')
                }
                axios.post(`https://maps.googleapis.com/maps/api/geocode/json?address=${address.street},${address.area}&key=${API_KEY}`)
                    .then(res => {
                        // console.log("geocoder res: ", res)
                        
                            this.setState({
                                lat: res.data.results[0].geometry.location.lat,
                                lng: res.data.results[0].geometry.location.lng
                            })
                        
                    })
                    .catch(res => {
                        console.log("geocoder fail", res);
                    })
                axios.post(`${IP}/api/vehicle/getANPRCameras`,
                    this.state.searchData, { headers: HEADERS })
                    .then(res => {
                        // console.log("map data get success", res)
                        let tempArr = res.data.anpr.map(x => {
                            return {
                                latitude: x.latitude,
                                longitude: x.longitude,
                                viewLat: x.latitude,
                                viewLng: x.longitude
                            }
                        }, () => {sessionStorage.setItem('mapDataLoaded', 'true')})
                        // console.log(tempArr)


                        this.setState({
                            data: tempArr
                        })
                    })
                    .catch(res => {
                        console.log("error!", res)
                    })
            }
        }
    }


    render() {
        return (
            <div>
                <Row>
                    <Col>
                        <GoogleMap
                            defaultZoom={this.state.defaultZoom}
                            defaultCenter={{ lat: this.state.viewLat, lng: this.state.viewLng }}
                            onClick={() => { this.setState({ editcircle: false }) }}
                            // onDblClick={(e) => { console.log(e) }}
                        // onCenterChanged={ (e)=> this.getCenter(e)}
                        >
                            {(this.state.data !== []) && this.state.data.map(place => {
                                return (<Fragment key={place.id}>
                                    <Marker
                                        position={{
                                            lat: parseFloat(place.latitude),
                                            lng: parseFloat(place.longitude)
                                        }}
                                    />
                                </Fragment>)
                            })}



                            <Marker
                                position={{ lat: this.state.lat, lng: this.state.lng }}
                                draggable={true}
                                onDragStart={(e) => {
                                    // console.log(this.state.prevLat, this.state.prevLng)
                                    this.setState(state => {
                                        const prevLat = [...state.prevLat, parseFloat(e.latLng.lat())];
                                        const prevLng = [...state.prevLng, parseFloat(e.latLng.lng())];
                                        return {
                                            prevLat,
                                            prevLng
                                        };
                                    });
                                }}

                                onDrag={(e) => {

                                    this.setState({
                                        undos: 0,
                                        lat: parseFloat(Math.round(e.latLng.lat() * 10000) / 10000),
                                        lng: parseFloat(Math.round(e.latLng.lng() * 10000) / 10000),
                                        newLat: parseFloat(Math.round(e.latLng.lat() * 10000) / 10000),
                                        newLng: parseFloat(Math.round(e.latLng.lng() * 10000) / 10000)
                                    })
                                }}

                            />

                            <Circle
                                defaultCenter={{ lat: this.state.lat, lng: this.state.lng }}
                                center={{ lat: this.state.lat, lng: this.state.lng }}
                                defaultRadius={10000}
                                radius={this.state.radius}
                                visible={true}
                                editable={this.state.editcircle}
                                onDblClick={() => { this.setState({ editcircle: true }) }}
                                // onRadiusChanged={(e) => console.log("radius change", e)}

                            />
                        </GoogleMap>
                    </Col>
                </Row>
                <div className="searchBox" style={sessionStorage.getItem('mapStyle') ? JSON.parse(sessionStorage.getItem('mapStyle')) : { zIndex: 10, position: 'absolute', left: 1225, top: 95 }}>
                    <h5 style={{ textAlign: 'center' }}>Search Parameters</h5>
                    <br />
                    <form onSubmit={(e) => { this.onSubmit(e) }}>
                        <Row>
                            <Col>
                                <span >Latitude:</span>
                            </Col>
                            <Col>
                                <input type="number" step="0.0001" value={this.state.newLat} onChange={(e) => { this.setState({ newLat: parseFloat(e.target.value) }) }}></input>
                            </Col>
                        </Row>
                        <br />
                        <Row>
                            <Col>
                                <span >Longitude:</span>
                            </Col>
                            <Col>
                                <input type="number" step="0.0001" value={this.state.newLng} onChange={(e) => { if (!NaN) { this.setState({ newLng: parseFloat(e.target.value) }) } }}></input>
                            </Col>
                        </Row>
                        <br />
                        <Row>
                            <Col>
                                <span >Radius:</span>
                            </Col>
                            <Col>
                                <input type="number" value={this.state.radius} onChange={(e) => { this.setState({ radius: parseFloat(e.target.value) }) }}>
                                </input><span style={{ marginLeft: '-30px', color: 'grey' }}>m</span>
                            </Col>
                        </Row>
                        <br />
                        <Row>
                            <Col>
                                <input type="submit" value="Submit"></input>
                            </Col>
                        </Row>
                        {/* <button style={{ marginLeft: 25 }} onClick={this.undo} >Undo</button> */}
                    </form>
                </div>

            </div>
        )
    }
}


export default function WrappedMap(props) {
    const WrappedMap = withScriptjs(withGoogleMap(Map));

    return (
        <div style={{ ...props.style, width: props.width, height: props.height }}>
            <WrappedMap
                googleMapURL={`https://maps.googleapis.com/maps/api/js?key=${API_KEY}
                &v=3.exp&libraries=geometry,drawing,places`}
                loadingElement={<div style={{ height: "100%" }} />}
                containerElement={<div style={{ height: "100%" }} />}
                mapElement={<div style={{ height: "100%" }} prop="123" />}
            />

        </div>
    )
}