/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : wlk

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2020-05-13 20:38:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for login_session
-- ----------------------------
DROP TABLE IF EXISTS `login_session`;
CREATE TABLE `login_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `account` varchar(255) DEFAULT '' COMMENT '账号',
  `open_id` varchar(255) DEFAULT '' COMMENT '微信openId',
  `union_id` varchar(255) DEFAULT NULL COMMENT '微信平台唯一id',
  `token` varchar(255) DEFAULT '' COMMENT '登录token，有效期30天',
  `login_ip` varchar(255) DEFAULT '' COMMENT '登录ip',
  `source` int(4) DEFAULT '0' COMMENT '来源，小程序：1,安卓：2 ,苹果：3,web网站：4,未知：0',
  `first_login_time` bigint(20) DEFAULT '0' COMMENT '第一次登录时间戳',
  `login_updte_time` bigint(20) DEFAULT '0' COMMENT '最后一次更新时间0：代表过期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_session
-- ----------------------------
INSERT INTO `login_session` VALUES ('1', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', '6d8a02154d5299b844fa882e9b928e88', '121.36.71.144', '1', '1586395610350', '0', '2020-04-09 01:26:50', '2020-04-09 01:27:07');
INSERT INTO `login_session` VALUES ('2', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'd55768d975afc84fc756f258c805f3c6', '121.36.71.144', '1', '1586395626633', '0', '2020-04-09 01:27:07', '2020-04-09 01:27:49');
INSERT INTO `login_session` VALUES ('3', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', '1cee2a0be9aad57e5fc7a2b710e0c717', '121.36.71.144', '1', '1586395669036', '0', '2020-04-09 01:27:49', '2020-04-09 01:28:06');
INSERT INTO `login_session` VALUES ('4', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'e5d09aac6deab1dd7e813593f4d741bb', '121.36.71.144', '1', '1586395685981', '0', '2020-04-09 01:28:06', '2020-04-09 01:28:22');
INSERT INTO `login_session` VALUES ('5', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'd4e7de05cbd5bbfafbc1176fdb63fff3', '121.36.71.144', '1', '1586395701858', '0', '2020-04-09 01:28:22', '2020-04-09 01:28:33');
INSERT INTO `login_session` VALUES ('6', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', '0876758676035969cf8f3558c2b7e4cb', '121.36.71.144', '1', '1586395713345', '0', '2020-04-09 01:28:33', '2020-04-09 01:29:28');
INSERT INTO `login_session` VALUES ('7', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'abf37b1da806f69c3d7e99d756dfb039', '121.36.71.144', '1', '1586395768347', '0', '2020-04-09 01:29:28', '2020-04-09 01:30:19');
INSERT INTO `login_session` VALUES ('8', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'd76ba70f8c8274f33bcb5ef62feed605', '121.36.71.144', '1', '1586395819414', '0', '2020-04-09 01:30:19', '2020-04-09 01:30:46');
INSERT INTO `login_session` VALUES ('9', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'c515992e3dd8d8eab8a8eb61ca77960f', '121.36.71.144', '1', '1586395846331', '0', '2020-04-09 01:30:46', '2020-04-09 01:34:22');
INSERT INTO `login_session` VALUES ('10', '1', '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', 'a3093688bc479e7f3a83c9ffa8bff34c', '121.36.71.144', '1', '1586396062471', '1586396619373', '2020-04-09 01:34:22', '2020-04-09 01:43:39');
INSERT INTO `login_session` VALUES ('11', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '197390f7ce950ede4d5c116df63aa7aa', '121.36.71.144', '1', '1586396646746', '0', '2020-04-09 01:44:07', '2020-04-09 01:59:27');
INSERT INTO `login_session` VALUES ('12', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'ba85e41e432922c25a1c8d0ca14a6a72', '0:0:0:0:0:0:0:1', '1', '1586397567201', '0', '2020-04-09 01:59:27', '2020-04-09 02:03:30');
INSERT INTO `login_session` VALUES ('13', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'd6b5632211cb5f28e7510e5d3175cf47', '0:0:0:0:0:0:0:1', '1', '1586397809772', '0', '2020-04-09 02:03:30', '2020-04-09 02:07:50');
INSERT INTO `login_session` VALUES ('14', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'a4bfc3bff302e6e3c0309babac52c8ea', '0:0:0:0:0:0:0:1', '1', '1586398069684', '0', '2020-04-09 02:07:50', '2020-04-09 02:09:03');
INSERT INTO `login_session` VALUES ('15', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '85b91328cf13ddff27393a92c3e8daed', '0:0:0:0:0:0:0:1', '1', '1586398142987', '0', '2020-04-09 02:09:03', '2020-04-09 02:16:47');
INSERT INTO `login_session` VALUES ('16', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'e9ca7a10872f3fee2a003fac552379be', '0:0:0:0:0:0:0:1', '1', '1586398606959', '0', '2020-04-09 02:16:47', '2020-04-09 02:43:14');
INSERT INTO `login_session` VALUES ('17', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'a585e083353d0d8d00497e27897e4ab0', '0:0:0:0:0:0:0:1', '1', '1586400194495', '0', '2020-04-09 02:43:14', '2020-04-09 02:47:25');
INSERT INTO `login_session` VALUES ('18', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '914084ea17b74466604203b2a0183734', '0:0:0:0:0:0:0:1', '1', '1586400445805', '0', '2020-04-09 02:47:26', '2020-04-09 02:53:04');
INSERT INTO `login_session` VALUES ('19', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '0955b89918c24bb289e44fde3825cb68', '0:0:0:0:0:0:0:1', '1', '1586400783906', '0', '2020-04-09 02:53:04', '2020-04-09 03:07:09');
INSERT INTO `login_session` VALUES ('20', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '948a5a372c1f0b5a905809b43752768d', '121.36.71.144', '1', '1586401629408', '0', '2020-04-09 03:07:09', '2020-04-09 03:10:13');
INSERT INTO `login_session` VALUES ('21', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '186bab9482ab48cc97653880972d074e', '121.36.71.144', '1', '1586401812901', '0', '2020-04-09 03:10:13', '2020-04-09 03:11:19');
INSERT INTO `login_session` VALUES ('22', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'f8a188afc51c8e80148513f0dc4fe538', '121.36.71.144', '1', '1586401879417', '0', '2020-04-09 03:11:19', '2020-04-09 03:11:31');
INSERT INTO `login_session` VALUES ('23', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'c631984d7c1b597f3ffb192fac3463ba', '121.36.71.144', '1', '1586401891263', '0', '2020-04-09 03:11:31', '2020-04-09 03:12:09');
INSERT INTO `login_session` VALUES ('24', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'd7aa26b42ecc6e501810196851234f31', '121.36.71.144', '1', '1586401929500', '0', '2020-04-09 03:12:10', '2020-04-09 03:12:20');
INSERT INTO `login_session` VALUES ('25', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '17be9701a59b4666ad5ba154fcf3447f', '121.36.71.144', '1', '1586401940088', '0', '2020-04-09 03:12:20', '2020-04-09 03:13:02');
INSERT INTO `login_session` VALUES ('26', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '5894cccb93d5fe87dfb9672638ac4d38', '121.36.71.144', '1', '1586401981675', '0', '2020-04-09 03:13:02', '2020-04-09 03:13:11');
INSERT INTO `login_session` VALUES ('27', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'd7431c1c67c7352098c5fa14067b0e40', '121.36.71.144', '1', '1586401991063', '0', '2020-04-09 03:13:11', '2020-04-09 03:13:16');
INSERT INTO `login_session` VALUES ('28', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '3874c2aa33df44370b4fb5fd9c6a222c', '121.36.71.144', '1', '1586401996236', '0', '2020-04-09 03:13:16', '2020-04-09 03:13:28');
INSERT INTO `login_session` VALUES ('29', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'f7be085421470bfc8fe7b41f0faf4e3e', '121.36.71.144', '1', '1586402007695', '0', '2020-04-09 03:13:28', '2020-04-09 03:13:59');
INSERT INTO `login_session` VALUES ('30', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '43d5ce7def06fa1c385a561c4802295d', '121.36.71.144', '1', '1586402039212', '0', '2020-04-09 03:13:59', '2020-04-09 03:23:19');
INSERT INTO `login_session` VALUES ('31', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '980dc0fdf47c6d32dbe60ee9402759af', '121.36.71.144', '1', '1586402599442', '0', '2020-04-09 03:23:19', '2020-04-09 03:24:00');
INSERT INTO `login_session` VALUES ('32', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '4517ecadc6ad75a2842d9d0ee597753b', '121.36.71.144', '1', '1586402640333', '0', '2020-04-09 03:24:00', '2020-04-10 06:23:43');
INSERT INTO `login_session` VALUES ('33', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'd18051127c17136e1e6169942e5f8c60', '121.36.71.144', '1', '1586499822844', '0', '2020-04-10 06:23:43', '2020-04-10 07:05:39');
INSERT INTO `login_session` VALUES ('34', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '3b2eb8fb5b9a3e6268a9930d13a40854', '121.36.71.144', '1', '1586502338553', '0', '2020-04-10 07:05:39', '2020-04-11 04:03:07');
INSERT INTO `login_session` VALUES ('35', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '64e73eda7b0b5bd07f530f689cf96950', '121.36.71.144', '1', '1586577786959', '0', '2020-04-11 04:03:07', '2020-04-11 04:04:47');
INSERT INTO `login_session` VALUES ('36', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '021a5009e4e520abdbd8d65651413b20', '121.36.71.144', '1', '1586577886985', '0', '2020-04-11 04:04:47', '2020-04-11 04:04:53');
INSERT INTO `login_session` VALUES ('37', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '898d29eb603a33157893133c65d09bcf', '121.36.71.144', '1', '1586577893440', '0', '2020-04-11 04:04:53', '2020-04-11 11:00:39');
INSERT INTO `login_session` VALUES ('38', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '61d8f3ca12562399c1aa76d456ede166', '115.172.91.48', '1', '1586602839405', '0', '2020-04-11 11:00:39', '2020-04-11 12:26:44');
INSERT INTO `login_session` VALUES ('39', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '445c05134c1557bd14fe9b596d67c06a', '127.0.0.1', '1', '1586608003922', '0', '2020-04-11 12:26:44', '2020-04-12 02:25:58');
INSERT INTO `login_session` VALUES ('40', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '8a7724b7c96462c0d6212d0816195d12', '115.172.91.48', '1', '1586658357781', '0', '2020-04-12 02:25:58', '2020-04-12 02:28:51');
INSERT INTO `login_session` VALUES ('41', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'f1d479237f1428bd8009385590ef6b3f', '115.172.91.48', '1', '1586658530748', '0', '2020-04-12 02:28:51', '2020-04-15 06:39:55');
INSERT INTO `login_session` VALUES ('42', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'c7ee9d921ba7fbb6f42a2b3c9e907e93', '101.95.159.254', '1', '1586932795281', '0', '2020-04-15 06:39:55', '2020-04-15 06:40:51');
INSERT INTO `login_session` VALUES ('43', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', 'a5fd07a0fa8e00685ebc17eacb675a31', '127.0.0.1', '1', '1586932851374', '0', '2020-04-15 06:40:51', '2020-04-15 06:42:00');
INSERT INTO `login_session` VALUES ('44', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '5ce16731d3d276e8e9d028ebcb37ec6c', '127.0.0.1', '1', '1586932919754', '0', '2020-04-15 06:42:00', '2020-04-24 06:14:10');
INSERT INTO `login_session` VALUES ('45', '2', '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '0131fc70d89012b91092e15c0130b9b0', '0:0:0:0:0:0:0:1', '1', '1587708850957', '1589174899983', '2020-04-24 06:14:10', '2020-05-11 05:28:19');

-- ----------------------------
-- Table structure for product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `product_attribute`;
CREATE TABLE `product_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `attribute_content` varchar(255) DEFAULT '' COMMENT '属性内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品属性表';

-- ----------------------------
-- Records of product_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_name` varchar(255) DEFAULT '' COMMENT '分类名称',
  `type_logo` varchar(255) DEFAULT '' COMMENT '分类logo',
  `type_status` int(4) DEFAULT '0' COMMENT '分类状态0:无效，1:有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='产品类型';

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '今日爆款', 'http://localhost:8070/shop/img/preview?name=nav1.png', '1', '2020-04-24 15:42:17', '2020-04-24 15:42:17');
INSERT INTO `product_type` VALUES ('2', '精选家电', 'http://localhost:8070/shop/img/preview?name=nav2.png', '1', '2020-04-24 15:42:17', '2020-04-24 15:42:17');
INSERT INTO `product_type` VALUES ('3', '美妆护理', 'http://localhost:8070/shop/img/preview?name=nav3.png', '1', '2020-04-24 15:42:17', '2020-04-24 15:42:17');
INSERT INTO `product_type` VALUES ('4', '百货电器', 'http://localhost:8070/shop/img/preview?name=nav4.png', '1', '2020-04-24 15:42:17', '2020-04-24 15:42:17');
INSERT INTO `product_type` VALUES ('5', '食品饮料', 'http://localhost:8070/shop/img/preview?name=nav5.png', '1', '2020-04-24 15:42:17', '2020-04-24 15:42:17');

-- ----------------------------
-- Table structure for receive_address
-- ----------------------------
DROP TABLE IF EXISTS `receive_address`;
CREATE TABLE `receive_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `receive_name` varchar(255) DEFAULT '' COMMENT '收货人',
  `receive_phone` varchar(255) DEFAULT '' COMMENT '收货人手机号',
  `provice` varchar(255) DEFAULT '' COMMENT '省',
  `city` varchar(255) DEFAULT '' COMMENT '市',
  `area` varchar(255) DEFAULT '' COMMENT '区/县',
  `receive_address` varchar(500) DEFAULT '' COMMENT '详细收货地址',
  `default_flag` int(4) DEFAULT '0' COMMENT '是否是默认地址0:不是，1:是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='收货地址表';

-- ----------------------------
-- Records of receive_address
-- ----------------------------
INSERT INTO `receive_address` VALUES ('1', '1', '小明', '17858596523', '河南省', '郑州市', '中原区', '河南省郑州市中原区一马路124号11楼', '1', '2020-04-25 16:21:41', '2020-04-26 06:12:10');
INSERT INTO `receive_address` VALUES ('2', '1', '小李', '17858596523', '河南省', '郑州市', '中原区', '河南省郑州市中原区二马路154号15楼', '0', '2020-04-25 16:21:41', '2020-04-26 05:33:54');
INSERT INTO `receive_address` VALUES ('3', '1', '小黑', '17858596523', '河南省', '郑州市', '中原区', '河南省郑州市中原区三马路132号32楼', '0', '2020-04-25 16:21:41', '2020-04-25 13:22:19');

-- ----------------------------
-- Table structure for shop_car
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `pro_name` varchar(255) DEFAULT '' COMMENT '商品名称',
  `pro_id` int(11) DEFAULT NULL COMMENT '商品id',
  `pro_logo` varchar(500) DEFAULT '' COMMENT '商品logo',
  `pro_price` bigint(20) DEFAULT '0' COMMENT '价格（分）',
  `pro_num` int(11) DEFAULT '1' COMMENT '商品数量',
  `source` int(4) DEFAULT '0' COMMENT '来源',
  `car_status` int(4) DEFAULT '0' COMMENT '购物车状态0：未删除，1：已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of shop_car
-- ----------------------------

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT '' COMMENT '用户名',
  `transaction_no` varchar(255) DEFAULT '' COMMENT '交易号',
  `serial_no` varchar(255) DEFAULT '' COMMENT '支付流水号',
  `order_no` varchar(255) DEFAULT '' COMMENT '订单号',
  `order_total` bigint(20) DEFAULT '0' COMMENT '订单总金额',
  `coupon_id` bigint(20) DEFAULT '0' COMMENT '使用的优惠券id',
  `receive_address` varchar(255) DEFAULT '' COMMENT '收货地址',
  `receive_name` varchar(255) DEFAULT '' COMMENT '收货人姓名',
  `receive_phone` varchar(255) DEFAULT '' COMMENT '收货人手机号',
  `order_status` int(4) DEFAULT '0' COMMENT '订单状态0：待付款，1：待发货，2：待确认收获，3：待评价，4：已完成，5：已取消，6:已退款',
  `source` int(4) DEFAULT '0' COMMENT '来源',
  `time_start` datetime DEFAULT NULL COMMENT '交易起始时间',
  `time_expire` datetime DEFAULT NULL COMMENT '交易结束时间',
  `pay_method` int(4) DEFAULT '0' COMMENT '支付方式1:微信，2:支付宝,3:ios,4:银行卡',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES ('1', '1', '小明', 'T-e30a67c82a-20200426140158486', '', 'W-da697aa436-20200426140158486', '30003', '0', '河南省郑州市中原区二马路154号15楼', '小李', '17858596523', '0', '1', '2020-04-26 06:01:58', null, '1', null, '2020-04-26 06:01:58', '2020-04-26 06:01:58');
INSERT INTO `shop_order` VALUES ('2', '1', '小明', 'T-d606838ee8-20200426140207953', '', 'W-03650cb3bb-20200426140207953', '30003', '0', '河南省郑州市中原区二马路154号15楼', '小李', '17858596523', '0', '1', '2020-04-26 06:02:07', null, '1', null, '2020-04-26 06:02:07', '2020-04-26 06:02:07');
INSERT INTO `shop_order` VALUES ('3', '1', '小明', 'T-cfecc68382-20200426141157830', '', 'W-ad9b1b451c-20200426141157828', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小李', '17858596523', '0', '1', '2020-04-26 06:11:57', null, '1', null, '2020-04-26 06:11:57', '2020-04-26 06:11:57');
INSERT INTO `shop_order` VALUES ('4', '1', '小明', 'T-786f86819a-20200426141242309', '', 'W-2f553fe230-20200426141242309', '1200', '0', '河南省郑州市中原区二马路154号15楼', '小李', '17858596523', '0', '1', '2020-04-26 06:12:42', null, '1', null, '2020-04-26 06:12:42', '2020-04-26 06:12:42');
INSERT INTO `shop_order` VALUES ('5', '1', '小明', 'T-ba1be687ee-20200426141257840', '', 'W-eaf95fb9ac-20200426141257840', '30003', '0', '河南省郑州市中原区二马路154号15楼', '小李', '17858596523', '0', '1', '2020-04-26 06:12:57', null, '1', null, '2020-04-26 06:12:57', '2020-04-26 06:12:57');
INSERT INTO `shop_order` VALUES ('6', '1', '小明', 'T-e574ccbbae-20200426141318651', '', 'W-49aa77f600-20200426141318651', '3000', '0', '河南省郑州市中原区二马路154号15楼', '小李', '17858596523', '0', '1', '2020-04-26 06:13:18', null, '1', null, '2020-04-26 06:13:18', '2020-04-26 06:13:18');
INSERT INTO `shop_order` VALUES ('7', '1', '小明', 'T-1302d2a5f0-20200426141754037', '', 'W-6f307955e2-20200426141754037', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:17:54', null, '1', null, '2020-04-26 06:17:54', '2020-04-26 06:17:54');
INSERT INTO `shop_order` VALUES ('8', '1', '小明', 'T-60590318c2-20200426141804816', '', 'W-127254ee5a-20200426141804816', '3000', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:18:04', null, '1', null, '2020-04-26 06:18:04', '2020-04-26 06:18:04');
INSERT INTO `shop_order` VALUES ('9', '1', '小明', 'T-e4b9caba41-20200426141821675', '', 'W-7e61a73a7b-20200426141821674', '34203', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:18:21', null, '1', null, '2020-04-26 06:18:21', '2020-04-26 06:18:21');
INSERT INTO `shop_order` VALUES ('10', '1', '小明', 'T-27fd2cdb6a-20200426142053997', '', 'W-b0b1a8a718-20200426142053997', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:20:53', null, '1', null, '2020-04-26 06:20:54', '2020-04-26 06:20:54');
INSERT INTO `shop_order` VALUES ('11', '1', '小明', 'T-0ac3d1d5a5-20200426142247235', '', 'W-6307961178-20200426142247235', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:22:47', null, '1', null, '2020-04-26 06:22:47', '2020-04-26 06:22:47');
INSERT INTO `shop_order` VALUES ('12', '1', '小明', 'T-f64256dd5c-20200426142720239', '', 'W-34e4281051-20200426142720239', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:27:20', null, '1', null, '2020-04-26 06:27:20', '2020-04-26 06:27:20');
INSERT INTO `shop_order` VALUES ('13', '1', '小明', 'T-5bf59c5b0d-20200426142810609', '', 'W-1a539ea16d-20200426142810609', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:28:10', null, '1', null, '2020-04-26 06:28:10', '2020-04-26 06:28:10');
INSERT INTO `shop_order` VALUES ('14', '1', '小明', 'T-2c71c105af-20200426143052579', '', 'W-ec17742975-20200426143052578', '1200', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:30:52', null, '1', null, '2020-04-26 06:30:52', '2020-04-26 06:30:52');
INSERT INTO `shop_order` VALUES ('15', '1', '小明', 'T-2cf9188ce2-20200426144230668', '', 'W-8cce3c429a-20200426144230668', '2400', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:42:30', null, '1', null, '2020-04-26 06:42:30', '2020-04-26 06:42:30');
INSERT INTO `shop_order` VALUES ('16', '1', '小明', 'T-a11756068f-20200426144845105', '', 'W-a8791bea6d-20200426144845105', '8400', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:48:45', null, '1', null, '2020-04-26 06:48:45', '2020-04-26 06:48:45');
INSERT INTO `shop_order` VALUES ('17', '1', '小明', 'T-aa951cf35f-20200426144850519', '', 'W-5e1d415a28-20200426144850519', '120012', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:48:50', null, '1', null, '2020-04-26 06:48:50', '2020-04-26 06:48:50');
INSERT INTO `shop_order` VALUES ('18', '1', '小明', 'T-223ed457c9-20200426145258576', '', 'W-49400d5b1e-20200426145258576', '133212', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-04-26 06:52:58', null, '1', null, '2020-04-26 06:52:58', '2020-04-26 06:52:58');
INSERT INTO `shop_order` VALUES ('19', '1', '小明', 'T-32ccf28a01-20200511132519029', '', 'W-0c51474d79-20200511132519009', '6000', '0', '河南省郑州市中原区一马路124号11楼', '小明', '17858596523', '0', '1', '2020-05-11 05:25:19', null, '1', null, '2020-05-11 05:25:19', '2020-05-11 05:25:19');

-- ----------------------------
-- Table structure for shop_order_item
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_item`;
CREATE TABLE `shop_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) DEFAULT '' COMMENT '订单号',
  `pro_attribute` varchar(255) DEFAULT '' COMMENT '产品属性',
  `pro_id` bigint(20) DEFAULT '0' COMMENT '商品id',
  `pro_name` varchar(255) DEFAULT '' COMMENT '商品名称',
  `pro_logo` varchar(255) DEFAULT '' COMMENT '订单logo',
  `pro_price` bigint(20) DEFAULT '0' COMMENT '商品单价',
  `pro_sale_price` bigint(20) DEFAULT '0' COMMENT '商品实际成交总价（总价=订单*数量）',
  `pro_num` int(11) DEFAULT '0' COMMENT '商品数量',
  `coupon_id` bigint(20) DEFAULT '0' COMMENT '使用的优惠券id',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='订单子项';

-- ----------------------------
-- Records of shop_order_item
-- ----------------------------
INSERT INTO `shop_order_item` VALUES ('1', 'W-da697aa436-20200426140158486', '', '2', '物联卡2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '30003', '30003', '1', '0', null, '2020-04-26 06:01:58', '2020-04-26 06:01:58');
INSERT INTO `shop_order_item` VALUES ('2', 'W-03650cb3bb-20200426140207953', '', null, '物联卡2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '30003', '30003', '1', '0', null, '2020-04-26 06:02:07', '2020-04-26 06:02:07');
INSERT INTO `shop_order_item` VALUES ('3', 'W-ad9b1b451c-20200426141157828', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:11:57', '2020-04-26 06:11:57');
INSERT INTO `shop_order_item` VALUES ('4', 'W-2f553fe230-20200426141242309', '', null, '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:12:42', '2020-04-26 06:12:42');
INSERT INTO `shop_order_item` VALUES ('5', 'W-eaf95fb9ac-20200426141257840', '', '2', '物联卡2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '30003', '30003', '1', '0', null, '2020-04-26 06:12:57', '2020-04-26 06:12:57');
INSERT INTO `shop_order_item` VALUES ('6', 'W-49aa77f600-20200426141318651', '', '3', '物联卡3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '3000', '3000', '1', '0', null, '2020-04-26 06:13:18', '2020-04-26 06:13:18');
INSERT INTO `shop_order_item` VALUES ('7', 'W-6f307955e2-20200426141754037', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:17:54', '2020-04-26 06:17:54');
INSERT INTO `shop_order_item` VALUES ('8', 'W-127254ee5a-20200426141804816', '', '3', '物联卡3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '3000', '3000', '1', '0', null, '2020-04-26 06:18:04', '2020-04-26 06:18:04');
INSERT INTO `shop_order_item` VALUES ('9', 'W-7e61a73a7b-20200426141821674', '', null, '物联卡3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '3000', '3000', '1', '0', null, '2020-04-26 06:18:21', '2020-04-26 06:18:21');
INSERT INTO `shop_order_item` VALUES ('10', 'W-7e61a73a7b-20200426141821674', '', '2', '物联卡2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '30003', '30003', '1', '0', null, '2020-04-26 06:18:21', '2020-04-26 06:18:21');
INSERT INTO `shop_order_item` VALUES ('11', 'W-7e61a73a7b-20200426141821674', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:18:21', '2020-04-26 06:18:21');
INSERT INTO `shop_order_item` VALUES ('12', 'W-b0b1a8a718-20200426142053997', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:20:53', '2020-04-26 06:20:53');
INSERT INTO `shop_order_item` VALUES ('13', 'W-6307961178-20200426142247235', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:22:47', '2020-04-26 06:22:47');
INSERT INTO `shop_order_item` VALUES ('14', 'W-34e4281051-20200426142720239', '', null, '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:27:20', '2020-04-26 06:27:20');
INSERT INTO `shop_order_item` VALUES ('15', 'W-1a539ea16d-20200426142810609', '', null, '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:28:10', '2020-04-26 06:28:10');
INSERT INTO `shop_order_item` VALUES ('16', 'W-ec17742975-20200426143052578', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '1200', '1', '0', null, '2020-04-26 06:30:52', '2020-04-26 06:30:52');
INSERT INTO `shop_order_item` VALUES ('17', 'W-8cce3c429a-20200426144230668', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '2400', '2400', '1', '0', null, '2020-04-26 06:42:30', '2020-04-26 06:42:30');
INSERT INTO `shop_order_item` VALUES ('18', 'W-a8791bea6d-20200426144845105', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '2400', '2400', '1', '0', null, '2020-04-26 06:48:45', '2020-04-26 06:48:45');
INSERT INTO `shop_order_item` VALUES ('19', 'W-a8791bea6d-20200426144845105', '', '3', '物联卡3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '6000', '6000', '1', '0', null, '2020-04-26 06:48:45', '2020-04-26 06:48:45');
INSERT INTO `shop_order_item` VALUES ('20', 'W-5e1d415a28-20200426144850519', '', '2', '物联卡2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '60006', '120012', '2', '0', null, '2020-04-26 06:48:50', '2020-04-26 06:48:50');
INSERT INTO `shop_order_item` VALUES ('21', 'W-49400d5b1e-20200426145258576', '', '2', '物联卡2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '60006', '120012', '2', '0', null, '2020-04-26 06:52:58', '2020-04-26 06:52:58');
INSERT INTO `shop_order_item` VALUES ('22', 'W-49400d5b1e-20200426145258576', '', '1', '物联卡', 'http://localhost:8070/shop/img/preview?name=hot11.png', '2400', '7200', '3', '0', null, '2020-04-26 06:52:58', '2020-04-26 06:52:58');
INSERT INTO `shop_order_item` VALUES ('23', 'W-49400d5b1e-20200426145258576', '', '3', '物联卡3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '6000', '6000', '1', '0', null, '2020-04-26 06:52:58', '2020-04-26 06:52:58');
INSERT INTO `shop_order_item` VALUES ('24', 'W-0c51474d79-20200511132519009', '', '3', '物联卡3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '6000', '6000', '1', '0', null, '2020-05-11 05:25:19', '2020-05-11 05:25:19');

-- ----------------------------
-- Table structure for shop_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(255) DEFAULT '' COMMENT '商品名称',
  `pro_type` int(4) DEFAULT '0' COMMENT '商品类型',
  `pro_logo` varchar(500) DEFAULT '' COMMENT '商品logo',
  `pro_price` bigint(20) DEFAULT '0' COMMENT '商品价格（分）',
  `pro_num` int(11) DEFAULT '0' COMMENT '商品数量',
  `pro_desc` longtext COMMENT '商品详情',
  `pro_status` int(4) DEFAULT '0' COMMENT '商品状态0：未上架，1：已上架，2：已下架',
  `pro_del_status` int(4) DEFAULT '0' COMMENT '删除状态0：未删除，1：已删除',
  `pro_courier` int(4) DEFAULT '0' COMMENT '快递是否免费0：不免费，1：免费',
  `pro_send_place` varchar(255) DEFAULT '' COMMENT '发货地点',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of shop_product
-- ----------------------------
INSERT INTO `shop_product` VALUES ('1', '物联卡', '1', 'http://localhost:8070/shop/img/preview?name=hot11.png', '1200', '0', '122', '1', '0', '1', '1', '2020-04-09 16:27:28', '2020-04-09 16:27:30');
INSERT INTO `shop_product` VALUES ('2', '物联卡2', '2', 'http://localhost:8070/shop/img/preview?name=hot1.png', '30003', '0', '11111', '1', '0', '1', '1', '2020-04-24 15:06:43', '2020-04-24 15:06:45');
INSERT INTO `shop_product` VALUES ('3', '物联卡3', '3', 'http://localhost:8070/shop/img/preview?name=hot12.png', '3000', '0', '是为对方', '1', '0', '1', '1', '2020-04-24 15:58:25', '2020-04-24 15:58:27');

-- ----------------------------
-- Table structure for shop_transaction
-- ----------------------------
DROP TABLE IF EXISTS `shop_transaction`;
CREATE TABLE `shop_transaction` (
  `transaction_no` varchar(50) NOT NULL COMMENT '交易号',
  `appid` varchar(255) DEFAULT '' COMMENT '小程序ID',
  `mch_id` varchar(255) DEFAULT '' COMMENT '商户号',
  `nonce_str` varchar(255) DEFAULT '' COMMENT '随机字符串',
  `sign` varchar(255) DEFAULT '' COMMENT '签名',
  `sign_type` varchar(255) DEFAULT '' COMMENT '签名类型',
  `body` varchar(255) DEFAULT '' COMMENT '商品描述',
  `out_trade_no` varchar(255) DEFAULT '' COMMENT '商户订单号',
  `total_fee` bigint(20) DEFAULT NULL COMMENT '标价金额(分)',
  `spbill_create_ip` varchar(255) DEFAULT '' COMMENT '终端IP',
  `notify_url` varchar(255) DEFAULT '' COMMENT '通知地址',
  `trade_type` varchar(255) DEFAULT 'JSAPI' COMMENT '交易类型',
  `serial_no` varchar(255) DEFAULT '' COMMENT '流水号',
  `user` bigint(20) DEFAULT '0' COMMENT '用户',
  `product_id` bigint(20) DEFAULT '0' COMMENT '商品ID',
  `pay_method` int(4) DEFAULT '0' COMMENT '支付方式1:微信，2:支付宝,3:ios,4:银行卡',
  `transaction_status` int(4) DEFAULT '0' COMMENT '交易状态0：初始状态，1:支付成功，2:支付失败',
  `time_start` datetime DEFAULT NULL COMMENT '交易起始时间',
  `time_expire` datetime DEFAULT NULL COMMENT '交易结束时间',
  PRIMARY KEY (`transaction_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易表';

-- ----------------------------
-- Records of shop_transaction
-- ----------------------------
INSERT INTO `shop_transaction` VALUES ('T-0ac3d1d5a5-20200426142247235', 'wx4a4453ad26d7a5f1', '1565923801', '0794600a-c001-4bd1-a710-6f793cc57cbf', '', 'MD5', '小店商品信息', 'W-6307961178-20200426142247235', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '11', '1', '0', '2020-04-26 06:22:47', null);
INSERT INTO `shop_transaction` VALUES ('T-1302d2a5f0-20200426141754037', 'wx4a4453ad26d7a5f1', '1565923801', '92cf3d49-f842-45f5-874f-a19b742b8ee0', '', 'MD5', '小店商品信息', 'W-6f307955e2-20200426141754037', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '7', '1', '0', '2020-04-26 06:17:54', null);
INSERT INTO `shop_transaction` VALUES ('T-223ed457c9-20200426145258576', 'wx4a4453ad26d7a5f1', '1565923801', 'c8307162-1b68-477d-bd9b-7159d6fa7124', '', 'MD5', '小店商品信息', 'W-49400d5b1e-20200426145258576', '133212', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '18', '1', '0', '2020-04-26 06:52:58', null);
INSERT INTO `shop_transaction` VALUES ('T-27fd2cdb6a-20200426142053997', 'wx4a4453ad26d7a5f1', '1565923801', '9fa80356-db92-4c70-9788-dca98d6eef6d', '', 'MD5', '小店商品信息', 'W-b0b1a8a718-20200426142053997', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '10', '1', '0', '2020-04-26 06:20:54', null);
INSERT INTO `shop_transaction` VALUES ('T-2c71c105af-20200426143052579', 'wx4a4453ad26d7a5f1', '1565923801', 'a4ba476c-36cf-44d6-bff9-fc124d20db7e', '', 'MD5', '小店商品信息', 'W-ec17742975-20200426143052578', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '14', '1', '0', '2020-04-26 06:30:52', null);
INSERT INTO `shop_transaction` VALUES ('T-2cf9188ce2-20200426144230668', 'wx4a4453ad26d7a5f1', '1565923801', 'a2eb8e20-9d46-4344-84dd-450914e9bdec', '', 'MD5', '小店商品信息', 'W-8cce3c429a-20200426144230668', '2400', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '15', '1', '0', '2020-04-26 06:42:30', null);
INSERT INTO `shop_transaction` VALUES ('T-32ccf28a01-20200511132519029', 'wx4a4453ad26d7a5f1', '1565923801', '002d9c6c-cd89-4ca2-89b4-31e7b87d353a', '', 'MD5', '小店商品信息', 'W-0c51474d79-20200511132519009', '6000', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '19', '1', '0', '2020-05-11 05:25:19', null);
INSERT INTO `shop_transaction` VALUES ('T-5bf59c5b0d-20200426142810609', 'wx4a4453ad26d7a5f1', '1565923801', '4c99dca2-9a6b-47fe-8c63-583090a8671b', '', 'MD5', '小店商品信息', 'W-1a539ea16d-20200426142810609', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '13', '1', '0', '2020-04-26 06:28:10', null);
INSERT INTO `shop_transaction` VALUES ('T-60590318c2-20200426141804816', 'wx4a4453ad26d7a5f1', '1565923801', '12c17b7e-8157-4246-983e-4bc5a1ee648f', '', 'MD5', '小店商品信息', 'W-127254ee5a-20200426141804816', '3000', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '8', '1', '0', '2020-04-26 06:18:04', null);
INSERT INTO `shop_transaction` VALUES ('T-786f86819a-20200426141242309', 'wx4a4453ad26d7a5f1', '1565923801', '2b06d690-e7d0-4842-8f44-3c3821f91d03', '', 'MD5', '小店商品信息', 'W-2f553fe230-20200426141242309', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '4', '1', '0', '2020-04-26 06:12:42', null);
INSERT INTO `shop_transaction` VALUES ('T-a11756068f-20200426144845105', 'wx4a4453ad26d7a5f1', '1565923801', 'c55f1e08-ec0c-4c66-9b3e-635d04c50c47', '', 'MD5', '小店商品信息', 'W-a8791bea6d-20200426144845105', '8400', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '16', '1', '0', '2020-04-26 06:48:45', null);
INSERT INTO `shop_transaction` VALUES ('T-aa951cf35f-20200426144850519', 'wx4a4453ad26d7a5f1', '1565923801', '3fc7a5eb-a062-4dfb-b23c-d12daa76563d', '', 'MD5', '小店商品信息', 'W-5e1d415a28-20200426144850519', '120012', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '17', '1', '0', '2020-04-26 06:48:50', null);
INSERT INTO `shop_transaction` VALUES ('T-ba1be687ee-20200426141257840', 'wx4a4453ad26d7a5f1', '1565923801', '55c1bea2-e620-4d22-95e3-b406eab7994d', '', 'MD5', '小店商品信息', 'W-eaf95fb9ac-20200426141257840', '30003', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '5', '1', '0', '2020-04-26 06:12:57', null);
INSERT INTO `shop_transaction` VALUES ('T-cfecc68382-20200426141157830', 'wx4a4453ad26d7a5f1', '1565923801', 'cc3c393a-ac7e-497e-8e13-7fbb76276480', '', 'MD5', '小店商品信息', 'W-ad9b1b451c-20200426141157828', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '3', '1', '0', '2020-04-26 06:11:57', null);
INSERT INTO `shop_transaction` VALUES ('T-d606838ee8-20200426140207953', 'wx4a4453ad26d7a5f1', '1565923801', 'e7ae8806-3a34-4719-8956-ea61f3204fec', '', 'MD5', '小店商品信息', 'W-03650cb3bb-20200426140207953', '30003', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '2', '1', '0', '2020-04-26 06:02:07', null);
INSERT INTO `shop_transaction` VALUES ('T-e30a67c82a-20200426140158486', 'wx4a4453ad26d7a5f1', '1565923801', 'd8211134-755a-4b94-9850-a6ebe6e96816', '', 'MD5', '小店商品信息', 'W-da697aa436-20200426140158486', '30003', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '1', '1', '0', '2020-04-26 06:01:58', null);
INSERT INTO `shop_transaction` VALUES ('T-e4b9caba41-20200426141821675', 'wx4a4453ad26d7a5f1', '1565923801', 'e5078648-1e23-43da-ad5b-b3947a9d0bee', '', 'MD5', '小店商品信息', 'W-7e61a73a7b-20200426141821674', '34203', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '9', '1', '0', '2020-04-26 06:18:21', null);
INSERT INTO `shop_transaction` VALUES ('T-e574ccbbae-20200426141318651', 'wx4a4453ad26d7a5f1', '1565923801', '8c64c4c5-a193-4506-b383-842761e7d206', '', 'MD5', '小店商品信息', 'W-49aa77f600-20200426141318651', '3000', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '6', '1', '0', '2020-04-26 06:13:18', null);
INSERT INTO `shop_transaction` VALUES ('T-f64256dd5c-20200426142720239', 'wx4a4453ad26d7a5f1', '1565923801', '69a10e97-15ed-4dc9-848e-34d3eb5d6657', '', 'MD5', '小店商品信息', 'W-34e4281051-20200426142720239', '1200', 'localhost', 'https://runvp.com/shop/pay/weixin/callback/wxNotify', 'JSAPI', '', '1', '12', '1', '0', '2020-04-26 06:27:20', null);

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(255) DEFAULT '' COMMENT '昵称',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
  `account` varchar(255) NOT NULL DEFAULT '' COMMENT '账号',
  `open_id` varchar(255) DEFAULT '' COMMENT '小程序openid',
  `union_id` varchar(255) DEFAULT '' COMMENT '微信平台唯一id',
  `password` varchar(255) DEFAULT '' COMMENT '密码/验证码',
  `gender` int(4) DEFAULT '0' COMMENT '性别0：未知，1：男， 2：女',
  `birthday` varchar(20) DEFAULT '' COMMENT '生日',
  `height` double DEFAULT '0' COMMENT '身高CM',
  `weight` double DEFAULT '0' COMMENT '体重KG',
  `user_like` varchar(1000) DEFAULT '' COMMENT '爱好',
  `status` int(4) DEFAULT '0' COMMENT '用户状态0：未认证，1：已认证，2:认证失败 ，3：已锁定',
  `del_flag` int(4) DEFAULT '0' COMMENT '是否删除0：未删除 1：已删除',
  `source` int(4) DEFAULT '0' COMMENT '来源，小程序：1,安卓：2 ,苹果：3,web网站：4,未知：0',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`,`phone`,`account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES ('1', null, '17565252362', 'wlk_252362', '345634563456456', 'gfgfgwert4r445g5geg', '1234', null, null, null, null, null, '1', '0', '1', '2020-04-09 01:26:37', '2020-04-09 01:34:22');
INSERT INTO `shop_user` VALUES ('2', null, '17585859652', 'wlk_859652', '345634563456456', 'gfgfgwert4r445g5geg', '1234', null, null, null, null, null, '1', '0', '1', '2020-04-09 01:44:05', '2020-04-24 06:14:10');

-- ----------------------------
-- Table structure for verify_code
-- ----------------------------
DROP TABLE IF EXISTS `verify_code`;
CREATE TABLE `verify_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `verify_code` varchar(255) DEFAULT '' COMMENT '验证码',
  `source` int(4) DEFAULT '0' COMMENT '来源',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='验证码记录';

-- ----------------------------
-- Records of verify_code
-- ----------------------------
INSERT INTO `verify_code` VALUES ('1', '17565252362', '1234', '1', '2020-04-09 01:26:37');
INSERT INTO `verify_code` VALUES ('2', '17565252362', '1234', '1', '2020-04-09 01:27:05');
INSERT INTO `verify_code` VALUES ('3', '17565252362', '1234', '1', '2020-04-09 01:27:48');
INSERT INTO `verify_code` VALUES ('4', '17565252362', '1234', '1', '2020-04-09 01:28:05');
INSERT INTO `verify_code` VALUES ('5', '17565252362', '1234', '1', '2020-04-09 01:28:21');
INSERT INTO `verify_code` VALUES ('6', '17565252362', '1234', '1', '2020-04-09 01:28:33');
INSERT INTO `verify_code` VALUES ('7', '17565252362', '1234', '1', '2020-04-09 01:29:26');
INSERT INTO `verify_code` VALUES ('8', '17565252362', '1234', '1', '2020-04-09 01:29:32');
INSERT INTO `verify_code` VALUES ('9', '17565252362', '1234', '1', '2020-04-09 01:30:44');
INSERT INTO `verify_code` VALUES ('10', '17565252362', '1234', '1', '2020-04-09 01:32:34');
INSERT INTO `verify_code` VALUES ('11', '17565252362', '1234', '1', '2020-04-09 01:34:52');
INSERT INTO `verify_code` VALUES ('12', '17565252362', '1234', '1', '2020-04-09 01:38:23');
INSERT INTO `verify_code` VALUES ('13', '17585859652', '1234', '1', '2020-04-09 01:44:05');
INSERT INTO `verify_code` VALUES ('14', '17585859652', '1234', '1', '2020-04-09 01:56:09');
INSERT INTO `verify_code` VALUES ('15', '17585859652', '1234', '1', '2020-04-09 01:59:23');
INSERT INTO `verify_code` VALUES ('16', '17585859652', '1234', '1', '2020-04-09 01:59:37');
INSERT INTO `verify_code` VALUES ('17', '17585859652', '1234', '1', '2020-04-09 02:03:14');
INSERT INTO `verify_code` VALUES ('18', '17585859652', '1234', '1', '2020-04-09 02:04:00');
INSERT INTO `verify_code` VALUES ('19', '17585859652', '1234', '1', '2020-04-09 02:07:39');
INSERT INTO `verify_code` VALUES ('20', '17585859652', '1234', '1', '2020-04-09 02:09:00');
INSERT INTO `verify_code` VALUES ('21', '17585859652', '1234', '1', '2020-04-09 02:16:36');
INSERT INTO `verify_code` VALUES ('22', '17585859652', '1234', '1', '2020-04-09 02:18:21');
INSERT INTO `verify_code` VALUES ('23', '17585859652', '1234', '1', '2020-04-09 02:21:57');
INSERT INTO `verify_code` VALUES ('24', '17585859652', '1234', '1', '2020-04-09 02:36:02');
INSERT INTO `verify_code` VALUES ('25', '17585859652', '1234', '1', '2020-04-09 02:43:04');
INSERT INTO `verify_code` VALUES ('26', '17585859652', '1234', '1', '2020-04-09 02:47:17');
INSERT INTO `verify_code` VALUES ('27', '17585859652', '1234', '1', '2020-04-09 02:52:48');
INSERT INTO `verify_code` VALUES ('28', '17585859652', '1234', '1', '2020-04-09 03:06:59');
INSERT INTO `verify_code` VALUES ('29', '17585859652', '1234', '1', '2020-04-09 03:07:44');
INSERT INTO `verify_code` VALUES ('30', '17585859652', '1234', '1', '2020-04-09 03:10:18');
INSERT INTO `verify_code` VALUES ('31', '17585859652', '1234', '1', '2020-04-09 03:11:29');
INSERT INTO `verify_code` VALUES ('32', '17585859652', '1234', '1', '2020-04-09 03:11:36');
INSERT INTO `verify_code` VALUES ('33', '17585859652', '1234', '1', '2020-04-09 03:12:18');
INSERT INTO `verify_code` VALUES ('34', '17585859652', '1234', '1', '2020-04-09 03:12:32');
INSERT INTO `verify_code` VALUES ('35', '17585859652', '1234', '1', '2020-04-09 03:13:09');
INSERT INTO `verify_code` VALUES ('36', '17585859652', '1234', '1', '2020-04-09 03:13:15');
INSERT INTO `verify_code` VALUES ('37', '17585859652', '1234', '1', '2020-04-09 03:13:25');
INSERT INTO `verify_code` VALUES ('38', '17585859652', '1234', '1', '2020-04-09 03:13:57');
INSERT INTO `verify_code` VALUES ('39', '17585859652', '1234', '1', '2020-04-09 03:14:07');
INSERT INTO `verify_code` VALUES ('40', '17585859652', '1234', '1', '2020-04-09 03:17:30');
INSERT INTO `verify_code` VALUES ('41', '17585859652', '1234', '1', '2020-04-09 03:20:40');
INSERT INTO `verify_code` VALUES ('42', '17585859652', '1234', '1', '2020-04-09 03:23:43');
INSERT INTO `verify_code` VALUES ('43', '17585859652', '1234', '1', '2020-04-10 06:23:38');
INSERT INTO `verify_code` VALUES ('44', '17585859652', '1234', '1', '2020-04-10 07:05:32');
INSERT INTO `verify_code` VALUES ('45', '17585859652', '1234', '1', '2020-04-11 04:03:06');
INSERT INTO `verify_code` VALUES ('46', '17585859652', '1234', '1', '2020-04-11 04:04:46');
INSERT INTO `verify_code` VALUES ('47', '17585859652', '1234', '1', '2020-04-11 04:04:52');
INSERT INTO `verify_code` VALUES ('48', '17585859652', '1234', '1', '2020-04-11 04:05:08');
INSERT INTO `verify_code` VALUES ('49', '17585859652', '1234', '1', '2020-04-11 09:23:28');
INSERT INTO `verify_code` VALUES ('50', '17585859652', '1234', '1', '2020-04-11 09:30:09');
INSERT INTO `verify_code` VALUES ('51', '17585859652', '1234', '1', '2020-04-11 10:05:47');
INSERT INTO `verify_code` VALUES ('52', '17585859652', '1234', '1', '2020-04-11 10:09:20');
INSERT INTO `verify_code` VALUES ('53', '17585859652', '1234', '1', '2020-04-11 10:56:26');
INSERT INTO `verify_code` VALUES ('54', '17585859652', '1234', '1', '2020-04-11 11:00:02');
INSERT INTO `verify_code` VALUES ('55', '17585859652', '1234', '1', '2020-04-11 11:01:54');
INSERT INTO `verify_code` VALUES ('56', '17585859652', '1234', '1', '2020-04-11 11:20:05');
INSERT INTO `verify_code` VALUES ('57', '17585859652', '1234', '1', '2020-04-11 12:08:08');
INSERT INTO `verify_code` VALUES ('58', '17585859652', '1234', '1', '2020-04-11 12:17:24');
INSERT INTO `verify_code` VALUES ('59', '17585859652', '1234', '1', '2020-04-11 12:26:40');
INSERT INTO `verify_code` VALUES ('60', '17585859652', '1234', '1', '2020-04-11 12:32:58');
INSERT INTO `verify_code` VALUES ('61', '17585859652', '1234', '1', '2020-04-12 02:25:20');
INSERT INTO `verify_code` VALUES ('62', '17585859652', '1234', '1', '2020-04-12 02:28:49');
INSERT INTO `verify_code` VALUES ('63', '17585859652', '1234', '1', '2020-04-15 06:21:44');
INSERT INTO `verify_code` VALUES ('64', '17585859652', '1234', '1', '2020-04-15 06:26:16');
INSERT INTO `verify_code` VALUES ('65', '17585859652', '1234', '1', '2020-04-15 06:37:27');
INSERT INTO `verify_code` VALUES ('66', '17585859652', '1234', '1', '2020-04-15 06:40:41');
INSERT INTO `verify_code` VALUES ('67', '17585859652', '1234', '1', '2020-04-15 06:41:41');
INSERT INTO `verify_code` VALUES ('68', '17585859652', '1234', '1', '2020-04-23 08:13:40');
INSERT INTO `verify_code` VALUES ('69', '17585859652', '1234', '1', '2020-04-23 09:37:18');
INSERT INTO `verify_code` VALUES ('70', '17585859652', '1234', '1', '2020-04-24 04:06:37');
INSERT INTO `verify_code` VALUES ('71', '17585859652', '1234', '1', '2020-04-24 06:14:08');
