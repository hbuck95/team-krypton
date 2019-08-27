const axios = require('axios');

const HEADERS = {
    'Content-Type': 'application/json'
};

module.exports = {
    axiosPost: function (endpoint, body, auth) {
        console.log("Auth: ", auth);
        return axios.post(endpoint, body, { headers: HEADERS });
    }
}