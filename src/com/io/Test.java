/*
 * Copyright (C) 2012 Oki Electric Industry Co., Ltd.
 * $HeadURL$
 */
package com.io;


/**
 * 
 * 
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(StringUtils.abbreviate("���������������L����ļ�������������������������������������ĤƤȤʤˤ̤ͤΤϤҤդؤۤޤߤ���������", 53));

//		File file = new File("e-rad/src/jp/go/mext/erad/action/e08");
		
		int[] a = {1, 2, 3};
		StringBuffer sbuf = new StringBuffer();
		
		System.out.println(charArrayAppend(sbuf, a).toString());
	}

	private static StringBuffer charArrayAppend(StringBuffer sbuf, int[] a) {
//		sbuf.append('[');
		int len = a.length;
		for (int i = 0; i < len; ++i) {
			sbuf.append(a[i]);
			if (i != len - 1)
				sbuf.append(", ");
		}
//		sbuf.append(']');
		return sbuf;
	}

}
