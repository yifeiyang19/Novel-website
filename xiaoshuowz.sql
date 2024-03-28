/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : xiaoshuowz

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 26/02/2024 12:02:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Administrator id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Account',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Password',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Administrator' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'admin');
INSERT INTO `t_admin` VALUES (2, '账号2', '密码2');
INSERT INTO `t_admin` VALUES (3, '账号3', '密码3');
INSERT INTO `t_admin` VALUES (4, '账号4', '密码4');
INSERT INTO `t_admin` VALUES (5, '账号5', '密码5');
INSERT INTO `t_admin` VALUES (6, '账号6', '密码6');
INSERT INTO `t_admin` VALUES (7, '账号7', '密码7');
INSERT INTO `t_admin` VALUES (8, '账号8', '密码8');
INSERT INTO `t_admin` VALUES (9, '账号9', '密码9');
INSERT INTO `t_admin` VALUES (10, 'admin0', 'admin0');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Classify id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Name',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Picture',
  `shortinfo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Introduction',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Classification' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '名称1', '2024/2/sliver20240226113232798.jpg', '简介1简介1简介1简介1简介1');
INSERT INTO `t_category` VALUES (2, '名称2', '2024/2/sliver20240226113232798.jpg', '简介2简介2简介2简介2简介2');
INSERT INTO `t_category` VALUES (3, '名称3', '2024/2/sliver20240226113232798.jpg', '简介3简介3简介3简介3简介3');
INSERT INTO `t_category` VALUES (4, '名称4', '2024/2/sliver20240226113232798.jpg', '简介4简介4简介4简介4简介4');
INSERT INTO `t_category` VALUES (5, '名称5', '2024/2/sliver20240226113232798.jpg', '简介5简介5简介5简介5简介5');
INSERT INTO `t_category` VALUES (6, '名称6', '2024/2/sliver20240226113232798.jpg', '简介6简介6简介6简介6简介6');
INSERT INTO `t_category` VALUES (7, '名称7', '2024/2/sliver20240226113232798.jpg', '简介7简介7简介7简介7简介7');
INSERT INTO `t_category` VALUES (8, '名称8', '2024/2/sliver20240226113232798.jpg', '简介8简介8简介8简介8简介8');
INSERT INTO `t_category` VALUES (9, '名称9', '2024/2/sliver20240226113232798.jpg', '简介9简介9简介9简介9简介9');
INSERT INTO `t_category` VALUES (10, '名称10', '2024/2/sliver20240226113232798.jpg', '简介10简介10简介10简介10简介10');

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Collection id',
  `novel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Novel',
  `novelid` int(11) NULL DEFAULT NULL COMMENT 'novel id',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Root',
  `userid` int(11) NULL DEFAULT NULL COMMENT 'root id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Collection' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_collect
-- ----------------------------
INSERT INTO `t_collect` VALUES (1, '小说1', 1, '用户1', 1);
INSERT INTO `t_collect` VALUES (2, '小说2', 2, '用户2', 2);
INSERT INTO `t_collect` VALUES (3, '小说3', 3, '用户3', 3);
INSERT INTO `t_collect` VALUES (4, '小说4', 4, '用户4', 4);
INSERT INTO `t_collect` VALUES (6, '小说6', 6, '用户6', 6);
INSERT INTO `t_collect` VALUES (7, '小说7', 7, '用户7', 7);
INSERT INTO `t_collect` VALUES (8, '小说8', 8, '用户8', 8);
INSERT INTO `t_collect` VALUES (9, '小说9', 9, '用户9', 9);
INSERT INTO `t_collect` VALUES (10, '小说10', 10, '用户10', 10);

-- ----------------------------
-- Table structure for t_gonggao
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Notice id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'title',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'picture',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'content',
  `addtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'release time',
  `shortinfo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'introduction',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'notice' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------
INSERT INTO `t_gonggao` VALUES (1, '标题1', '2024/2/sliver20240226113256177.webp', '内容1内容1内容1内容1内容1', '2024-02-24 10:00:13', '简介1简介1简介1简介1简介1');
INSERT INTO `t_gonggao` VALUES (2, '标题2', '2024/2/sliver20240226113256177.webp', '内容2内容2内容2内容2内容2', '2024-02-24 10:00:13', '简介2简介2简介2简介2简介2');
INSERT INTO `t_gonggao` VALUES (3, '标题3', '2024/2/sliver20240226113256177.webp', '内容3内容3内容3内容3内容3', '2024-02-24 10:00:13', '简介3简介3简介3简介3简介3');
INSERT INTO `t_gonggao` VALUES (4, '标题4', '2024/2/sliver20240226113256177.webp', '内容4内容4内容4内容4内容4', '2024-02-24 10:00:13', '简介4简介4简介4简介4简介4');
INSERT INTO `t_gonggao` VALUES (5, '标题5', '2024/2/sliver20240226113256177.webp', '内容5内容5内容5内容5内容5', '2024-02-24 10:00:13', '简介5简介5简介5简介5简介5');
INSERT INTO `t_gonggao` VALUES (6, '标题6', '2024/2/sliver20240226113256177.webp', '内容6内容6内容6内容6内容6', '2024-02-24 10:00:13', '简介6简介6简介6简介6简介6');
INSERT INTO `t_gonggao` VALUES (7, '标题7', '2024/2/sliver20240226113256177.webp', '内容7内容7内容7内容7内容7', '2024-02-24 10:00:13', '简介7简介7简介7简介7简介7');
INSERT INTO `t_gonggao` VALUES (8, '标题8', '2024/2/sliver20240226113256177.webp', '内容8内容8内容8内容8内容8', '2024-02-24 10:00:13', '简介8简介8简介8简介8简介8');
INSERT INTO `t_gonggao` VALUES (9, '标题9', '2024/2/sliver20240226113256177.webp', '内容9内容9内容9内容9内容9', '2024-02-24 10:00:13', '简介9简介9简介9简介9简介9');
INSERT INTO `t_gonggao` VALUES (10, '标题10', '2024/2/sliver20240226113256177.webp', '内容10内容10内容10内容10内容10', '2024-02-24 10:00:13', '简介10简介10简介10简介10简介10');

-- ----------------------------
-- Table structure for t_likes
-- ----------------------------
DROP TABLE IF EXISTS `t_likes`;
CREATE TABLE `t_likes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Like id',
  `novel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'novel',
  `novelid` int(11) NULL DEFAULT NULL COMMENT 'novel id',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'root',
  `userid` int(11) NULL DEFAULT NULL COMMENT 'root id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'like' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_likes
-- ----------------------------
INSERT INTO `t_likes` VALUES (1, '小说1', 1, '用户1', 1);
INSERT INTO `t_likes` VALUES (2, '小说2', 2, '用户2', 2);
INSERT INTO `t_likes` VALUES (3, '小说3', 3, '用户3', 3);
INSERT INTO `t_likes` VALUES (4, '小说4', 4, '用户4', 4);
INSERT INTO `t_likes` VALUES (5, '小说5', 5, '用户5', 5);
INSERT INTO `t_likes` VALUES (6, '小说6', 6, '用户6', 6);
INSERT INTO `t_likes` VALUES (7, '小说7', 7, '用户7', 7);
INSERT INTO `t_likes` VALUES (8, '小说8', 8, '用户8', 8);
INSERT INTO `t_likes` VALUES (9, '小说9', 9, '用户9', 9);
INSERT INTO `t_likes` VALUES (10, '小说10', 10, '用户10', 10);
INSERT INTO `t_likes` VALUES (11, '名称5', 5, '姓名1', 1);

-- ----------------------------
-- Table structure for t_novel
-- ----------------------------
DROP TABLE IF EXISTS `t_novel`;
CREATE TABLE `t_novel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'novel id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cover',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'discribe',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'writer',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'classification',
  `categoryid` int(11) NULL DEFAULT NULL COMMENT 'classify id',
  `uploads` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'upload',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'novel' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_novel
-- ----------------------------
INSERT INTO `t_novel` VALUES (1, '名称1', '2024/2/sliver20240226113218972.jpg', '描述1描述1描述1描述1描述1', '作者1', '名称1', 1, '上传1', '待审核');
INSERT INTO `t_novel` VALUES (2, '名称2', '2024/2/sliver20240226113218972.jpg', '描述2描述2描述2描述2描述2', '作者2', '分类2', 2, '上传2', '状态2');
INSERT INTO `t_novel` VALUES (3, '名称3', '2024/2/sliver20240226113218972.jpg', '描述3描述3描述3描述3描述3', '作者3', '分类3', 3, '上传3', '状态3');
INSERT INTO `t_novel` VALUES (4, '名称4', '2024/2/sliver20240226113218972.jpg', '描述4描述4描述4描述4描述4', '作者4', '分类4', 4, '上传4', '状态4');
INSERT INTO `t_novel` VALUES (5, '名称5', '2024/2/sliver20240226113218972.jpg', '描述5描述5描述5描述5描述5', '作者5', '分类5', 5, '上传5', '状态5');
INSERT INTO `t_novel` VALUES (6, '名称6', '2024/2/sliver20240226113218972.jpg', '描述6描述6描述6描述6描述6', '作者6', '分类6', 6, '上传6', '状态6');
INSERT INTO `t_novel` VALUES (7, '名称7', '2024/2/sliver20240226113218972.jpg', '描述7描述7描述7描述7描述7', '作者7', '分类7', 7, '上传7', '状态7');
INSERT INTO `t_novel` VALUES (8, '名称8', '2024/2/sliver20240226113218972.jpg', '描述8描述8描述8描述8描述8', '作者8', '分类8', 8, '上传8', '状态8');
INSERT INTO `t_novel` VALUES (9, '名称9', '2024/2/sliver20240226113218972.jpg', '描述9描述9描述9描述9描述9', '作者9', '分类9', 9, '上传9', '状态9');
INSERT INTO `t_novel` VALUES (10, '名称10', '2024/2/sliver20240226113218972.jpg', '描述10描述10描述10描述10描述10', '作者10', '分类10', 10, '上传10', '状态10');
INSERT INTO `t_novel` VALUES (11, '名称10', '2024/2/sliver20240226113218972.jpg', '描述10描述10描述10描述10描述10', '作者10', '分类10', 10, '上传10', '状态10');

-- ----------------------------
-- Table structure for t_novelpinglun
-- ----------------------------
DROP TABLE IF EXISTS `t_novelpinglun`;
CREATE TABLE `t_novelpinglun`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'comments id',
  `novel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'novel',
  `novelid` int(11) NULL DEFAULT NULL COMMENT 'novel id',
  `neirong` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'connect',
  `pinglunrenmingzi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'commenter',
  `pinglunrenid` int(11) NULL DEFAULT NULL COMMENT 'commenter id',
  `pinglunshijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'comment time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'comments' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_novelpinglun
-- ----------------------------
INSERT INTO `t_novelpinglun` VALUES (1, '小说1', 1, '内容1内容1内容1内容1内容1', '评论人1', 1, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (2, '小说2', 2, '内容2内容2内容2内容2内容2', '评论人2', 2, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (3, '小说3', 3, '内容3内容3内容3内容3内容3', '评论人3', 3, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (4, '小说4', 4, '内容4内容4内容4内容4内容4', '评论人4', 4, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (5, '小说5', 5, '内容5内容5内容5内容5内容5', '评论人5', 5, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (6, '小说6', 6, '内容6内容6内容6内容6内容6', '评论人6', 6, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (7, '小说7', 7, '内容7内容7内容7内容7内容7', '评论人7', 7, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (8, '小说8', 8, '内容8内容8内容8内容8内容8', '评论人8', 8, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (9, '小说9', 9, '内容9内容9内容9内容9内容9', '评论人9', 9, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (10, '小说10', 10, '内容10内容10内容10内容10内容10', '评论人10', 10, '2024-02-24 10:00:13');
INSERT INTO `t_novelpinglun` VALUES (11, '名称6', 6, '很好看', '姓名1', 1, '2024/2/26 11:58:37');

-- ----------------------------
-- Table structure for t_posts
-- ----------------------------
DROP TABLE IF EXISTS `t_posts`;
CREATE TABLE `t_posts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'post id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'title',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'picture',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'connect',
  `addtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'publication time',
  `shortinfo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'introduction',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'post' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_posts
-- ----------------------------
INSERT INTO `t_posts` VALUES (1, '标题1', '2024/2/sliver20240226113245115.webp', '内容1内容1内容1内容1内容1', '2024-02-24 10:00:13', '简介1简介1简介1简介1简介1');
INSERT INTO `t_posts` VALUES (2, '标题2', '2024/2/sliver20240226113245115.webp', '内容2内容2内容2内容2内容2', '2024-02-24 10:00:13', '简介2简介2简介2简介2简介2');
INSERT INTO `t_posts` VALUES (3, '标题3', '2024/2/sliver20240226113245115.webp', '内容3内容3内容3内容3内容3', '2024-02-24 10:00:13', '简介3简介3简介3简介3简介3');
INSERT INTO `t_posts` VALUES (4, '标题4', '2024/2/sliver20240226113245115.webp', '内容4内容4内容4内容4内容4', '2024-02-24 10:00:13', '简介4简介4简介4简介4简介4');
INSERT INTO `t_posts` VALUES (5, '标题5', '2024/2/sliver20240226113245115.webp', '内容5内容5内容5内容5内容5', '2024-02-24 10:00:13', '简介5简介5简介5简介5简介5');
INSERT INTO `t_posts` VALUES (6, '标题6', '2024/2/sliver20240226113245115.webp', '内容6内容6内容6内容6内容6', '2024-02-24 10:00:13', '简介6简介6简介6简介6简介6');
INSERT INTO `t_posts` VALUES (7, '标题7', '2024/2/sliver20240226113245115.webp', '内容7内容7内容7内容7内容7', '2024-02-24 10:00:13', '简介7简介7简介7简介7简介7');
INSERT INTO `t_posts` VALUES (8, '标题8', '2024/2/sliver20240226113245115.webp', '内容8内容8内容8内容8内容8', '2024-02-24 10:00:13', '简介8简介8简介8简介8简介8');
INSERT INTO `t_posts` VALUES (9, '标题9', '2024/2/sliver20240226113245115.webp', '内容9内容9内容9内容9内容9', '2024-02-24 10:00:13', '简介9简介9简介9简介9简介9');
INSERT INTO `t_posts` VALUES (10, '标题10', '2024/2/sliver20240226113245115.webp', '内容10内容10内容10内容10内容10', '2024-02-24 10:00:13', '简介10简介10简介10简介10简介10');
INSERT INTO `t_posts` VALUES (11, '今天', NULL, '', '2024-02-26 11:58:10', '');

-- ----------------------------
-- Table structure for t_postspinglun
-- ----------------------------
DROP TABLE IF EXISTS `t_postspinglun`;
CREATE TABLE `t_postspinglun`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子评论id',
  `posts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子',
  `postsid` int(11) NULL DEFAULT NULL COMMENT '帖子id',
  `neirong` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `pinglunrenmingzi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人',
  `pinglunrenid` int(11) NULL DEFAULT NULL COMMENT '评论人id',
  `pinglunshijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '帖子评论' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_postspinglun
-- ----------------------------
INSERT INTO `t_postspinglun` VALUES (1, '帖子1', 1, '内容1内容1内容1内容1内容1', '评论人1', 1, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (2, '帖子2', 2, '内容2内容2内容2内容2内容2', '评论人2', 2, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (3, '帖子3', 3, '内容3内容3内容3内容3内容3', '评论人3', 3, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (4, '帖子4', 4, '内容4内容4内容4内容4内容4', '评论人4', 4, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (5, '帖子5', 5, '内容5内容5内容5内容5内容5', '评论人5', 5, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (6, '帖子6', 6, '内容6内容6内容6内容6内容6', '评论人6', 6, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (7, '帖子7', 7, '内容7内容7内容7内容7内容7', '评论人7', 7, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (8, '帖子8', 8, '内容8内容8内容8内容8内容8', '评论人8', 8, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (9, '帖子9', 9, '内容9内容9内容9内容9内容9', '评论人9', 9, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (10, '帖子10', 10, '内容10内容10内容10内容10内容10', '评论人10', 10, '2024-02-24 10:00:13');
INSERT INTO `t_postspinglun` VALUES (11, '标题6', 6, '好好', '姓名1', 1, '2024/2/26 11:25:59');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `toux` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '姓名1', 'admin', 'admin', 'syspic/user1.jpg', '男', '1', '15219393597', '邮箱1', '地址1地址1地址1地址1地址1');
INSERT INTO `t_user` VALUES (2, '姓名2', '账号2', '密码2', 'syspic/user2.jpg', '女', '2', '13278936287', '邮箱2', '地址2地址2地址2地址2地址2');
INSERT INTO `t_user` VALUES (3, '姓名3', '账号3', '密码3', 'syspic/user3.jpg', '女', '3', '13645660869', '邮箱3', '地址3地址3地址3地址3地址3');
INSERT INTO `t_user` VALUES (4, '姓名4', '账号4', '密码4', 'syspic/user4.jpg', '女', '4', '13354308212', '邮箱4', '地址4地址4地址4地址4地址4');
INSERT INTO `t_user` VALUES (5, '姓名5', '账号5', '密码5', 'syspic/user5.jpg', '女', '5', '13726821284', '邮箱5', '地址5地址5地址5地址5地址5');
INSERT INTO `t_user` VALUES (6, '姓名6', '账号6', '密码6', 'syspic/user6.jpg', '男', '6', '15261637234', '邮箱6', '地址6地址6地址6地址6地址6');
INSERT INTO `t_user` VALUES (7, '姓名7', '账号7', '密码7', 'syspic/user7.jpg', '女', '7', '18828065324', '邮箱7', '地址7地址7地址7地址7地址7');
INSERT INTO `t_user` VALUES (8, '姓名8', '账号8', '密码8', 'syspic/user8.jpg', '女', '8', '15949019129', '邮箱8', '地址8地址8地址8地址8地址8');
INSERT INTO `t_user` VALUES (9, '姓名9', '账号9', '密码9', 'syspic/user9.jpg', '男', '9', '15264227635', '邮箱9', '地址9地址9地址9地址9地址9');

SET FOREIGN_KEY_CHECKS = 1;
