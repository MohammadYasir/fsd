require('zone.js/dist/zone-node');
//require('angular2-universal-polyfills');
const express = require('express');
const ngExpressEngine = require('@nguniversal/express-engine').ngExpressEngine;
const enableProdMode = require('@angular/core').enableProdMode;

//require(`./dist/polyfills.bundle`);
var {
    ServerAppModuleNgFactory,
    LAZY_MODULE_MAP
} = require(`./dist/main.bundle`);

enableProdMode();
const app = express();

app.engine(
    'html',
    ngExpressEngine({
        bootstrap: ServerAppModuleNgFactory,
        providers: []
    })
);

app.set('view engine', 'html');
app.set('views', __dirname);

app.use(express.static(__dirname + '/assets', { index: false }));
app.use(express.static(__dirname + '/public', { index: false }));

app.get('/*', (req, res) => {
    console.time(`GET: ${req.originalUrl}`);
    res.render('./public/index', {
        req: req,
        res: res
    });
    console.timeEnd(`GET: ${req.originalUrl}`);
});

module.exports = app;
