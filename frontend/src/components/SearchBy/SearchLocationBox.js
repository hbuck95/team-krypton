import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Link } from 'react-router-dom'


import { Button, Input, Form, Row, Col, FormGroup, Label } from 'reactstrap'

export default class SearchLocationBox extends Component {

    constructor(props) {
        super(props);

        this.handleSubmit = (e) => {
            e.preventDefault();
            console.log("location search clicked!")

            if (e.target[0].value && e.target[1].value) {
                localStorage.setItem('latSearch', e.target[0].value);
                localStorage.setItem('lngSearch', e.target[1].value);
            } else{
                localStorage.setItem('latSearch', 53.4741);
                localStorage.setItem('lngSearch', -2.2866);
            }

            props.passedFunction('map');

        }
    }

    render() {
        return (
            <div className="searchBox">
                <h1 style={{ textAlign: 'center', marginBottom: "50px" }}>LOCATION</h1>

                <Form onSubmit={(e) => { this.handleSubmit(e) }}>
                    <Row form>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="latitude">Latitude:</Label>
                                <Input type="number" step="0.0001" name="latitude" id="latitude" placeholder="e.g. 53.4741" />
                            </FormGroup>
                        </Col>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="longitude">Longitude:</Label>
                                <Input type="number" step="0.0001" name="longitude" id="longitude" placeholder="e.g. -2.2866" />
                            </FormGroup>
                        </Col>
                    </Row>
                    <Row>
                        radius goes here
                    </Row>
                    <FormGroup check row style={{ marginTop: "25px" }}>
                        <Col sm={{ size: 10, offset: 4 }}>
                            <Button>Search</Button>
                        </Col>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}