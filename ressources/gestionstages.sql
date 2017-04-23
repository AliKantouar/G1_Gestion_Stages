-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 23 Avril 2017 à 22:23
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionstages`
--

-- --------------------------------------------------------

--
-- Structure de la table `entreprises`
--

CREATE TABLE `entreprises` (
  `NomEntreprise` varchar(30) NOT NULL,
  `Mdp` varchar(600) NOT NULL,
  `Adresse` varchar(60) NOT NULL,
  `Telephone` varchar(10) NOT NULL,
  `Commentaire` varchar(600) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offres`
--

CREATE TABLE `offres` (
  `NomEntreprise` varchar(30) NOT NULL,
  `Duree` int(3) NOT NULL,
  `Poste` varchar(30) NOT NULL,
  `Places` int(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `postulation`
--

CREATE TABLE `postulation` (
  `Identifiant` varchar(30) NOT NULL,
  `NomEntreprise` varchar(30) NOT NULL,
  `Poste` varchar(30) NOT NULL,
  `Duree` varchar(30) NOT NULL,
  `Etat` varchar(1) NOT NULL DEFAULT 'A'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Identifiant` varchar(30) NOT NULL,
  `Mdp` varchar(600) NOT NULL,
  `Telephone` varchar(10) NOT NULL,
  `Mail` varchar(30) NOT NULL,
  `Adresse` varchar(60) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Formation` varchar(600) NOT NULL,
  `Competences` varchar(600) NOT NULL,
  `Experience` varchar(600) NOT NULL,
  `Interets` varchar(600) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
