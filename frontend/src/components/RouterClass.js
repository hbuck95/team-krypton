import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";

import Footer from './Footer'

import LoginPage from "./LoginPage"
import NavbarClass from './NavbarClass'
import LandingPage from './LandingPage'
import SearchLocationPage from './SearchBy/SearchLocationPage'
import SearchPersonResult from './SearchBy/Person/ResultsPage'
import RegistrationResultPage from './SearchBy/Registration/ResultsPage';
import ErrorBoundary from './ErrorBoundary';
import TeamKryptonPage from './TeamKryptonPage';

export default class RouterClass extends Component {

    render() {
        
        return (
            <Router>
                <NavbarClass loggedOut={this.props.loggedOut} toggleLoggedOut={this.props.toggleLoggedOut} toggleLoggingOut={this.props.toggleLoggingOut} />

                {
                    (this.props.redirect && <Redirect push to={{
                        pathname: `/search/${this.props.link}`
                    }} />)
                }

                {
                    (!sessionStorage.getItem('authKey') && <Redirect push to='/login' />)
                }
                <ErrorBoundary>
                    <Route exact path="/login" render={() => <LoginPage setHelpText={this.props.setHelpText} toggleLoggedOut={this.props.toggleLoggedOut} />} />
                </ErrorBoundary>
                <Route path="/search/map" render={() => <SearchLocationPage resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
                <Route path="/home" render={() => <LandingPage setHelpText={this.props.setHelpText} passedFunction={this.props.passedFunction} />} />
                <Route path="/search/result" render={() => <SearchPersonResult resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
                <Route path="/search/vehicle" render={() => <RegistrationResultPage resetRedirect={this.props.resetRedirect} searchData={this.props.searchData} />} />
                <Route path="/teamkrypton" component={TeamKryptonPage} />

                <Footer helpText={this.props.helpText}/>
            </Router>
        );
    }
}