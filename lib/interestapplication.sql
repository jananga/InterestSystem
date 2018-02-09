-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2018 at 06:34 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET AUTOCOMMIT = 0;
START TRANSACTION;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `interestapplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cusID` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `telNoOne` varchar(10) DEFAULT NULL,
  `telNoTwo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cusID`, `name`, `telNoOne`, `telNoTwo`) VALUES
(1, 'Princi', '0724052127', ''),
(11, 'Wasana akka', '0765481473', '0772205767'),
(12, 'Princige akka', '0719620232', ''),
(13, 'Princige akkage duva (Teacher)', '0714440062', '0770584694'),
(14, 'Princi (Halawatha) - Princige akkage deveni duva', '', ''),
(15, 'Ralahamige duva', '', ''),
(16, 'Clarence - Modara', '0771502004', '0725491846'),
(17, 'Thilina', '0766413221', '');

-- --------------------------------------------------------

--
-- Table structure for table `interest`
--

CREATE TABLE `interest` (
  `interestID` int(11) NOT NULL,
  `cusID` int(11) NOT NULL,
  `date` date NOT NULL,
  `amount` double NOT NULL,
  `interest` float NOT NULL,
  `installment` double NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interest`
--

INSERT INTO `interest` (`interestID`, `cusID`, `date`, `amount`, `interest`, `installment`, `description`) VALUES
(6, 1, '2016-01-02', 80000, 10, 5000, 'My test installment update');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `name`, `email`, `password`) VALUES
(1, 'jana', 'janangah@gmail.com', 'jana'),
(2, 'jana', 'jananga_h@yahoo.com', '123'),
(3, 'jana boy', 'admin@gmail.com', '12345'),
(4, 'Jananga hettiarachchi', 'jananga_h@yahoo.com', '1234'),
(5, 'Jananga hettiarachchi', 'jananga_h@yahoo.com', '1234'),
(6, 'Jananga hettiarachchi', 'jananga_h@yahoo.com', 'tt'),
(7, 'Jananga hettiarachchi', 'jananga_h@yahoo.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cusID`);

--
-- Indexes for table `interest`
--
ALTER TABLE `interest`
  ADD PRIMARY KEY (`interestID`),
  ADD KEY `fk_CusID` (`cusID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cusID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `interest`
--
ALTER TABLE `interest`
  MODIFY `interestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `interest`
--
ALTER TABLE `interest`
  ADD CONSTRAINT `fk_CusID` FOREIGN KEY (`cusID`) REFERENCES `customer` (`cusID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
