/*
Navicat MySQL Data Transfer

Source Server         : TEST
Source Server Version : 80016
Source Host           : 127.0.0.1:3306
Source Database       : design

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-05-15 14:37:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for abnormal
-- ----------------------------
DROP TABLE IF EXISTS `abnormal`;
CREATE TABLE `abnormal` (
  `abnormal_id` int(11) NOT NULL COMMENT '异常人员编号',
  `abnormal_name` varchar(50) DEFAULT NULL COMMENT '异常人员姓名',
  `abnormal_time` timestamp NULL DEFAULT NULL COMMENT '异常发生时间',
  `abnormal_comment` varchar(255) DEFAULT NULL COMMENT '异常情况说明',
  PRIMARY KEY (`abnormal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abnormal
-- ----------------------------
INSERT INTO `abnormal` VALUES ('1201701', '张三', '2021-04-23 14:31:56', '体温异常:38摄氏度');

-- ----------------------------
-- Table structure for addresschange
-- ----------------------------
DROP TABLE IF EXISTS `addresschange`;
CREATE TABLE `addresschange` (
  `change_userid` int(11) NOT NULL COMMENT '位置变化用户编号',
  `change_username` varchar(50) DEFAULT NULL COMMENT '位置变化用户姓名',
  `change_time` timestamp NULL DEFAULT NULL COMMENT '位置变化时间',
  `changeto_loc` varchar(50) DEFAULT NULL COMMENT '变化的地点',
  `loc_risklevel` varchar(255) DEFAULT NULL COMMENT '该地点的风险等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addresschange
-- ----------------------------
INSERT INTO `addresschange` VALUES ('1201701', '张三', '2021-04-20 10:26:46', '辽宁省沈阳市', '1');
INSERT INTO `addresschange` VALUES ('1201701', '张三', '2021-04-20 10:53:48', '辽宁省沈阳市', '1');
INSERT INTO `addresschange` VALUES ('1201701', '张三', '2021-04-23 14:31:56', '辽宁省鞍山市', '0');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '管理员姓名',
  `admin_password` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '管理员', '123');

-- ----------------------------
-- Table structure for appoint
-- ----------------------------
DROP TABLE IF EXISTS `appoint`;
CREATE TABLE `appoint` (
  `appoint_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约流水号',
  `appoint_userid` int(11) DEFAULT NULL COMMENT '预约者编号',
  `appoint_username` varchar(50) DEFAULT NULL COMMENT '预约者姓名',
  `appoint_phonenum` varchar(20) DEFAULT NULL,
  `appoint_project` varchar(50) DEFAULT NULL COMMENT '预约项目（核算或疫苗）',
  `appoint_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间',
  `appoint_status` varchar(50) DEFAULT NULL COMMENT '预约状态（成功或失败）',
  PRIMARY KEY (`appoint_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of appoint
-- ----------------------------
INSERT INTO `appoint` VALUES ('1', '1201704', '赵六', '15084079355', '接种疫苗', '2021-04-26 13:28:06', '预约成功');
INSERT INTO `appoint` VALUES ('2', '1201704', '赵六', '15084079355', '接种疫苗', '2021-04-26 13:28:08', '预约失败：已预约');
INSERT INTO `appoint` VALUES ('3', '1201704', '赵六', '15084079355', '核酸检测', '2021-04-26 13:28:34', '预约成功');
INSERT INTO `appoint` VALUES ('4', '1201704', '赵六', '15084079355', '核酸检测', '2021-04-26 13:28:36', '预约成功');
INSERT INTO `appoint` VALUES ('5', '1201704', '赵六', '12345678900', '核酸检测', '2021-04-26 17:32:12', '预约成功');
INSERT INTO `appoint` VALUES ('6', '1201704', '赵六', '12345678900', '接种疫苗', '2021-04-26 17:37:52', '预约失败：暂无接种疫苗');
INSERT INTO `appoint` VALUES ('7', '1201704', '赵六', '12345678900', '接种疫苗', '2021-04-26 17:38:22', '预约失败：已预约');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL COMMENT '一个无关的编号顺序',
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `class_grade` varchar(255) DEFAULT NULL COMMENT '班级',
  `idcard_number` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `phone_number` varchar(50) DEFAULT NULL COMMENT '手机号',
  `parent_phone_number` varchar(50) DEFAULT NULL COMMENT '家长手机号',
  `dormitory` varchar(50) DEFAULT NULL COMMENT '宿舍号',
  `home_loc` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `traveling_loc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '旅行史'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '姬云启', '男', '软件17-1', '130730199809072612', '15084079355', '15084079355', 'M417', '河北省张家口市怀来县', '无');

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `loc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '各城市编号',
  `loc_name` varchar(50) DEFAULT NULL COMMENT '各城市名',
  `loc_risklevel` int(11) DEFAULT NULL COMMENT '城市风险等级',
  PRIMARY KEY (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1352 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1201', '北京市', '0');
INSERT INTO `location` VALUES ('1202', '天津市', '0');
INSERT INTO `location` VALUES ('1203', '上海市', '0');
INSERT INTO `location` VALUES ('1204', '重庆市', '0');
INSERT INTO `location` VALUES ('1301', '石家庄市', '0');
INSERT INTO `location` VALUES ('1302', '唐山市', '0');
INSERT INTO `location` VALUES ('1303', '秦皇岛市', '0');
INSERT INTO `location` VALUES ('1304', '邯郸市', '0');
INSERT INTO `location` VALUES ('1305', '鞍山市', '0');
INSERT INTO `location` VALUES ('1306', '沈阳市', '1');
INSERT INTO `location` VALUES ('1307', '大连市', '0');
INSERT INTO `location` VALUES ('1308', '抚顺市', '0');
INSERT INTO `location` VALUES ('1309', '本溪市', '0');
INSERT INTO `location` VALUES ('1310', '丹东市', '0');
INSERT INTO `location` VALUES ('1311', '锦州市', '0');
INSERT INTO `location` VALUES ('1312', '营口市', '0');
INSERT INTO `location` VALUES ('1313', '阜新市', '0');
INSERT INTO `location` VALUES ('1314', '盘锦市', '0');
INSERT INTO `location` VALUES ('1315', '铁岭市', '0');
INSERT INTO `location` VALUES ('1316', '朝阳市', '0');
INSERT INTO `location` VALUES ('1317', '葫芦岛市', '0');
INSERT INTO `location` VALUES ('1318', '长春市', '0');
INSERT INTO `location` VALUES ('1319', '吉林市', '0');
INSERT INTO `location` VALUES ('1320', '四平市', '0');
INSERT INTO `location` VALUES ('1321', '辽源市', '0');
INSERT INTO `location` VALUES ('1322', '齐齐哈尔市', '0');
INSERT INTO `location` VALUES ('1323', '鸡西市', '0');
INSERT INTO `location` VALUES ('1324', '鹤岗市', '0');
INSERT INTO `location` VALUES ('1325', '双鸭山市', '0');
INSERT INTO `location` VALUES ('1326', '佳木斯市', '0');
INSERT INTO `location` VALUES ('1327', '黑河市', '0');
INSERT INTO `location` VALUES ('1328', '无锡市', '0');
INSERT INTO `location` VALUES ('1329', '徐州市', '0');
INSERT INTO `location` VALUES ('1330', '常州市', '0');
INSERT INTO `location` VALUES ('1331', '苏州市', '0');
INSERT INTO `location` VALUES ('1332', '连云港市', '0');
INSERT INTO `location` VALUES ('1333', '厦门市', '0');
INSERT INTO `location` VALUES ('1334', '福州市', '0');
INSERT INTO `location` VALUES ('1335', '呼和浩特市', '0');
INSERT INTO `location` VALUES ('1336', '昆明市', '0');
INSERT INTO `location` VALUES ('1337', '拉萨市', '0');
INSERT INTO `location` VALUES ('1338', '银川市', '0');
INSERT INTO `location` VALUES ('1339', '西宁市', '0');
INSERT INTO `location` VALUES ('1340', '乌鲁木齐市', '0');
INSERT INTO `location` VALUES ('1341', '西安市', '0');
INSERT INTO `location` VALUES ('1342', '贵阳市', '0');
INSERT INTO `location` VALUES ('1343', '郑州市', '0');
INSERT INTO `location` VALUES ('1344', '青岛市', '0');
INSERT INTO `location` VALUES ('1345', '三亚市', '0');
INSERT INTO `location` VALUES ('1346', '海口市', '0');
INSERT INTO `location` VALUES ('1347', '济南市', '0');
INSERT INTO `location` VALUES ('1348', '哈尔滨市', '0');
INSERT INTO `location` VALUES ('1349', '深圳市', '0');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_content` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('2', '测试数据', '赵六', '学生');
INSERT INTO `message` VALUES ('3', '测试数据', '赵六', '学生');
INSERT INTO `message` VALUES ('6', '赵六已被确诊为患者', '赵六', '学生');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注解编号',
  `notice_content` varchar(255) DEFAULT NULL COMMENT '注解内容',
  `notice_level` int(5) DEFAULT NULL COMMENT '该条注解的重要等级',
  `vaccine_date` timestamp NULL DEFAULT NULL,
  `vaccine_count` int(10) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for specialcon
-- ----------------------------
DROP TABLE IF EXISTS `specialcon`;
CREATE TABLE `specialcon` (
  `specialCon_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '特殊事项编号',
  `specialCon_content` varchar(255) DEFAULT NULL COMMENT '特殊事项内容',
  PRIMARY KEY (`specialCon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of specialcon
-- ----------------------------
INSERT INTO `specialcon` VALUES ('1', '这是一个没有理由的特殊情况！');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `user_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '学生' COMMENT '访客类型',
  `user_checkin` int(5) DEFAULT '0',
  `applyStatus` varchar(5) DEFAULT '0' COMMENT '申请防疫员状态[0:未申请，1:已申请]',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1201705 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1201701', '张三三', '123456', '学生', '1', '0');
INSERT INTO `user` VALUES ('1201702', '防疫员', '123', '防疫员', '0', '0');
INSERT INTO `user` VALUES ('1201703', '王五', '123', '学生', '1', '0');
INSERT INTO `user` VALUES ('1201704', '赵六', '123', '学生', '1', '0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_temperature` double(10,0) DEFAULT NULL COMMENT '体温',
  `physical_condition` varchar(255) DEFAULT NULL COMMENT '供选择的一些身体状况',
  `contact_condition` varchar(255) DEFAULT NULL COMMENT '与新冠疫情人员的接触情况',
  `user_loc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户当前地址',
  `operate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1201701', '张三', '37', '喘憋、呼吸急', '有', '辽宁省鞍山市', '2021-04-20 10:08:43');
INSERT INTO `userinfo` VALUES ('1201701', '张三', '37', '没有出现症', '无', '辽宁省沈阳市', '2021-04-20 10:53:48');
INSERT INTO `userinfo` VALUES ('1201701', '张三', '38', '没有出现症', '无', '辽宁省鞍山市', '2021-04-23 14:31:56');
INSERT INTO `userinfo` VALUES ('1201701', '张三', '37', '喘憋、呼吸急', '无', '辽宁省鞍山市', '2021-04-24 14:38:53');
INSERT INTO `userinfo` VALUES ('1201702', '李四', '37', '没有出现症', '无', '辽宁省鞍山市', '2021-04-25 12:44:56');
INSERT INTO `userinfo` VALUES ('1201703', '王五', '36', '没有出现症', '无', '辽宁省鞍山市', '2021-04-25 13:25:26');
INSERT INTO `userinfo` VALUES ('1201704', '赵六', '35', '感冒样症状：乏力、咳嗽、发烧、肌肉痛、头痛,喘憋、呼吸急促心慌、胸闷,恶心呕吐、腹泻,结膜炎（红眼病样症状表现：眼睛涩、红、有分泌物）,其他症状', '不确定', '辽宁省鞍山市沈阳市大连市', '2021-05-08 20:13:13');

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `visitor_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(50) DEFAULT NULL,
  `visitor_sex` varchar(50) DEFAULT NULL,
  `visitor_temperature` varchar(5) DEFAULT NULL,
  `visitor_phone_num` varchar(20) DEFAULT NULL,
  `visitor_car_num` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `visitor_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('1', '姬云启', '男', '37', '110', 'G5641', '2021-05-05 23:28:57');
