--insert into member ( mid , mpwd ) values ( "qwe1" , "1234" );
--insert into member ( mid , mpwd ) values ( "qwe2" , "4567" );
--insert into member ( mid , mpwd ) values ( "qwe3" , "7891" );
--insert into member ( mid , mpwd ) values ( "qwe4" , "1598" );
--insert into member ( mid , mpwd ) values ( "qwe5" , "3578" );
--
--insert into board ( btitle , bcontent , mno ) values( "제목1" , "내용1" , 1);
--insert into board ( btitle , bcontent , mno ) values( "제목2" , "내용2" , 3);
--insert into board ( btitle , bcontent , mno ) values( "제목3" , "내용3" , 2);
--insert into board ( btitle , bcontent , mno ) values( "제목4" , "내용4" , 1 );
--insert into board ( btitle , bcontent , mno ) values( "제목5" , "내용5" , 4);

insert into user ( uname, uid, upwd, uphone, uaddress ) values ("kim", "qqq123", "1234", 01012345678, "서울 용산");
insert into user ( uname, uid, upwd, uphone, uaddress ) values ("Lee", "www123", "2345", 01023456789, "인천 남동");
insert into user ( uname, uid, upwd, uphone, uaddress ) values ("Park", "eee123", "3456", 01034567890, "인천 서");
insert into user ( uname, uid, upwd, uphone, uaddress ) values ("choi", "rrr123", "4567", 01045678900, "서울 강남");
insert into user ( uname, uid, upwd, uphone, uaddress ) values ("jeon", "ttt123", "5678", 01056781234, "경기 김포");

insert into cate (cname) values ("신선식품");
insert into cate (cname) values ("간편식품");
insert into cate (cname) values ("육류");
insert into cate (cname) values ("해산류");
insert into cate (cname) values ("유제품");

insert into pro (pname, cno) values ("밀키트", 2);
insert into pro (pname, cno) values ("한우", 3);
insert into pro (pname, cno) values ("요거트", 5);
insert into pro (pname, cno) values ("굴비", 4);
insert into pro (pname, cno) values ("밀키트떡볶이", 2);

insert into orders (uno) values (1);
insert into orders (uno) values (2);
insert into orders (uno) values (3);
insert into orders (uno) values (4);
insert into orders (uno) values (5);

insert into order_Detail (odcount, ono, pno, sellerno, buyerno) values (1, 1, 1, 1, 2);
