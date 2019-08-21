const router = require('express').Router();
const auth = require('../auth');
const axios = require('axios');

const HEADERS = {
  'Content-Type': 'application/json'
};

//POST get citizen data using forenames, surname, and address (authentication required)
router.post('/getCitizen', auth.required, (req, res) => {

    axios.post("http://localhost:9003/citizen/getCitizen", req.body, { headers: HEADERS })
      .then(response => {
        if (res.statusCode === 200) {
          console.log(response.data);
          console.log(response);
          return res.status(200).json({ data: response.data });
        } else {
          console.log(res.statusCode);
          console.log(response.data);
          return res.status(400).json({ data: "Unable to find citizen" });
        }
      }).catch(err => {
          console.log(err);
          return res.status(500).json({ error: err});
      });
  
  });

  module.exports = router;