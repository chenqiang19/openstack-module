/*
 Navicat Premium Data Transfer

 Source Server         : nacos
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : cloud_computing2.0

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/07/2021 13:41:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for openstack_nodes
-- ----------------------------
DROP TABLE IF EXISTS `openstack_nodes`;
CREATE TABLE `openstack_nodes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `instance_uuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实例UUID',
  `uuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'UUID',
  `provision_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器状态',
  `power_state` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电源状态',
  `vcpus` int(11) NULL DEFAULT NULL COMMENT 'CPU总数',
  `memory_mb` int(11) NULL DEFAULT NULL COMMENT '内存总大小',
  `local_gb` int(11) NULL DEFAULT NULL COMMENT '本地硬盘大小',
  `cpu_arch` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cpu架构',
  `gpu_flag` int(1) NULL DEFAULT NULL COMMENT 'GPU判断符',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uuid`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物理机集群' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of openstack_nodes
-- ----------------------------


SET FOREIGN_KEY_CHECKS = 1;
