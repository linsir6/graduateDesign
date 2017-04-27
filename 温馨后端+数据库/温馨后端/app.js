var koa = require('koa');
var controller = require('koa-route');
var app = koa();

var views = require('co-views');
var render = views('./view', {
    map: {html: 'ejs'}
});

var koa_static = require('koa-static-server');
var service = require('./service/Shopping.js');
var querystring = require('querystring');
app.use(koa_static({
    rootDir: './static/',
    rootPath: '/static/',
    maxage: 0
}));

app.use(controller.get('/register', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var user_name = params.user_name;
    var user_phone = params.user_phone;
    var pwd = params.pwd;
    this.body = yield service.register(user_name, user_phone, pwd);
}));

app.use(controller.get('/login', function*() {
    this.set('Cache-Control', 'no-cache');
    var params = querystring.parse(this.req._parsedUrl.query);
    var user_phone = params.user_phone;
    var pwd = params.pwd;
    this.body = yield service.login(user_phone, pwd);
}));

app.use(controller.get('/get_all_product', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.get_all_product();
}));


app.use(controller.get('/get_all_order', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.get_all_order();
}));

app.use(controller.get('/user_list', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var userId = params.userId;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.user_list(userId);
}));

app.use(controller.get('/get_sort_product', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var type = params.type;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.get_sort_product(type);
}));

app.use(controller.get('/get_car_product', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var id = params.id;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.get_car_product(id);
}));

app.use(controller.get('/save_in_car', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var name = params.name;
    var price = params.price;
    var type = params.type;
    var img = params.img;
    var details = params.details;
    var count = params.count;
    var userId = params.userId;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.save_in_car(name, price, type, img, details, count, userId);
}));

app.use(controller.get('/save_in_car', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var name = params.name;
    var price = params.price;
    var type = params.type;
    var img = params.img;
    var details = params.details;
    var count = params.count;
    var userId = params.userId;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.save_in_car(name, price, type, img, details, count, userId);
}));

app.use(controller.get('/pay', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var ids = params.ids;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.pay(ids);
}));

app.use(controller.get('/delete_shopping_car', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var ids = params.ids;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.delete_shopping_car(ids);
}));

app.use(controller.get('/order', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var userId = params.userId;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.order(userId);
}));

// 后台管理界面
app.use(controller.get('/add_shopping', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var name = params.name;
    var price = params.price;
    var type = params.type;
    var img = params.img;
    var details = params.details;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.add_shopping(name, price, type, img, details);
}));

app.use(controller.get('/change_shopping_list', function*() {
    var params = querystring.parse(this.req._parsedUrl.query);
    var id = params.id;
    var name = params.name;
    var price = params.price;
    var type = params.type;
    var img = params.img;
    var details = params.details;
    var id2 = params.id2;
    this.set('Cache-Control', 'no-cache');
    this.body = yield service.change_shopping_list(id, name, price, type, img, details, id2);
}));

app.use(controller.get('/index.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('index');
}));

app.use(controller.get('/login.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('login');
}));

app.use(controller.get('/show_shopping_list.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('show_shopping_list');
}));

app.use(controller.get('/add_shopping_list.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('add_shopping_list');
}));

app.use(controller.get('/change_shopping_List.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('change_shopping_List');
}));


app.use(controller.get('/order_List.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('order_List');
}));


app.use(controller.get('/user_List.html', function*() {
    this.set('Cache-Control', 'no-cache');
    this.body = yield render('user_List');
}));

app.listen(3000);
console.log('Koa server is started!');






























