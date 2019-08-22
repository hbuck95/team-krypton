const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

//Headers used in each axios request
const HEADERS = {
    'Content-Type': 'application/json'
};

//URL to the transactions microservice
const API = "http://localhost:9004/call"

const getPhoneNumber = (body) => {
    return axios.post(API + "/getPhoneNumber", body, { headers: HEADERS });
};

const getCallRecordsOfSuspect = (body) => {
    return axios.post(API + "/getCallRecordsOfSuspect", body, { headers: HEADERS })
};

const getAssociates = (body) => {
    return axios.post(API + "/getAssosiate", body, { headers: HEADERS })
};



router.post('/getAssociates', auth.required, (req, res) => {

    //The payload object returned when all axios requests have been resolved
    const payload = {
        associates: null
    };

    const suspectCallRecordsBody = {
        callerMSISDN: null
    };

    // @route  POST http://localhost:9004/call/getPhoneNumber
    // @desc   Get all EPOS transactions for a bank card
    // @body   {forename: "", surname: "", homeAddress: ""}
    // return axios.post(API + "/getPhoneNumber", req.body, { headers: HEADERS })
    getPhoneNumber(req.body)
        .then(response => {

            //Assign the phone number retrieved to the suspectcallrecordsbody object for the next axios request.
            suspectCallRecordsBody.callerMSISDN = response.data.phoneNumber;

            // @route  POST http://localhost:9004/call/getCallRecordsOfSuspect
            // @desc   Get all mobile call records where the retrieved phone number is the caller
            //return axios.post(API + "/getCallRecordsOfSuspect", suspectCallRecordsBody, { headers: HEADERS })
            getCallRecordsOfSuspect(suspectCallRecordsBody)
        }).then(response => {

            // @route  POST http://localhost:9004/call/getCallRecordsOfSuspect
            // @desc   Get all people mobile phone records where the supplied phone number is the receiver of the above calls
            //return axios.post(API + "/getAssosiate", response.data, { headers: HEADERS })
            getAssociates(response.data)
        }).then(response => {

            payload.associates = response.data;
            return res.status(200).json(payload).end();

        }).catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        })

});

module.exports = router;