/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : exam01

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 25/08/2020 20:53:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_items
-- ----------------------------
DROP TABLE IF EXISTS `exam_items`;
CREATE TABLE `exam_items`  (
  `eId` int(10) NOT NULL AUTO_INCREMENT COMMENT '试题ID，主键，自增长',
  `eName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '试题题干',
  `ePaperId` int(10) NULL DEFAULT 0 COMMENT '试卷ID，外键',
  `eScore` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '试题应得分',
  `eType` int(10) NULL DEFAULT 0 COMMENT '1.填空；2.判断；3.单选；4.多选；5.问答',
  `eDegree` int(10) NULL DEFAULT 1 COMMENT '试题难易程度，(1-10) 默认为1',
  `ea` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT 'A选项',
  `eb` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT 'B选项',
  `ec` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT 'C选项',
  `ed` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT 'D选项',
  `ee` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT 'E选项',
  `ef` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT 'F选项',
  `eKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '试题答案',
  `eHints` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '略' COMMENT '试题解析',
  PRIMARY KEY (`eId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_items
-- ----------------------------
INSERT INTO `exam_items` VALUES (27, '1+1=', 1, '10', 1, 1, '', '', '', '', '', '', '2', '略');
INSERT INTO `exam_items` VALUES (28, '2+2=', 1, '10', 1, 1, '', '', '', '', '', '', '4', '略');
INSERT INTO `exam_items` VALUES (29, '3+3=5', 1, '10', 2, 1, '', '', '', '', '', '', '错误', '略');
INSERT INTO `exam_items` VALUES (30, '4+4=8', 1, '10', 2, 1, '', '', '', '', '', '', '正确', '略');
INSERT INTO `exam_items` VALUES (31, '1+1=', 1, '10', 3, 1, '1', '2', '3', '4', '', '', 'b', '略');
INSERT INTO `exam_items` VALUES (32, '5+5=', 1, '10', 3, 1, '8', '9', '10', '11', '', '', 'c', '略');
INSERT INTO `exam_items` VALUES (33, '2+2>', 1, '10', 4, 1, '1', '2', '3', '4', '', '', 'abc', '略');
INSERT INTO `exam_items` VALUES (34, '4+5>', 1, '10', 4, 1, '7', '8', '9', '10', '', '', 'ab', '略');
INSERT INTO `exam_items` VALUES (35, '数学好不好玩？', 1, '10', 5, 1, '', '', '', '', '', '', '好玩', '略');
INSERT INTO `exam_items` VALUES (36, '数学难不难？', 1, '10', 5, 1, '', '', '', '', '', '', '不难', '略');

SET FOREIGN_KEY_CHECKS = 1;
