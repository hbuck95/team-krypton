const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');
const makeRequest = require('../../util/makeRequest');

const HEADERS = {
    'Content-Type': 'application/json'
};

const API = "http://localhost:9003/citizen"
const GET_CITIZEN = "/gitCitizen";

router.post('/getCitizen', auth.required, (req, res) => {
    return makeRequest.axiosPost(API + GET_CITIZEN, req.body)
        .then(response => {
            return res.status(200).json({ payload: response.data }).end();
        })
        .catch(err => {
            console.log(err);
            return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });            
        });
});

//POST get citizen data using forenames, surname, and address (authentication required)
// router.post('/getCitizen', auth.required, (req, res) => {

//     axios.post("http://localhost:9003/citizen/getCitizen", req.body, { headers: HEADERS })
//         .then(response => {
//             if (res.statusCode === 200) {
//                 console.log(response.data);
//                 return res.status(200).json({ payload: response.data });
//             } else {
//                 console.log(res.statusCode);
//                 console.log(response.data);
//                 return res.status(400).json({ payload: "Unable to find citizen" });
//             }
//         }).catch(err => {
//             console.log(err);
//             return res.status(500).json({ error: err });
//         });

// });

module.exports = router;