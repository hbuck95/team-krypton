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

        console.log("/getPhoneNumber");
        console.log(response.data);
        console.log(response.data.phoneNumber);
        suspectCallRecordsBody.callerMSISDN = response.data.phoneNumber;

        return axios.post(API + "/getCallRecordsOfSuspect", suspectCallRecordsBody, { headers: HEADERS})

    }).then(response => {
        console.log("/getCallRecordsofSuspect");
        console.log("Body:" + suspectCallRecordsBody.callerMSISDN);
        console.log(response.data);

        return axios.post(API + "/getAssosiate", response.data, { headers: HEADERS })

    }).then(response => {
        console.log("/getAssosiate");
        console.log("Body:" + response.body);
        console.log(response.data);

        payload.associates = response.data;
        return res.status(200).json(payload).end();
    })

});







router.post('/test', auth.required, (req, res) => {

    //The payload object returned when all axios requests have been resolved
    const payload = {
        associates: null
    };

    const suspectCallRecordsBody = {
        callerMSISDN: null
    };

    return axios.post(API + "/getPhoneNumber", req.body, { headers: HEADERS })
    .then(response => {

        console.log("/getPhoneNumber");
        console.log(response.data);
        console.log(response.data.phoneNumber);
        suspectCallRecordsBody.callerMSISDN = response.data.phoneNumber;

        return axios.post(API + "/getAssociatesByCallRecord", response.data.phoneNumber, { headers: HEADERS})

    }).then(response => {
        console.log("/getAssociatesByCallRecord");
        console.log("Body:" + response.body);
        console.log(response.data);

        payload.associates = response.data;
        return res.status(200).json(payload).end();
    })

});

module.exports = router;