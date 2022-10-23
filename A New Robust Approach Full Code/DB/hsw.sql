# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: hsw
# ------------------------------------------------------
# Server version 5.0.24a-community-nt

DROP DATABASE IF EXISTS `hsw`;
CREATE DATABASE `hsw` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hsw`;

#
# Source for table admingraphicalpassword
#

CREATE TABLE `admingraphicalpassword` (
  `userName` varchar(255) default NULL,
  `userEmail` varchar(255) default NULL,
  `userAddress` varchar(255) default NULL,
  `userBirth` varchar(255) default NULL,
  `userImage` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table admingraphicalpassword
#
LOCK TABLES `admingraphicalpassword` WRITE;
/*!40000 ALTER TABLE `admingraphicalpassword` DISABLE KEYS */;

INSERT INTO `admingraphicalpassword` VALUES ('mani','mani@gmail.com','chennai','null','');
/*!40000 ALTER TABLE `admingraphicalpassword` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table binarydb
#

CREATE TABLE `binarydb` (
  `SNO` varchar(255) NOT NULL default '',
  `YEAR` varchar(255) NOT NULL default '',
  `STAFF` varchar(255) NOT NULL default '',
  `VECHICLE` varchar(255) NOT NULL default '',
  `MATERIAL` varchar(255) NOT NULL default '',
  `DAMAGE` varchar(255) NOT NULL default '',
  `CUSTOMER` varchar(255) NOT NULL default '',
  `BRANCHES` varchar(255) NOT NULL default '',
  `RENTALEXPENSES` varchar(255) NOT NULL default '',
  `SALARYAMOUNT_PA` varchar(255) NOT NULL default '',
  `OTHER_EXPENSES_PA` varchar(255) NOT NULL default '',
  `ANNUALTURNOVER` varchar(255) NOT NULL default '',
  `PROFITLOSS` varchar(255) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table binarydb
#
LOCK TABLES `binarydb` WRITE;
/*!40000 ALTER TABLE `binarydb` DISABLE KEYS */;

/*!40000 ALTER TABLE `binarydb` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table binaryinfotechstatus
#

CREATE TABLE `binaryinfotechstatus` (
  `SNO` varchar(255) NOT NULL default '',
  `YEAR` varchar(255) NOT NULL default '',
  `STAFF` varchar(255) NOT NULL default '',
  `VECHICLE` varchar(255) NOT NULL default '',
  `MATERIAL` varchar(255) NOT NULL default '',
  `DAMAGE` varchar(255) NOT NULL default '',
  `CUSTOMER` varchar(255) NOT NULL default '',
  `BRANCHES` varchar(255) NOT NULL default '',
  `RENTALEXPENSES` varchar(255) NOT NULL default '',
  `SALARYAMOUNT_PA` varchar(255) NOT NULL default '',
  `OTHER_EXPENSES_PA` varchar(255) NOT NULL default '',
  `ANNUALTURNOVER` varchar(255) NOT NULL default '',
  `PROFITLOSS` varchar(255) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table binaryinfotechstatus
#
LOCK TABLES `binaryinfotechstatus` WRITE;
/*!40000 ALTER TABLE `binaryinfotechstatus` DISABLE KEYS */;

/*!40000 ALTER TABLE `binaryinfotechstatus` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table infotechdb
#

CREATE TABLE `infotechdb` (
  `SNO` varchar(255) NOT NULL default '',
  `YEAR` varchar(255) NOT NULL default '',
  `STAFF` varchar(255) NOT NULL default '',
  `VECHICLE` varchar(255) NOT NULL default '',
  `MATERIAL` varchar(255) NOT NULL default '',
  `DAMAGE` varchar(255) NOT NULL default '',
  `CUSTOMER` varchar(255) NOT NULL default '',
  `BRANCHES` varchar(255) NOT NULL default '',
  `RENTALEXPENSES` varchar(255) NOT NULL default '',
  `SALARYAMOUNT_PA` varchar(255) NOT NULL default '',
  `OTHER_EXPENSES_PA` varchar(255) NOT NULL default '',
  `ANNUALTURNOVER` varchar(255) NOT NULL default '',
  `PROFIT/LOSS` varchar(255) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table infotechdb
#
LOCK TABLES `infotechdb` WRITE;
/*!40000 ALTER TABLE `infotechdb` DISABLE KEYS */;

/*!40000 ALTER TABLE `infotechdb` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table infotechstatus
#

CREATE TABLE `infotechstatus` (
  `YEAR` varchar(250) NOT NULL default '',
  `STAFF` int(11) default NULL,
  `VECHICLE` int(11) default NULL,
  `MATERIAL` int(11) default NULL,
  `DAMAGE` int(11) default NULL,
  `CUSTOMER` int(11) default NULL,
  `BRANCHES` int(11) default NULL,
  `RENTALEXPENSES` varchar(255) default NULL,
  `SALARYAMOUNT_PA` varchar(255) default NULL,
  `OTHER_EXPENSES_PA` varchar(255) default NULL,
  `ANNUALTURNOVER` varchar(255) default NULL,
  `PROFIT/LOSS(CR)` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table infotechstatus
#
LOCK TABLES `infotechstatus` WRITE;
/*!40000 ALTER TABLE `infotechstatus` DISABLE KEYS */;

/*!40000 ALTER TABLE `infotechstatus` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table registration
#

CREATE TABLE `registration` (
  `userName` varchar(255) default NULL,
  `userEmail` varchar(255) default NULL,
  `userAddress` varchar(255) default NULL,
  `userBirth` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `userid` varchar(255) default NULL,
  `fingerprint` varchar(4000) default NULL,
  `fingertemplate` varchar(255) default NULL,
  `secretkey` varchar(4000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table registration
#
LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;

INSERT INTO `registration` VALUES ('mani','mani@gmail.com','chennai',NULL,'11','694982','Rk1SACAyMAAAAAD8AAABPAFiAMUAxQEAAAAoJUDAANDyZEDHAO/jZEDiALn2ZEDzAMvrZEDvAPzXZEESAOFoUEDWAS+yXUCcAGD9ZICtAT41XUD0ASfCZEBHARUvZEA+AR03ZEBMAFIeV4CdAOH1ZICBANkIZECeAQvaV4BeAOCsZEC8AHT6ZEDlAHh5ZEEBAJJ1V0EWAN7nUEB9ATfWSUA2ALWkZEC3AUwhDUBSAGYQXYCTAK8DZEDAAJ+BXYCZARLEV0C2AIGKV0C0AGd/ZICdATdDQ0BYAIMLXUDkAG7zZED9AR3LZEETAQXWZEBSAGkSXYAtAIcYZAAA','nwjlPEqcKH+ArXSV2h33nMLitDywvK9CPWgKi+ShGME=','21*1620*59*31*90*27*12*4*1.0*1.5*1.5*7.5*3.5####35*1634*95*33*128*28*13*4*2.0*2.0*1.0*3.5*-1.5####38*1637*60*26*86*27*14*5*2.0*1.0*0.5*4.0*0.5####45*1644*58*28*86*16*13*4*1.5*1.5*1.5*9.0*4.5####60*1659*90*22*112*24*9*3*1.5*1.0*1.5*3.5*-0.5####65*1664*51*14*65*27*10*4*2.5*1.5*1.5*5.5*0.0####68*1667*79*13*92*16*9*4*2.5*1.0*1.5*8.5*3.5####69*1668*97*33*130*13*9*5*1.0*2.5*0.5*8.0*4.0####85*1684*68*18*86*27*14*6*2.0*1.0*1.5*9.5*5.0####86*1685*74*32*106*17*11*6*1.5*2.5*1.0*3.5*-1.5####105*1704*92*31*123*17*14*6*2.0*2.5*1.0*5.5*0.0####107*1706*75*15*90*14*10*5*1.5*1.5*1.5*5.5*1.0####112*1711*64*34*98*16*10*5*1.0*1.0*0.5*4.0*1.5####145*1744*98*16*114*25*11*5*1.5*2.5*1.5*4.0*-1.5####153*1752*89*26*115*20*12*5*1.5*2.0*0.5*5.5*1.5####159*1758*80*28*108*27*10*6*1.5*2.5*0.5*8.0*3.5####166*1765*75*39*114*16*9*6*1.0*2.5*1.5*4.5*-0.5####169*1768*86*36*122*28*10*5*1.0*1.5*1.0*3.0*-0.5####171*1770*59*34*93*14*10*3*1.5');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
