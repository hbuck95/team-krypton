const express = require('express');
const router = express.Router();

//Routes
router.use('/users', require('./users'));
router.use('/citizen', require('./citizen'));
router.use('/transactions', require('./transactions'));
router.use('/callrecords', require('./callrecords'));
router.use('/vehicle', require('./vehicles'));
router.use('/audit', require('./audit'));

module.exports = router;