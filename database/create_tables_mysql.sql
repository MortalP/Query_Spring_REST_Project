create table Kysymys(
    id int auto_increment not null,
    kysymys varchar(300) not null,
    primary key (id));
    
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