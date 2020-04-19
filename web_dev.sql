/*
Navicat MySQL Data Transfer

Source Server         : comp208
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : web_dev

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-04-19 00:30:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billNo` int NOT NULL AUTO_INCREMENT,
  `amount` double(255,0) NOT NULL,
  `serviceID` int NOT NULL,
  PRIMARY KEY (`billNo`),
  KEY `serviceFor` (`serviceID`),
  CONSTRAINT `serviceFor` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for binrequest
-- ----------------------------
DROP TABLE IF EXISTS `binrequest`;
CREATE TABLE `binrequest` (
  `serviceID` int NOT NULL AUTO_INCREMENT,
  `binVolumn` int DEFAULT NULL,
  `binAmount` int DEFAULT NULL,
  `serviceType` varchar(255) NOT NULL,
  PRIMARY KEY (`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of binrequest
-- ----------------------------

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `branchNo` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zip` varchar(10) NOT NULL,
  `telNo` varchar(20) DEFAULT NULL,
  `recyclingCenterAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`branchNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('1', 'King Edward Industrial Estate, Gibraltar Row', 'L3 7HJ', '0151 203 6283', 'King Edward Industrial Estate');

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `staffNo` varchar(10) NOT NULL,
  `carAllowance` varchar(10) DEFAULT NULL,
  `workState` varchar(20) DEFAULT NULL,
  `taskForDriver` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`staffNo`),
  KEY `taskFor` (`taskForDriver`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('D0001', '1', 'available', null);
INSERT INTO `driver` VALUES ('D0002', '2', 'available', null);
INSERT INTO `driver` VALUES ('D0003', '3', 'available', null);
INSERT INTO `driver` VALUES ('D0004', '4', 'available', null);
INSERT INTO `driver` VALUES ('D0005', '5', 'available', null);
INSERT INTO `driver` VALUES ('D0006', '6', 'available', null);
INSERT INTO `driver` VALUES ('D0007', '7', 'available', null);
INSERT INTO `driver` VALUES ('D0008', '8', 'available', null);
INSERT INTO `driver` VALUES ('D0009', '9', 'available', null);
INSERT INTO `driver` VALUES ('D0010', '10', 'available', null);

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `residentID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `dateJoined` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `branchNo` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `binVolume` int DEFAULT NULL,
  PRIMARY KEY (`residentID`) USING BTREE,
  UNIQUE KEY `emailUnique` (`email`),
  KEY `branchFor` (`branchNo`),
  CONSTRAINT `branchFor` FOREIGN KEY (`branchNo`) REFERENCES `branch` (`branchNo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resident
-- ----------------------------
INSERT INTO `resident` VALUES ('1', 'resident1', 'resident1@qq.com', '2020-04-18 19:09:03', 'aA123456', '1', 'X1 Liverpool One', '53.403497', '-2.981671', '30');
INSERT INTO `resident` VALUES ('2', 'resident2', 'resident2@qq.com', '2020-04-18 19:10:02', 'aA123456', '1', 'iQ Student Accommodation Great Newton House', '53.408421', '-2.970718', '30');
INSERT INTO `resident` VALUES ('3', 'resident3', 'resident3@qq.com', '2020-04-18 19:10:55', 'aA123456', '1', 'Hard Wok Cafe, Hardman Street, Liverpool', '53.40202', '-2.972562', '30');
INSERT INTO `resident` VALUES ('4', 'resident4', 'resident4@qq.com', '2020-04-18 19:11:53', 'aA123456', '1', 'Nido Student, Haigh Court, South Hunter Street, Liverpool', '53.40223', '-2.970787', '30');
INSERT INTO `resident` VALUES ('5', 'resident5', 'resident5@qq.com', '2020-04-18 19:13:49', 'aA123456', '1', 'The Liner Hotel', '53.408392', '-2.976266', '30');
INSERT INTO `resident` VALUES ('6', 'resident6', 'resident6@qq.com', '2020-04-18 19:14:27', 'aA123456', '1', 'Mercure Liverpool Atlantic Tower Hotel', '53.407546', '-2.99521', '30');
INSERT INTO `resident` VALUES ('7', 'resident7', 'resident7@qq.com', '2020-04-18 19:15:07', 'aA123456', '1', 'HM Passport Office Liverpool', '53.41044', '-2.99597', '30');
INSERT INTO `resident` VALUES ('8', 'resident8', 'resident8@qq.com', '2020-04-18 19:16:02', 'aA123456', '1', 'Picturehouse Apartments, Scotland Road, Liverpool', '53.420924', '-2.981358', '30');
INSERT INTO `resident` VALUES ('9', 'resident9', 'resident9@qq.com', '2020-04-18 19:16:20', 'aA123456', '1', 'St Anthony\'s Catholic Church', '53.422277', '-2.981385', '30');
INSERT INTO `resident` VALUES ('10', 'resident10', 'resident10@qq.com', '2020-04-18 19:16:43', 'aA123456', '1', 'Vauxhall Health Centre, Limekiln Lane, Liverpool', '53.419458', '-2.984421', '30');
INSERT INTO `resident` VALUES ('11', 'resident11', 'resident11@qq.com', '2020-04-18 19:22:12', 'aA123456', '1', 'The MMA Academy, Vulcan Street, Liverpool', '53.416959', '-2.999049', '30');

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `serviceID` int NOT NULL AUTO_INCREMENT,
  `serviceType` varchar(255) NOT NULL,
  `serviceDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `residentID` int NOT NULL,
  `serviceStatus` varchar(255) NOT NULL,
  `staffNo` varchar(10) DEFAULT NULL,
  `serviceAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`serviceID`),
  UNIQUE KEY `staffNoUni` (`staffNo`) USING BTREE,
  KEY `residentFor` (`residentID`),
  KEY `driverNoFor` (`staffNo`)
) ENGINE=InnoDB AUTO_INCREMENT=483097 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staffNo` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `position` varchar(255) DEFAULT NULL,
  `salary` double(10,2) DEFAULT NULL,
  `phoneNo` int DEFAULT NULL,
  `branchNo` int DEFAULT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`staffNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('D0001', 'Mia', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0002', 'Charlotte', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0003', 'Aiden', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0004', 'Lucas', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0005', 'Liam', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0006', 'Mason', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0007', 'Oliver', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0008', 'Elijah', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0009', 'Noah', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('D0010', 'Zoe', 'driver', '10000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('M0001', 'Sophia', 'manager', '20000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('M0002', 'Emma', 'manager', '20000.00', '123456', '1', '123456');
INSERT INTO `staff` VALUES ('M0003', 'Olivia', 'manager', '20000.00', '123456', '1', '123456');

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `vehicleID` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `branchNo` int DEFAULT NULL,
  PRIMARY KEY (`vehicleID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'truck', '1');
INSERT INTO `vehicle` VALUES ('2', 'truck', '1');
INSERT INTO `vehicle` VALUES ('3', 'truck', '1');
INSERT INTO `vehicle` VALUES ('4', 'truck', '1');
INSERT INTO `vehicle` VALUES ('5', 'truck', '1');
INSERT INTO `vehicle` VALUES ('6', 'truck', '1');
INSERT INTO `vehicle` VALUES ('7', 'truck', '1');
INSERT INTO `vehicle` VALUES ('8', 'truck', '1');
INSERT INTO `vehicle` VALUES ('9', 'truck', '1');
INSERT INTO `vehicle` VALUES ('10', 'truck', '1');
