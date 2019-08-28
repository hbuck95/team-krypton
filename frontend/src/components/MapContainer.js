import React, { Component, Fragment } from 'react';
import { Row, Col } from 'reactstrap';
import axios from 'axios';
import { withScriptjs, withGoogleMap, Marker, Circle } from 'react-google-maps';
//import { DrawingManager } from 'react-google-maps/lib/components/drawing/DrawingManager';
import API_KEY from '../gmapsApiKey';
import IP from '../ipaddress';
const { GoogleMap } = require("react-google-maps");
const defaultLatLng = { lat: 52.3555, lng: -1.1743, radius: 5000 };


class Map extends Component {
    constructor(props) {
        super(props)

        this.state = {
            searchData: (sessionStorage.getItem('searchData') ? JSON.parse(sessionStorage.getItem('searchData')) : {}),
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
            console.log("begin undo")
            if ((this.state.lat !== this.state.prevLat.length - (this.state.undos + 1)) && (this.state.lng !== this.state.prevLng.length - (this.state.undos + 1))) {
                console.log(this.state.prevLat, this.state.lat, this.state.undos)
                this.setState({
                    lat: this.state.prevLat[this.state.prevLat.length - (this.state.undos + 1)],
                    lng: this.state.prevLng[this.state.prevLng.length - (this.state.undos + 1)],
                    undos: (this.state.undos + 1)
                });
            }
        }

        this.componentDidMount = () => {

            let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

            if(sessionStorage.getItem('scenario')=== '3'){
            axios.post(`${IP}/api/vehicle/getANPRCameras`, {
                "forenames": this.state.searchData.forenames,
                "surname": this.state.searchData.surname,
                "address": this.state.searchData.address
            },
            { headers: HEADERS })
            .then(res => {
                console.log("success", res)
                // this.setState({
                //     data: res.data.payload
                // })
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
                <GoogleMap
                    defaultZoom={this.state.defaultZoom}
                    defaultCenter={{ lat: this.state.viewLat, lng: this.state.viewLng }}
                    onClick={() => { this.setState({ editcircle: false }) }}
                    onDblClick={(e) => { console.log(e) }}
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
                }
                

                    <Marker
                        position={{ lat: this.state.lat, lng: this.state.lng }}
                        draggable={true}
                        onDragStart={(e) => {
                            console.log(this.state.prevLat, this.state.prevLng)
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
                        onRadiusChanged={(e) => console.log("radius change", e)}

                    />
                </GoogleMap>
                <form onSubmit={(e) => { this.onSubmit(e) }}>
                    <Row>
                        <span >Latitude:</span>
                        <input type="number" step="0.0001" value={this.state.newLat} onChange={(e) => { this.setState({ newLat: parseFloat(e.target.value) }) }}></input>
                    </Row>
                    <Row>
                        <span >Longitude:</span>
                        <input type="number" step="0.0001" value={this.state.newLng} onChange={(e) => { if (!NaN) { this.setState({ newLng: parseFloat(e.target.value) }) } }}></input>
                    </Row>
                    <Row>
                        <Col>
                            <span >Radius:</span>
                            <input type="number" value={this.state.radius} onChange={(e) => { this.setState({ radius: parseFloat(e.target.value) }) }}>
                            </input><span style={{ marginLeft: '-30px', color: 'grey' }}>m</span>
                        </Col>
                        <Col>
                            <input type="submit" value="Submit" style={{ marginLeft: 25 }}></input>
                        </Col>
                    </Row>
                    {/* <button style={{ marginLeft: 25 }} onClick={this.undo} >Undo</button> */}
                </form>

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