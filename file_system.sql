/*
 Navicat Premium Data Transfer

 Source Server         : 172.30.34.66
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : 172.30.34.66:3306
 Source Schema         : file_system

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 13/12/2023 21:11:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `server_filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件路径(绝对路径)',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '路径（“/”+文件名）',
  `size` bigint(20) NULL DEFAULT NULL COMMENT '文件大小 单位（B）',
  `file_status` int(11) NULL DEFAULT NULL COMMENT '状态（0:私有，1:指定人员访问，2:公开）',
  `role` int(11) NULL DEFAULT NULL COMMENT '权限（0：普通用户，1：老师，2：管理员）',
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件类型（文件后缀名区分）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态(0:正常，1：删除)',
  `del_flag` int(11) NULL DEFAULT NULL COMMENT '逻辑删除(0:正常，1：删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/s', '/3636792f-ee74-4e1f-a5b3-f06d12dca073.txt', 9, 0, 0, '.txt', 1, '2023-11-30 17:13:26', 1, '2023-11-30', 0, 0);
INSERT INTO `file` VALUES (3, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/d1271785-12d1-4a64-8923-04c51559ca17.png', '/d1271785-12d1-4a64-8923-04c51559ca17.png', 612430, 0, 0, '.png', 1, '2023-12-03 20:06:47', 1, '2023-12-03', 0, 0);
INSERT INTO `file` VALUES (4, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/c87d0eee-40db-4fc8-9964-dfe341fe140a.png', '/c87d0eee-40db-4fc8-9964-dfe341fe140a.png', 612430, 0, 0, '.png', 1, '2023-12-03 20:07:45', 1, '2023-12-03', 0, 0);
INSERT INTO `file` VALUES (5, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/2986dbbd-4eea-4ae6-aaaf-2719214e6d08.png', '/2986dbbd-4eea-4ae6-aaaf-2719214e6d08.png', 612430, 0, 0, '.png', 1, '2023-12-03 20:08:34', 1, '2023-12-03', 0, 0);
INSERT INTO `file` VALUES (6, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/59437f59-35d9-49b6-9a0c-93c30e7f3d5a.zip', '/59437f59-35d9-49b6-9a0c-93c30e7f3d5a.zip', 238004, 0, 0, '.zip', 1, '2023-12-03 20:09:12', 1, '2023-12-03', 0, 0);
INSERT INTO `file` VALUES (7, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/3a61bbb0-550d-49e7-a32c-aca2c330ee6d.iso', '/3a61bbb0-550d-49e7-a32c-aca2c330ee6d.iso', 3892314112, 0, 0, '.iso', 1, '2023-12-03 23:18:06', 1, '2023-12-03', 0, 0);
INSERT INTO `file` VALUES (8, '/Users/tian/VscodeProject/FileSystem/WebServer/src/main/resources/img/user/3/2e1508cd-5e25-4b67-8a2f-184e01fb4c88.pdf', '/2e1508cd-5e25-4b67-8a2f-184e01fb4c88.pdf', 125994, 0, 0, '.pdf', 3, '2023-12-04 12:43:54', 3, '2023-12-04', 0, 0);
INSERT INTO `file` VALUES (9, 'D:/Desktop/FileSystem/FileSystem/WebServer/src/main/resources/file/user/1/9c019b8c-78f9-4e67-a678-42b74bb04b7a.gif', '/9c019b8c-78f9-4e67-a678-42b74bb04b7a.gif', 128230, 0, 0, '.gif', 1, '2023-12-04 13:01:30', 1, '2023-12-04', 0, 0);
INSERT INTO `file` VALUES (10, '/Users/tian/VscodeProject/FileSystem/WebServer/src/main/resources/img/user/1/67790a91-19a7-4ffa-a462-db232d208379.docx', '/67790a91-19a7-4ffa-a462-db232d208379.docx', 2574752, 0, 0, '.docx', 1, '2023-12-04 20:12:21', 1, '2023-12-04', 0, 0);
INSERT INTO `file` VALUES (11, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/488d4910-8c45-438d-82cd-73ff8dfc5241.txt', '/488d4910-8c45-438d-82cd-73ff8dfc5241.txt', 20064, 0, 0, '.txt', 1, '2023-12-04 21:31:01', 1, '2023-12-04', 0, 0);
INSERT INTO `file` VALUES (12, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/61de7156-1995-4a44-b04b-d9f6d4af2d9f.docx', '/61de7156-1995-4a44-b04b-d9f6d4af2d9f.docx', 41710, 0, 0, '.docx', 1, '2023-12-05 16:32:58', 1, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (13, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/ac50ff3c-d8eb-4051-9a30-dda728ba7fb8.docx', '/ac50ff3c-d8eb-4051-9a30-dda728ba7fb8.docx', 42009, 0, 0, '.docx', 1, '2023-12-05 16:53:07', 1, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (14, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/17d41b61-464c-43ee-8030-8cd852277f45.docx', '/17d41b61-464c-43ee-8030-8cd852277f45.docx', 42009, 0, 0, '.docx', 1, '2023-12-05 16:56:51', 1, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (15, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/5bb4a331-68b5-4e1e-804a-7434bf5a7009.docx', '/5bb4a331-68b5-4e1e-804a-7434bf5a7009.docx', 42009, 0, 0, '.docx', 1, '2023-12-05 17:59:26', 1, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (16, 'http://127.0.0.1:8010/system/getfile?fileUrl=6/93c7e546-89ce-46f1-856c-0acd7879f3d3.jpg', '/93c7e546-89ce-46f1-856c-0acd7879f3d3.jpg', 301575, 0, 0, '.jpg', 6, '2023-12-05 18:03:49', 6, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (17, 'http://127.0.0.1:8010/system/getfile?fileUrl=6/0f9366ea-ab34-4444-a32c-2764a77f5089.psd', '/0f9366ea-ab34-4444-a32c-2764a77f5089.psd', 2464138, 0, 0, '.psd', 6, '2023-12-05 18:05:05', 6, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (18, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/1efa38ca-8da4-40fe-ba3c-72936ad26c7c.docx', '/1efa38ca-8da4-40fe-ba3c-72936ad26c7c.docx', 41710, 0, 0, '.docx', 1, '2023-12-05 20:48:11', 1, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (19, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/9b42d588-7cba-4ed5-9391-faba89f4e905.docx', '/9b42d588-7cba-4ed5-9391-faba89f4e905.docx', 42009, 0, 0, '.docx', 1, '2023-12-05 20:54:44', 1, '2023-12-05', 0, 0);
INSERT INTO `file` VALUES (20, 'http://127.0.0.1:8010/system/getfile?fileUrl=1/2f2d211e-2b2d-4362-9e8b-81669696663a.docx', '/2f2d211e-2b2d-4362-9e8b-81669696663a.docx', 41710, 0, 0, '.docx', 1, '2023-12-05 20:55:03', 1, '2023-12-05', 0, 0);

-- ----------------------------
-- Table structure for file_download
-- ----------------------------
DROP TABLE IF EXISTS `file_download`;
CREATE TABLE `file_download`  (
  `id` bigint(20) NOT NULL,
  `file_id` bigint(20) NULL DEFAULT NULL COMMENT '下载文件的id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态（0：正常，1：删除）',
  `del_flag` int(11) NULL DEFAULT NULL COMMENT '逻辑删除（0：正常，1：删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file_download
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(765) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(765) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(765) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `grade` bigint(20) NULL DEFAULT NULL COMMENT '年级',
  `org` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级或部门',
  `role` int(5) NULL DEFAULT 0 COMMENT '权限（ 0是公开，1是私有，2是管理人员）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(3) NULL DEFAULT 0 COMMENT '状态',
  `del_flag` int(3) NULL DEFAULT 0 COMMENT '逻辑删除（0：没有删除，1：已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'string', 'string', 'string', 2020, 'string', 0, 1, '2023-11-28 08:56:10', 2, '2023-12-08 14:58:47', 0, 0);
INSERT INTO `user` VALUES (2, '123', 'string', 'string', 2021, 'string', 0, 0, '2023-11-28 08:59:30', 2, '2023-12-08 15:06:47', 0, 0);
INSERT INTO `user` VALUES (4, '123', '123', '132', 2020, 'string', 0, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES (5, 'string', 'string', 'st', 2020, 'string', 0, 0, '2023-11-28 10:24:44', 2, '2023-11-28 10:26:00', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
