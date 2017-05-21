/*
 Navicat Premium Data Transfer

 Source Server         : lin
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : WenXin

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 05/21/2017 15:56:03 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `paid`
-- ----------------------------
DROP TABLE IF EXISTS `paid`;
CREATE TABLE `paid` (
  `number` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `details` varchar(45) DEFAULT NULL,
  `count` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=gbk;

-- ----------------------------
--  Records of `paid`
-- ----------------------------
BEGIN;
INSERT INTO `paid` VALUES ('10', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '1', '18646163197', '4/24/2017, 8:05:28 AM', '36', 'img51'), ('11', '乐视手机', '￥ 1088', 'Android', '乐视手机，64g,金色', '1', '18646163197', '4/24/2017, 8:06:17 AM', '37', 'img64'), ('13', 'macPro839', '￥ 8888', '笔记本电脑', '苹果笔记本，i5,8g,128ssd', '1', '18646163197', '4/24/2017, 2:53:10 PM', '38', 'img63'), ('14', '爱国者充电宝', '￥ 49', '充电宝', '爱国者充电宝，5000毫安，白色', '1', '18646163197', '4/24/2017, 3:15:11 PM', '39', 'img60'), ('17', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '4', '18646163197', '5/14/2017, 6:53:52 PM', '40', 'img51'), ('16', 'iPhone7', '￥ 5888', 'iPhone', 'iphone7 32g,黑色', '5', '18646163197', '5/14/2017, 3:51:23 PM', '41', 'img54'), ('17', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '3', '18646163197', '5/14/2017, 6:53:52 PM', '42', 'img51'), ('19', 'iPhone7', '￥ 5888', 'iPhone', 'iphone7 32g,黑色', '1', '18646163197', '5/14/2017, 6:55:43 PM', '43', 'img54'), ('20', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '3', '18646163197', '5/14/2017, 6:56:20 PM', '44', 'img55'), ('23', '小米充电宝', '￥ 88', '充电宝', '小米充电宝，5000毫安，黑色', '2', '18646163197', '5/14/2017, 6:56:38 PM', '45', 'img59'), ('24', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '1', '18646163197', '5/14/2017, 6:59:15 PM', '46', 'img55'), ('25', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '1', '18646163197', '5/14/2017, 7:00:14 PM', '47', 'img55'), ('26', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '1', '18646163197', '5/14/2017, 7:02:18 PM', '48', 'img55'), ('29', 'iPhone7', '￥ 5888', 'iPhone', 'iphone7 32g,黑色', '1', '18646163197', '5/14/2017, 7:06:18 PM', '49', 'img54'), ('27', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '1', '18646163197', '5/14/2017, 7:06:18 PM', '50', 'img51'), ('31', '罗马充电宝', '￥ 99', '充电宝', '罗马充电宝，10000毫安，白色', '1', '18646163197', '5/14/2017, 7:06:27 PM', '51', 'img58'), ('32', '爱国者充电宝', '￥ 49', '充电宝', '爱国者充电宝，5000毫安，白色', '2', '18646163197', '5/14/2017, 7:09:30 PM', '52', 'img60'), ('33', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '1', '18646163197', '5/14/2017, 7:09:30 PM', '53', 'img51'), ('30', 'iPhone7', '￥ 5888', 'iPhone', 'iphone7 32g,黑色', '2', '18646163197', '5/14/2017, 7:09:39 PM', '54', 'img54'), ('35', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '1', '18646163197', '5/14/2017, 7:10:20 PM', '55', 'img55'), ('38', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '2', '18646163197', '5/14/2017, 7:11:55 PM', '56', 'img51'), ('37', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '2', '18646163197', '5/14/2017, 7:12:01 PM', '57', 'img55'), ('42', 'iPhone6', '￥ 4888', 'iPhone', 'iphone6 32g,金色', '2', '18646163197', '5/14/2017, 7:25:18 PM', '58', 'img56'), ('41', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '2', '18646163197', '5/14/2017, 7:25:21 PM', '59', 'img55'), ('44', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '1', '18646163197', '5/14/2017, 7:26:46 PM', '60', 'img55'), ('43', 'iPhone7', '￥ 5888', 'iPhone', 'iphone7 32g,黑色', '1', '18646163197', '5/14/2017, 7:26:46 PM', '61', 'img54'), ('45', 'iPhone6s', '￥ 5288', 'iPhone', 'iphone6s 32g,粉色', '1', '18646163197', '5/14/2017, 7:27:01 PM', '62', 'img55'), ('47', '华为荣耀v8', '￥ 3999', 'Android', '华为荣耀 128g,白色', '1', '18646163197', '5/14/2017, 7:27:01 PM', '63', 'img51');
COMMIT;

-- ----------------------------
--  Table structure for `shopping`
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `shopping`
-- ----------------------------
BEGIN;
INSERT INTO `shopping` VALUES ('1', 'iPhone7', '5888', 'iPhone', 'img54', 'iphone7 32g,黑色'), ('2', 'iPhone6', '4888', 'iPhone', 'img56', 'iphone6 32g,金色'), ('3', 'iPhone6s', '5288', 'iPhone', 'img55', 'iphone6s 32g,粉色'), ('4', '华为荣耀v8', '3999', 'Android', 'img51', '华为荣耀 128g,白色'), ('5', '美图秀秀手机', '2999', 'Android', 'img52', '美图秀秀手机，白色'), ('6', '乐视手机', '1088', 'Android', 'img64', '乐视手机，64g,金色'), ('7', '罗马充电宝', '99', '充电宝', 'img58', '罗马充电宝，10000毫安，白色'), ('8', '小米充电宝', '88', '充电宝', 'img59', '小米充电宝，5000毫安，黑色'), ('9', '爱国者充电宝', '49', '充电宝', 'img60', '爱国者充电宝，5000毫安，白色'), ('10', '小米笔记本', '4999', '笔记本电脑', 'img61', '小米笔记本，i7,8g,128ssd'), ('11', 'macPro839', '8888', '笔记本电脑', 'img63', '苹果笔记本，i5,8g,128ssd'), ('12', '联想笔记本电脑', '5288', '笔记本电脑', 'img65', '联想笔记本电脑，i5,1t机械硬盘');
COMMIT;

-- ----------------------------
--  Table structure for `shopping_car`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `count` varchar(255) DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `shopping_car`
-- ----------------------------
BEGIN;
INSERT INTO `shopping_car` VALUES ('18', 'iPhone7', '￥ 5888', 'iPhone', 'img54', 'iphone7 32g,黑色', '1', 'null'), ('46', '乐视手机', '￥ 1088', 'Android', 'img64', '乐视手机，64g,金色', '1', '18646163197');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(45) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `user_phone` varchar(45) NOT NULL,
  PRIMARY KEY (`user_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('linsir', '123456', '18646163197'), ('88', '66', '44');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
