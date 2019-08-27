const router = require('express').Router();
const auth = require('../auth');
const makeRequest = require('../../util/makeRequest');

const API = "http://localhost:9003/citizen"

// @route  POST http://localhost:9003/citizen/getCitizen
// @desc   Get a citizen record based on their forenames, surname, and address
// @body   {"forenames":"Charlene Danielle", "surname":"Francis", "homeAddress":"34 KING CROSS ROAD, HALIFAX, HX1 3LN"}
const GET_CITIZEN = "/getCitizen";

router.post('/getCitizen', auth.required, (req, res) => {

    return makeRequest.createAudit("/getCitizen", req.body, req.header("Authorization"))
        .then(() => {
            return makeRequest.axiosPost(API + GET_CITIZEN, req.body)
        })
        .then(response => {
            return res.status(200).json({ payload: response.data }).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        });
});

module.exports = router;