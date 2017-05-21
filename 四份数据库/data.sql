/*
 Navicat Premium Data Transfer

 Source Server         : lin
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : data

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 05/21/2017 15:55:45 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `app_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `name` varchar(45) NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `app_info`
-- ----------------------------
BEGIN;
INSERT INTO `app_info` VALUES ('version', '1.0.0');
COMMIT;

-- ----------------------------
--  Table structure for `car_beauty`
-- ----------------------------
DROP TABLE IF EXISTS `car_beauty`;
CREATE TABLE `car_beauty` (
  `phone` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `carinfo` varchar(45) DEFAULT NULL,
  `pre_date` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `situation` varchar(45) DEFAULT NULL,
  `pirce` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `shop` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `car_beauty`
-- ----------------------------
BEGIN;
INSERT INTO `car_beauty` VALUES ('18646163197', '18646163197', '白色，路虎揽胜', '2017-03-04 00:00', '', '0', '20', '2017-4-13 14:20:54', null, '黑龙江大学', '4'), ('18646163198', '18646163798', '灰色奔驰', '2017-05-01 00:00', '到店', '0', '20', '4/24/2017, 7:09:42 AM', null, '哈尔滨', '5'), ('13511112222', '18304213333', '锕红色 卡宴', '2017-05-01 02:00', '上门', '1', '10', '4/24/2017, 10:13:58 AM', null, '黑大', '6'), ('18646161111', '18646161111', '白色路虎', '2017-03-04 00:00', '上门', '1', '10', '5/17/2017, 2:52:24 PM', null, '黑龙江大学', '7'), ('18646655685', '18646655685', '白色凯美瑞', '2017-05-01 00:00', '上门', '1', '10', '5/18/2017, 9:43:47 PM', null, '黑大', '8'), ('18646655685', '18646655685', '黑色路虎', '2017-03-04 00:00', '上门', '0', '10', '5/19/2017, 7:03:31 AM', null, '黑大', '9'), ('18646655685', '12345678911', '黑色路虎', '2017-03-06 00:00', '上门', '0', '10', '5/19/2017, 8:40:09 AM', null, '黑大', '10'), ('18646655685', '18646655685', '白色路虎', '2017-05-01 00:00', '上门', '1', '10', '5/19/2017, 8:41:47 AM', null, '黑大', '11');
COMMIT;

-- ----------------------------
--  Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `evaluate` varchar(100) DEFAULT NULL,
  `time` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `evaluate`
-- ----------------------------
BEGIN;
INSERT INTO `evaluate` VALUES ('1', '18646163197', 'ww', '5/14/2017, 12:23:32 PM'), ('2', '18646163197', 'esss', '5/15/2017, 6:56:13 PM'), ('3', '18646163197', '啊啊啊', '5/15/2017, 6:59:12 PM'), ('4', '18646161111', '太棒惹', '5/17/2017, 2:53:37 PM'), ('5', '18646655685', '好棒了', '5/18/2017, 9:44:48 PM');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `phone` varchar(45) NOT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('13511112222', '111111'), ('13514681358', '123456'), ('18646161111', '123456'), ('18646163197', '123456'), ('18646163198', '123456'), ('18646655685', '123456');
COMMIT;

-- ----------------------------
--  Table structure for `washcar`
-- ----------------------------
DROP TABLE IF EXISTS `washcar`;
CREATE TABLE `washcar` (
  `phone` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `carinfo` varchar(45) DEFAULT NULL,
  `pre_date` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `situation` varchar(45) DEFAULT NULL,
  `pirce` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `shop` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `washcar`
-- ----------------------------
BEGIN;
INSERT INTO `washcar` VALUES ('18646163197', '18646163197', '白色，路虎揽胜', '2017-03-04 00:00', '快洗', '1', '10', '2017-4-13 14:21:52', null, '10'), ('18646163198', '18646163190', '白色陆虎', '2017-06-04 00:00', '标洗', '1', '30', '4/24/2017, 7:10:18 AM', null, '11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
