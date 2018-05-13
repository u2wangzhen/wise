/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : wise

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-05-13 22:32:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_class_record
-- ----------------------------
DROP TABLE IF EXISTS `t_class_record`;
CREATE TABLE `t_class_record` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `cid` varchar(50) DEFAULT NULL COMMENT '课程id',
  `record_data` datetime DEFAULT NULL COMMENT '登记时间',
  `start_time` datetime DEFAULT NULL COMMENT '上课时间',
  `end_time` datetime DEFAULT NULL COMMENT '下课时间',
  `class_hour` double DEFAULT NULL COMMENT '课时',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_curriculum
-- ----------------------------
DROP TABLE IF EXISTS `t_curriculum`;
CREATE TABLE `t_curriculum` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `subject` varchar(16) DEFAULT NULL COMMENT '科目',
  `type` int(11) DEFAULT NULL COMMENT '小初高',
  `grade` varchar(16) DEFAULT NULL COMMENT '年级',
  `teacher_id` varchar(50) DEFAULT NULL COMMENT '代课老师id',
  `teacher_name` varchar(16) DEFAULT NULL COMMENT '代课老师名称',
  `start_time` datetime DEFAULT NULL COMMENT '开课时间',
  `end_time` datetime DEFAULT NULL COMMENT '结课时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_curriculum
-- ----------------------------

-- ----------------------------
-- Table structure for t_curriculum_config
-- ----------------------------
DROP TABLE IF EXISTS `t_curriculum_config`;
CREATE TABLE `t_curriculum_config` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `cid` varchar(50) DEFAULT NULL COMMENT '课程id',
  `student_count` int(11) DEFAULT NULL COMMENT '学生数量',
  `class_fee` int(11) DEFAULT NULL COMMENT '课时费',
  `teacher_price` int(11) DEFAULT NULL COMMENT '老师价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_curriculum_config
-- ----------------------------

-- ----------------------------
-- Table structure for t_curriculum_student
-- ----------------------------
DROP TABLE IF EXISTS `t_curriculum_student`;
CREATE TABLE `t_curriculum_student` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `cid` varchar(50) DEFAULT NULL COMMENT 'cid',
  `student_id` varchar(50) DEFAULT NULL COMMENT 'sutdent id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_curriculum_student
-- ----------------------------

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(16) DEFAULT NULL COMMENT '名称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `code` varchar(8) DEFAULT NULL COMMENT '编号',
  `parent_name` varchar(8) DEFAULT NULL COMMENT '父母称呼|电话',
  `parent_info` varchar(255) DEFAULT NULL COMMENT '父母信息备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `start_time` datetime DEFAULT NULL COMMENT '开始日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('dfbe3153-bd73-4b46-9347-4b0d09f443f1', 'test', '2', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_student_payment
-- ----------------------------
DROP TABLE IF EXISTS `t_student_payment`;
CREATE TABLE `t_student_payment` (
  `id` varchar(50) DEFAULT NULL COMMENT 'id',
  `student_id` varchar(50) DEFAULT NULL COMMENT '学生id',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `pay_date` datetime DEFAULT NULL COMMENT '支付日期',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标记'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_payment
-- ----------------------------

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(16) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(16) DEFAULT NULL COMMENT '电话',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `class_type` varchar(64) DEFAULT NULL COMMENT '代课类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(10) unsigned DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
