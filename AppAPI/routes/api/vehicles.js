const router = require('express').Router();
const auth = require('../auth');
const makeRequest = require('../../util/makeRequest');

//URL to the transactions microservice
const API = "http://anpr:9005/ANPR"

//Endpoint URLs
const GET_VEHICLE_REGISTRATIONS = "/getVehicleRegistrations";
const GET_VEHICLE = "/getVehicle";
const GET_ANPR_OBSERVATIONS = "/getANPRObservations";
const GET_ANPR_CAMERA = "/getANPRCamera";

router.post("/getVehicle", auth.required, (req, res) => {

    const payload = {
        vehicle: null
    };

    makeRequest.createAudit("/getVehicle", req.body, req.header("Authorization"));

    return makeRequest.axiosPost(API + GET_VEHICLE, req.body)
        .then(response => {
            payload.vehicle = response.data;
        })
        .then(() => {
            res.status(200).json(payload).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        });
});

router.post("/getAnprCameras", auth.required, (req, res) => {

    const payload = {
        anpr: null
    };

    let anprObservations = null;

    makeRequest.createAudit("/getAnprCameras", req.body, req.header("Authorization"));

    return makeRequest.axiosPost(API + GET_VEHICLE_REGISTRATIONS, req.body)
        .then(response => {
            return makeRequest.axiosPost(API + GET_ANPR_OBSERVATIONS, response.data)
        })
        .then(response => {
            anprObservations = response.data;
            return makeRequest.axiosPost(API + GET_ANPR_CAMERA, response.data)
        })
        .then(response => {
            let data = response.data;

            for(let i in anprObservations){
                data[i] = {timestamp: anprObservations[i].timeStamp, ...data[i]};
            }

            payload.anpr = data;
        })
        .then(() => {
            return res.status(200).json(payload).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        });
});

module.exports = router;