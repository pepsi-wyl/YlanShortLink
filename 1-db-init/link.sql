# 创建link数据库
CREATE DATABASE IF NOT EXISTS link;

# 切换到link数据库
USE link;

# 用户表分表
CREATE TABLE `t_user_0`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_1`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_2`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_3`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_4`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_5`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_6`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_7`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_8`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_9`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_10`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_11`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_12`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_13`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_14`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_user_15`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`      varchar(256) DEFAULT NULL COMMENT '用户名',
    `password`      varchar(512) DEFAULT NULL COMMENT '密码',
    `real_name`     varchar(256) DEFAULT NULL COMMENT '真实姓名',
    `phone`         varchar(128) DEFAULT NULL COMMENT '手机号',
    `mail`          varchar(512) DEFAULT NULL COMMENT '邮箱',
    `deletion_time` bigint(20)   DEFAULT NULL COMMENT '注销时间戳',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`      tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1715030926162935810
  DEFAULT CHARSET = utf8mb4;

# 短链接分组表分表
CREATE TABLE `t_group_0`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_1`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_2`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_3`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_4`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_5`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_6`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_7`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_8`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_9`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_10`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_11`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_12`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_13`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_14`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_group_15`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`         varchar(32)  DEFAULT NULL COMMENT '分组标识',
    `name`        varchar(64)  DEFAULT NULL COMMENT '分组名称',
    `username`    varchar(256) DEFAULT NULL COMMENT '创建分组用户名',
    `sort_order`  int(3)       DEFAULT NULL COMMENT '分组排序',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_username_gid` (`gid`, `username`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接表
CREATE TABLE `t_link`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接表分表
CREATE TABLE `t_link_0`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_1`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_2`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_3`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_4`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_5`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_6`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_7`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_8`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_9`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_10`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_11`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_12`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_13`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_14`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_15`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`             varchar(32)                                    DEFAULT 'default' COMMENT '分组标识',
    `origin_url`      varchar(1024)                                  DEFAULT NULL COMMENT '原始链接',
    `domain`          varchar(128)                                   DEFAULT NULL COMMENT '域名',
    `short_uri`       varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '短链接',
    `full_short_url`  varchar(128)                                   DEFAULT NULL COMMENT '完整短链接',
    `created_type`    tinyint(1)                                     DEFAULT NULL COMMENT '创建类型 0：接口创建 1：控制台创建',
    `valid_date_type` tinyint(1)                                     DEFAULT NULL COMMENT '有效期类型 0：永久有效 1：自定义',
    `valid_date`      datetime                                       DEFAULT NULL COMMENT '有效期',
    `describe`        varchar(1024)                                  DEFAULT NULL COMMENT '描述',
    `favicon`         varchar(256)                                   DEFAULT NULL COMMENT '网站图标',
    `enable_status`   tinyint(1)                                     DEFAULT NULL COMMENT '启用标识 0：启用 1：未启用',
    `click_num`       int(11)                                        DEFAULT '0' COMMENT '点击量',
    `total_pv`        int(11)                                        DEFAULT NULL COMMENT '历史PV',
    `total_uv`        int(11)                                        DEFAULT NULL COMMENT '历史UV',
    `total_uip`       int(11)                                        DEFAULT NULL COMMENT '历史UIP',
    `create_time`     datetime                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                       DEFAULT NULL COMMENT '修改时间',
    `del_flag`        tinyint(1)                                     DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    `del_time`        bigint(20)                                     DEFAULT '0'  COMMENT '删除时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`,`del_time`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# t_link 添加标题字段
alter table t_link_0
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_1
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_2
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_3
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_4
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_5
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_6
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_7
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_8
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_9
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_10
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_11
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_12
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_13
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_14
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;
alter table t_link_15
    add column title varchar(256) DEFAULT NULL COMMENT '标题' after favicon;

# 短链接跳转表
CREATE TABLE `t_link_goto_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;;
CREATE TABLE `t_link_goto_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_goto_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_goto_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_goto_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_goto_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_goto_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 基础访问监控表
CREATE TABLE `t_link_access_stats_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_access_stats_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)     DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128)    DEFAULT NULL COMMENT '完整短链接',
    `date`           date       NULL DEFAULT NULL COMMENT '日期',
    `hour`           int        NULL DEFAULT NULL COMMENT '小时',
    `weekday`        int        NULL DEFAULT NULL COMMENT '星期',
    `pv`             int        NULL DEFAULT NULL COMMENT '访问量',
    `uv`             int        NULL DEFAULT NULL COMMENT '独立访问数',
    `uip`            int        NULL DEFAULT NULL COMMENT '独立IP数',
    `create_time`    datetime   NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime   NULL DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) NULL DEFAULT NULL COMMENT '删除标识：0 未删除 1 已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_access_stats` (`gid`, `full_short_url`, `date`, `hour`, `weekday`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接地区访问监控表
CREATE TABLE `t_link_locale_stats_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_locale_stats_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `country`        varchar(64)  DEFAULT NULL COMMENT '国家名称',
    `province`       varchar(64)  DEFAULT NULL COMMENT '省份名称',
    `city`           varchar(64)  DEFAULT NULL COMMENT '市区名称',
    `adcode`         varchar(64)  DEFAULT NULL COMMENT '城市编码',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_locale_stats` (`gid`, `full_short_url`, `date`, `country`, `province`, `city`,
                                          `adcode`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接浏览器访问监控表
CREATE TABLE `t_link_browser_stats_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_browser_stats_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '浏览器',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `browser`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接操作系统访问监控表
CREATE TABLE `t_link_os_stats_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_os_stats_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `os`             varchar(64)  DEFAULT NULL COMMENT '操作系统',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_os_stats` (`gid`, `full_short_url`, `date`, `os`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接设备访问监控表
CREATE TABLE `t_link_device_stats_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_device_stats_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `device`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接网络🛜访问监控表
CREATE TABLE `t_link_network_stats_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_network_stats_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `cnt`            int(11)      DEFAULT NULL COMMENT '访问量',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_browser_stats` (`gid`, `full_short_url`, `date`, `network`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 短链接访问日志监控表
CREATE TABLE `t_link_access_logs_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_link_access_logs_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `user`           varchar(64)  DEFAULT NULL COMMENT '用户信息',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',
    `ip`             varchar(64)  DEFAULT NULL COMMENT '访问IP',
    `locale`         varchar(256) DEFAULT NULL COMMENT '访问地区',
    `os`             varchar(64)  DEFAULT NULL COMMENT '访问操作系统',
    `browser`        varchar(64)  DEFAULT NULL COMMENT '访问浏览器',
    `network`        varchar(64)  DEFAULT NULL COMMENT '访问网络',
    `device`         varchar(64)  DEFAULT NULL COMMENT '访问设备',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1) DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 短链接今日统计表
CREATE TABLE `t_link_stats_today_0`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_1`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_2`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_3`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_4`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_5`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_6`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_7`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_8`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_9`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_10`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_11`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_12`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_13`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_14`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_stats_today_15`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `gid`            varchar(32)  DEFAULT 'default' COMMENT '分组标识',
    `full_short_url` varchar(128) DEFAULT NULL COMMENT '短链接',
    `date`           date         DEFAULT NULL COMMENT '日期',
    `today_pv`       int(11)      DEFAULT '0' COMMENT '今日PV',
    `today_uv`       int(11)      DEFAULT '0' COMMENT '今日UV',
    `today_uip`      int(11)      DEFAULT '0' COMMENT '今日IP数',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`       tinyint(1)   DEFAULT NULL COMMENT '删除标识 0：未删除 1：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `idx_unique_today_stats` (`gid`, `full_short_url`, `date`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;