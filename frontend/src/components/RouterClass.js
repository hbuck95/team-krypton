import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";

import LoginPage from "./LoginPage"
import NavbarClass from './NavbarClass'
import LandingPage from './LandingPage'
import SearchLocationPage from './SearchBy/SearchLocationPage'
import SearchPersonResult from './SearchBy/Person/ResultsPage'

export default class RouterClass extends Component {

    render() {
        if (!sessionStorage.getItem('authKey'))
            console.log("no auth key")
        return (
            <Router>
                <NavbarClass loggedOut={this.props.loggedOut} toggleLoggedOut={this.props.toggleLogOut} />

                {
                    (this.props.redirect && <Redirect push to={{
                        pathname: `/search/${this.props.link}`
                    }} />)
                }

                {
                    (!sessionStorage.getItem('authKey') && <Redirect push to='/login' />)
                }
                <Route exact path="/login" render={()=><LoginPage toggleLoggedOut={this.props.toggleLogOut/>} />
                <Route path="/search/map" render={() => <SearchLocationPage resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
                <Route path="/home" render={() => <LandingPage passedFunction={this.props.passedFunction} />} />
                <Route path="/search/result" render={() => <SearchPersonResult resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
            </Router>
        );
    }
}