-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 25 Septembre 2017 à 17:24
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `portmatane`
--

-- --------------------------------------------------------

--
-- Structure de la table `armateur`
--

CREATE TABLE `armateur` (
  `idArmateur` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `armateur`
--

INSERT INTO `armateur` (`idArmateur`, `nom`) VALUES
(1, 'Boluda France'),
(2, 'Bourbon'),
(3, 'Comex'),
(4, 'CMA CGM'),
(5, 'Compagnie du Ponant'),
(6, 'Genavir'),
(7, 'Les Abeilles'),
(8, 'Marfret'),
(9, 'Orange Marine'),
(10, 'Socatra');

-- --------------------------------------------------------

--
-- Structure de la table `bateau`
--

CREATE TABLE `bateau` (
  `idBateau` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `marque` varchar(50) NOT NULL,
  `modele` varchar(50) NOT NULL,
  `annee` date NOT NULL,
  `longueur` int(11) NOT NULL,
  `largeur` int(11) NOT NULL,
  `hauteur` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `bouee`
--

CREATE TABLE `bouee` (
  `idBouee` int(11) NOT NULL,
  `latitude` int(11) NOT NULL,
  `longitude` int(11) NOT NULL,
  `temperatureEau` int(11) NOT NULL,
  `temperatureAir` int(11) NOT NULL,
  `salinite` float NOT NULL,
  `vitesseVent` float NOT NULL,
  `dimension` int(11) NOT NULL,
  `pressionAtmosherique` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `declaration`
--

CREATE TABLE `declaration` (
  `idDeclaration` int(11) NOT NULL,
  `nomBateau` varchar(50) DEFAULT NULL,
  `nomMarchandise` varchar(50) DEFAULT NULL,
  `descriptionMarchandise` varchar(50) DEFAULT NULL,
  `typeMarchandise` varchar(50) DEFAULT NULL,
  `paysOrigineMatierePremiere` varchar(50) DEFAULT NULL,
  `paysOrigineAssemblage` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `declaration`
--

INSERT INTO `declaration` (`idDeclaration`, `nomBateau`, `nomMarchandise`, `descriptionMarchandise`, `typeMarchandise`, `paysOrigineMatierePremiere`, `paysOrigineAssemblage`) VALUES
(1, 'Test', 'Matiere Test', 'Ceci est un test', 'Dure', 'Zimbabwe', 'Argentine');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `armateur`
--
ALTER TABLE `armateur`
  ADD PRIMARY KEY (`idArmateur`);

--
-- Index pour la table `bateau`
--
ALTER TABLE `bateau`
  ADD PRIMARY KEY (`idBateau`);

--
-- Index pour la table `bouee`
--
ALTER TABLE `bouee`
  ADD PRIMARY KEY (`idBouee`);

--
-- Index pour la table `declaration`
--
ALTER TABLE `declaration`
  ADD PRIMARY KEY (`idDeclaration`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `armateur`
--
ALTER TABLE `armateur`
  MODIFY `idArmateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `bateau`
--
ALTER TABLE `bateau`
  MODIFY `idBateau` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `bouee`
--
ALTER TABLE `bouee`
  MODIFY `idBouee` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `declaration`
--
ALTER TABLE `declaration`
  MODIFY `idDeclaration` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
