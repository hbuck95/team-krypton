import React, {Component} from 'react';
import { BrowserRouter as Router, Route } from "react-router-dom";

import LoginPage from "./LoginPage"
import NavbarClass from './NavbarClass'
import MapContainer from './MapContainer'
import LandingPage from './LandingPage'

export default class RouterClass extends Component {

    render() {
        return(

            <Router>
                <NavbarClass />

                <Route exact path="/login" component={LoginPage} />
                <Route path="/searchlocation" component={MapContainer} />     
                <Route path="/home" component={LandingPage} /> 
            </Router>
        );
    }
}