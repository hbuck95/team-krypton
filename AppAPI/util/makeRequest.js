const axios = require('axios');
const jwtDecode = require('./jwtDecode');

const HEADERS = {
    'Content-Type': 'application/json'
};

const AUDIT_API = "http://audit-producer:9002/"
const AUDIT_CREATE = "/create"

module.exports = {
    axiosPost: function (endpoint, body, authHeader, src) {
        console.log("Auth: ", authHeader);

        // if (authHeader) {
        //     console.log("Creating audit...");

        //     const audit = {
        //         username: jwtDecode.decodeToken(authHeader).username,
        //         searchUrl: src,
        //         searchCriteria: `${JSON.stringify(body)}`
        //     };

        //     console.log("Audit: ", audit);

        //     axios.post(AUDIT_API + AUDIT_CREATE, audit, { headers: HEADERS })
        //         .then(response => {
        //             console.log(response);
        //         }).catch(err => {
        //             console.log(err);
        //         })
        // }

        return axios.post(endpoint, body, { headers: HEADERS });
    },

    createAudit: function (src, body, authHeader) {

        if (!authHeader)
            return;

        const audit = {
            username: jwtDecode.decodeToken(authHeader).username,
            searchUrl: src,
            searchCriteria: `${JSON.stringify(body)}`
        };

        axios.post(AUDIT_API + AUDIT_CREATE, audit, { headers: HEADERS })
            .then(response => {
                if (response.status === 200) {
                    console.log("Audit created.");
                    return response.data;
                } else {
                    console.log("Expected response status of 200 (OK). Received ", response.status);
                    return "OK not received. Aborting audit entry.";
                }
            }).catch(err => {
                console.log(err);
                return "An error occurred whilst attempting to create your audit entry";
            })

    }
}