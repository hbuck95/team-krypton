const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

const makeRequest = require('../../util/makeRequest');

const HEADERS = {
    'Content-Type': 'application/json'
};

//URL to the transactions microservice
const API = "http://localhost:9005/ANPR"

const GET_VEHICLE_REGISTRATIONS = "/getVehicleRegistrations";

const findVehicleRegistration = (body) => {
    return axios.post(API + "/getVehicleRegistrations", body, { headers: HEADERS });
};

const makeAxiosPost = (endpoint, body) => {
    return axios.post(API + endpoint, body, {headers: HEADERS});
};

router.post("/getVehicleRegistrations", auth.required, (req, res) => {

    const payload = {
        vehicleRegistration: null
    };

    //makeAxiosPost(GET_VEHICLE_REGISTRATIONS, req.body)
    makeRequest.axiosPost(API + GET_VEHICLE_REGISTRATIONS, req.body)
        .then(response => {
            payload.vehicleRegistration = response.data;
        })
        .then(() => {
            res.status(200).json(payload).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        });
});


module.exports = router;