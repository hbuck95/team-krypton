import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Link } from 'react-router-dom'


import { Button, Input, Form, Row, Col, FormGroup, Label } from 'reactstrap'

export default class SearchLocationBox extends Component {
    render() {
        return (
            <div className="searchBox">
                <h1 style={{ textAlign: 'center', marginBottom: "50px" }}>LOCATION</h1>

                <Form onSubmit={(e) => { e.preventDefault() }}>
                    <Row form>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="latitude">Latitude:</Label>
                                <Input type="number" step="0.0001" name="latitude" id="latitude" placeholder="..." />
                            </FormGroup>
                        </Col>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="longitude">Longitude:</Label>
                                <Input type="number" step="0.0001" name="longitude" id="longitude" placeholder="..." />
                            </FormGroup>
                        </Col>
                    </Row>
                    <Row>
                        radius goes here
                    </Row>
                    <FormGroup check row style={{ marginTop: "25px" }}>
                        <Col sm={{ size: 10, offset: 4 }}>
                        <Link to="/search/map"><Button>Search</Button></Link>
                        </Col>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}