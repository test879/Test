package com.cd;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String ss = "速度加快沃尔夫你偶是第五届";
		String ssTo = new String(ss.getBytes(), "GBK");
		if(ssTo.getBytes().length > 16){
			ssTo = ssTo.substring(0, 8)+"...";
		}
		System.out.println(ssTo.getBytes().length+"    :"+ssTo);
	}
}
