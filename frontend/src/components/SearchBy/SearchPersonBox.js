import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Button, Input, Form, Row, Col, FormGroup, Label } from 'reactstrap'

import { Link } from 'react-router-dom'

export default class SearchPersonBox extends Component {

    constructor(props) {
        super(props)

        this.handleSubmit = (e) => {
            e.preventDefault();


            let searchData = {
                forenames: e.target[0].value,
                surname: e.target[1].value,
                homeAddress: e.target[2].value
            }

            localStorage.setItem('searchData', searchData);
            console.log(searchData);


            props.passedFunction(searchData, 'result');

        }

    }
    render() {
        return (
            <div className="searchBox">
                <h1 style={{ textAlign: 'center', marginBottom: "50px" }}>NAME</h1>

                <Form onSubmit={(e) => { this.handleSubmit(e) }}>
                    <Row form>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="forenames">Forenames:</Label>
                                <Input type="text" name="forenames" id="forenames" placeholder="..." />
                            </FormGroup>
                        </Col>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="lastName">Last name:</Label>
                                <Input type="text" name="lastName" id="lastName" placeholder="..." />
                            </FormGroup>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <FormGroup>
                                <Label for="address">Address:</Label>
                                <Input type="text" name="address" id="address" placeholder="..." />
                            </FormGroup>
                        </Col>
                    </Row>
                    <FormGroup check row style={{ marginTop: "25px" }}>
                        <Col sm={{ size: 10, offset: 4 }}>
                            {/* <Link to="/search/result"> */}
                                <Button>Search</Button>
                            {/* </Link> */}
                        </Col>
                    </FormGroup>
                </Form>
            </div>
        )
    }
}