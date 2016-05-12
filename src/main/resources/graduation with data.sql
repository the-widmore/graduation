/*
Navicat MariaDB Data Transfer

Source Server         : MySQL-LocalServer
Source Server Version : 100108
Source Host           : localhost:3306
Source Database       : graduation

Target Server Type    : MariaDB
Target Server Version : 100108
File Encoding         : 65001

Date: 2016-05-12 19:36:38
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
  `nickName` varchar(20) DEFAULT NULL,
  `sex` enum('男','女','未知') DEFAULT '未知',
  `status` enum('registered','activated','locked') NOT NULL DEFAULT 'registered',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `email` (`email`),
  KEY `tel` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'chenyiyuan00@163.com', '18681714595', '123456', '1234', 'Carbon', '灵馨儿', '女', 'registered');
INSERT INTO `author` VALUES ('2', 'chenyiyuan00@gmail.com', '18681714595', '123456', null, null, null, '未知', 'registered');

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
-- Records of author_info
-- ----------------------------
INSERT INTO `author_info` VALUES ('1', null, null, null, null, '1', '1', '1', 'both');
INSERT INTO `author_info` VALUES ('2', null, null, null, null, null, null, null, 'email');

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
-- Records of auth_code
-- ----------------------------
INSERT INTO `auth_code` VALUES ('1', '3', null, '123456', '0');
INSERT INTO `auth_code` VALUES ('2', '45', null, '123456', '0');
INSERT INTO `auth_code` VALUES ('3', '46', null, '123456', '0');
INSERT INTO `auth_code` VALUES ('4', '47', null, '123456', '0');

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
INSERT INTO `progress` VALUES ('30', 'finished');

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
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

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
INSERT INTO `tag` VALUES ('11', 'Tag1', '0');
INSERT INTO `tag` VALUES ('14', 'Tag2', '0');
INSERT INTO `tag` VALUES ('18', 'Tag3 ', '0');
INSERT INTO `tag` VALUES ('19', 'Tag4', '0');
INSERT INTO `tag` VALUES ('23', 'Test', '0');
INSERT INTO `tag` VALUES ('24', 'Web', '0');
INSERT INTO `tag` VALUES ('25', 'Vote', '0');
INSERT INTO `tag` VALUES ('26', 'Create', '0');
INSERT INTO `tag` VALUES ('34', 'Not', '0');
INSERT INTO `tag` VALUES ('35', 'yet', '0');
INSERT INTO `tag` VALUES ('36', 'implemented', '0');
INSERT INTO `tag` VALUES ('49', 'edit', '0');
INSERT INTO `tag` VALUES ('50', 'publist', '0');
INSERT INTO `tag` VALUES ('53', '东软', '0');
INSERT INTO `tag` VALUES ('54', '实习', '0');
INSERT INTO `tag` VALUES ('55', '2016', '0');
INSERT INTO `tag` VALUES ('58', '答辩', '0');
INSERT INTO `tag` VALUES ('61', ' Tag3 ', '0');
INSERT INTO `tag` VALUES ('62', ' Tag4', '0');
INSERT INTO `tag` VALUES ('63', ' Tag5', '0');
INSERT INTO `tag` VALUES ('64', '生活', '0');
INSERT INTO `tag` VALUES ('65', '成都', '0');
INSERT INTO `tag` VALUES ('66', null, '0');
INSERT INTO `tag` VALUES ('67', null, '0');
INSERT INTO `tag` VALUES ('68', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '', '2343', 'vote', '1', 't1', '20', 'PRIVATE', '2016-04-12 14:52:49', '2016-04-12 14:52:49', '2016-04-18 00:00:00', null, '1');
INSERT INTO `vote` VALUES ('2', '', '345345', 'poll', '1', 't2', '0', 'PUBLIC', '2016-03-30 19:01:11', '2016-03-30 19:01:11', '2016-03-30 19:01:11', null, '1');
INSERT INTO `vote` VALUES ('3', '', '2353', 'vote', '1', 't3', '20', 'PROTECTED', '2016-04-16 09:37:14', '2016-04-16 09:37:14', '2016-04-16 09:37:14', null, '1');
INSERT INTO `vote` VALUES ('4', '', '23434', 'info', '1', 't4', '20', 'PUBLIC', '2016-03-30 19:01:11', '2016-03-30 19:01:11', '2016-03-30 19:01:11', null, '1');
INSERT INTO `vote` VALUES ('9', '', 'tableName', 'poll', '1', 't9', '0', 'PUBLIC', '2016-03-30 19:01:11', '2016-03-30 19:01:11', '2016-03-30 19:01:11', null, '1');
INSERT INTO `vote` VALUES ('10', '', 'tableName', 'info', '1', 't10', '0', 'PUBLIC', '2016-03-30 19:01:11', '2016-03-30 19:01:11', '2016-03-30 19:01:11', null, '1');
INSERT INTO `vote` VALUES ('45', null, '_25c519c2c20e4b44891b506a0540bc0a', 'vote', '1', 'Use web create vote test to my vote', '20', 'PROTECTED', '2016-04-16 09:33:11', '2016-04-30 23:59:00', '2016-04-16 09:33:11', null, '0');
INSERT INTO `vote` VALUES ('46', null, '_738c619b542a4a71b86b26cf99eb9df2', 'vote', '1', 'Test create edit and publish', '20', 'PROTECTED', '2016-04-17 21:03:21', '2016-04-18 00:30:00', null, null, '0');
INSERT INTO `vote` VALUES ('47', 'AaAa', '_504213a4ae834bd0bb461418f3d8c62f', 'vote', '1', '2016东软学生实习情况', '20', 'PROTECTED', '2016-04-29 22:39:37', '2016-05-30 23:59:00', null, null, '0');
INSERT INTO `vote` VALUES ('48', null, '_8a070a7f885d41a693d7a5c7f94a07f4', 'vote', '1', '答辩情况收集', '0', 'PUBLIC', '2016-04-29 23:07:09', null, null, null, '1');
INSERT INTO `vote` VALUES ('50', null, '_9c469d2e9b6f4befa09a07e8d60ee1ad', 'vote', '1', 'vote title', '0', 'PUBLIC', '2016-04-30 22:07:35', null, null, null, '1');
INSERT INTO `vote` VALUES ('51', null, 'tableName', 'info', '1', 'title', '0', 'PUBLIC', '2016-04-30 22:07:35', null, null, null, '0');
INSERT INTO `vote` VALUES ('53', null, '_a09db408c1f9446eb731997eb3fefafb', 'vote', '1', 'vote title', '0', 'PUBLIC', '2016-04-30 22:33:16', null, null, null, '1');
INSERT INTO `vote` VALUES ('54', null, 'tableName', 'info', '1', 'title', '0', 'PUBLIC', '2016-04-30 22:33:16', null, null, null, '1');
INSERT INTO `vote` VALUES ('56', null, '_8a4d2057a260425381b6419f9e0b0cef', 'vote', '1', 'vote title', '0', 'PUBLIC', '2016-04-30 22:37:35', null, null, null, '1');
INSERT INTO `vote` VALUES ('58', 'Xm7X', '_2872b9778f5a459c8705933c43c8f22d', 'vote', '1', '生活体验', '20', 'PUBLIC', '2016-05-02 18:06:02', '2016-05-30 23:59:00', null, null, '0');

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
-- Records of voter
-- ----------------------------
INSERT INTO `voter` VALUES ('1', '1', 'chenyiyuan00@163.com', '18651174063', 'GoodWid');
INSERT INTO `voter` VALUES ('2', '1', '1174310485@qq.com', '13599004009', 'Lias');
INSERT INTO `voter` VALUES ('3', '1', '1174310485@qq.com', '13551174063', 'Carbon');
INSERT INTO `voter` VALUES ('4', '1', 'weufbeurf@12345.com', '18851174063', 'Gods');
INSERT INTO `voter` VALUES ('5', '3', '1174310485@google.com', '18852343063', 'Good');
INSERT INTO `voter` VALUES ('6', '3', 'exampl@16366.com', '13345678910', 'ALia');

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
-- Records of voter_group
-- ----------------------------
INSERT INTO `voter_group` VALUES ('1', '1', '7', 't1', '2016-03-29 22:44:00');
INSERT INTO `voter_group` VALUES ('2', '1', '0', 't2', '2016-03-25 17:30:23');
INSERT INTO `voter_group` VALUES ('3', '1', '0', 't3', '2016-04-30 10:47:22');

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
-- Records of vote_content
-- ----------------------------
INSERT INTO `vote_content` VALUES ('1', '<p>EasyVote::投票:创建</p>\r\n\r\n<div>\r\n<div>EasyVote</div>\r\n\r\n<div>\r\n<p>首页</p>\r\n\r\n<p>搜索</p>\r\n\r\n<p>投票</p>\r\n\r\n<p>问卷</p>\r\n\r\n<p>个人</p>\r\n\r\n<p>演示</p>\r\n\r\n<p>帮助</p>\r\n\r\n<p>关于</p>\r\n更多\r\n\r\n<p>活动</p>\r\n\r\n<p>隐私政策</p>\r\n\r\n<p>用户数据</p>\r\n\r\n<p>平台政策</p>\r\nchenyiyuan00@163.com\r\n\r\n<p>个人中心</p>\r\n\r\n<p>退出</p>\r\n</div>\r\n</div>\r\n\r\n<div>\r\n<p>首页</p>\r\n\r\n<p>投票</p>\r\n\r\n<p>创建简单投票</p>\r\n\r\n<div>\r\n<div>\r\n<div>\r\n<h3>创建投票</h3>\r\n</div>\r\n\r\n<div>投票标题\r\n<div><input name=\"title\" required=\"\" type=\"text\" /></div>\r\n</div>\r\n\r\n<div>投票标签\r\n<div><input name=\"tags\" type=\"text\" /></div>\r\n</div>\r\n\r\n<div>结束时间\r\n<div><input name=\"endDate\" required=\"\" type=\"datetime-local\" /></div>\r\n</div>\r\n\r\n<div>编辑模式\r\n<div><select name=\"editMode\"><option value=\"html\">HTML模式</option><option value=\"visible\">拖拽编辑</option> </select></div>\r\n</div>\r\n\r\n<div>\r\n<div><input type=\"submit\" /></div>\r\n</div>\r\n</div>\r\n\r\n<div>&nbsp;</div>\r\n</div>\r\n</div>\r\n', '1');
INSERT INTO `vote_content` VALUES ('2', '对几种中文分析器，从分词准确性和效率两方面进行比较。分析器依次为：StandardAnalyzer、ChineseAnalyzer、 CJKAnalyzer、IK_CAnalyzer、MIK_CAnalyzer、MMAnalyzer（JE分词）、PaodingAnalyzer。\r\n单纯的中文分词的实现一般为按字索引或者按词索引。按字索引顾名思义，就是按单个字建立索引。按词索引就是按词喽，根据词库中的词，将文字进行切分。车东的交叉双字分割或者叫二元分词我觉得应该算是按字索引的改进，应该还是属于字索引的范畴吧。\r\n分词准确性的评估比较难，很难有统一的标准，不同应用的要求也不同，这个统一以“2008年8月8日晚，举世瞩目的北京第二十九届奥林匹克运动会开幕式在国家体育场隆重举行。”为例说明。\r\n分词效率，统一使用《射雕英雄传》的全文文本为例说明。呵呵。对于按词索引的分析器，使用统一的基本词库，词汇量为227,719个。在开发环境下运行，性能不准确，但可比较相对值。', '1');
INSERT INTO `vote_content` VALUES ('3', '<p>1.示例单选问题？</p>\r\n\r\n<p><input checked=\"checked\" name=\"q1\" type=\"radio\" value=\"A\" />选项1 &nbsp; &nbsp;<input name=\"q1\" type=\"radio\" value=\"B\" />选项2 &nbsp; &nbsp; <input name=\"q1\" type=\"radio\" value=\"C\" />选项3 &nbsp; &nbsp;<input name=\"q1\" type=\"radio\" value=\"D\" />选项4</p>\r\n\r\n<p>2.多选实例问题？</p>\r\n\r\n<p><input name=\"q2\" type=\"checkbox\" value=\"A\" />可选A &nbsp; &nbsp; <input checked=\"checked\" name=\"q2\" type=\"checkbox\" value=\"B\" />可选B &nbsp; &nbsp; <input name=\"q2\" type=\"checkbox\" value=\"C\" />可选C &nbsp;&nbsp;<input name=\"q2\" type=\"checkbox\" value=\"D\" />可选D&nbsp;</p>\r\n\r\n<p>3.下拉选择实例问题？</p>\r\n\r\n<p>下拉选项01下拉选项02下拉选项03下拉选项04</p>\r\n\r\n<p>4.带有自定义域的问题？</p>\r\n\r\n<p><input name=\"a4\" type=\"checkbox\" value=\"A\" />选项01 &nbsp; <input name=\"q4\" type=\"checkbox\" value=\"B\" />选项02 &nbsp; 其他 <input name=\"q4\" type=\"text\" /></p>\r\n\r\n<p>5.你睡了吗？</p>\r\n\r\n<p><input checked=\"checked\" name=\"q5\" type=\"radio\" />没睡 &nbsp;<input name=\"q5\" type=\"radio\" />睡了&nbsp;</p>\r\n\r\n<p>6.you cellphone?</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n', '1');
INSERT INTO `vote_content` VALUES ('45', '<p>1</p>\r\n\r\n<p>2</p>\r\n\r\n<p>3</p>\r\n\r\n<p>4</p>\r\n\r\n<p>5</p>\r\n\r\n<p>6</p>\r\n\r\n<p>7</p>\r\n\r\n<p>8</p>\r\n\r\n<p>9</p>\r\n\r\n<p>10</p>\r\n\r\n<p>11.<input name=\"A\" type=\"checkbox\" value=\"A\" />A</p>\r\n\r\n<p>&nbsp;</p>\r\n', '1');
INSERT INTO `vote_content` VALUES ('46', 'content', '1');
INSERT INTO `vote_content` VALUES ('47', '<p>1.工作时间好多月？</p>\r\n\r\n<p><input name=\"q1\" type=\"radio\" value=\"1\" />1 &nbsp;<input name=\"q1\" type=\"radio\" value=\"2\" />2 &nbsp;<input name=\"q1\" type=\"radio\" value=\"3\" />3 &nbsp;<input name=\"q4\" type=\"radio\" value=\"4\" />4 &nbsp;<input name=\"q1\" type=\"radio\" value=\"5\" />5</p>\r\n\r\n<p>2.基本工资</p>\r\n\r\n<p><input name=\"q2\" type=\"radio\" value=\"A\" />&lt;2000&nbsp;<input name=\"q2\" type=\"radio\" value=\"B\" />2000-4000&nbsp;<input name=\"q2\" type=\"radio\" value=\"C\" />4000-6000 &nbsp;<input name=\"q2\" type=\"radio\" value=\"D\" />&gt;6000</p>\r\n\r\n<p>3.是否经常加班？</p>\r\n\r\n<p><input name=\"q3\" type=\"radio\" value=\"A\" />NO &nbsp;<input name=\"q3\" type=\"radio\" value=\"B\" />YES</p>\r\n', '1');
INSERT INTO `vote_content` VALUES ('48', '<p>1</p>\r\n\r\n<p>2</p>\r\n\r\n<p>3</p>\r\n', '1');
INSERT INTO `vote_content` VALUES ('50', 'zoo', '1');
INSERT INTO `vote_content` VALUES ('51', 'zore', '1');
INSERT INTO `vote_content` VALUES ('53', null, '1');
INSERT INTO `vote_content` VALUES ('54', null, '1');
INSERT INTO `vote_content` VALUES ('56', null, '1');
INSERT INTO `vote_content` VALUES ('57', null, '1');
INSERT INTO `vote_content` VALUES ('58', '<p>1</p>\r\n\r\n<p>2</p>\r\n\r\n<p>3</p>\r\n', '1');

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
-- Records of vote_content_temp
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_tag
-- ----------------------------
INSERT INTO `vote_tag` VALUES ('3', '1', '4');
INSERT INTO `vote_tag` VALUES ('5', '3', '2');
INSERT INTO `vote_tag` VALUES ('6', '3', '1');
INSERT INTO `vote_tag` VALUES ('7', '9', '5');
INSERT INTO `vote_tag` VALUES ('8', '10', '3');
INSERT INTO `vote_tag` VALUES ('9', '10', '5');
INSERT INTO `vote_tag` VALUES ('10', '2', '1');
INSERT INTO `vote_tag` VALUES ('127', '45', '26');
INSERT INTO `vote_tag` VALUES ('128', '45', '25');
INSERT INTO `vote_tag` VALUES ('129', '45', '23');
INSERT INTO `vote_tag` VALUES ('130', '45', '47');
INSERT INTO `vote_tag` VALUES ('131', '45', '48');
INSERT INTO `vote_tag` VALUES ('132', '46', '23');
INSERT INTO `vote_tag` VALUES ('133', '46', '49');
INSERT INTO `vote_tag` VALUES ('134', '46', '50');
INSERT INTO `vote_tag` VALUES ('135', '46', '51');
INSERT INTO `vote_tag` VALUES ('136', '46', '52');
INSERT INTO `vote_tag` VALUES ('137', '47', '53');
INSERT INTO `vote_tag` VALUES ('138', '47', '54');
INSERT INTO `vote_tag` VALUES ('139', '47', '55');
INSERT INTO `vote_tag` VALUES ('140', '47', '56');
INSERT INTO `vote_tag` VALUES ('141', '47', '57');
INSERT INTO `vote_tag` VALUES ('142', '48', '55');
INSERT INTO `vote_tag` VALUES ('143', '48', '58');
INSERT INTO `vote_tag` VALUES ('144', '48', '53');
INSERT INTO `vote_tag` VALUES ('145', '48', '59');
INSERT INTO `vote_tag` VALUES ('146', '48', '60');
INSERT INTO `vote_tag` VALUES ('147', '50', '11');
INSERT INTO `vote_tag` VALUES ('148', '50', '14');
INSERT INTO `vote_tag` VALUES ('149', '50', '61');
INSERT INTO `vote_tag` VALUES ('150', '50', '62');
INSERT INTO `vote_tag` VALUES ('151', '50', '63');
INSERT INTO `vote_tag` VALUES ('152', '1', '11');
INSERT INTO `vote_tag` VALUES ('155', '1', '62');
INSERT INTO `vote_tag` VALUES ('157', '53', '11');
INSERT INTO `vote_tag` VALUES ('158', '53', '14');
INSERT INTO `vote_tag` VALUES ('159', '53', '61');
INSERT INTO `vote_tag` VALUES ('160', '53', '62');
INSERT INTO `vote_tag` VALUES ('161', '53', '63');
INSERT INTO `vote_tag` VALUES ('164', '1', '61');
INSERT INTO `vote_tag` VALUES ('167', '56', '11');
INSERT INTO `vote_tag` VALUES ('168', '56', '14');
INSERT INTO `vote_tag` VALUES ('169', '56', '61');
INSERT INTO `vote_tag` VALUES ('170', '56', '62');
INSERT INTO `vote_tag` VALUES ('171', '56', '63');
INSERT INTO `vote_tag` VALUES ('177', '58', '64');
INSERT INTO `vote_tag` VALUES ('178', '58', '65');
INSERT INTO `vote_tag` VALUES ('179', '58', '66');
INSERT INTO `vote_tag` VALUES ('180', '58', '67');
INSERT INTO `vote_tag` VALUES ('181', '58', '68');

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

-- ----------------------------
-- Records of vote_voter_group
-- ----------------------------
INSERT INTO `vote_voter_group` VALUES ('1', '1', '2');
INSERT INTO `vote_voter_group` VALUES ('2', '1', '3');
