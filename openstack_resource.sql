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

 Date: 24/05/2021 18:26:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for openstack_resource
-- ----------------------------
DROP TABLE IF EXISTS `openstack_resource`;
CREATE TABLE `openstack_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
  `instance_id` int(11)  DEFAULT NULL COMMENT '实例机ID',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `vcpus_used` int(1) DEFAULT NULL COMMENT '已经使用CPU数',
  `hypervisor_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监视器类型',
  `local_gb_used` int(11) DEFAULT NULL COMMENT '已使用的本地硬盘数',
  `vcpus` int(11) DEFAULT NULL COMMENT 'CPU总数',
  `hypervisor_hostname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监视器名',
  `memory_mb_used` int(11) DEFAULT NULL COMMENT '已使用的内存数',
  `memory_mb` int(11) DEFAULT NULL COMMENT '内存总大小',
  `current_workload` int(4) DEFAULT NULL COMMENT '当前工作量',
  `state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机器状态',
  `host_ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机器IP',
  `running_vms` int(4) DEFAULT NULL COMMENT '启动的实例数',
  `free_disk_gb` int(11) DEFAULT NULL COMMENT '可用硬盘空间',
  `hypervisor_version` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监视器版本号',
  `disk_available_least` int(11) DEFAULT NULL COMMENT '硬盘可用量',
  `local_gb` int(11) DEFAULT NULL COMMENT '本地硬盘大小',
  `free_ram_mb` int(11) DEFAULT NULL COMMENT '可用内存大小',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `host_ip`(`host_ip`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Openstack资源管理' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `openstack_images`;
CREATE TABLE `openstack_images` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
	`parent_id` int(11) DEFAULT NULL COMMENT 'Openstack资源管理ID',
	`image_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '镜像ID',
	`image_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '镜像名',
	`image_status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '镜像状态',
	`create_at` datetime DEFAULT NULL COMMENT '创建时间',
	`updated_at` datetime DEFAULT NULL COMMENT '更新时间',
	`extend` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '扩展字段',
	PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Openstack镜像' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `openstack_networks`;
CREATE TABLE `openstack_networks` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
	`parent_id` int(11) DEFAULT NULL COMMENT 'Openstack资源管理ID',
	`network_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网络ID',
	`bridge` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网络桥接方式',
	`create_at` datetime DEFAULT NULL COMMENT '创建时间',
	`updated_at` datetime DEFAULT NULL COMMENT '更新时间',
	`extend` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '扩展字段',
	PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Openstack网络' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `openstack_flavors`;
CREATE TABLE `openstack_flavors` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
	`parent_id` int(11) DEFAULT NULL COMMENT 'Openstack资源管理ID',
	`flavor_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '模板ID',
	`flavor_ram` int(11) DEFAULT NULL COMMENT '模板内存大小',
	`flavor_disk` int(11) DEFAULT NULL COMMENT '模板硬盘大小',
	`flavor_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '模板名',
	`flavor_vcpu` int(4) DEFAULT NULL COMMENT '模板占用的CPU数',
	`extend` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '扩展字段',
	PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Openstack模板' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `openstack_security_group`;
CREATE TABLE `openstack_security_group` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
	`parent_id` int(11) DEFAULT NULL COMMENT 'Openstack资源管理ID',
	`security_group_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '安全组ID',
	`security_group_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '安全组名',
	`security_group_tenant_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '安全组用户名',
	`extend` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '扩展字段',
	PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Openstack安全组' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `product_pools`;
CREATE TABLE `product_pools` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识ID',
	`spec_id` int(11) DEFAULT NULL COMMENT '产品规格对应的ID',
	`category_id` int(11) DEFAULT NULL COMMENT '父级分类所对应的ID',
	`product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '规格所对应的产品名',
	`host_ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Openstack对应的机器IP',
	`support_gpu` tinyint(1) DEFAULT NULL COMMENT '是否支持GPU',
	`status` int(4) DEFAULT NULL COMMENT '机器状态',
	PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Openstack安全组' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;