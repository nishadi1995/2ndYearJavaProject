-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2018 at 04:45 AM
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
('BC001', 'Business Communication', 'Bachelor', 'School of Business'),
('BM001', 'BM in Accounting & Finance (Special)', 'Bachelor', 'School of Business'),
('CM001', 'Creative Multimedia', 'Bachelor', 'School of Business'),
('CN001', 'Computer Networks', 'Bachelor', 'School of Computing'),
('CN002', 'Computer Networks(MA)', 'Master', 'School of Computing'),
('ID001', 'Interior Design', 'Bachelor', 'School of Business'),
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
  `Qualification_type` varchar(20) NOT NULL,
  `institute` varchar(100) NOT NULL,
  `year_completed` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `postgraduate`
--

INSERT INTO `postgraduate` (`std_id`, `Qualification_type`, `institute`, `year_completed`) VALUES
(18000015, 'linhj', 'kmhj', 2015);

-- --------------------------------------------------------

--
-- Table structure for table `std_practical_subjects`
--

CREATE TABLE `std_practical_subjects` (
  `std_id` int(8) NOT NULL,
  `sub_code` varchar(7) NOT NULL,
  `lab_ass_marks` int(3) NOT NULL,
  `practical_demo_marks` int(3) NOT NULL,
  `project_marks` int(3) NOT NULL,
  `exam_marks` int(3) NOT NULL,
  `grade` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `std_id` int(8) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(60) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `age` int(2) NOT NULL,
  `connum` int(10) NOT NULL,
  `address` varchar(250) NOT NULL,
  `gender` char(1) NOT NULL,
  `intake` varchar(8) NOT NULL,
  `en_date` date NOT NULL,
  `course_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`std_id`, `first_name`, `middle_name`, `last_name`, `nic`, `dob`, `age`, `connum`, `address`, `gender`, `intake`, `en_date`, `course_id`) VALUES
(18000000, 'Test', 'Test', 'Test', '000000000v', '2018-06-14', 0, 0, 'test', 'M', 'Test', '2018-06-14', 'BC001'),
(18000005, 'Sanuri', 'nisansala', 'gamage', '9586321v', '2010-07-06', 0, 65564, 'yt unu', 'F', 'February', '2018-06-14', 'CN001'),
(18000006, 'ava', 'G', 'dwh', '54565v', '2007-06-26', 0, 546284, 'iuhouij uwhdwiu', 'M', 'February', '2018-06-14', 'BA001'),
(18000007, 'ava', 'G', 'dwh', '54565v', '2007-06-26', 0, 546284, 'iuhouij uwhdwiu', 'M', 'February', '2018-06-14', 'BA001'),
(18000008, 'fdsvse', 'ev', 'efve', '5296v', '2007-06-12', 0, 6456653, 'qe', 'M', 'February', '2018-06-14', 'BA001'),
(18000009, 'jfneawij ijneijaf', 'ijnfeijf ', 'jnij', '654154', '2018-06-14', 0, 565, 'segjo', 'M', 'February', '2018-06-14', 'BA001'),
(18000010, 'jfneawij ijneijaf', 'ijnfeijf ', 'jnij', '654154', '2018-06-14', 0, 565, 'segjo', 'M', 'February', '2018-06-14', 'BA001'),
(18000011, 'erg', 'egawe', 'ugb', '1665v', '2018-06-14', 0, 654, 'i o uoi', 'M', 'February', '2018-06-14', 'CN002'),
(18000012, 'ffff', 'fffff', 'ggggggg', '432', '2018-06-14', 0, 33256, 'uyh ib', 'M', 'February', '2018-06-14', 'CM001'),
(18000013, 'ffff', 'fffff', 'ggggggg', '432', '2018-06-14', 0, 33256, 'uyh ib', 'M', 'February', '2018-06-14', 'CM001'),
(18000014, 'bbbb', 'bbbbb', 'bbbb', '154362v', '2018-06-14', 0, 40433, 'nguuil lnuh', 'M', 'February', '2018-06-14', 'BA001'),
(18000015, 'bbbb', 'bbbbb', 'bbbb', '154362v', '2018-06-14', 0, 40433, 'nguuil lnuh', 'M', 'February', '2018-06-14', 'BA001');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `sub_code` varchar(7) NOT NULL,
  `sub_name` varchar(80) NOT NULL,
  `fees` int(4) NOT NULL,
  `credits` int(1) NOT NULL,
  `yr_sem` varchar(15) NOT NULL,
  `course_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`sub_code`, `sub_name`, `fees`, `credits`, `yr_sem`, `course_id`) VALUES
('AB001', 'ABC', 2500, 2, '2nd yr_1st sem', 'CM001'),
('IND001', 'Interior Design I', 2500, 3, '1st yr_1st sem', 'ID001'),
('tst001', 'test', 2000, 3, '2nd yr_1st sem', 'BM001');

-- --------------------------------------------------------

--
-- Table structure for table `undergraduate`
--

CREATE TABLE `undergraduate` (
  `std_id` int(8) NOT NULL,
  `al_results` char(4) NOT NULL,
  `d_rank` int(8) NOT NULL,
  `i_rank` int(10) NOT NULL,
  `zscore` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `undergraduate`
--

INSERT INTO `undergraduate` (`std_id`, `al_results`, `d_rank`, `i_rank`, `zscore`) VALUES
(18000000, 'AAA', 123, 15423, 2.3623),
(18000005, 'AAA', 4165, 54, 1.23),
(18000012, 'ACA', 45, 456, 0.1235);

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
  ADD PRIMARY KEY (`std_id`);

--
-- Indexes for table `std_practical_subjects`
--
ALTER TABLE `std_practical_subjects`
  ADD PRIMARY KEY (`std_id`,`sub_code`),
  ADD KEY `sub_code` (`sub_code`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`std_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`sub_code`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `undergraduate`
--
ALTER TABLE `undergraduate`
  ADD PRIMARY KEY (`std_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `postgraduate`
--
ALTER TABLE `postgraduate`
  MODIFY `std_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18100008;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `std_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18000017;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD CONSTRAINT `postgraduate_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `std_practical_subjects`
--
ALTER TABLE `std_practical_subjects`
  ADD CONSTRAINT `std_practical_subjects_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `std_practical_subjects_ibfk_2` FOREIGN KEY (`sub_code`) REFERENCES `subjects` (`sub_code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `undergraduate`
--
ALTER TABLE `undergraduate`
  ADD CONSTRAINT `undergraduate_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
