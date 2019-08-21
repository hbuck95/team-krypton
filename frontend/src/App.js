import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

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

  }
  searchData = (data, link) => {
    console.log(data)
    this.setState({
      searchData: data,
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

