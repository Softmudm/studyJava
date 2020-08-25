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

 Date: 25/08/2020 20:54:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_score_detail
-- ----------------------------
DROP TABLE IF EXISTS `exam_score_detail`;
CREATE TABLE `exam_score_detail`  (
  `detailId` int(10) NOT NULL AUTO_INCREMENT COMMENT '成绩详情表ID，主键，自增长',
  `scoreId` int(10) NULL DEFAULT NULL COMMENT '成绩ID，外键',
  `eId` int(10) NULL DEFAULT NULL COMMENT '试题ID，外键',
  `uAnswer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户答案',
  `upoint` int(4) NULL DEFAULT NULL COMMENT '该题实际得分',
  PRIMARY KEY (`detailId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_score_detail
-- ----------------------------
INSERT INTO `exam_score_detail` VALUES (79, 12, 27, '2', 10);
INSERT INTO `exam_score_detail` VALUES (80, 12, 28, '4', 10);
INSERT INTO `exam_score_detail` VALUES (81, 12, 29, '错误', 10);
INSERT INTO `exam_score_detail` VALUES (82, 12, 30, '错误', 0);
INSERT INTO `exam_score_detail` VALUES (83, 12, 31, 'b', 10);
INSERT INTO `exam_score_detail` VALUES (84, 12, 32, 'c', 10);
INSERT INTO `exam_score_detail` VALUES (85, 12, 33, 'ab', 5);
INSERT INTO `exam_score_detail` VALUES (86, 12, 34, 'ab', 10);
INSERT INTO `exam_score_detail` VALUES (87, 12, 35, '好玩', 10);
INSERT INTO `exam_score_detail` VALUES (88, 12, 36, '难', 5);
INSERT INTO `exam_score_detail` VALUES (89, 13, 27, '2', 10);
INSERT INTO `exam_score_detail` VALUES (90, 13, 28, '2', 0);
INSERT INTO `exam_score_detail` VALUES (91, 13, 29, '正确', 0);
INSERT INTO `exam_score_detail` VALUES (92, 13, 30, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (93, 13, 31, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (94, 13, 32, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (95, 13, 33, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (96, 13, 34, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (97, 13, 35, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (98, 13, 36, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (99, 14, 27, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (100, 14, 28, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (101, 14, 29, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (102, 14, 30, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (103, 14, 31, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (104, 14, 32, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (105, 14, 33, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (106, 14, 34, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (107, 14, 35, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (108, 14, 36, NULL, 0);
INSERT INTO `exam_score_detail` VALUES (109, 15, 27, '2', 10);
INSERT INTO `exam_score_detail` VALUES (110, 15, 28, '4', 10);
INSERT INTO `exam_score_detail` VALUES (111, 15, 29, '错误', 10);
INSERT INTO `exam_score_detail` VALUES (112, 15, 30, '正确', 10);
INSERT INTO `exam_score_detail` VALUES (113, 15, 31, 'b', 10);
INSERT INTO `exam_score_detail` VALUES (114, 15, 32, 'c', 10);
INSERT INTO `exam_score_detail` VALUES (115, 15, 33, 'abc', 10);
INSERT INTO `exam_score_detail` VALUES (116, 15, 34, 'ab', 10);
INSERT INTO `exam_score_detail` VALUES (117, 15, 35, '好玩', 10);
INSERT INTO `exam_score_detail` VALUES (118, 15, 36, '不难', 10);
INSERT INTO `exam_score_detail` VALUES (119, 16, 27, '111', 0);
INSERT INTO `exam_score_detail` VALUES (120, 16, 28, '111', 0);
INSERT INTO `exam_score_detail` VALUES (121, 16, 29, '正确', 0);
INSERT INTO `exam_score_detail` VALUES (122, 16, 30, '正确', 10);
INSERT INTO `exam_score_detail` VALUES (123, 16, 31, 'b', 10);
INSERT INTO `exam_score_detail` VALUES (124, 16, 32, 'a', 0);
INSERT INTO `exam_score_detail` VALUES (125, 16, 33, 'ab', 5);
INSERT INTO `exam_score_detail` VALUES (126, 16, 34, 'a', 5);
INSERT INTO `exam_score_detail` VALUES (127, 16, 35, '1', 0);
INSERT INTO `exam_score_detail` VALUES (128, 16, 36, '1', 0);

SET FOREIGN_KEY_CHECKS = 1;
