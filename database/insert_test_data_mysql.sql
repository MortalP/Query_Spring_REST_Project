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
    
INSERT INTO Admin (kayttajatunnus, salasana)
VALUES 
    ("devaaja", "salainen");
    
