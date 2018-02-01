/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : 192.168.145.100:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 31/01/2018 16:51:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sp_xs_xs
-- ----------------------------
DROP TABLE IF EXISTS `t_sp_xs_xs`;
CREATE TABLE `t_sp_xs_xs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `Xsbh` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生编号',
  `Xsxm` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学生姓名',
  `Sfzx` int(255) NULL DEFAULT NULL COMMENT '是否在校：0、不在校  1、在校',
  `Zgxlm` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '最高学历编码',
  `Zgxlmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '最高学历名称',
  `Gkzf` float(255, 0) NULL DEFAULT NULL COMMENT '高考总分',
  `yx` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '院校',
  `Zy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
  `Nj` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '年级',
  `Bj` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sp_xs_xs
-- ----------------------------
INSERT INTO `t_sp_xs_xs` VALUES (1, '123', '123', 0, '123', '123', 123, '123', '123', '123', '123213214321432143214');
INSERT INTO `t_sp_xs_xs` VALUES (2, 'fdssafdas', 'fdsafdasf', 1, 'fdsaffdsa', 'asfdasf', 123213, '天地传奇', '梗阻', '1天', '123');
INSERT INTO `t_sp_xs_xs` VALUES (3, 'FDA', '地', 1, '123', '123', 123, '123', '123', '1232', '123');
INSERT INTO `t_sp_xs_xs` VALUES (4, '123213abc', '小明', 1, 'fda12321', '你大爷', 200, '家里墩', '玩', '3', '13');

SET FOREIGN_KEY_CHECKS = 1;
