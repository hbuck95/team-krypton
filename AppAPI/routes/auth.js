const jwt = require('express-jwt');
const secrets = require('../config/secrets')
const webtoken = require('jsonwebtoken');  //https://npmjs.org/package/node-jsonwebtoken

const getTokenFromHeaders = (req) => {
  console.log("Token: ", req.headers.authorization);

  const usertoken = req.headers.authorization;
const token = usertoken.split(' ');
const decoded = webtoken.verify(token[1], secrets.phrase);
console.log(decoded);

  const { headers: { authorization } } = req;

  if(authorization && authorization.split(' ')[0] === 'Token') {
    return authorization.split(' ')[1];
  }
  return null;
};

const auth = {
  required: jwt({
    secret: secrets.phrase,
    userProperty: 'payload',
    getToken: getTokenFromHeaders,
  }),
  optional: jwt({
    secret: secrets.phrase,
    userProperty: 'payload',
    getToken: getTokenFromHeaders,
    credentialsRequired: false,
  }),
};

module.exports = auth;