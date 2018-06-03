-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2018 at 08:53 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `course_enrolment_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `course_id` varchar(5) NOT NULL,
  `course_name` varchar(60) NOT NULL,
  `type` varchar(10) NOT NULL,
  `faculty_name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `course_name`, `type`, `faculty_name`) VALUES
('BA001', 'Business Administration', 'Master', 'School of Business'),
('BC001', 'Business Communication', 'Bachelor', 'Faculty of Business'),
('CM001', 'Creative Multimedia', 'Bachelor', 'School of Business'),
('CN001', 'Computer Networks', 'Bachelor', 'School of Computing'),
('CN002', 'Computer Networks(MA)', 'Master', 'School of Computing'),
('SE001', 'Software Engineering(Honours)', 'Bachelor', 'School of Computing');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(7) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('nsbm001', 'pwnsbm001'),
('nsbm002', 'pwnsbm002'),
('nsbm003', 'pwnsbm003'),
('nsbm004', 'pwnsbm004');

-- --------------------------------------------------------

--
-- Table structure for table `postgraduate`
--

CREATE TABLE `postgraduate` (
  `std_id` int(8) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(60) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `age` int(2) NOT NULL,
  `connum` int(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `gender` char(1) NOT NULL,
  `intake` varchar(8) NOT NULL,
  `en_date` date NOT NULL,
  `Qualification_type` varchar(20) NOT NULL,
  `institute` varchar(100) NOT NULL,
  `year_completed` year(4) NOT NULL,
  `course_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `postgraduate`
--

INSERT INTO `postgraduate` (`std_id`, `first_name`, `middle_name`, `last_name`, `nic`, `dob`, `age`, `connum`, `address`, `gender`, `intake`, `en_date`, `Qualification_type`, `institute`, `year_completed`, `course_id`) VALUES
(18100005, 'Kasun', 'withana', 'GAmage', '56895623v', '1990-06-12', 0, 4569355, 'mvn ancsi', 'M', 'February', '2018-06-01', 'BSc', 'University of Dublin', 2016, 'CN002'),
(18100006, 'Nimali', 'Q', 'Amarasingha', '90236548v', '1997-06-17', 0, 421569, 'no 125/5', 'F', 'February', '2018-06-01', 'BA', 'University of Ruhuna', 2015, 'BA001');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `sub_code` varchar(7) NOT NULL,
  `sub_name` varchar(80) NOT NULL,
  `fees` int(4) NOT NULL,
  `credits` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`sub_code`, `sub_name`, `fees`, `credits`) VALUES
('DIM001', 'Digital Imaging I', 2500, 3),
('DIM002', 'Digital Imaging II', 2500, 3),
('DWN001', 'Drawing', 2000, 2),
('VCM001', 'Visual Communication', 2500, 2);

-- --------------------------------------------------------

--
-- Table structure for table `undergraduate`
--

CREATE TABLE `undergraduate` (
  `std_id` int(8) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(60) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `age` int(2) NOT NULL,
  `address` varchar(250) NOT NULL,
  `connum` int(10) NOT NULL,
  `gender` char(1) NOT NULL,
  `intake` varchar(8) NOT NULL,
  `en_date` date NOT NULL,
  `al_results` char(4) NOT NULL,
  `d_rank` int(8) NOT NULL,
  `i_rank` int(10) NOT NULL,
  `zscore` double NOT NULL,
  `course_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `undergraduate`
--

INSERT INTO `undergraduate` (`std_id`, `first_name`, `middle_name`, `last_name`, `nic`, `dob`, `age`, `address`, `connum`, `gender`, `intake`, `en_date`, `al_results`, `d_rank`, `i_rank`, `zscore`, `course_id`) VALUES
(18000031, 'KAmal', 'N', 'Wickrama', '12254841v', '1998-06-16', 0, 'bvnf eieie', 158452, 'M', 'February', '2018-06-01', 'AAAA', 12, 45, 1.2356, 'CN001'),
(18000033, 'Malik', 'A', 'Samarawickrama', '926538125v', '1992-10-23', 0, 'bvh jcn', 214555, 'M', 'February', '2018-06-01', 'BAAC', 1212, 10235, 2.365, 'CM001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD PRIMARY KEY (`std_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`sub_code`);

--
-- Indexes for table `undergraduate`
--
ALTER TABLE `undergraduate`
  ADD PRIMARY KEY (`std_id`),
  ADD KEY `course_id` (`course_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `postgraduate`
--
ALTER TABLE `postgraduate`
  MODIFY `std_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18100007;
--
-- AUTO_INCREMENT for table `undergraduate`
--
ALTER TABLE `undergraduate`
  MODIFY `std_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18000034;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD CONSTRAINT `postgraduate_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `undergraduate`
--
ALTER TABLE `undergraduate`
  ADD CONSTRAINT `undergraduate_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
