/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2023-03-10 15:15:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for check_in
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `check_in_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入住id',
  `order_id` int(11) NOT NULL COMMENT '订单号',
  `room_id` int(11) NOT NULL COMMENT '房间ID',
  `room_number` varchar(8) NOT NULL COMMENT '房间号',
  `peo_count` int(11) NOT NULL DEFAULT '1' COMMENT '入住人数',
  `persons` varchar(255) NOT NULL COMMENT '入住人',
  `ids` varchar(255) NOT NULL COMMENT '身份证号',
  `check_in_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入住时间',
  `check_out_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '离店时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`check_in_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='入住退房登记表';

-- ----------------------------
-- Records of check_in
-- ----------------------------
INSERT INTO `check_in` VALUES ('1', '5', '5', '111', '1', '李元芳', '112468098654334567', '2018-12-08 17:14:05', '2018-12-18 14:05:38', '2018-12-08 17:13:33', '2018-12-18 14:05:38');
INSERT INTO `check_in` VALUES ('2', '7', '7', '112', '2', '王昭君,上官婉儿', '775432134479076664,8876543233568677789', '2018-12-11 19:10:34', '2018-12-18 14:05:53', '2018-12-12 16:07:16', '2018-12-18 14:05:53');
INSERT INTO `check_in` VALUES ('3', '11', '9', '123', '2', '黄石,吕晓明', '441982300129390022,441823900918230021', '2018-12-18 18:24:54', '2018-12-18 18:26:30', '2018-12-18 18:24:54', '2018-12-18 18:26:30');
INSERT INTO `check_in` VALUES ('4', '13', '8', '113', '1', 'baozhikuan', '11346', '2018-12-20 11:46:28', '0000-00-00 00:00:00', '2018-12-20 11:46:28', '2018-12-20 11:46:28');
INSERT INTO `check_in` VALUES ('5', '14', '12', '100', '2', '分析,社稷', '143958344085440092,1438573958392432423', '2018-12-22 13:41:06', '2018-12-22 13:41:26', '2018-12-22 13:41:06', '2018-12-22 13:41:26');
INSERT INTO `check_in` VALUES ('6', '16', '12', '100', '2', '软须,测试', '1243243254895823,23483925832728914', '2018-12-22 14:13:03', '2018-12-22 14:13:20', '2018-12-22 14:13:03', '2018-12-22 14:13:20');
INSERT INTO `check_in` VALUES ('7', '17', '12', '100', '1', 'ss', '1111111', '2018-12-25 13:48:44', '2018-12-25 13:48:55', '2018-12-25 13:48:44', '2018-12-25 13:48:55');

-- ----------------------------
-- Table structure for hotel_info
-- ----------------------------
DROP TABLE IF EXISTS `hotel_info`;
CREATE TABLE `hotel_info` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '酒店id',
  `hotel_name` varchar(16) NOT NULL COMMENT '酒店名',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `telephone` varchar(16) NOT NULL COMMENT '电话号码',
  `email` varchar(32) NOT NULL COMMENT '电子邮箱',
  `address` varchar(32) NOT NULL COMMENT '地址',
  `website` varchar(32) NOT NULL COMMENT '网站',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='酒店信息表';

-- ----------------------------
-- Records of hotel_info
-- ----------------------------
INSERT INTO `hotel_info` VALUES ('1', 'H.O大酒店', '18768866666', '0763-4831555', '1032796097@qq.com', '浙江省杭州市', 'http://hotel.mafangui.cn', '2018-11-23 10:14:44', '2019-11-23 19:39:34');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `order_type_id` int(11) NOT NULL DEFAULT '2' COMMENT '预订方式ID',
  `order_type` varchar(8) NOT NULL COMMENT '预订方式',
  `user_id` int(11) DEFAULT '0' COMMENT '预订人ID',
  `name` varchar(16) NOT NULL COMMENT '入住人',
  `phone` varchar(16) NOT NULL COMMENT '手机号',
  `room_type_id` int(11) NOT NULL COMMENT '房型ID',
  `room_type` varchar(16) NOT NULL COMMENT '房间类型',
  `order_date` date NOT NULL COMMENT '预订日期',
  `order_days` int(11) NOT NULL DEFAULT '1' COMMENT '预定天数',
  `order_status` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `order_cost` double NOT NULL COMMENT '订单费用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '2', '官网预订', '73', '刘斌', '12345854940', '3', '双床房', '2018-12-01', '3', '-1', '417', '2018-11-30 14:43:42', '2018-12-18 14:08:42');
INSERT INTO `order_info` VALUES ('2', '2', '官网预订', '73', '厚驲', '187513447889', '2', '单人房', '2018-12-03', '3', '-1', '329.4', '2018-12-01 14:43:48', '2018-12-18 14:07:26');
INSERT INTO `order_info` VALUES ('3', '2', '官网预订', '73', '路北', '184739740338', '3', '双床房', '2018-12-02', '2', '-1', '278', '2018-12-01 14:43:51', '2018-12-18 14:08:48');
INSERT INTO `order_info` VALUES ('4', '2', '官网预订', '73', '沈石溪', '19204830300', '3', '双床房', '2018-12-03', '11', '-1', '1529', '2018-12-08 14:43:55', '2018-12-18 14:08:55');
INSERT INTO `order_info` VALUES ('5', '2', '官网预订', '73', '孙铭阳', '18767176100', '3', '双床房', '2018-12-03', '1', '2', '139', '2018-12-12 14:43:58', '2018-12-18 14:09:01');
INSERT INTO `order_info` VALUES ('7', '2', '官网预订', '74', '艾青来', '13258549905', '4', '豪华大床房', '2018-12-03', '2', '2', '576', '2018-12-04 14:44:01', '2018-12-18 14:09:07');
INSERT INTO `order_info` VALUES ('8', '2', '官网预订', '77', '李小明', '16758991255', '2', '单人房', '2018-12-14', '2', '2', '219.6', '2018-12-13 19:07:31', '2018-12-18 14:36:12');
INSERT INTO `order_info` VALUES ('9', '2', '官网预订', '73', '李敏德', '12374857433', '3', '双床房', '2018-12-19', '2', '2', '278', '2018-12-18 13:59:52', '2018-12-18 14:36:14');
INSERT INTO `order_info` VALUES ('10', '2', '官网预订', '73', 'dasha', '12345678910', '4', '豪华大床房', '2018-12-18', '1', '2', '288', '2018-12-18 14:29:49', '2018-12-18 14:36:15');
INSERT INTO `order_info` VALUES ('11', '2', '官网预订', '73', '黄石', '18776558899', '2', '单人房', '2018-12-19', '1', '2', '109.8', '2018-12-18 18:23:22', '2018-12-18 18:23:22');
INSERT INTO `order_info` VALUES ('12', '2', '官网预订', '73', '报纸看', '1335424452', '2', '单人房', '2018-12-20', '1', '-1', '109.8', '2018-12-20 11:40:57', '2018-12-20 11:40:57');
INSERT INTO `order_info` VALUES ('13', '2', '官网预订', '73', '博安置款', '213164', '2', '单人房', '2018-12-20', '1', '2', '109.8', '2018-12-20 11:43:08', '2018-12-20 11:43:08');
INSERT INTO `order_info` VALUES ('14', '2', '官网预订', '79', '阮旭', '18721225599', '2', '单人房', '2018-12-24', '3', '2', '329.4', '2018-12-22 13:37:34', '2018-12-22 13:37:34');
INSERT INTO `order_info` VALUES ('15', '4', '领导安排', '0', '软须', '18768124444', '3', '双床房', '2018-12-16', '8', '0', '1112', '2018-12-22 13:39:11', '2018-12-22 13:39:11');
INSERT INTO `order_info` VALUES ('16', '2', '官网预订', '80', '测试', '18768125800', '2', '单人房', '2018-12-22', '2', '2', '219.6', '2018-12-22 14:12:03', '2018-12-22 14:12:03');
INSERT INTO `order_info` VALUES ('17', '2', '官网预订', '73', 'ss', '123', '2', '单人房', '2018-12-25', '1', '2', '109.8', '2018-12-25 13:48:13', '2018-12-25 13:48:13');
INSERT INTO `order_info` VALUES ('18', '2', '官网预订', '81', 'w', '11111111111', '2', '单人房', '2019-01-03', '1', '1', '109.8', '2019-01-03 19:30:03', '2019-01-03 19:30:03');
INSERT INTO `order_info` VALUES ('19', '2', '官网预订', '82', '123', '123', '3', '双床房', '2019-01-12', '1', '1', '139', '2019-01-11 11:06:16', '2019-01-11 11:06:16');
INSERT INTO `order_info` VALUES ('20', '2', '官网预订', '83', '苍海', '17612137467', '9', '豪华三床房', '2019-01-22', '2', '1', '1554', '2019-01-21 12:50:24', '2019-01-21 12:50:24');
INSERT INTO `order_info` VALUES ('21', '2', '官网预订', '86', 'asd', 'asd', '4', '豪华大床房', '2019-03-14', '1', '1', '288', '2019-03-14 09:20:24', '2019-03-14 09:20:24');
INSERT INTO `order_info` VALUES ('22', '2', '官网预订', '88', 'l', '123', '9', '豪华三床房', '2019-03-20', '1', '-1', '777', '2019-03-17 23:10:11', '2019-03-17 23:10:11');
INSERT INTO `order_info` VALUES ('23', '2', '官网预订', '90', '大江', '13619871632', '8', '豪华套房', '2019-03-20', '2', '1', '1136', '2019-03-20 10:39:59', '2019-03-20 10:39:59');
INSERT INTO `order_info` VALUES ('24', '2', '官网预订', '91', 'da', '123', '9', '豪华三床房', '2019-11-29', '1', '1', '777', '2019-11-23 21:45:20', '2019-11-28 21:09:22');

-- ----------------------------
-- Table structure for order_type
-- ----------------------------
DROP TABLE IF EXISTS `order_type`;
CREATE TABLE `order_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'typeId',
  `type` varchar(16) NOT NULL COMMENT '方式',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='预订方式表';

-- ----------------------------
-- Records of order_type
-- ----------------------------
INSERT INTO `order_type` VALUES ('1', '电话预订', '通过电话联系前台完成预定', '2018-11-15 16:19:21', '2019-11-28 20:26:05');
INSERT INTO `order_type` VALUES ('2', '官网预订', '在酒店官网注册用户，自主下单完成预订', '2018-11-06 16:20:09', '2018-11-14 16:20:12');
INSERT INTO `order_type` VALUES ('4', '领导安排', '通过领导为重要来宾安排客房', '2018-11-15 18:19:16', '2018-11-25 20:54:03');
INSERT INTO `order_type` VALUES ('5', '前台预订', '直接在酒店前台进行客房预订入住', '2018-11-26 19:49:33', '2018-11-26 19:49:33');
INSERT INTO `order_type` VALUES ('7', 'APP预订', '通过APP来预订客房', '2018-12-22 14:15:11', '2018-12-22 14:15:11');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `room_number` varchar(8) NOT NULL COMMENT '房间号码',
  `type_id` int(11) NOT NULL COMMENT '房间类型ID',
  `room_type` varchar(16) NOT NULL COMMENT '房间类型',
  `room_price` double NOT NULL DEFAULT '0' COMMENT '房间价格',
  `room_discount` double NOT NULL DEFAULT '0' COMMENT '房间折扣',
  `room_status` int(11) NOT NULL DEFAULT '1' COMMENT '房间状态:1-可预订，0-已被预订，-1：已入住，-2：不可用',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`room_id`),
  UNIQUE KEY `uqe_room_number` (`room_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='房间信息表';

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES ('5', '111', '3', '双床房', '156', '10', '1', '2', '2018-11-13 20:43:40', '2018-12-12 11:32:35');
INSERT INTO `room_info` VALUES ('7', '112', '4', '豪华大床房', '111', '12', '1', '哈哈哈', '2018-11-13 22:12:46', '2018-12-12 18:54:14');
INSERT INTO `room_info` VALUES ('8', '113', '2', '单人房', '123', '12', '3', '啊的洒', '2018-11-16 11:02:15', '2018-12-20 11:46:28');
INSERT INTO `room_info` VALUES ('9', '123', '2', '单人房', '99', '20', '1', '2', '2018-11-26 19:16:34', '2018-12-18 18:26:30');
INSERT INTO `room_info` VALUES ('10', '11233', '4', '豪华大床房', '233', '12', '1', '阿萨德', '2018-11-26 19:46:25', '2018-12-18 14:33:55');
INSERT INTO `room_info` VALUES ('11', '32432', '4', '豪华大床房', '123', '12', '1', '阿萨德', '0000-00-00 00:00:00', '2018-12-01 14:26:44');
INSERT INTO `room_info` VALUES ('12', '100', '2', '单人房', '108', '20', '1', '1 person', '2018-11-30 11:55:13', '2018-12-25 13:48:55');
INSERT INTO `room_info` VALUES ('13', '666', '8', '豪华套房', '777', '11', '1', '豪华套间', '2018-12-22 13:42:56', '2019-11-28 20:22:50');
INSERT INTO `room_info` VALUES ('14', '777', '9', '豪华三床房', '777', '12', '1', '豪华装修', '2018-12-22 14:14:51', '2018-12-22 14:14:51');
INSERT INTO `room_info` VALUES ('18', '909', '2', '单人房', '109.8', '22.9', '1', '', '2019-11-28 20:19:28', '2019-11-28 20:19:28');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `type_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `room_type` varchar(16) NOT NULL COMMENT '类型名',
  `remark` varchar(128) DEFAULT NULL COMMENT '房型备注',
  `price` double NOT NULL DEFAULT '0' COMMENT '预定价格',
  `discount` double NOT NULL COMMENT '预定折扣',
  `area` int(11) NOT NULL DEFAULT '12' COMMENT '房间大小:m2',
  `bed_num` int(11) NOT NULL DEFAULT '1' COMMENT '床位',
  `bed_size` varchar(16) NOT NULL DEFAULT '1.5m*1.8m' COMMENT '床位大小',
  `window` int(11) NOT NULL DEFAULT '0' COMMENT '是否有窗：0-无，1-有',
  `rest` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `uqe_room_type` (`room_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='房间类型表';

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('2', '单人房', '房间透亮，床铺舒适', '109.8', '22.9', '10', '1', '1.2', '1', '1', '2018-11-13 16:55:09', '2019-11-28 20:19:28');
INSERT INTO `room_type` VALUES ('3', '双床房', '2 Person to live', '139', '22', '12', '2', '1.5m*1.8m', '1', '0', '2018-10-31 19:32:03', '2019-01-11 11:06:30');
INSERT INTO `room_type` VALUES ('4', '豪华大床房', '宽敞大床，阳光透亮', '288', '15', '28', '1', '1.8', '1', '1', '2018-11-13 20:27:02', '2019-11-28 20:15:16');
INSERT INTO `room_type` VALUES ('5', '大床房', '舒适大床，温暖温馨', '168', '20', '14', '1', '1.5', '1', '0', '2018-11-13 20:28:08', '2018-12-03 15:16:57');
INSERT INTO `room_type` VALUES ('7', '商务双床房', '商务人士出行必选', '199', '12', '20', '2', '1.8', '0', '0', '2018-12-03 11:24:07', '2018-12-03 11:24:07');
INSERT INTO `room_type` VALUES ('8', '豪华套房', '豪华套间', '568', '5', '35', '2', '1.8', '1', '1', '2018-12-22 13:42:21', '2019-11-28 20:11:20');
INSERT INTO `room_type` VALUES ('9', '豪华三床房', '豪华三床', '777', '12', '30', '3', '1.8', '1', '2', '2018-12-22 14:14:27', '2019-03-17 23:10:40');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(16) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(256) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(16) NOT NULL COMMENT '姓名',
  `gender` char(2) NOT NULL DEFAULT '男' COMMENT '性别',
  `phone` varchar(16) NOT NULL COMMENT '手机号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱地址',
  `address` varchar(32) DEFAULT NULL COMMENT '地址',
  `idcard` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uqe_phone` (`phone`) USING BTREE,
  UNIQUE KEY `uqe_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='注册用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('12', 'user0', 'pass0', '司蕊', '女', '15902203347', '7y4ikalr@googlemail.com', '新湛路90号-13-10', '155002902231550688', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('13', 'user1', 'pass1', '刁奇善', '男', '15000492184', '0pcdc5@hotmail.com', '河北大厦113号-13-7', '137077905971370626', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('14', 'user2', 'pass2', '空友', '男', '13504010606', 'bgqpdzy5@163.net', '贮水山大厦113号-13-5', '131022008441310667', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('15', 'user3', 'pass3', '聂志河', '男', '13007413989', 'm8yf2x@yahoo.com.cn', '澳门八街123号-9-9', '138080908841380496', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('16', 'user4', 'pass4', '董梁飞', '男', '13308573145', '5qnpxg3@msn.com', '金门路146号-5-2', '150052203431500459', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('17', 'user5', 'pass5', '衡昌功', '男', '15707416676', 'voa12ru@googlemail.com', '秋阳路142号-15-5', '150052105641500768', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('18', 'user6', 'pass6', '凤翠琰', '女', '13601540822', 'p8hy3un7@126.com', '漳州街二街110号-4-9', '130014701651300723', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('19', 'user7', 'pass7', '焦永树', '男', '13802622538', 'uylsv4k@hotmail.com', '宁夏路98号-2-1', '138041006231380509', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('20', 'user8', 'pass8', '戴心', '男', '13502253514', '60wi7ri@qq.com', '广西街26号-3-1', '150053806601500816', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('21', 'user9', 'pass9', '施航', '男', '13601170914', 'q5gq21rb@yahoo.com.cn', '硕阳街125号-18-2', '133035705121330430', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('22', 'user10', 'pass10', '巩宜娣', '女', '15705104604', 'syuqfan@163.com', '居庸关街116号-19-9', '139081700871390257', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('23', 'user11', 'pass11', '宰环', '女', '15008005526', 'r6hl6jj@163.net', '鹊山广场150号-14-3', '135042502421350645', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('24', 'user12', 'pass12', '舌鹏', '男', '15601528069', 'xuys772@163.net', '台东八广场141号-9-5', '136023204721360103', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('25', 'user13', 'pass13', '奚馨', '女', '13707191699', 'ntfp3w0@hotmail.com', '新泰大厦99号-8-3', '137045102781370883', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('26', 'user14', 'pass14', '童彪林', '男', '13404156615', 'na9k2qvq@msn.com', '澳门一路88号-13-10', '153080805961530311', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('27', 'user15', 'pass15', '伍菊澜', '女', '13602777035', '9yciidvd@googlemail.com', '丽水街136号-6-5', '131002004271310589', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('28', 'user16', 'pass16', '班旭', '男', '15801762368', 'ktw6enh@aol.com', '宁国二支路40号-10-6', '150009406161500782', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('29', 'user17', 'pass17', '童福', '男', '15500527496', 'b6s47itop@gmail.com', '石岛广场137号-8-6', '131033103661310677', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('30', 'user18', 'pass18', '五超', '男', '15501533610', 'sdriz3@gmail.com', '珠海一广场20号-19-10', '132042105071320341', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('31', 'user19', 'pass19', '管健信', '男', '15101630430', 'gcfc9ew0@ask.com', '无棣街70号-1-5', '133052206051330281', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('32', 'user20', 'pass20', '太策', '男', '15200581655', 'wk8yad@aol.com', '东阿街136号-11-9', '139076304341390552', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('33', 'user21', 'pass21', '容善庆', '男', '13304126348', '21mkw0ir@126.com', '历城广场19号-2-4', '130085700861300159', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('34', 'user22', 'pass22', '佟文', '男', '15105082209', 'l0uhs96u@aol.com', '南通大厦23号-15-3', '151008800731510719', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('35', 'user23', 'pass23', '戴婕筠', '女', '15601311376', 'pqzk2v@msn.com', '瑞云街58号-8-5', '137082808401370585', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('36', 'user24', 'pass24', '龙伊纯', '女', '15706021078', '7xn2lf7@hotmail.com', '重庆大厦94号-5-5', '130035108111300690', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('37', 'user25', 'pass25', '边希', '女', '13901196618', '6ypojp@sina.com', '汶水街93号-2-4', '138018905981380101', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('38', 'user26', 'pass26', '伍兰', '女', '13807388270', 'ca6afv6s@ask.com', '芝罘路123号-8-6', '156022505691560735', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('39', 'user27', 'pass27', '倪俊', '男', '13904570746', '43zjstnll@ask.com', '杭州支广场110号-1-6', '130073600611300390', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('40', 'user28', 'pass28', '官胜斌', '男', '15603811430', 'jm65g1mnm@googlemail.com', '仙居街115号-7-4', '153046200381530325', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('41', 'user29', 'pass29', '隗军士', '男', '15004855580', 'ddcksa18y@0355.net', '大连支街112号-18-4', '155077500681550097', '2018-11-30 23:17:39', '2018-11-30 23:17:39');
INSERT INTO `user_info` VALUES ('73', 'baozhiku', '123456', '包23', '男', '18767140000', '1924389@qq.com', 'io', '1243214325436436', '2018-12-03 10:43:48', '2023-03-10 15:11:17');
INSERT INTO `user_info` VALUES ('77', 'muamua', 'muamua', '李小明', '男', '16812585899', '1032796097@qq.com', '浙江省杭州市', '441821199603192231', '2018-12-13 19:06:34', '2023-03-10 15:11:20');
INSERT INTO `user_info` VALUES ('78', 'ss', '111', 'dasd', '男', '123456788145', '111@com', 'ssss', '1111', '2018-12-18 14:30:32', '2018-12-18 14:30:32');
INSERT INTO `user_info` VALUES ('79', 'ruanxu', '123456', '阮旭', '男', '18768224455', '1239485594@qq.com', '软须', '4419284299023902244', '2018-12-22 13:37:04', '2018-12-22 13:37:04');
INSERT INTO `user_info` VALUES ('80', 'ceshi', '123456', '测试', '女', '187681257384', '1093847437@test.cn', '软须', '441821924292039902', '2018-12-22 14:11:37', '2018-12-22 14:11:37');
INSERT INTO `user_info` VALUES ('81', 'wwmm', 'wwwmmm', 'w', '男', 'fe', 'fe', 'fe', 'ef', '2019-01-03 19:28:04', '2019-01-03 19:28:04');
INSERT INTO `user_info` VALUES ('82', '123', '123', '123', '男', '123', '123', '123', '123', '2019-01-11 11:04:14', '2019-01-11 11:04:14');
INSERT INTO `user_info` VALUES ('83', '苍海', '123456', '苍海', '男', '17612137467', 'canghai0617@163.com', '上海', '325452199012134098', '2019-01-21 12:49:37', '2019-01-21 12:49:37');
INSERT INTO `user_info` VALUES ('84', 'admin', '123456', 'jim', '男', '18621709036', 'jimhu0817@163.com', 'shanghai', '110101199003075592', '2019-01-21 15:01:10', '2019-01-21 15:01:10');
INSERT INTO `user_info` VALUES ('85', 'gagechan', '123456', '陈锦瑞', '男', '13060221766', 'gage@foxmail.com', '四川省成都市', '500101199809128878', '2019-03-03 18:40:54', '2019-03-03 18:40:54');
INSERT INTO `user_info` VALUES ('86', 'asd', 'asd', 'asd', '男', 'asd', 'asd', 'asd', 'asd', '2019-03-13 11:14:22', '2019-03-13 11:14:22');
INSERT INTO `user_info` VALUES ('88', 'l', '123', '林', '男', '13367208346', '1262676539@qq.com', '北京', '5208', '2019-03-17 23:03:14', '2019-03-17 23:03:14');
INSERT INTO `user_info` VALUES ('89', 'hahah', 'asdzxc1314', '东少', '男', '15601335391', 'm15601335391@163.com', 'beijing', '1', '2019-03-18 09:21:49', '2019-03-18 09:21:49');
INSERT INTO `user_info` VALUES ('90', 'dajiang', '123456', '大江', '女', '13819234567', '649001928@163.com', '东京', '231126199109090411', '2019-03-20 10:39:14', '2019-03-20 10:39:14');
INSERT INTO `user_info` VALUES ('91', 'freee', 'e10adc3949ba59abbe56e057f20f883e', '谢建峰', '男', '18768124566', '184732@qq.com', '凤起路8号', '661723489884389232', '2019-09-20 09:39:56', '2019-11-22 21:50:58');
INSERT INTO `user_info` VALUES ('92', 'fdsafdasfdsafdsa', '202cb962ac59075b964b07152d234b70', '的萨芬', '男', '24324324', '', '', '', '2019-11-28 21:03:45', '2019-11-28 21:03:45');

-- ----------------------------
-- Table structure for worker_info
-- ----------------------------
DROP TABLE IF EXISTS `worker_info`;
CREATE TABLE `worker_info` (
  `worker_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作员id',
  `role` varchar(8) NOT NULL DEFAULT 'operator' COMMENT '角色:worker/admin',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(16) NOT NULL COMMENT '姓名',
  `gender` char(2) NOT NULL DEFAULT '男' COMMENT '性别',
  `phone` varchar(16) NOT NULL COMMENT '手机号码',
  `email` varchar(16) DEFAULT NULL COMMENT '邮箱地址',
  `address` varchar(32) DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`worker_id`),
  UNIQUE KEY `uqe_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='工作人员信息表';

-- ----------------------------
-- Records of worker_info
-- ----------------------------
INSERT INTO `worker_info` VALUES ('1', 'admin', 'admin', 'admin', '何来', '男', '18758343488', '1032@qdj.cmn', '卡基恩', '2018-11-12 15:33:50', '2018-12-18 14:02:38');
INSERT INTO `worker_info` VALUES ('5', 'operator', 'wawa', '123', '李大霄', '女', '12345678', 'aw@qqqdxx.sd', '上海市开发区', '2018-11-26 19:48:16', '2019-11-28 20:31:23');
INSERT INTO `worker_info` VALUES ('6', 'operator', 'op', 'op', '杜锋', '男', '124342', 'assf@mme.org', '陇西峰大厦', '2018-11-30 11:55:12', '2018-12-18 14:03:16');
INSERT INTO `worker_info` VALUES ('7', 'operator', 'abc', 'abc', '韩格', '女', '242424', '111@qq.mon', '北京市国芳百货', '2018-11-30 11:55:14', '2018-12-18 14:02:19');
INSERT INTO `worker_info` VALUES ('8', 'admin', 'freee', 'e10adc3949ba59abbe56e057f20f883e', '谢建峰', '男', '18768124566', '184732@qq.com', '凤起路8号', '2019-11-27 20:18:17', '2019-11-27 20:18:17');
INSERT INTO `worker_info` VALUES ('9', 'operator', 'www', 'e10adc3949ba59abbe56e057f20f883e', '放电管', '女', '234324354', '', '', '2019-11-28 20:31:55', '2019-11-28 20:31:55');
INSERT INTO `worker_info` VALUES ('10', 'operator', 'qqq', 'e10adc3949ba59abbe56e057f20f883e', 'ds', '男', '32432534', '', '', '2019-11-28 20:32:31', '2019-11-28 20:32:31');
