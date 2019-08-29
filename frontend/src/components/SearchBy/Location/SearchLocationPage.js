import React, { Component } from 'react'

import '../../../css/SearchBoxes.css'


import MapContainer from '../../MapContainer'

export default class SearchLocationPage extends Component {
    constructor(props) {
        super(props);

        this.componentDidMount = () => {

            props.resetRedirect();

            sessionStorage.removeItem('mapStyle');
            
        }
    }
    render() {
        return (
            <div>
                <MapContainer height="800px" width="1200px" />
            </div>
        )
    }
}