import React, {Component} from 'react';
import { BrowserRouter as Router, Route } from "react-router-dom";

import LoginPage from "./LoginPage"
import NavbarClass from './NavbarClass'
import LandingPage from './LandingPage'
import SearchLocationPage from './SearchBy/SearchLocationPage'

export default class RouterClass extends Component {

    render() {
        return(
            <Router>
                <NavbarClass />

                <Route exact path="/login" component={LoginPage} />
                <Route path="/search/map" component={SearchLocationPage} />     
                <Route path="/home" component={LandingPage} /> 
            </Router>
        );
    }
}