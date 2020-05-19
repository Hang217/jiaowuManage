/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : jiaowumanage

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 26/06/2019 11:23:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'dfsdfsadf',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, 'java11班', '0', 0);
INSERT INTO `classes` VALUES (2, 'Java2班', '1', 0);
INSERT INTO `classes` VALUES (3, 'UI一班', '1', 0);
INSERT INTO `classes` VALUES (4, 'UI二班', '1', 0);
INSERT INTO `classes` VALUES (5, 'Java高级班', '0', 0);
INSERT INTO `classes` VALUES (6, '6', '1', 0);
INSERT INTO `classes` VALUES (15, '软件工程4班', '0', NULL);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `shenhe` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '模拟电路', '1', 1);
INSERT INTO `course` VALUES (5, '线性代数', '0', 1);
INSERT INTO `course` VALUES (7, 'Java', '1', 1);
INSERT INTO `course` VALUES (8, 'c#', '1', 1);
INSERT INTO `course` VALUES (9, 'java基础', '0', 1);
INSERT INTO `course` VALUES (10, '毛泽东思想', '1', 1);
INSERT INTO `course` VALUES (11, 'web课程12', '0', 1);
INSERT INTO `course` VALUES (12, '面向对象', '0', 1);
INSERT INTO `course` VALUES (13, '数据库设计与实现', '0', 1);
INSERT INTO `course` VALUES (14, '操作系统', '0', NULL);

-- ----------------------------
-- Table structure for ctc
-- ----------------------------
DROP TABLE IF EXISTS `ctc`;
CREATE TABLE `ctc`  (
  `couid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `claid` int(11) NOT NULL,
  PRIMARY KEY (`couid`, `tid`, `claid`) USING BTREE,
  INDEX `tid`(`tid`) USING BTREE,
  INDEX `claid`(`claid`) USING BTREE,
  INDEX `couid`(`couid`) USING BTREE,
  CONSTRAINT `claid` FOREIGN KEY (`claid`) REFERENCES `classes` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `couid` FOREIGN KEY (`couid`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ctc
-- ----------------------------
INSERT INTO `ctc` VALUES (1, 1, 2);
INSERT INTO `ctc` VALUES (1, 1, 3);
INSERT INTO `ctc` VALUES (1, 1, 4);
INSERT INTO `ctc` VALUES (1, 1, 5);
INSERT INTO `ctc` VALUES (5, 1, 1);
INSERT INTO `ctc` VALUES (5, 1, 2);
INSERT INTO `ctc` VALUES (5, 1, 4);
INSERT INTO `ctc` VALUES (5, 1, 5);
INSERT INTO `ctc` VALUES (7, 1, 1);
INSERT INTO `ctc` VALUES (7, 1, 2);
INSERT INTO `ctc` VALUES (7, 1, 3);
INSERT INTO `ctc` VALUES (7, 1, 4);
INSERT INTO `ctc` VALUES (7, 1, 5);
INSERT INTO `ctc` VALUES (7, 1, 15);
INSERT INTO `ctc` VALUES (8, 1, 4);
INSERT INTO `ctc` VALUES (8, 1, 5);
INSERT INTO `ctc` VALUES (8, 1, 15);
INSERT INTO `ctc` VALUES (9, 1, 4);
INSERT INTO `ctc` VALUES (9, 1, 5);
INSERT INTO `ctc` VALUES (9, 1, 6);
INSERT INTO `ctc` VALUES (10, 1, 2);
INSERT INTO `ctc` VALUES (10, 1, 3);
INSERT INTO `ctc` VALUES (10, 1, 5);
INSERT INTO `ctc` VALUES (11, 1, 15);
INSERT INTO `ctc` VALUES (12, 1, 1);
INSERT INTO `ctc` VALUES (14, 1, 1);
INSERT INTO `ctc` VALUES (1, 2, 15);
INSERT INTO `ctc` VALUES (7, 2, 15);

-- ----------------------------
-- Table structure for gonggao
-- ----------------------------
DROP TABLE IF EXISTS `gonggao`;
CREATE TABLE `gonggao`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gonggao
-- ----------------------------
INSERT INTO `gonggao` VALUES (1, '月考成绩', '12月份高三全体成绩', '2019-04-01 16:26:18');
INSERT INTO `gonggao` VALUES (3, 'gao', '期中考试1', '2019-04-01 22:09:54');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT 0,
  `cid` int(11) NULL DEFAULT 0,
  `tid` int(11) NULL DEFAULT NULL,
  `pgrade` double NULL DEFAULT NULL,
  `kgrade` double NULL DEFAULT NULL,
  `zgrade` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cid2`(`cid`) USING BTREE,
  INDEX `tid2`(`tid`) USING BTREE,
  INDEX `sid2`(`sid`) USING BTREE,
  CONSTRAINT `cid2` FOREIGN KEY (`cid`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sid2` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tid2` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (7, 1, 1, 1, 23, 45, 68);
INSERT INTO `grade` VALUES (8, 1, 7, 1, 34, 54, 88);
INSERT INTO `grade` VALUES (9, 1, 10, 1, 33, 55, 88);
INSERT INTO `grade` VALUES (10, 1, 1, 1, 89, 78, 167);
INSERT INTO `grade` VALUES (11, 27, 10, 1, 34, 67, 89);
INSERT INTO `grade` VALUES (12, 1, 1, 1, 20, 80, 100);
INSERT INTO `grade` VALUES (13, 1, 1, 1, 30, 70, 100);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `sid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`sid`, `cid`) USING BTREE,
  INDEX `cId1`(`cid`) USING BTREE,
  INDEX `tId1`(`tid`) USING BTREE,
  CONSTRAINT `cId1` FOREIGN KEY (`cid`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `sId1` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tId1` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (1, 1, 1);
INSERT INTO `sc` VALUES (1, 1, 7);
INSERT INTO `sc` VALUES (1, 1, 10);
INSERT INTO `sc` VALUES (27, 1, 7);
INSERT INTO `sc` VALUES (27, 1, 12);
INSERT INTO `sc` VALUES (27, 1, 14);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classid` int(30) NULL DEFAULT NULL,
  `usertype` int(11) NULL DEFAULT 2,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `files` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `s_c`(`classid`) USING BTREE,
  CONSTRAINT `classid` FOREIGN KEY (`classid`) REFERENCES `classes` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'ahui1', '1', '山西', '15635354675', 1, 2, '123', 'ahui1', NULL);
INSERT INTO `student` VALUES (8, '赵璇', '1', '辅导费但V发tyrytttttttttttttttttt', '123432133', 1, 2, 'aaa', 'zx', NULL);
INSERT INTO `student` VALUES (9, '张宇航111', '1', '事实上', '11111', 5, 2, NULL, NULL, NULL);
INSERT INTO `student` VALUES (21, '22', '0', '2222', '222', 1, 2, '22222', '22', NULL);
INSERT INTO `student` VALUES (27, '张三', '0', '江苏大学', '12345678912', 1, 2, '123456', 'zhangsan', NULL);
INSERT INTO `student` VALUES (28, '22', '0', 'sss', '111', 1, 2, 'eee', '22', NULL);
INSERT INTO `student` VALUES (29, 'ee', '0', 'ffffff', '15635385193', 1, 2, 'hjjjj', 'yyy', NULL);
INSERT INTO `student` VALUES (38, 'wwww', '0', 'www', '15635385193', 1, 2, 'aaa', 'admin', 'myfile');
INSERT INTO `student` VALUES (43, 'ddd', '1', 'ddd', 'dd', 2, 2, 'ddd', 'dd', NULL);
INSERT INTO `student` VALUES (44, 'qq', '1', 'qqqqqqqq', '2222222222', 4, 2, 'qqq', 'qqq', NULL);
INSERT INTO `student` VALUES (45, '张三同学', '0', '大连东软信息学院', '13354268903', 15, 2, 'admin12345', 'admin', NULL);
INSERT INTO `student` VALUES (46, '余长权', '0', '大连东软', '17614052024', 15, NULL, '123456', 'yu', NULL);
INSERT INTO `student` VALUES (47, '夏生', '0', '大连东软', '18920999298', 1, 2, '123456', 'xia', NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usertype` int(11) NULL DEFAULT 3,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'aaaaaa',
  `workId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '王老师12', 3, 'wang', '12', '12');
INSERT INTO `teacher` VALUES (2, '李老师', 3, 'li', '123456', '123');
INSERT INTO `teacher` VALUES (4, '赵老师', 3, 'zhao', '123456', NULL);
INSERT INTO `teacher` VALUES (5, '夏老师', 3, 'xia', '123456', NULL);
INSERT INTO `teacher` VALUES (6, '马老师', 3, 'ma', '123456', NULL);
INSERT INTO `teacher` VALUES (10, '陈老师', 3, 'chen', '123456', NULL);
INSERT INTO `teacher` VALUES (11, '方老师', 3, 'lixiaoyu', '123456', NULL);
INSERT INTO `teacher` VALUES (12, '黄老师', 3, 'zhangsan', '123456', NULL);
INSERT INTO `teacher` VALUES (13, '隋老师', 3, '123456', '12345612', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usertype` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `user` VALUES (2, 'zhangsan', 'zhangsan', 1);

SET FOREIGN_KEY_CHECKS = 1;
