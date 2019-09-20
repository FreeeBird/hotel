-- 创建数据库
DROP DATABASE
IF EXISTS hotel;

CREATE DATABASE hotel DEFAULT CHARACTER SET utf8;
use hotel

-- 1客房类型表
CREATE TABLE
IF NOT EXISTS `room_type` (
	`type_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '类型ID',
	`room_type` VARCHAR(16) not NULL COMMENT '类型名',
	`remark` VARCHAR(128) null COMMENT '房型备注',
	`price` DOUBLE NOT NULL DEFAULT 0 COMMENT '预定价格',
	`discount` DOUBLE NOT NULL COMMENT '预定折扣',
	`area` int not null DEFAULT 12 COMMENT '房间大小:m2',
	`bed_num` int not null DEFAULT 1 COMMENT '床位',
	`bed_size` varchar(16) not null DEFAULT '1.5m*1.8m' COMMENT '床位大小',
	`window` int not null DEFAULT 0 COMMENT '是否有窗：0-无，1-有',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`type_id`),
	UNIQUE KEY `uqe_room_type` (`room_type`)

) COMMENT '房间类型表';

-- 2客房信息表
CREATE TABLE
IF NOT EXISTS `room_info` (
	`room_id` INT NOT NULL AUTO_INCREMENT COMMENT '房间id',
	`room_number` VARCHAR (8) NOT NULL COMMENT '房间号码',
	`type_id` int NOT NULL COMMENT '房间类型ID',
	`room_type` VARCHAR(16) NOT NULL COMMENT '房间类型',
	`room_price` DOUBLE NOT NULL DEFAULT 0 COMMENT '房间价格',
	`room_discount` DOUBLE NOT NULL DEFAULT 0 COMMENT '房间折扣',
	`room_status` int NOT NULL DEFAULT 1 COMMENT '房间状态:1-可预订，0-已被预订，-1：已入住，-2：不可用',
	`remark` VARCHAR(255) null COMMENT '备注',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`room_id`),
	UNIQUE KEY `uqe_room_number` (`room_number`)
) COMMENT '房间信息表';

-- 3入住退房登记信息表
CREATE TABLE
IF NOT EXISTS `check_in` (
	`check_in_id` INT AUTO_INCREMENT COMMENT '入住id',
	`order_id` int NOT NULL COMMENT '订单号',
	`room_number` VARCHAR (8) NOT NULL comment '房间号',
	`room_type` VARCHAR(16) NOT NULL COMMENT '房间类型',
	`peo_count` INT NOT NULL DEFAULT 1 COMMENT '入住人数',
	`persons` VARCHAR (255) NOT NULL COMMENT '入住人',
	`ids` VARCHAR (255) NOT NULL COMMENT '身份证号',
	`check_in_time` TIMESTAMP null DEFAULT '0000-00-00 00:00:00' COMMENT '入住时间',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`check_in_id`),
	UNIQUE KEY `uqe_order_id`(`order_id`)
) comment '入住退房登记表';

-- 4订单信息表
CREATE TABLE
IF NOT EXISTS `order_info` (
	`order_id` INT AUTO_INCREMENT COMMENT '订单号',
	`order_type` VARCHAR(8) not null COMMENT '预订方式',
	`phone` VARCHAR (16) NOT NULL COMMENT '手机号',
	`room_type` VARCHAR (16) not null COMMENT '房间类型',
	`num_of_room` int not null DEFAULT 1 COMMENT '房间数',
	`order_date` DATE not null COMMENT '预订日期',
	`order_days` INT NOT NULL DEFAULT 1 COMMENT '预定天数',
	`order_status` int not null DEFAULT 0 COMMENT '订单状态:0-已下单，1-已付款，2-已消费，-1-已取消，-2-被删除',
	`order_cost` DOUBLE NOT NULL COMMENT '订单费用',
	`create_time` TIMESTAMP null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`order_id`)
) COMMENT '订单信息表';


-- 5注册用户信息表
CREATE TABLE
IF NOT EXISTS `user_info` (
	`user_id` INT NULL AUTO_INCREMENT COMMENT '用户id',
	`username` VARCHAR (16) NOT NULL COMMENT '用户名',
	`password` VARCHAR (256) NOT NULL COMMENT '密码',
	`name` VARCHAR(16) not NULL COMMENT '姓名',
	`gender` CHAR(2) not null DEFAULT '男' COMMENT '性别',
	`phone` VARCHAR (16) NOT NULL COMMENT '手机号码',
	`email` VARCHAR (16) NULL COMMENT '邮箱地址',
	`address` VARCHAR (32) NULL COMMENT '地址',
	`idcard` VARCHAR (32) NOT NULL COMMENT '身份证号码',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`user_id`),
	UNIQUE KEY `uqe_username` (`username`)
) COMMENT '注册用户信息表';

-- 6工作人员信息表
CREATE TABLE
IF NOT EXISTS `worker_info` (
	`worker_id` INT NULL AUTO_INCREMENT COMMENT '操作员id',
	`role` VARCHAR(8) NOT NULL DEFAULT 'worker' COMMENT '角色:worker/admin',
	`username` VARCHAR (16) NOT NULL COMMENT '用户名',
	`password` VARCHAR (16) NOT NULL COMMENT '密码',
	`name` VARCHAR (8) NOT NULL comment '姓名',
	`gender` CHAR(2) not null DEFAULT '男' COMMENT '性别',
	`phone` VARCHAR (16) NOT NULL COMMENT '手机号码',
	`department` int null COMMENT '部门',
	`email` VARCHAR (16) NULL COMMENT '邮箱地址',
	`address` VARCHAR (32) NULL COMMENT '地址',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`worker_id`),
	UNIQUE KEY `uqe_username` (`username`)

) COMMENT '工作人员信息表'

-- 7酒店信息表
CREATE TABLE
IF NOT EXISTS `hotel_info` (
	`hotel_id` int not null auto_increment COMMENT '酒店id',
	`hotel_name` VARCHAR (16) NOT NULL COMMENT '酒店名',
	`phone` VARCHAR (16) NULL COMMENT '手机号',
	`telephone` VARCHAR (16) NOT NULL COMMENT '电话号码',
	`email` VARCHAR (16) NOT NULL COMMENT '电子邮箱',
	`address` VARCHAR (32) NOT NULL COMMENT '地址',
	`website` VARCHAR (16) NOT NULL COMMENT '网站',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`hotel_id`)

) comment '酒店信息表';

-- 8部门信息表
CREATE TABLE
IF NOT EXISTS `department_info` (
	`department_id` int not null auto_increment COMMENT '部门id',
	`departmen` VARCHAR(16) not null DEFAULT '可用' COMMENT '部门',
	`remark` VARCHAR(32) null COMMENT '备注',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`department_id`),
	UNIQUE KEY `uqe_status` (`departmen`)

) COMMENT '部门信息表';

-- 9预订方式表
CREATE TABLE
IF NOT EXISTS `order_type` (
	`type_id` int not null auto_increment COMMENT 'typeId',
	`type` VARCHAR(16) not null COMMENT '方式',
	`remark` VARCHAR(32) null COMMENT '备注',
	`create_time` TIMESTAMP not null DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
	`update_time` TIMESTAMP null ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY(`type_id`)
) COMMENT '预订方式表';


