const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

//Headers used in each axios request
const HEADERS = {
  'Content-Type': 'application/json'
};

//URL to the transactions microservice
const API = "http://localhost:9006/transactions"

// @route   POST api/transactions/getAccountAndCardHolder
// @desc    Get all a citizens bank account record and bank card information
// @body    {forename: "", surname: "", homeAddress: ""}
// @access  Authentication required via JSToken generated via /users/login
router.post('/getTransactionsForCitizen', auth.required, (req, res) => {

  //The payload object returned when all axios requests have been resolved
  const payload = {
    eposTransactions: null,
    atmTransactions: null
  };

  //Body sent with the /getBankCard axios request bellow
  //accountNumber is required to retrieve bank cards
  const bankCardBody = {
    accountNumber: null
  };

  //The bankCard object used in the body of the /getEposTransactions and /getAtmTransactions axios request.
  const bankCard = {
    bankCardNumber: null
  };

  // @route  POST http://localhost:9006/transactions/getAccountHolder
  // @desc   Get a citizens bank account record
  // @body   {forename: "", surname: "", homeAddress: ""}
  axios.post(API + "/getAccountHolder", req.body, { headers: HEADERS }).then(response => {

    //If the status code OK is not returned end the request early and return that the account holder cannot be found
    if (res.statusCode !== 200) {
      return res.status(400).json({ payload: "Unable to find Account Holder!" });
    }

    // Assign the accountNumber from the retrieved record to the bankCardBody object.
    bankCardBody.accountNumber = response.data.accountNumber

  }).then(() => {

    // @route  POST http://localhost:9006/transactions/getBankCard
    // @desc   Get a citizens bank card information
    // @body   {accountNumber: ""}
    axios.post(API + "/getBankCard", bankCardBody, { headers: HEADERS }).then(response => {

      //If the status code OK is not returned end the request early and return that the account holder cannot be found
      if (res.statusCode !== 200) {
        return res.status(400).json({ payload: "Unable to find Bank Card!" });
      }

      //Assign the retrieved bank card information to the bankCard object
      bankCard.bankCardNumber = response.data.cardNumber;

    }).then(() => {

      // @route  POST http://localhost:9006/transactions/getEposTransactions
      // @desc   Get all EPOS transactions for a bank card
      // @body   {bankCardNumber: ""}
      axios.post(API + "/getEposTransactions", bankCard, { headers: HEADERS }).then(response => {
        console.log(bankCard);

        //If the status code OK is not returned end the request early and return that the resource cannot be found
        if (res.statusCode !== 200) {
          console.log(res.statusCode + ": "+ res.statusMessage);
          return res.status(400).json({ payload: "Requested resources could not be found." });
        }

        //Assign the EPOS transaction record(s) to the payload object
        payload.eposTransactions = response.data;

      });
    }).then(() => {

      // @desc   Get all EPOS transactions for a bank card
      // @body   {bankCardNumber: ""}
      axios.post(API + "/getAtmTransactions", bankCard, { headers: HEADERS }).then(response => {

        console.log(bankCard);

        //If the status code OK is not returned end the request early and return that the resource cannot be found
        if (res.statusCode !== 200) {
          console.log(res.statusCode + ": "+ res.statusMessage);
          return res.status(400).json({ payload: "Requested resources could not be found." });
        }

        //Assign the retrieved bank card information to the payload object
        payload.atmTransactions = response.data;

      }).then(() => {
        //End the request chain by returning the payload object with a status code of OK.
        return res.status(200).json({ payload: payload });
      });
    });

    //Handle any errors thrown up throughout the promise chain
  }).catch(err => {
    console.log(err);
    return res.status(500).json({ error: err });
  });
});

module.exports = router;