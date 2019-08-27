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
    FormText,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter
} from 'reactstrap'

import { Redirect } from 'react-router-dom'

import '../App.css'
import axios from 'axios';
import {Link} from 'react-router-dom'

const HEADERS = { "Content-Type": "application/json" }

export default class LoginPage extends Component {

    constructor() {
        super();

        this.state = {
            name: '',
            pass: '',
            warning: '',
            loginSuccess: false,
            modal: false
        }

        this.componentDidMount=()=>{
            this.props.setHelpText('login');
        }

        this.handleSubmit = (e) => {
            e.preventDefault();

            let detailsToSend = {
                username: this.state.name,
                password: this.state.pass
            }
            
            axios.post('http://35.197.200.12:9000/api/users/login', { user: detailsToSend }, { headers: HEADERS })
                .then((res) => {
                    console.log(res);
                    sessionStorage.setItem('authKey', res.data.token)
                    this.setState({
                        loginSuccess: true
                    },
                    () => {this.props.toggleLoggedOut()})
                })
                .catch((res) => {
                    console.log("error: ", res)

                    sessionStorage.removeItem('authKey');
                    this.setState({
                        pass: '',
                        warning: (res === 'Error: Invalid Credentials' ? 'Incorrect user name or password...' : 'Could not connect to login services...')
                    });
                })

        }


        this.handleNameChange = (e) => {
            this.setState({ name: e.target.value });
        }

        this.handlePassChange = (e) => {
            this.setState({ pass: e.target.value });
        }

        this.toggleModal = () =>{
            this.setState(prevState => ({
                modal: !prevState.modal
            }));
        }
    }


    render() {
        
        sessionStorage.setItem('loggedOut', 'loggedOut')
        sessionStorage.setItem('loggingOut', false);
        if (this.state.loginSuccess) {
            console.log("auth key accepted!")
            return (<Redirect
                push to='/home'
            />)
        }

        return (
            <div style={{ boxShadow: "0px 5px 3px grey", margin: 'auto', marginTop: "100px", backgroundColor: '#d8dcdb', width: '40%', maxWidth: '550px', minWidth: '400px', padding: "40px" }} className="rounded .align-center">
                <h2 style={{ textAlign: 'center', paddingBottom: "25px" }}>LOG IN</h2>
                <Form onSubmit={this.handleSubmit}>
                    <Row form>
                        <Col>
                            <FormGroup>
                                <Label for="username">Username</Label>
                                <Input value={this.state.name} id="username" onChange={this.handleNameChange} placeholder="..." />
                            </FormGroup>
                        </Col>

                    </Row>
                    <FormGroup>
                        <Label for="password">Password</Label>
                        <Input type="password" name="password" value={this.state.pass} onChange={this.handlePassChange} id="password" placeholder="..." />
                        <FormText onClick={this.toggleModal} style={{textAlign:"right"}}>Forgotten password?</FormText>
                        <FormText>{this.state.warning}</FormText>
                    </FormGroup>

                    <Button >Sign in</Button>
                </Form>
                <Modal isOpen={this.state.modal} toggle={this.toggleModal}>
                    <ModalHeader toggle={this.toggleModal}>Forgotten Password</ModalHeader>
                    <ModalBody style={{padding:25}}>
                        Please contact your supervisor to retrieve your password.
                    </ModalBody>
                </Modal>

            </div >
        )
    }
}