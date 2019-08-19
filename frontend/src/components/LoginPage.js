import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.css';
import {
    Form,
    FormGroup,
    Label,
    Col,
    Row,
    Input,
    Button,
    FormText
} from 'reactstrap'

import '../App.css'

export default class LoginPage extends Component {

    constructor() {
        super();

        this.state = {
            name: '',
            pass: '',
            warning: ''
        }

        this.handleSubmit = (e) => {
            e.preventDefault();



            let detailsToSend = {
                username: this.state.name,
                password: this.state.pass
            }
            e.target[0].value = '';
            e.target[1].value = '';

            console.log(detailsToSend);

            //then
            document.location.href = "/home"
            //catch
            e.target[0].value = this.state.name;
            this.setState({
                pass: '',
                warning: 'Incorrect password'
            });

        }


        this.handleNameChange = (e) => {
            this.setState({ name: e.target.value });
        }

        this.handlePassChange = (e) => {
            this.setState({ pass: e.target.value });
        }
    }


    render() {
        return (
            <div style={{ boxShadow: "0px 5px 3px grey", margin: 'auto', marginTop: "100px", backgroundColor: '#d8dcdb', width: '40%', maxWidth: '550px', minWidth: '400px', padding: "40px" }} className="rounded .align-center">
                <h2 style={{ textAlign: 'center', paddingBottom: "25px" }}>LOG IN:</h2>
                <Form onSubmit={this.handleSubmit}>
                    <Row form>
                        <Col>
                            <FormGroup>
                                <Label for="exampleEmail">Email</Label>
                                <Input value={this.state.name} id="exampleEmail" onChange={this.handleNameChange} placeholder="..." />
                            </FormGroup>
                        </Col>

                    </Row>
                    <FormGroup>
                        <Label for="password">Password</Label>
                        <Input type="password" name="password" value={this.state.pass} onChange={this.handlePassChange} id="password" placeholder="..." />
                        <FormText>{this.state.warning}</FormText>
                    </FormGroup>

                    <Button >Sign in</Button>
                </Form>


            </div >
        )
    }
}