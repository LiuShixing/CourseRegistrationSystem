/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : datas

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-07-03 16:25:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for courseoffering
-- ----------------------------
DROP TABLE IF EXISTS `courseoffering`;
CREATE TABLE `courseoffering` (
  `ID` int(11) NOT NULL,
  `Title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Dept_Name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Start_Week` int(255) DEFAULT NULL,
  `End_Week` int(255) DEFAULT NULL,
  `Time_slot_id` int(11) DEFAULT NULL,
  `Year` int(255) DEFAULT NULL,
  `Semester` int(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of courseoffering
-- ----------------------------
INSERT INTO `courseoffering` VALUES ('1', '编译原理', '计算机学院', '1', '16', '1', '2015', '2');
INSERT INTO `courseoffering` VALUES ('2', '高等数学', '数学学院', '1', '14', '2', '2015', '2');
INSERT INTO `courseoffering` VALUES ('3', '大学生英语', '外国语学院', '1', '14', '3', '2015', '2');
INSERT INTO `courseoffering` VALUES ('4', '程序设计', '计算机学院', '2', '16', '4', '2015', '2');
INSERT INTO `courseoffering` VALUES ('5', '软件工程', '计算机学院', '4', '12', '5', '2015', '2');
INSERT INTO `courseoffering` VALUES ('6', '大学生就业指导', '计算机学院', '6', '10', '6', '2015', '2');
INSERT INTO `courseoffering` VALUES ('7', '计算机网络', '计算机学院', '1', '16', '1', '2015', '1');
INSERT INTO `courseoffering` VALUES ('8', '数据库', '计算机学院', '1', '16', '2', '2015', '1');
INSERT INTO `courseoffering` VALUES ('9', '算法分析与设计', '计算机学院', '1', '16', '3', '2015', '1');
INSERT INTO `courseoffering` VALUES ('10', '课1', '计算机学院', '17', '18', '3', '2015', '2');
INSERT INTO `courseoffering` VALUES ('11', '课2', '计算机学院', '1', '16', '5', '2015', '2');
INSERT INTO `courseoffering` VALUES ('12', '课3', '计算机学院', '1', '16', '6', '2015', '2');

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Birthday` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SocialNumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Department` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`),
  CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of professor
-- ----------------------------
INSERT INTO `professor` VALUES ('24', '刘世', '2222.1.23', '教授', '123435432343', '计算机学院');
INSERT INTO `professor` VALUES ('26', '教授', '2001.1.23', '教授', '123435432343', '计算机学院');
INSERT INTO `professor` VALUES ('27', '万磁王', '2001.1.23', '教授', '123435432343', '计算机学院');
INSERT INTO `professor` VALUES ('31', '钢铁侠', '2001.1.23', '教授', '123435432343', '计算机学院');
INSERT INTO `professor` VALUES ('32', '绿巨人', '2001.2.2', '教授', '123435432343', '计算机学院');
INSERT INTO `professor` VALUES ('33', '教授', '2001.2.2', '教授', '123435432343', '计算机学院');
INSERT INTO `professor` VALUES ('40', 's', '2001.1.2', '教授', '123435432343', '计算机学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Birthday` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SocialNumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `GraduationDate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('21', '金刚狼', '2001.1.23', '123435432343', '大三', '2017.6.1');
INSERT INTO `student` VALUES ('25', '明白', '2001.1.23', '123435432343', '大三', '2017.6.1');
INSERT INTO `student` VALUES ('28', '琴', '2001.2.2', '123435432343', '大三', '2017.6.1');
INSERT INTO `student` VALUES ('29', '蜘蛛侠', '2001.2.2', '123435432343', '大三', '2017.6.1');
INSERT INTO `student` VALUES ('30', '蝙蝠侠', '2001.1.23', '123435432343', '大三', '2017.6.1');

-- ----------------------------
-- Table structure for student_take_count
-- ----------------------------
DROP TABLE IF EXISTS `student_take_count`;
CREATE TABLE `student_take_count` (
  `StuId` int(11) NOT NULL,
  `MainCount` int(11) DEFAULT NULL,
  `AlterCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`StuId`),
  CONSTRAINT `student_take_count_ibfk_1` FOREIGN KEY (`StuId`) REFERENCES `student` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_take_count
-- ----------------------------
INSERT INTO `student_take_count` VALUES ('21', '0', '0');
INSERT INTO `student_take_count` VALUES ('25', '-1', '0');
INSERT INTO `student_take_count` VALUES ('28', '1', '0');
INSERT INTO `student_take_count` VALUES ('29', '0', '0');
INSERT INTO `student_take_count` VALUES ('30', '0', '0');

-- ----------------------------
-- Table structure for takes
-- ----------------------------
DROP TABLE IF EXISTS `takes`;
CREATE TABLE `takes` (
  `Stu_id` int(11) NOT NULL,
  `Pro_id` int(11) NOT NULL,
  `CouOffer_id` int(11) NOT NULL,
  `Grade` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Semester` int(11) DEFAULT NULL,
  `Type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Stu_id`,`Pro_id`,`CouOffer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of takes
-- ----------------------------
INSERT INTO `takes` VALUES ('25', '23', '1', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('25', '23', '6', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('28', '23', '1', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('28', '23', '6', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('28', '23', '9', 'C', '2015', '1', 'main');
INSERT INTO `takes` VALUES ('28', '24', '4', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('29', '23', '1', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('29', '23', '6', '', '2015', '2', 'main');
INSERT INTO `takes` VALUES ('29', '23', '9', 'F', '2015', '1', 'main');

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `CouOffer_id` int(11) NOT NULL,
  `Pro_id` int(11) NOT NULL,
  `Student_count` int(11) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Semester` int(11) DEFAULT NULL,
  PRIMARY KEY (`CouOffer_id`,`Pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teach
-- ----------------------------
INSERT INTO `teach` VALUES ('1', '23', '3', '2015', '2');
INSERT INTO `teach` VALUES ('6', '23', '3', '2015', '2');
INSERT INTO `teach` VALUES ('9', '23', '5', '2015', '1');
INSERT INTO `teach` VALUES ('11', '33', '10', '2015', '2');

-- ----------------------------
-- Table structure for time_slot
-- ----------------------------
DROP TABLE IF EXISTS `time_slot`;
CREATE TABLE `time_slot` (
  `Time_slot_id` int(11) NOT NULL,
  `Day` int(11) NOT NULL,
  `Start_time` int(11) NOT NULL,
  `End_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`Time_slot_id`,`Day`,`Start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of time_slot
-- ----------------------------
INSERT INTO `time_slot` VALUES ('1', '3', '1', '2');
INSERT INTO `time_slot` VALUES ('1', '4', '1', '2');
INSERT INTO `time_slot` VALUES ('1', '5', '1', '2');
INSERT INTO `time_slot` VALUES ('2', '1', '5', '6');
INSERT INTO `time_slot` VALUES ('2', '5', '5', '6');
INSERT INTO `time_slot` VALUES ('3', '2', '3', '4');
INSERT INTO `time_slot` VALUES ('3', '5', '3', '4');
INSERT INTO `time_slot` VALUES ('4', '1', '7', '8');
INSERT INTO `time_slot` VALUES ('4', '4', '7', '8');
INSERT INTO `time_slot` VALUES ('5', '2', '5', '7');
INSERT INTO `time_slot` VALUES ('5', '4', '5', '7');
INSERT INTO `time_slot` VALUES ('6', '6', '9', '11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'registrar', '123');
INSERT INTO `user` VALUES ('21', 'student', '123');
INSERT INTO `user` VALUES ('24', 'professor', '123');
INSERT INTO `user` VALUES ('25', 'student', '123');
INSERT INTO `user` VALUES ('26', 'professor', '123');
INSERT INTO `user` VALUES ('27', 'professor', '123');
INSERT INTO `user` VALUES ('28', 'student', '123');
INSERT INTO `user` VALUES ('29', 'student', '123');
INSERT INTO `user` VALUES ('30', 'student', '123');
INSERT INTO `user` VALUES ('31', 'professor', '123');
INSERT INTO `user` VALUES ('32', 'professor', '123');
INSERT INTO `user` VALUES ('33', 'professor', '123');
INSERT INTO `user` VALUES ('40', 'professor', '123');
DROP TRIGGER IF EXISTS `t_on_insert_student`;
DELIMITER ;;
CREATE TRIGGER `t_on_insert_student` AFTER INSERT ON `student` FOR EACH ROW BEGIN
 insert into student_take_count values(NEW.ID,0,0);
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_on_insert_take`;
DELIMITER ;;
CREATE TRIGGER `t_on_insert_take` AFTER INSERT ON `takes` FOR EACH ROW BEGIN
 update teach set Student_count=Student_count+1 where CouOffer_id=NEW.CouOffer_id AND Pro_id=NEW.Pro_id;

 if NEW.Type='main' then
 update student_take_count set MainCount=MainCount+1 where NEW.Stu_id=StuId;
 else
update student_take_count set AlterCount=AlterCount+1 where NEW.Stu_id=StuId;
end if;

END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_on_delete_take`;
DELIMITER ;;
CREATE TRIGGER `t_on_delete_take` AFTER DELETE ON `takes` FOR EACH ROW BEGIN
 update teach set Student_count=Student_count-1 where CouOffer_id=OLD.CouOffer_id AND Pro_id=OLD.Pro_id;

if OLD.Type='main' then
 update student_take_count set MainCount=MainCount-1 where OLD.Stu_id=StuId;
 else
update student_take_count set AlterCount=AlterCount-1 where OLD.Stu_id=StuId;
end if;
END
;;
DELIMITER ;
SET FOREIGN_KEY_CHECKS=1;
