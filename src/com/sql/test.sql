with send100(outputbno) as 
(
select  send100.outputbno as outputbno 
from cisfedb.CHECKOUTPUT send100,cisfedb.CISFEODT0001 c01  
where send100.outputbno=c01.bnkcode  and  1=1 and  send100.sysaccepttime  
between '20050906' and '20150911'group by send100.outputbno
),
rece100(inputbno) as (
select  rece100.inputbno as inputbno from cisfedb.CHECKTB rece100,cisfedb.CISFEODT0001 c01  
where rece100.inputbno=c01.bnkcode    
and 1=1 and rece100.sysaccepttime  between '20050906' and '20150911'group by rece100.inputbno
)
select  c01.lname as lname,c01.bnkcode as bankcode 
from  cisfedb.CISFEODT0001 c01  where  c01.bnkcode in (select * from send100 ) 
or c01.bnkcode in (select * from rece100)  group by c01.lname ,c01.bnkcode 
