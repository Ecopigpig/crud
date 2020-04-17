/*
Navicat MySQL Data Transfer

Source Server         : mycomputer
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : aaaa

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-04-17 23:39:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `status` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userInfo` VALUES ('4', '小明', '1');
INSERT INTO `userInfo` VALUES ('5', '张三', '0');
INSERT INTO `userInfo` VALUES ('6', 'admin', '0');
INSERT INTO `userInfo` VALUES ('7', 'ZZZ', '0');
INSERT INTO `userInfo` VALUES ('8', 'Q123', '0');
INSERT INTO `userInfo` VALUES ('9', 'Q宝', '0');
