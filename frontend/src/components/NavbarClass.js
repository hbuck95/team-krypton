import React, { Component } from 'react';
import { Link, Redirect } from "react-router-dom";
//import 'bootstrap/dist/css/bootstrap.css';
import {
    Navbar,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink
} from 'reactstrap'

import '../css/Navbar.css'
import '../App.css'

export default class NavbarClass extends Component {

    constructor(props) {
        super(props);

        this.state = {
            loginout: (sessionStorage.getItem('authKey') ? 'log out' : 'login')
        }

        this.selectedStyle = { backgroundColor: "#f26521" };

        this.logout = (e) => {
            e.preventDefault();
            console.log("logout clicked")
            if (sessionStorage.getItem('loggedOut') === false) {
                console.log("user is logged in trying to log out")
                sessionStorage.setItem('loggingOut', true);
                sessionStorage.removeItem('authKey')
            }
        }

        
    }

    render() {

        if (!sessionStorage.getItem('loggedOut') && sessionStorage.getItem('loggingOut')) {
            return (
                <Redirect push to='/login' />
            )
        }
        return (
            <div className="Selected" style={{ zIndex: "10" }}>
                <Navbar color="dark" dark expand="md">
                    <NavbarBrand tag={Link} to="/home"><h2 style={{ color: "white" }}>krypton</h2></NavbarBrand>
                    <Nav className="ml-auto" navbar>
                        <NavItem>
                            <NavLink tag={Link} to="/help" style={{ fontSize: 25 }}>help</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink onClick={(e) => { this.logout(e) }} style={{ fontSize: 25 }}>{sessionStorage.getItem('loggedOut') ? 'log in' : 'log out'}</NavLink>
                        </NavItem>
                    </Nav>
                </Navbar>
            </div>
        );

    }
}