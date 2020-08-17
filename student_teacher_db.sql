CREATE DATABASE  IF NOT EXISTS `testdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `testdb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.6.33

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `TEACHER `;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHER ` (
  `TID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TNAME` varchar(200) DEFAULT NULL,  
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `STUDENT `;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENT ` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `PHONE_NO` bigint(20) ,  
  PRIMARY KEY (`ID`),
  KEY `fk1_teacher_idx` (`C`),  
  CONSTRAINT `fk1_address` FOREIGN KEY (`TID`) REFERENCES `TEACHER` (`TID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
