/*
 Navicat MySQL Data Transfer

 Source Server         : mypetstore
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : jpetcoop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/04/2021 10:04:06
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `userid` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `firstname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr2` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('123', '1843773386gyk@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES ('1234', '1650752558@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES ('1843773386gyk', '1843773386gyk@gmail.com', 'gyk', 'yly', NULL, '1', '1', '1', '1', '1', '1', '15732585281');
INSERT INTO `account` VALUES ('j2ee', 'yourname@yourdomain.com', 'ABC', 'XYX', NULL, '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');
INSERT INTO `account` VALUES ('liuxin', '1650752558@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '81d9d56c210d7d09422334e1e54cf0bd');

-- ----------------------------
-- Table structure for bannerdata
-- ----------------------------
DROP TABLE IF EXISTS `bannerdata`;
CREATE TABLE `bannerdata`  (
  `favcategory` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bannername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`favcategory`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bannerdata
-- ----------------------------
INSERT INTO `bannerdata` VALUES ('BIRDS', '<image src=\"../images/banner_birds.gif\">');
INSERT INTO `bannerdata` VALUES ('CATS', '<image src=\"../images/banner_cats.gif\">');
INSERT INTO `bannerdata` VALUES ('DOGS', '<image src=\"../images/banner_dogs.gif\">');
INSERT INTO `bannerdata` VALUES ('FISH', '<image src=\"../images/banner_fish.gif\">');
INSERT INTO `bannerdata` VALUES ('REPTILES', '<image src=\"../images/banner_reptiles.gif\">');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderDate` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('yly', '1002', '2020-11-18');
INSERT INTO `blog` VALUES ('yly', 'change account information', '2020-11-18');
INSERT INTO `blog` VALUES ('yly', 'EST-6', '2020-11-18');
INSERT INTO `blog` VALUES ('1843773386gyk', 'login', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'logout', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'login', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'EST-8', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', '1003', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'change account information', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'change account information', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'logout', '2020-12-08');
INSERT INTO `blog` VALUES ('1843773386gyk', 'login', '2020-12-08');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `userid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `itemid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`userid`, `itemid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('j2ee', 'EST-15', 1);
INSERT INTO `cart` VALUES ('j2ee', 'EST-17', 2);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `catid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`catid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('BIRDS', 'Birds', '<image src=\"../images/birds_icon.gif\"><font size=\"5\" color=\"blue\"> Birds</font>');
INSERT INTO `category` VALUES ('CATS', 'Cats', '<image src=\"../images/cats_icon.gif\"><font size=\"5\" color=\"blue\"> Cats</font>');
INSERT INTO `category` VALUES ('DOGS', 'Dogs', '<image src=\"../images/dogs_icon.gif\"><font size=\"5\" color=\"blue\"> Dogs</font>');
INSERT INTO `category` VALUES ('FISH', 'Fish', '<image src=\"../images/fish_icon.gif\"><font size=\"5\" color=\"blue\"> Fish</font>');
INSERT INTO `category` VALUES ('REPTILES', 'Reptiles', '<image src=\"../images/reptiles_icon.gif\"><font size=\"5\" color=\"blue\"> Reptiles</font>');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `itemid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('EST-1', 10000);
INSERT INTO `inventory` VALUES ('EST-10', 10000);
INSERT INTO `inventory` VALUES ('EST-11', 10000);
INSERT INTO `inventory` VALUES ('EST-12', 10000);
INSERT INTO `inventory` VALUES ('EST-13', 10000);
INSERT INTO `inventory` VALUES ('EST-14', 10000);
INSERT INTO `inventory` VALUES ('EST-15', 10000);
INSERT INTO `inventory` VALUES ('EST-16', 10000);
INSERT INTO `inventory` VALUES ('EST-17', 10000);
INSERT INTO `inventory` VALUES ('EST-18', 9997);
INSERT INTO `inventory` VALUES ('EST-19', 10000);
INSERT INTO `inventory` VALUES ('EST-2', 10000);
INSERT INTO `inventory` VALUES ('EST-20', 10000);
INSERT INTO `inventory` VALUES ('EST-21', 10000);
INSERT INTO `inventory` VALUES ('EST-22', 10000);
INSERT INTO `inventory` VALUES ('EST-23', 10000);
INSERT INTO `inventory` VALUES ('EST-24', 10000);
INSERT INTO `inventory` VALUES ('EST-25', 10000);
INSERT INTO `inventory` VALUES ('EST-26', 9999);
INSERT INTO `inventory` VALUES ('EST-27', 9999);
INSERT INTO `inventory` VALUES ('EST-28', 10000);
INSERT INTO `inventory` VALUES ('EST-3', 10000);
INSERT INTO `inventory` VALUES ('EST-4', 10000);
INSERT INTO `inventory` VALUES ('EST-5', 10000);
INSERT INTO `inventory` VALUES ('EST-6', 9996);
INSERT INTO `inventory` VALUES ('EST-7', 10000);
INSERT INTO `inventory` VALUES ('EST-8', 10000);
INSERT INTO `inventory` VALUES ('EST-9', 10000);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `itemid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `listprice` decimal(10, 2) NULL DEFAULT NULL,
  `unitcost` decimal(10, 2) NULL DEFAULT NULL,
  `supplier` int NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr3` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr4` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr5` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE,
  INDEX `fk_item_2`(`supplier`) USING BTREE,
  INDEX `itemProd`(`productid`) USING BTREE,
  CONSTRAINT `fk_item_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_item_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('EST-1', 'FI-SW-01', 16.50, 10.00, 1, 'P', 'Large', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-10', 'K9-DL-01', 18.50, 12.00, 1, 'P', 'Spotted Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-11', 'RP-SN-01', 18.50, 12.00, 1, 'P', 'Venomless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-12', 'RP-SN-01', 18.50, 12.00, 1, 'P', 'Rattleless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-13', 'RP-LI-02', 18.50, 12.00, 1, 'P', 'Green Adult', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-14', 'FL-DSH-01', 58.50, 12.00, 1, 'P', 'Tailless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-15', 'FL-DSH-01', 23.50, 12.00, 1, 'P', 'With tail', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-16', 'FL-DLH-02', 93.50, 12.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-17', 'FL-DLH-02', 93.50, 12.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-18', 'AV-CB-01', 193.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-19', 'AV-SB-02', 15.50, 2.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-2', 'FI-SW-01', 16.50, 10.00, 1, 'P', 'Small', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-20', 'FI-FW-02', 5.50, 2.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-21', 'FI-FW-02', 5.29, 1.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-22', 'K9-RT-02', 135.50, 100.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-23', 'K9-RT-02', 145.49, 100.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-24', 'K9-RT-02', 255.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-25', 'K9-RT-02', 325.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-26', 'K9-CW-01', 125.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-27', 'K9-CW-01', 155.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-28', 'K9-RT-01', 155.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-3', 'FI-SW-02', 18.50, 12.00, 1, 'P', 'Toothless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-4', 'FI-FW-01', 18.50, 12.00, 1, 'P', 'Spotted', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-5', 'FI-FW-01', 18.50, 12.00, 1, 'P', 'Spotless', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-6', 'K9-BD-01', 18.50, 12.00, 1, 'P', 'Male Adult', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-7', 'K9-BD-01', 18.50, 12.00, 1, 'P', 'Female Puppy', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-8', 'K9-PO-02', 18.50, 12.00, 1, 'P', 'Male Puppy', NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES ('EST-9', 'K9-DL-01', 18.50, 12.00, 1, 'P', 'Spotless Male Puppy', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for lineitem
-- ----------------------------
DROP TABLE IF EXISTS `lineitem`;
CREATE TABLE `lineitem`  (
  `orderid` int NOT NULL,
  `linenum` int NOT NULL,
  `itemid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantity` int NOT NULL,
  `unitprice` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`orderid`, `linenum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lineitem
-- ----------------------------
INSERT INTO `lineitem` VALUES (1010, 1018, 'EST-27', 1, 90.00);
INSERT INTO `lineitem` VALUES (1010, 1019, 'EST-6', 3, 12.00);
INSERT INTO `lineitem` VALUES (1011, 1020, 'EST-18', 2, 92.00);
INSERT INTO `lineitem` VALUES (1011, 1021, 'EST-6', 1, 12.00);
INSERT INTO `lineitem` VALUES (1012, 1022, 'EST-18', 1, 92.00);
INSERT INTO `lineitem` VALUES (1012, 1023, 'EST-26', 1, 92.00);

-- ----------------------------
-- Table structure for ninventory
-- ----------------------------
DROP TABLE IF EXISTS `ninventory`;
CREATE TABLE `ninventory`  (
  `Category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qty` int NOT NULL,
  `unsold` int NULL DEFAULT NULL,
  `soldout` int NULL DEFAULT NULL,
  `ordered` int NULL DEFAULT NULL,
  PRIMARY KEY (`Category`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ninventory
-- ----------------------------
INSERT INTO `ninventory` VALUES ('BIRDS', 745, 200, 500, 45);
INSERT INTO `ninventory` VALUES ('CATS', 230, 100, 120, 10);
INSERT INTO `ninventory` VALUES ('DOGS', 361, 161, 150, 50);
INSERT INTO `ninventory` VALUES ('FISH', 1023, 500, 500, 23);
INSERT INTO `ninventory` VALUES ('REPTILES', 94, 80, 10, 4);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `orderid` int NOT NULL,
  `userid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `itemid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `linenum` int NOT NULL,
  `quantity` int NOT NULL,
  `unitprice` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`linenum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (1000, 'yly', 'EST-19', 1000, 1, 16);
INSERT INTO `orderitem` VALUES (1001, 'yly', 'EST-13', 1001, 1, 19);
INSERT INTO `orderitem` VALUES (1001, 'yly', 'EST-19', 1002, 5, 16);
INSERT INTO `orderitem` VALUES (1001, 'yly', 'EST-3', 1003, 1, 19);
INSERT INTO `orderitem` VALUES (1002, 'yly', 'EST-19', 1004, 1, 16);
INSERT INTO `orderitem` VALUES (1002, 'yly', 'EST-12', 1005, 1, 19);
INSERT INTO `orderitem` VALUES (1003, '1843773386gyk', 'EST-19', 1006, 3, 16);
INSERT INTO `orderitem` VALUES (1003, '1843773386gyk', 'EST-8', 1007, 1, 19);
INSERT INTO `orderitem` VALUES (1004, '1843773386gyk', 'EST-4', 1008, 1, 19);
INSERT INTO `orderitem` VALUES (1004, '1843773386gyk', 'EST-15', 1009, 3, 24);
INSERT INTO `orderitem` VALUES (1004, '1843773386gyk', 'EST-13', 1010, 2, 19);
INSERT INTO `orderitem` VALUES (1004, '1843773386gyk', 'EST-12', 1011, 1, 19);
INSERT INTO `orderitem` VALUES (1005, '1843773386gyk', 'EST-9', 1012, 99, 19);
INSERT INTO `orderitem` VALUES (1006, '1843773386gyk', 'EST-26', 1013, 1, 126);
INSERT INTO `orderitem` VALUES (1007, '1843773386gyk', 'EST-27', 1014, 6, 155);
INSERT INTO `orderitem` VALUES (1008, '1843773386gyk', 'EST-27', 1015, 6, 155);
INSERT INTO `orderitem` VALUES (1008, '1843773386gyk', 'EST-18', 1016, 1, 194);
INSERT INTO `orderitem` VALUES (1010, '1843773386gyk', 'EST-19', 1017, 1, 16);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderid` int NOT NULL,
  `userid` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderdate` date NOT NULL,
  `shipaddr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipaddr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shipcity` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipstate` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipzip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipcountry` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billaddr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billaddr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `billcity` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billstate` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billzip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billcountry` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `courier` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `totalprice` decimal(10, 0) NOT NULL,
  `billtofirstname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `billtolastname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shiptofirstname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shiptolastname` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creditcard` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `exprdate` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardtype` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `locale` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1010, '1843773386gyk', '2021-04-09', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', 'East Wind', 0, 'gyk', 'yly', 'gyk', 'yly', 'a', 'a', 'Visa', 'china');
INSERT INTO `orders` VALUES (1011, 'liuxin', '2021-04-18', '', '', '', '', '', '', '', '', '', '', '', '', 'East Wind', 387, '', '', '', '', '', '', 'Visa', 'china');
INSERT INTO `orders` VALUES (1012, '1234', '2021-04-19', '123', '123', '123', '123', '123', '132', '123', '123', '123', '123', '123', '132', 'East Wind', 194, '123', '123', '123', '123', '123', '123', 'Visa', 'china');

-- ----------------------------
-- Table structure for orderstatus
-- ----------------------------
DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus`  (
  `orderid` int NOT NULL,
  `timestamp` date NOT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderstatus
-- ----------------------------
INSERT INTO `orderstatus` VALUES (1010, '2021-04-08', 'n');
INSERT INTO `orderstatus` VALUES (1011, '2021-04-17', 'y');
INSERT INTO `orderstatus` VALUES (1012, '2021-04-19', 'n');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`productid`) USING BTREE,
  INDEX `productName`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('AV-CB-01', 'BIRDS', 'Amazon Parrotda', '<image src=\"../images/bird2.gif\">Great companion for up to 75 years');
INSERT INTO `product` VALUES ('AV-SB-02', 'BIRDS', 'Fincha', '<image src=\"../images/bird1.gif\">Great stress reliever');
INSERT INTO `product` VALUES ('FI-FW-01', 'FISH', 'Koio', '<image src=\"../images/fish1.gif\">Fresh Water fish from Japan');
INSERT INTO `product` VALUES ('FI-FW-02', 'FISH', 'Goldfish', '<image src=\"../images/fish2.gif\">Fresh Water fish from China');
INSERT INTO `product` VALUES ('FI-SW-01', 'FISH', 'Angelfish', '<image src=\"../images/fish1.gif\">Salt Water fish from Australia');
INSERT INTO `product` VALUES ('FI-SW-02', 'FISH', 'Tiger Shark', '<image src=\"../images/fish4.gif\">Salt Water fish from Australia');
INSERT INTO `product` VALUES ('FL-DLH-02', 'CATS', 'Persian', '<image src=\"../images/cat1.gif\">Friendly house cat, doubles as a princess');
INSERT INTO `product` VALUES ('FL-DSH-01', 'CATS', 'Manx', '<image src=\"../images/cat1.gif\">Great for reducing mouse populations');
INSERT INTO `product` VALUES ('K9-BD-01', 'DOGS', 'Bulldog', '<image src=\"../images/dog2.gif\">Friendly dog from England');
INSERT INTO `product` VALUES ('K9-CW-01', 'DOGS', 'Chihuahua', '<image src=\"../images/dog4.gif\">Great companion dog');
INSERT INTO `product` VALUES ('K9-DL-01', 'DOGS', 'Dalmation', '<image src=\"../images/dog5.gif\">Great dog for a Fire Station');
INSERT INTO `product` VALUES ('K9-PO-02', 'DOGS', 'Poodle', '<image src=\"../images/dog6.gif\">Cute dog from France');
INSERT INTO `product` VALUES ('K9-RT-01', 'DOGS', 'Golden Retriever', '<image src=\"../images/dog1.gif\">Great family dog');
INSERT INTO `product` VALUES ('RP-LI-02', 'REPTILES', 'Iguana', '<image src=\"../images/lizard1.gif\">Friendly green friend');
INSERT INTO `product` VALUES ('RP-SN-01', 'REPTILES', 'Rattlesnake', '<image src=\"../images/lizard1.gif\">Doubles as a watch dog');

-- ----------------------------
-- Table structure for profile
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile`  (
  `userid` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `langpref` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `favcategory` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mylistopt` tinyint(1) NULL DEFAULT NULL,
  `banneropt` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES ('123', 'English', 'CATS', NULL, NULL);
INSERT INTO `profile` VALUES ('1234', 'english', 'CATS', NULL, NULL);
INSERT INTO `profile` VALUES ('1843773386gyk', 'english', 'DOGS', 1, 1);
INSERT INTO `profile` VALUES ('j2ee', 'english', 'FISH', 1, 1);
INSERT INTO `profile` VALUES ('liuxin', 'english', 'CATS', NULL, NULL);

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence`  (
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nextid` int NOT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('linenum', 1024);
INSERT INTO `sequence` VALUES ('ordernum', 1013);

-- ----------------------------
-- Table structure for signon
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon`  (
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of signon
-- ----------------------------
INSERT INTO `signon` VALUES ('123', 'b19d49444887541a271d02607ec0ff70');
INSERT INTO `signon` VALUES ('1234', 'b19d49444887541a271d02607ec0ff70');
INSERT INTO `signon` VALUES ('1843773386gyk', 'b19d49444887541a271d02607ec0ff70');
INSERT INTO `signon` VALUES ('j2ee', 'j2ee');
INSERT INTO `signon` VALUES ('liuxin', 'b19d49444887541a271d02607ec0ff70');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `suppid` int NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addr1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zip` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`suppid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, 'XYZ Pets', 'AC', '600 Avon Way', '', 'Los Angeles', 'CA', '94024', '212-947-0797');
INSERT INTO `supplier` VALUES (2, 'ABC Pets', 'AC', '700 Abalone Way', '', 'San Francisco ', 'CA', '94024', '415-947-0797');

-- ----------------------------
-- Table structure for verification
-- ----------------------------
DROP TABLE IF EXISTS `verification`;
CREATE TABLE `verification`  (
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of verification
-- ----------------------------
INSERT INTO `verification` VALUES ('123', '107060');
INSERT INTO `verification` VALUES ('1843773386gyk', '062819');

SET FOREIGN_KEY_CHECKS = 1;
