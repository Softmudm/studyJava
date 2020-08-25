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

 Date: 25/08/2020 20:53:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper`  (
  `paperId` int(10) NOT NULL AUTO_INCREMENT COMMENT '试卷ID，主键，自增长',
  `paperName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `paperType` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT 'java' COMMENT '试卷类型:默认为java',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '自动阅卷' COMMENT '阅卷方式:默认自动阅卷',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '试卷总分',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建试卷日期',
  PRIMARY KEY (`paperId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES (1, '小学加法', '数学', '自动阅卷', '100', '2020-08-20 10:54:23');
INSERT INTO `exam_paper` VALUES (2, '小学减法', '数学', '自动阅卷', '100', '2020-08-10 17:57:15');
INSERT INTO `exam_paper` VALUES (3, '小学乘法', '数学', '自动阅卷', '100', '2020-08-03 18:00:04');
INSERT INTO `exam_paper` VALUES (4, '小学除法', '数学', '自动阅卷', '100', '2020-08-18 18:00:23');

SET FOREIGN_KEY_CHECKS = 1;
