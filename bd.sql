CREATE DATABASE `db_tareas` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;


-- db_tareas.usuarios definition

CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `email_usuario` varchar(255) DEFAULT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  `password_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- db_tareas.tareas definition

CREATE TABLE `tareas` (
  `id_tarea` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion_tarea` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `titulo_tarea` varchar(255) DEFAULT NULL,
  `usuario_id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `FK4op1e3n6k3loxkhfnmbb38jx6` (`usuario_id_usuario`),
  CONSTRAINT `FK4op1e3n6k3loxkhfnmbb38jx6` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
