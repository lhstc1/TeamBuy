/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : teambuy

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 08/07/2022 10:50:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `date` date NULL DEFAULT NULL COMMENT '时间',
  `span` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时长',
  `fee` double NOT NULL COMMENT '活动费用',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主要内容',
  `leader` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团长',
  `tfee` double NOT NULL COMMENT '团费',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1017 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1001, '最美九寨沟', '2022-07-15', '5小时', 660, '游玩九寨沟', '小欣', 10);
INSERT INTO `activity` VALUES (1002, '醉梦千岛湖', '2022-07-12', '4小时', 480, '欣赏千岛湖', '小欣', 10);
INSERT INTO `activity` VALUES (1003, '千垛景区', '2022-07-21', '2小时', 120, '油菜花开金满地', '小欣', 10);
INSERT INTO `activity` VALUES (1004, '爬泰山', '2022-07-22', '5小时', 360, '登峰造极之境', '小欣', 10);
INSERT INTO `activity` VALUES (1005, '马尔代夫', '2022-10-01', '7小时', 3200, '美妙的海景', '小欣', 10);
INSERT INTO `activity` VALUES (1006, '方特乐园', '2022-07-09', '4小时', 1050, '游乐园玩耍', '小欣', 10);
INSERT INTO `activity` VALUES (1007, '海洋世界', '2022-07-15', '6小时', 1200, '观赏海底世界', '小欣', 10);
INSERT INTO `activity` VALUES (1008, '冰河世纪', '2022-08-11', '2小时', 980, '漂流', '小欣', 10);
INSERT INTO `activity` VALUES (1009, '瓯江音乐节', '2022-07-29', '4小时', 2080, '观看音乐演出', '小欣', 10);
INSERT INTO `activity` VALUES (1010, '银泰美食节', '2022-09-01', '5小时', 280, '品尝美食', '小欣', 10);
INSERT INTO `activity` VALUES (1011, '横店影视城', '2022-09-06', '10小时', 300, '游玩横店', '小欣', 10);
INSERT INTO `activity` VALUES (1012, '迪士尼乐园', '2022-10-07', '8小时', 3880, '畅玩乐园', '小欣', 10);
INSERT INTO `activity` VALUES (1015, '动物园', '2022-10-19', '5小时', 380, '观赏动物', '小欣', 10);

-- ----------------------------
-- Table structure for joiners
-- ----------------------------
DROP TABLE IF EXISTS `joiners`;
CREATE TABLE `joiners`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `leader` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团长',
  `fee` double NOT NULL COMMENT '活动费用',
  `tfee` double NOT NULL COMMENT '团费',
  `people` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 320 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of joiners
-- ----------------------------
INSERT INTO `joiners` VALUES (301, '方特乐园', '小欣', 1050, 10, '小路');
INSERT INTO `joiners` VALUES (302, '海底世界', '小欣', 998, 10, '小壮');
INSERT INTO `joiners` VALUES (303, '方特乐园', '小欣', 1050, 10, '孙明');
INSERT INTO `joiners` VALUES (304, '瓯江音乐节', '小欣', 780, 10, '小李');
INSERT INTO `joiners` VALUES (305, '爬泰山', '小欣', 360, 10, '小路');
INSERT INTO `joiners` VALUES (306, '爬泰山', '小欣', 360, 10, '小明');
INSERT INTO `joiners` VALUES (307, '冰河世纪', '小欣', 280, 10, '小李');
INSERT INTO `joiners` VALUES (308, '方特乐园', '小欣', 1050, 10, '小明');
INSERT INTO `joiners` VALUES (309, '最美九寨沟', '小欣', 1050, 10, '小析');
INSERT INTO `joiners` VALUES (310, '马尔代夫', '小欣', 3200, 10, '小卷');
INSERT INTO `joiners` VALUES (312, '方特乐园', '小欣', 1050, 10, '小卷');
INSERT INTO `joiners` VALUES (313, '动物园', '小欣', 380, 10, '小卷');

-- ----------------------------
-- Table structure for leader
-- ----------------------------
DROP TABLE IF EXISTS `leader`;
CREATE TABLE `leader`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `leadername` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leader
-- ----------------------------
INSERT INTO `leader` VALUES (1, '小欣', 'xx123');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队名称',
  `leader` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团长',
  `sum` int NOT NULL COMMENT '所需人数',
  `pfee` double NOT NULL,
  `fee` double NOT NULL COMMENT '团费',
  `tfee` double NOT NULL,
  `elsefee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 203 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (201, '海底世界', '小欣', 1, 998, 998, 10, '个人活动费增加120元');
INSERT INTO `team` VALUES (204, '马尔代夫', '小欣', 1, 3200, 3200, 10, '个人团费增加20元');
INSERT INTO `team` VALUES (206, '方特乐园', '小欣', 4, 262.5, 1050, 10, NULL);
INSERT INTO `team` VALUES (207, '动物园', '小欣', 1, 380, 380, 10, '个人团费增加20元');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` blob NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (101, '小明', 0x786D313233);
INSERT INTO `users` VALUES (102, '小卷', 0x786A313233);
INSERT INTO `users` VALUES (103, '小李', 0x786C313233);
INSERT INTO `users` VALUES (104, '小壮', 0x787A313233);
INSERT INTO `users` VALUES (105, '小路', 0x786C313233);
INSERT INTO `users` VALUES (106, '孙明', 0x736D313233);

SET FOREIGN_KEY_CHECKS = 1;
