CREATE DATABASE  IF NOT EXISTS `gcthermocouple` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gcthermocouple`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gcthermocouple
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `t_product_mass`
--

DROP TABLE IF EXISTS `t_product_mass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_mass` (
  `productID` bigint(20) NOT NULL AUTO_INCREMENT,
  `partNumberFormat` varchar(800) DEFAULT NULL COMMENT '{typeid:optionid,,};;',
  `description` varchar(800) DEFAULT NULL,
  `taobaoUrl` varchar(800) DEFAULT NULL,
  `docURl` varchar(800) DEFAULT NULL,
  `productName` varchar(500) NOT NULL,
  `pageDetail` bigint(20) DEFAULT NULL,
  `typeF` bigint(20) NOT NULL,
  `typeS` bigint(20) NOT NULL,
  `typeT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_mass`
--

LOCK TABLES `t_product_mass` WRITE;
/*!40000 ALTER TABLE `t_product_mass` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_mass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_mass_pagedetail`
--

DROP TABLE IF EXISTS `t_product_mass_pagedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_mass_pagedetail` (
  `pageDetailID` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pageDetailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_mass_pagedetail`
--

LOCK TABLES `t_product_mass_pagedetail` WRITE;
/*!40000 ALTER TABLE `t_product_mass_pagedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_mass_pagedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_mass_partnumber_format`
--

DROP TABLE IF EXISTS `t_product_mass_partnumber_format`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_mass_partnumber_format` (
  `partNumberID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `optionsIDJSON` varchar(1000) NOT NULL,
  `optionsJSON` varchar(1000) NOT NULL,
  PRIMARY KEY (`partNumberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_mass_partnumber_format`
--

LOCK TABLES `t_product_mass_partnumber_format` WRITE;
/*!40000 ALTER TABLE `t_product_mass_partnumber_format` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_mass_partnumber_format` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_mass_type`
--

DROP TABLE IF EXISTS `t_product_mass_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_mass_type` (
  `typeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `typeLevel` int(2) NOT NULL,
  `typeF` bigint(20) DEFAULT NULL,
  `typeS` bigint(20) DEFAULT NULL,
  `description` varchar(400) NOT NULL,
  `name` varchar(200) NOT NULL,
  `pictureSmallUrl` varchar(200) DEFAULT NULL,
  `pictureBigUrl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_mass_type`
--

LOCK TABLES `t_product_mass_type` WRITE;
/*!40000 ALTER TABLE `t_product_mass_type` DISABLE KEYS */;
INSERT INTO `t_product_mass_type` VALUES (1,1,NULL,NULL,'热电偶（thermocouple）是温度测量仪表中常用的测温元件，它直接测量温度，并把温度信号转换成热电动势信号，通过电气仪表（二次仪表）转换成被测介质的温度。','热电偶',NULL,NULL),(2,1,NULL,NULL,'各种仪表','各种仪表',NULL,NULL),(3,1,NULL,NULL,'线材与保护材料','线材与保护材料',NULL,NULL),(4,1,NULL,NULL,'其他材料','其他材料',NULL,NULL),(5,2,3,NULL,'补偿导线','补偿导线',NULL,NULL),(6,2,3,NULL,'陶瓷管','陶瓷管',NULL,NULL),(7,2,3,NULL,'刚玉管','刚玉管',NULL,NULL),(8,2,4,NULL,'瓷珠','瓷珠',NULL,NULL),(9,2,3,NULL,'热缩管','热缩管',NULL,NULL),(10,2,4,NULL,'铜接线片','铜接线片',NULL,NULL),(11,2,3,NULL,'热电偶钢管','热电偶钢管',NULL,NULL),(12,2,3,NULL,'纱包线','纱包线',NULL,NULL),(13,2,3,NULL,'屏蔽线','屏蔽线',NULL,NULL),(17,2,1,NULL,'特殊热电偶带有磁性材料，以便简单安装。','磁热电偶',NULL,NULL),(18,2,3,NULL,'铠装材料','铠装材料',NULL,NULL),(19,2,4,NULL,'铂电阻','铂电阻',NULL,NULL);
/*!40000 ALTER TABLE `t_product_mass_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_info`
--

DROP TABLE IF EXISTS `t_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_info` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(40) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `PASSWORDTYPE` int(11) NOT NULL,
  `FULLNAME` varchar(100) NOT NULL,
  `STATUS` int(11) NOT NULL,
  `COUNTRY` varchar(40) DEFAULT NULL,
  `CITY` varchar(40) DEFAULT NULL,
  `PHONE` varchar(40) DEFAULT NULL,
  `MOBILE` varchar(40) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `FAX` varchar(40) DEFAULT NULL,
  `REMARK` varchar(400) DEFAULT NULL,
  `CREATETIME` date DEFAULT NULL,
  `UPDATETIME` date DEFAULT NULL,
  `MODPWDTIME` date DEFAULT NULL,
  `RSV1` varchar(40) DEFAULT NULL,
  `RSV2` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_info`
--

LOCK TABLES `t_user_info` WRITE;
/*!40000 ALTER TABLE `t_user_info` DISABLE KEYS */;
INSERT INTO `t_user_info` VALUES (36669055,'1111112ce4','1111',1,'1112',1,'534','456',NULL,'123321','1111@qq.com','456','123456',NULL,'2014-08-19','2014-08-21','2014-08-21',NULL,NULL),(76150148,'1111','11111111',1,'123',1,NULL,NULL,NULL,NULL,'123@123.123',NULL,NULL,NULL,'2014-08-25',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-08 22:35:28
