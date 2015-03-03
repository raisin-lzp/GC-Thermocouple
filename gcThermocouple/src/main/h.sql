/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.1.62-community : Database - gcthermocouple
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gcthermocouple` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gcthermocouple`;

/*Table structure for table `t_product_mass` */

DROP TABLE IF EXISTS `t_product_mass`;

CREATE TABLE `t_product_mass` (
  `productID` int(20) NOT NULL AUTO_INCREMENT,
  `PartNumberFormat` varchar(800) DEFAULT NULL COMMENT 'typeid:optionid,;',
  `description` varchar(800) DEFAULT NULL,
  `taobaoUrl` varchar(800) DEFAULT NULL,
  `docURl` varchar(800) DEFAULT NULL,
  `productName` varchar(500) NOT NULL,
  `pageDetail` int(20) DEFAULT NULL,
  `typeF` int(20) NOT NULL,
  `typeS` int(20) NOT NULL,
  `typeT` int(20) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass` */

/*Table structure for table `t_product_mass_pagedetail` */

DROP TABLE IF EXISTS `t_product_mass_pagedetail`;

CREATE TABLE `t_product_mass_pagedetail` (
  `pageDetailID` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pageDetailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass_pagedetail` */

/*Table structure for table `t_product_mass_partnumber_format` */

DROP TABLE IF EXISTS `t_product_mass_partnumber_format`;

CREATE TABLE `t_product_mass_partnumber_format` (
  `partNumberID` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `optionsJSON` varchar(1000) NOT NULL,
  PRIMARY KEY (`partNumberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass_partnumber_format` */

/*Table structure for table `t_product_mass_type` */

DROP TABLE IF EXISTS `t_product_mass_type`;

CREATE TABLE `t_product_mass_type` (
  `typeID` int(20) NOT NULL AUTO_INCREMENT,
  `typeLevel` int(2) NOT NULL,
  `typeF` int(20) DEFAULT NULL,
  `typeS` int(20) DEFAULT NULL,
  `description` varchar(400) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass_type` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
