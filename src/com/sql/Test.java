/**
 * FileName: Test.java <br/>
 */
package com.sql;

/**
 * Project: Test <br/>
 * Class: com.sql.Test <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2015 <br/>
 * Makedate: 2015年9月11日 上午10:33:06 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class Test {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String wangdian = " and 1=1";
		String wangdian1 = " and 1=1";
		String beginTime = "20060904";
		String endTime = "20150918";
		 String sql_1="with send100(outputbno) as (select  send100.outputbno as outputbno from cisfedb.CHECKOUTPUT send100,cisfedb.CISFEODT0001 c01 "
			     +" where send100.outputbno=c01.bnkcode "
			  + wangdian
	           + " and  send100.sysaccepttime  between '"
					+ beginTime+ "' and '"+ endTime+ "'"
	          +"group by send100.outputbno"
	          +"),"
			       + "rece100(inputbno) as (select  rece100.inputbno as inputbno from cisfedb.CHECKTB rece100,cisfedb.CISFEODT0001 c01 "
			  +" where rece100.inputbno=c01.bnkcode "
			  + wangdian1
				  + " and rece100.sysaccepttime  between '"
				  + beginTime+ "' and '"+ endTime+ "'"
	          +"group by rece100.inputbno"
	          +")"
			 +"select  c01.lname as lname,c01.bnkcode as bankcode from  cisfedb.CISFEODT0001 c01 "
			 +" where  c01.bnkcode in (select * from send100 ) or c01.bnkcode in (select * from rece100)  group by    c01.lname ,c01.bnkcode ";

		String sql_5 = "select  c01.lname as lname,c01.bnkcode as bankcode from  cisfedb.CISFEODT0001 c01 "
				+ " where  c01.bnkcode in (select * from "
				+"(select  send100.outputbno as outputbno from cisfedb.CHECKOUTPUT send100,cisfedb.CISFEODT0001 c02 "
						+ " where send100.outputbno=c02.bnkcode "
						+ wangdian
						+ " and  send100.sysaccepttime  between '"
						+ beginTime
						+ "' and '"
						+ endTime
						+ "'"
						+ "group by send100.outputbno"
				+") "
				+") or c01.bnkcode in (select * from ("+
				"select  rece100.inputbno as inputbno from cisfedb.CHECKTB rece100,cisfedb.CISFEODT0001 c03 "
						+ " where rece100.inputbno=c03.bnkcode "
						+ wangdian1
						+ " and rece100.sysaccepttime  between '"
						+ beginTime
						+ "' and '"
						+ endTime
						+ "'"
						+ "group by rece100.inputbno"
				+")"
				+")  group by c01.lname ,c01.bnkcode ";
		
		System.out.println(sql_1);
	}

}
