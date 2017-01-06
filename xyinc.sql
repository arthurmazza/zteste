CREATE DATABASE  IF NOT EXISTS `xyinc`;
USE `xyinc`;

-- Criação da estrutura da tabela `places`


DROP TABLE IF EXISTS `places`;
CREATE TABLE `places` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- Inserção dos dados tabela `places`


LOCK TABLES `places` WRITE;
INSERT INTO `places` VALUES (1,'Lanchonete', 27, 12);
INSERT INTO `places` VALUES (2,'Posto', 31, 18);
INSERT INTO `places` VALUES (3,'Joalheria', 15, 12);
INSERT INTO `places` VALUES (4,'Floricultura', 19, 21);
INSERT INTO `places` VALUES (5,'Pub', 12, 8);
INSERT INTO `places` VALUES (6,'Supermercado', 23, 6);
INSERT INTO `places` VALUES (7,'Churrascaria', 28, 2);
UNLOCK TABLES;
