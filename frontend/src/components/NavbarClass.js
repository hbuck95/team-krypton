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
            loginout: (sessionStorage.getItem('authKey') ? 'log out' : 'login'),
            loggingOut: (sessionStorage.getItem('loggingOut'))
        }


        this.selectedStyle = { backgroundColor: "#f26521" };

        this.logout = (e) => {
            e.preventDefault();
            if (!this.props.loggedOut) {
                sessionStorage.removeItem('authKey')
                
                this.props.toggleLoggedOut();
            }
        }

        


    }

    render() {
        if (this.props.loggingOut && !this.props.loggedOut){
            return (
                <Redirect push to='/login' />
            )
        }
        else {
            return (
                <div className="Selected" style={{ zIndex: "10" }}>
                    <Navbar color="dark" dark expand="md">
                        <NavbarBrand tag={Link} to="/home"><h2 style={{ color: "white" }}>Krypton</h2></NavbarBrand>
                        <Nav className="ml-auto" navbar>
                            {/* <NavItem>
                                <NavLink tag={Link} to="/help" style={{ fontSize: 25 }}>help</NavLink>
                            </NavItem> */}
                            <NavItem>
                                {!this.props.loggedOut && <NavLink style={{ fontSize: 25 }} tag={Link} to='/audits' >Audits</NavLink>}
                            </NavItem>
                            <NavItem>
                                <NavLink onClick={(e) => { this.logout(e) }} key={this.props.loggedOut} style={{ fontSize: 25 }}>{this.props.loggedOut ? 'Log in' : 'Log out'}</NavLink>
                            </NavItem>
                        </Nav>
                    </Navbar>
                </div>
            );
        }

    }
}