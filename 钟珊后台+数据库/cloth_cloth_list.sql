-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: cloth
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cloth_list`
--

DROP TABLE IF EXISTS `cloth_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cloth_list` (
  `number` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `items` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `price` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `color` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `describe` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `picture` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cloth_list`
--

LOCK TABLES `cloth_list` WRITE;
/*!40000 ALTER TABLE `cloth_list` DISABLE KEYS */;
INSERT INTO `cloth_list` VALUES ('1','鞋','人气潮鞋女鞋','199','白色','时尚 百搭 人气','/images/1.jpg',1),('2','上衣','初冬新款 夹克衫','67','黑色/褐色/灰色','良品 新款 时尚','/images/2.jpg',2),('3','裤子','裤子男 学生','122','黑色','学生 春季 百搭','/images/3.jpg',3),('4','上衣','春季韩版学生百搭宽松外套','209','橄榄绿/枣红/黑色','宽松 外套 时尚','/images/4.jpg',4),('5','鞋','帆布鞋男韩版运动鞋小白鞋','67','蓝色/黑白','运动 帆布 男士','/images/5.jpg',5),('6','上衣','男士 运动装','90','蓝色/灰色','男士 运动 时尚','/images/6.jpg',6),('7','上衣','修身韩版休闲帅气男春装','110','藏青/浅灰','休闲 男士 韩版','/images/7.jpg',7),('8','上衣','少女短袖韩版宽松打底衫','99','浅粉/墨绿','少女 短袖 宽松','/images/8.jpg',8),('9','上衣','春季新款女时尚套装','100','灰色/黑色','新款 学生 女士','/images/9.jpg',9),('10','上衣','打底衫春秋新款 女','134','黄色','少女 短袖 宽松','/images/10.jpg',10),('11','上衣','男士青年百搭黑色','211','黑色/灰色','少女 短袖 宽松','/images/11.jpg',11),('12','裤子','韩版 男士 春季 健身裤','112','蓝色/黑色','少女 短袖 宽松','/images/12.jpg',12),('13','裤子','男士休闲裤 百搭','89','蓝色/浅灰','少女 短袖 宽松','/images/13.jpg',13),('14','裤子','韩版 女裤子 显瘦 韩版','90','灰色','少女 短袖 宽松','/images/14.jpg',14),('15','裤子','宽松 女裤子','99','黑色','少女 短袖 宽松','/images/15.jpg',15),('16','鞋','男士透气鞋人气潮鞋','119','灰色/白色/黑白','休闲 男士 韩版','/images/16.jpg',16),('17','鞋','夏季男鞋百搭小白鞋','129','白色/黑色','休闲 男士 韩版','/images/17.jpg',17),('18','鞋','花花公子运动鞋 ','229','蓝色/黑色','休闲 男士 韩版','/images/18.jpg',18),('19','上衣','时尚打底衫女春秋','124','白色/浅黄','学生 春季 百搭','/images/19.jpg',19),('20','上衣','圆领穿棉打底衫','220','灰色/白色/黑色','学生 春季 百搭','/images/20.jpg',20),('21','上衣','时尚套装女春装韩版','190','背带/普通','学生 春季 百搭','/images/21.jpg',21),('22','鞋','人气潮鞋韩版百搭女','89','黑色/卡其色/灰色','学生 春季 百搭','/images/22.jpg',22),('0023','鞋','运动鞋白色','120','白色','学生 春季 百搭','/images/23.jpg',23);
/*!40000 ALTER TABLE `cloth_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-17 10:12:16
