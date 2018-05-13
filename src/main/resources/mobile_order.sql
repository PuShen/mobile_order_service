/*
Navicat MySQL Data Transfer

Source Server         : 云数据库
Source Server Version : 50718
Source Host           : rm-bp10ix261s5m171demo.mysql.rds.aliyuncs.com:3306
Source Database       : mobile_order

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-05-13 12:23:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `deskno`
-- ----------------------------
DROP TABLE IF EXISTS `deskno`;
CREATE TABLE `deskno` (
  `restaurant` varchar(50) NOT NULL,
  `no` varchar(5) NOT NULL,
  `capacity` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`restaurant`,`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deskno
-- ----------------------------
INSERT INTO `deskno` VALUES ('麦家小馆', '101', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '102', '6');
INSERT INTO `deskno` VALUES ('麦家小馆', '103', '6');
INSERT INTO `deskno` VALUES ('麦家小馆', '104', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '105', '2');
INSERT INTO `deskno` VALUES ('麦家小馆', '106', '2');
INSERT INTO `deskno` VALUES ('麦家小馆', '107', '8');
INSERT INTO `deskno` VALUES ('麦家小馆', '108', '8');
INSERT INTO `deskno` VALUES ('麦家小馆', '109', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '110', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '111', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '112', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '113', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '114', '4');
INSERT INTO `deskno` VALUES ('麦家小馆', '115', '6');
INSERT INTO `deskno` VALUES ('麦家小馆', '116', '2');
INSERT INTO `deskno` VALUES ('麦家小馆', '117', '5');

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `imageUrl` varchar(100) DEFAULT NULL,
  `practice` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `number` int(11) NOT NULL,
  `labelId` varchar(100) NOT NULL,
  `restaurant` varchar(50) NOT NULL,
  `vareCount` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`name`,`restaurant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('-1710234274', '小炒肉', '/1515155095350.jpg', '微辣，中辣，特辣', '农家小吃', '15', '0', '-1463006431', '麦家小馆', '0');
INSERT INTO `food` VALUES ('91146007', '招牌削面', '/1521866100548.jpg', '微辣，中辣，特辣', '招牌菜', '18', '3', '-1480708097', '麦家小馆', '0');
INSERT INTO `food` VALUES ('2106192644', '炸鲜奶（简单，健康）', '/1515599454010.jpg', '', '', '22', '62', '-1480708097', '麦家小馆', '0');
INSERT INTO `food` VALUES ('-1769726530', '牛羊肉泡馍', '/1521866239437.jpg', '微辣，中辣，特辣', '推荐菜', '32', '49', '-1664226687', '麦家小馆', '0');
INSERT INTO `food` VALUES ('1493725946', '秘制红烧鸡爪', '/1515773555307.jpg', '', '其实做起来也很简单，和我们平时做卤味差不多的过程，只是我自己琢磨着添加了一样秘密武器--半茶匙的十三香，有了它的加入，鸡爪的味道瞬间就提升了，点睛就是它啦！', '30', '83', '-1852059050', '麦家小馆', '0');
INSERT INTO `food` VALUES ('2104042881', '红烧肉沫茄子', '/1515417961481.jpg', '少油，多肉', '米饭杀手，绝对够味，喜欢茄子的人都懂得！茄子是一道离不开油的菜，离开油做不出那个感觉的，所以我要么不做茄子，要么肯定过油，这也是餐厅里厨师们一贯做法！', '16', '29', '-1852059050', '麦家小馆', '0');
INSERT INTO `food` VALUES ('395004695', '考尖椒', '/1521866348757.jpg', '火候大点，少油，不要味精', '慎重点菜', '4', '92', '1909402169', '麦家小馆', '0');
INSERT INTO `food` VALUES ('-568646221', '蒜蓉蒸金针菇', '/1516420588310.jpg', '加葱花', '金针菇的口感是独特的，韧中带脆，配合我独家的蒜蓉酱一起蒸来吃，马上变成简单的美味!', '24', '20', '-1463006431', '麦家小馆', '0');
INSERT INTO `food` VALUES ('-1074099682', '鱼豆腐', '/1521866411638.jpg', '微辣，中辣，特辣', '特色菜', '4', '78', '-1480708097', '麦家小馆', '0');
INSERT INTO `food` VALUES ('-569512831', '黄焖鸡米饭', '/1515081035909.jpg', '微辣，中辣，特辣', '特色小吃', '18', '7', '-1463006431', '麦家小馆', '0');

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` varchar(100) NOT NULL,
  `labelName` varchar(50) NOT NULL,
  `restaurant` varchar(255) NOT NULL,
  `bannerUrl` varchar(100) NOT NULL,
  `bannerId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('-1463006431', '热销', '麦家小馆', '/banner1.png', '-1463006431');
INSERT INTO `label` VALUES ('-1480708097', '新品', '麦家小馆', '/banner2.png', '-1480708097');
INSERT INTO `label` VALUES ('-1664226687', '饮品', '麦家小馆', '/banner2.png', '-1664226687');
INSERT INTO `label` VALUES ('-1852059050', '推荐', '麦家小馆', '/banner1.png', '-1852059050');
INSERT INTO `label` VALUES ('1909402169', '折扣', '麦家小馆', '/banner2.png', '1909402169');

-- ----------------------------
-- Table structure for `order_details`
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `name` varchar(50) NOT NULL,
  `no` varchar(5) NOT NULL,
  `practice` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `totalPrice` double NOT NULL,
  `time` datetime NOT NULL,
  `restaurant` varchar(50) NOT NULL,
  PRIMARY KEY (`no`,`name`,`time`,`restaurant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_details
-- ----------------------------
INSERT INTO `order_details` VALUES ('招牌削面', '101', '微辣，中辣，特辣', '4', '72', '2018-04-28 18:57:46', '麦家小馆');
INSERT INTO `order_details` VALUES ('炸鲜奶（简单，健康）', '101', '', '4', '88', '2018-04-29 12:33:56', '麦家小馆');
INSERT INTO `order_details` VALUES ('秘制红烧鸡爪', '101', '', '2', '60', '2018-04-28 21:40:13', '麦家小馆');
INSERT INTO `order_details` VALUES ('红烧肉沫茄子', '101', '少油，多肉', '3', '48', '2018-04-28 21:40:13', '麦家小馆');
INSERT INTO `order_details` VALUES ('红烧肉沫茄子', '101', '少油，多肉', '1', '16', '2018-04-29 12:33:56', '麦家小馆');
INSERT INTO `order_details` VALUES ('鱼豆腐', '101', '微辣，中辣，特辣', '9', '36', '2018-04-29 12:33:56', '麦家小馆');
INSERT INTO `order_details` VALUES ('招牌削面', '106', '微辣', '1', '18', '2017-12-31 17:47:05', '麦家小馆');
INSERT INTO `order_details` VALUES ('秘制红烧鸡爪', '106', '', '1', '30', '2018-05-11 10:03:14', '麦家小馆');
INSERT INTO `order_details` VALUES ('秘制红烧鸡爪', '106', '', '1', '30', '2018-05-11 10:03:58', '麦家小馆');
INSERT INTO `order_details` VALUES ('蒜蓉蒸金针菇', '106', '加葱花', '1', '24', '2018-05-11 10:03:14', '麦家小馆');
INSERT INTO `order_details` VALUES ('蒜蓉蒸金针菇', '106', '加葱花', '1', '24', '2018-05-11 10:03:58', '麦家小馆');
INSERT INTO `order_details` VALUES ('鱼豆腐', '106', '微辣，中辣，特辣', '4', '16', '2018-05-11 10:03:14', '麦家小馆');
INSERT INTO `order_details` VALUES ('鱼豆腐', '106', '微辣，中辣，特辣', '4', '16', '2018-05-11 10:03:58', '麦家小馆');
INSERT INTO `order_details` VALUES ('牛羊肉泡馍', '108', '微辣，中辣，特辣', '1', '32', '2018-05-11 21:45:40', '麦家小馆');
INSERT INTO `order_details` VALUES ('招牌削面', '110', '微辣，中辣，特辣', '1', '18', '2018-04-29 12:36:11', '麦家小馆');
INSERT INTO `order_details` VALUES ('秘制红烧鸡爪', '110', '', '1', '30', '2018-04-29 12:37:32', '麦家小馆');
INSERT INTO `order_details` VALUES ('考尖椒', '110', '火候大点，少油，不要味精', '1', '4', '2018-04-29 12:36:11', '麦家小馆');
INSERT INTO `order_details` VALUES ('鱼豆腐', '110', '微辣，中辣，特辣', '1', '4', '2018-04-29 12:36:11', '麦家小馆');
INSERT INTO `order_details` VALUES ('鱼豆腐', '110', '微辣，中辣，特辣', '4', '16', '2018-04-29 12:37:32', '麦家小馆');
INSERT INTO `order_details` VALUES ('黄焖鸡米饭', '110', '微辣，中辣，特辣', '1', '18', '2018-04-29 12:36:11', '麦家小馆');

-- ----------------------------
-- Table structure for `order_overview`
-- ----------------------------
DROP TABLE IF EXISTS `order_overview`;
CREATE TABLE `order_overview` (
  `no` varchar(5) NOT NULL,
  `totalPrice` double NOT NULL,
  `time` datetime NOT NULL,
  `paymentMethod` varchar(50) DEFAULT NULL,
  `havePaid` char(2) NOT NULL,
  `notes` varchar(255) NOT NULL,
  `restaurant` varchar(50) NOT NULL,
  PRIMARY KEY (`no`,`time`,`restaurant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_overview
-- ----------------------------
INSERT INTO `order_overview` VALUES ('106', '18', '2017-12-31 17:47:05', '支付宝', '是', '少汤', '麦家小馆');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'wxp*03014672');
