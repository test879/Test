package com.cd.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getStringDateByFormat("2014-08-18","yyyy-MM-dd","yyyy年MM月dd日"));
	}
	
	public static String decimalFormat(){
		DecimalFormat df = new DecimalFormat("#,##0.00");
		BigDecimal bd1 = null;
		String charge = "1230.89";
		
		if(charge==null || charge.equals("0")){
			bd1 = new BigDecimal("0.00");
		}else{
			bd1 = new BigDecimal(charge);
		}
		;
		return df.format(bd1);
	}

	/**
	 * 取得指定格式的日期
	 * 
	 * @param stringDate
	 * @param format
	 * @return
	 */
	public static String getStringDateByFormat(String stringDate, String stringDateFormat,
			String stringFormat) {
		String stringDateTime = null;
		Date date = stringToDate(stringDate, stringFormat);
		SimpleDateFormat dateFormat = new SimpleDateFormat(stringFormat);
		try {
			stringDateTime = dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringDateTime;
	}
	
	/**
	 * 把String类型的日期转换成DATA类型
	 * 
	 * @param stringTime
	 * @param format
	 * @return
	 */
	public static Date stringToDate(String stringTime, String format) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			date = dateFormat.parse(stringTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
