const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const session = require('express-session');
const cors = require('cors');
const mongoose = require('mongoose');
const errorHandler = require('errorhandler');
const secrets = require('./config/secrets');

//Configure mongoose's promise to global promise
mongoose.promise = global.Promise;

//Initiate our app
const app = express();

//Configure our app
app.use(cors());
app.use(require('morgan')('dev'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));
app.use(session({ secret: secrets.phrase, cookie: { maxAge: 60000 }, resave: false, saveUninitialized: false }));

//Configure Mongoose
const db = require("./config/keys").mongoURI;

mongoose
  .connect(db)
  .then(() => console.log("Connected to MongoDB"))
  .catch(err => console.log(err));

  require('./models/Users');
  require('./config/passport');
  app.use(require('./routes'));

const port = process.env.PORT || 9000;
app.listen(port, () => console.log(`server running on port ${port}`));