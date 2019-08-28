const jwt = require('jsonwebtoken');
const secrets = require('../config/secrets');

exports.decodeToken = function (authToken) {
    const token = authToken.split(' ');
    const decoded = jwt.verify(token[1], secrets.phrase);
    // console.log("Decoded token: ", decoded);
    return decoded;
};