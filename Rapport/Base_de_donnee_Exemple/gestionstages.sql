-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 24 Avril 2017 à 19:31
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
  `Telephone` varchar(30) NOT NULL,
  `Commentaire` varchar(600) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entreprises`
--

INSERT INTO `entreprises` (`NomEntreprise`, `Mdp`, `Adresse`, `Telephone`, `Commentaire`) VALUES
('Ikea', 'c9e9da56866520e81000ca2db176530e', '1 Rue du Clos aux Pois, 91020 Lisses', '0145786545', ''),
('Google', '778bf5ca74864583b419dcf1bbea091b', 'Partout', '0108080808', 'Petite multinationale peu connue');

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

--
-- Contenu de la table `offres`
--

INSERT INTO `offres` (`NomEntreprise`, `Duree`, `Poste`, `Places`) VALUES
('Google', 6, 'Webmaster', 1),
('Ikea', 4, 'Webmaster', 1),
('Ikea', 6, 'Vendeur', 3);

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

--
-- Contenu de la table `postulation`
--

INSERT INTO `postulation` (`Identifiant`, `NomEntreprise`, `Poste`, `Duree`, `Etat`) VALUES
('Bruno', 'Ikea', 'Vendeur', '6', 'A'),
('Soso', 'Google', 'Webmaster', '6', 'A'),
('Soso', 'Ikea', 'Webmaster', '4', 'A'),
('Soso', 'Ikea', 'Vendeur', '6', 'A'),
('Soso77', 'Google', 'Webmaster', '6', 'T'),
('Soso77', 'Ikea', 'Webmaster', '4', 'A');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Identifiant` varchar(30) NOT NULL,
  `Mdp` varchar(600) NOT NULL,
  `Telephone` varchar(30) NOT NULL,
  `Mail` varchar(30) NOT NULL,
  `Adresse` varchar(60) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Formation` varchar(600) NOT NULL,
  `Competences` varchar(600) NOT NULL,
  `Experience` varchar(600) NOT NULL,
  `Interets` varchar(600) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Identifiant`, `Mdp`, `Telephone`, `Mail`, `Adresse`, `Nom`, `Prenom`, `Formation`, `Competences`, `Experience`, `Interets`) VALUES
('Soso', '6351bf9dce654515bf1ddbd6426dfa97', '0645796285', 'soso.dubois@gmail.com', '45 rue Marie-Currie, Versaille', 'Dubois', 'Sophie', 'Brevet des colleges\nBac ES\nLicence de managment\nBTS informatique', '-Extraverti\n-Dirigeante\n-Debrouillarde\n-Negociatrice\n-Bureautique\n-HTML, CSS', '2014-caisière chez Flunch: Mon premier emploi\n2015-Stagiaire informatique chez Carrefour: J\'y ai fais du web\n', '-Natation\n-Course à pied\n-Art contemporain'),
('Bruno', 'ab4f63f9ac65152575886860dde480a1', '0645874741', 'burno.durand@hotmail.fr', '71 rue de jonville, St-Fargeau Ponthierry', 'Bruno', 'Durand', 'Bravet des colleges\nCAP menuiserie', '-Bricoler\n-Decouper\n-Sculter\n-Leadership', '2015-Mcdo: premier pas dans le monde du travail', '-Je fais du tennis de table\n-J\'aime bricoler des choses en bois et en metal'),
('Soso77', 'a9c4cef5735770e657b7c25b9dcb807b', '0645789635', 'sosodu77@hotmail.fr', '85 rue boucher, Melun', 'Sofia', 'Machroux', 'Bac S\nLicence d\'informatique\n(actuellement en Master 1er année)', '-HTML, CSS\n-Java\n-C, C#, C++', '2016-Stagiaire chez Ubisoft: J\'ai fais une page de leur site web', '-jeux video\n-arts du cinema'),
('MisterPirate', '96d5e6eea948e9d955597b628e32eff', '0647859654', 'misterpirate@gmail.com', '69 rue du poisson, Brest', 'Céparou', 'Jack', 'Bac S\nBTS Informatique\nMaster Miage', '-Html, CSS, javascript\n-Gestion\n-Java, C++, Python', '2015-Caissier à Truffaut\n2016-Stage de Webmaster chez google', '-jeux video\n-escalade');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
