/*
 Navicat Premium Data Transfer

 Source Server         : lin
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : trip

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 04/28/2017 08:55:40 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `call_back`
-- ----------------------------
DROP TABLE IF EXISTS `call_back`;
CREATE TABLE `call_back` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(100) NOT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
--  Records of `call_back`
-- ----------------------------
BEGIN;
INSERT INTO `call_back` VALUES ('1', '18646163197', 'lin', '啦啦啦', '2017-04-27 12:51:48'), ('2', '18888888888', '哈哈哈', '拉拉裤哈哈哈', '4/27/2017, 2:44:38 PM');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
