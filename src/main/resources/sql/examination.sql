/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : examination

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 09/04/2019 23:37:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination`  (
  `ExaminationID` int(20) NOT NULL AUTO_INCREMENT,
  `PaperID` int(20) DEFAULT NULL,
  `Subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `BeginTime` datetime(6) DEFAULT NULL,
  `Duration` int(10) DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CreateUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ExaminationID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for examinationpaper
-- ----------------------------
DROP TABLE IF EXISTS `examinationpaper`;
CREATE TABLE `examinationpaper`  (
  `PaperID` int(20) NOT NULL AUTO_INCREMENT,
  `QuestionIds` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SAQIds` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SelectNum` int(10) DEFAULT NULL,
  `SAQNum` int(10) DEFAULT NULL,
  `Score` int(10) DEFAULT NULL,
  `Subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CreateUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TotalSelect` int(10) DEFAULT NULL,
  `TotalSAQ` int(10) DEFAULT NULL,
  `SelectScore` int(10) DEFAULT NULL,
  `SAQScore` int(10) DEFAULT NULL,
  PRIMARY KEY (`PaperID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examinationpaper
-- ----------------------------
INSERT INTO `examinationpaper` VALUES (7, '1', '1', '1', 2, 2, 100, '语文', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `examinationpaper` VALUES (8, '1,6', '2', '1,4', 2, 2, NULL, '语文', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `examinationpaper` VALUES (10, '1,6', '语文试卷', '1,5', 3, 2, 100, '语文', 'admin', NULL, NULL, NULL, NULL);
INSERT INTO `examinationpaper` VALUES (11, '1,6,9', '1', '1,5', 3, 2, 100, '语文', 'admin', NULL, NULL, NULL, NULL);
INSERT INTO `examinationpaper` VALUES (12, '9', '3', '1,5,8', 1, 3, 100, '语文', 'admin', 3, 2, 20, 20);

-- ----------------------------
-- Table structure for saq
-- ----------------------------
DROP TABLE IF EXISTS `saq`;
CREATE TABLE `saq`  (
  `SAQID` int(20) NOT NULL AUTO_INCREMENT,
  `Question` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Chapter` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Difficulty` int(10) DEFAULT NULL COMMENT '1-	easy\r\n2-	normal\r\n3-	hard\r\n',
  `CreateUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Answer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`SAQID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of saq
-- ----------------------------
INSERT INTO `saq` VALUES (1, '简单题一', '语文', '第一章', 2, 'admin', NULL);
INSERT INTO `saq` VALUES (2, '简答题二', '历史', '第三章', 1, '', '参考答案');
INSERT INTO `saq` VALUES (5, '2', '语文', '第二章', NULL, NULL, NULL);
INSERT INTO `saq` VALUES (6, '3', '语文', '第一章', 1, 'admin', '3');
INSERT INTO `saq` VALUES (7, '4', '语文', '第二章', 1, 'admin', '4');
INSERT INTO `saq` VALUES (8, '判断题一', '语文', '第一章', 2, 'admin', '是');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PaperID` int(20) DEFAULT NULL,
  `Subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SelectAnswer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SAQAnswer` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Score` int(10) DEFAULT NULL,
  PRIMARY KEY (`Name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for singleselect
-- ----------------------------
DROP TABLE IF EXISTS `singleselect`;
CREATE TABLE `singleselect`  (
  `QuestionID` int(20) NOT NULL AUTO_INCREMENT,
  `Question` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ChoiceOne` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ChoiceTwo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ChoiceThree` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ChoiceFour` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Answer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Subject` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Chapter` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Difficulty` int(10) NOT NULL COMMENT '1-easy  2-normal  3-hard',
  `CreateUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`QuestionID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of singleselect
-- ----------------------------
INSERT INTO `singleselect` VALUES (1, '例二', '选项一', '选项二', '选项三', '选项四', '选项一', '语文', '第一章', 1, '教师');
INSERT INTO `singleselect` VALUES (4, '题目三', '选项一', '选项二', '选项三', '选项四', '选项一', '历史', '第一章', 2, 'admin');
INSERT INTO `singleselect` VALUES (6, '2', '1', '2', '3', '4', NULL, '语文', '第三章', 2, NULL);
INSERT INTO `singleselect` VALUES (7, '3', '1', '', '2', '4', NULL, '语文', '第二章', 1, NULL);
INSERT INTO `singleselect` VALUES (8, '1', '1', '1', '1', '1', '1', '语文', '第二章', 2, NULL);
INSERT INTO `singleselect` VALUES (9, '4', '1', '2', '3', '4', '2', '语文', '第三章', 1, 'admin');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `UserID` int(10) NOT NULL AUTO_INCREMENT,
  `UserCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`UserID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '123456', '管理员');
INSERT INTO `user` VALUES (2, '201901', '李丽', '12345', '学生');
INSERT INTO `user` VALUES (3, '201902', '李玲', '12345', '学生');
INSERT INTO `user` VALUES (4, '1201901', '王敏', '12345', '教师');
INSERT INTO `user` VALUES (5, '1201902', '黄亮', '12345', '教师');
INSERT INTO `user` VALUES (14, '201904', '杨建军', '123456', '教师');
INSERT INTO `user` VALUES (18, '2201904', '王浩', 'Qw123456', '教师');

SET FOREIGN_KEY_CHECKS = 1;
