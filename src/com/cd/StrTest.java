/**
 * FileName: StrTest.java <br/>
 */
package com.cd;


/**
 * Project: Test <br/>
 * Class: com.cd.StrTest <br/>
 * Description: <������Ĺ���>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Makedate: 2014-7-16 ����09:59:58 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class StrTest {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append("1234567890");
		sb.append("0987654321");
		System.out.println("ǰ��"+sb.toString());
		sb.delete(0, sb.length());
		
		System.out.println("��"+sb.toString());
	}
	

}
