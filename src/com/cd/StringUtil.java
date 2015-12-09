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
		if (ssTo.getBytes().length > 16) {
			ssTo = ssTo.substring(0, 8) + "...";
		}
		System.out.println(ssTo.getBytes().length + "    :" + ssTo);
	}

	/**
	 * �õ��ַ����������.����"Ԥ���Ŀ1",��õ�1
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
