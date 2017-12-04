/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.17 : Database - friendsdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`friendsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `homenote` */

DROP TABLE IF EXISTS `homenote`;

CREATE TABLE `homenote` (
  `noteId` int(8) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `note` text,
  `bgColor` varchar(20) DEFAULT NULL,
  `likeNum` int(8) DEFAULT NULL,
  `dislikeNum` int(8) DEFAULT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Table structure for table `msgreply` */

DROP TABLE IF EXISTS `msgreply`;

CREATE TABLE `msgreply` (
  `replyId` int(8) NOT NULL AUTO_INCREMENT,
  `msgId` int(8) DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  `comment` text,
  `isLike` tinyint(1) DEFAULT NULL,
  `isDislike` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`replyId`),
  KEY `msgId` (`msgId`),
  KEY `userId` (`userId`),
  CONSTRAINT `msgreply_ibfk_1` FOREIGN KEY (`msgId`) REFERENCES `usermsg` (`msgId`),
  CONSTRAINT `msgreply_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

/*Table structure for table `notereply` */

DROP TABLE IF EXISTS `notereply`;

CREATE TABLE `notereply` (
  `replyId` int(8) NOT NULL AUTO_INCREMENT,
  `noteId` int(8) DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  `isLike` tinyint(1) DEFAULT NULL,
  `isDislike` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`replyId`),
  KEY `userId` (`userId`),
  KEY `noteId` (`noteId`),
  CONSTRAINT `notereply_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `notereply_ibfk_3` FOREIGN KEY (`noteId`) REFERENCES `homenote` (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userId` int(8) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `userPsw` varchar(200) NOT NULL,
  `userSex` varchar(2) DEFAULT NULL,
  `userQQ` varchar(20) DEFAULT NULL,
  `loginFlag` int(8) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `usermsg` */

DROP TABLE IF EXISTS `usermsg`;

CREATE TABLE `usermsg` (
  `msgId` int(8) NOT NULL AUTO_INCREMENT,
  `userId` int(8) NOT NULL,
  `msgTitle` varchar(50) DEFAULT NULL,
  `msgBody` text NOT NULL,
  `msgDate` datetime DEFAULT NULL,
  `commentNum` int(8) DEFAULT NULL,
  `likeNum` int(8) DEFAULT NULL,
  `dislikeNum` int(8) DEFAULT NULL,
  PRIMARY KEY (`msgId`),
  KEY `FOREIGN_KEY` (`userId`),
  CONSTRAINT `外键` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
