package com.cd;

public class SQLTest {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SQLTest test = new SQLTest();
		
		CrederncePrintEntity entity = new CrederncePrintEntity();
		
		System.out.println("���ڴ���:"+test.getHvps111SQL("15102014060980006673", "BEPS121DBTR", entity)+"\n");
		
//		System.out.println("���л�Ʊ:"+test.getHvps111SQL("15102014091980013532", "HVPSBILLDBTR", entity));

	}

	private String getHvps111SQL(String pmgrpid, String tableName, CrederncePrintEntity entity) {

		StringBuffer sql = new StringBuffer();

		if (tableName.equalsIgnoreCase("HVPS111DBTR")) {
			// ��ͨ��Ҵ��
			sql.append("select o.orgcode,o.signeddt,o.signedtm,o.PrintTimes,c.MsgTpId,o.pmttp,o.pmtkd,o.Pmtgrpid,o.Dbtrbrnchid, ");
			sql.append("o.Dbtrissuer,o.DBTRISSUERNM,o.Dbtrbrnchnm,o.Dbtracct,o.Dbtrnm,o.Dbtraddr,o.Cdtrbrnchid,o.CDTRBRNCHNM,");
			sql.append("o.Workdt,o.Cdtrissuer,o.CDTRISSUERNM,o.signeddt,o.signedtm,o.Cdtracct,o.Cdtrnm,o.Cdtraddr,o.Amount,o.Ustrd,o.orgCode,o.signerid,o.checkerid,");
			sql.append("o.ServiceCharge,o.Postage,o.OutstationCharge,o.gongbenfei,o.warrantyId,c.tablenm, ");
			sql.append("c.Sttlmprty,o.waive");
			sql.append(", (select t.name from ccmssystemorganizationsmanage t where t.NAMECODE = o.orgcode) as orgname");
			if (pmgrpid.length() != 20) {
				// ת���жҲ�ѯ ע��֧�����������ʽΪ200812175072����ˮ��Ϊ����λ
				sql.append(", " + pmgrpid.substring(8) + " as printno");
			} else {
				sql.append(", (select j.coreid from ccms_chaoy_jizhangliushui j where j.cnapspmtcollectid = c.id and (j.operatetype='1' or j.operatetype='0')) as printno");
			}
			sql.append(" from HVPS111DBTR o ");
			sql.append(" left join CNAPSPMTCOLLECT c on  o.PmtGrpId = c.PmtGrpId  where 1=1  ");
			sql.append(" and o.PmtGrpId=?");
		} else if (tableName.equalsIgnoreCase("BEPS121DBTR")) {
			// ��ͨ���С��
			sql.append("select o.orgcode,o.signeddt,o.signedtm,o.PrintTimes,c.MsgTpId,o.pmttp,o.pmtkd,o.Pmtgrpid,o.Dbtrbrnchid, ");
			sql.append("o.Dbtrissuer,o.DBTRISSUERNM,o.Dbtrbrnchnm,o.Dbtracct,o.Dbtrnm,o.Dbtraddr,o.Cdtrbrnchid,o.CDTRBRNCHNM,");
			sql.append("o.Workdt,o.Cdtrissuer,o.CDTRISSUERNM,o.signeddt,o.signedtm,o.Cdtracct,o.Cdtrnm,o.Cdtraddr,o.Amount,o.ADDTLINF,o.orgCode,o.signerid,o.checkerid, ");
			sql.append("o.ServiceCharge,o.Postage,o.OutstationCharge,o.gongbenfei,o.warrantyId");
			sql.append("c.Sttlmprty, o.waive");
			sql.append(", (select t.name from ccmssystemorganizationsmanage t where t.NAMECODE = o.orgcode) as orgname");
			if (pmgrpid.length() != 20) {
				// ת���жҲ�ѯ ע��֧�����������ʽΪ200812175072����ˮ��Ϊ����λ
				sql.append(", " + pmgrpid.substring(8) + " as printno");
			} else {
				sql.append(", (select j.coreid from ccms_chaoy_jizhangliushui j where j.cnapspmtcollectid = c.id and (j.operatetype='1' or j.operatetype='0')) as printno");
			}
			sql.append(" from BEPS121DBTR o ");
			sql.append(" left join CNAPSPMTCOLLECT c on  o.PmtGrpId = c.PmtGrpId  where 1=1  ");
			sql.append(" and o.PmtGrpId=?");
		} else if (tableName.equalsIgnoreCase("BEPS125DBTR")) {
			// ���ڴ���
			sql.append("select");
			sql.append(" o.WAIVE,o.DBTRBRNCHID,o.DBTRACCT,o.DBTRNM,o.CDTRACCT,o.CDTRNM,o.CDTRBRNCHID,o.MSGID,o.CHECKERID,");
			sql.append("(select distinct j.coreid from ccms_chaoy_jizhangliushui j,cnapspmtcollect c where j.cnapspmtcollectid = c.pid  and c.pmtgrpid = o.PmtGrpId) as printno");
			sql.append(" from BEPS125DBTR o where 1=1 ");
			sql.append(" and o.PmtGrpId=?");
		} else if (tableName.equalsIgnoreCase("BEPS133DBTR")) {
			// ���ڽ��
			sql.append("select o.PrintTimes,o.pmttp,o.pmtkd,o.Pmtgrpid,");
			sql.append("o.Cdtrbrnchid,o.RCPTLTD,o.NBOFTXS,o.CDTRISSUERNM,o.CDTRBRNCHNM,");
			sql.append("o.Workdt,o.Cdtrissuer,o.signeddt,o.signedtm,o.Cdtracct,o.Cdtrnm,o.Cdtraddr,o.Amount,o.orgCode,o.signerid,o.checkerid, ");
			sql.append("o.warrantyId,c.ServiceCharge,c.Postage,c.OutstationCharge,c.gongbenfei,c.Waive, ");
			sql.append("(select distinct j.coreid from ccms_chaoy_jizhangliushui j,cnapspmtcollect c where j.cnapspmtcollectid = c.pid  and c.pmtgrpid = o.PmtGrpId) as printno");
			sql.append(" from BEPS133CDTR o ");
			sql.append(" left join beps133cdtrpertain c on o.pid = c.id  where 1=1  ");
			sql.append(" and o.PmtGrpId=?");
		} else if (tableName.equalsIgnoreCase("HVPSBILLDBTR")) {
			// ���л�Ʊ
			sql.append("select");
			sql.append(" o.WAIVE,o.DBTRBRNCHID,o.DBTRACCT,o.DBTRNM,o.CDTRACCT,o.CDTRNM,o.CDTRBRNCHID,o.MSGID,o.CHECKERID,");
			sql.append("(select distinct j.coreid from ccms_chaoy_jizhangliushui j,cnapspmtcollect c where j.cnapspmtcollectid = c.pid  and c.pmtgrpid = o.PmtGrpId) as printno");
			sql.append(", (select t.name from ccmssystemorganizationsmanage t where t.NAMECODE = o.orgcode) as orgname");
			sql.append(" from HVPSBILLDBTR o ");
			sql.append(" where 1=1 and o.PMTGRPID =?");
		}
		
		return sql.toString().replace("?", "'"+pmgrpid+"'");
	}
}