/*
Navicat MariaDB Data Transfer

Source Server         : graduation
Source Server Version : 100108
Source Host           : localhost:3306
Source Database       : graduation

Target Server Type    : MariaDB
Target Server Version : 100108
File Encoding         : 65001

Date: 2016-05-14 20:58:58
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
  `nickname` varchar(20) DEFAULT NULL,
  `sex` enum('男','女','未知') DEFAULT '未知',
  `status` enum('registered','activated','locked') NOT NULL DEFAULT 'registered',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `email` (`email`),
  KEY `tel` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for author_info
-- ----------------------------
DROP TABLE IF EXISTS `author_info`;
CREATE TABLE `author_info` (
  `id` bigint(20) unsigned NOT NULL,
  `company` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `work` varchar(50) DEFAULT NULL,
  `descriptionSelf` varchar(255) DEFAULT NULL,
  `setLinkmanNotify` tinyint(3) unsigned DEFAULT NULL,
  `setVoteFinishNotify` tinyint(3) unsigned DEFAULT NULL,
  `setDataExpireNotify` tinyint(3) unsigned DEFAULT NULL,
  `setPrimaryNofify` enum('email','phone','both') DEFAULT 'email',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  CONSTRAINT `author_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for auth_code
-- ----------------------------
DROP TABLE IF EXISTS `auth_code`;
CREATE TABLE `auth_code` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned NOT NULL,
  `voter` bigint(20) unsigned DEFAULT NULL,
  `code` char(6) NOT NULL,
  `used` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `voter` (`voter`),
  KEY `auth_code_ibfk_1` (`vote`),
  CONSTRAINT `auth_code_ibfk_1` FOREIGN KEY (`vote`) REFERENCES `vote` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='验证码';

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
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(20) DEFAULT NULL,
  `hot` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `tag` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `url` char(4) DEFAULT NULL COMMENT 'Short URL',
  `tableName` char(33) NOT NULL,
  `category` enum('vote','poll','info') NOT NULL DEFAULT 'vote',
  `author` bigint(20) unsigned NOT NULL,
  `title` varchar(50) NOT NULL,
  `progress` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `auth` enum('PUBLIC','PROTECTED','PRIVATE') NOT NULL DEFAULT 'PUBLIC' COMMENT '授权方式',
  `inDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `predictDate` timestamp NULL DEFAULT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `removed` tinyint(1) unsigned DEFAULT '0' COMMENT '是否显示',
  PRIMARY KEY (`id`),
  KEY `tableName` (`tableName`),
  KEY `author` (`author`),
  KEY `title` (`title`),
  KEY `sort_url` (`url`),
  KEY `id` (`id`) USING HASH,
  CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`author`) REFERENCES `author` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vote_content
-- ----------------------------
DROP TABLE IF EXISTS `vote_content`;
CREATE TABLE `vote_content` (
  `id` bigint(20) unsigned NOT NULL,
  `content` text,
  `shared` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vote_content_temp
-- ----------------------------
DROP TABLE IF EXISTS `vote_content_temp`;
CREATE TABLE `vote_content_temp` (
  `id` bigint(20) unsigned NOT NULL,
  `vote` bigint(20) unsigned NOT NULL,
  `content` text,
  `inDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='临时表';

-- ----------------------------
-- Table structure for vote_tag
-- ----------------------------
DROP TABLE IF EXISTS `vote_tag`;
CREATE TABLE `vote_tag` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `vote` bigint(20) unsigned DEFAULT NULL,
  `tag` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vote` (`vote`),
  KEY `tag` (`tag`),
  CONSTRAINT `vote_tag_ibfk_1` FOREIGN KEY (`vote`) REFERENCES `vote` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
