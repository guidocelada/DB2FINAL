CREATE DATABASE  IF NOT EXISTS DB2FINAL;
USE DB2FINAL;
# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.13)
# Database: DB2FINAL
# Generation Time: 2014-06-02 17:31:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Application
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Application`;

CREATE TABLE `Application` (
  `application_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Application` WRITE;
/*!40000 ALTER TABLE `Application` DISABLE KEYS */;

INSERT INTO `Application` (`application_id`)
VALUES
  (1);

/*!40000 ALTER TABLE `Application` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Cart
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Cart`;

CREATE TABLE `Cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `site` bigint(20) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FK1FEF40A1FC454B` (`site`),
  KEY `FK1FEF401B168A5D` (`application_id`),
  CONSTRAINT `FK1FEF401B168A5D` FOREIGN KEY (`application_id`) REFERENCES `Application` (`application_id`),
  CONSTRAINT `FK1FEF40A1FC454B` FOREIGN KEY (`site`) REFERENCES `Site` (`site_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Cart_products
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Cart_products`;

CREATE TABLE `Cart_products` (
  `cart_id` bigint(20) NOT NULL,
  `elt` int(11) DEFAULT NULL,
  `idx` varchar(255) NOT NULL,
  PRIMARY KEY (`cart_id`,`idx`),
  KEY `FK1F4A3B83C2CAA477` (`cart_id`),
  CONSTRAINT `FK1F4A3B83C2CAA477` FOREIGN KEY (`cart_id`) REFERENCES `Cart` (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Site
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Site`;

CREATE TABLE `Site` (
  `site_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`site_id`),
  KEY `FK2753671B168A5D` (`application_id`),
  CONSTRAINT `FK2753671B168A5D` FOREIGN KEY (`application_id`) REFERENCES `Application` (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
