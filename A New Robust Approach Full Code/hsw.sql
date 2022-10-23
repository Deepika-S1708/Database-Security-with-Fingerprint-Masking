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

#
# Source for table admingraphicalpassword
#

DROP TABLE IF EXISTS `admingraphicalpassword`;
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

/*!40000 ALTER TABLE `admingraphicalpassword` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table binarydb
#

DROP TABLE IF EXISTS `binarydb`;
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

DROP TABLE IF EXISTS `binaryinfotechstatus`;
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

DROP TABLE IF EXISTS `infotechdb`;
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

DROP TABLE IF EXISTS `infotechstatus`;
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

DROP TABLE IF EXISTS `registration`;
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

/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
