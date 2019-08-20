const mongoose = require('mongoose');
const passport = require('passport');
const router = require('express').Router();
const auth = require('../auth');
const Users = mongoose.model('Users');
const axios = require('axios');

const HEADERS = {
  'Content-Type': 'application/json'
};

//POST new user route (optional, everyone has access)
router.post('/', auth.optional, (req, res, next) => {
  const { body: { user } } = req;

  if (!user.username) {
    return res.status(422).json({
      errors: {
        username: 'is required',
      },
    });
  }

  if (!user.password) {
    return res.status(422).json({
      errors: {
        password: 'is required',
      },
    });
  }

  const finalUser = new Users(user);

  finalUser.setPassword(user.password);

  return finalUser.save()
    .then(() => res.json({ user: finalUser.toAuthJSON() }));
});

//POST login route (optional, everyone has access)
router.post('/login', auth.optional, (req, res, next) => {
  const { body: { user } } = req;

  if (!user.username) {
    return res.status(422).json({
      errors: {
        username: 'is required',
      },
    }).send();
  }

  if (!user.password) {
    return res.status(422).json({
      errors: {
        password: 'is required',
      },
    }).send();
  }

  return passport.authenticate('local', { session: false }, (err, passportUser, info) => {
    if (err) {
      return next(err);
    }

    if (passportUser) {
      const token = passportUser.generateJWT();

      return res.json({ token: token });
    }

    return res.status(400).json({ info });
  })(req, res, next);
});

//GET current route (required, only authenticated users have access)
router.get('/current', auth.required, (req, res, next) => {
  const { payload: { id } } = req;

  return Users.findById(id)
    .then((user) => {
      if (!user) {
        return res.sendStatus(400);
      }

      return res.json({ user: user.toAuthJSON() });
    });
});

//POST get citizen data using forenames, surname, and address (authentication required)
router.post('/getCitizen', auth.required, (req, res) => {

  axios.post("http://localhost:9003/citizen/getCitizen", req.body, { headers: HEADERS })
    .then(response => {
      if (res.statusCode === 200) {
        console.log(response.data);
        return res.statusCode(200).json({ data: response.data }).send();
      } else {
        console.log(res.statusCode);
        console.log(response.data);
        return res.statusCode(400).json({ data: "Unable to find citizen" });
      }
    }).catch(err => {
        console.log(err);
        return res.statusCode(500).json({ error: err}).send();
    });

});


module.exports = router;