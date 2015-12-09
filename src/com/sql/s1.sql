select CONSIGNDATE    as cissdt,
       DEALNO         as cisssq,
       OUTPUTBNO      as pyerbk,
       MONEY          as tranam,
       ckstatus       as transt,
       PAYERNO        as pyerac,
       PAYERFULLNAME  as pyerna,
       OPERSTATUS     as trstat,
       GATHERNO       as recvac,
       GATHERFULLNAME as recvna,
       CHECKNO        as drftno,
       PAYPW          as pypswd
  from checktb t