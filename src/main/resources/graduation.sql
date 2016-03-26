/*
Navicat MariaDB Data Transfer

Source Server         : LocalServer
Source Server Version : 100108
Source Host           : localhost:3306
Source Database       : graduation

Target Server Type    : MariaDB
Target Server Version : 100108
File Encoding         : 65001

Date: 2016-03-26 17:33:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `password` char(40) NOT NULL,
  `secondPassword` char(40) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` enum('男','女','未知') DEFAULT '未知',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `email` (`email`),
  KEY `tel` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'chenyiyuan00@163.com', '18681714595', '123456', null, 'Carbon', '未知');
INSERT INTO `author` VALUES ('2', 'chenyiyuan00@gmail.com', '18681714595', '123456', null, null, '未知');

-- ----------------------------
-- Table structure for author_info
-- ----------------------------
DROP TABLE IF EXISTS `author_info`;
CREATE TABLE `author_info` (
  `id` bigint(20) unsigned NOT NULL,
  `company` varchar(50) DEFAULT NULL,
  `work` varchar(50) DEFAULT NULL,
  `descriptionSelf` varchar(255) DEFAULT NULL,
  `setLinkmanNotify` tinyint(3) unsigned DEFAULT NULL,
  `setFinishNotify` tinyint(3) unsigned DEFAULT NULL,
  `setDataExpireNotify` tinyint(3) unsigned DEFAULT NULL,
  `setPrimaryNofify` enum('email','phone','both') DEFAULT 'email',
  `inDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  CONSTRAINT `author_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author_info
-- ----------------------------
INSERT INTO `author_info` VALUES ('1', null, null, null, null, null, null, 'email', '2016-03-26 12:23:24');
INSERT INTO `author_info` VALUES ('2', null, null, null, null, null, null, 'email', '2016-03-26 12:23:55');

-- ----------------------------
-- Table structure for auth_code
-- ----------------------------
DROP TABLE IF EXISTS `auth_code`;
CREATE TABLE `auth_code` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned NOT NULL,
  `voter` bigint(20) unsigned NOT NULL,
  `code` char(6) NOT NULL,
  `used` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `vote` (`vote`),
  KEY `voter` (`voter`),
  CONSTRAINT `auth_code_ibfk_1` FOREIGN KEY (`vote`) REFERENCES `vote` (`id`),
  CONSTRAINT `auth_code_ibfk_2` FOREIGN KEY (`voter`) REFERENCES `voter` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='验证码';

-- ----------------------------
-- Records of auth_code
-- ----------------------------
INSERT INTO `auth_code` VALUES ('1', '1', '1', '123456', '1');

-- ----------------------------
-- Table structure for progress
-- ----------------------------
DROP TABLE IF EXISTS `progress`;
CREATE TABLE `progress` (
  `progress` tinyint(3) unsigned NOT NULL,
  `message` varchar(20) NOT NULL,
  PRIMARY KEY (`progress`),
  KEY `progress` (`progress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of progress
-- ----------------------------
INSERT INTO `progress` VALUES ('0', 'created');
INSERT INTO `progress` VALUES ('10', 'edited');
INSERT INTO `progress` VALUES ('20', 'published');
INSERT INTO `progress` VALUES ('30', 'proceed');
INSERT INTO `progress` VALUES ('40', 'finished');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(10) NOT NULL,
  `hot` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `tag` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', 'workDo', '999999997');
INSERT INTO `tag` VALUES ('2', 'havework', '999999999');
INSERT INTO `tag` VALUES ('3', 'work year', '999999998');
INSERT INTO `tag` VALUES ('4', 'moreMoney', '999999999');
INSERT INTO `tag` VALUES ('5', 'tag', '0');
INSERT INTO `tag` VALUES ('6', 'One', '0');
INSERT INTO `tag` VALUES ('7', 'Twn', '0');
INSERT INTO `tag` VALUES ('8', 'Other', '0');
INSERT INTO `tag` VALUES ('9', 'Double', '0');
INSERT INTO `tag` VALUES ('10', 'M_M', '0');

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `url` char(4) NOT NULL COMMENT 'Short URL',
  `tableName` char(33) NOT NULL,
  `category` enum('vote','poll','info') NOT NULL DEFAULT 'vote',
  `author` bigint(20) unsigned NOT NULL,
  `title` varchar(40) NOT NULL,
  `progress` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `auth` enum('public','protected','private') NOT NULL COMMENT '授权方式',
  `inDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `predictDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `endDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `tableName` (`tableName`),
  KEY `author` (`author`),
  KEY `title` (`title`),
  CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`author`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '', '2343', 'vote', '1', 't1', '10', 'public', '2016-03-23 15:30:17', '2016-03-23 15:30:17', '2016-03-23 15:30:17');
INSERT INTO `vote` VALUES ('2', '', '345345', 'poll', '1', 't2', '0', 'public', '2016-03-21 22:27:04', '2016-03-21 22:27:04', '2016-03-21 22:23:54');
INSERT INTO `vote` VALUES ('3', '', '2353', 'vote', '1', 't3', '0', 'public', '2016-03-15 18:02:55', '2016-03-29 18:02:51', '2016-03-15 18:02:55');
INSERT INTO `vote` VALUES ('4', '', '23434', 'info', '1', 't4', '20', 'public', '2016-03-25 17:41:34', '2016-03-25 17:41:34', '2016-03-25 17:41:34');
INSERT INTO `vote` VALUES ('9', '', 'tableName', 'poll', '1', 't9', '0', 'public', '2016-03-25 17:41:37', '2016-03-25 17:41:37', '2016-03-25 17:41:37');
INSERT INTO `vote` VALUES ('10', '', 'tableName', 'info', '1', 't10', '0', 'public', '2016-03-25 17:41:42', '2016-03-25 17:41:42', '2016-03-25 17:41:42');
INSERT INTO `vote` VALUES ('11', '', 'tableName', 'info', '2', 't11', '0', 'public', '2016-03-26 17:28:56', '2016-03-26 17:28:56', '2016-03-26 17:28:56');
INSERT INTO `vote` VALUES ('12', '', 'tableName', 'poll', '2', 't12', '0', 'public', '2016-03-26 17:28:57', '2016-03-26 17:28:57', '2016-03-26 17:28:57');
INSERT INTO `vote` VALUES ('13', '', 'tableName', 'vote', '2', 't13', '0', 'public', '2016-03-26 17:29:02', '2016-03-26 17:29:02', '2016-03-26 17:29:02');
INSERT INTO `vote` VALUES ('14', '', 'tableName', 'info', '2', 't14', '0', 'public', '2016-03-26 17:28:59', '2016-03-26 17:28:59', '2016-03-26 17:28:59');

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
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `voterGroup` (`voterGroup`),
  KEY `email` (`email`),
  CONSTRAINT `voter_ibfk_1` FOREIGN KEY (`voterGroup`) REFERENCES `voter_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voter
-- ----------------------------
INSERT INTO `voter` VALUES ('1', '1', '1174310485@qq.com', '13551174063', 'Widmore');
INSERT INTO `voter` VALUES ('4', '1', '1174310485@google.com', '18851174063', 'Good');
INSERT INTO `voter` VALUES ('10', '1', 'exampl@163.com', '13345678910', '备注名');
INSERT INTO `voter` VALUES ('11', '1', 'exampl@gmail.com', '13345678911', 'Aias');
INSERT INTO `voter` VALUES ('12', '1', 'exampl@qq.com', '13345678912', 'QQ好友');
INSERT INTO `voter` VALUES ('16', '1', '1174310485@qq.com', '13551174063', 'Widmore');
INSERT INTO `voter` VALUES ('17', '1', '1174310485@qq.com', '13551174063', 'Widmore');

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
  PRIMARY KEY (`id`),
  KEY `author` (`author`),
  CONSTRAINT `voter_group_ibfk_1` FOREIGN KEY (`author`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voter_group
-- ----------------------------
INSERT INTO `voter_group` VALUES ('1', '1', '5', 't1', '2016-03-22 11:55:22');
INSERT INTO `voter_group` VALUES ('2', '1', '0', 't2', '2016-03-25 17:30:23');

-- ----------------------------
-- Table structure for vote_content
-- ----------------------------
DROP TABLE IF EXISTS `vote_content`;
CREATE TABLE `vote_content` (
  `id` bigint(20) unsigned NOT NULL,
  `content` text,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_content
-- ----------------------------

-- ----------------------------
-- Table structure for vote_tag
-- ----------------------------
DROP TABLE IF EXISTS `vote_tag`;
CREATE TABLE `vote_tag` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned DEFAULT NULL,
  `tag` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vote` (`vote`),
  KEY `tag` (`tag`),
  CONSTRAINT `vote_tag_ibfk_1` FOREIGN KEY (`vote`) REFERENCES `vote` (`id`),
  CONSTRAINT `vote_tag_ibfk_2` FOREIGN KEY (`tag`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_tag
-- ----------------------------
INSERT INTO `vote_tag` VALUES ('3', '9', '4');
INSERT INTO `vote_tag` VALUES ('4', '9', '3');
INSERT INTO `vote_tag` VALUES ('5', '9', '2');
INSERT INTO `vote_tag` VALUES ('6', '9', '1');
INSERT INTO `vote_tag` VALUES ('7', '9', '5');
INSERT INTO `vote_tag` VALUES ('8', '10', '3');
INSERT INTO `vote_tag` VALUES ('9', '10', '5');
INSERT INTO `vote_tag` VALUES ('10', '2', '1');
INSERT INTO `vote_tag` VALUES ('11', '3', '9');

-- ----------------------------
-- Table structure for vote_voter_group
-- ----------------------------
DROP TABLE IF EXISTS `vote_voter_group`;
CREATE TABLE `vote_voter_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned NOT NULL,
  `voterGroup` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vote` (`vote`),
  KEY `voterGroup` (`voterGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_voter_group
-- ----------------------------
