const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

//Headers used in each axios request
const HEADERS = {
    'Content-Type': 'application/json'
};

//URL to the transactions microservice
const API = "http://localhost:9004/call"

router.post('/getAssociates', auth.required, (req, res) => {

    //The payload object returned when all axios requests have been resolved
    const payload = {
        associates: null
    };

    const suspectCallRecordsBody = {
        callerMSISDN: null
    };

    return axios.post(API + "/getPhoneNumber", req.body, { headers: HEADERS })
    .then(response => {

        suspectCallRecordsBody.callerMSISDN = response.data.phoneNumber;

        return axios.post(API + "/getCallRecordsOfSuspect", suspectCallRecordsBody, { headers: HEADERS});

    }).then(response => {

        return axios.post(API + "/getAssosiate", response.data, { headers: HEADERS });

    }).then(response => {
        payload.associates = response.data;
        return res.status(200).json(payload).end();
    })

});