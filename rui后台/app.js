var koa = require('koa');
var controller = require('koa-route');
var app = koa();

var views = require('co-views');
var render = views('./view', {
    map: {html: 'ejs'}
});

var koa_static = require('koa-static-server');
var service = require('./service/carService.js');
var querystring = require('querystring');
app.use(koa_static({
    rootDir: './static/',
    rootPath: '/static/',
    maxage: 0
}));


app.use(controller.get('/register', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var phone = params.phone;
    var pwd = params.pwd;
    this.body = yield service.register(phone, pwd);
}));


app.use(controller.get('/login', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var phone = params.phone;
    var pwd = params.pwd;
    this.body = yield service.load(phone, pwd);
}));


app.use(controller.get('/login.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('login');
}));

app.use(controller.get('/washcar', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var userName = params.userName;
    var pwd = params.pwd;
    var contact = params.contact;
    var carinfo = params.carinfo;
    var date = params.date;
    var type = params.type;
    this.body = yield service.washcar(userName, pwd, contact, carinfo, date, type);
}));

app.use(controller.get('/car_beauty', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var userName = params.userName;
    var pwd = params.pwd;
    var contact = params.contact;
    var carinfo = params.carinfo;
    var date = params.date;
    var type = params.type;
    var location = params.location;
    this.body = yield service.car_beauty(userName, pwd, contact, carinfo, date, type, location);
}));

app.use(controller.get('/get_all_info_wash', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var id = params.id;
    this.body = yield service.get_all_info_wash(id);
}));

app.use(controller.get('/get_all_info_beauty', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var id = params.id;
    this.body = yield service.get_all_info_beauty(id);
}));

app.use(controller.get('/get_order_info_wash', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.get_order_info_wash();
}));

app.use(controller.get('/get_order_info_beauty', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.get_order_info_beauty();
}));

app.use(controller.get('/my_order_info_washcar', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var userName = params.userName;
    this.body = yield service.my_order_info_washcar(userName);
}));

app.use(controller.get('/evaluate', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var user_id = params.userName;
    var evaluate = params.evaluate;

    this.body = yield service.evaluate(user_id, evaluate);
}));


app.use(controller.get('/my_order_info_beauty', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var userName = params.userName;
    this.body = yield service.my_order_info_beauty(userName);
}));

app.use(controller.get('/finish_wash_car', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var id = params.id;
    this.body = yield service.finish_wash_car(id);
}));

app.use(controller.get('/finish_beauty', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var id = params.id;
    this.body = yield service.finish_beauty(id);
}));

app.use(controller.get('/check_version', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.check_version();
}));

app.use(controller.get('/user.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('user');
}));

app.use(controller.get('/index.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('index');
}));

app.use(controller.get('/order.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('order');
}));

app.use(controller.get('/order_form_all.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('order_form_all');
}));


app.use(controller.get('/order_form_some.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('order_form_some');
}));

app.use(controller.get('/user_wash.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('user_wash');
}));

app.use(controller.get('/user_beauty.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('user_beauty');
}));

app.use(controller.get('/bill.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('bill');
}));

app.use(controller.get('/earnest.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('earnest');
}));

app.listen(3007);
console.log('Koa server is started!');






























