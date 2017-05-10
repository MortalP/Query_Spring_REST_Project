INSERT INTO Kysely(nimi)
VALUES ("Mielipidekysely");

INSERT INTO Kysymys (kysymys, tyyppi, description,kysely_id)
VALUES 
    ("Missä on jatkot?", "Teksti", "Testitestitesti", 1 ),
    ("Miten menee?", "Teksti", "Kerrontaa", 1),
    ("Maistuisiko olut?", "Monivalinta", "Pilipalijuttuu", 1);
    
INSERT INTO Vastaus (vastaus, kysymys_id)
VALUES 
    ("Hyvin menee", 2),
    ("Kyllä, kunhan ei ole Koff", 3);
    
    
    
INSERT INTO webuser2
VALUES 
    (1, 'Admin', '635fb41d21af00dc4a9ef7401b729c30f33b67261e3189346dd2507eb2e2d124b42a85852133c859', 1);
    
INSERT INTO
	authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');
	
	INSERT INTO
	webuser2_authority
VALUES
	(1,1,2);
