const jwt = require('express-jwt');
const secrets = require('../config/secrets')

const getTokenFromHeaders = (req) => {
  console.log("Token: ", req.headers.authorization);
  var authorization = headers.authorization, decoded;
  decoded = jwt.verify(authorization, secret.secretToken);
  console.log("Decoded: ", decoded);

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