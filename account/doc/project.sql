
/* 删除数据库 */
DROP DATABASE IF EXISTS account;
/* 创建数据库 */
CREATE DATABASE account CHARACTER SET 'UTF8' COLLATE 'UTF8_general_ci';
/* 使用数据库 */
use account;

/* 若存在先删除 */
DROP TABLE IF EXISTS t_user;
/* 用户表_创建 */
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `type` varchar(10) COMMENT '用户类型',
  `status` tinyint DEFAULT 1 COMMENT '状态, 0-无效，1-有效',
  `locked` tinyint DEFAULT 0 COMMENT '是否锁定, 0-无锁定，1-已锁定',  
  `loginCount` int(11) DEFAULT 0 COMMENT '登录次数',
  `lastLoginDateTime` timestamp DEFAULT current_timestamp() COMMENT '上一次登录日期时间',
  `remark` varchar(1024) COMMENT '备注',
  `createDateTime` timestamp DEFAULT current_timestamp() COMMENT '创建日期时间',
  `updateDateTime` timestamp DEFAULT current_timestamp() COMMENT '更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 COMMENT '用户表(系统用户)' DEFAULT CHARSET=UTF8;

/* 若存在先删除 */
DROP TABLE IF EXISTS t_dict;
/* 数据字典表_创建 */
CREATE TABLE `t_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) DEFAULT NULL COMMENT '编码-划分模块',
  `value` varchar(12) COMMENT '值',  
  `text` varchar(128) COMMENT '显示名称(中/英文)',
  `status` tinyint DEFAULT 1 COMMENT '状态, 0-无效，1-有效',
  `remark` varchar(1024) COMMENT '备注',  
  `createDateTime` timestamp DEFAULT current_timestamp() COMMENT '创建日期时间',
  `updateDateTime` timestamp DEFAULT current_timestamp() COMMENT '更新日期时间',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 COMMENT '数据字典表' DEFAULT CHARSET=UTF8;

/* 若存在先删除 */
DROP TABLE IF EXISTS t_resource;
/* 资源表_创建 */
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(256) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(10) COMMENT '资源类型',  
  `ownerId` int(11) COMMENT '资源所有者id',    
  `title` varchar(64) DEFAULT NULL COMMENT '资源标题',  
  `path` varchar(512) DEFAULT NULL COMMENT '资源路径',
  `status` tinyint DEFAULT 1 COMMENT '状态, 0-无效，1-有效',  
  `remark` varchar(1024) COMMENT '备注',  
  `createDateTime` timestamp DEFAULT current_timestamp() COMMENT '创建日期时间',
  `updateDateTime` timestamp DEFAULT current_timestamp() COMMENT '更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 COMMENT '资源表' DEFAULT CHARSET=UTF8;

/* 若存在先删除 */
DROP TABLE IF EXISTS t_account;
/* 账户表_创建 */
CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(128) DEFAULT NULL COMMENT '(帐号)用户名',
  `status` tinyint DEFAULT 1 COMMENT '状态, 0-无效，1-有效',    
  `password` varchar(128) DEFAULT NULL COMMENT '密码',  
  `level` varchar(2) DEFAULT NULL COMMENT '级别-数据字典code: level',
  `type` varchar(2) DEFAULT NULL COMMENT '类型-数据字典code: type',  
  `source` varchar(128) DEFAULT NULL COMMENT '来源',
  `usage` varchar(256) DEFAULT NULL COMMENT '用途',
  `expireDate` date DEFAULT NULL COMMENT '有效期至',
  `relationalAccounts` varchar(256) DEFAULT NULL COMMENT '关联帐号',    
  `mobilePhone` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
  `officialLink` varchar(1024) DEFAULT NULL COMMENT '官网',    
  `loginLink` varchar(1024) DEFAULT NULL COMMENT '登录入口',
  `location` varchar(256) DEFAULT NULL COMMENT '位置信息',       
  `remark` varchar(1024) COMMENT '备注',    
  `createDateTime` timestamp DEFAULT current_timestamp() COMMENT '创建日期时间',
  `updateDateTime` timestamp DEFAULT current_timestamp() COMMENT '更新日期时间',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 COMMENT '账户表' DEFAULT CHARSET=UTF8;


/* 用户-初始化数据 */
INSERT INTO t_user (username, password, type) 
VALUES('admin', '', 'system');

/* 数据字典-初始化数据 */
INSERT INTO t_dict (code, value, text, remark) VALUES('level', '1', '普通','');
INSERT INTO t_dict (code, value, text, remark) VALUES('level', '2', '加密', '');
INSERT INTO t_dict (code, value, text, remark) VALUES('level', '3', '绝密', '');

INSERT INTO t_dict (code, value, text, remark) VALUES('type', '1', '普通', '');
INSERT INTO t_dict (code, value, text, remark) VALUES('type', '2', '邮箱', '');
INSERT INTO t_dict (code, value, text, remark) VALUES('type', '3', '金融', '');
INSERT INTO t_dict (code, value, text, remark) VALUES('type', '4', '网络', '');

/* 账户-初始化数据 */
/* INSERT INTO t_account () VALUES(); */
/* 初始化数据 */


/* 账户-测试数据 */
INSERT INTO t_account (username, password, level, type, source, loginLink) VALUES('dearzqy2010@qq.com', '12345678910123', 1, 1, '中华英才网', 'http://www.baidu.com/');
INSERT INTO t_account (username, password, level, type, source, loginLink) VALUES('dearzqy2010@qq.com', '12345678910123', 1, 1, '中华英才网', 'http://www.baidu.com/');
INSERT INTO t_account (username, password, level, type, source, loginLink) VALUES('dearzqy2010@qq.com', '12345678910123', 1, 1, '中华英才网', 'http://www.baidu.com/');
INSERT INTO t_account (username, password, level, type, source, loginLink) VALUES('dearzqy2010@qq.com', '12345678910123', 1, 1, '中华英才网', 'http://www.baidu.com/');











