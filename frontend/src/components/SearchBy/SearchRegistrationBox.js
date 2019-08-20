import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Button, Input, Form, Row, Col, FormGroup, Label } from 'reactstrap'

export default class SearchRegistrationBox extends Component {


    render() {
        return (
            <div className="searchBox">
                <h1 style={{ textAlign: 'center', marginBottom: "50px" }}>REGISTRATION</h1>

                <Form onSubmit={(e) => { e.preventDefault() }}>
                    <Row form>
                        <Col>
                            <FormGroup>
                                <Label for="registration">Registration Number:</Label>
                                <Input type="text" name="registration" id="registration" placeholder="AB12 XYZ" style={{textAlign:"center"}}/>
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