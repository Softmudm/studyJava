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

 Date: 25/08/2020 20:54:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_score
-- ----------------------------
DROP TABLE IF EXISTS `exam_score`;
CREATE TABLE `exam_score`  (
  `scoreId` int(10) NOT NULL AUTO_INCREMENT COMMENT '成绩ID，主键，自增长',
  `userId` int(10) NULL DEFAULT NULL COMMENT '用户ID，外键',
  `paperId` int(10) NULL DEFAULT NULL COMMENT '试卷ID，外键',
  `score` int(4) NULL DEFAULT NULL COMMENT '分数',
  `rights` int(4) NULL DEFAULT NULL COMMENT '答对题数',
  `errors` int(4) NULL DEFAULT NULL COMMENT '答错题数',
  PRIMARY KEY (`scoreId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_score
-- ----------------------------
INSERT INTO `exam_score` VALUES (12, 1, 1, 80, 7, 3);
INSERT INTO `exam_score` VALUES (13, 1, 1, 10, 1, 9);
INSERT INTO `exam_score` VALUES (14, 1, 1, 0, 0, 10);
INSERT INTO `exam_score` VALUES (15, 2, 1, 100, 10, 0);
INSERT INTO `exam_score` VALUES (16, 4, 1, 30, 2, 8);

SET FOREIGN_KEY_CHECKS = 1;
