package com.cd;

public class HvpsBillDbtr {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private String hvpsBillDbtr() {
		
		// ������ҵ���л�ƱSQL
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT");
		// ǩ�����ڣ���Ʊ���ڣ�
		sb.append("      T.MBFEAUTHENTICATEDDT ");
		// �տ�������
		sb.append("      T.CDTRNM");
		// ��Ʊ���
		sb.append("      T.ISSUEAMT");
		// ���������ƣ������ˣ�
		sb.append("      T.DBTRNM");
		// �������ʺ�
		sb.append("      T.DBTRACCT");
		// ���������ƣ���Ʊ�У�
		sb.append("      T.DBTRBRNCHNM");
		// �������кţ���Ʊ�кţ�
		sb.append("      vDBTRBRNCHID");
		// ��Ѻ
		sb.append("      T.BILLSEAL");
		// ��ע
		sb.append("      T.USTRD");
		sb.append("FROM   HVPSBILLDBTR t");
		sb.append("WHERE 1 = 1");
		// ֧���������
		sb.append("AND T.PMTGRPID = ?");
		
		return null;
	}
	
	
	
}