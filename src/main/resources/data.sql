INSERT INTO category VALUES(null, "Football", 1);

INSERT INTO place(city, country, stadium) VALUES
(null, "France", null),
("Paris", "France", "Stade de France"),
("Rennes", "France", "Roazhon Park");


INSERT INTO competition VALUES(null, "Ligue 1", 1, 2, 1);
INSERT INTO competition VALUES(null, "Coupe de France", 1, 1, 1);

INSERT INTO category_competitions VALUES(1, 1);
INSERT INTO category_competitions VALUES(1, 2);

INSERT INTO season VALUES(null, "2019-07-15", "2018-08-15", 1, 1);
INSERT INTO season VALUES(null, "2019-07-15", "2018-08-15", 1, 2);

INSERT INTO matchday values(null, "1e journée", 1);
INSERT INTO matchday values(null, "2e journée", 1);
INSERT INTO matchday values(null, "3e journée", 1);
INSERT INTO matchday values(null, "4e journée", 1);
INSERT INTO matchday values(null, "5e journée", 1);
INSERT INTO matchday values(null, "5e tour", 2);

INSERT INTO match_vs
(date, status, matchday_id, place_id) VALUES
("2018-08-18", 5, 1, 1),
("2018-09-26", 3, 4, 1),
("2018-09-26", 3, 4, 1),
("2018-09-28", 3, 5, 1),
("2018-09-28", 3, 5, 1), -- 5
("2018-09-29", 3, 5, 1),
("2018-09-29", 3, 5, 1),
("2018-09-30", 3, 5, 1),
("2018-09-30", 3, 5, 1),
("2018-09-30", 3, 5, 1), --10
("2018-09-30", 3, 6, 1),
("2018-10-01", 3, 6, 1),
("2018-10-01", 3, 6, 1);

INSERT INTO team(creationdate, label, status, place_id) VALUES
(null, "Paris SG", 1, 1),
(null, "Rennes", 1, 1),
(null, "Angers", 1, 1),
(null, "Monaco", 1, 1),
(null, "Nice", 1, 1), --5
(null, "Marseille", 1, 1),
(null, "Lyon", 1, 1),
(null, "Nantes", 1, 1),
(null, "Saint-Etienne", 1, 1),
(null, "Strasbourg", 1, 1), --10
(null, "Dijon", 1, 1), 
(null, "Caen", 1, 1),
(null, "Amiens", 1, 1),
(null, "Guingamp", 1, 1),
(null, "Reims", 1, 1), --15
(null, "Bordeaux", 1, 1), 
(null, "Toulouse", 1, 1),
(null, "Montpellier", 1, 1),
(null, "Nîmes", 1, 1),
(null, "Lille", 1, 1), --20
(null, "Nancy", 1, 1), 
(null, "Metz", 1, 1),
(null, "Le Mans", 1, 1),
(null, "Laval", 1, 1), 
(null, "Sochaux", 1, 1), --25
(null, "Lorient", 1, 1);

INSERT INTO matchteam(ishometeam, match_id, team_id) VALUES
(1, 1, 1),
(1, 2, 2),
(0, 2, 3),
(0, 1, 4),
(0, 3, 5),
(1, 3, 6),
(1, 4, 7),
(0, 4, 8),
(0, 5, 9),
(1, 5, 10),
(1, 6, 11),
(0, 6, 12),
(1, 7, 13),
(0, 7, 14),
(1, 8, 15),
(0, 8, 16),
(1, 9, 17),
(0, 9, 18),
(1, 10, 19),
(0, 10, 20),
(1, 11, 21),
(0, 11, 22),
(1, 12, 23),
(0, 12, 24),
(1, 13, 25),
(0, 13, 26);

INSERT INTO security_role VALUES(null, "USER");
INSERT INTO security_role VALUES(null, "ADMIN");

INSERT INTO users_securityroles VALUES
(1, 1),
(2, 2);

INSERT INTO user values(null, null, null, 0, null, "4orRGnsLmA4y8OrvqlXUmA==", "user", "1994-08-03", "Colin", "Richard", "colin.richard@email.com",  5.30);
INSERT INTO user values(null, "twLWrdvhw3R4y602kYsgpzVCoil+c9i7qLSTEsuRKLE=", "gU+SjWX1vAOVgaVfmxMxoQ==", 0, "fxvz4XCfbMGgYVrbBhp60w==", "4orRGnsLmA4y8OrvqlXUmA==", "admin", "1994-08-03", "Colin", "Richard", "colin.richard@email.com",  5.30);

INSERT INTO bettype VALUES
-- 1
(null, 1.5, 1.65, 'Paris SG', 1, 1),
(null, 2.25, 2.5, 'Nul', 1, 1),
(null, 3.2, 3.25, 'Monaco', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 2
(null, 1.5, 1.65, 'Rennes', 1, 1),
(null, 2.25, 2.5, 'Nul', 1, 1),
(null, 2, 2, 'Angers', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 3
(null, 1.2, 1.65, 'Marseille', 1, 1),
(null, 2.5, 2.5, 'Nul', 1, 1),
(null, 3.5, 1.65, 'Nice', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 4
(null, 1.5, 1.65, 'Lyon', 1, 1),
(null, 2, 2.5, 'Nul', 1, 1),
(null, 2.8, 1.65, 'Nantes', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 5
(null, 2.8, 1.65, 'Saint-Etienne', 1, 1),
(null, 2.2, 2.5, 'Nul', 1, 1),
(null, 1.5, 1.65, 'Strasbourg', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 6
(null, 1.4, 1.65, 'Dijon', 1, 1),
(null, 2, 2.5, 'Nul', 1, 1),
(null, 2.8, 1.65, 'Caen', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 7
(null, 2, 1.65, 'Amiens', 1, 1),
(null, 2.2, 2.5, 'Nul', 1, 1),
(null, 2.4, 1.65, 'Guingamp', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 8
(null, 2.84, 1.65, 'Reims', 1, 1),
(null, 2.5, 2.5, 'Nul', 1, 1),
(null, 1.35, 1.65, 'Bordeaux', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 9
(null, 2.21, 1.65, 'Toulouse', 1, 1),
(null, 2.00, 2.5, 'Nul', 1, 1),
(null, 2.15, 1.65, 'Montpellier', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 10
(null, 4.2, 1.65, 'Nîmes', 1, 1),
(null, 3.2, 2.5, 'Nul', 1, 1),
(null, 1.12, 1.65, 'Lille', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 11
(null, 1.5, 1.65, 'Nancy', 1, 1),
(null, 2.5, 2.5, 'Nul', 1, 1),
(null, 2.8, 1.65, 'Metz', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 12
(null, 1.35, 1.65, 'Le Mans', 1, 1),
(null, 2.05, 2.5, 'Nul', 1, 1),
(null, 2.84, 1.65, 'Laval', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3),

-- 13
(null, 3.2, 1.65, 'Sochaux', 1, 1),
(null, 3.05, 2.5, 'Nul', 1, 1),
(null, 1.34, 1.65, 'Lorient', 1, 1),
(null, 2, 2, '1-0', 1, 2),
(null, 5, 5, '0-1', 1, 2),
(null, 3.5, 3.5, '0-0', 1, 2),
(null, 2, 2, '2-0', 1, 2),
(null, 5, 5, '1-2', 1, 2),
(null, 3.5, 3.5, '1-1', 1, 2),
(null, 1.2, 1.2, '+0.5', 1, 3),
(null, 5, 5, '-0.5', 1, 3),
(null, 2.5, 2.5, '+1.5', 1, 3),
(null, 2.5, 2.5,'-1.5', 1, 3),
(null, 5, 5,'+2.5', 1, 3),
(null, 1.2, 1.2,'-2.5', 1, 3);

INSERT INTO matchbet VALUES
-- 1
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

-- 2
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
(30, 2, null),

-- 3
(31, 3, 6),
(32, 3, null),
(33, 3, 5),
(34, 3, null),
(35, 3, null),
(36, 3, null),
(37, 3, null),
(38, 3, null),
(39, 3, null),
(40, 3, null),
(41, 3, null),
(42, 3, null),
(43, 3, null),
(44, 3, null),
(45, 3, null),

-- 4
(46, 4, 7),
(47, 4, null),
(48, 4, 8),
(49, 4, null),
(50, 4, null),
(51, 4, null),
(52, 4, null),
(53, 4, null),
(54, 4, null),
(55, 4, null),
(56, 4, null),
(57, 4, null),
(58, 4, null),
(59, 4, null),
(60, 4, null),

-- 5
(61, 5, 9),
(62, 5, null),
(63, 5, 10),
(64, 5, null),
(65, 5, null),
(66, 5, null),
(67, 5, null),
(68, 5, null),
(69, 5, null),
(70, 5, null),
(71, 5, null),
(72, 5, null),
(73, 5, null),
(74, 5, null),
(75, 5, null),

-- 6
(76, 6, 11),
(77, 6, null),
(78, 6, 12),
(79, 6, null),
(80, 6, null),
(81, 6, null),
(82, 6, null),
(83, 6, null),
(84, 6, null),
(85, 6, null),
(86, 6, null),
(87, 6, null),
(88, 6, null),
(89, 6, null),
(90, 6, null),

-- 7
(91, 7, 13),
(92, 7, null),
(93, 7, 14),
(94, 7, null),
(95, 7, null),
(96, 7, null),
(97, 7, null),
(98, 7, null),
(99, 7, null),
(100, 7, null),
(101, 7, null),
(102, 7, null),
(103, 7, null),
(104, 7, null),
(105, 7, null),

-- 8
(106, 8, 15),
(107, 8, null),
(108, 8, 16),
(109, 8, null),
(110, 8, null),
(111, 8, null),
(112, 8, null),
(113, 8, null),
(114, 8, null),
(115, 8, null),
(116, 8, null),
(117, 8, null),
(118, 8, null),
(119, 8, null),
(120, 8, null),

-- 9
(121, 9, 17),
(122, 9, null),
(123, 9, 18),
(124, 9, null),
(125, 9, null),
(126, 9, null),
(127, 9, null),
(128, 9, null),
(129, 9, null),
(130, 9, null),
(131, 9, null),
(132, 9, null),
(133, 9, null),
(134, 9, null),
(135, 9, null),

-- 10
(136, 10, 19),
(137, 10, null),
(138, 10, 20),
(139, 10, null),
(140, 10, null),
(141, 10, null),
(142, 10, null),
(143, 10, null),
(144, 10, null),
(145, 10, null),
(146, 10, null),
(147, 10, null),
(148, 10, null),
(149, 10, null),
(150, 10, null),

-- 11
(151, 11, 21),
(152, 11, null),
(153, 11, 22),
(154, 11, null),
(155, 11, null),
(156, 11, null),
(157, 11, null),
(158, 11, null),
(159, 11, null),
(160, 11, null),
(161, 11, null),
(162, 11, null),
(163, 11, null),
(164, 11, null),
(165, 11, null),

-- 12
(166, 12, 23),
(167, 12, null),
(168, 12, 24),
(169, 12, null),
(170, 12, null),
(171, 12, null),
(172, 12, null),
(173, 12, null),
(174, 12, null),
(175, 12, null),
(176, 12, null),
(177, 12, null),
(178, 12, null),
(179, 12, null),
(180, 12, null),

-- 13
(181, 13, 25),
(182, 13, null),
(183, 13, 26),
(184, 13, null),
(185, 13, null),
(186, 13, null),
(187, 13, null),
(188, 13, null),
(189, 13, null),
(190, 13, null),
(191, 13, null),
(192, 13, null),
(193, 13, null),
(194, 13, null),
(195, 13, null);

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