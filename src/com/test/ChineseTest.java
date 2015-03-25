/**
 * FileName: ChineseTest.java <br/>
 */
package com.test;

import java.io.UnsupportedEncodingException;

/**
 * Project: Test <br/>
 * Class: com.test.ChineseTest <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Company: www.xxxxxxxx.com <br/>
 * Makedate: 2014-4-22 下午11:11:34 <br/>
 * 
 * @author guanxl
 * @version 1.0
 * @since 1.0
 */
public class ChineseTest {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String s1 = "我是中国人";
		String s2 = "imchinese";
		String s3 = "im中国人";
		String ss = "我ABC是汉DEF";
		char[] charStr = ss.toCharArray();
//		for (int i = 0; i < charStr.length; i++) {
//			System.out.println(charStr);
//		}
		
		ChineseTest ct = new ChineseTest();
		System.out.println(ct.getLimitLengthString(ss, 7));
		System.out.println(ss.getBytes("GBK").length);
		System.out.println(ss.length());
	}

	/**
	 * 截取字符串 len为字节长度
	 * 
	 * @param str
	 * @param len
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getLimitLengthString(String str, int len) {
		try {
			int counterOfDoubleByte = 0;
			byte[] b = str.getBytes("gb2312");
			if (b.length <= len)
				return str;
			for (int i = 0; i < len; i++) {
				if (b[i] < 0)
					counterOfDoubleByte++;
			}
			if (counterOfDoubleByte % 2 == 0)
				return new String(b, 0, len, "gb2312");
			else
				return new String(b, 0, len - 1, "gb2312");
		} catch (Exception ex) {
			return "";
		}
	}

}
