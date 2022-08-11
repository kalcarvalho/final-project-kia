/*
SQLyog Community Edition- MySQL GUI v7.11 
MySQL - 4.1.18 : Database - distribuidora
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`distribuidora` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `distribuidora`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `cnpj` varchar(15) NOT NULL default '',
  `razaoSocial` varchar(60) NOT NULL default '',
  `inscEstadual` varchar(20) default NULL,
  `fantasia` varchar(60) default NULL,
  PRIMARY KEY  (`cnpj`),
  UNIQUE KEY `razaoSocial` (`razaoSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`cnpj`,`razaoSocial`,`inscEstadual`,`fantasia`) values ('1928374656','Souza Ltda','1234569876','Souzinha'),('19424002','Mendes Aguiar Ltda','1212121','Pulga'),('987064651','Minas Bras','7575757575','Mineirinho');

/*Table structure for table `compra` */

DROP TABLE IF EXISTS `compra`;

CREATE TABLE `compra` (
  `data` date NOT NULL default '0000-00-00',
  `hora` time default NULL,
  `idCompra` int(10) unsigned NOT NULL auto_increment,
  `notaFiscal` varchar(15) NOT NULL default '',
  `idFornecedor` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`idCompra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `compra` */

insert  into `compra`(`data`,`hora`,`idCompra`,`notaFiscal`,`idFornecedor`) values ('2004-06-09',NULL,1,'',''),('2004-05-15','11:23:00',2,'',''),('2004-05-15','00:00:11',3,'',''),('2015-05-20','17:00:00',4,'',''),('2015-05-20',NULL,5,'',''),('2015-05-20',NULL,6,'',''),('2015-05-20',NULL,7,'',''),('2015-05-20',NULL,8,'',''),('2015-05-20',NULL,9,'',''),('2015-05-20',NULL,10,'',''),('2016-05-20',NULL,11,'',''),('2016-05-20',NULL,12,'',''),('2016-05-20',NULL,13,'',''),('2019-05-20',NULL,14,'',''),('2005-06-06',NULL,15,'',''),('2004-05-23',NULL,16,'3434',''),('2004-05-23',NULL,17,'432432',''),('2004-05-23',NULL,18,'1111111',''),('2004-05-23',NULL,19,'99999999',''),('2004-05-23',NULL,20,'88888888888',''),('2004-05-23',NULL,21,'88888888888',''),('2004-05-23',NULL,22,'88888888888',''),('2004-05-23',NULL,23,'777777777',''),('2004-05-23',NULL,24,'55555555555',''),('2004-05-23',NULL,25,'32323555',''),('2004-05-23',NULL,26,'222233333',''),('2004-05-23',NULL,27,'3333333333',''),('2004-05-24',NULL,28,'343434','1973'),('2004-05-24',NULL,29,'323232',''),('2004-05-24',NULL,30,'34343432',''),('2004-05-24',NULL,31,'8888888',''),('2004-05-24',NULL,32,'2121212',''),('2004-05-24',NULL,36,'232323',''),('2004-05-24',NULL,35,'323232',''),('2004-05-24',NULL,37,'2222',''),('2004-05-24',NULL,38,'323232',''),('2004-05-25',NULL,39,'2121212',''),('2004-05-25',NULL,40,'32323',''),('2004-05-25',NULL,41,'21212',''),('2004-05-25',NULL,42,'212',''),('2004-05-25',NULL,43,'32321',''),('2004-05-25',NULL,44,'21212',''),('2004-05-25',NULL,45,'212121',''),('2004-05-25',NULL,46,'121212',''),('2004-05-25',NULL,47,'12212',''),('2004-05-25',NULL,48,'3232223',''),('2004-12-11','05:48:40',62,'3434','111111777777'),('2004-12-11','06:00:49',63,'434','776655'),('2004-11-18','06:12:48',64,'89898','111111777777');

/*Table structure for table `contacompra` */

DROP TABLE IF EXISTS `contacompra`;

CREATE TABLE `contacompra` (
  `idConta` int(10) unsigned NOT NULL default '0',
  `idCompra` int(10) unsigned NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contacompra` */

insert  into `contacompra`(`idConta`,`idCompra`) values (1,26),(2,27),(3,28),(4,29),(5,30),(6,31),(7,32),(8,35),(9,48),(10,0),(11,0),(12,0),(13,52),(14,55),(15,60),(16,61),(17,66),(28,62),(28,63),(29,64);

/*Table structure for table `contadevolucao` */

DROP TABLE IF EXISTS `contadevolucao`;

CREATE TABLE `contadevolucao` (
  `idDevolucao` int(4) unsigned NOT NULL auto_increment,
  `idConta` int(4) NOT NULL default '0',
  `idVenda` int(4) NOT NULL default '0',
  PRIMARY KEY  (`idDevolucao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contadevolucao` */

insert  into `contadevolucao`(`idDevolucao`,`idConta`,`idVenda`) values (4,26,185),(5,27,186),(6,28,186);

/*Table structure for table `contasapagar` */

DROP TABLE IF EXISTS `contasapagar`;

CREATE TABLE `contasapagar` (
  `idConta` int(10) unsigned NOT NULL auto_increment,
  `vencimento` date NOT NULL default '0000-00-00',
  `valor` double unsigned NOT NULL default '0',
  `status` tinyint(1) default NULL,
  `idDevolucao` int(4) NOT NULL default '0',
  PRIMARY KEY  (`idConta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contasapagar` */

insert  into `contasapagar`(`idConta`,`vencimento`,`valor`,`status`,`idDevolucao`) values (19,'2004-12-25',2000,0,0),(20,'2004-12-25',900,0,0),(21,'2004-11-17',1400,0,0),(22,'2005-10-25',3100,0,0),(28,'2004-10-26',12,1,6),(27,'2004-10-26',12,1,5),(26,'2004-10-26',8,1,4),(29,'2004-12-23',168,0,0);

/*Table structure for table `contasareceber` */

DROP TABLE IF EXISTS `contasareceber`;

CREATE TABLE `contasareceber` (
  `idConta` int(10) NOT NULL auto_increment,
  `vencimento` date NOT NULL default '0000-00-00',
  `valor` double unsigned NOT NULL default '0',
  `Aberto` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`idConta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contasareceber` */

insert  into `contasareceber`(`idConta`,`vencimento`,`valor`,`Aberto`) values (16,'2004-09-21',32,0),(17,'2004-09-21',79,0),(18,'2005-02-25',48,0),(19,'2004-12-30',20,0),(20,'2004-12-11',16,0),(21,'2004-12-21',82,0);

/*Table structure for table `contavenda` */

DROP TABLE IF EXISTS `contavenda`;

CREATE TABLE `contavenda` (
  `idConta` int(10) unsigned NOT NULL default '0',
  `idVenda` int(10) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contavenda` */

insert  into `contavenda`(`idConta`,`idVenda`) values (16,185),(17,186),(18,188),(19,189),(20,190),(20,193),(20,194),(20,195),(21,196);

/*Table structure for table `ct` */

DROP TABLE IF EXISTS `ct`;

CREATE TABLE `ct` (
  `idFornecedor` varchar(15) default NULL,
  `idProduto` int(10) unsigned default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ct` */

insert  into `ct`(`idFornecedor`,`idProduto`) values ('5007',1),('99007',3),('99007',2),('99007',4),('5007',5),('8888888888',6),('98054588',7),('776655',8),('8888888888',9),('111111777777',10),('111111777777',11);

/*Table structure for table `distribuidora` */

DROP TABLE IF EXISTS `distribuidora`;

CREATE TABLE `distribuidora` (
  `inscEstadual` varchar(15) default NULL,
  `fantasia` varchar(60) default NULL,
  `razaoSocial` varchar(60) NOT NULL default '',
  `cnpj` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`cnpj`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `distribuidora` */

/*Table structure for table `endcliente` */

DROP TABLE IF EXISTS `endcliente`;

CREATE TABLE `endcliente` (
  `idEndereco` int(10) unsigned NOT NULL default '0',
  `idCliente` varchar(15) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `endcliente` */

insert  into `endcliente`(`idEndereco`,`idCliente`) values (26,'1928374656'),(27,'19424002'),(28,'19424002'),(39,'99999'),(43,'16122004'),(45,'56781234522'),(46,'1928374656'),(47,'1928374656'),(48,'999999999999999'),(49,'999999999999999'),(50,'0707070707'),(51,'6690987899'),(52,'464646464'),(53,'464646464'),(53,'987064651');

/*Table structure for table `enddistribuidora` */

DROP TABLE IF EXISTS `enddistribuidora`;

CREATE TABLE `enddistribuidora` (
  `idEndereco` int(10) unsigned NOT NULL default '0',
  `idDistribuidora` varchar(15) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `enddistribuidora` */

/*Table structure for table `endereco` */

DROP TABLE IF EXISTS `endereco`;

CREATE TABLE `endereco` (
  `idEndereco` int(10) unsigned NOT NULL auto_increment,
  `rua` varchar(60) NOT NULL default '',
  `bairro` varchar(60) default NULL,
  `cidade` varchar(60) NOT NULL default '',
  `estado` varchar(30) NOT NULL default '',
  `cep` varchar(10) default NULL,
  `numero` varchar(10) NOT NULL default '',
  `Email` varchar(60) default NULL,
  `praca` varchar(30) default NULL,
  `idRota` int(10) unsigned default NULL,
  PRIMARY KEY  (`idEndereco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `endereco` */

insert  into `endereco`(`idEndereco`,`rua`,`bairro`,`cidade`,`estado`,`cep`,`numero`,`Email`,`praca`,`idRota`) values (19,'acre','olaria','Teres¢polis','rj','7777','77','gggggg',NULL,NULL),(20,'rua Salvador','Olaria','Nova Friburgo','RJ','88888543','564','cole@ig.com.br',NULL,NULL),(21,'rua São Paulo','Conego','Nova Friburgo','RJ','28600','43','beeage@uol','Nova Friburgo',NULL),(22,'rua Lisboa','centro','Nova Friburgo','RJ','888855','99','sasasa@er',NULL,NULL),(23,'rua Tomb','centro','Fonseca','ES','23776','1500','tombraider@hotmail.com',NULL,NULL),(24,'rua zoom','Uta','YangShu','RJ','286090','87','lara@tom.com',NULL,NULL),(25,'rua Nair','centro','Nova Friburgo','RJ','28600','88','fiasde@ig',NULL,NULL),(26,'rua Piauí','Olaria','Nova Friburgo','RJ','28635028','1234','blumen@ig.com.br','Nova Friburgo',NULL),(27,'rua Paqueta','centro','Niterói','RJ','4321230','22','pulguinha@yahoo.com',NULL,NULL),(28,'rua Pedro Gouvea','centro','Pinda','SP','2192939','12','dede@bol',NULL,NULL),(29,'sdfds','sfsdd','Bom Jardim','RJ','fsd','dsd','dsfdfdsfsdds','Interior',NULL),(30,'ffg','fgfd','Bom Jardim','SP','sd','fdfgd','fdsfd','Interior',NULL),(31,'xzx','zx','Cachoeiras','MG','zx','zx','zxz','Interior',NULL),(32,'ewe','eqw','SÆo SebastiÆo','ES','weqw','wewq','qwe',NULL,NULL),(33,'u','uuu','Rio de Janeiro','RJ','uu','uuu','hh',NULL,NULL),(34,'vvv','vvv','Cordeiro','MG','v','vv','hhhh',NULL,NULL),(35,'iii','iii','Cordeiro','SP','iii','iii','iiii',NULL,NULL),(36,'ffffsdas','fff','Macuco','MG','fff','fffffff','ff','Teresopolis',NULL),(37,'cc','cc','Cantagalo','SP','c','ccc','cc',NULL,NULL),(38,'trtrtewrt','terter','Queimados','SP','retert','erter','retertr',NULL,NULL),(39,'UUUUUUU','UUUUUU','Carmo','RJ','U9','U','UUUUU',NULL,NULL),(40,'rua muraqui','centro','Rio de Janeiro','RJ','23232','33','vasco@vasco',NULL,NULL),(41,'rua soler','centro','Rio de Janeiro','RJ','99','8','VASCO@VASCO',NULL,NULL),(42,'rua mal','centro','Rio de Janeiro','RJ','888','7','botinha@bota',NULL,NULL),(43,'rua Mendes de Sá','centro','Nova Friburgo','RJ','28400121','24','barate@barate.com','Nova Friburgo',NULL),(44,'nnnnnnnn12','klklkl12','hhhygy12','RJ','888812',' jjkk12','ihuihui12',NULL,NULL),(45,'Alberto Braune','centro','Nova Friburgo','RJ','28600','13','paozao@ub.com.br','',NULL),(46,'UUUUUUU','Conselheiro Paulino','Nova Friburgo','RJ','28600','89','branel@branel.com.br','',NULL),(47,'Marques Braga','centro','Nova Friburgo','RJ','28600','88','marques@marques.com.br','',NULL),(48,'maroca','hhhhhhhh','fffffff','RJ','77777','9','hhhhhhhhh','',NULL),(49,'natal','aaaaaaa','bbbbb','RJ','999','88','oooooooo','',NULL),(50,'rua Salvador','dddddddd','Nova Friburgo','RJ','98987','45','ewewewe@wee','',NULL),(51,'morales','centro','NovaFriburgo','RJ','285347','99','iuuiu@w','',NULL),(52,'Maquiavel','centro','Nova Friburgo','RJ','28600','88','FFF@E','',NULL),(53,'UUUUUUU','centro','Nova Friburgo','RJ','28609','77','r@w','',0);

/*Table structure for table `endfornecedor` */

DROP TABLE IF EXISTS `endfornecedor`;

CREATE TABLE `endfornecedor` (
  `idEndereco` int(10) unsigned NOT NULL default '0',
  `idFornecedor` varchar(15) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `endfornecedor` */

insert  into `endfornecedor`(`idEndereco`,`idFornecedor`) values (19,'8888888888'),(20,'111111777777'),(21,'98054588'),(22,'20012004'),(23,'776655'),(24,'1973'),(25,'1973'),(29,'ersdfds'),(30,'wewerew'),(31,'zxz'),(32,'wewq'),(33,'u'),(34,'v'),(35,'iii'),(36,'ffff'),(37,'ccc'),(38,'232323'),(40,'12345678987654'),(41,'55555000000'),(42,'111111'),(44,'56473473ggg');

/*Table structure for table `estoque` */

DROP TABLE IF EXISTS `estoque`;

CREATE TABLE `estoque` (
  `idEstoque` int(10) unsigned NOT NULL auto_increment,
  `Quantidade` double unsigned NOT NULL default '0',
  `idProduto` int(10) unsigned NOT NULL default '0',
  `Validade` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`idEstoque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estoque` */

insert  into `estoque`(`idEstoque`,`Quantidade`,`idProduto`,`Validade`) values (7,58,8,'2005-01-01'),(9,465,8,'2004-12-25'),(10,101,10,'2004-11-17'),(11,57,10,'2004-11-27'),(12,478,7,'2005-12-31'),(13,200,7,'2006-12-31'),(14,466,6,'2004-12-20'),(15,300,6,'2005-01-01'),(16,382,9,'2005-01-01'),(17,90,9,'2006-11-25'),(18,36,10,'2004-10-22');

/*Table structure for table `fornecedor` */

DROP TABLE IF EXISTS `fornecedor`;

CREATE TABLE `fornecedor` (
  `cnpj` varchar(15) NOT NULL default '',
  `razaosocial` varchar(60) NOT NULL default '',
  `inscestadual` varchar(20) default NULL,
  `fantasia` varchar(60) default NULL,
  `repVendas` varchar(30) default NULL,
  PRIMARY KEY  (`cnpj`),
  UNIQUE KEY `cnpj` (`cnpj`),
  UNIQUE KEY `razaosocial` (`razaosocial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `fornecedor` */

insert  into `fornecedor`(`cnpj`,`razaosocial`,`inscestadual`,`fantasia`,`repVendas`) values ('111111777777','Eneias Ltda','86868686','Fusca','manoel'),('8888888888','Moura figueira','432','Cold Montain','juca'),('98054588','Maveric Ltda','98056600','Marvel','Carlos'),('55555000000','Vasco','12121','Vascao','miranda'),('776655','Angelina Jolie','9899899','Lara Croft','Angelina Jolie'),('1973','Palmeiras','878787','palmE','miriam'),('111111','Botafogo','9989','foguinho','kaled');
