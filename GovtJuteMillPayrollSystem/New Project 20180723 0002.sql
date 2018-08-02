-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema govt_jute_mill_payroll
--

CREATE DATABASE IF NOT EXISTS govt_jute_mill_payroll;
USE govt_jute_mill_payroll;

--
-- Definition of table `basic_grade`
--

DROP TABLE IF EXISTS `basic_grade`;
CREATE TABLE `basic_grade` (
  `grade_id` int(10) unsigned NOT NULL auto_increment,
  `grade_cd` int(10) unsigned NOT NULL,
  `scale_start` double NOT NULL,
  `scale_end` double NOT NULL,
  `total_step` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`grade_id`),
  UNIQUE KEY `grade_cd` (`grade_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basic_grade`
--

/*!40000 ALTER TABLE `basic_grade` DISABLE KEYS */;
INSERT INTO `basic_grade` (`grade_id`,`grade_cd`,`scale_start`,`scale_end`,`total_step`) VALUES 
 (1,1,70000,70000,0),
 (2,2,60000,69000,2);
/*!40000 ALTER TABLE `basic_grade` ENABLE KEYS */;


--
-- Definition of table `basic_increment`
--

DROP TABLE IF EXISTS `basic_increment`;
CREATE TABLE `basic_increment` (
  `increment_id` int(10) unsigned NOT NULL auto_increment,
  `increment_cd` int(10) unsigned NOT NULL,
  `increment_name` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`increment_id`),
  UNIQUE KEY `increment_cd` (`increment_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basic_increment`
--

/*!40000 ALTER TABLE `basic_increment` DISABLE KEYS */;
INSERT INTO `basic_increment` (`increment_id`,`increment_cd`,`increment_name`) VALUES 
 (1,1,1),
 (2,2,2),
 (3,3,3),
 (4,4,4);
/*!40000 ALTER TABLE `basic_increment` ENABLE KEYS */;


--
-- Definition of table `basic_master`
--

DROP TABLE IF EXISTS `basic_master`;
CREATE TABLE `basic_master` (
  `basic_id` int(10) unsigned NOT NULL auto_increment,
  `basic_cd` int(10) unsigned NOT NULL,
  `grade_id` int(10) unsigned NOT NULL,
  `increment_id` int(10) unsigned NOT NULL,
  `basic_main` double NOT NULL,
  PRIMARY KEY  (`basic_id`),
  KEY `FK_basic_master_1` (`grade_id`),
  KEY `FK_basic_master_2` (`increment_id`),
  CONSTRAINT `FK_basic_master_1` FOREIGN KEY (`grade_id`) REFERENCES `basic_grade` (`grade_id`),
  CONSTRAINT `FK_basic_master_2` FOREIGN KEY (`increment_id`) REFERENCES `basic_increment` (`increment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basic_master`
--

/*!40000 ALTER TABLE `basic_master` DISABLE KEYS */;
INSERT INTO `basic_master` (`basic_id`,`basic_cd`,`grade_id`,`increment_id`,`basic_main`) VALUES 
 (1,1,1,1,70000),
 (2,2,1,1,60000),
 (3,3,1,1,50000);
/*!40000 ALTER TABLE `basic_master` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(10) unsigned NOT NULL auto_increment,
  `department_cd` int(10) unsigned NOT NULL,
  `department_name` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`department_id`),
  UNIQUE KEY `department_cd` (`department_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`department_id`,`department_cd`,`department_name`) VALUES 
 (1,1,'Administration'),
 (2,2,'Accounce'),
 (3,3,'Jute');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `designation`
--

DROP TABLE IF EXISTS `designation`;
CREATE TABLE `designation` (
  `designation_id` int(10) unsigned NOT NULL auto_increment,
  `designation_cd` int(10) unsigned NOT NULL,
  `designation_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`designation_id`),
  UNIQUE KEY `designation_cd` (`designation_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `designation`
--

/*!40000 ALTER TABLE `designation` DISABLE KEYS */;
INSERT INTO `designation` (`designation_id`,`designation_cd`,`designation_name`) VALUES 
 (1,1,'General Manager'),
 (2,2,'Deputy General Manager'),
 (3,3,'Manager');
/*!40000 ALTER TABLE `designation` ENABLE KEYS */;


--
-- Definition of table `house`
--

DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `house_id` int(10) unsigned NOT NULL auto_increment,
  `house_cd` int(10) unsigned NOT NULL,
  `house_name` varchar(45) NOT NULL,
  `house_rent` double NOT NULL,
  PRIMARY KEY  (`house_id`),
  UNIQUE KEY `house_cd` (`house_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house`
--

/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` (`house_id`,`house_cd`,`house_name`,`house_rent`) VALUES 
 (1,1,'Bachelor',2000),
 (2,2,'Half Family Quarter',2500),
 (3,3,'Family Quarter',4000);
/*!40000 ALTER TABLE `house` ENABLE KEYS */;


--
-- Definition of table `job_status`
--

DROP TABLE IF EXISTS `job_status`;
CREATE TABLE `job_status` (
  `job_status_id` int(10) unsigned NOT NULL auto_increment,
  `job_status_cd` int(10) unsigned NOT NULL,
  `job_status_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`job_status_id`),
  UNIQUE KEY `job_status_cd` (`job_status_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_status`
--

/*!40000 ALTER TABLE `job_status` DISABLE KEYS */;
INSERT INTO `job_status` (`job_status_id`,`job_status_cd`,`job_status_name`) VALUES 
 (1,1,'Officer'),
 (2,2,'Stuff'),
 (3,3,'4th Class Employee');
/*!40000 ALTER TABLE `job_status` ENABLE KEYS */;


--
-- Definition of table `job_type`
--

DROP TABLE IF EXISTS `job_type`;
CREATE TABLE `job_type` (
  `job_type_id` int(10) unsigned NOT NULL auto_increment,
  `job_type_cd` int(10) unsigned NOT NULL,
  `job_type_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`job_type_id`),
  UNIQUE KEY `job_type_cd` (`job_type_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_type`
--

/*!40000 ALTER TABLE `job_type` DISABLE KEYS */;
INSERT INTO `job_type` (`job_type_id`,`job_type_cd`,`job_type_name`) VALUES 
 (1,1,'Permanant'),
 (2,2,'Daily Basic'),
 (3,3,'Temporary');
/*!40000 ALTER TABLE `job_type` ENABLE KEYS */;


--
-- Definition of table `master_allowance`
--

DROP TABLE IF EXISTS `master_allowance`;
CREATE TABLE `master_allowance` (
  `master_allowance_id` int(10) unsigned NOT NULL auto_increment,
  `employee_id` int(10) unsigned NOT NULL,
  `house_rent_allow` double NOT NULL,
  `medical_allow` double NOT NULL,
  `mohargo_allow` double NOT NULL,
  `child_education` double NOT NULL,
  `convence_allow` double NOT NULL,
  `tiffin_allow` double NOT NULL,
  `telephone_allow` double NOT NULL,
  `others` double NOT NULL,
  PRIMARY KEY  (`master_allowance_id`),
  KEY `FK_master_allowance_1` (`employee_id`),
  CONSTRAINT `FK_master_allowance_1` FOREIGN KEY (`employee_id`) REFERENCES `master_data` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_allowance`
--

/*!40000 ALTER TABLE `master_allowance` DISABLE KEYS */;
/*!40000 ALTER TABLE `master_allowance` ENABLE KEYS */;


--
-- Definition of table `master_data`
--

DROP TABLE IF EXISTS `master_data`;
CREATE TABLE `master_data` (
  `employee_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `date_birth` date NOT NULL,
  `designation_id` int(10) unsigned NOT NULL,
  `basic_id` int(10) unsigned NOT NULL,
  `mill_id` int(10) unsigned NOT NULL,
  `department_id` int(10) unsigned NOT NULL,
  `job_type_id` int(10) unsigned NOT NULL,
  `job_status_id` int(10) unsigned NOT NULL,
  `father_name` varchar(45) NOT NULL,
  `mother_name` varchar(45) NOT NULL,
  `home_district` varchar(45) NOT NULL,
  `permanent_address` varchar(145) NOT NULL,
  `date_join_job` date NOT NULL,
  `date_join_mill` date NOT NULL,
  `date_retired` date NOT NULL,
  `pf_ac_no` varchar(45) NOT NULL,
  `bank_ac` varchar(45) NOT NULL,
  `bank_name` varchar(45) NOT NULL,
  `bank_branch` varchar(45) NOT NULL,
  `salary_status_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`employee_id`),
  KEY `FK_master_data_1` (`basic_id`),
  KEY `FK_master_data_2` (`department_id`),
  KEY `FK_master_data_3` (`designation_id`),
  KEY `FK_master_data_4` (`job_status_id`),
  KEY `FK_master_data_5` (`job_type_id`),
  KEY `FK_master_data_6` (`salary_status_id`),
  KEY `FK_master_data_7` (`mill_id`),
  CONSTRAINT `FK_master_data_1` FOREIGN KEY (`basic_id`) REFERENCES `basic_master` (`basic_id`),
  CONSTRAINT `FK_master_data_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `FK_master_data_3` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`designation_id`),
  CONSTRAINT `FK_master_data_4` FOREIGN KEY (`job_status_id`) REFERENCES `job_status` (`job_status_id`),
  CONSTRAINT `FK_master_data_5` FOREIGN KEY (`job_type_id`) REFERENCES `job_type` (`job_type_id`),
  CONSTRAINT `FK_master_data_6` FOREIGN KEY (`salary_status_id`) REFERENCES `salary_status` (`salary_status_id`),
  CONSTRAINT `FK_master_data_7` FOREIGN KEY (`mill_id`) REFERENCES `mill` (`mill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_data`
--

/*!40000 ALTER TABLE `master_data` DISABLE KEYS */;
INSERT INTO `master_data` (`employee_id`,`name`,`date_birth`,`designation_id`,`basic_id`,`mill_id`,`department_id`,`job_type_id`,`job_status_id`,`father_name`,`mother_name`,`home_district`,`permanent_address`,`date_join_job`,`date_join_mill`,`date_retired`,`pf_ac_no`,`bank_ac`,`bank_name`,`bank_branch`,`salary_status_id`) VALUES 
 (1,'Rabi','2018-07-04',3,2,2,3,2,2,'Ratan','Moli','Khulna','Khulna','2010-10-10','2010-10-10','2050-01-01','11111','22222','Trust','Khulna',1),
 (2,'Kabir','1990-01-01',2,2,2,2,2,2,'Kalim','Kabita','Dhaka','Dhaka','2010-10-10','2010-10-10','2050-01-01','11112','22223','Trust','Dhaka',2),
 (3,'name','1988-01-01',3,2,1,1,1,1,'name1','name2','Khulna','Khulna','2000-01-01','2001-01-03','2003-01-01','147258','1452','Trust','Daulatpur',1);
/*!40000 ALTER TABLE `master_data` ENABLE KEYS */;


--
-- Definition of table `master_deduction`
--

DROP TABLE IF EXISTS `master_deduction`;
CREATE TABLE `master_deduction` (
  `master_deduction_id` int(10) unsigned NOT NULL auto_increment,
  `employee_id` int(10) unsigned NOT NULL,
  `telephone_bill` double NOT NULL,
  `pf_contribution` double NOT NULL,
  `pf_loan` double NOT NULL,
  `advance_salary` double NOT NULL,
  `revenue_stamp` double NOT NULL,
  `income_tax` double NOT NULL,
  `electric_bill` double NOT NULL,
  `house_id` int(10) unsigned NOT NULL,
  `others` double NOT NULL,
  PRIMARY KEY  (`master_deduction_id`),
  KEY `FK_master_deduction_1` (`employee_id`),
  KEY `FK_master_deduction_2` (`house_id`),
  CONSTRAINT `FK_master_deduction_1` FOREIGN KEY (`employee_id`) REFERENCES `master_data` (`employee_id`),
  CONSTRAINT `FK_master_deduction_2` FOREIGN KEY (`house_id`) REFERENCES `house` (`house_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_deduction`
--

/*!40000 ALTER TABLE `master_deduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `master_deduction` ENABLE KEYS */;


--
-- Definition of table `mill`
--

DROP TABLE IF EXISTS `mill`;
CREATE TABLE `mill` (
  `mill_id` int(10) unsigned NOT NULL auto_increment,
  `mill_cd` int(10) unsigned NOT NULL,
  `mill_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`mill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mill`
--

/*!40000 ALTER TABLE `mill` DISABLE KEYS */;
INSERT INTO `mill` (`mill_id`,`mill_cd`,`mill_name`) VALUES 
 (1,1,'Mill No. 1'),
 (2,2,'Mill No. 2');
/*!40000 ALTER TABLE `mill` ENABLE KEYS */;


--
-- Definition of table `salary_status`
--

DROP TABLE IF EXISTS `salary_status`;
CREATE TABLE `salary_status` (
  `salary_status_id` int(10) unsigned NOT NULL auto_increment,
  `salary_status_cd` int(10) unsigned NOT NULL,
  `salary_status_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`salary_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary_status`
--

/*!40000 ALTER TABLE `salary_status` DISABLE KEYS */;
INSERT INTO `salary_status` (`salary_status_id`,`salary_status_cd`,`salary_status_name`) VALUES 
 (1,1,'Active'),
 (2,2,'Temporary Suspend'),
 (3,3,'Suspend');
/*!40000 ALTER TABLE `salary_status` ENABLE KEYS */;


--
-- Definition of table `salary_tran`
--

DROP TABLE IF EXISTS `salary_tran`;
CREATE TABLE `salary_tran` (
  `salary_tran_id` int(10) unsigned NOT NULL auto_increment,
  `salary_tran_month` date NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `designation_name` varchar(45) NOT NULL,
  `basic_main` double NOT NULL,
  `mill_name` varchar(45) NOT NULL,
  `department_name` varchar(45) NOT NULL,
  `job_status_name` varchar(45) NOT NULL,
  `salary_status_name` varchar(45) NOT NULL,
  `job_type_name` varchar(45) NOT NULL,
  `working_day` int(10) unsigned NOT NULL,
  `leave_day` int(10) unsigned NOT NULL,
  `ot_hour` float NOT NULL,
  `encash_day` int(10) unsigned NOT NULL,
  `house_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`salary_tran_id`),
  KEY `FK_salary_tran_1` (`employee_id`),
  CONSTRAINT `FK_salary_tran_1` FOREIGN KEY (`employee_id`) REFERENCES `master_data` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary_tran`
--

/*!40000 ALTER TABLE `salary_tran` DISABLE KEYS */;
INSERT INTO `salary_tran` (`salary_tran_id`,`salary_tran_month`,`employee_id`,`name`,`designation_name`,`basic_main`,`mill_name`,`department_name`,`job_status_name`,`salary_status_name`,`job_type_name`,`working_day`,`leave_day`,`ot_hour`,`encash_day`,`house_name`) VALUES 
 (1,'2000-01-01',1,'Rabi','Manager',60000,'Mill No. 2','Jute','Stuff','Temporary Suspend','Daily Basic',30,30,30,30,'Bachelor');
/*!40000 ALTER TABLE `salary_tran` ENABLE KEYS */;


--
-- Definition of table `salary_tran_allowance`
--

DROP TABLE IF EXISTS `salary_tran_allowance`;
CREATE TABLE `salary_tran_allowance` (
  `salary_tran_allow_id` int(10) unsigned NOT NULL auto_increment,
  `salary_tran_id` int(10) unsigned NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  `total_basic` double NOT NULL,
  `house_rent_allow` double NOT NULL,
  `medical_allow` double NOT NULL,
  `mohargo_allow` double NOT NULL,
  `child_eduction` double NOT NULL,
  `convence_allow` double NOT NULL,
  `tiffin_allow` double NOT NULL,
  `telephone_allow` double NOT NULL,
  `ot_allow` double NOT NULL,
  `encash_pay` double NOT NULL,
  `others` double NOT NULL,
  PRIMARY KEY  USING BTREE (`salary_tran_allow_id`),
  KEY `FK_salary_tran_allowance_1` (`salary_tran_id`),
  KEY `FK_salary_tran_allowance_2` (`employee_id`),
  CONSTRAINT `FK_salary_tran_allowance_1` FOREIGN KEY (`salary_tran_id`) REFERENCES `salary_tran` (`salary_tran_id`),
  CONSTRAINT `FK_salary_tran_allowance_2` FOREIGN KEY (`employee_id`) REFERENCES `master_data` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary_tran_allowance`
--

/*!40000 ALTER TABLE `salary_tran_allowance` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary_tran_allowance` ENABLE KEYS */;


--
-- Definition of table `salary_tran_deduction`
--

DROP TABLE IF EXISTS `salary_tran_deduction`;
CREATE TABLE `salary_tran_deduction` (
  `salary_tran_ded_id` int(10) unsigned NOT NULL auto_increment,
  `salary_tran_id` int(10) unsigned NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  `house_rent` double NOT NULL,
  `telephone_bill` double NOT NULL,
  `water_bill` double NOT NULL,
  `electric_bill` double NOT NULL,
  `gas_bill` double NOT NULL,
  `pf_contribution` double NOT NULL,
  `pf_loan` double NOT NULL,
  `advance_salary` double NOT NULL,
  `revenue_stamp` double NOT NULL,
  `income_tax` double NOT NULL,
  `transport_ded` double NOT NULL,
  `others` double NOT NULL,
  PRIMARY KEY  (`salary_tran_ded_id`),
  KEY `FK_salary_tran_deduction_1` (`salary_tran_id`),
  KEY `FK_salary_tran_deduction_2` (`employee_id`),
  CONSTRAINT `FK_salary_tran_deduction_1` FOREIGN KEY (`salary_tran_id`) REFERENCES `salary_tran` (`salary_tran_id`),
  CONSTRAINT `FK_salary_tran_deduction_2` FOREIGN KEY (`employee_id`) REFERENCES `master_data` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary_tran_deduction`
--

/*!40000 ALTER TABLE `salary_tran_deduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary_tran_deduction` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `employee_id` int(10) unsigned NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_pass` varchar(45) NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `FK_user_1` (`employee_id`),
  CONSTRAINT `FK_user_1` FOREIGN KEY (`employee_id`) REFERENCES `master_data` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
