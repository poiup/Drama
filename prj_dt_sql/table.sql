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
    upoint int
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
    foreign key (dnum) references dramainfo(dnum)
);

create table favorite(
	foreign key (unum) references userinfo(unum),
    foreign key (dnum) references dramainfo(dnum),
    favnum int auto_increment primary key,
    favdate date not null
);

create table buyinfo(
	foreign key (unum) references userinfo(unum),
    foreign key (dnum) references dramainfo(dnum),
	buynum int auto_increment primary key,
    buydate date not null
);

create table drama_comment(
	foreign key (unum) references userinfo(unum),
    foreign key (dnum) references dramainfo(dnum),
	comtcont varchar(100),
    comtdate date,
    comtrate int,
    comtnum int auto_increment primary key
);