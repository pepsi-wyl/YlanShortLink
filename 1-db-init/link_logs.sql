# 创建link数据库
CREATE DATABASE IF NOT EXISTS link_logs;

# 切换到link数据库
USE link_logs;

# 网关日志表
CREATE TABLE `t_link_gateway_log_0`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_1`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_2`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_3`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_4`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_5`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_6`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_7`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_8`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
CREATE TABLE `t_link_gateway_log_9`
(
    `trace_id`              varchar(48)  COMMENT '链路追踪ID',
    `ip`                    varchar(48)  DEFAULT NULL COMMENT 'ip',
    `schema`                varchar(8)   DEFAULT NULL COMMENT '协议',
    `request_method`        varchar(8)   DEFAULT NULL COMMENT '请求方法',
    `request_path`          varchar(128) DEFAULT NULL COMMENT '请求路径',
    `request_content_type`  varchar(128) DEFAULT NULL COMMENT '请求数据类型',
    `request_body`          TEXT         DEFAULT NULL COMMENT '请求体',
    `response_content_type` varchar(128) DEFAULT NULL COMMENT '返回数据类型',
    `response_data`         TEXT         DEFAULT NULL COMMENT '响应体',
    `request_time`          datetime     DEFAULT NULL COMMENT '请求时间',
    `response_time`         datetime     DEFAULT NULL COMMENT '响应时间',
    `execute_time`          bigint(20)   DEFAULT NULL COMMENT '执行时间',
    `target_server`         varchar(128) DEFAULT NULL COMMENT '访问实例',
    `route_config`          TEXT         DEFAULT NULL COMMENT '路由配置',
    primary key (`trace_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;