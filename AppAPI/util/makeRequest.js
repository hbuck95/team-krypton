const axios = require('axios');
const jwtDecode = require('./jwtDecode');

const HEADERS = {
    'Content-Type': 'application/json'
};

const AUDIT_API = "http://localhost:9002/"
const AUDIT_CREATE = "/create"

module.exports = {
    axiosPost: function (endpoint, body, auth) {
        console.log("Auth: ", auth);

        if(auth){
            console.log("Creating audit...");

            const audit = {
                username: jwtDecode.decodeToken(auth).username,
                searchUrl: endpoint,
                searchCriteria: "\""+body+"\""
            };

            console.log("Audit: ", audit);

            axios.post(AUDIT_API + AUDIT_CREATE, audit, { headers: HEADERS})
            .then(response => {
                console.log(response);               
            }).catch(err => {
                console.log(err);
            })
        }

        return axios.post(endpoint, body, { headers: HEADERS });
    }
}