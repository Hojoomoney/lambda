show tables;
select * from members;
insert into articles(title, content, writer) values ('테스트 제목','테스트글','에이다');
CREATE TABLE articles(
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(20) NOT NULL,
  content VARCHAR(100) NULL,
  writer VARCHAR(20) NOT NULL,
  register_date DATETIME DEFAULT (current_time),
  CONSTRAINT board_pk PRIMARY KEY(id)
);

CREATE TABLE Members (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20),
    phone VARCHAR(20),
    job VARCHAR(20),
    height VARCHAR(20),
    weight VARCHAR(20)
);

drop table members;
rename table board to articles;

CREATE TABLE stadium(
    id INT NOT NULL AUTO_INCREMENT,
    stadium_name VARCHAR(40),
    hometeam_id VARCHAR(10),
    seat_count INT,
    address VARCHAR(60),
    ddd VARCHAR(10),
    tel VARCHAR(10),
    PRIMARY KEY(id)
);
CREATE TABLE schedule(
    id INT NOT NULL AUTO_INCREMENT,
    stadium_id INT,
    gubun VARCHAR(10),
    hometeam_id VARCHAR(10),
    awayteam_id VARCHAR(10),
    home_score INT,
    away_score INT,
    primary key (id),
    foreign key (stadium_id) references stadium(id)
);
create table team(
    id INT NOT NULL AUTO_INCREMENT,
    region_name VARCHAR(10),
    team_name VARCHAR(40),
    e_team_name VARCHAR(50),
    orig_yyyy VARCHAR(10),
    zip_code1 VARCHAR(10),
    zip_code2 VARCHAR(10),
    address VARCHAR(80),
    ddd VARCHAR(10),
    tel VARCHAR(10),
    fax VARCHAR(10),
    homepage VARCHAR(50),
    owner VARCHAR(10),
    stadium_id INT,
    primary key (id),
    foreign key (stadium_id) references stadium(id)
);
create table player(
    id INT NOT NULL AUTO_INCREMENT,
    player_name VARCHAR(20),
    e_player_name VARCHAR(40),
    nickname VARCHAR(30),
    join_yyyy VARCHAR(10),
    position VARCHAR(10),
    back_no INT,
    nation VARCHAR(20),
    birth_date DATE,
    solar VARCHAR(10),
    height INT,
    weight INT,
    team_id INT,
    primary key (id),
    foreign key (team_id) references team(id)
);

