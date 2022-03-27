use team_prj;

create table userinfo(
	uid varchar(20) unique not null,
    upw varchar(20) not null,
    uname varchar(20) not null,
    uage int not null,
    unum int auto_increment primary key,
    ucredit varchar(16) not null,
    uadress varchar(60),
    unick varchar(15),
    upoint int default 0
);

INSERT INTO userinfo (uid,upw,uname,uage,ucredit,uadress,unick) VALUE (1,2,3,4,5,6,7);
INSERT INTO userinfo (uid,upw,uname,uage,ucredit,uadress,unick) VALUE ('q','q','q','4','q','q','q');
create table dramainfo(
	dname varchar(20) not null,
    dprice int not null,
    dgenre varchar(10) not null,
    ddate date not null,
    dage int not null,
    dnum int auto_increment primary key,
    dthumb varchar(30) not null,
    dvideo varchar(30) not null,
    dtext varchar(300)
);

create table actor(
	actname varchar(10) not null,
    actnum int auto_increment primary key,
    dnum int not null,
    CONSTRAINT FOREIGN KEY(dnum) REFERENCES dramainfo (dnum) ON DELETE CASCADE
);

create table favorite(
	unum int not null,
	CONSTRAINT foreign key (unum) references userinfo(unum) ON DELETE CASCADE,
    dnum int not null,
    CONSTRAINT foreign key (dnum) references dramainfo(dnum) ON DELETE CASCADE,
    favnum int auto_increment primary key,
    favdate date not null
);
 insert into buyinfo values (1,7,null,now());
create table buyinfo(
	unum int not null,
	CONSTRAINT foreign key (unum) references userinfo(unum) ON DELETE CASCADE,
    dnum int not null,
    CONSTRAINT foreign key (dnum) references dramainfo(dnum) ON DELETE CASCADE,
	buynum int auto_increment primary key,
    buydate datetime default now()
);

create table drama_comment(
	unum int not null,
	CONSTRAINT foreign key (unum) references userinfo(unum) ON DELETE CASCADE,
    dnum int not null,
    CONSTRAINT foreign key (dnum) references dramainfo(dnum) ON DELETE CASCADE,
	comtcont varchar(100),
    comtdate datetime default now(),
    comtrate int,
    comtnum int auto_increment primary key
);


-- 어드민 유저
insert into userinfo (uid,upw,uname,uage,ucredit,uadress,unick) value ("admin", "1234", "어드민", 28, "1111111111111111", "경기도 고양시", "admin");  
insert into dramainfo values ('1',2,'3',now(),1,null,'4','5','1234567');
insert into drama_comment (unum,dnum,comtcont,comtrate) value(1,1,'댓글내용',5);
insert into actor (actname,dnum) value ("1",3);
-- 테이블 체크
select * from favorite;
select * from buyinfo;
select * from actor;
select * from drama_comment;
select * from dramainfo;
select * from userinfo;

SELECT * FROM userinfo WHERE uid = 'admin';
SELECT * FROM dramainfo WHERE dnum = (SELECT max(dnum) from dramainfo);
SELECT * FROM actor WHERE dnum = 3;
-- 테이블 싹 날릴때 순서대로 실행하면 됩니다.
drop table favorite;
drop table buyinfo;
drop table actor;
drop table drama_comment;
drop table dramainfo;
drop table userinfo;
