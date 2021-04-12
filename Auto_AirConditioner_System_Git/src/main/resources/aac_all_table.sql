create table aac_member(
	aac_no number(10) primary key,
	aac_member_serial_number varchar2(10 char) not null,
	aac_email varchar2(50 char) not null,
	aac_password varchar2(20 char) not null,
	aac_sex varchar2(5 char) not null,
	aac_addr varchar2(100 char) not null,
	aac_age number(2) not null
);
insert into aac_member values(aac_member_seq.nextval, 'F3F8D6', 'sangmin3285@gmail.com', '123123123', '남', '서울특별시 서초구 방배로14 3-803', '29');
insert into aac_member values(aac_member_seq.nextval, 'F3F8D6', 'a@gmail.com', 'a', '남', '서울특별시', '34');
create sequence aac_member_seq;
drop sequence aac_member_seq;
select * from aac_member;


update aac_member
set aac_member_serial_number = 'F3F8D7'
where aac_email = 'qq@gmail.com';

delete from aac_member where aac_email = 'sangmin3285@gmail.com';

create table aac_tempData(
	aac_no number(10) primary key,
	aac_serial_number varchar2(10 char) not null,
	aac_temp number(5,2) not null,
	aac_humidity number(5,2) not null,
	aac_statue varchar2(5 char) not null
);
insert into aac_tempData values(aac_tempData_seq.nextval, 'A111111', 123, 123,'제습');
create sequence aac_tempData_seq;
drop sequence aac_tempData_seq;

select * from aac_member whe re aac_email = 'sangmin3285@gmail.com';

select *
from aac_member
where aac_email = 'sangmin3285@gmail.com';


select * from aac_tempData where aac_serial_number = 'F3F8D7';
select aac_serial_number, aac_temp, aac_humidity, aac_statue, aac_email, aac_password
from aac_tempData, aac_member
where aac_serial_number in (
	select aac_member_serial_number
	from aac_member
	where aac_email = 'sangmin3285@gmail.com' and aac_password = '123123123'
);



select aac_email, aac_password, aac_member_serial_number
from aac_member
where aac_email = 'sangmin3285@gmail.com' and aac_password = '123123123';


select aac_serial_number, aac_temp, aac_humidity, aac_statue
from aac_temp
where aac_serial_number = (
	select aac_serial_number
	from aac_member
	where aac_serial_number = (
		from aac_member
		where aac_email = '123@gmail.com'
	)
);
select * from aac_tempData;

select count(*) from aac_tempData;



drop table aac_member cascade constraint purge;
drop table aac_tempData cascade constraint purge;
