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
      redirect: false
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



  render() {
    return (
      <div>
        <RouterClass redirect={this.state.redirect} resetRedirect={this.resetRedirect} link={this.state.link} passedFunction={this.searchData} searchData={this.state.searchData} />
        <Footer />
      </div>
    );
  }
}

