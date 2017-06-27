/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sample

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-27 10:19:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_sample`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sample`;
CREATE TABLE `tb_sample` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_user_id` varchar(100) DEFAULT NULL COMMENT '创建用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(100) DEFAULT NULL COMMENT '修改用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sample
-- ----------------------------
INSERT INTO `tb_sample` VALUES ('1', 'qqq', '2017-05-11 17:55:00', null, null, '1');
INSERT INTO `tb_sample` VALUES ('2', 'qqq', '2017-05-11 17:57:12', null, '2017-05-12 11:31:41', '38');
INSERT INTO `tb_sample` VALUES ('3', 'qqq', '2017-05-11 18:05:28', 'User_6', '2017-05-12 11:37:04', '89');
INSERT INTO `tb_sample` VALUES ('6', 'User_1', '2017-05-12 09:08:02', null, null, '0');
INSERT INTO `tb_sample` VALUES ('8', 'User_1', '2017-05-12 09:13:53', null, '2017-05-12 11:35:25', '7');
INSERT INTO `tb_sample` VALUES ('10', 'User_0', '2017-05-12 09:14:39', null, null, '0');
INSERT INTO `tb_sample` VALUES ('12', 'User_1', '2017-05-12 09:14:39', null, null, '0');
INSERT INTO `tb_sample` VALUES ('13', 'User_1', '2017-05-12 09:21:57', null, null, '83');
INSERT INTO `tb_sample` VALUES ('14', 'User_2', '2017-05-12 09:21:57', null, null, '1');
INSERT INTO `tb_sample` VALUES ('16', 'User_0', '2017-05-12 09:22:54', null, null, '1');
INSERT INTO `tb_sample` VALUES ('17', 'User_2', '2017-05-12 09:22:54', null, null, '3');
INSERT INTO `tb_sample` VALUES ('18', 'User_0', '2017-05-12 09:22:54', null, null, '2');
INSERT INTO `tb_sample` VALUES ('20', 'User_2', '2017-05-12 09:24:35', null, null, '0');
INSERT INTO `tb_sample` VALUES ('21', 'User_1', '2017-05-12 09:24:35', null, null, '3');
INSERT INTO `tb_sample` VALUES ('24', 'User_1', '2017-05-12 10:08:06', null, null, '1');
INSERT INTO `tb_sample` VALUES ('25', 'User_1', '2017-05-12 10:08:06', null, '2017-05-12 12:04:47', '81');
INSERT INTO `tb_sample` VALUES ('26', 'User_1', '2017-05-12 10:08:06', null, null, '1');
INSERT INTO `tb_sample` VALUES ('27', 'User_1', '2017-05-12 10:11:23', null, null, '1');
INSERT INTO `tb_sample` VALUES ('28', 'User_0', '2017-05-12 10:11:23', null, null, '1');
INSERT INTO `tb_sample` VALUES ('29', 'User_2', '2017-05-12 10:11:23', null, null, '2');
INSERT INTO `tb_sample` VALUES ('30', 'User_1', '2017-05-12 10:11:23', null, null, '1');
INSERT INTO `tb_sample` VALUES ('31', 'User_1', '2017-05-12 10:11:23', 'User_4', '2017-05-12 12:04:47', '27');
INSERT INTO `tb_sample` VALUES ('32', 'User_2', '2017-05-12 10:11:23', null, null, '0');
INSERT INTO `tb_sample` VALUES ('35', 'User_1', '2017-05-12 10:13:17', null, null, '0');
INSERT INTO `tb_sample` VALUES ('36', 'User_2', '2017-05-12 10:13:17', null, null, '0');
INSERT INTO `tb_sample` VALUES ('38', 'User_1', '2017-05-12 10:13:17', null, null, '1');
INSERT INTO `tb_sample` VALUES ('39', 'User_2', '2017-05-12 10:13:17', null, null, '1');
INSERT INTO `tb_sample` VALUES ('40', 'User_0', '2017-05-12 10:13:17', null, null, '3');
INSERT INTO `tb_sample` VALUES ('41', 'User_1', '2017-05-12 10:13:55', null, null, '2');
INSERT INTO `tb_sample` VALUES ('42', 'User_1', '2017-05-12 10:13:55', null, null, '3');
INSERT INTO `tb_sample` VALUES ('45', 'User_1', '2017-05-12 10:13:55', null, null, '0');
INSERT INTO `tb_sample` VALUES ('46', 'User_2', '2017-05-12 10:13:55', null, '2017-05-12 11:31:41', '71');
INSERT INTO `tb_sample` VALUES ('47', 'User_2', '2017-05-12 10:13:55', null, null, '0');
INSERT INTO `tb_sample` VALUES ('49', 'User_1', '2017-05-12 10:25:06', null, null, '1');
INSERT INTO `tb_sample` VALUES ('50', 'User_1', '2017-05-12 10:25:06', null, '2017-05-12 12:00:28', '16');
INSERT INTO `tb_sample` VALUES ('51', 'User_0', '2017-05-12 10:25:06', null, null, '2');
INSERT INTO `tb_sample` VALUES ('52', 'User_0', '2017-05-12 10:25:06', null, '2017-05-12 12:00:28', '33');
INSERT INTO `tb_sample` VALUES ('53', 'User_0', '2017-05-12 10:25:06', null, null, '3');
INSERT INTO `tb_sample` VALUES ('55', 'User_0', '2017-05-12 10:27:44', null, null, '0');
INSERT INTO `tb_sample` VALUES ('56', 'User_2', '2017-05-12 10:27:44', null, '2017-05-12 11:37:04', '41');
INSERT INTO `tb_sample` VALUES ('58', 'User_2', '2017-05-12 10:27:44', null, null, '2');
INSERT INTO `tb_sample` VALUES ('59', 'User_0', '2017-05-12 10:27:44', null, null, '3');
INSERT INTO `tb_sample` VALUES ('60', 'User_1', '2017-05-12 10:27:44', null, '2017-05-12 11:37:04', '98');
INSERT INTO `tb_sample` VALUES ('61', 'User_0', '2017-05-12 10:27:44', null, null, '0');
INSERT INTO `tb_sample` VALUES ('62', 'User_0', '2017-05-12 10:27:44', null, null, '0');
INSERT INTO `tb_sample` VALUES ('64', 'User_2', '2017-05-12 10:33:42', null, null, '1');
INSERT INTO `tb_sample` VALUES ('65', 'User_0', '2017-05-12 10:33:42', null, null, '0');
INSERT INTO `tb_sample` VALUES ('67', 'User_0', '2017-05-12 10:33:42', null, null, '2');
INSERT INTO `tb_sample` VALUES ('68', 'User_1', '2017-05-12 10:33:42', null, null, '2');
INSERT INTO `tb_sample` VALUES ('70', 'User_1', '2017-05-12 10:33:42', null, null, '1');
INSERT INTO `tb_sample` VALUES ('71', 'User_2', '2017-05-12 10:33:42', null, null, '2');
INSERT INTO `tb_sample` VALUES ('72', 'User_1', '2017-05-12 10:33:42', 'User_7', '2017-05-12 11:35:25', '2');
INSERT INTO `tb_sample` VALUES ('73', 'User_2', '2017-05-12 10:33:42', null, null, '1');
INSERT INTO `tb_sample` VALUES ('74', 'User_2', '2017-05-12 10:33:42', null, null, '2');
INSERT INTO `tb_sample` VALUES ('75', 'User_0', '2017-05-12 10:36:58', null, null, '1');
INSERT INTO `tb_sample` VALUES ('77', 'User_2', '2017-05-12 10:36:58', null, null, '3');
INSERT INTO `tb_sample` VALUES ('78', 'User_0', '2017-05-12 10:36:58', 'User_7', '2017-05-12 12:04:47', '64');
INSERT INTO `tb_sample` VALUES ('79', 'User_1', '2017-05-12 10:36:58', null, null, '0');
INSERT INTO `tb_sample` VALUES ('80', 'User_0', '2017-05-12 10:36:58', null, null, '0');
INSERT INTO `tb_sample` VALUES ('81', 'User_2', '2017-05-12 10:36:58', null, null, '2');
INSERT INTO `tb_sample` VALUES ('82', 'User_1', '2017-05-12 10:36:58', null, null, '3');
INSERT INTO `tb_sample` VALUES ('83', 'User_2', '2017-05-12 10:36:58', null, null, '2');
INSERT INTO `tb_sample` VALUES ('84', 'User_2', '2017-05-12 10:36:59', null, null, '29');
INSERT INTO `tb_sample` VALUES ('85', 'User_0', '2017-05-12 10:36:59', null, null, '2');
INSERT INTO `tb_sample` VALUES ('87', 'User_0', '2017-05-12 10:46:23', null, '2017-06-20 20:04:40', '16');
INSERT INTO `tb_sample` VALUES ('88', 'User_0', '2017-05-12 10:46:23', null, null, '3');
INSERT INTO `tb_sample` VALUES ('90', 'User_2', '2017-05-12 10:46:23', null, null, '2');
INSERT INTO `tb_sample` VALUES ('92', 'User_1', '2017-05-12 10:46:23', null, null, '0');
INSERT INTO `tb_sample` VALUES ('94', 'User_1', '2017-05-12 10:46:23', 'User_4', '2017-05-12 12:00:28', '44');
INSERT INTO `tb_sample` VALUES ('95', 'User_2', '2017-05-12 10:46:23', null, null, '1');
INSERT INTO `tb_sample` VALUES ('96', 'User_2', '2017-05-12 10:46:23', null, '2017-06-20 20:04:41', '50');
INSERT INTO `tb_sample` VALUES ('97', 'User_0', '2017-05-12 11:19:49', 'User_0', '2017-06-20 20:04:41', '23');
INSERT INTO `tb_sample` VALUES ('98', 'User_1', '2017-05-12 11:19:49', null, null, '3');
INSERT INTO `tb_sample` VALUES ('99', 'User_0', '2017-05-12 11:19:49', null, null, '2');
INSERT INTO `tb_sample` VALUES ('100', 'User_0', '2017-05-12 11:19:49', null, null, '0');
INSERT INTO `tb_sample` VALUES ('103', 'User_0', '2017-05-12 11:19:50', null, null, '0');
INSERT INTO `tb_sample` VALUES ('104', 'User_1', '2017-05-12 11:19:50', null, null, '3');
INSERT INTO `tb_sample` VALUES ('105', 'User_1', '2017-05-12 11:19:50', null, null, '0');
INSERT INTO `tb_sample` VALUES ('106', 'User_0', '2017-05-12 11:19:50', null, null, '1');
INSERT INTO `tb_sample` VALUES ('108', 'User_1', '2017-05-12 11:24:47', null, null, '2');
INSERT INTO `tb_sample` VALUES ('111', 'User_2', '2017-05-12 11:24:47', null, null, '2');
INSERT INTO `tb_sample` VALUES ('113', 'User_2', '2017-05-12 11:24:47', null, null, '0');
INSERT INTO `tb_sample` VALUES ('114', 'User_0', '2017-05-12 11:24:47', null, null, '3');
INSERT INTO `tb_sample` VALUES ('116', 'User_1', '2017-05-12 11:24:47', null, null, '3');
INSERT INTO `tb_sample` VALUES ('117', 'User_2', '2017-05-12 11:24:47', null, null, '1');
INSERT INTO `tb_sample` VALUES ('120', 'User_1', '2017-05-12 11:31:41', null, null, '0');
INSERT INTO `tb_sample` VALUES ('121', 'User_1', '2017-05-12 11:31:41', null, null, '0');
INSERT INTO `tb_sample` VALUES ('124', 'User_2', '2017-05-12 11:31:41', null, null, '0');
INSERT INTO `tb_sample` VALUES ('125', 'User_1', '2017-05-12 11:31:41', null, null, '0');
INSERT INTO `tb_sample` VALUES ('126', 'User_1', '2017-05-12 11:31:41', null, null, '2');
INSERT INTO `tb_sample` VALUES ('127', 'User_0', '2017-05-12 11:31:41', null, null, '2');
INSERT INTO `tb_sample` VALUES ('128', 'User_0', '2017-05-12 11:31:41', null, null, '0');
INSERT INTO `tb_sample` VALUES ('129', 'User_2', '2017-05-12 11:31:41', null, null, '1');
INSERT INTO `tb_sample` VALUES ('130', 'User_1', '2017-05-12 11:35:25', null, null, '3');
INSERT INTO `tb_sample` VALUES ('131', 'User_1', '2017-05-12 11:35:25', null, null, '3');
INSERT INTO `tb_sample` VALUES ('132', 'User_2', '2017-05-12 11:35:25', null, null, '2');
INSERT INTO `tb_sample` VALUES ('133', 'User_1', '2017-05-12 11:35:25', null, null, '1');
INSERT INTO `tb_sample` VALUES ('134', 'User_1', '2017-05-12 11:35:25', null, null, '1');
INSERT INTO `tb_sample` VALUES ('135', 'User_0', '2017-05-12 11:35:25', null, null, '1');
INSERT INTO `tb_sample` VALUES ('136', 'User_1', '2017-05-12 11:35:25', null, null, '2');
INSERT INTO `tb_sample` VALUES ('137', 'User_0', '2017-05-12 11:35:25', null, null, '0');
INSERT INTO `tb_sample` VALUES ('140', 'User_1', '2017-05-12 11:35:25', null, null, '1');
INSERT INTO `tb_sample` VALUES ('142', 'User_2', '2017-05-12 11:37:04', null, null, '0');
INSERT INTO `tb_sample` VALUES ('145', 'User_2', '2017-05-12 11:37:04', null, null, '3');
INSERT INTO `tb_sample` VALUES ('147', 'User_2', '2017-05-12 11:37:04', null, null, '3');
INSERT INTO `tb_sample` VALUES ('148', 'User_2', '2017-05-12 11:37:04', null, null, '2');
INSERT INTO `tb_sample` VALUES ('149', 'User_2', '2017-05-12 11:37:04', null, null, '2');
INSERT INTO `tb_sample` VALUES ('151', 'User_2', '2017-05-12 11:37:04', null, null, '1');
INSERT INTO `tb_sample` VALUES ('152', 'User_1', '2017-05-12 12:00:28', null, null, '3');
INSERT INTO `tb_sample` VALUES ('153', 'User_1', '2017-05-12 12:00:28', null, null, '1');
INSERT INTO `tb_sample` VALUES ('154', 'User_0', '2017-05-12 12:00:28', null, null, '3');
INSERT INTO `tb_sample` VALUES ('156', 'User_1', '2017-05-12 12:00:28', null, null, '0');
INSERT INTO `tb_sample` VALUES ('157', 'User_1', '2017-05-12 12:00:28', null, null, '2');
INSERT INTO `tb_sample` VALUES ('158', 'User_0', '2017-05-12 12:00:28', null, null, '1');
INSERT INTO `tb_sample` VALUES ('159', 'User_1', '2017-05-12 12:00:28', null, null, '2');
INSERT INTO `tb_sample` VALUES ('160', 'User_1', '2017-05-12 12:00:28', null, null, '2');
INSERT INTO `tb_sample` VALUES ('161', 'User_1', '2017-05-12 12:00:28', null, null, '2');
INSERT INTO `tb_sample` VALUES ('163', 'User_2', '2017-05-12 12:04:47', null, null, '0');
INSERT INTO `tb_sample` VALUES ('164', 'User_2', '2017-05-12 12:04:47', null, null, '0');
INSERT INTO `tb_sample` VALUES ('165', 'User_2', '2017-05-12 12:04:47', null, null, '1');
INSERT INTO `tb_sample` VALUES ('167', 'User_1', '2017-05-12 12:04:47', null, null, '2');
INSERT INTO `tb_sample` VALUES ('168', 'User_1', '2017-05-12 12:04:47', null, null, '3');
INSERT INTO `tb_sample` VALUES ('169', 'User_2', '2017-05-12 12:04:47', null, null, '1');
INSERT INTO `tb_sample` VALUES ('170', 'User_0', '2017-05-12 12:04:47', null, null, '0');
INSERT INTO `tb_sample` VALUES ('171', 'User_2', '2017-05-12 12:04:47', null, null, '1');
INSERT INTO `tb_sample` VALUES ('172', 'User_1', '2017-05-12 12:04:47', null, null, '3');
INSERT INTO `tb_sample` VALUES ('173', 'User_2', '2017-05-12 12:04:47', null, null, '3');
INSERT INTO `tb_sample` VALUES ('174', 'User_2', '2017-06-20 20:04:40', null, null, '2');
INSERT INTO `tb_sample` VALUES ('175', 'User_2', '2017-06-20 20:04:40', null, null, '3');
INSERT INTO `tb_sample` VALUES ('176', 'User_1', '2017-06-20 20:04:40', null, null, '2');
INSERT INTO `tb_sample` VALUES ('177', 'User_1', '2017-06-20 20:04:40', null, null, '3');
INSERT INTO `tb_sample` VALUES ('178', 'User_0', '2017-06-20 20:04:40', null, null, '3');
INSERT INTO `tb_sample` VALUES ('179', 'User_2', '2017-06-20 20:04:40', null, null, '1');
INSERT INTO `tb_sample` VALUES ('181', 'User_2', '2017-06-20 20:04:40', null, null, '0');
INSERT INTO `tb_sample` VALUES ('182', 'User_1', '2017-06-20 20:04:40', null, null, '3');
INSERT INTO `tb_sample` VALUES ('183', 'User_1', '2017-06-20 20:04:40', null, null, '2');
