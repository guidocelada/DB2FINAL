DROP DATABASE IF EXISTS `DB2FINAL`;

CREATE DATABASE `DB2FINAL`;

USE `DB2FINAL`;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `stock` int(11) NOT NULL DEFAULT '0',
  `price` int(11) NOT NULL DEFAULT '0',
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `product` (`id`, `name`, `stock`, `price`, `description`)
VALUES
	(1, 'Loren', 1, 11, 'loren!'),
	(2, 'Ipsum', 2, 22, 'Ipsum!\n');