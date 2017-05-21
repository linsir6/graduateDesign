/**
 * Created on 2017/2/13.后台的服务类
 *
 */
var fs = require('fs');
var mysql = require('mysql');
exports.register = function (phone, pwd) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();

    var promise = new Promise(function (resolve, reject) {

        var userSelectSql = "SELECT pwd FROM user WHERE phone='" + phone + "'";
        connection.query(userSelectSql, function (err, result) {
            if (result[0] != null) {
                resolve('101');
            }
        });
        var userAddSql = 'INSERT INTO user(phone,pwd) VALUES(?,?)';
        var userAddSql_Params = [phone, pwd];
        connection.query(userAddSql, userAddSql_Params, function (err, result) {
            if (err) {

            } else {
                resolve('100');
            }
        });
    });

    return promise.then(function (value) {
        return value;
    }, function (value) {

    });
    return promise;
};


exports.load = function (phone, pwd) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    var promise = new Promise(function (resolve, reject) {
        var userSelectSql = "SELECT pwd FROM user WHERE phone='" + phone + "' AND pwd='" + pwd + "'";

        connection.query(userSelectSql, function (err, result) {
            if (result[0] != null) {
                resolve('100');
            }
            else {
                resolve('102');
            }
        });
    });

    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};


exports.washcar = function (userName, pwd, contact, carinfo, date, type) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    var pirce;
    if (type == "快洗") {
        pirce = "20";
    } else {
        if (type == "标洗")
            pirce = "30";
        else
            pirce = "40";
    }
    var date_o = new Date();
    var order_date = date_o.toLocaleString();
    var promise = new Promise(function (resolve, reject) {
        var userSelectSql = "SELECT pwd FROM user WHERE phone='" + userName + "' AND pwd='" + pwd + "'";

        connection.query(userSelectSql, function (err, result) {
            if (result[0] != null) {
                var userAddSql = 'INSERT INTO washcar(phone, contact, carinfo, pre_date, type , situation, pirce, order_date) VALUES(?,?,?,?,?,?,?,?)';
                var userAddSql_Params = [userName, contact, carinfo, date, type, '0', pirce, order_date];

                connection.query(userAddSql, userAddSql_Params, function (err, result) {
                    if (err) {

                        resolve(err);
                    } else {
                        resolve('100');
                    }
                });
            }
            else {
                resolve('103');
            }
        });

    });

    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

exports.car_beauty = function (userName, pwd, contact, carinfo, date, type, location) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    var pirce;
    if (type == "上门") {
        pirce = 10;
    } else {
        pirce = 20;
    }
    var date_o = new Date();
    var order_date = date_o.toLocaleString();
    var promise = new Promise(function (resolve, reject) {
        var userSelectSql = "SELECT pwd FROM user WHERE phone='" + userName + "' AND pwd='" + pwd + "'";

        connection.query(userSelectSql, function (err, result) {
            if (result[0] != null) {
                var userAddSql = 'INSERT INTO car_beauty(phone, contact, carinfo, pre_date, type , situation, pirce, order_date,location) VALUES(?,?,?,?,?,?,?,?,?)';
                var userAddSql_Params = [userName, contact, carinfo, date, type, '0', pirce, order_date, location];
                connection.query(userAddSql, userAddSql_Params, function (err, result) {
                    if (err) {
                        resolve(err);
                    } else {
                        resolve('100');
                    }
                });
            }
            else {
                resolve('103');
            }
        });

    });

    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

var all_info_wash;
var all_info_beauty;

exports.get_all_info_wash = function (id) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var wash_result;
    if (id == 3) {
        wash_result = "SELECT * FROM washcar";
    } else {
        wash_result = "SELECT * FROM washcar WHERE shop='" + id + "'";
    }
    var promise = new Promise(function (resolve, reject) {
        connection.query(wash_result, function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    all_info_wash = JSON.stringify(obj);
                    resolve(all_info_wash);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};


exports.get_all_info_beauty = function (id) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var beauty_result;
    if (id == 3) {
        beauty_result = "SELECT * FROM car_beauty";
    } else {
        beauty_result = "SELECT * FROM car_beauty WHERE shop='" + id + "'";
    }
    var promise = new Promise(function (resolve, reject) {
        connection.query(beauty_result, function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    all_info_beauty = JSON.stringify(obj);
                    resolve(all_info_beauty);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

var order_info_wash;
var order_info_beauty;

exports.get_order_info_wash = function () {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var promise = new Promise(function (resolve, reject) {
        connection.query(
            "SELECT * FROM washcar WHERE situation=0",
            function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    order_info_wash = JSON.stringify(obj);
                    resolve(order_info_wash);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};


exports.get_order_info_beauty = function () {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var promise = new Promise(function (resolve, reject) {
        connection.query(
            "SELECT * FROM car_beauty WHERE situation=0",
            function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    order_info_beauty = JSON.stringify(obj);
                    resolve(order_info_beauty);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};
var my_all_info_washcar;
var my_all_info_beauty;

exports.my_order_info_washcar = function (userName) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data'
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var beauty_result = "SELECT * FROM washcar WHERE phone='" + userName + "'";
    var promise = new Promise(function (resolve, reject) {
        connection.query(beauty_result, function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    my_all_info_washcar = JSON.stringify(obj);
                    resolve(my_all_info_washcar);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

exports.my_order_info_beauty = function (userName) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data'
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var beauty_result = "SELECT * FROM car_beauty WHERE phone='" + userName + "'";
    var promise = new Promise(function (resolve, reject) {
        connection.query(beauty_result, function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    my_all_info_beauty = JSON.stringify(obj);
                    resolve(my_all_info_beauty);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};


exports.finish_wash_car = function (id) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    var promise = new Promise(function (resolve, reject) {
        var userAddSql = "UPDATE washcar SET situation = '1' WHERE id = '" + id + "'";
        connection.query(userAddSql, function (err, result) {
            if (err) {
                resolve(err);
            } else {
                resolve('100');
            }
        });
    });

    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

exports.finish_beauty = function (id) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    var promise = new Promise(function (resolve, reject) {
        var userAddSql = "UPDATE car_beauty SET situation = '1' WHERE id = '" + id + "'";
        connection.query(userAddSql, function (err, result) {
            if (err) {
                resolve(err);
            } else {
                resolve('100');
            }
        });
    });

    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};


var version;

exports.check_version = function () {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    //创建连接
    var list = new Array();
    var promise = new Promise(function (resolve, reject) {
        connection.query(
            "SELECT content FROM app_info WHERE name='version'",
            function selectCb(err, results) {
                if (err) {

                    console.log(err);

                }
                else {
                    list = results;
                    var obj = {
                        "name": list
                    };
                    version = JSON.stringify(obj);
                    resolve(version);

                }
            }
        );
        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

// exports.check_version = function () {
//     var connection = mysql.createConnection({
//         host: '127.0.0.1',
//         user: 'root',
//         password: 'root',
//         port: '3306',
//         database: 'data',
//     });
//     connection.connect();
//     //创建连接
//     var list = new Array();
//     var promise = new Promise(function (resolve, reject) {
//         connection.query(
//             "SELECT content FROM app_info WHERE name='version'",
//             function selectCb(err, results) {
//                 if (err) {
//
//                     console.log(err);
//
//                 }
//                 else {
//                     list = results;
//                     var obj = {
//                         "name": list
//                     };
//                     version = JSON.stringify(obj);
//                     resolve(version);
//
//                 }
//             }
//         );
//         connection.end();
//     });
//     return promise.then(function (value) {
//         return value;
//
//     }, function (value) {
//
//     });
//     return promise;
// };


exports.evaluate = function (user_id,evaluate) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'data',
    });
    connection.connect();
    //创建连接
    var promise = new Promise(function (resolve, reject) {

        console.log(9999999);

        var date_o = new Date();
        var order_date = date_o.toLocaleString();

        var userAddSql = 'INSERT INTO evaluate(user_id,evaluate,time) VALUES(?,?,?)';
        var userAddSql_Params = [user_id, evaluate, order_date];
        connection.query(userAddSql, userAddSql_Params, function (err, result) {
            console.log("-----------" + err);
            console.log("-----------" + result);


            if (err) {
                console.log("aaaaaaaaaa222");
                resolve(err);
            } else {
                console.log("110000")

                resolve('100');
            }
        });

        connection.end();
    });
    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};

