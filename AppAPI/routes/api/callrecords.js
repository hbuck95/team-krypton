const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

//Headers used in each axios request
const HEADERS = {
  'Content-Type': 'application/json'
};

//URL to the transactions microservice
const API = "http://localhost:9004/call"