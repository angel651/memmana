/*
SQLyog Ultimate v9.60 
MySQL - 5.1.73-community : Database - memmana
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`memmana` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `memmana`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL,
  `password` char(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`username`,`password`) values ('admin','21232f297a57a5a743894a0e4a801fc3');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contentTitle` varchar(40) NOT NULL,
  `contentPage` varchar(80) NOT NULL,
  `publishDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`id`,`contentTitle`,`contentPage`,`publishDate`) values (1,'1：Web开发基础及Java EE开发环境搭建','http://www.wustwzx.com/javaee/sy/wkd2018/sy1.html','2015-10-24'),(2,'2：使用JSP技术开发Web项目','http://www.wustwzx.com/javaee/sy/wkd2018/sy2.html','2015-10-15'),(3,'3：Servlet组件、使用MVC模式开发Web项目','http://www.wustwzx.com/javaee/sy/wkd2018/sy3.html','2015-10-15'),(4,'4：MyBatis框架','http://www.wustwzx.com/javaee/sy/wkd2018/sy4.html','2015-10-15'),(5,'5：Spring MVC框架','http://www.wustwzx.com/javaee/sy/wkd2018/sy5.html','2015-10-15'),(6,'6：Spring框架','http://www.wustwzx.com/javaee/sy/wkd2018/sy6.html','2015-10-15'),(7,'7：使用SSM整合开发Web项目','http://www.wustwzx.com/javaee/sy/wkd2018/sy7.html','2015-12-01'),(8,'8：Spring Boot框架','http://www.wustwzx.com/javaee/sy/wkd2018/sy8.html','2015-12-01');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` char(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `realname` char(10) DEFAULT NULL,
  `mobile` char(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`realname`,`mobile`,`age`) values ('chenjiu','777','陈久','13700000009',99),('lisi','222','李四','13700000004',44),('qianqi','555','钱七','13700000007',77),('sunba','666','孙八','13700000008',88),('wangwu','333','王五','13700000005',55),('zhangsan','111','张三','13700000003',33),('zhaoliu','444','赵六','13700000006',66);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
