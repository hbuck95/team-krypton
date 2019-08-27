import React, { Component } from 'react';

import RouterClass from './components/RouterClass'
import Footer from './components/Footer'

import './css/Navbar.css'
import HELP_TEXT from './components/HelpText';





export default class App extends Component {

  constructor() {
    super();
    this.state = {
      searchData: {},
      link: '',
      redirect: false,

      loggedOut: true,
      loggingOut: false
    }
    localStorage.setItem('test', 'test');
    // sessionStorage.setItem('authKey', 'default');
  }
  searchData = (link) => {
    // console.log(data)
    this.setState({
      link: link,
      redirect: true
    }
      ,
      () => { console.log("redirecting..."); })
  }

  resetRedirect = () => {
    console.log("reset redirect");
    this.setState({
      redirect: false
    })
  }

  toggleLoggedOut = () => {
    this.setState({
      loggedOut: !this.state.loggedOut
    })
  }

  toggleLoggingOut = () => {
    this.setState({
      loggingOut: !this.state.loggingOut
    })
  }

  setHelpText = (page) => {
    let helpText = '';

    switch (page) {
      case 'login':
        helpText = HELP_TEXT.login
        break;
      case 'landing page':
        helpText = HELP_TEXT.landingPage;
        break;
      default:
        helpText = <p>Your details are shown on screen</p>
        break;
    }
    this.setState({
      helpText: helpText
    })
  }

  componentDidMount = () => {
    sessionStorage.setItem('authKey', 'authkey')
    if (!sessionStorage.getItem('authKey')) {
      this.setState({
        loggedOut: true
      })
    } else {
      this.setState({
        loggedOut: false
      })
    }

  }


  render() {
    return (
      <div>
        <RouterClass setHelpText={this.setHelpText}  loggedOut={this.state.loggedOut} toggleLoggingOut={this.toggleLoggingOut} toggleLoggedOut={this.toggleLoggedOut} redirect={this.state.redirect} resetRedirect={this.resetRedirect} link={this.state.link} passedFunction={this.searchData} searchData={this.state.searchData} />
        <Footer helpText={this.state.helpText}/>
      </div>
    );
  }
}

