import React, { Component } from 'react'
import { Row, Col } from 'reactstrap'


import SearchPersonBox from './SearchBy/SearchPersonBox'
import SearchRegistrationBox from './SearchBy/SearchRegistrationBox'
import SearchLocationBox from './SearchBy/SearchLocationBox'

export default class LandingPage extends Component {
    

    render() {
        return (
            <div>
                <h1 style={{margin:"auto"}}>SEARCH BY...</h1>
                <div style={{ marginTop: "100px", width: "80%"}}>
                    <Row style={{marginLeft:0, marginRight:0}}>
                        <Col >
                            <SearchPersonBox passedFunction={this.props.passedFunction} />
                        </Col>
                        <Col>
                            <SearchLocationBox />
                        </Col>
                        <Col>
                            <SearchRegistrationBox />
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}