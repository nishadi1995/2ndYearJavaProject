-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2018 at 11:48 AM
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
-- Table structure for table `academic_staff`
--

CREATE TABLE `academic_staff` (
  `staff_id` int(4) NOT NULL,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `con_num` int(10) NOT NULL,
  `email` varchar(35) NOT NULL,
  `room` varchar(5) NOT NULL,
  `lec_or_inst` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `academic_staff`
--

INSERT INTO `academic_staff` (`staff_id`, `name`, `address`, `con_num`, `email`, `room`, `lec_or_inst`) VALUES
(1, 'Sunil Wickramanayaka', '133/5,Kottawa', 714562588, 'sunil@gmail.com', 'L001', 1),
(24, 'Noel Perera', 'no:23,Maharagama', 778956664, 'Perera123@gmail.com', 'I001', 0),
(25, 'Jeewani Rathnayaka', '45/8,talawathugoda', 775688956, 'jeewani@gmail.com', 'L002', 1),
(26, 'Manju Shri Gamage', '\"lakdil\",Hikkaduwa.', 716768859, 'manju@gmail.com', 'L003', 1),
(27, 'Kasun Kalpana', 'no:89,nawam road,Homagama', 716593265, 'kasun1992@gmail.com', 'L001', 1),
(28, 'Nimesh Ariyarathna', '45/8,Colombo Road,Mount Lavinia', 774585651, 'nimesh@yahoo.com', 'I002', 0),
(29, 'Tharanga Gamage', 'malwatta road,kandy', 716523653, 'tharanga@gmail.com', 'L003', 1);

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
('CS001', 'Computer Science', 'Bachelor', 'School of Computing'),
('CS002', 'Computer Security', 'Master', 'School of Computing'),
('CS003', 'Computer Systems Engineering', 'Master', 'School of Engineering'),
('HR001', 'Human Resource Management', 'Bachelor', 'School of Business'),
('ID001', 'Interior Design', 'Bachelor', 'School of Engineering'),
('MI001', 'Management Information Systems', 'Master', 'School of Computing'),
('MM001', 'Marketing Management', 'Bachelor', 'School of Business'),
('SE001', 'Software Engineering(Honours)', 'Bachelor', 'School of Computing'),
('SE002', 'Software Engineering(Masters)', 'Master', 'School of Computing');

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
  `std_id` int(10) NOT NULL,
  `Qualification_type` varchar(120) NOT NULL,
  `institute` varchar(100) NOT NULL,
  `year_completed` year(4) NOT NULL,
  `course_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `postgraduate`
--

INSERT INTO `postgraduate` (`std_id`, `Qualification_type`, `institute`, `year_completed`, `course_id`) VALUES
(18000003, 'Bachelor of Networking', 'SLIIT', 2016, 'CN002'),
(18000005, 'Bachelor of Art', 'ICBT institute', 2015, 'CS003'),
(18000008, 'B com', 'University of Kelaniya', 2016, 'MI001'),
(18000011, 'BSc in networking', 'NSBM university', 2018, 'SE002');

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE `sessions` (
  `date` date NOT NULL,
  `time` time NOT NULL,
  `location` varchar(20) NOT NULL,
  `duration` int(3) NOT NULL,
  `staff_id` int(4) NOT NULL,
  `sub_code` varchar(7) NOT NULL,
  `lecorlab` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sessions`
--

INSERT INTO `sessions` (`date`, `time`, `location`, `duration`, `staff_id`, `sub_code`, `lecorlab`) VALUES
('2018-08-16', '08:00:00', 'W002', 2, 1, 'FC001', 0),
('2018-08-17', '08:00:00', 'W001', 2, 1, 'EP002', 0),
('2018-12-30', '08:30:00', 'S002', 2, 24, 'FC001', 1),
('2018-11-30', '08:00:00', 'S002', 2, 1, 'EP002', 0);

-- --------------------------------------------------------

--
-- Table structure for table `staff_subjects`
--

CREATE TABLE `staff_subjects` (
  `staff_id` int(4) NOT NULL,
  `sub_code` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_subjects`
--

INSERT INTO `staff_subjects` (`staff_id`, `sub_code`) VALUES
(1, 'EP002'),
(1, 'FC001'),
(24, 'FC001'),
(24, 'IC001'),
(25, 'II001'),
(25, 'IM001'),
(25, 'RM001'),
(26, 'FP001'),
(26, 'VC001'),
(27, 'IB001'),
(27, 'PD001'),
(29, 'FC001'),
(29, 'IC001');

-- --------------------------------------------------------

--
-- Table structure for table `std_practical_subjects`
--

CREATE TABLE `std_practical_subjects` (
  `std_id` int(8) NOT NULL,
  `sub_code` varchar(7) NOT NULL,
  `lab_ass_marks` varchar(25) NOT NULL DEFAULT 'Still not attempted',
  `practical_demo_marks` varchar(25) NOT NULL DEFAULT 'Still not attempted',
  `project_marks` varchar(25) DEFAULT 'Still not attempted',
  `exam_marks` varchar(25) DEFAULT 'Still not attempted',
  `grade` char(1) DEFAULT NULL,
  `semester` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `std_practical_subjects`
--

INSERT INTO `std_practical_subjects` (`std_id`, `sub_code`, `lab_ass_marks`, `practical_demo_marks`, `project_marks`, `exam_marks`, `grade`, `semester`) VALUES
(18000003, 'EP002', 'Still not attempted', 'Still not attempted', 'Still not attempted', 'Still not attempted', NULL, '1st yr_1st sem'),
(18000003, 'IB001', 'Still not attempted', 'Still not attempted', 'Still not attempted', 'Still not attempted', NULL, '1st yr_1st sem'),
(18000006, 'IC001', '52', '60', '59', '80', 'B', '1st yr_1st sem'),
(18000006, 'PC001', '60', '56', '80', '65', 'C', '1st yr_1st sem');

-- --------------------------------------------------------

--
-- Table structure for table `std_theoretical_subjects`
--

CREATE TABLE `std_theoretical_subjects` (
  `std_id` int(8) NOT NULL,
  `sub_code` varchar(7) NOT NULL,
  `inclass_ass1_marks` varchar(25) DEFAULT 'Still not attempted',
  `inclass_ass2_marks` varchar(25) DEFAULT 'Still not attempted',
  `report_marks` varchar(25) DEFAULT 'Still not attempted',
  `exam_marks` varchar(25) DEFAULT 'Still not attempted',
  `grade` char(1) DEFAULT NULL,
  `semester` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `std_theoretical_subjects`
--

INSERT INTO `std_theoretical_subjects` (`std_id`, `sub_code`, `inclass_ass1_marks`, `inclass_ass2_marks`, `report_marks`, `exam_marks`, `grade`, `semester`) VALUES
(18000003, 'IC001', 'Still not attempted', 'Still not attempted', 'Still not attempted', 'Still not attempted', NULL, '1st yr_1st sem'),
(18000003, 'II001', 'Still not attempted', 'Still not attempted', 'Still not attempted', 'Still not attempted', NULL, '1st yr_1st sem'),
(18000006, 'IM001', '80', '58', '92', '70', 'B', '1st yr_1st sem'),
(18000006, 'PD001', '56', '90', '90', '95', 'A', '1st yr_1st sem');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `std_id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(60) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `nic` varchar(10) NOT NULL,
  `dob` date NOT NULL,
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

INSERT INTO `student` (`std_id`, `first_name`, `middle_name`, `last_name`, `nic`, `dob`, `connum`, `address`, `gender`, `intake`, `en_date`, `course_id`) VALUES
(18000000, 'Test', 'Test', 'Test', '000000000v', '2018-06-14', 0, 'Test test test', 'M', 'Test', '2018-06-14', 'CS002'),
(18000003, 'Sathya', 'Rangi', 'De Silva', '941235648V', '1994-04-21', 775894562, 'no:56,Galle road,Ambalangoda', 'F', 'July', '2018-08-16', 'CN002'),
(18000004, 'Pamoda', 'Shiranthi', 'Abewardana', '945666235V', '1994-10-14', 716995623, 'waligama,Matara', 'F', 'July', '2018-08-17', 'CN001'),
(18000005, 'Damiru', 'Shiran', 'Withanage', '935688452V', '1994-07-13', 775689997, 'no :33, malwatta road, colombo', 'M', 'February', '2018-08-17', 'CS003'),
(18000006, 'Harini', 'Madusha', 'Wellala', '945655896V', '1994-08-17', 122785548, 'Rathnapitiya Road,Rathnapura', 'F', 'July', '2018-08-22', 'BC001'),
(18000008, 'Shan', 'Anjana', 'Hewage', '956266352V', '1995-12-22', 775695521, 'Walgama road,Matara', 'M', 'July', '2018-08-22', 'MI001'),
(18000009, 'Janaki', 'H', 'Gamage', '945625889V', '1994-10-14', 715689561, 'Malwatta Road,Kandy', 'F', 'February', '2018-08-22', 'BM001'),
(18000011, 'Sachini', 'Thisara', 'Rathnasekara', '926345892v', '1992-08-11', 718965632, 'gall road matara', 'F', 'July', '2018-08-22', 'SE002'),
(18000012, 'kasuni', '', 'Yapa', '958623851V', '1992-07-01', 123654855, 'Kumarathunga Mawatha,Matara', 'F', 'February', '2018-08-22', 'ID001'),
(18000019, 'Yashoda', 'R', 'Wimukthi', '956237841v', '1993-08-03', 716594569, 'Ibulgoda,Gampaha', 'F', 'July', '2018-08-22', 'CM001'),
(18000020, 'Kalani ', 'Sachinthya', 'De silva', '945612362V', '1993-12-10', 112366592, 'jawaththa road colombo 8', 'F', 'February', '2018-08-22', 'BC001');

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
  `course_id` varchar(5) NOT NULL,
  `prac_or_theo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`sub_code`, `sub_name`, `fees`, `credits`, `yr_sem`, `course_id`, `prac_or_theo`) VALUES
('AT001', 'Autometa Theory I', 3500, 3, '1st yr_2nd sem', 'CN002', 0),
('EP001', 'English for Professional Purposes (I)', 2500, 3, '1st yr_1st sem', 'BC001', 1),
('EP002', 'English for Professional Purposes (II)', 2500, 3, '1st yr_2nd sem', 'BC001', 0),
('FC001', 'Fundamentals of Communication Studies', 3500, 3, '1st yr_2nd sem', 'BC001', 0),
('FP001', 'Final year project', 4000, 3, '3rd yr_2nd sem', 'BC001', 1),
('IB001', 'International Business', 4000, 3, '2nd yr_1st sem', 'BC001', 0),
('IB002', 'International Business II', 3000, 3, '4th yr_1st sem', 'BC001', 0),
('IC001', 'ICT for Communication', 2500, 2, '1st yr_1st sem', 'BC001', 1),
('II001', 'Intercultural & Interpersonal Communication', 3000, 2, '1st yr_2nd sem', 'BC001', 1),
('IM001', 'Introduction to Management', 3000, 2, '1st yr_1st sem', 'BC001', 0),
('IP000', 'Internship project', 4000, 3, '3rd yr_1st sem', 'BC001', 1),
('LB001', 'Laboratary I', 2000, 2, '1st yr_1st sem', 'CN002', 1),
('OS001', 'Operating Systems I', 4000, 3, '1st yr_1st sem', 'CS003', 0),
('P001', 'Programing I', 2500, 3, '1st yr_1st sem', 'CS001', 1),
('P002', 'Programming II', 2500, 3, '1st yr_2nd sem', 'CS001', 1),
('P003', 'Progrmming III', 3000, 3, '2nd yr_1st sem', 'CS001', 1),
('PC001', 'Professional Communication', 3500, 3, '1st yr_1st sem', 'BC001', 1),
('PD001', 'Personal Development\r\n', 3000, 2, '1st yr_1st sem', 'BC001', 0),
('R001', 'Research II', 3500, 3, '4th yr_2nd sem', 'BC001', 1),
('RM001', 'Research Methods for Communication Research', 4000, 3, '2nd yr_2nd sem', 'BC001', 0),
('VC001', 'Visual Communication', 3500, 2, '1st yr_2nd sem', 'BC001', 1),
('WB001', 'World of Business', 3500, 3, '1st yr_2nd sem', 'BC001', 0);

-- --------------------------------------------------------

--
-- Table structure for table `undergraduate`
--

CREATE TABLE `undergraduate` (
  `std_id` int(10) NOT NULL,
  `al_results` char(4) NOT NULL,
  `d_rank` int(8) NOT NULL,
  `i_rank` int(10) NOT NULL,
  `zscore` double NOT NULL,
  `course_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `undergraduate`
--

INSERT INTO `undergraduate` (`std_id`, `al_results`, `d_rank`, `i_rank`, `zscore`, `course_id`) VALUES
(18000000, 'AAC', 156, 456, 2.3654, 'CS002'),
(18000004, 'CBB', 456, 12364, 2.1236, 'CN001'),
(18000009, 'AAS', 2365, 25689, 1.2348, 'BM001'),
(18000012, 'CCB', 2563, 535155, 1.2987, 'ID001'),
(18000019, 'BBC', 6145, 48432, 0.2985, 'CM001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academic_staff`
--
ALTER TABLE `academic_staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`,`password`);

--
-- Indexes for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD PRIMARY KEY (`std_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD KEY `staff_id` (`staff_id`),
  ADD KEY `sub_code` (`sub_code`);

--
-- Indexes for table `staff_subjects`
--
ALTER TABLE `staff_subjects`
  ADD PRIMARY KEY (`staff_id`,`sub_code`),
  ADD KEY `sub_code` (`sub_code`);

--
-- Indexes for table `std_practical_subjects`
--
ALTER TABLE `std_practical_subjects`
  ADD PRIMARY KEY (`std_id`,`sub_code`),
  ADD KEY `sub_code` (`sub_code`);

--
-- Indexes for table `std_theoretical_subjects`
--
ALTER TABLE `std_theoretical_subjects`
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
  ADD PRIMARY KEY (`std_id`),
  ADD KEY `course_id` (`course_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `academic_staff`
--
ALTER TABLE `academic_staff`
  MODIFY `staff_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `postgraduate`
--
ALTER TABLE `postgraduate`
  MODIFY `std_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18000012;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `std_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18000021;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD CONSTRAINT `postgraduate_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `postgraduate_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `student` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sessions`
--
ALTER TABLE `sessions`
  ADD CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `academic_staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sessions_ibfk_2` FOREIGN KEY (`sub_code`) REFERENCES `subjects` (`sub_code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `staff_subjects`
--
ALTER TABLE `staff_subjects`
  ADD CONSTRAINT `staff_subjects_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `academic_staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `staff_subjects_ibfk_2` FOREIGN KEY (`sub_code`) REFERENCES `subjects` (`sub_code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `std_practical_subjects`
--
ALTER TABLE `std_practical_subjects`
  ADD CONSTRAINT `std_practical_subjects_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `std_practical_subjects_ibfk_2` FOREIGN KEY (`sub_code`) REFERENCES `subjects` (`sub_code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `std_theoretical_subjects`
--
ALTER TABLE `std_theoretical_subjects`
  ADD CONSTRAINT `std_theoretical_subjects_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `std_theoretical_subjects_ibfk_2` FOREIGN KEY (`sub_code`) REFERENCES `subjects` (`sub_code`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `undergraduate_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `undergraduate_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `student` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
