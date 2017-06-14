
use WebTest4
go

--用存储过程创建表格
--exec CreateMyTable

--select year,
--case month
-- when 1 then 'm1' end as m1



--select year as year,
-- (select SUM(amount) from MyData b where a.year = b.year and b.month = 1)as m1,
-- (select SUM(amount) from MyData b where a.year = b.year and b.month = 2)as m2,
-- (select SUM(amount) from MyData b where a.year = b.year and b.month = 3)as m3,
-- (select SUM(amount) from MyData b where a.year = b.year and b.month = 4)as m4,
-- (select SUM(amount) from MyData b where a.year = b.year and b.month = 5)as m5
-- from MyData a group by year


select year as year,
SUM(case when month =1 then amount else 0 end) as m1,
SUM(case when month =2 then amount else 0 end) as m2,
SUM(case when month =3 then amount else 0 end) as m3,
SUM(case when month =4 then amount else 0 end) as m4,
SUM(case when month =5 then amount else 0 end) as m5,
SUM(case when month =6 then amount else 0 end) as m6,
SUM(case when month =7 then amount else 0 end) as m7,
SUM(case when month =8 then amount else 0 end) as m8,
SUM(case when month =9 then amount else 0 end) as m9,
SUM(case when month =10 then amount else 0 end) as m10,
SUM(case when month =11 then amount else 0 end) as m11,
SUM(case when month =12 then amount else 0 end) as m12
from MyData group by year 


