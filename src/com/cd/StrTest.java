/**
 * FileName: StrTest.java <br/>
 */
package com.cd;


/**
 * Project: Test <br/>
 * Class: com.cd.StrTest <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Makedate: 2014-7-16 上午09:59:58 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class StrTest {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append("1234567890");
		sb.append("0987654321");
		System.out.println("前："+sb.toString());
		sb.delete(0, sb.length());
		
		System.out.println("后："+sb.toString());
	}
	

}
