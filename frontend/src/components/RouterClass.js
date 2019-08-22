import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";

import LoginPage from "./LoginPage"
import NavbarClass from './NavbarClass'
import LandingPage from './LandingPage'
import SearchLocationPage from './SearchBy/SearchLocationPage'
import SearchPersonResult from './SearchBy/Person/SearchPersonResult'

export default class RouterClass extends Component {

    render() {
        if (!localStorage.getItem('authKey'))
            console.log("no auth key")

        return (
            <Router>
                <NavbarClass />

                {
                    (this.props.redirect && <Redirect push to={{
                        pathname: `/search/${this.props.link}`
                    }} />)
                }

                {
                    (localStorage.getItem('authKey') && <Redirect push to='/login' />)
                }
                <Route exact path="/login" component={LoginPage} />
                <Route path="/search/map" render={() => <SearchLocationPage resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
                <Route path="/home" render={() => <LandingPage passedFunction={this.props.passedFunction} />} />
                <Route path="/search/result" render={() => <SearchPersonResult resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
            </Router>
        );
    }
}