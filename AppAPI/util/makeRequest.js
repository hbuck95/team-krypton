import Axios from "axios";

const HEADERS = {
    'Content-Type': 'application/json'
};

module.exports = axiosPost = (endpoint, body) => {
    return Axios.post(endpoint, body, { headers: HEADERS} );
};