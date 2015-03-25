/**
 * FileName: Test.java <br/>
 */
package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Project: Test <br/>
 * Class: cn.ctdw.test.Test <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Company: www.xxxxxxxx.com <br/>
 * Makedate: 2014-4-29 下午05:48:23 <br/>
 * 
 * @author guanxl
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
//		String str1 = "abc";
//		String str2 = "abc";
//		String date = "|20150305|";
//		date = date.split("[|]")[3];
//		System.out.println(date);
		File file = new File("success.msg");
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(file, "r");
			System.out.println(raf.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
