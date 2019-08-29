const router = require('express').Router();
const auth = require('../auth');
const makeRequest = require('../../util/makeRequest');

//URL to the transactions microservice
const API = "http://audit-consumer:9010/audits";

const GET_ALL = "/getAll";

router.get("/getAudits", auth.required, (req, res) => {

    const payload = {
        audits: null
    };

    makeRequest.createAudit("/getAudits", req.body, req.header("Authorization"));

    return makeRequest.axiosGet(API + GET_ALL)
        .then(response => {
            payload.audits = response.data;
            return res.status(200).json(payload).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        });

});

module.exports = router;