-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2015 at 06:41 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hiber`
--

-- --------------------------------------------------------

--
-- Table structure for table `addresses`
--

CREATE TABLE IF NOT EXISTS `addresses` (
  `addresse_id` int(10) NOT NULL AUTO_INCREMENT,
  `people_id` int(10) NOT NULL,
  `addresse_name` varchar(255) NOT NULL,
  PRIMARY KEY (`addresse_id`),
  KEY `people_id` (`people_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `disciplines`
--

CREATE TABLE IF NOT EXISTS `disciplines` (
  `discipline_id` int(10) NOT NULL AUTO_INCREMENT,
  `name_discipline` varchar(255) NOT NULL,
  PRIMARY KEY (`discipline_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `disciplines`
--

INSERT INTO `disciplines` (`discipline_id`, `name_discipline`) VALUES
(1, 'Matematica'),
(2, 'Fisica'),
(3, 'Historia'),
(4, 'Religiao'),
(5, 'Portugues'),
(8, 'disciplina1'),
(9, 'disciplina1'),
(10, 'disciplina1'),
(11, 'disciplina1'),
(12, 'disciplina1'),
(13, 'disciplina1'),
(14, 'disciplina1');

-- --------------------------------------------------------

--
-- Table structure for table `disciplines_peoples`
--

CREATE TABLE IF NOT EXISTS `disciplines_peoples` (
  `disciplines_discipline_id` int(11) NOT NULL,
  `peoples_people_id` int(11) NOT NULL,
  KEY `FK_c2b256a8df27432cb0e50357534` (`peoples_people_id`),
  KEY `FK_ef48417acb4c435d8b412f5b684` (`disciplines_discipline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disciplines_peoples`
--

INSERT INTO `disciplines_peoples` (`disciplines_discipline_id`, `peoples_people_id`) VALUES
(8, 18),
(9, 19),
(10, 20),
(11, 21),
(12, 22);

-- --------------------------------------------------------

--
-- Table structure for table `peoples`
--

CREATE TABLE IF NOT EXISTS `peoples` (
  `people_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`people_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `peoples`
--

INSERT INTO `peoples` (`people_id`, `name`) VALUES
(2, 'Musashi'),
(18, 'coleman'),
(19, 'Novo Mapa Disci'),
(20, 'Novo Mapa Disci'),
(21, 'Novo Mapa Disci'),
(22, 'Novo Mapa Disci');

-- --------------------------------------------------------

--
-- Table structure for table `peoples_disciplines`
--

CREATE TABLE IF NOT EXISTS `peoples_disciplines` (
  `peoples_people_id` int(11) NOT NULL,
  `disciplines_discipline_id` int(11) NOT NULL,
  KEY `FK_eb739dccb30e404299f234bd575` (`disciplines_discipline_id`),
  KEY `FK_1630752b27c640a1980ccb6b889` (`peoples_people_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `people_id` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `people_id` (`people_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `people_id`, `email`) VALUES
(2, 2, 'th3ultimat3@hotmail.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addresses`
--
ALTER TABLE `addresses`
  ADD CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`people_id`) REFERENCES `peoples` (`people_id`) ON DELETE CASCADE;

--
-- Constraints for table `disciplines_peoples`
--
ALTER TABLE `disciplines_peoples`
  ADD CONSTRAINT `FK_c2b256a8df27432cb0e50357534` FOREIGN KEY (`peoples_people_id`) REFERENCES `peoples` (`people_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_ef48417acb4c435d8b412f5b684` FOREIGN KEY (`disciplines_discipline_id`) REFERENCES `disciplines` (`discipline_id`) ON DELETE CASCADE;

--
-- Constraints for table `peoples_disciplines`
--
ALTER TABLE `peoples_disciplines`
  ADD CONSTRAINT `FK_1630752b27c640a1980ccb6b889` FOREIGN KEY (`peoples_people_id`) REFERENCES `peoples` (`people_id`),
  ADD CONSTRAINT `FK_eb739dccb30e404299f234bd575` FOREIGN KEY (`disciplines_discipline_id`) REFERENCES `disciplines` (`discipline_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`people_id`) REFERENCES `peoples` (`people_id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
