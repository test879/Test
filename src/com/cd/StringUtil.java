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
		if (ssTo.getBytes().length > 16) {
			ssTo = ssTo.substring(0, 8) + "...";
		}
		System.out.println(ssTo.getBytes().length + "    :" + ssTo);
	}

	/**
	 * 得到字符串后的数字.比如"预算科目1",则得到1
	 */
	public static int getSuffixAsNumber(String str) {
		int numBegin = str.length() - 1;
		while (numBegin > 0) {
			char c = str.charAt(numBegin);
			if (c >= '0' && c <= '9') {
				numBegin--;
			} else {
				break;
			}
		}
		if (numBegin + 1 >= str.length()) {
			return 0;
		} else {
			return Integer.parseInt(str.substring(numBegin + 1, str.length()));
		}
	}

	public static String nullToString(String resource) {
		if (resource == null)
			resource = "";
		return resource.trim();
	}
}
