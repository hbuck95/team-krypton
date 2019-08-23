import axios from "axios";

const HEADERS = {
    'Content-Type': 'application/json'
};

module.exports = axiosPost = (endpoint, body) => {
    return axios.post(endpoint, body, { headers: HEADERS} );
};