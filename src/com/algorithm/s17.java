package com.algorithm;

/**
 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b
 * 
 * Project: Test <br/>
 * Class: com.test.s17 <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2015 <br/>
 * Makedate: 2015年2月28日 上午11:49:04 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class s17 {
	public static char firstOne(String s)
	{
		char result = '0';
		char temp;
		int[] num = new int[52];
		for (int i = 0; i < s.length(); i ++)
		{
			temp = s.charAt(i);
			if ( temp >= 'a' && temp <= 'z' )
			{
				num[temp - 'a']++;
			}
			else
				if (temp >= 'A' && temp <= 'Z')
				{
					num[temp - 'A' + 26] ++;
				}
		}
		for (int i = 0; i < num.length; i ++)
		{
			if (num[i] == 1)
			{
				if (i >= 0 && i <=26)
				{
					result = (char)(i + 'a');
				}
				else
					result = (char)(i - 26 + 'A');
				break;
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "xabb";
		String s = "abaccdeff";
//		
//		char c = firstOne(s);
//		System.out.println(c);
		char temp='z';
		System.out.println(temp-'a');
		System.out.println(temp);
	}
}
