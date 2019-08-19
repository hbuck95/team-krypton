import React from 'react'

import { Button, Input, Form, Row, Col, FormGroup, Label, FormText } from 'reactstrap'

export default function SearchPerson() {
    return (
        <div style={{ boxShadow: "0px 5px 3px grey", backgroundColor: '#d8dcdb', maxWidth: '500px', minWidth: '400px', padding: "50px" }}>
            <h1 style={{ textAlign: 'center', marginBottom:"50px" }}>SEARCH</h1>

            <Form>
                <Row form>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="firstName">First name:</Label>
                            <Input type="text" name="email" id="firstName" placeholder="..." />
                        </FormGroup>
                    </Col>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="lastName">Last name:</Label>
                            <Input type="text" name="firstName" id="lastName" placeholder="..." />
                        </FormGroup>
                    </Col>
                </Row>
                <FormGroup check row style={{marginTop:"25px"}}>
                    <Col sm={{ size: 10, offset: 4 }}>
                        <Button>Search</Button>
                    </Col>
                </FormGroup>
            </Form>
        </div>
    )
}