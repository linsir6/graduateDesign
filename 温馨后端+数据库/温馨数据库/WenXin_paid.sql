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
-- Table structure for table `paid`
--

DROP TABLE IF EXISTS `paid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paid` (
  `number` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `details` varchar(45) DEFAULT NULL,
  `count` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paid`
--

LOCK TABLES `paid` WRITE;
/*!40000 ALTER TABLE `paid` DISABLE KEYS */;
INSERT INTO `paid` VALUES ('18','iPhone7','￥ 5888','iPhone','img57','iphone7 32g,黑色','1','18304523113','2017-4-16 12:06:43',2),('19','iPhone6s','￥ 5288','iPhone','img55','iphone6s 32g,粉色','1','18304523113','2017-4-16 12:06:43',3),('20','iPhone6s','￥ 5288','iPhone','img55','iphone6s 32g,粉色','1','18646163197','2017-4-16 12:06:43',9),('21','iPhone6s','￥ 5288','iPhone','img55','iphone6s 32g,粉色','1','18304523113','2017-4-16 12:06:43',11),('22','iPhone7','￥ 5888','iPhone','img57','iphone7 32g,黑色','1','18304523113','2017-4-16 12:06:43',13),('23','iPhone6s','￥ 5288','iPhone','img55','iphone6s 32g,粉色','1','18304523113','2017-4-16 12:06:43',14),('24','iPhone6s','￥ 5288','iPhone','img55','iphone6s 32g,粉色','f','18304523113','2017-4-16 12:06:43',24),('46','iPhone6s','5288','iPhone','img55','iphone6s 32g','1','18646163197','2017-4-16 12:06:43',25);
/*!40000 ALTER TABLE `paid` ENABLE KEYS */;
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
