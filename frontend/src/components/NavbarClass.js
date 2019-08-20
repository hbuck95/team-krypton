import React, { Component } from 'react';
import { Link } from "react-router-dom";
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

    constructor() {
        super();

        this.state = {
            selected: 'login'
        }

        this.selectedStyle = { backgroundColor: "#f26521" };


    }

    render() {
        return (
            <div className="Selected" style={{zIndex:"10"}}>
                <Navbar color="dark" dark expand="md">
                    <Link to="home"><NavbarBrand><h2 style={{ color: "white" }}>krypton</h2></NavbarBrand></Link>
                    <Nav className="ml-auto" navbar>
                        <NavItem>
                            <NavLink tag={Link} to="/help" style={{fontSize:25}}>help</NavLink>
                        </NavItem>
                        <NavItem>
                           <Link to="login"><NavLink to="login" style={{fontSize:25}}>login</NavLink></Link>
                        </NavItem>
                    </Nav>
                </Navbar>
            </div>
        );

    }
}