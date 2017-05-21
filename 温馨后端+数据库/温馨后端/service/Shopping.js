var fs = require('fs');
var mysql = require('mysql');

exports.register = function (user_name, user_phone, pwd) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'WenXin',
    });
    connection.connect();

    var promise = new Promise(function (resolve, reject) {

        var userSelectSql = "SELECT pwd FROM user WHERE user_phone='" + user_phone + "'";
        connection.query(userSelectSql, function (err, result) {
            if (result[0] != null) {
                resolve('101');
            }
        });
        var userAddSql = 'INSERT INTO user(user_name,user_phone,pwd) VALUES(?,?,?)';
        var userAddSql_Params = [user_name, user_phone, pwd];
        connection.query(userAddSql, userAddSql_Params, function (err, result) {
            if (err) {
                resolve('102');
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


exports.login = function (user_phone, pwd) {
    var connection = mysql.createConnection({
        host: '127.0.0.1',
        user: 'root',
        password: 'root',
        port: '3306',
        database: 'WenXin',
    });
    connection.connect();
    var promise = new Promise(function (resolve, reject) {
        var userSelectSql = "SELECT user_name FROM user WHERE user_phone='" + user_phone + "' AND pwd='" + pwd + "'";

        connection.query(userSelectSql, function (err, result) {
            if (result[0] != null) {
                resolve('100' + "," + result[0].user_name);
            }
            else {
                resolve('101');
            }
        });
    });

    return promise.then(function (value) {
        return value;

    }, function (value) {

    });
    return promise;
};


exports.get_all_product = function () {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        connection.query(
            "SELECT * FROM shopping",
            function selectCb(err, results) {
                if (results) {
                    console.log(results);
                    resolve(results);
                }
                if (err) {
                    console.log(err);
                }
                connection.end();
            }
        );

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};


exports.get_sort_product = function (type) {
    console.log(type);
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        connection.query(
            "SELECT * FROM shopping where type = '" + type + "'",
            function selectCb(err, results) {
                if (results) {
                    console.log(results);
                    resolve(results);
                }
                if (err) {
                    console.log(err);
                }
                connection.end();
            }
        );

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};


exports.get_car_product = function (id) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        connection.query(
            "SELECT * FROM shopping_car where userId = '" + id + "'",
            function selectCb(err, results) {
                if (results) {
                    console.log(results);
                    resolve(results);
                }
                if (err) {
                    console.log(err);
                }
                connection.end();
            }
        );

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};


exports.save_in_car = function (name, price, type, img, details, count, userId) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();

        var userAddSql = 'INSERT INTO shopping_car(name,price,type,img,details,count,userId) VALUES(?,?,?,?,?,?,?)';
        var userAddSql_Params = [name, price, type, img, details, count, userId];
        connection.query(userAddSql, userAddSql_Params, function (err, result) {
            if (err == null) {
                resolve('100')
            } else {
                resolve('101')
            }

        });

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};

exports.pay = function (ids) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        var id = ids.split(",");
        for (var i = 0; i < id.length - 1; i++) {
            var list = "INSERT INTO paid(number,name,price,type,img,details,count,userId) SELECT id,name,price,type,img,details,count,userId FROM shopping_car WHERE id = '" + id[i] + "'";
            connection.query(list, [id], function (err, result) {
                if (err == null) {
                    resolve('100')
                } else {
                    resolve('101')
                }

            });
            var pay = "DELETE FROM shopping_car WHERE id = '" + id[i] + "'";
            connection.query(pay, [id], function (err, result) {
                if (err == null) {
                    resolve('104')
                } else {
                    resolve('105')
                }

            });

        }
        for (var i = 0; i < id.length - 1; i++) {
            var date_o = new Date();
            var order_date = date_o.toLocaleString();
            var insert_date = 'UPDATE paid SET order_date = ? WHERE number = ?';
            var userModSql_Params = [order_date, id[i]];
            connection.query(insert_date, userModSql_Params, function (err, result) {
                if (err == null) {
                    resolve('102')
                } else {
                    console.log(err);
                    resolve('103')
                }

            });
        }
    });
    promise.then(function (value) {
        return value;
// success
    }, function (value) {
// failure
    });
    return promise;
};

exports.delete_shopping_car = function (ids) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        var id = ids.split(",");
        for (var i = 0; i < id.length - 1; i++) {
            var pay = "DELETE FROM shopping_car WHERE id = '" + id[i] + "'";
            connection.query(pay, [id], function (err, result) {
                if (err == null) {
                    resolve('100')
                } else {
                    resolve('101')
                }

            });
        }
    });
    promise.then(function (value) {
        return value;
// success
    }, function (value) {
// failure
    });
    return promise;
};

exports.order = function (userId) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        var pay = "SELECT * FROM paid WHERE userId = '" + userId + "'";
        connection.query(pay, function (err, result) {
            if (err == null) {
                resolve(result)
            } else {
                resolve('101')
            }

        });
    });
    promise.then(function (value) {
        return value;
// success
    }, function (value) {
// failure
    });
    return promise;
};

// 后台管理系统


exports.change_shopping_list = function (id, name, price, type, img, details, id2) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        var change_list = "UPDATE shopping SET name = ? ,price = ?,type = ?,img = ?,details = ? WHERE id = ? ";
        var data = [name, price, type, img, details, id];
        connection.query(change_list, data, function (err, result) {
            if (err == null) {
                resolve(result)
                console.log(result);
            } else {
                resolve('101')
            }

        });
        if (id2) {
            var delete_list = "DELETE FROM shopping WHERE id = '" + id2 + "'";
            connection.query(delete_list, function (err, result) {
                if (err) {
                    console.log(err);
                    console.log("删除失败");
                } else {
                    console.log("删除成功");
                }
            });
        }
        connection.end();
    });
    promise.then(function (value) {
        return value;
// success
    }, function (value) {
// failure
    });
    return promise;
};

exports.add_shopping = function (name, price, type, img, details) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        var add = 'INSERT INTO shopping(name,price,type,img,details) VALUES(?,?,?,?,?)';
        var add_Params = [name, price, type, img, details];
        connection.query(add, add_Params, function (err, result) {
            if (err == null) {
                resolve('100')
            } else {
                resolve('101')
            }

        });
    });
    promise.then(function (value) {
        return value;
// success
    }, function (value) {
// failure
    });
    return promise;
};


exports.get_all_order = function () {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        connection.query(
            "SELECT * FROM paid",
            function selectCb(err, results) {
                if (results) {
                    console.log(results);
                    resolve(results);
                }
                if (err) {
                    console.log(err);
                }
                connection.end();
            }
        );

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};


exports.user_list = function (userId) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        if (userId) {
            connection.query(
                "SELECT * FROM paid WHERE userId = '" + userId + "'",
                function selectCb(err, results) {
                    if (results) {
                        console.log(results);
                        resolve(results);
                    }
                    if (err) {
                        console.log(err);
                    }
                    connection.end();
                }
            );
        } else {
            connection.query(
                "SELECT * FROM paid",
                function selectCb(err, results) {
                    if (results) {
                        console.log(results);
                        resolve(results);
                    }
                    if (err) {
                        console.log(err);
                    }
                    connection.end();
                }
            );
        }

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};


exports.search_product = function (text) {
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();
        connection.query(
            "SELECT * FROM shopping WHERE name like '%" + text + "%'",
            function selectCb(err, results) {
                if (results) {
                    console.log(results);
                    resolve(results);
                }
                if (err) {
                    console.log(err);
                }
                connection.end();
            }
        );

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};


exports.count = function (id, count) {
    console.log(id);
    var promise = new Promise(function (resolve, reject) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            port: '3306',
            database: 'WenXin'
        });
        connection.connect();

        var sql = 'UPDATE shopping_car SET count = ? WHERE id = ?';
        var data = [count, id]
        connection.query(sql, data, function (err, result) {
            if (err) {
                console.log(err);
                return;
            }
            resolve("100");
            console.log("100");
        });

    });
    promise.then(function (value) {
        console.log(value);
        return value;
        // success
    }, function (value) {
        // failure
    });
    return promise;
};

