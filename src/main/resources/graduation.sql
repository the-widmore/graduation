/*
Navicat MariaDB Data Transfer

Source Server         : LocalServer
Source Server Version : 100108
Source Host           : localhost:3306
Source Database       : graduation

Target Server Type    : MariaDB
Target Server Version : 100108
File Encoding         : 65001

Date: 2016-03-16 23:06:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `password` char(40) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` enum('男','女','未知') DEFAULT '未知',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_2` (`email`),
  UNIQUE KEY `tel_2` (`tel`),
  KEY `id` (`id`),
  KEY `email` (`email`),
  KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'chenyiyuan00@163.com', '18681714595', '123456', 'C.K', 'Carbon', '男');
INSERT INTO `author` VALUES ('3', 'chenyiyuan00@gmail.com', null, '123456', null, null, '未知');

-- ----------------------------
-- Table structure for author_info
-- ----------------------------
DROP TABLE IF EXISTS `author_info`;
CREATE TABLE `author_info` (
  `id` bigint(20) unsigned NOT NULL,
  `secondPassword` char(40) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `work` varchar(50) DEFAULT NULL,
  `descriptionSelf` varchar(255) DEFAULT NULL,
  `setLinkmanNotify` tinyint(3) unsigned DEFAULT NULL,
  `setFinishNotify` tinyint(3) unsigned DEFAULT NULL,
  `setDataExpireNotify` tinyint(3) unsigned DEFAULT NULL,
  `setPrimaryNofify` enum('email','phone','both') DEFAULT 'email',
  `inDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `author_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author_info
-- ----------------------------

-- ----------------------------
-- Table structure for auth_code
-- ----------------------------
DROP TABLE IF EXISTS `auth_code`;
CREATE TABLE `auth_code` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned NOT NULL,
  `voter` bigint(20) unsigned NOT NULL,
  `code` int(11) NOT NULL,
  `used` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='验证码';

-- ----------------------------
-- Records of auth_code
-- ----------------------------

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tableName` char(36) NOT NULL,
  `category` enum('vote','poll','info') NOT NULL DEFAULT 'vote',
  `author` bigint(20) unsigned NOT NULL,
  `title` varchar(40) NOT NULL,
  `inDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `predictDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `endDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '2343', 'vote', '1', 't1', '2016-03-15 18:01:34', '2016-03-30 18:01:24', null);
INSERT INTO `vote` VALUES ('2', '345345', 'poll', '1', 't2', '2016-03-15 18:01:53', '2016-03-22 18:01:48', null);
INSERT INTO `vote` VALUES ('3', '2353', 'vote', '1', 't3', '2016-03-15 18:02:55', '2016-03-29 18:02:51', '2016-03-15 18:02:55');

-- ----------------------------
-- Table structure for voter
-- ----------------------------
DROP TABLE IF EXISTS `voter`;
CREATE TABLE `voter` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `voterGroup` bigint(20) unsigned DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `alias` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voter
-- ----------------------------
INSERT INTO `voter` VALUES ('3', '1', '1174310485@qq.com', '13551174063', 'Widmore');
INSERT INTO `voter` VALUES ('4', '1', '1174310485@qq.com', '13551174063', 'Widmore');

-- ----------------------------
-- Table structure for voter_group
-- ----------------------------
DROP TABLE IF EXISTS `voter_group`;
CREATE TABLE `voter_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `author` bigint(20) unsigned NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '人数',
  `description` varchar(50) DEFAULT NULL,
  `inDate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voter_group
-- ----------------------------
INSERT INTO `voter_group` VALUES ('1', '1', '1', 't1', '2016-03-16 19:42:28');

-- ----------------------------
-- Table structure for vote_tag
-- ----------------------------
DROP TABLE IF EXISTS `vote_tag`;
CREATE TABLE `vote_tag` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(10) DEFAULT NULL,
  `hot` int(11) unsigned DEFAULT '999999999',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_tag
-- ----------------------------

-- ----------------------------
-- Table structure for vote_voter_group
-- ----------------------------
DROP TABLE IF EXISTS `vote_voter_group`;
CREATE TABLE `vote_voter_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned NOT NULL,
  `voter_group` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_voter_group
-- ----------------------------
