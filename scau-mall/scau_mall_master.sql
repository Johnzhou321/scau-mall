/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : scau_mall_master

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2022-10-23 22:30:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_client
-- ----------------------------
DROP TABLE IF EXISTS `pms_client`;
CREATE TABLE `pms_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `id_number` varchar(20) DEFAULT NULL COMMENT '身份证',
  `telephone` varchar(50) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pms_client
-- ----------------------------
INSERT INTO `pms_client` VALUES ('8', '周小天', '44088119910607533X', '15217976491', '湛江市廉江市', '1', '2022-01-02 22:30:28', null);
INSERT INTO `pms_client` VALUES ('9', '周莫', '440881199106075330', '15217976492', null, '1', '2022-03-20 18:04:00', null);
INSERT INTO `pms_client` VALUES ('10', '周默', '440881199404048767', '15276538871', null, '1', '2022-03-20 18:06:25', null);
INSERT INTO `pms_client` VALUES ('11', '周咔咔', '440881199203049733', '15217976490', null, '1', '2022-03-20 18:08:33', null);
INSERT INTO `pms_client` VALUES ('12', '周可', '440881200202039875', '15276653887', null, '1', '2022-03-20 18:11:16', null);
INSERT INTO `pms_client` VALUES ('13', '周都', '440881199304048776', '15218765567', null, '1', '2022-03-20 18:14:59', null);
INSERT INTO `pms_client` VALUES ('14', '智能', '440881199304048777', '15276653333', null, '1', '2022-03-20 18:16:08', null);
INSERT INTO `pms_client` VALUES ('15', '周刊', '440881199303037772', '15277664444', null, '1', '2022-03-20 18:17:42', null);
INSERT INTO `pms_client` VALUES ('16', '天天', '440881200203049876', '15287664988', null, '1', '2022-03-20 18:19:15', null);
INSERT INTO `pms_client` VALUES ('17', '最终', '440881199203047766', '15234443332', null, '1', '2022-03-20 18:28:40', null);
INSERT INTO `pms_client` VALUES ('18', '周噢', '440881199304048766', '15218776559', null, '1', '2022-03-20 18:30:35', null);
INSERT INTO `pms_client` VALUES ('19', '舟中', '440881199404048776', '15277664444', null, '1', '2022-03-20 18:37:08', null);
INSERT INTO `pms_client` VALUES ('20', '周莫', '440881199203032222', '15233321122', null, '1', '2022-09-18 15:51:00', null);
INSERT INTO `pms_client` VALUES ('21', '周沫', '440881199206078799', '15234321122', null, '1', '2022-09-18 16:04:07', null);
INSERT INTO `pms_client` VALUES ('22', '舟中', '440881199206078791', '15233221122', null, '1', '2022-09-18 16:05:33', null);
INSERT INTO `pms_client` VALUES ('23', '周默', '440881199004058866', '15217973332', null, '1', '2022-09-18 16:09:51', null);
INSERT INTO `pms_client` VALUES ('24', '周么', '440881199705058833', '15234442677', null, '1', '2022-09-18 16:14:46', null);
INSERT INTO `pms_client` VALUES ('25', '周一', '4408811992070787575', '15276452154', null, '1', '2022-09-27 20:40:34', null);
INSERT INTO `pms_client` VALUES ('26', '周一', '4408811992070787575', '15276452154', null, '1', '2022-09-27 20:40:34', null);
INSERT INTO `pms_client` VALUES ('27', '周一', '4408811992070787575', '15276452154', null, '1', '2022-09-27 20:40:34', null);
INSERT INTO `pms_client` VALUES ('28', '周一', '4408811992070787575', '15276452154', null, '1', '2022-09-27 20:40:34', null);
INSERT INTO `pms_client` VALUES ('29', '周一', '4408811992070787575', '15276452154', null, '1', '2022-09-27 20:40:34', null);

-- ----------------------------
-- Table structure for pms_menu
-- ----------------------------
DROP TABLE IF EXISTS `pms_menu`;
CREATE TABLE `pms_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父节点id',
  `is_leaf` int(1) DEFAULT NULL COMMENT '是否叶子节点， 0：非叶子，1：叶子',
  `path` varchar(50) DEFAULT NULL COMMENT '路由路径',
  `status` int(1) DEFAULT NULL COMMENT '状态，0：失效，1：有效',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='订单列表';

-- ----------------------------
-- Records of pms_menu
-- ----------------------------
INSERT INTO `pms_menu` VALUES ('1', '首页', null, '0', 'home', '1', '2022-02-01 12:00:04', '2022-02-01 12:00:04');
INSERT INTO `pms_menu` VALUES ('2', '用户管理', null, '0', null, '1', '2022-02-01 12:00:03', '2022-02-01 12:00:03');
INSERT INTO `pms_menu` VALUES ('3', '用户列表', '2', '1', 'users', '1', '2022-02-01 12:00:03', '2022-02-01 12:00:03');
INSERT INTO `pms_menu` VALUES ('4', '客户管理', null, '0', null, '1', '2022-02-01 12:00:03', '2022-02-01 12:00:03');
INSERT INTO `pms_menu` VALUES ('5', '客户列表', '4', '1', 'clients', '1', '2022-02-01 12:00:04', '2022-02-01 12:00:04');
INSERT INTO `pms_menu` VALUES ('6', '订单管理', null, '0', null, '1', '2022-02-01 12:00:04', '2022-02-01 12:00:04');
INSERT INTO `pms_menu` VALUES ('7', '订单列表', '6', '1', 'orders', '1', '2022-02-01 12:00:04', '2022-02-01 12:00:04');

-- ----------------------------
-- Table structure for pms_orders
-- ----------------------------
DROP TABLE IF EXISTS `pms_orders`;
CREATE TABLE `pms_orders` (
  `order_no` char(50) NOT NULL COMMENT '订单号',
  `type` varchar(50) DEFAULT NULL,
  `apply_amount` decimal(10,2) DEFAULT NULL COMMENT '贷款金额',
  `actual_amount` decimal(10,2) DEFAULT NULL COMMENT '实际放款额度',
  `client_id` int(11) NOT NULL COMMENT '客户ID',
  `status` int(1) DEFAULT NULL COMMENT '状态，0：提交审核，1：审核中，2：审核通过，3：放款成功，4：审核不通过',
  `document_url` varchar(200) DEFAULT NULL COMMENT '审核资料',
  `audit_remark` varchar(500) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `approve_time` datetime DEFAULT NULL COMMENT '放款时间',
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pms_orders
-- ----------------------------
INSERT INTO `pms_orders` VALUES ('2203133344', '公积金', '500000.00', '500000.00', '8', '3', 'http://42.193.227.2/group1/M00/00/00/KsHjAmI15DSAbkpZAAABo97ABjw220.rar', '发手动', '2022-03-19 22:10:04', '2022-03-19 23:13:27', '2022-03-19 23:13:26', '2022-03-19 23:13:27');
INSERT INTO `pms_orders` VALUES ('2203201198', '代发工资', '50000.00', null, '16', '0', null, null, null, null, '2022-03-20 18:19:15', null);
INSERT INTO `pms_orders` VALUES ('2203201378', '车贷', '200000.00', null, '11', '0', null, null, null, null, '2022-03-20 18:08:33', null);
INSERT INTO `pms_orders` VALUES ('2203201768', '房贷,车贷', '400000.00', null, '9', '0', null, null, null, null, '2022-03-20 18:04:00', null);
INSERT INTO `pms_orders` VALUES ('2203202574', '保单', '100000.00', null, '19', '0', null, null, null, null, '2022-03-20 18:37:08', null);
INSERT INTO `pms_orders` VALUES ('2203203525', '代发工资', '300000.00', null, '12', '0', null, null, null, null, '2022-03-20 18:11:16', null);
INSERT INTO `pms_orders` VALUES ('2203204394', '房贷', '250000.00', null, '18', '0', null, null, null, null, '2022-03-20 18:30:35', null);
INSERT INTO `pms_orders` VALUES ('2203204940', '车贷,保单', '100000.00', null, '14', '0', null, null, null, null, '2022-03-20 18:16:08', null);
INSERT INTO `pms_orders` VALUES ('2203207261', '房贷,全款车', '600000.00', null, '13', '0', null, null, null, null, '2022-03-20 18:14:59', null);
INSERT INTO `pms_orders` VALUES ('2203208593', '保单', '200000.00', null, '15', '0', null, null, null, null, '2022-03-20 18:17:42', null);
INSERT INTO `pms_orders` VALUES ('2203209072', '代发工资', '20000.00', null, '17', '0', null, null, null, null, '2022-03-20 18:28:40', null);
INSERT INTO `pms_orders` VALUES ('2203209683', '全款车', '100000.00', null, '10', '0', null, null, null, null, '2022-03-20 18:06:25', null);
INSERT INTO `pms_orders` VALUES ('2209180296', '房贷', '200000.00', null, '23', '0', null, null, null, null, '2022-09-18 16:09:51', null);
INSERT INTO `pms_orders` VALUES ('2209185601', '房贷,车贷', '500000.00', null, '21', '0', null, null, null, null, '2022-09-18 16:04:07', null);
INSERT INTO `pms_orders` VALUES ('2209186354', '车贷,全款车', '100000.00', null, '20', '0', null, null, null, null, '2022-09-18 15:51:00', null);
INSERT INTO `pms_orders` VALUES ('2209187215', '全款房,车贷', '400000.00', null, '22', '0', null, null, null, null, '2022-09-18 16:05:33', null);
INSERT INTO `pms_orders` VALUES ('2209187296', '车贷,全款车', '100000.00', null, '20', '0', null, null, null, null, '2022-09-18 15:51:16', null);
INSERT INTO `pms_orders` VALUES ('2209189150', '营业执照,保单', '300000.00', null, '24', '0', null, null, null, null, '2022-09-18 16:14:46', null);
INSERT INTO `pms_orders` VALUES ('2209271677', '公积金,保单', '300000.00', null, '28', '0', null, null, null, null, '2022-09-27 20:40:34', null);
INSERT INTO `pms_orders` VALUES ('2209273843', '公积金,保单', '300000.00', null, '26', '0', null, null, null, null, '2022-09-27 20:40:34', null);
INSERT INTO `pms_orders` VALUES ('2209275120', '公积金,保单', '300000.00', null, '29', '0', null, null, null, null, '2022-09-27 20:40:34', null);
INSERT INTO `pms_orders` VALUES ('2209275579', '公积金,保单', '300000.00', null, '25', '0', null, null, null, null, '2022-09-27 20:40:34', null);
INSERT INTO `pms_orders` VALUES ('2209277419', '公积金,保单', '300000.00', null, '27', '0', null, null, null, null, '2022-09-27 20:40:34', null);
INSERT INTO `pms_orders` VALUES ('2209278037', '公积金,保单', '300000.00', null, '25', '0', null, null, null, null, '2022-09-27 20:42:13', null);

-- ----------------------------
-- Table structure for pms_user
-- ----------------------------
DROP TABLE IF EXISTS `pms_user`;
CREATE TABLE `pms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户姓名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `status` int(1) DEFAULT NULL COMMENT '状态，0：失效，1：有效',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pms_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户列表';

-- ----------------------------
-- Records of pms_user
-- ----------------------------
INSERT INTO `pms_user` VALUES ('2', 'test', '$2a$10$KOsrmg9MurF9055uyICa9OEUlQsRXD9AwgWhHN3oEqDMgPWpijUoe', '5345345@qq.com', '15298878877', '1', null, '2022-02-05 16:37:57');
INSERT INTO `pms_user` VALUES ('3', 'test2', '$2a$10$Q6Mo8KmrM1sZAZMTRVL/jeFlXHkIpr9gS1ISN1w1S5r1p0T9.na1a', '12345678@qq.com', '15266557767', '1', null, '2022-02-05 16:38:15');
INSERT INTO `pms_user` VALUES ('4', 'test3', '123456', '5435454@qq.com', '15234545654', '1', '2022-02-04 16:59:23', '2022-02-04 16:59:23');
INSERT INTO `pms_user` VALUES ('5', 'test4', '123456', '5435454@qq.com', '15234545654', '0', '2022-02-04 17:02:19', '2022-02-05 16:38:20');
INSERT INTO `pms_user` VALUES ('7', 'admin', '$2a$10$9yE3niegXHtGl4XU3u4nCOZAuCsWczvnxvJlfGzOo/J20gjU.YaM6', '819291943@qq.com', '15217976491', '1', '2022-02-04 18:12:36', '2022-02-04 18:12:36');
