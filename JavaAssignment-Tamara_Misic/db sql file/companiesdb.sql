-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2023 at 08:40 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `companiesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL,
  `name` varchar(24) NOT NULL,
  `adress` varchar(64) NOT NULL,
  `city` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`company_id`, `name`, `adress`, `city`) VALUES
(1, 'Prime', 'Adresa 1', 'Nis'),
(2, 'Webelinx', 'Adresa 2', 'Beograd');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `employee_type_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `full_name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `phone_number` varchar(64) NOT NULL,
  `date_of_birth` date NOT NULL,
  `monthly_salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_type_id`, `company_id`, `full_name`, `email`, `phone_number`, `date_of_birth`, `monthly_salary`) VALUES
(1, 1, 1, 'Tamara Misic', 'tamara@gmail.com', '0656280456', '2023-03-21', 400),
(2, 1, 1, 'Tamara Stojanovic', 'tamaras@gmail.com', '0625796215', '2023-03-24', 500),
(3, 1, 1, 'Lana Kostic', 'lana@gmail.com', '061245789', '2023-03-16', 200),
(4, 1, 2, 'Uros Milovanovic', 'uros@gmail.com', '065784539', '2023-03-25', 900),
(5, 2, 1, 'Tamara Milovanovic', 'tamaram@gmail.com', '065781696', '2023-03-21', 500),
(6, 2, 1, 'Sanja Djikic', 'sanja@gmail.com', '065356892', '2023-03-11', 700),
(7, 1, 1, 'Aleksa Cekic', 'aleksa@gmail.com', '063578516', '2023-03-08', 500);

-- --------------------------------------------------------

--
-- Table structure for table `employee_type`
--

CREATE TABLE `employee_type` (
  `employee_type_id` int(11) NOT NULL,
  `type_name` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_type`
--

INSERT INTO `employee_type` (`employee_type_id`, `type_name`) VALUES
(1, 'developer'),
(2, 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `meeting`
--

CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `duration` int(11) NOT NULL,
  `description` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `meeting`
--

INSERT INTO `meeting` (`meeting_id`, `date`, `duration`, `description`) VALUES
(1, '2023-03-08', 30, 'opis'),
(2, '2023-03-05', 45, 'opis'),
(3, '2023-03-31', 10, 'opis');

-- --------------------------------------------------------

--
-- Table structure for table `meeting_employee`
--

CREATE TABLE `meeting_employee` (
  `meeting_employee_id` int(11) NOT NULL,
  `meeting_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `meeting_employee`
--

INSERT INTO `meeting_employee` (`meeting_employee_id`, `meeting_id`, `employee_id`) VALUES
(1, 1, 7),
(2, 1, 3),
(3, 1, 6),
(4, 1, 5),
(5, 1, 1),
(6, 2, 4),
(7, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `task_id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `description` varchar(256) NOT NULL,
  `assignee` int(11) NOT NULL,
  `due_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`task_id`, `title`, `description`, `assignee`, `due_date`) VALUES
(1, 'Task1', 'opis', 7, '2023-02-01'),
(2, 'Task2', 'opis', 7, '2023-02-02'),
(3, 'Task3', 'opis', 7, '2023-02-01'),
(4, 'Task4', 'opis', 7, '2023-02-17'),
(5, 'Task5', 'opis', 7, '2023-02-16'),
(6, 'Task6', 'opis', 7, '2023-02-10'),
(7, 'Task7', 'opis', 3, '2023-02-08'),
(8, 'Task8', 'opis', 3, '2023-02-18'),
(9, 'Task9', 'opis', 3, '2023-02-09'),
(10, 'Task10', 'opis', 3, '2023-02-18'),
(11, 'Task11', 'opis', 3, '2023-02-09'),
(12, 'Task12', 'opis', 6, '2023-02-01'),
(13, 'Task13', 'opis', 6, '2023-02-10'),
(14, 'Task14', 'opis', 6, '2023-02-09'),
(15, 'Task15', 'opis', 6, '2023-02-10'),
(16, 'Task16', 'opis', 5, '2023-02-10'),
(17, 'Task17', 'opis', 5, '2023-02-18'),
(18, 'Task18', 'opis', 5, '2023-02-17'),
(19, 'Task19', 'opis', 1, '2023-02-10'),
(20, 'Task20', 'opis', 1, '2023-02-09'),
(21, 'Task21', 'opis', 2, '2023-03-10'),
(22, 'Task22', 'opis', 4, '2023-03-10'),
(23, 'Task23', 'opis', 2, '2023-03-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `employee_type_id` (`employee_type_id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `employee_type`
--
ALTER TABLE `employee_type`
  ADD PRIMARY KEY (`employee_type_id`);

--
-- Indexes for table `meeting`
--
ALTER TABLE `meeting`
  ADD PRIMARY KEY (`meeting_id`);

--
-- Indexes for table `meeting_employee`
--
ALTER TABLE `meeting_employee`
  ADD PRIMARY KEY (`meeting_employee_id`),
  ADD KEY `meeting_id` (`meeting_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`task_id`),
  ADD KEY `assignee_id` (`assignee`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employee_type`
--
ALTER TABLE `employee_type`
  MODIFY `employee_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `meeting`
--
ALTER TABLE `meeting`
  MODIFY `meeting_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `meeting_employee`
--
ALTER TABLE `meeting_employee`
  MODIFY `meeting_employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `task_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `employee_type_id` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`employee_type_id`);

--
-- Constraints for table `meeting_employee`
--
ALTER TABLE `meeting_employee`
  ADD CONSTRAINT `employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `meeting_id` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`meeting_id`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `assignee_id` FOREIGN KEY (`assignee`) REFERENCES `employee` (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
