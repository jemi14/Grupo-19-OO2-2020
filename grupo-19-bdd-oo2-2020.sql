CREATE DATABASE  IF NOT EXISTS `grupo-19-bdd-oo2-2020` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `grupo-19-bdd-oo2-2020`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo-19-bdd-oo2-2020
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `mail` varchar(30) DEFAULT NULL,
  `id_persona` bigint NOT NULL,
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `FKlbs69o9qkvv7lgn06idak3crb` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('r@mail',1),('l@mail',2),('ul@mail',3);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerente`
--

DROP TABLE IF EXISTS `gerente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gerente` (
  `legajo` bigint DEFAULT NULL,
  `sueldo_basico` float DEFAULT NULL,
  `id_persona` bigint NOT NULL,
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `FK11telbxi00xnevesjwe9osc7x` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerente`
--

LOCK TABLES `gerente` WRITE;
/*!40000 ALTER TABLE `gerente` DISABLE KEYS */;
INSERT INTO `gerente` VALUES (1111111,120000,4),(1222222,220000,5),(133333,320000,6),(1444444,120000,7),(155555,220000,8),(1666666,320000,9),(8274929,1111,22);
/*!40000 ALTER TABLE `gerente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calle` varchar(30) NOT NULL,
  `latitud` float DEFAULT NULL,
  `localidad` varchar(30) NOT NULL,
  `longitud` float DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `telefono` bigint DEFAULT NULL,
  `gerente_id_persona` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckynv5hyopte2cp332egt4a4w` (`gerente_id_persona`),
  CONSTRAINT `FKckynv5hyopte2cp332egt4a4w` FOREIGN KEY (`gerente_id_persona`) REFERENCES `gerente` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Rodriguez',-34.42,'Banfield',-58.23,1111,1234,4),(2,'Alfonsin',-34.45,'Lanus',-58.22,22222,12224,5),(3,'Chaco',-27.45,'Resistencia',-58.98,333,12224,6),(4,'Peron',-36.6167,'Santa Rosa',-64.2833,1111,1234,7),(5,'Cristina F.',-41.1456,'Bariloche',-71.3082,22222,12224,8),(6,'Sarmiento',-32.9468,'Rosario',-60.6393,333,12224,9);
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `entregado` bit(1) NOT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `pagado` bit(1) NOT NULL,
  `tomado` bit(1) NOT NULL,
  `cliente_id_persona` int DEFAULT NULL,
  `local_id` int DEFAULT NULL,
  `producto_id` int DEFAULT NULL,
  `vendedor_id_persona` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKee9kmfvfpfbidx3ssf0fbg502` (`cliente_id_persona`),
  KEY `FKcl9gf7hbaosndcvwud8auides` (`local_id`),
  KEY `FKsoggxhdxr3wnhv3kdkka1nmvy` (`producto_id`),
  KEY `FK9tt6uo9va8fccetnxy3jqngde` (`vendedor_id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,22,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-04-10',_binary '\0',_binary '\0',2,2,3,12),(2,114,'Contamos con su pedido en la sucursal elegida, pronto estara disponible su pedido. Se realizara la entrega en los proximos 7 días.',_binary '\0','2020-01-14','2020-01-07',_binary '\0',_binary '',2,2,2,13),(3,71,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-03-18',_binary '\0',_binary '\0',2,2,1,12),(4,32,'En esa sucursal no contamos con tantos productos,usaremos las sucursales mas proximas. Productos llegando de las sucursales: Resistencia- Rosario- ',_binary '\0','2020-05-11','2020-04-26',_binary '\0',_binary '',3,3,2,14),(5,53,'En esa sucursal no contamos con tantos productos,usaremos las sucursales mas proximas. Productos llegando de las sucursales: Santa Rosa- Rosario- Banfield- Lanus- Resistencia- ',_binary '\0','2020-04-02','2020-03-18',_binary '\0',_binary '',3,4,4,18),(6,13,'Contamos con su pedido en la sucursal elegida, pronto estara disponible su pedido. Se realizara la entrega en los proximos 7 días.',_binary '\0','2020-03-25','2020-03-18',_binary '\0',_binary '',3,6,5,21),(7,52,'En esa sucursal no contamos con tantos productos,usaremos las sucursales mas proximas. Productos llegando de las sucursales: Banfield- Lanus- Rosario- ',_binary '\0','2020-03-10','2020-02-24',_binary '\0',_binary '',3,1,2,11),(8,22,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-04-10',_binary '\0',_binary '\0',2,2,3,12),(9,22,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-10',_binary '\0',_binary '\0',2,2,3,12),(10,32,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,1,1,11),(11,31,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',2,2,6,12),(12,43,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',3,3,5,14),(13,32,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,2,5,12),(14,54,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,1,1,11),(15,12,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,2,1,13),(16,32,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,3,3,14),(17,37,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,1,4,11),(18,371,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-14',_binary '\0',_binary '\0',1,2,1,13),(19,92,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-19',_binary '\0',_binary '\0',3,2,3,13),(20,41,'Usted desea mas productos de los que tenemos. Cuando tengamos stock nos comunicaremos para que usted confirme si sigue interesado en la compra.',_binary '\0',NULL,'2020-05-19',_binary '\0',_binary '\0',2,1,2,12);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id_persona` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(30) NOT NULL,
  `dni` bigint DEFAULT NULL,
  `fecha_de_nacimiento` date DEFAULT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Ortiz',3111111,'1998-08-01','Raul'),(2,'Muniz',3222222,'1991-08-02','Lara'),(3,'Perez',3233333,'1992-08-03','Lucas'),(4,'Benitez',1111111,'1995-01-14','Griselda'),(5,'Gomez',1222222,'1992-01-04','Leandro'),(6,'Wolf',133333,'1993-01-01','Marcelo'),(7,'Trotta',1444444,'1991-08-01','Agustin'),(8,'Iglesias',155555,'1992-08-01','Alberto'),(9,'Altamirano',1666666,'1990-08-01','Aldana'),(10,'Garcia',21111111,'1990-04-01','Jorge'),(11,'Baldi',22222222,'1991-12-02','Raul'),(12,'Haugg',23333333,'1992-02-03','Belen'),(13,'Lopez',24444444,'1989-07-04','Roberto'),(14,'Diaz',25555555,'1988-08-05','Samuel'),(15,'Jenez',26666666,'1987-06-06','Ismael'),(16,'Albert',27777777,'1986-03-07','Abraham'),(17,'Saba',28888888,'1985-11-08','Sara'),(18,'Tres',29999999,'1995-05-09','Isaac'),(19,'Azul',21010101,'1987-10-10','Lot'),(20,'Blanco',21011111,'1997-09-11','Rebeca'),(21,'Diez',21012222,'1981-08-12','Juliana'),(22,'Geren',8274929,'2020-06-09','NUevoGerente');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio_unitario` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'EL mas rico, lo vale...','Chocolate',123.5),(2,'Baratito pero delicioso','Kinder',13.5),(3,'Rico','Caramelo palito de la selva',11),(4,'Sabor del conurbano','Helado',15.1),(5,'Las mejores pepas','Pepas',20);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `local_id` bigint DEFAULT NULL,
  `producto_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmteaiv8alkvidnj3rca5r110h` (`local_id`),
  KEY `FK1hx9o107cpb0o8hppaicd7af9` (`producto_id`),
  CONSTRAINT `FK1hx9o107cpb0o8hppaicd7af9` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`),
  CONSTRAINT `FKmteaiv8alkvidnj3rca5r110h` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,0,'2020-04-11',1,1),(2,0,'2020-04-26',2,1),(3,12,'2020-03-18',3,1),(4,11,'2020-02-02',4,1),(5,12,'2020-01-07',5,1),(6,3,'2020-04-10',6,1),(7,0,'2020-03-11',1,2),(8,0,'2020-02-24',2,2),(9,0,'2020-01-25',3,2),(10,41,'2020-03-11',4,2),(11,10,'2020-04-22',5,2),(12,38,'2020-05-14',6,2),(13,2,'2020-04-06',1,3),(14,2,'2020-02-17',2,3),(15,2,'2020-05-08',3,3),(16,2,'2020-01-08',4,3),(17,2,'2020-01-23',5,3),(18,2,'2020-03-05',6,3),(19,0,'2020-03-01',1,4),(20,0,'2020-02-11',2,4),(21,20,'2020-02-03',3,4),(22,0,'2020-04-28',4,4),(23,13,'2020-03-05',5,4),(24,0,'2020-05-29',6,4),(25,102,'2020-04-14',1,5),(26,12,'2020-05-13',2,5),(27,2,'2020-03-30',3,5),(28,21,'2020-03-26',4,5),(29,43,'2020-04-14',5,5),(30,1,'2020-02-20',6,5);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,NULL,_binary '','$2a$10$G1ymZR3MR7gZPYlke5zLEucMTiRMyKQRvJ0UTvy.diFK/MVthBxrW',NULL,'gerente'),(3,NULL,_binary '','$2a$10$L4IsCDkvtDRuqAQB/0mz/exuybIV/V7UEuVZaEsIRCTj1Y09oyc6C',NULL,'vendedor'),(4,NULL,_binary '','$2a$10$D3r3cEiUVNotjYsZFZEH6.m5uoecWkyHO2.4XuBzE1ZhNyTIpX0f2',NULL,'cliente'),(5,NULL,_binary '','$2a$10$GmooAhVx1cTAy62sDS73rO77/FSXyw3BeHiy76eDIfcKvv81Ywqui',NULL,'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `role` varchar(100) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKscfpive7aa0o9savdwmxmnaij` (`role`,`user_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,NULL,'ROLE_GERENTE',NULL,2),(3,NULL,'ROLE_VENDEDOR',NULL,3),(4,NULL,'ROLE_CLIENTE',NULL,4),(5,NULL,'ROLE_ADMIN',NULL,5);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `extra` float DEFAULT NULL,
  `horas_por_jornada` time DEFAULT NULL,
  `sueldo_basico` float DEFAULT NULL,
  `id_persona` bigint NOT NULL,
  `local_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FK5p8oeqjy48ubmjngebufdgnk8` (`local_id`),
  CONSTRAINT `FK5p8oeqjy48ubmjngebufdgnk8` FOREIGN KEY (`local_id`) REFERENCES `local` (`id`),
  CONSTRAINT `FKroe98nhopj8kja00hydk444pu` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (0.4,NULL,15000,10,1),(0.4,NULL,11000,11,1),(0.4,NULL,23000,12,2),(0.4,NULL,20000,13,2),(0.4,NULL,110000,14,3),(0.4,NULL,23000,15,3),(0.4,NULL,10000,16,3),(0.4,NULL,11000,17,4),(0.4,NULL,23000,18,4),(0.4,NULL,22000,19,5),(0.4,NULL,11000,20,6),(0.4,NULL,23000,21,6);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'grupo-19-bdd-oo2-2020'
--

--
-- Dumping routines for database 'grupo-19-bdd-oo2-2020'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-19 22:22:01
