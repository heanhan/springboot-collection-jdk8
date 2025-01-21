/*
 Navicat Premium Dump SQL

 Source Server         : 172.16.75.105
 Source Server Type    : MySQL
 Source Server Version : 80025 (8.0.25)
 Source Host           : 172.16.75.105:3306
 Source Schema         : tenant_system

 Target Server Type    : MySQL
 Target Server Version : 80025 (8.0.25)
 File Encoding         : 65001

 Date: 21/01/2025 15:37:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单标题',
  `menu_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单地址',
  `parent_id` int NOT NULL COMMENT '父id',
  `list_order` int NOT NULL COMMENT '菜单排序',
  `icon` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
  `is_show` tinyint(1) DEFAULT '1',
  `type` tinyint(1) DEFAULT '1' COMMENT '菜单类型 1：pc  2：小程序',
  `is_del` tinyint(1) NOT NULL DEFAULT '1' COMMENT '菜单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=438 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  `menu_rights` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单权限',
  `node_rights` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '节点权限',
  `parent_id` int NOT NULL COMMENT '父id',
  `type` tinyint DEFAULT NULL COMMENT '角色类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`id`, `role_name`, `description`, `menu_rights`, `node_rights`, `parent_id`, `type`, `create_time`, `update_time`, `is_del`) VALUES (1, 'test', NULL, NULL, NULL, 0, NULL, '2021-05-28 15:54:19', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_tenant
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant_data`;
CREATE TABLE `sys_tenant_data` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `tenant_id` int DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_tenant_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_tenant_data` (`id`, `tenant_id`, `url`, `username`, `password`, `create_time`, `update_time`, `is_del`) VALUES (1, 1, 'jdbc:mysql://172.16.176.250:33060/tenant_one?tinyInt1isBit=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true', 'root', 'admin123', NULL, NULL, 0);
INSERT INTO `sys_tenant_data` (`id`, `tenant_id`, `url`, `username`, `password`, `create_time`, `update_time`, `is_del`) VALUES (2, 2, 'jdbc:mysql://172.16.176.250:33060/tenant_tow?tinyInt1isBit=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true', 'root', 'admin123', NULL, NULL, 0);
INSERT INTO `sys_tenant_data` (`id`, `tenant_id`, `url`, `username`, `password`, `create_time`, `update_time`, `is_del`) VALUES (3, 3, 'jdbc:mysql://172.16.176.250:33060/tenant_three?tinyInt1isBit=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8&allowMultiQueries=true', 'root', 'admin123', NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `tenant_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `type` tinyint(1) DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话号码',
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_phone` (`phone`) USING BTREE,
  KEY `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='系統用戶表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `tenant_id`, `role_id`, `username`, `password`, `nickname`, `type`, `email`, `phone`, `avatar`, `remark`, `status`, `create_time`, `update_time`) VALUES (267, 1, 1, 'a', '$2a$10$PG2beRhlJGGDbBYBNSLOB.T.T8WeoDYxCog67e2qDrRcSS99HbYx2', NULL, NULL, NULL, NULL, NULL, NULL, 1, '2021-05-28 15:51:08', NULL);
INSERT INTO `sys_user` (`id`, `tenant_id`, `role_id`, `username`, `password`, `nickname`, `type`, `email`, `phone`, `avatar`, `remark`, `status`, `create_time`, `update_time`) VALUES (268, 2, 1, 'b', '$2a$10$PG2beRhlJGGDbBYBNSLOB.T.T8WeoDYxCog67e2qDrRcSS99HbYx2', NULL, NULL, NULL, NULL, NULL, NULL, 1, '2021-05-28 15:51:08', NULL);
INSERT INTO `sys_user` (`id`, `tenant_id`, `role_id`, `username`, `password`, `nickname`, `type`, `email`, `phone`, `avatar`, `remark`, `status`, `create_time`, `update_time`) VALUES (269, 3, 1, 'c', '$2a$10$PG2beRhlJGGDbBYBNSLOB.T.T8WeoDYxCog67e2qDrRcSS99HbYx2', NULL, NULL, NULL, NULL, NULL, NULL, 1, '2021-05-28 15:51:40', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
