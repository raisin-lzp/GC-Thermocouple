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

/*Data for the table `t_product_mass` */

/*Table structure for table `t_product_mass_pagedetail` */

DROP TABLE IF EXISTS `t_product_mass_pagedetail`;

CREATE TABLE `t_product_mass_pagedetail` (
  `pageDetailID` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pageDetailID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass_pagedetail` */

/*Table structure for table `t_product_mass_partnumber_format` */

DROP TABLE IF EXISTS `t_product_mass_partnumber_format`;

CREATE TABLE `t_product_mass_partnumber_format` (
  `partNumberID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `optionsIDJSON` varchar(1000) NOT NULL,
  `optionsJSON` varchar(1000) NOT NULL,
  PRIMARY KEY (`partNumberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass_partnumber_format` */

/*Table structure for table `t_product_mass_type` */

DROP TABLE IF EXISTS `t_product_mass_type`;

CREATE TABLE `t_product_mass_type` (
  `typeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `typeLevel` int(2) NOT NULL,
  `typeF` bigint(20) DEFAULT NULL,
  `typeS` bigint(20) DEFAULT NULL,
  `description` varchar(400) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_product_mass_type` */

insert  into `t_product_mass_type`(`typeID`,`typeLevel`,`typeF`,`typeS`,`description`,`name`) values (1,1,NULL,NULL,'热电偶','热电偶'),(2,2,1,NULL,'特殊热电偶带有磁性材料，以便简单安装。','磁热电偶');

/*Table structure for table `t_user_info` */

DROP TABLE IF EXISTS `t_user_info`;

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

/*Data for the table `t_user_info` */

insert  into `t_user_info`(`USERID`,`USERNAME`,`PASSWORD`,`PASSWORDTYPE`,`FULLNAME`,`STATUS`,`COUNTRY`,`CITY`,`PHONE`,`MOBILE`,`EMAIL`,`ADDRESS`,`FAX`,`REMARK`,`CREATETIME`,`UPDATETIME`,`MODPWDTIME`,`RSV1`,`RSV2`) values (36669055,'1111112ce4','1111',1,'1112',1,'534','456',NULL,'123321','1111@qq.com','456','123456',NULL,'2014-08-19','2014-08-21','2014-08-21',NULL,NULL),(76150148,'1111','11111111',1,'123',1,NULL,NULL,NULL,NULL,'123@123.123',NULL,NULL,NULL,'2014-08-25',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
