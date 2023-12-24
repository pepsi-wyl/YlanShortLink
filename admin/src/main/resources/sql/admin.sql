# 创建link数据库
CREATE DATABASE IF NOT EXISTS link;

# 切换到link数据库
USE link;

# 用户表
CREATE TABLE IF NOT EXISTS `t_user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                          `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                          `password` varchar(512) DEFAULT NULL COMMENT '密码',
                          `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                          `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                          `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                          `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                          `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;


# 用户表分表
CREATE TABLE `t_user_0` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_1` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_2` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_3` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_4` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_5` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_6` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_7` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_8` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_9` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                            `password` varchar(512) DEFAULT NULL COMMENT '密码',
                            `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                            `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                            `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                            `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_10` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                             `password` varchar(512) DEFAULT NULL COMMENT '密码',
                             `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                             `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                             `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                             `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                             `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_11` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                             `password` varchar(512) DEFAULT NULL COMMENT '密码',
                             `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                             `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                             `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                             `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                             `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_12` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                             `password` varchar(512) DEFAULT NULL COMMENT '密码',
                             `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                             `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                             `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                             `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                             `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_13` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                             `password` varchar(512) DEFAULT NULL COMMENT '密码',
                             `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                             `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                             `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                             `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                             `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_14` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                             `password` varchar(512) DEFAULT NULL COMMENT '密码',
                             `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                             `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                             `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                             `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                             `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_15` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `username` varchar(256) DEFAULT NULL COMMENT '用户名',
                             `password` varchar(512) DEFAULT NULL COMMENT '密码',
                             `real_name` varchar(256) DEFAULT NULL COMMENT '真实姓名',
                             `phone` varchar(128) DEFAULT NULL COMMENT '手机号',
                             `mail` varchar(512) DEFAULT NULL COMMENT '邮箱',
                             `deletion_time` bigint(20) DEFAULT NULL COMMENT '注销时间戳',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                             `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1715030926162935810 DEFAULT CHARSET=utf8mb4;

# 短链接分组表
CREATE TABLE `t_group` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                           `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',
                           `name` varchar(64) DEFAULT NULL COMMENT '分组名称',
                           `username` varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
                           `sort_order` int(3) DEFAULT NULL COMMENT '分组排序',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                           `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `idx_unique_username_gid` (`gid`,`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;