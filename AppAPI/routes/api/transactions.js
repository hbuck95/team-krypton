const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

const HEADERS = {
  'Content-Type': 'application/json'
};

const API = "http://localhost:9006/transactions"


//POST get citizen data using forenames, surname, and address (authentication required)
router.post('/getAccountHolder', auth.required, (req, res) => {

  axios.post(API + "/getAccountHolder", req.body, { headers: HEADERS })
    .then(response => {
      if (res.statusCode === 200) {
        console.log(response.data);
        return res.status(200).json({ payload: response.data });
      } else {
        console.log(res.statusCode);
        console.log(response.data);
        return res.status(400).json({ payload: "Unable to find Account Holder!" });
      }
    }).catch(err => {
        console.log(err);
        return res.status(500).json({ error: err});
    });

});

//POST get citizen data using forenames, surname, and address (authentication required)
router.post('/getBankCard', auth.required, (req, res) => {

  axios.post(API + "/getBankCard", req.body, { headers: HEADERS })
    .then(response => {
      if (res.statusCode === 200) {
        console.log(response.data);
        return res.status(200).json({ payload: response.data });
      } else {
        console.log(res.statusCode);
        console.log(response.data);
        return res.status(400).json({ payload: "Unable to find Bank Card!" });
      }
    }).catch(err => {
        console.log(err);
        return res.status(500).json({ error: err});
    });

});

//POST get citizen data using forenames, surname, and address (authentication required)
router.post('/getEposTransactions', auth.required, (req, res) => {

  axios.post(API + "/getEposTransactions", req.body, { headers: HEADERS })
    .then(response => {
      if (res.statusCode === 200) {
        console.log(response.data);
        return res.status(200).json({ payload: response.data });
      } else {
        console.log(res.statusCode);
        console.log(response.data);
        return res.status(400).json({ payload: "Unable to find EPOS Transaction for the supplied bank card number!" });
      }
    }).catch(err => {
        console.log(err);
        return res.status(500).json({ error: err});
    });

});

//POST get citizen data using forenames, surname, and address (authentication required)
router.post('/getAtmTransactions', auth.required, (req, res) => {

  axios.post(API + "/getAtmTransactions", req.body, { headers: HEADERS })
    .then(response => {
      if (res.statusCode === 200) {
        console.log(response.data);
        return res.status(200).json({ payload: response.data });
      } else {
        console.log(res.statusCode);
        console.log(response.data);
        return res.status(400).json({ payload: "Unable to find ATM Transaction for the supplied bank card number!" });
      }
    }).catch(err => {
        console.log(err);
        return res.status(500).json({ error: err});
    });

});

module.exports = router;