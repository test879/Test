/**
 * FileName: CaldTest.java <br/>
 */
package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Project: Test <br/>
 * Class: com.test.CaldTest <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Company: www.xxxxxxxx.com <br/>
 * Makedate: 2014-4-17 下午05:49:13 <br/>
 * 
 * @author guanxl
 * @version 1.0
 * @since 1.0
 */
public class CalendarTest {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 1);
		Date date = c.getTime();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sd.format(date));
	}
}
