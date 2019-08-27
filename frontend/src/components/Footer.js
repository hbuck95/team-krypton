import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.css';
import '../css/Navbar.css';
import '../css/Footer.css'
import HELP_TEXT from './HelpText';
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChevronCircleUp, faChevronCircleDown } from "@fortawesome/free-solid-svg-icons";



export default class Footer extends Component {
    constructor() {
        super();

        this.state = {
            helpTextStyle: { visiblity: "hidden" },
            divHeight: "50px",
            poppedUp: false,
            visible: true
        }

        this.handleHover = (e) => {
            console.log("handle hover")
            e.target.style.backgroundColor = "#515761";
            e.target.style.height = "8%";
        }

        this.handleHoverLeave = (e) => {
            console.log("hover leave")
            e.target.style.backgroundColor = "#474c55";
            e.target.style.height = "5%";

            this.setState({
                helpTextStyle: { textAlign: "center", visiblity: "hidden" }
            })
        }

        this.handleClick = (e) => {
            console.log("handle click")
            this.toggle();
            if (this.state.toggle) {
                e.target.style.backgroundColor = "#515761";
                e.target.style.height = "70%";
            } else {
                e.target.style.backgroundColor = "#474c55";
                e.target.style.height = "5%";
            }

            this.setState({
                helpTextStyle: { textAlign: "center", visiblity: "visible" }
            })
        }

        this.toggleVisible = () => {
            if (this.state.visible) {
                this.setState({
                    visible: !this.state.visible,
                    divHeight: 0
                })
            }
            else {
                
                this.setState({
                    visible: !this.state.visible,
                    divHeight: 50
                })
            }

        }


    }

    render() {
        if (this.state.visible) {
            return (
                <div style={{ height: this.state.divHeight, visible: (this.state.visible ? 'visible' : 'hidden'), paddingTop: "1.2rem" }}>
                    <div className="window on">
                        {/* <input type="checkbox" className="closer"></input> */}
                        <FontAwesomeIcon icon={faChevronCircleDown} onClick={this.toggleVisible}  style={{ position: "fixed", bottom: 0, right: 0, margin: 25, width:25, marginBottom: 15, height: 25, color: "darkgray"}}/>
                        {/* <div onClick={this.toggleVisible} className="toggle" style={{ position: "fixed", bottom: 0, right: 0, margin: 25, backgroundColor: "red", color: "white", paddingLeft: 15, paddingRight: 15 }}>{' v '}</div> */}
                        <input type="checkbox" id="toggle" className="toggle" />
                        <label htmlFor="toggle"></label>
                        <div style={{ paddingRight: "75px", paddingLeft: "75px" }}>
                            {this.props.helpText}
                            <p style={{bottom: 0, left: 0}}>© Copyright: Team Krypton, 2019</p>
                        </div>
                    </div>
                </div>
            )
        }
        return (
            <div style={{ height: "50px", paddingTop: "1.2rem" }}>
                <FontAwesomeIcon onClick={this.toggleVisible} icon={faChevronCircleUp} style={{ position: "fixed", bottom: 0, right: 0, margin: 25, marginBottom: 0, width:25, height: 25, color: "#515761"}}/>
                {/* <div onClick={this.toggleVisible} className="toggle" style={{ position: "fixed", bottom: 0, right: 0, margin: 25, marginBottom: 0, backgroundColor: "red", color: "white", paddingLeft: 15, paddingRight: 15 }}>
                    {' ^ '}
                </div> */}
            </div>
        )
    }
}