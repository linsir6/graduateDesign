-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: WenXin
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
-- Table structure for table `shopping_car`
--

DROP TABLE IF EXISTS `shopping_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_car`
--

LOCK TABLES `shopping_car` WRITE;
/*!40000 ALTER TABLE `shopping_car` DISABLE KEYS */;
INSERT INTO `shopping_car` VALUES (1,'iphone7','5888','iphone','img57','iphone7 32g 亮黑色','2','18646163197'),(2,'iphone6','4888','iphone','img56','iphone6 32g 金色','1','18745069763'),(3,'iphone7','5888','iphone','img57','iphone7 32g 亮黑色','1','18646163197'),(4,'iphone6','4888','iphone','img56','iphone6 32g 金色','1','18646163197'),(5,'华为荣耀v6','3999','Android','img51','华为荣耀 128g 白色','1','18646163197'),(6,'小米笔记本','4999','笔记本电脑','img61','小米笔记本 i7 8g 128ssd','1','18646163197'),(7,'联想笔记本电脑','5288','笔记本电脑','img65','苹果笔记本，i5,8g,128ssd','1','18646163197'),(8,'小米充电宝','88','充电宝','img59','小米充电宝 5000毫安 黑色','2','18646163197'),(9,'华为荣耀v6','3999','Android','img51','华为荣耀 128g 白色','1','18745069763'),(10,'小米充电宝','88','充电宝','img59','小米充电宝 5000毫安 黑色','1','18745069763'),(11,'联想笔记本电脑','5288','笔记本电脑','img65','苹果笔记本，i5,8g,128ssd','1','18745069763');
/*!40000 ALTER TABLE `shopping_car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-18 22:49:50
