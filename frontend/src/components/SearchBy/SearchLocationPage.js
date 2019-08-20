import React, { Component } from 'react'

import '../../css/SearchBoxes.css'


import MapContainer from '../MapContainer'
import MapTest from '../MapTest'

export default class SearchLocationPage extends Component {

    render() {
        return(
            <div>
                <MapContainer height="800px" width="1200px"/>
            </div>
        )
    }
}