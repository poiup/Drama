use team_prj;

create table userinfo(
	uid varchar(20) unique,
    upw varchar(20) not null,
    uname varchar(20) not null,
    uage int not null,
    unum int auto_increment primary key,
    ucredit varchar(16) not null,
    uadress varchar(60),
    unick varchar(15),
    upoint int default 0
);


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
    FOREIGN KEY(dnum) REFERENCES dramainfo (dnum)
);

create table favorite(
	unum int not null,
	foreign key (unum) references userinfo(unum),
    dnum int not null,
    foreign key (dnum) references dramainfo(dnum),
    favnum int auto_increment primary key,
    favdate date not null
);

create table buyinfo(
	unum int not null,
	foreign key (unum) references userinfo(unum),
    dnum int not null,
    foreign key (dnum) references dramainfo(dnum),
	buynum int auto_increment primary key,
    buydate datetime default now()
);

create table drama_comment(
	unum int not null,
	foreign key (unum) references userinfo(unum),
    dnum int not null,
    foreign key (dnum) references dramainfo(dnum),
	comtcont varchar(100),
    comtdate datetime default now(),
    comtrate int,
    comtnum int auto_increment primary key
);


-- 어드민 유저
insert into userinfo (uid,upw,uname,uage,ucredit,uadress,unick) value ("admin", "1234", "어드민", 28, "1111111111111111", "경기도 고양시", "admin");  


-- 테이블 체크
select * from favorite;
select * from buyinfo;
select * from actor;
select * from drama_comment;
select * from dramainfo;
select * from userinfo;



-- 테이블 싹 날릴때 순서대로 실행하면 됩니다.
drop table favorite;
drop table buyinfo;
drop table actor;
drop table drama_comment;
drop table dramainfo;
drop table userinfo;
