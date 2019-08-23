const router = require('express').Router();
const auth = require('../auth');
const makeRequest = require('../../util/makeRequest');

//URL to the transactions microservice
const API = "http://localhost:9005/ANPR"

//Endpoint URLs
const GET_VEHICLE_REGISTRATIONS = "/getVehicleRegistrations";
const GET_VEHICLE = "/getVehicle";

router.post("/getVehicle", auth.required, (req, res) => {

    const payload = {
        vehicle: null
    };

    makeRequest.axiosPost(API + GET_VEHICLE, req.body)
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

router.post("/getVehicleRegistrations", auth.required, (req, res) => {

    const payload = {
        vehicleRegistrations: null
    };

    makeRequest.axiosPost(API + GET_VEHICLE_REGISTRATIONS, req.body)
        .then(response => {
            payload.vehicleRegistrations = response.data;
        }).then(() => {
            res.status(200).json(payload).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
        });
});


module.exports = router;