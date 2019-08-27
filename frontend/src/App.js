import React, { Component } from 'react';

import RouterClass from './components/RouterClass'
import Footer from './components/Footer'

import './css/Navbar.css'





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

  componentDidMount = () => {
    if(!sessionStorage.getItem('authKey')){
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
        <RouterClass loggedOut={this.state.loggedOut} toggleLoggingOut={this.toggleLoggingOut} toggleLoggedOut={this.toggleLoggedOut} redirect={this.state.redirect} resetRedirect={this.resetRedirect} link={this.state.link} passedFunction={this.searchData} searchData={this.state.searchData} />
        <Footer />
      </div>
    );
  }
}

