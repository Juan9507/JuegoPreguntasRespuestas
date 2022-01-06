-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-01-2022 a las 21:48:12
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concurso_respuestas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre_categoria`) VALUES
(1, 'Historia'),
(2, 'Ciencia'),
(3, 'Entretenimiento'),
(4, 'Deportes'),
(5, 'Geografia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historico`
--

CREATE TABLE `historico` (
  `id_historico` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id_jugador` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `acumulado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id_jugador`, `nombre`, `apellido`, `correo`, `acumulado`) VALUES
(1, 'Juan', 'Rivera', 'prueba1@gmail.com', '20000000'),
(2, 'john', 'R', 'prueba2@gmail.com', '0'),
(3, 'prueba 3', 'p', 'prueba3@gmail.com', '0'),
(4, 'sara', 'gomez', 'sara@gmail.com', '20000000'),
(5, 'edward', 'z', 'sss@gmail.com', '0'),
(6, 'loro', 'perez', 'loro@gmail.com', '500000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivel`
--

CREATE TABLE `nivel` (
  `id_nivel` int(11) NOT NULL,
  `dificultad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nivel`
--

INSERT INTO `nivel` (`id_nivel`, `dificultad`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id_preguntas` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `img` varchar(20) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id_preguntas`, `nombre`, `img`, `id_categoria`, `id_nivel`) VALUES
(2, '¿Como se llama esta estructura?', 'piramide.png', 1, 1),
(3, '¿Cuál es la verdura usada en Halloween?', 'calabaza.png', 2, 1),
(4, '¿De qué película es, este famoso personaje?', 'dumbo.png', 3, 1),
(5, '¿Qué deporte se juega sin pelota?', 'sin.png', 4, 2),
(6, '¿Contra qué enfermedad es la primera vacuna que nos aplican?', 'sin.png', 2, 3),
(7, '¿Quién tenía el apodo de karate kid en el real Madrid?', 'sin.png', 4, 5),
(8, '¿Quién es Falcao?', 'sin.png', 4, 1),
(9, '¿Como se llaman los dos trópicos del mundo?', 'sin.png', 5, 5),
(10, '¿Cómo se le llama a este personaje?', 'marimonda.png', 3, 3),
(11, '¿En qué ciudad es muy común el \"cholado\"?', 'sin.png', 1, 2),
(12, '¿Cuál es el país con más paramos en el mundo?', 'sin.png', 5, 1),
(13, '¿Qué ventajas tiene la cordillera de los Andes para Colombia?', 'sin.png', 5, 3),
(14, '¿Qué deporte se practica con un caballo?', 'sin.png', 4, 3),
(15, '¿Cómo se llama el volcán de Ecuador?', 'sin.png', 5, 4),
(16, '¿Cómo se llama esta banda indie rock?', 'banda.png', 3, 4),
(17, '¿Quién fue la primera persona en observar la luna girar sobre nuestro planeta?', 'planeta.png', 2, 5),
(18, '¿Cuál de estos animales no es vivíparo?', 'sin.png', 2, 2),
(19, '¿Dónde queda ubicado el municipio de la Ceja?', 'sin.png', 5, 2),
(20, '¿Qué nombre recibe el estadio que se muestra en la imagen?', 'estadio.png', 4, 4),
(21, '¿Quién es él?', 'presidente.png', 1, 3),
(22, '¿Qué parentesco tienen estos tres hombres?', 'corea.png', 1, 5),
(23, '¿De qué película son estos personajes?', 'ratatouille.png', 3, 2),
(24, '¿Cuál es el nombre comercial para el Peróxido de Hidrógeno?', 'sin.png', 2, 4),
(26, '¿Quién fue en la antigüedad el mayor conquistador en la tierra y murió a los 33 años en la etapa helenística en Grecia?', 'sin.png', 1, 4),
(27, '¿Quién es ella ?', 'actriz.png', 3, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `id_respuestas` int(11) NOT NULL,
  `opcion` varchar(100) NOT NULL,
  `valor_booleano` tinyint(1) NOT NULL,
  `id_preguntas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`id_respuestas`, `opcion`, `valor_booleano`, `id_preguntas`) VALUES
(1, 'Cubo Rubix', 0, 2),
(2, 'Conos', 0, 2),
(3, 'Templos', 0, 2),
(4, 'pirámides', 1, 2),
(5, 'Lechuga', 0, 3),
(6, 'Zapallo', 0, 3),
(7, 'Calabaza', 1, 3),
(8, 'Brócoli', 0, 3),
(9, 'El elefante volador', 0, 4),
(10, 'Dumbo', 1, 4),
(11, 'Dumbito', 0, 4),
(12, 'Una aventura en el aire', 0, 4),
(13, 'Football', 0, 5),
(14, 'Federball', 1, 5),
(15, 'Basketball', 0, 5),
(16, 'Volleyball', 0, 5),
(17, 'Tuberculosis', 1, 6),
(18, 'Neumococo', 0, 6),
(19, 'Difteria', 0, 6),
(20, 'Inflienza', 0, 6),
(21, 'Zidane', 0, 7),
(22, 'Figo', 0, 7),
(23, 'Ronaldo', 0, 7),
(24, 'Steve Mac nanamam', 1, 7),
(25, 'Un jugador de fútbol', 1, 8),
(26, 'Un dentista', 0, 8),
(27, 'Un abogado', 0, 8),
(28, 'Un enfermero', 0, 8),
(32, 'Trópico de Cáncer y de Capricornio', 1, 9),
(33, 'Trópico de Cáncer y de Libra', 0, 9),
(34, 'Trópico de Piscis y Leo', 0, 9),
(35, 'Trópico de Piscis y Acuario', 0, 9),
(36, 'Monocuco', 0, 10),
(37, 'Torito', 0, 10),
(38, 'Marimonda', 1, 10),
(39, 'Joselito', 0, 10),
(40, 'Sincelejo', 0, 11),
(41, 'Bogotá', 0, 11),
(42, 'Cali', 1, 11),
(43, 'Armenia', 0, 11),
(44, 'Colombia', 1, 12),
(45, 'Rusia', 0, 12),
(46, 'Ecuador', 0, 12),
(47, 'Estados Unidos', 0, 12),
(48, 'Gran cantidad de fuentes hídricas', 0, 13),
(49, 'No Calefacción o Aire acondicionado', 0, 13),
(50, 'Todas las mencionadas', 1, 13),
(51, 'Variedad de Flora y Fauna', 0, 13),
(52, 'Levitación', 0, 14),
(53, 'Meditación', 0, 14),
(54, 'Equitación', 1, 14),
(55, 'Ninguna de las anteriores', 0, 14),
(56, 'Nevado ruis', 0, 15),
(57, 'Volcán Cotopaxi', 1, 15),
(58, 'Volcán tolimense', 0, 15),
(59, 'Volcán cotxi', 0, 15),
(60, 'The 1975', 0, 16),
(61, 'The Strokes', 0, 16),
(62, 'Arctic Monkeys', 1, 16),
(63, 'The Killers', 0, 16),
(64, 'William Gilbert', 0, 17),
(65, 'Sir Isaac Newton', 0, 17),
(66, 'Tycho Brahe', 0, 17),
(67, 'Galileo Galilei', 1, 17),
(68, 'Vaca', 0, 18),
(69, 'Pez', 1, 18),
(70, 'Caballo', 0, 18),
(71, 'Ciervo', 0, 18),
(72, 'Choco', 0, 19),
(73, 'Risaraldas', 0, 19),
(74, 'Antioquia', 1, 19),
(75, 'Cundinamarca', 0, 19),
(76, 'Atanasio Girardot', 0, 20),
(77, 'Estadio metropolitano Roberto Meléndez', 1, 20),
(78, 'Estadio Metropolitano de teccho', 0, 20),
(79, 'Estadio Romelio Martínez', 0, 20),
(80, 'Mike Pence', 0, 21),
(81, 'Joe Biden', 1, 21),
(82, 'Tim Kaine', 0, 21),
(83, 'Vladimir Putin', 0, 21),
(84, 'Suegro, muero y amigo', 0, 22),
(85, 'Familia', 0, 22),
(86, 'Padre e Hijos', 0, 22),
(87, 'Abuelo, Hijo y Nieto', 1, 22),
(88, 'The Chef and the Rat', 0, 23),
(89, 'Despereaux', 0, 23),
(90, 'Ratatouille', 1, 23),
(91, 'Chefcito', 0, 23),
(92, 'Agua lonizada', 0, 24),
(93, 'Agua Desinfectante', 0, 24),
(94, 'Agua Fiolizada', 0, 24),
(95, 'Agua Oxigenada', 1, 24),
(96, 'Alejandro Magno', 1, 26),
(97, 'Rómulo y Remo ', 0, 26),
(98, 'Agamenón ', 0, 26),
(99, 'Paris y Héctor', 0, 26),
(100, 'Rachel McAdams', 1, 27),
(101, 'Zendaya', 0, 27),
(102, 'Angelina Jolie', 0, 27),
(103, 'Jennifer Aninston', 0, 27);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`id_historico`),
  ADD KEY `id_jugador` (`id_jugador`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id_jugador`);

--
-- Indices de la tabla `nivel`
--
ALTER TABLE `nivel`
  ADD PRIMARY KEY (`id_nivel`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id_preguntas`),
  ADD KEY `id_nivel` (`id_nivel`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id_respuestas`),
  ADD KEY `id_preguntas` (`id_preguntas`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `historico`
--
ALTER TABLE `historico`
  MODIFY `id_historico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `nivel`
--
ALTER TABLE `nivel`
  MODIFY `id_nivel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id_preguntas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `id_respuestas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `historico_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id_jugador`);

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `preguntas_ibfk_2` FOREIGN KEY (`id_nivel`) REFERENCES `nivel` (`id_nivel`);

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`id_preguntas`) REFERENCES `preguntas` (`id_preguntas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
