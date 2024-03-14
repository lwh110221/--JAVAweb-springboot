/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 13/03/2024 22:43:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮件',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `validation_time` datetime NULL DEFAULT NULL COMMENT '有效时间',
  `is_valid` tinyint(1) NULL DEFAULT 1 COMMENT '0：不可用 1：可用',
  `confirm_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, 'admin', '41a2dd468699ea713fae62a25db4690d', 'i0kwwy053', '2023-12-13 17:22:32', 1, '1734503993973018624');
INSERT INTO `login` VALUES (2, '3163524351@qq.com', '7781323524ce9df6e5e4bcb1897a26b8', 'ln1315qdp', '2023-12-18 22:14:42', 1, '1736389457105522688');

-- ----------------------------
-- Table structure for ranks
-- ----------------------------
DROP TABLE IF EXISTS `ranks`;
CREATE TABLE `ranks`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `stuNumber` int(11) NULL DEFAULT NULL COMMENT '学生学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `couName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `grade` int(11) NULL DEFAULT NULL COMMENT '成绩',
  `point` float NULL DEFAULT NULL COMMENT '绩点',
  `ranks` int(11) NULL DEFAULT NULL COMMENT '排名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ranks
-- ----------------------------

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `stuNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `couId` mediumint(9) NULL DEFAULT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `couName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `grade` smallint(6) NULL DEFAULT NULL COMMENT '成绩',
  `point` float NULL DEFAULT NULL COMMENT '绩点',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`stuNumber`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('202011010', 1, '白慧捷', '数据结构', 97, 0.97, '计算机科学与技术');
INSERT INTO `score` VALUES ('202011011', 1, '曾茂彦', '数据结构', 67, 0.67, '计算机科学与技术');
INSERT INTO `score` VALUES ('202011012', 2, '高花', '计算机操作系统', 54, 0.54, '计算机科学与技术');
INSERT INTO `score` VALUES ('202011013', 2, '张志强', '计算机操作系统', 56, 0.56, '计算机科学与技术');
INSERT INTO `score` VALUES ('202311014', 4, '查良吉', '世界经济概论', 77, 0.77, '工商管理');
INSERT INTO `score` VALUES ('202311015', 5, '常锐志', '中级计量经济学', 89, 0.89, '工商管理');
INSERT INTO `score` VALUES ('202311016', 6, '陈浩浒', '高等数学', 90, 0.9, '工商管理');
INSERT INTO `score` VALUES ('202311017', 7, '陈阳伯', '国际经济学', 52, 0.52, '工商管理');
INSERT INTO `score` VALUES ('202311018', 7, '方涵润', '国际经济学', 63, 0.63, '工商管理');
INSERT INTO `score` VALUES ('202311019', 8, '方嘉', '动物解剖学', 84, 0.84, '动物医学');
INSERT INTO `score` VALUES ('202311020', 9, '戴萍', '兽医药理学', 92, 0.92, '动物医学');
INSERT INTO `score` VALUES ('202311021', 9, '邓成化', '兽医药理学', 95, 0.95, '动物医学');
INSERT INTO `score` VALUES ('202211022', 11, '安澜', '临床兽医学', 99, 0.99, '动物医学');
INSERT INTO `score` VALUES ('202211023', 11, '丁成弘', '临床兽医学', 78, 0.78, '动物医学');
INSERT INTO `score` VALUES ('202211024', 15, '丁聪', '耕作学', 64, 0.64, '农学');
INSERT INTO `score` VALUES ('202211025', 16, '董瑞', '作物栽培学', 96, 0.96, '农学');
INSERT INTO `score` VALUES ('202211026', 17, '窦英', '植物生理学', 81, 0.81, '农学');
INSERT INTO `score` VALUES ('202211027', 18, '段高格', '中国教育史', 55, 0.55, '人文教育');
INSERT INTO `score` VALUES ('202211028', 19, '段天材', '教育心理学', 97, 0.97, '人文教育');
INSERT INTO `score` VALUES ('202211029', 19, '郭容容', '教育心理学', 53, 0.53, '人文教育');
INSERT INTO `score` VALUES ('202211030', 20, '郭彭彭', '教育哲学', 86, 0.86, '人文教育');

-- ----------------------------
-- Table structure for software
-- ----------------------------
DROP TABLE IF EXISTS `software`;
CREATE TABLE `software`  (
  `couId` mediumint(9) NOT NULL AUTO_INCREMENT,
  `couName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `couGrade` mediumint(9) NULL DEFAULT NULL,
  `couTime` mediumint(9) NULL DEFAULT NULL,
  PRIMARY KEY (`couId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of software
-- ----------------------------
INSERT INTO `software` VALUES (1, '数据结构', 2, 15);
INSERT INTO `software` VALUES (2, '计算机操作系统', 1, 12);
INSERT INTO `software` VALUES (4, '世界经济概论', 2, 15);
INSERT INTO `software` VALUES (5, '中级计量经济学', 3, 18);
INSERT INTO `software` VALUES (6, '高等数学', 3, 18);
INSERT INTO `software` VALUES (7, '国际经济学', 2, 15);
INSERT INTO `software` VALUES (8, '动物解剖学', 2, 15);
INSERT INTO `software` VALUES (9, '兽医药理学', 1, 12);
INSERT INTO `software` VALUES (11, '临床兽医学', 4, 24);
INSERT INTO `software` VALUES (15, '耕作学', 3, 18);
INSERT INTO `software` VALUES (16, '作物栽培学', 1, 12);
INSERT INTO `software` VALUES (17, '植物生理学', 2, 15);
INSERT INTO `software` VALUES (18, '中国教育史', 2, 15);
INSERT INTO `software` VALUES (19, '教育心理学', 1, 12);
INSERT INTO `software` VALUES (20, '教育哲学', 4, 24);

-- ----------------------------
-- Table structure for st_course
-- ----------------------------
DROP TABLE IF EXISTS `st_course`;
CREATE TABLE `st_course`  (
  `couId` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `couName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `couGrade` mediumint(9) NOT NULL COMMENT '学分',
  `couTime` mediumint(9) NOT NULL COMMENT '学时',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属专业',
  PRIMARY KEY (`couId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of st_course
-- ----------------------------
INSERT INTO `st_course` VALUES (1, '数据结构', 2, 15, '计算机科学与技术');
INSERT INTO `st_course` VALUES (2, '计算机操作系统', 1, 12, '计算机科学与技术');
INSERT INTO `st_course` VALUES (4, '世界经济概论', 2, 15, '工商管理');
INSERT INTO `st_course` VALUES (5, '中级计量经济学', 3, 18, '工商管理');
INSERT INTO `st_course` VALUES (6, '高等数学', 3, 18, '工商管理');
INSERT INTO `st_course` VALUES (7, '国际经济学', 2, 15, '工商管理');
INSERT INTO `st_course` VALUES (8, '动物解剖学', 2, 15, '动物医学');
INSERT INTO `st_course` VALUES (9, '兽医药理学', 1, 12, '动物医学');
INSERT INTO `st_course` VALUES (11, '临床兽医学', 4, 24, '动物医学');
INSERT INTO `st_course` VALUES (15, '耕作学', 3, 18, '农学');
INSERT INTO `st_course` VALUES (16, '作物栽培学', 1, 12, '农学');
INSERT INTO `st_course` VALUES (17, '植物生理学', 2, 15, '农学');
INSERT INTO `st_course` VALUES (18, '中国教育史', 2, 15, '人文教育');
INSERT INTO `st_course` VALUES (19, '教育心理学', 1, 12, '人文教育');
INSERT INTO `st_course` VALUES (20, '教育哲学', 4, 24, '人文教育');

-- ----------------------------
-- Table structure for st_dorm
-- ----------------------------
DROP TABLE IF EXISTS `st_dorm`;
CREATE TABLE `st_dorm`  (
  `dormId` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '宿舍id',
  `dormNum` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宿舍号',
  `dormAddress` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍地址号',
  PRIMARY KEY (`dormId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of st_dorm
-- ----------------------------
INSERT INTO `st_dorm` VALUES (1, '101', '立志苑一栋');
INSERT INTO `st_dorm` VALUES (2, '101', '立志苑一栋');
INSERT INTO `st_dorm` VALUES (3, '102', '立志苑一栋');
INSERT INTO `st_dorm` VALUES (4, '102', '立志苑一栋');
INSERT INTO `st_dorm` VALUES (5, '210', '立德苑三栋');
INSERT INTO `st_dorm` VALUES (6, '210', '立德苑三栋');
INSERT INTO `st_dorm` VALUES (7, '211', '立德苑三栋');
INSERT INTO `st_dorm` VALUES (8, '212', '立德苑三栋');
INSERT INTO `st_dorm` VALUES (9, '213', '立德苑三栋');
INSERT INTO `st_dorm` VALUES (10, '110', '立德苑六栋');
INSERT INTO `st_dorm` VALUES (11, '110', '立德苑六栋');
INSERT INTO `st_dorm` VALUES (12, '110', '立德苑六栋');
INSERT INTO `st_dorm` VALUES (13, '111', '立德苑六栋');
INSERT INTO `st_dorm` VALUES (14, '112', '立德苑六栋');
INSERT INTO `st_dorm` VALUES (15, '405', '立志苑五栋');
INSERT INTO `st_dorm` VALUES (16, '405', '立志苑五栋');
INSERT INTO `st_dorm` VALUES (17, '406', '立志苑五栋');
INSERT INTO `st_dorm` VALUES (18, '302', '立信苑二栋');
INSERT INTO `st_dorm` VALUES (19, '303', '立信苑二栋');
INSERT INTO `st_dorm` VALUES (20, '304', '立信苑二栋');
INSERT INTO `st_dorm` VALUES (21, '305', '立信苑二栋');

-- ----------------------------
-- Table structure for st_grade
-- ----------------------------
DROP TABLE IF EXISTS `st_grade`;
CREATE TABLE `st_grade`  (
  `stuNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `couId` mediumint(9) NOT NULL COMMENT '课程号',
  `grade` smallint(6) NOT NULL COMMENT '成绩',
  `point` float(2, 1) NOT NULL COMMENT '绩点',
  PRIMARY KEY (`stuNumber`, `couId`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of st_grade
-- ----------------------------
INSERT INTO `st_grade` VALUES ('202011010', 1, 97, 1.0);
INSERT INTO `st_grade` VALUES ('202011011', 1, 67, 0.7);
INSERT INTO `st_grade` VALUES ('202011012', 2, 54, 0.5);
INSERT INTO `st_grade` VALUES ('202011013', 2, 56, 0.6);
INSERT INTO `st_grade` VALUES ('202311014', 4, 77, 0.8);
INSERT INTO `st_grade` VALUES ('202311014', 5, 80, 0.8);
INSERT INTO `st_grade` VALUES ('202311015', 5, 89, 0.9);
INSERT INTO `st_grade` VALUES ('202311015', 6, 93, 0.9);
INSERT INTO `st_grade` VALUES ('202311016', 6, 90, 0.9);
INSERT INTO `st_grade` VALUES ('202311017', 4, 85, 0.8);
INSERT INTO `st_grade` VALUES ('202311017', 7, 52, 0.5);
INSERT INTO `st_grade` VALUES ('202311018', 7, 63, 0.6);
INSERT INTO `st_grade` VALUES ('202311019', 8, 84, 0.8);
INSERT INTO `st_grade` VALUES ('202311019', 9, 56, 0.6);
INSERT INTO `st_grade` VALUES ('202311020', 9, 92, 0.9);
INSERT INTO `st_grade` VALUES ('202311021', 9, 95, 1.0);
INSERT INTO `st_grade` VALUES ('202211022', 11, 99, 1.0);
INSERT INTO `st_grade` VALUES ('202211023', 11, 78, 0.8);
INSERT INTO `st_grade` VALUES ('202211024', 15, 64, 0.6);
INSERT INTO `st_grade` VALUES ('202211025', 16, 96, 1.0);
INSERT INTO `st_grade` VALUES ('202211026', 17, 81, 0.8);
INSERT INTO `st_grade` VALUES ('202211027', 18, 55, 0.6);
INSERT INTO `st_grade` VALUES ('202211027', 19, 88, 0.9);
INSERT INTO `st_grade` VALUES ('202211028', 19, 97, 1.0);
INSERT INTO `st_grade` VALUES ('202211029', 19, 53, 0.5);
INSERT INTO `st_grade` VALUES ('202211030', 20, 86, 0.9);

-- ----------------------------
-- Table structure for st_login
-- ----------------------------
DROP TABLE IF EXISTS `st_login`;
CREATE TABLE `st_login`  (
  `id` mediumint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `stuNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '账户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of st_login
-- ----------------------------

-- ----------------------------
-- Table structure for st_name
-- ----------------------------
DROP TABLE IF EXISTS `st_name`;
CREATE TABLE `st_name`  (
  `stuId` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `stuNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `age` int(11) NOT NULL COMMENT '年龄',
  `dormNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '宿舍地址好',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `majorClass` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '专业班级',
  `stuDay` datetime NOT NULL COMMENT '入学日期',
  `stuPic` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '头像图片',
  `major` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业全称',
  PRIMARY KEY (`stuId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci PACK_KEYS = 1 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of st_name
-- ----------------------------
INSERT INTO `st_name` VALUES (1, '白慧捷', '202011010', 18, '立志苑一栋101', '女', '计科1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '计算机科学与技术');
INSERT INTO `st_name` VALUES (2, '曾茂彦', '202011011', 19, '立志苑一栋101', '男', '计科1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '计算机科学与技术');
INSERT INTO `st_name` VALUES (3, '高花', '202011012', 20, '立志苑一栋102', '女', '计科2班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '计算机科学与技术');
INSERT INTO `st_name` VALUES (4, '张志强', '202011013', 21, '立志苑一栋102', '男', '计科2班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '计算机科学与技术');
INSERT INTO `st_name` VALUES (5, '查良吉', '202011014', 22, '立德苑三栋210', '男', '工商管理1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '工商管理');
INSERT INTO `st_name` VALUES (6, '常锐志', '202011015', 18, '立德苑三栋210', '男', '工商管理1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '工商管理');
INSERT INTO `st_name` VALUES (7, '陈浩浒', '202011016', 22, '立德苑三栋211', '男', '工商管理2班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '工商管理');
INSERT INTO `st_name` VALUES (8, '陈阳伯', '202011017', 18, '立德苑三栋212', '男', '工商管理3班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '工商管理');
INSERT INTO `st_name` VALUES (9, '方涵润', '202011018', 19, '立德苑三栋213', '女', '工商管理3班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '工商管理');
INSERT INTO `st_name` VALUES (10, '方嘉', '202011019', 27, '立德苑六栋110', '女', '动物医学1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '动物医学');
INSERT INTO `st_name` VALUES (11, '戴萍', '202011020', 20, '立德苑六栋110', '女', '动物医学1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '动物医学');
INSERT INTO `st_name` VALUES (12, '邓成化', '202011021', 20, '立德苑六栋110', '男', '动物医学1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '动物医学');
INSERT INTO `st_name` VALUES (13, '安澜', '202011022', 20, '立德苑六栋111', '女', '动物医学2班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '动物医学');
INSERT INTO `st_name` VALUES (14, '丁成弘', '202011023', 19, '立德苑六栋112', '男', '动物医学2班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '动物医学');
INSERT INTO `st_name` VALUES (15, '丁聪', '202011024', 20, '立志苑五栋405', '男', '农学1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '农学');
INSERT INTO `st_name` VALUES (16, '董瑞', '202011025', 20, '立志苑五栋405', '男', '农学2班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '农学');
INSERT INTO `st_name` VALUES (17, '窦英', '202011026', 21, '立志苑五栋406', '女', '农学3班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '农学');
INSERT INTO `st_name` VALUES (18, '段高格', '202011027', 20, '立信苑二栋302', '男', '人文教育1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '人文教育');
INSERT INTO `st_name` VALUES (19, '段天材', '202011028', 19, '立信苑二栋303', '男', '人文教育1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '人文教育');
INSERT INTO `st_name` VALUES (20, '郭容容', '202011029', 20, '立信苑二栋304', '女', '人文教育3班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '人文教育');
INSERT INTO `st_name` VALUES (21, '郭彭彭', '202011030', 18, '立信苑二栋305', '男', '人文教育4班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '人文教育');
INSERT INTO `st_name` VALUES (22, '张三', '202011031', 19, '立志苑一栋101', '女', '计科1班', '2020-10-01 00:00:00', 'e3090ede-7723-4bc9-b754-0c206db6a048-QQ图片20230908145219.png', '计算机科学与技术');

-- ----------------------------
-- View structure for computer
-- ----------------------------
DROP VIEW IF EXISTS `computer`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `computer` AS select `st_course`.`couId` AS `couId`,`st_course`.`couName` AS `couName`,`st_course`.`couGrade` AS `couGrade`,`st_course`.`couTime` AS `couTime` from `st_course` where (`st_course`.`major` = '计算机科学与技术')  WITH CASCADED CHECK OPTION;

SET FOREIGN_KEY_CHECKS = 1;
