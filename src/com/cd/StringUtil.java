package com.cd;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String ss = "�ٶȼӿ��ֶ�����ż�ǵ����";
		String ssTo = new String(ss.getBytes(), "GBK");
		if(ssTo.getBytes().length > 16){
			ssTo = ssTo.substring(0, 8)+"...";
		}
		System.out.println(ssTo.getBytes().length+"    :"+ssTo);
	}
}
