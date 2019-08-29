import React, { Component } from 'react';

import { TabPane, Spinner, Table } from 'reactstrap'
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSignOutAlt } from "@fortawesome/free-solid-svg-icons";

import ResultTableHorizontal from '../ResultTableHorizontal'

library.add(faSignOutAlt);

export default class AssociatesTab extends Component {
    constructor(props) {
        super(props);
        this.state = {
            headers: ['Forenames', 'Surnames', 'Date of Birth', 'Home Address', 'Phone Number', 'Service Provider', 'More details']
        }

        this.moreDetail = (data) => {
            props.toggle('1');
            // console.log("toggle 1", data)
            // localStorage.setItem('searchData', JSON.stringify(data));
            props.changeSearchData(data);

        }
    }

    render() {
        if (this.props.dataLoaded) {
            return (
                <TabPane tabId='3'>
                    <h2>Associates</h2>
                    <Table hover bordered style={{ width: "95%", marginLeft: 50, marginTop: 50 }}>
                        <thead>
                            <tr>
                                {this.state.headers.map((header) =>
                                    <th key={header}>{header}</th>
                                )}
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.associatesData.map((data, i) => {
                                return <tr key={`data-${i}`}>
                                    {Object.values(data).map((value) =>
                                        <td key={`data-${value}`}>{(value ? value : 'null')}</td>
                                    )}
                                    <td><button onClick={() => this.moreDetail({forenames: data.forenames, surname: data.surname, homeAddress: data.address})}>More details</button></td>
                                </tr>
                            })
                            }
                        </tbody>
                    </Table>
                    {/* <ResultTableHorizontal passedStyle={{ width: "95%", marginLeft: 50, marginTop: 50 }}
                        data={this.props.associatesData ? [...this.props.associatesData, <FontAwesomeIcon icon={faSignOutAlt} onClick={this.moreDetail(this.props.associatesData)}/>] : {noData : 'No associates found'}}
                        headers={['Forenames', 'Surnames', 'Date of Birth', 'Home Address', 'Phone Number', 'Service Provider', 'More details']}
                    /> */}
                </TabPane>
            )
        }
        if (this.props.error === '500') {
            return (
                <TabPane tabId='3'>
                    <h1>uh oh</h1>
                </TabPane>
            )
        }

        return (
            <TabPane tabId='3' >
                <Spinner style={{ width: '5rem', height: '5rem', position: 'fixed', top: '47.5%', left: '47.5%' }} />
            </TabPane>
        )
    }
}