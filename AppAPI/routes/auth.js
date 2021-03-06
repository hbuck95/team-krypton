const jwt = require('express-jwt');
const secrets = require('../config/secrets')
const webtoken = require('jsonwebtoken');  //https://npmjs.org/package/node-jsonwebtoken
const jwtDecode = require('../util/jwtDecode');

const getTokenFromHeaders = (req) => {
  console.log("Token: ", req.headers.authorization);
  
  const { headers: { authorization } } = req;

  if (authorization && authorization.split(' ')[0] === 'Token') {
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