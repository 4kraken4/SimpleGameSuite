SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `simple-game-suite` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `simple-game-suite`;

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `GameId` int NOT NULL AUTO_INCREMENT,
  `GameTitle` varchar(50) NOT NULL,
  `GameDescription` varchar(255) NOT NULL,
  `LastUpdated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ActiveStatus` bit(1) NOT NULL,
  PRIMARY KEY (`GameId`),
  UNIQUE KEY `idx_uni_gametitle` (`GameTitle`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `game` (`GameId`, `GameTitle`, `GameDescription`, `LastUpdated`, `ActiveStatus`) VALUES
(1, '8 Queens', '', '2023-05-26 06:58:56', b'1'),
(2, 'Tic Tac Toe', '', '2023-05-26 06:58:56', b'1'),
(3, 'Huffman Encode/Decode', '', '2023-05-26 06:58:56', b'1'),
(4, 'Find Shortest Path', '', '2023-05-26 06:58:56', b'1'),
(5, 'Find Minimum Spanning Tree', '', '2023-05-26 06:58:56', b'1');

DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `ScoreId` int NOT NULL AUTO_INCREMENT,
  `UID` int NOT NULL,
  `GID` int NOT NULL,
  `Value` int NOT NULL DEFAULT '0',
  `Answer` varbinary(256) NOT NULL,
  `LastUpdated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `HelperData` varbinary(600) DEFAULT NULL,
  PRIMARY KEY (`ScoreId`),
  UNIQUE KEY `uni_score_answer` (`Answer`),
  KEY `fk_score_userid` (`UID`) USING BTREE,
  KEY `fk_score_gameid` (`GID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(16) NOT NULL,
  `LastPayedOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `idx_user_username` (`Username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `score`
  ADD CONSTRAINT `fk_score_gameid` FOREIGN KEY (`GID`) REFERENCES `game` (`GameId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_score_userid` FOREIGN KEY (`UID`) REFERENCES `user` (`UserId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;