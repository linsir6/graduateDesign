/*
 Navicat Premium Data Transfer

 Source Server         : lin
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : cloth

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 05/21/2017 15:55:39 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `unumber` varchar(45) COLLATE utf8_bin NOT NULL,
  `upwd` varchar(45) COLLATE utf8_bin NOT NULL,
  `buyer_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`unumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `User`
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES ('18646163197', '123456', 'lin'), ('18689572395', '111111', 'aaa'), ('18745069763', '123456', 'yu');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
--  Records of `call_back`
-- ----------------------------
BEGIN;
INSERT INTO `call_back` VALUES ('1', '18646163197', 'lin', 'Ppp', '2017-05-10 23:59:40'), ('2', '18646163197', 'lin', 'Uhfsxg', '2017-05-10 23:59:53'), ('3', '18646163197', 'lin', 'adqfwve', '2017-05-14 14:56:49');
COMMIT;

-- ----------------------------
--  Table structure for `cloth_list`
-- ----------------------------
DROP TABLE IF EXISTS `cloth_list`;
CREATE TABLE `cloth_list` (
  `number` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `items` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `price` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `color` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `describe` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `picture` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shoucang` varchar(10000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `cloth_list`
-- ----------------------------
BEGIN;
INSERT INTO `cloth_list` VALUES ('1', '鞋', '人气潮鞋女鞋', '199', '白色', '时尚 百搭 人气', '/images/1.jpg', '1', null), ('2', '上衣', '初冬新款 夹克衫', '67', '黑色/褐色/灰色', '良品 新款 时尚', '/images/2.jpg', '2', '18646163197;'), ('3', '裤子', '裤子男 学生', '122', '黑色', '学生 春季 百搭', '/images/3.jpg', '3', '18646163197;'), ('4', '上衣', '春季韩版学生百搭宽松外套', '209', '橄榄绿/枣红/黑色', '宽松 外套 时尚', '/images/4.jpg', '4', '18646163197;'), ('5', '鞋', '帆布鞋男韩版运动鞋小白鞋', '67', '蓝色/黑白', '运动 帆布 男士', '/images/5.jpg', '5', '18646163197;'), ('6', '上衣', '男士 运动装', '90', '蓝色/灰色', '男士 运动 时尚', '/images/6.jpg', '6', '18646163197;'), ('7', '上衣', '修身韩版休闲帅气男春装', '110', '藏青/浅灰', '休闲 男士 韩版', '/images/7.jpg', '7', '18646163197;'), ('8', '上衣', '少女短袖韩版宽松打底衫', '99', '浅粉/墨绿', '少女 短袖 宽松', '/images/8.jpg', '8', '18646163133;'), ('9', '上衣', '春季新款女时尚套装', '100', '灰色/黑色', '新款 学生 女士', '/images/9.jpg', '9', null), ('10', '上衣', '打底衫春秋新款 女', '134', '黄色', '少女 短袖 宽松', '/images/10.jpg', '10', null), ('11', '上衣', '男士青年百搭黑色', '211', '黑色/灰色', '少女 短袖 宽松', '/images/11.jpg', '11', null), ('12', '裤子', '韩版 男士 春季 健身裤', '112', '蓝色/黑色', '少女 短袖 宽松', '/images/12.jpg', '12', null), ('13', '裤子', '男士休闲裤 百搭', '89', '蓝色/浅灰', '少女 短袖 宽松', '/images/13.jpg', '13', null), ('14', '裤子', '韩版 女裤子 显瘦 韩版', '90', '灰色', '少女 短袖 宽松', '/images/14.jpg', '14', ''), ('15', '裤子', '宽松 女裤子', '99', '黑色', '少女 短袖 宽松', '/images/15.jpg', '15', null), ('16', '鞋', '男士透气鞋人气潮鞋', '119', '灰色/白色/黑白', '休闲 男士 韩版', '/images/16.jpg', '16', null), ('17', '鞋', '夏季男鞋百搭小白鞋', '129', '白色/黑色', '休闲 男士 韩版', '/images/17.jpg', '17', null), ('18', '鞋', '花花公子运动鞋 ', '229', '蓝色/黑色', '休闲 男士 韩版', '/images/18.jpg', '18', null), ('19', '上衣', '时尚打底衫女春秋', '124', '白色/浅黄', '学生 春季 百搭', '/images/19.jpg', '19', '18646163197;'), ('20', '上衣', '圆领穿棉打底衫', '220', '灰色/白色/黑色', '学生 春季 百搭', '/images/20.jpg', '20', ''), ('21', '上衣', '时尚套装女春装韩版', '190', '背带/普通', '学生 春季 百搭', '/images/21.jpg', '21', null), ('22', '鞋', '人气潮鞋韩版百搭女', '89', '黑色/卡其色/灰色', '学生 春季 百搭', '/images/22.jpg', '22', null), ('23', '鞋', '运动鞋白色', '120', '白色', '学生 春季 百搭', '/images/23.jpg', '23', null), ('24', '鞋', '运动鞋白色', '120', '白色', '学生 春季 百搭', '/images/23.jpg', '24', null), ('25', '鞋', '运动鞋白色2', '130', null, '学生 春季 aa', '/images/23.jpg', '29', null);
COMMIT;

-- ----------------------------
--  Table structure for `order_list`
-- ----------------------------
DROP TABLE IF EXISTS `order_list`;
CREATE TABLE `order_list` (
  `unumber` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `items` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `count` varchar(45) DEFAULT NULL,
  `buyer` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `product_img` varchar(45) DEFAULT NULL,
  `product_type` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order_list`
-- ----------------------------
BEGIN;
INSERT INTO `order_list` VALUES ('18646163197', '3', '裤子男 学生', '122', '2', 'lin', '123', '456', '2017-04-17 17:47:55', '/images/3.jpg', '学生 春季 百搭', '28'), ('18646163197', '16', '男士透气鞋人气潮鞋', '119', '1', 'lin', '18304521331', '啦啦啦啦啦啦', '4/20/2017, 10:50:30 PM', '/images/16.jpg', '休闲 男士 韩版', '29'), ('18646163197', '22', '人气潮鞋韩版百搭女', '89', '3', 'lin', '18304521331', '啦啦啦啦啦啦', '4/20/2017, 10:50:30 PM', '/images/22.jpg', '学生 春季 百搭', '30'), ('18646163197', '19', '时尚打底衫女春秋', '124', '1', 'lin', '111111', '啦啦啦啦', '4/20/2017, 10:51:05 PM', '/images/19.jpg', '学生 春季 百搭', '31'), ('18646163197', '5', '帆布鞋男韩版运动鞋小白鞋', '67', '2', 'lin', '12345678911', '黑大', '2017-04-25 12:38:29', '/images/5.jpg', '运动 帆布 男士', '32'), ('18689572395', '9', '春季新款女时尚套装', '100', '2', 'aaa', '12365498711', '黑大', '2017-04-25 12:40:35', '/images/9.jpg', '新款 学生 女士', '33');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
