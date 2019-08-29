import React, {Component} from 'react'


export default class LocationResultsPage extends Component {

    componentDidMount =() =>{
        sessionStorage.setItem('mapStyle', JSON.stringify({zIndex: 10, position: 'absolute', left: 1225, top: 95}))
    }
}