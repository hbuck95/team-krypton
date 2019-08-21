const express = require('express');
const router = express.Router();

router.use('/users', require('./users'));
router.use('/citizen', require('./citizen'));

module.exports = router;