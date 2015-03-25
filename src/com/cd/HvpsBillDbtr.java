package com.cd;

public class HvpsBillDbtr {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private String hvpsBillDbtr() {
		
		// 城市商业银行汇票SQL
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT");
		// 签发日期（出票日期）
		sb.append("      T.MBFEAUTHENTICATEDDT ");
		// 收款人名称
		sb.append("      T.CDTRNM");
		// 出票金额
		sb.append("      T.ISSUEAMT");
		// 付款人名称（申请人）
		sb.append("      T.DBTRNM");
		// 付款人帐号
		sb.append("      T.DBTRACCT");
		// 付款行名称（出票行）
		sb.append("      T.DBTRBRNCHNM");
		// 付款行行号（出票行号）
		sb.append("      vDBTRBRNCHID");
		// 密押
		sb.append("      T.BILLSEAL");
		// 备注
		sb.append("      T.USTRD");
		sb.append("FROM   HVPSBILLDBTR t");
		sb.append("WHERE 1 = 1");
		// 支付交易组号
		sb.append("AND T.PMTGRPID = ?");
		
		return null;
	}
	
	
	
}