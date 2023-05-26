-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 26, 2023 at 01:37 AM
-- Server version: 8.0.29
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simple-game-suite`
--
CREATE DATABASE IF NOT EXISTS `simple-game-suite` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `simple-game-suite`;

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

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

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`GameId`, `GameTitle`, `GameDescription`, `LastUpdated`, `ActiveStatus`) VALUES
(1, '8 Queens', '', '2023-05-26 06:58:56', b'1'),
(2, 'Tic Tac Toe', '', '2023-05-26 06:58:56', b'1'),
(3, 'Huffman Encode/Decode', '', '2023-05-26 06:58:56', b'1'),
(4, 'Find Shortest Path', '', '2023-05-26 06:58:56', b'1'),
(5, 'Find Minimum Spanning Tree', '', '2023-05-26 06:58:56', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `ScoreId` int NOT NULL AUTO_INCREMENT,
  `UID` int NOT NULL,
  `GID` int NOT NULL,
  `UserScore` int NOT NULL DEFAULT '0',
  `LastUpdated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ScoreId`),
  KEY `fk_score_userid` (`UID`) USING BTREE,
  KEY `fk_score_gameid` (`GID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(16) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `fk_score_gameid` FOREIGN KEY (`GID`) REFERENCES `game` (`GameId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_score_userid` FOREIGN KEY (`UID`) REFERENCES `user` (`UserId`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
