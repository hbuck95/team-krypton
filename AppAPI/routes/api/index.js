const express = require('express');
const router = express.Router();

router.use('/users', require('./users'));
router.use('/citizen', require('./citizen'));
router.use('/transactions', require('./transactions'));
router.use('/callrecords', require('./callrecords'));
router.use('/vehicle', require('./vehicles'));

module.exports = router;