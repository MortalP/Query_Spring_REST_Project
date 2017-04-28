create table Kysely(
	id int auto_increment not null,
	nimi varchar(100),
	primary key (id));

create table Kysymys(
    id int auto_increment not null,
    kysymys varchar(300) not null,
    tyyppi varchar(50),
    description varchar (500),
    kysely_id int,
    primary key (id),
    foreign key (kysely_id) REFERENCES Kysely(id));

create table Vastaus(
    id int auto_increment not null,
    vastaus varchar(300) not null,
    kysymys_id int,
    primary key (id),
    foreign key (kysymys_id) REFERENCES Kysymys(id));
    
create table Admin(
    kayttajatunnus varchar(50) not null,
    salasana varchar(300) not null,
    primary key (kayttajatunnus));