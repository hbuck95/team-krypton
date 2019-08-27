const jwt = require('jsonwebtoken');
const secrets = require('../config/secrets');

exports.getUser = function (req) {
    if (req.headers && req.headers.authorization) {
        const usertoken = req.headers.authorization;
        const token = usertoken.split(' ');
        const decoded = jwt.verify(token[1], secrets.phrase);
        console.log(decoded);
        console.log(decoded.username);
    }
};