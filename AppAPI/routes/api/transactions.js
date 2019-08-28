const router = require('express').Router();
const auth = require('../auth');
const makeRequest = require('../../util/makeRequest');

//URL to the transactions microservice
const API = "http://transactions:9006/transactions"

// @route  POST http://localhost:9006/transactions/getAtmLocation
// @desc   Get the location of EPOS transactions made
// @body   [{atmId: ""},{atmId: ""}]
const GET_ATM_LOCATION = "/getAtmLocation";

// @route  POST http://localhost:9006/transactions/getEposLocation
// @desc   Get the location of EPOS transactions made
// @body   [{id: ""},{id: ""}]
const GET_EPOS_LOCATION = "/getEposLocation";

// @route  POST http://localhost:9006/transactions/getAccountHolder
// @desc   Get a citizens bank account record
// @body   {forename: "", surname: "", homeAddress: ""}
const GET_ACCOUNT_HOLDER = "/getAccountHolder";

// @route  POST http://localhost:9006/transactions/getBankCard
// @desc   Get all ATM transactions for a bank card
// @body   {accountNumber: ""}
const GET_BANK_CARD = "/getBankCard";

// @route  POST http://localhost:9006/transactions/getAtmTransactions
// @desc   Get all ATM transactions for a bank card
// @body   {bankCardNumber: ""}
const GET_ATM_TRANSACTIONS = "/getAtmTransactions";

// @route  POST http://localhost:9006/transactions/getEposTransactions
// @desc   Get all EPOS transactions for a bank card
// @body   {bankCardNumber: ""}
const GET_EPOS_TRANSACTIONS = "/getEposTransactions";

// @route   POST api/transactions/getAtmLocation
// @desc    Get the location of ATMs based on a set of a atm transaction records
// @body    {eposTransactions: [{eposId: ""},{eposId: ""}], atmTransactions: [{atmId: ""}, {atmId: ""}]}
// @access  Authentication required via JSToken generated via /users/login
router.post('/getTransactionLocations', auth.required, (req, res) => {

  //The payload object returned when all axios requests have been resolved
  const payload = {
    eposLocations: null,
    atmLocations: null,
  };

  makeRequest.createAudit("/getTransactionLocations", req.body, req.header("Authorization"));

  return makeRequest.axiosPost(API + GET_ATM_LOCATION, req.body.atmTransactions)
    .then(response => {
      payload.atmLocations = response.data;
      return makeRequest.axiosPost(API + GET_EPOS_LOCATION, req.body.eposTransactions)
    })
    .then(response => {
      payload.eposLocations = response.data;
    })
    .then(() => {
      res.status(200).json(payload).end();
    })
    .catch(err => {
      console.log(err);
      return res.status(500).json({ message: "An error ocurred whilst processing your request.", error: err });
    });

});

// @route   POST api/transactions/getTransactionsForCitizen
// @desc    Get all a citizens bank account record and bank card information
// @body    {forename: "", surname: "", homeAddress: ""}
// @access  Authentication required via JSToken generated via /users/login
router.post('/getTransactionsForCitizen', auth.required, (req, res) => {

  //The payload object returned when all axios requests have been resolved
  const payload = {
    atm: {
      transactions: null,
      transactionLocations: null
    },
    epos: {
      transactions: null,
      transactionLocations: null
    }
  };

  //The object used in the body of the /getBankCard axios request.
  const bankCardBody = {
    accountNumber: null
  };

  //The object used in the body of the /getEposTransactions and /getAtmTransactions axios request.
  const transactionBody = {
    bankCardNumber: null
  };

  makeRequest.createAudit("/getTransactionsForCitizen", req.body, req.header("Authorization"));

  return makeRequest.axiosPost(API + GET_ACCOUNT_HOLDER, req.body)
    .then(response => {

      // Assign the accountNumber from the retrieved record to the bankCardBody object.
      bankCardBody.accountNumber = response.data.accountNumber

      return makeRequest.axiosPost(API + GET_BANK_CARD, bankCardBody)
    }).then(response => {

      //Assign the retrieved bank card information to the bankCard object
      transactionBody.bankCardNumber = response.data.cardNumber;

      return makeRequest.axiosPost(API + GET_EPOS_TRANSACTIONS, transactionBody)
    }).then(response => {

      //Assign the EPOS transaction record(s) to the payload object
      payload.epos.transactions = response.data;

      return makeRequest.axiosPost(API + GET_ATM_TRANSACTIONS, transactionBody)
    }).then(response => {

      //Assign the retrieved bank card information to the payload object
      payload.atm.transactions = response.data;

      return makeRequest.axiosPost(API + GET_ATM_LOCATION, payload.atm.transactions)
    }).then(response => {

      payload.atm.transactionLocations = response.data

      return makeRequest.axiosPost(API + GET_EPOS_LOCATION, payload.epos.transactions)
    }).then(response => {

      payload.epos.transactionLocations = response.data
    }).then(() => {

      //End the request chain by returning the payload object with a status code of OK.
      return res.status(200).json({ payload: payload }).end();
    }).catch(err => {

      console.log(err);
      return res.status(500).json({ error: err });
    })
});

module.exports = router;