const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');
const _ = require('lodash');
const makeRequest = require('../../util/makeRequest');

//Headers used in each axios request
const HEADERS = {
    'Content-Type': 'application/json'
};

//URL to the transactions microservice
const API = "http://localhost:9004/call"

const GET_PHONE_NUMBER = "/getPhoneNumber";
const GET_CALL_RECORDS_OF_SUSPECT = "/getCallRecordsOfSuspect";
const GET_ASSOCIATES = "/getAssosiate";
const GET_CELL_TOWER = "/getCellTower";


// @route  POST http://localhost:9004/call/getPhoneNumber
// @desc   Get all EPOS transactions for a bank card
// @body   {forename: "", surname: "", homeAddress: ""}
// @return  axios.post(API + "/getPhoneNumber", req.body, { headers: HEADERS })
const getPhoneNumber = (body) => {
    return axios.post(API + "/getPhoneNumber", body, { headers: HEADERS });
};

// @route  POST http://localhost:9004/call/getCallRecordsOfSuspect
// @desc   Get all mobile call records where the retrieved phone number is the caller
const getCallRecordsOfSuspect = (body) => {
    return axios.post(API + "/getCallRecordsOfSuspect", body, { headers: HEADERS })
};

// @route  POST http://localhost:9004/call/getCallRecordsOfSuspect
// @desc   Get all people mobile phone records where the supplied phone number is the receiver of the above calls
const getAssociates = (body) => {
    return axios.post(API + "/getAssosiate", body, { headers: HEADERS })
};

// @route  POST http://localhost:9004/call/getCellTower
// @desc   Get the cell towers which routed the above calls.
const getCellTower = (body) => {
    return axios.post(API + "/getCellTower", body, { headers: HEADERS })
};



router.post('/getAssociates', auth.required, (req, res) => {

    //The payload object returned when all axios requests have been resolved
    const payload = {
        associates: null
    };

    const suspectCallRecordsBody = {
        callerMSISDN: null
    };

    makeRequest.axiosPost(API+GET_PHONE_NUMBER, req.body)
        .then(response => {
            //Assign the phone number retrieved to the suspectcallrecordsbody object for the next axios request.
            suspectCallRecordsBody.callerMSISDN = response.data.phoneNumber;
            return makeRequest.axiosPost(API + GET_CALL_RECORDS_OF_SUSPECT, suspectCallRecordsBody)
        }).then(response => {
            return makeRequest.axiosPost(API + GET_ASSOCIATES, response.data)
        }).then(response => {
            payload.associates = _.uniqWith(response.data, _.isEqual);
            return res.status(200).json(payload).end();
        }).catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        })
});

router.post("/getCellTowers", auth.required, (req, res) => {

    const payload = {
        callRecords: null,
        cellTowers: null
    };

    const suspectCallRecordsBody = {
        callerMSISDN: null
    };

    makeRequest.axiosPost(API + GET_PHONE_NUMBER, req.body)
        .then(response => {
            //Assign the phone number retrieved to the suspectcallrecordsbody object for the next axios request.
            suspectCallRecordsBody.callerMSISDN = response.data.phoneNumber;
            return makeRequest.axiosPost(API + GET_CALL_RECORDS_OF_SUSPECT, suspectCallRecordsBody)
        }).then(response => {
            payload.callRecords = response.data;
            return makeRequest.axiosPost(API + GET_CELL_TOWER, response.data)
        })
        .then(response => {
            payload.cellTowers = response.data;
        })
        .then(() => {
            res.status(200).json(payload).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err }).end();
        });

});

module.exports = router;