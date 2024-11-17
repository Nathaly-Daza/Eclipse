-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2024 a las 16:59:33
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coursesdata`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curses`
--

CREATE TABLE `curses` (
  `cou_id` int(11) NOT NULL,
  `cou_name` varchar(150) DEFAULT NULL,
  `cou_description` varchar(250) DEFAULT NULL,
  `cou_price` decimal(6,2) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `type_curses`
--

CREATE TABLE `type_curses` (
  `type_id` int(11) NOT NULL,
  `type_description` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curses`
--
ALTER TABLE `curses`
  ADD PRIMARY KEY (`cou_id`),
  ADD KEY `type_id` (`type_id`);

--
-- Indices de la tabla `type_curses`
--
ALTER TABLE `type_curses`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `curses`
--
ALTER TABLE `curses`
  MODIFY `cou_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `type_curses`
--
ALTER TABLE `type_curses`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curses`
--
ALTER TABLE `curses`
  ADD CONSTRAINT `curses_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type_curses` (`type_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
