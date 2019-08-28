import React, { Component } from 'react'

import '../../css/SearchBoxes.css'

import { Button, Input, Form, Row, Col, FormGroup, Label, FormText } from 'reactstrap'
export default class SearchPersonBox extends Component {

    constructor(props) {
        super(props)

        this.state = {
            forenameError: null,
            surnameError: null,
            addressError: null
        }

        this.handleSubmit = (e) => {
            e.preventDefault();

            if (!e.target[0].value) {
                this.setState({
                    forenameError: 'Please enter all forenames'
                })
            } if (!e.target[1].value) {
                this.setState({
                    surnameError: 'Please enter a surname'
                })
            } if (!e.target[2].value) {
                this.setState({
                    addressError: 'Please enter an address'
                })
            } 
            if (e.target[0].value && e.target[1].value && e.target[2].value) { 
                let searchData = {
                    forenames: (e.target[0].value ? e.target[0].value : ''),
                    surname: (e.target[1].value ? e.target[1].value : ''),
                    homeAddress: (e.target[2].value ? e.target[2].value : '')
                }

                localStorage.setItem('searchData', JSON.stringify(searchData));

                props.passedFunction('result');

                this.setState({
                    forenameError: null,
                    surnameError: null,
                    addressError: null
                })
            }

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
                                <FormText>{this.state.forenameError}</FormText>
                            </FormGroup>
                        </Col>
                        <Col md={6}>
                            <FormGroup>
                                <Label for="lastName">Last name:</Label>
                                <Input type="text" name="lastName" id="lastName" placeholder="..." />
                                <FormText>{this.state.surnameError}</FormText>
                            </FormGroup>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <FormGroup>
                                <Label for="address">Address:</Label>
                                <Input type="text" name="address" id="address" placeholder="..." />
                                <FormText>{this.state.addressError}</FormText>
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