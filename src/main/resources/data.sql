INSERT INTO category VALUES(null, "Football", 1);

INSERT INTO place VALUES(null, null, "France", null);
INSERT INTO place VALUES(null, "Paris", "France", "Stade de France");
INSERT INTO place VALUES(null, "Rennes", "France", "Roazhon Park");

INSERT INTO competition VALUES(null, "Ligue 1", 1, 2, 1);
INSERT INTO competition VALUES(null, "Coupe de France", 1, 1, 1);

INSERT INTO category_competitions VALUES(1, 1);
INSERT INTO category_competitions VALUES(1, 2);

INSERT INTO season VALUES(null, "2019-07-15", "2018-08-15", 1, 1);

INSERT INTO matchday values(null, "1e journée", 1);
INSERT INTO matchday values(null, "2e journée", 1);
INSERT INTO matchday values(null, "3e journée", 1);

INSERT INTO match_vs VALUES(null, "2018-08-18", 5, 1, 2);
INSERT INTO match_vs VALUES(null, "2018-09-01", 3, 3, 3);

INSERT INTO team VALUES(null, null, "Paris Saint-Germain", 1, 1);
INSERT INTO team VALUES(null, null, "Stade Rennais", 1, 1);
INSERT INTO team VALUES(null, null, "Angers SCO", 1, 1);
INSERT INTO team VALUES(null, null, "AS Monaco", 1, 1);

INSERT INTO matchteam VALUES(null, true, 1, 1);
INSERT INTO matchteam VALUES(null, true, 2, 2);
INSERT INTO matchteam VALUES(null, false, 2, 3);
INSERT INTO matchteam VALUES(null, false, 1, 4);

INSERT INTO security_role VALUES(null, "USER");
INSERT INTO security_role VALUES(null, "ADMIN");

INSERT INTO users_securityroles VALUES
(1, 1),
(2, 2);

INSERT INTO user values(null, null, null, 0, null, "4orRGnsLmA4y8OrvqlXUmA==", "user", "1994-08-03", "Colin", "Richard", "colin.richard@email.com",  5.30);
INSERT INTO user values(null, "twLWrdvhw3R4y602kYsgpzVCoil+c9i7qLSTEsuRKLE=", "gU+SjWX1vAOVgaVfmxMxoQ==", 0, "fxvz4XCfbMGgYVrbBhp60w==", "4orRGnsLmA4y8OrvqlXUmA==", "admin", "1994-08-03", "Colin", "Richard", "colin.richard@email.com",  5.30);

INSERT INTO bettype VALUES
(1, 1.5, 1.65, 'Paris Saint Germain', 1, 1),
(2, 2.25, 2.5, 'Nul', 1, 1),
(3, 3.2, 3.25, 'Monaco', 1, 1),
(4, 2, 2, '1-0', 1, 2),
(5, 5, 5, '0-1', 1, 2),
(6, 3.5, 3.5, '0-0', 1, 2),
(7, 2, 2, '2-0', 1, 2),
(8, 5, 5, '1-2', 1, 2),
(9, 3.5, 3.5, '1-1', 1, 2),
(10, 1.2, 1.2, 'plus de 0.5 buts', 1, 3),
(11, 5, 5, 'Moins de 0.5 buts', 1, 3),
(12, 2.5, 2.5, 'Plus de 1.5 buts', 1, 3),
(13, 2.5, 2.5,'Moins de 1.5 buts', 1, 3),
(14, 5, 5,'Plus de 2.5 buts', 1, 3),
(15, 1.2, 1.2,'Moins de 2.5 buts', 1, 3),

(null, 1.5, 1.65, 'Stade Rennais', 1, 1),
(null, 2.25, 2.5, 'Nul', 1, 1),
(null, 1.5, 1.65, 'Angers SCO', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, 'plus de 0.5 buts', 1, 3),
(null, 5, 5, 'Moins de 0.5 buts', 1, 3),
(null, 2.5, 2.5, 'Plus de 1.5 buts', 1, 3),
(null, 2.5, 2.5,'Moins de 1.5 buts', 1, 3),
(null, 5, 5,'Plus de 2.5 buts', 1, 3),
(null, 1.2, 1.2,'Moins de 2.5 buts', 1, 3);

INSERT INTO matchbet VALUES
(1, 1, 1),
(2, 1, null),
(3, 1, 4),
(4, 1, null),
(5, 1, null),
(6, 1, null),
(7, 1, null),
(8, 1, null),
(9, 1, null),
(10, 1, null),
(11, 1, null),
(12, 1, null),
(13, 1, null),
(14, 1, null),
(15, 1, null),

(16, 2, 2),
(17, 2, null),
(18, 2, 3),
(19, 2, null),
(20, 2, null),
(21, 2, null),
(22, 2, null),
(23, 2, null),
(24, 2, null),
(25, 2, null),
(26, 2, null),
(27, 2, null),
(28, 2, null),
(29, 2, null),
(30, 2, null);

INSERT INTO bet VALUES
(null, 10, "2018-08-12", 3.14, 1, 2),
(null, 15, "2018-08-14", 2.1, 1, 2),
(null, 5, "2018-09-05", 5.5, 1, 1);

INSERT INTO betline VALUES
(null, 1, 1, 3),
(null, 1, 2, 14),
(null, 1, 3, 16),
(null, 1, 3, 19);

INSERT INTO player VALUES
(null, "1955-08-01", "Julien", "Lepers", 1, 1),
(null, "1960-08-01", "Nicolas", "Sarkozy", 1, 1);

INSERT INTO event VALUES
(null, 1, 44, 1, 1, 1);

INSERT INTO matchplayer VALUES
(null, 1, 72, 1, 1),
(null, 1, null, 1, 2);

INSERT INTO period VALUES
(null, null, "2018-01-01", 1, 1),
(null, "2005-12-18", "1998-08-15", 2, 1),
(null, null, "2006-01-01", 2, 2);

