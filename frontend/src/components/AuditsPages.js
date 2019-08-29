import React, { Component } from 'react';
import ResultTableHorizontal from './SearchBy/ResultTableHorizontal';
import Axios from 'axios';

import IP from '../ipaddress'



export default class AuditsPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            data: []
        }
    }
    componentDidMount = () => {

        let HEADERS = { "Content-Type": "application/json", "Authorization": `Token ${sessionStorage.getItem('authKey')}` }

        Axios.get(`${IP}/api/audit/getAudits`, { headers: HEADERS })
            .then(res => {
                // console.log("audit", res);
                let temp = res.data.audits.map(x => {
                    if (x.searchCriteria === "{}") {
                        x.searchCriteria = 'none';
                    }
                    else {

                        let replaced = x.searchCriteria;//.replace(/{\{\}"}+/g, '');

                        while (replaced.includes('"')) {
                            replaced = replaced.replace('"', ' ');
                        }
                        replaced = replaced.replace('{', '');
                        replaced = replaced.replace('}', '');
                        x.searchCriteria = replaced;
                    }
                    x = { date: x.date, ...x }
                    return x;
                })

                // console.log("temp", temp)
                this.setState({
                    data: temp
                })
            })
            .catch()
    }

    render() {
        return (
            <div>
                <ResultTableHorizontal
                    data={this.state.data !== [] ? this.state.data : { noData: 'No Audit logs found' }}
                    headers={['Time Stamp', 'User', 'URL', 'Search Terms']} />
            </div>
        )
    }
}