use WebTest4
go

create proc CreateMyTable 
as
create table MyData(
  year int not null,
  month int ,
  amount float
)

insert into MyData values 
(1991,1,1.1),
(1991,2,1.2),
(1991,3,1.3),
(1991,4,1.4),
(1992,1,1.1),
(1992,2,1.2),
(1992,3,1.3),
(1992,4,1.4)


go



