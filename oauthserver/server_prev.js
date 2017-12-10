require('angular2-universal-polyfills');
const compression = require('compression');
const express = require('express');
const enableProdMode = require('@angular/core').enableProdMode;
const createEngine = require('angular2-express-engine').createEngine;
const AppModule = require('./app/main').AppModule;

enableProdMode();

const app = express();
const ROOT = path.join(path.resolve(__dirname, '..'));
app.use(compression())

// Express View
app.engine('.html', createEngine({}));
app.set('views', __dirname);
app.set('view engine', 'html');

function ngApp(req, res) {
  res.render("index",{
    req: req,
    res: res,
    ngModule: AppModule,
    preboot: false,
    baseUrl: "/",
    requestUrl: req.originalUrl,
    originUrl: req.hostname
  });
}

// Serve static files
app.use(express.static(ROOT, {index: false}));

// send all requests to Angular Universal
// if you want Express to handle certain routes (ex. for an API) make sure you adjust this
app.get('/', ngApp);
app.get('/home', ngApp);
app.get('/about', ngApp);

module.exports = app;
