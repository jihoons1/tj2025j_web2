DROP DATABASE IF EXISTS springweb5;
CREATE DATABASE springweb5;
USE springweb5;

create table product5(
	sno int auto_increment, -- 익명 번호
    mno int not null, -- 영호 ㅏ번호
    spwd varchar(15) not null , -- 익명 비번
    tabletext varchar(100) not null , -- 게시물 내용
    smovie varchar(10) not null, -- 게시물 내용
    constraint pk_product5 primary key(sno),
    constraint fk_product5_movie foreign key(mno) references movie(mno)
    );
    
create table movie(
	mno int auto_increment, -- 영화 번호
    mname varchar(10) not null , -- 영화 감독
    mgenre varchar(10) not null , -- 영화 장르
    mcontent varchar(100) not null, -- 영화 소개
    constraint pk_movie primary key(mno)
    );

insert into movie(mname,mgenre,mcontent)values
	('크리스토퍼 놀란','SF','우주여행1'),
    ('크리스토퍼 놀린','SF','우주여행2'),
    ('크리스토퍼 놀런','SF','우주여행3');
        
    
insert into product5(mno,spwd,tabletext,smovie)values
	(1,'qwe123','오늘 저녁영화','인터스텔라1'),
    (2,'asd123','오늘 저녁영화','인터스텔라2'),
    (3,'zxc123','오늘 저녁영화','인터스텔라3');
    

    

    