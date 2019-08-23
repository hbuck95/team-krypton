const axios = require('axios');

const HEADERS = {
    'Content-Type': 'application/json'
};

module.exports = {

    axiosPost: function (endpoint, body) {
        return axios.post(endpoint, body, { headers: HEADERS });
    }

}

