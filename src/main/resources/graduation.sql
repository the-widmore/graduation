/*
Navicat MariaDB Data Transfer

Source Server         : LocalServer
Source Server Version : 100108
Source Host           : localhost:3306
Source Database       : graduation

Target Server Type    : MariaDB
Target Server Version : 100108
File Encoding         : 65001

Date: 2016-03-23 18:08:28
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
  `name` varchar(20) DEFAULT NULL,
  `sex` enum('男','女','未知') DEFAULT '未知',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `email` (`email`),
  KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'chenyiyuan00@163.com', '18681714595', '123456', 'Carbon', '男');
INSERT INTO `author` VALUES ('3', 'chenyiyuan00@gmail.com', null, '123456', null, '未知');

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
  KEY `id` (`id`),
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='验证码';

-- ----------------------------
-- Records of auth_code
-- ----------------------------
INSERT INTO `auth_code` VALUES ('1', '1', '1', '123456', '0');

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
INSERT INTO `tag` VALUES ('1', 'work', '999999997');
INSERT INTO `tag` VALUES ('2', 'have work', '999999999');
INSERT INTO `tag` VALUES ('3', 'work year', '999999998');
INSERT INTO `tag` VALUES ('4', 'more', '999999999');
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
  `tableName` char(36) NOT NULL,
  `category` enum('vote','poll','info') NOT NULL DEFAULT 'vote',
  `author` bigint(20) unsigned NOT NULL,
  `title` varchar(40) NOT NULL,
  `progress` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `inDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `predictDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `endDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `tableName` (`tableName`),
  KEY `author` (`author`),
  KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '2343', 'vote', '1', 't1', '10', '2016-03-23 15:30:17', '2016-03-23 15:30:17', '2016-03-23 15:30:17');
INSERT INTO `vote` VALUES ('2', '345345', 'poll', '1', 't2', '0', '2016-03-21 22:27:04', '2016-03-21 22:27:04', '2016-03-21 22:23:54');
INSERT INTO `vote` VALUES ('3', '2353', 'vote', '1', 't3', '0', '2016-03-15 18:02:55', '2016-03-29 18:02:51', '2016-03-15 18:02:55');
INSERT INTO `vote` VALUES ('4', '23434', 'info', '1', 'titleIs4', '20', '2016-03-23 16:20:54', '2016-03-23 16:20:54', '2016-03-30 16:20:54');

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
  KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voter
-- ----------------------------
INSERT INTO `voter` VALUES ('3', '1', '1174310485@qq.com', '13551174063', 'Widmore');
INSERT INTO `voter` VALUES ('4', '1', '1174310485@google.com', '18851174063', 'Good');
INSERT INTO `voter` VALUES ('10', '1', 'exampl@163.com', '13345678910', '备注名');
INSERT INTO `voter` VALUES ('11', '1', 'exampl@gmail.com', '13345678911', 'Aias');
INSERT INTO `voter` VALUES ('12', '1', 'exampl@qq.com', '13345678912', 'QQ好友');
INSERT INTO `voter` VALUES ('16', '1', '1174310485@qq.com', '13551174063', 'Widmore');

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
  KEY `author` (`author`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voter_group
-- ----------------------------
INSERT INTO `voter_group` VALUES ('1', '1', '5', 't1', '2016-03-22 11:55:22');

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
  KEY `tag` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_tag
-- ----------------------------
INSERT INTO `vote_tag` VALUES ('1', '1', '1');
INSERT INTO `vote_tag` VALUES ('2', '1', '4');
INSERT INTO `vote_tag` VALUES ('3', '1', '6');
INSERT INTO `vote_tag` VALUES ('4', '1', '1');
INSERT INTO `vote_tag` VALUES ('5', '1', '1');
INSERT INTO `vote_tag` VALUES ('6', '1', '1');
INSERT INTO `vote_tag` VALUES ('7', '1', '6');
INSERT INTO `vote_tag` VALUES ('8', '1', '7');
INSERT INTO `vote_tag` VALUES ('9', '1', '8');
INSERT INTO `vote_tag` VALUES ('10', '1', '9');
INSERT INTO `vote_tag` VALUES ('11', '1', '6');
INSERT INTO `vote_tag` VALUES ('12', '1', '7');
INSERT INTO `vote_tag` VALUES ('13', '1', '8');
INSERT INTO `vote_tag` VALUES ('14', '1', '9');
INSERT INTO `vote_tag` VALUES ('15', '1', '6');
INSERT INTO `vote_tag` VALUES ('16', '1', '7');
INSERT INTO `vote_tag` VALUES ('17', '1', '8');
INSERT INTO `vote_tag` VALUES ('18', '1', '9');
INSERT INTO `vote_tag` VALUES ('19', '1', '6');
INSERT INTO `vote_tag` VALUES ('20', '1', '7');
INSERT INTO `vote_tag` VALUES ('21', '1', '8');
INSERT INTO `vote_tag` VALUES ('22', '1', '9');
INSERT INTO `vote_tag` VALUES ('23', '1', '1');
INSERT INTO `vote_tag` VALUES ('24', '1', '6');
INSERT INTO `vote_tag` VALUES ('25', '1', '7');
INSERT INTO `vote_tag` VALUES ('26', '1', '8');
INSERT INTO `vote_tag` VALUES ('27', '1', '9');
INSERT INTO `vote_tag` VALUES ('28', '1', '10');

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
