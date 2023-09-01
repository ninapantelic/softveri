/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.18 : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `seminarski`;

/*Table structure for table `apartman` */

DROP TABLE IF EXISTS `apartman`;

CREATE TABLE `apartman` (
  `apartmanID` int(50) NOT NULL AUTO_INCREMENT,
  `nazivApartmana` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cena` int(50) DEFAULT NULL,
  `raspolozivost` tinyint(4) DEFAULT '0',
  `brojSoba` int(11) DEFAULT NULL,
  `balkon` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`apartmanID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `apartman` */

insert  into `apartman`(`apartmanID`,`nazivApartmana`,`cena`,`raspolozivost`,`brojSoba`,`balkon`) values 
(1,'A100',110,1,1,1),
(2,'B100',200,1,3,0),
(3,'B101',210,1,4,1),
(4,'B102',400,1,6,1);

/*Table structure for table `gost` */

DROP TABLE IF EXISTS `gost`;

CREATE TABLE `gost` (
  `gostID` int(100) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `korisnickoIme` varchar(20) DEFAULT NULL,
  `lozinka` varchar(20) DEFAULT NULL,
  `brojTelefona` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`gostID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `gost` */

insert  into `gost`(`gostID`,`ime`,`prezime`,`korisnickoIme`,`lozinka`,`brojTelefona`) values 
(1,'Katarina','Jovanovic','katarina','katarina1','063222333'),
(2,'Nikola','Nikolic','nikola','nikola','061123456'),
(3,'Petar','Petrovic','petar','petar1','061234213'),
(4,'Filip','Macura','filip','filip1','066208200'),
(5,'Ana','Anic','ana1402','ana123','062332352'),
(6,'Milos','Milosevic','milos','milos1','06123455');

/*Table structure for table `menadzer` */

DROP TABLE IF EXISTS `menadzer`;

CREATE TABLE `menadzer` (
  `menadzerID` int(11) NOT NULL AUTO_INCREMENT,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `mejl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menadzerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `menadzer` */

insert  into `menadzer`(`menadzerID`,`korisnickoIme`,`lozinka`,`ime`,`prezime`,`mejl`) values 
(1,'nina','nina123','Nina','Pantelic','nina@gmail.com'),
(2,'mina','mina123','Mina','Velebit','mina@gmail.com');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `rezervacijaID` int(11) NOT NULL AUTO_INCREMENT,
  `datumOd` date DEFAULT NULL,
  `datumDo` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `ukupnaCena` int(11) DEFAULT NULL,
  `menadzerID` int(11) DEFAULT NULL,
  `apartmanID` int(11) DEFAULT NULL,
  `gostID` int(11) DEFAULT NULL,
  PRIMARY KEY (`rezervacijaID`),
  KEY `menadzerID` (`menadzerID`),
  KEY `apartmanID` (`apartmanID`),
  KEY `gostID` (`gostID`),
  CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`menadzerID`) REFERENCES `menadzer` (`menadzerID`),
  CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`apartmanID`) REFERENCES `apartman` (`apartmanID`),
  CONSTRAINT `rezervacija_ibfk_3` FOREIGN KEY (`gostID`) REFERENCES `gost` (`gostID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`rezervacijaID`,`datumOd`,`datumDo`,`status`,`ukupnaCena`,`menadzerID`,`apartmanID`,`gostID`) values 
(1,'2022-03-22','2022-03-24','NEOBRADJENA',220,1,1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
