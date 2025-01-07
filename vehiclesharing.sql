-- CREATE DATABASE IF NOT EXISTS `vehiclesharing`;
-- GRANT ALL ON vehiclesharing.* 
-- TO 'app_java'@'localhost';
USE `vehiclesharing`;

CREATE TABLE IF NOT EXISTS `utente` (
`utente_id` int NOT NULL AUTO_INCREMENT,
`nome` varchar(75) DEFAULT NULL,
`cognome` varchar(75) DEFAULT NULL,
`data_nascita` date DEFAULT NULL,
`email` varchar(50) NOT NULL,
`password` varchar(20) NOT NULL,
`ruolo` enum('ADMIN','UTENTE') NOT NULL,
PRIMARY KEY (`utente_id`),
KEY `k_email` (`email`)
);
-- select all * from utente;
-- show create table utente;
-- truncate table utente;
INSERT INTO `utente`(nome,cognome,data_nascita,email,password,ruolo)
VALUES ('Carlo','Verdi','2001-03-19','utente@email.com','utente','UTENTE'),
('Paolo','Rossi','1994-06-07','admin@email.com','admin','ADMIN');

CREATE TABLE IF NOT EXISTS `veicolo`(
`veicolo_id` int NOT NULL AUTO_INCREMENT,
`categoria` varchar(75),
`descrizione` varchar(100) NOT NULL,
`alimentazione` varchar(20),
`indirizzo` varchar(100) NOT NULL,
`coordinate` varchar(50),
`disponibilita` tinyint,
-- `immagine` varchar(255) DEFAULT '',
`immagine` longblob,
PRIMARY KEY (`veicolo_id`)
);
-- drop table veicolo;
-- show create table veicolo;
-- truncate table veicolo;
 select * from veicolo;
INSERT INTO `veicolo`(categoria,descrizione,alimentazione,indirizzo,coordinate,disponibilita,immagine)
VALUES ('auto','Ferrari Enzo','benzina','Via Torino 80, Airasca, TO','44.9234386,7.5113506', TRUE, LOAD_FILE('/static/img/MrBean.jpg')),
('motociclo','Kawasaki Z900','diesel','Corso Unione Sovietica 34, Torino','45.0133568,7.6164037',FALSE, LOAD_FILE('/static/img/MrBean.jpg')),
('bicicletta','HAIBIKE ALLTRAIL','elettrica','Via Pietro Ferrero, Torino','45.05526657026985,7.616357395711968',TRUE,LOAD_FILE('/static/img/MrBean.jpg')),
('furgone','Fiat Fiorino','metano','Via Cesare Battisti 2B, San Mauro Torinese TO','45.1003189,7.7642173',FALSE,LOAD_FILE('/static/img/MrBean.jpg'));

-- fino a qui

create table if not exists `prenotazioni` (
`id` int not null auto_increment,
`utente_id` int not null,
`veicolo_id` int not null,
`data_inizio` datetime,
`data_fine` datetime,
`stato_prenotazione` varchar(20),
`modifiche` varchar(50),
PRIMARY KEY (`id`),
foreign key (utente_id) references utente(utente_id),
foreign key (veicolo_id) references veicolo(veicolo_id)
);
-- truncate table prenotazioni;
 drop table prenotazioni;
-- desc prenotazioni;
 select * from prenotazioni;

-- - ATTENZIONE - lascio un memo per tutti: valutare di gestire le coordinate con POINT invece che con un varchar




