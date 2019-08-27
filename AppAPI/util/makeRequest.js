const axios = require('axios');

const HEADERS = {
    'Content-Type': 'application/json'
};

module.exports = {
    axiosPost: function (endpoint, body, h) {
        console.log(h);
        return axios.post(endpoint, body, { headers: HEADERS });
    }
}