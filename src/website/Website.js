// Dependencies
const express = require('express');
const app = express();
app.disable('x-powered-by');
const path = require('path');
const Logger = require('../utils/Logger');

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
	res.render('index');
});
app.get('/invite', (req, res) => {
	res.redirect('https://discordapp.com/oauth2/authorize?client_id=412014529099333642&scope=bot&permissions=0');
});
app.get('/discord', (req, res) => {
	res.redirect('https://discord.gg/3t6VXsJ');
});
app.get('/github', (req, res) => {
	res.redirect('https://github.com/ohlookitsAugust/Yui');
});
/*app.get('/commands', (req, res) => {
	res.render('commands');
});*/

app.use((req, res, next) => {
	const err = new Error('File or resource not found.');
	err.status = 404;
	next(err);
});

app.use((err, req, res, next) => {
	res.status(err.status || 500);
	res.render('error', {
		message: err.message,
		error: err
	});
});

app.set('port', process.env.PORT || 86);

const server = app.listen(app.get('port'), (err) => {
	if (err) Logger.error(`\n${err.stack}`);
	Logger.custom('Website', `https://yuibot.xyz :: Listening to port ${server.address().port}`);
});