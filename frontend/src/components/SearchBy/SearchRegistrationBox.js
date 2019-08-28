import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Button, Input, Form, Row, Col, FormGroup, Label } from 'reactstrap'

export default class SearchRegistrationBox extends Component {
    constructor(props) {
        super(props)

        this.handleSubmit = (e) => {
            e.preventDefault();

            let searchData = {
                vehicleRegistrationNo: e.target[0].value
            }

            localStorage.setItem('searchData', JSON.stringify(searchData));
            console.log(searchData);

            props.passedFunction('vehicle');

        }

    }

    render() {
        return (
            <div className="searchBox">
                <h1 style={{ textAlign: 'center', marginBottom: "50px" }}>REGISTRATION</h1>

                <Form onSubmit={(e) => { this.handleSubmit(e) }}>
                    <Row form>
                        <Col>
                            <FormGroup>
                                <Label for="registration">Registration Number:</Label>
                                <Input type="text" maxLength="8" name="registration" id="registration" placeholder="AB12 XYZ" style={{ fontSize: "25px", textAlign: "center" }} />
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