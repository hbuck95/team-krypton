import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Button, Input, Form, Row, Col, FormGroup, Label } from 'reactstrap'

export default class SearchPersonBox extends Component {
    render() {
        return (
            <div className="searchBox">
                <h1 style={{ textAlign: 'center', marginBottom: "50px" }}>NAME</h1>

                <Form>
                    <Row form>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="firstName">First name:</Label>
                                <Input type="text" name="firstName" id="firstName" placeholder="..." />
                            </FormGroup>
                        </Col>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="lastName">Last name:</Label>
                                <Input type="text" name="lastName" id="lastName" placeholder="..." />
                            </FormGroup>
                        </Col>
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