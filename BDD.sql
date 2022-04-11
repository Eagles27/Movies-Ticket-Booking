CREATE TABLE `client` (
  `idclient` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `admin` varchar(10) DEFAULT NULL,
  `member` varchar(10) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `movie` (
  `idmovie` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `released` varchar(10) DEFAULT NULL,
  `images` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idmovie`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `session` (
  `idseance` int NOT NULL AUTO_INCREMENT,
  `startingTime` varchar(30) DEFAULT NULL,
  `idmovie` int DEFAULT NULL,
  `placeAmount` int DEFAULT NULL,
  `room` int DEFAULT NULL,
  PRIMARY KEY (`idseance`),
  KEY `session_movie_idmovie_fk` (`idmovie`),
  CONSTRAINT `session_movie_idmovie_fk` FOREIGN KEY (`idmovie`) REFERENCES `movie` (`idmovie`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `ticket` (
  `idticket` int NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`idticket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
