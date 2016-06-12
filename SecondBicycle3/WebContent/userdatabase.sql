/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : userdatabase

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2016-06-12 13:42:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orderlist
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `productid` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('26', '1', '欧拜克', '公路车', '2', '300', '600', '欧拜克21速拉风公路自行车越野公路跑车三刀一体轮公路赛车XC550', '宁润');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` int(20) NOT NULL AUTO_INCREMENT,
  `brand` char(10) CHARACTER SET gbk DEFAULT NULL,
  `type` char(10) CHARACTER SET gbk DEFAULT NULL,
  `price` double(10,0) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `other` char(200) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '欧拜克', '公路车', '300', '15616034228', '欧拜克21速拉风公路自行车越野公路跑车三刀一体轮公路赛车XC550');
INSERT INTO `product` VALUES ('2', '捷安特', '山地车', '300', '15616034228', '新款组装捷安特山地自行车21/24/27速26铝合金双碟刹可锁死变速车');
INSERT INTO `product` VALUES ('3', '捷安特', '学生车', '250', '15616034228', '新款捷安特atx山地车自行车铝合金双碟刹21速24速24寸26寸学生车');
INSERT INTO `product` VALUES ('4', '捷安特', '山地车', '359', '13557771813', '组装捷安特山地车自行车 铝合金车架ATX777油刹27变速山地自行车');
INSERT INTO `product` VALUES ('5', '捷安特', '休闲车', '559', '18245369522', '捷安特山地车自行车XTC 铝合金车架ATX777油刹27变速自行车');
INSERT INTO `product` VALUES ('6', '捷安特', '山地车', '559', '18263362554', '捷安特山地车自行车XTC 铝合金车架ATX777油刹27变速山地自行车');
INSERT INTO `product` VALUES ('7', '肖 捷安特', '儿童车', '100', '1356', '肖 捷安特');

-- ----------------------------
-- Table structure for usercart
-- ----------------------------
DROP TABLE IF EXISTS `usercart`;
CREATE TABLE `usercart` (
  `productid` int(20) DEFAULT NULL,
  `num` int(5) DEFAULT NULL,
  `brand` char(20) DEFAULT NULL,
  `type` char(20) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `other` char(200) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercart
-- ----------------------------
INSERT INTO `usercart` VALUES ('3', '2', '捷安特', '山地车', '250', '15616034228', '新款捷安特atx山地车自行车铝合金双碟刹21速24速24寸26寸学生车', '1500', '宁润');
INSERT INTO `usercart` VALUES ('1', '1', '欧拜克', '公路车', '300', '15616034228', '欧拜克21速拉风公路自行车越野公路跑车三刀一体轮公路赛车XC550', '600', '宁润');
INSERT INTO `usercart` VALUES ('2', '2', '捷安特', '山地车', '300', '15616034228', '新款组装捷按特山地自行车21/24/27速26铝合金双碟刹可锁死变速车', '600', '宁润');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `name` char(20) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  `address` char(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('123', '234231', '15616034228', '341232@qq.com', '423');
INSERT INTO `userinfo` VALUES ('ningrun', '123', '15616034228', '222@qq.com', '湖南大学');
INSERT INTO `userinfo` VALUES ('宁润', '12345', '15616034228', '687@sina.com', '湖南大学');
INSERT INTO `userinfo` VALUES ('小红', '12345', '15616034228', '176367137@qq.com', '湖南大学');
INSERT INTO `userinfo` VALUES ('fee', 'edwe34', '15616034228', '4465@qq.com', 'fsd312');
INSERT INTO `userinfo` VALUES ('456465', '43435', '15616034228', '153135@qq.com', '1515');
INSERT INTO `userinfo` VALUES ('423sdfsd', 'feds', '15616034228', '15665@qq.com', '655');
INSERT INTO `userinfo` VALUES ('468453`', '45435', '15616034228', '4653@qq.com', 'fsd32');
