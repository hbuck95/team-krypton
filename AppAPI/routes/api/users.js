const mongoose = require('mongoose');
const passport = require('passport');
const router = require('express').Router();
const auth = require('../auth');
const Users = mongoose.model('Users');

//POST new user route (optional, everyone has access)
router.post('/register', auth.required, (req, res) => {
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

module.exports = router;