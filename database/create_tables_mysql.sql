create table Kysely(
	id int auto_increment not null,
	nimi varchar(100),
	primary key (id))
	ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Kysymys(
    id int auto_increment not null,
    kysymys varchar(300) not null,
    tyyppi varchar(50),
    description varchar (500),
    kysely_id int,
    primary key (id),
    foreign key (kysely_id) REFERENCES Kysely(id))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Vastaus(
    id int auto_increment not null,
    vastaus varchar(300) not null,
    kysymys_id int,
    primary key (id),
    foreign key (kysymys_id) REFERENCES Kysymys(id))
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table webuser2(
	id integer NOT NULL auto_increment PRIMARY KEY,
    kayttajatunnus varchar(50) not null,
    password_encrypted varchar(255) NOT NULL,
  	enabled tinyint NOT NULL
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
create table authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 create table webuser2_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  webuser2_id integer NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (webuser2_id) REFERENCES webuser2(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
