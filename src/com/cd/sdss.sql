 select a.* from (
		 select o1.ID as id,c1.MSGTPID,o1.PMTTP,o1.TXID,o1.DBTRBRNCHID,o1.DBTRISSUER,o1.STTLMDT,o1.DBTRBRNCHNM,o1.DBTRACCT,o1.DBTRNM, 
		 o1.DBTRADDR,o1.CDTRBRNCHID,o1.CDTRISSUER,o1.WORKDT,o1.CDTRACCT,o1.CDTRNM,o1.CDTRADDR, 
		 o1.AMOUNT,o1.USTRD,o1.PRINTTIMES,o1.ENDTOENDID as NOTESNO,o1.NOTESTP,o1.NOTESDT,o1.ORGCODE,o1.MSGID, 
		 o1.PMTKD,c1.id as pid,o1.AMOUNT as AmndsAmt,o1.AMOUNT as RjctAmt,o1.NOTESTP as interbklnrt,o1.NOTESTP as interbklmt, 
		 c1.ZHANGWUSTATUS as corestatuss,c1.STTLMPRTY as sttlmprty,
		 c1.rzls, c1.GUAZHANGSTATUS
		 from HVPS111CDTR o1 
		 left join CNAPSPMTCOLLECT c1 on  (o1.msgid = c1.msgid and o1.instgpty=c1.instgpty )where 1=1   
		 and o1.pmttp not in('A110','A200') and c1.direction='I'
		 
		 union   //Æ´½Ó
		 select  b.Id as id, b.MSGTPID,b.PMTTP,b.TXID,b.DBTRBRNCHID,b.DBTRISSUER,b.WORKDT,b.DBTRBRNCHNM,b.DBTRACCT,b.DBTRNM,b.DBTRADDR, 
		 b.CDTRBRNCHID,b.CDTRISSUER,b.WORKDT,b.CDTRACCT,b.CDTRNM,b.CDTRADDR,b.AMOUNT,b.USTRD,b.PRINTTIMES, 
		 a110.NOTESNO,b.NOTESTP,a110.NOTESDT,b.ORGCODE,b.MSGID,b.PMTKD,b.PID,a110.AmndsAmt,a110.RjctAmt,   
		 b.NOTESTP as interbklnrt,b.NOTESTP as interbklmt,b.corestatuss,b.sttlmprty,
		 b.rzls,b.GUAZHANGSTATUS
		 from (  
		 select o2.Id, c2.MSGTPID,o2.PMTTP,o2.TXID,o2.DBTRBRNCHID,o2.DBTRISSUER,o2.STTLMDT,o2.DBTRBRNCHNM,o2.DBTRACCT,o2.DBTRNM, 
		 o2.DBTRADDR,o2.CDTRBRNCHID,o2.CDTRISSUER,o2.WORKDT,o2.CDTRACCT,o2.CDTRNM,o2.CDTRADDR, 
		 o2.AMOUNT,o2.USTRD,o2.PRINTTIMES,o2.NOTESTP,o2.ORGCODE,o2.MSGID,o2.PMTKD ,c2.id as pid, 
		 c2.ZHANGWUSTATUS as corestatuss,c2.STTLMPRTY as sttlmprty,
		 c2.rzls, c2.GUAZHANGSTATUS
		 from HVPS111CDTR o2 
		 left join CNAPSPMTCOLLECT c2 on ( o2.msgid = c2.msgid and o2.instgpty=c2.instgpty ) where   o2.pmttp ='A110' and c2.direction='I') b 
		 left join  ADDTNLDATAA110 a110 on b.id=a110.msgidunq  
		 union
		 select  b.Id as id, b.MSGTPID,b.PMTTP,b.TXID,b.DBTRBRNCHID,b.DBTRISSUER,b.WORKDT,b.DBTRBRNCHNM,b.DBTRACCT,b.DBTRNM,b.DBTRADDR, 
		 b.CDTRBRNCHID,b.CDTRISSUER,b.WORKDT,b.CDTRACCT,b.CDTRNM,b.CDTRADDR,b.AMOUNT,b.USTRD,b.PRINTTIMES, 
		 b.NOTESNO,b.NOTESTP,b.NOTESDT,b.ORGCODE,b.MSGID,b.PMTKD,b.PID,b.AMOUNT as AmndsAmt,b.AMOUNT as RjctAmt, 
		 a200.interbklnrt,a200.interbklmt,b.corestatuss,b.sttlmprty, 
		 b.rzls, b.GUAZHANGSTATUS
		 from (  
		 select o2.Id, c2.MSGTPID,o2.PMTTP,o2.TXID,o2.DBTRBRNCHID,o2.DBTRISSUER,o2.STTLMDT,o2.DBTRBRNCHNM,o2.DBTRACCT,o2.DBTRNM, 
		 o2.DBTRADDR,o2.CDTRBRNCHID,o2.CDTRISSUER,o2.WORKDT,o2.CDTRACCT,o2.CDTRNM,o2.CDTRADDR, 
		 o2.AMOUNT,o2.USTRD,o2.PRINTTIMES,o2.ENDTOENDID as NOTESNO,o2.NOTESTP,o2.NOTESDT,o2.ORGCODE,o2.MSGID,o2.PMTKD ,c2.id as pid,
		 c2.ZHANGWUSTATUS as corestatuss,c2.STTLMPRTY as sttlmprty,
		 c2.rzls, c2.GUAZHANGSTATUS
		 from HVPS111CDTR o2 
		 left join CNAPSPMTCOLLECT c2 on ( o2.msgid = c2.msgid and o2.instgpty=c2.instgpty ) where   o2.pmttp ='A200' and c2.direction='I') b 
		 left join  ADDTNLDATAA200 a200 on b.id=a200.msgidunq ) a where 1=1 