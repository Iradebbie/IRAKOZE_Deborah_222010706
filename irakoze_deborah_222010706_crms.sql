-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:46 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `irakoze_deborah_222010706_crms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `first_name` varchar(223) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(220) NOT NULL,
  `position` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `first_name`, `last_name`, `email`, `phone_number`, `position`) VALUES
(1, 'Deborah', 'Irakoze', 'deb@gmail.com', '0789654321', 'Analyst'),
(4, 'don', 'bo', 'don@gmail.com', '07888888888', 'it');

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL,
  `Make` varchar(50) DEFAULT NULL,
  `Model` varchar(50) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `Daily_Rate` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`car_id`, `Make`, `Model`, `Year`, `Daily_Rate`) VALUES
(1, 'toyota', 'newversion', 2024, 1.20),
(2, 'mercedese', 'newversion3', 2024, 1.50),
(3, 'LAND LOVER', 'NEWVERSION', 2024, 1.00),
(4, 'britian', 'V7', 2009, 1.40),
(6, 'range rover', 'v5', 2009, 1.50);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` int(11) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `firstName`, `lastName`, `email`, `Phone`) VALUES
(1, 'deborah', 'irakoze', 'ira@gmail.com', '0788100700'),
(2, 'Deborah', 'Irakoze', 'irakoze@gmail.com', '0789654321'),
(10, 'deb', 'mine', 'mine@gmail.com', '0789654321'),
(14, 'deb', 'irakoze', 'deb@gmail.com', '0789654321');

-- --------------------------------------------------------

--
-- Table structure for table `loyalty`
--

CREATE TABLE `loyalty` (
  `program_id` int(10) NOT NULL,
  `program_name` varchar(220) NOT NULL,
  `reword_threshold` varchar(220) NOT NULL,
  `reward_description` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loyalty`
--

INSERT INTO `loyalty` (`program_id`, `program_name`, `reword_threshold`, `reward_description`) VALUES
(1, 'Deb', 'second', 'grave');

-- --------------------------------------------------------

--
-- Table structure for table `serverlog`
--

CREATE TABLE `serverlog` (
  `log_id` int(11) NOT NULL,
  `timestamp` date NOT NULL,
  `logmessage` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `serverlog`
--

INSERT INTO `serverlog` (`log_id`, `timestamp`, `logmessage`) VALUES
(1, '2023-06-07', 'wawuu'),
(2, '2023-06-07', 'your are very delay for accessing those station'),
(3, '2024-01-22', 'time access'),
(4, '2024-12-03', 'added informs'),
(5, '2024-01-22', 'accessed on tme at station'),
(6, '2024-08-05', 'more'),
(7, '2024-02-04', 'sdcfgvbh'),
(9, '2021-07-08', 'accessed');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `id` int(10) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `user_name` varchar(220) NOT NULL,
  `pass_word` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`id`, `first_name`, `last_name`, `user_name`, `pass_word`) VALUES
(1, 'IRAKOZE', 'Deborah', 'debbie', '3103@Deb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `loyalty`
--
ALTER TABLE `loyalty`
  ADD PRIMARY KEY (`program_id`);

--
-- Indexes for table `serverlog`
--
ALTER TABLE `serverlog`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `loyalty`
--
ALTER TABLE `loyalty`
  MODIFY `program_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `serverlog`
--
ALTER TABLE `serverlog`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
