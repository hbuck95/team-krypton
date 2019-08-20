import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.css';
import '../css/Navbar.css';
import '../css/Footer.css'


export default class Footer extends Component {
    constructor() {
        super();

        this.state = {
            helpTextStyle: { visiblity: "hidden" },
            poppedUp: false,

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

        
    }

    render() {

        return (
            <div style={{ height: "50px", paddingTop: "1.2rem" }}>
                <div className="window on">
                    <input type="checkbox" className="closer"></input>
                    <input type="checkbox" id="toggle" className="toggle" />
                    <label htmlFor="toggle"></label>
                    <div style={{paddingRight:"75px", paddingLeft:"75px"}}>
                    <p >Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis imperdiet tempus nibh vel venenatis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Proin sodales sem eu dolor facilisis commodo. Praesent iaculis massa et lorem tempus placerat ut sit amet nisl. Nullam non dignissim est. Aenean venenatis eros sed nibh condimentum, eget molestie nulla posuere. Ut eget lorem pretium, rhoncus dolor ac, hendrerit turpis. Fusce a condimentum est, pharetra sodales felis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sit amet sem interdum nulla congue pellentesque. Morbi bibendum sapien ut tortor maximus porttitor. Mauris congue, risus sit amet aliquam lobortis, ligula nisl porta odio, tincidunt faucibus ex ex eu dolor. Suspendisse id elementum quam. Morbi erat dolor, vestibulum eu pulvinar eget, finibus quis metus. Curabitur eu sollicitudin velit. Nam pharetra commodo magna, sed tempor lacus vestibulum a.</p>
                    <p>Cras vitae porttitor mauris. Nulla vel massa quis mauris consectetur pellentesque ut quis orci. Aenean sit amet sapien vel dui congue tristique quis tempus mi. In efficitur faucibus neque eu tempus. Cras vitae ipsum accumsan sapien lobortis volutpat ut et ipsum. Donec sed ipsum orci. Pellentesque id viverra tortor. Aliquam ultrices aliquet massa, nec sagittis ante. Donec eget lectus vehicula, blandit augue nec, tempus est. Etiam quis nunc pulvinar, feugiat felis in, suscipit lectus. Ut urna sapien, consectetur ut augue eu, dignissim ornare elit. Donec pulvinar sodales mi.</p>
                    </div>
                </div>
            </div>
        )
    }
}