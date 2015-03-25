package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:17:17 AM</li>
	 * <li>4、返回类型：boolean</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：比较日期大小</li>
	 * </ul>
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isCompareDate(String str1, String str2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = null;
		try {
			date2 = f.parse(str2);
			date1 = f.parse(str1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date1.before(date2);
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:17:31 AM</li>
	 * <li>4、返回类型：boolean</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：判断是否为该月最后一天</li>
	 * </ul>
	 * 
	 * @param theDataStr
	 * @return
	 */
	public static boolean isLastDayOfMonth(String theDataStr) {
		Date theDate = java.sql.Date.valueOf(theDataStr);
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		int nowDay = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int lowDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		if (nowDay == lowDayOfMonth) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:17:43 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到时间 yyyy-mm-dd hh:mm:ss</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getyyyy_MM_DDHHMISS() {
		String dt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:17:52 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到时间 yyyy-mm-dd hh-mm-ss</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getyyyy_MM_DD_HH_MI_SS() {
		String dt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
			Calendar cal = Calendar.getInstance();
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:17:52 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到时间 yyyy-mm-dd hh-mm-ss</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getTimeByFormatStr(String formatStr, Calendar cal) {
		String dt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:01 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：按指定格式得到当前工作日期和时间 yyyy-mm-dd hh:mm:ss</li>
	 * </ul>
	 * 
	 * @param workDate
	 * @return
	 */
	public static String getWorkDate_yyyy_MM_DDHHMISS(String workDate) {
		String returnDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(sdf.parse(workDate));// 系统日期
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String dTime = sdfTime.format(cal.getTime());// 额外添加时间
			returnDate = date + " " + dTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnDate;
	}

	public static String getDateFlag() {
		String returnDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());// 系统日期
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String dTime = sdfTime.format(cal.getTime());// 额外添加时间
			returnDate = date + "T" + dTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnDate;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:09 AM</li>
	 * <li>4、返回类型：String[]</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到某天所在的月的前一个月的1号和下一个月的1号</li>
	 * </ul>
	 * 
	 * @param baseDay
	 * @return
	 */
	public static final String[] getPreAndNextDayOfMonth(String baseDay) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		java.util.Date d = new java.util.Date();
		if (baseDay.equals("")) {
			baseDay = formatter.format(cal.getTime());
		}
		@SuppressWarnings("unused")
		String rtn = "";
		try {
			d = formatter.parse(baseDay);
			cal.setTime(d);
		} catch (ParseException ex) {
		}
		cal.add(Calendar.MONTH, -1);
		String start = formatter.format(cal.getTime());
		cal.add(Calendar.MONTH, 2);
		String end = formatter.format(cal.getTime());
		String[] result = new String[] { start, end };
		d = null;
		cal = null;
		formatter = null;
		start = null;
		end = null;
		return result;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:17 AM</li>
	 * <li>4、返回类型：String[]</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到某天所在的星期的星期一和星期日的日期</li>
	 * </ul>
	 * 
	 * @param baseDay
	 * @return
	 */
	public static final String[] getMondayAndSunDayOfWeek(String baseDay) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		if (baseDay.equals("")) {
			baseDay = formatter.format(cal.getTime());
		}
		int year = Integer.parseInt(baseDay.substring(0, 4));
		int month = Integer.parseInt(baseDay.substring(5, 7));
		int day = Integer.parseInt(baseDay.substring(8, 10));
		@SuppressWarnings("unused")
		int monday;
		@SuppressWarnings("unused")
		int sunday;

		GregorianCalendar gc;
		gc = new GregorianCalendar(year, month - 1, day); // /month-1，因为这里1是代表2月，2代表3月。。。。
		int today = gc.get(Calendar.DAY_OF_WEEK); // 代表今天是星期几，周日---周六 返回 1---7

		if (today == 1)
			today = 8;
		gc.add(Calendar.DATE, -today + 2); // 本来是-today+1
		// 获得本周第一天---周日的，要获得周一，只有+2了
		String start = formatter.format(gc.getTime());
		gc.add(Calendar.DATE, 6); // //从星期一变到到星期六，所以加上5天
		String end = formatter.format(gc.getTime());
		String[] result = new String[] { start, end };
		gc = null;
		cal = null;
		formatter = null;
		start = null;
		end = null;
		return result;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:27 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到时间 yyyymmdd</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getMMDDHHMISS() {
		String dt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
			Calendar cal = Calendar.getInstance();
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:35 AM</li>
	 * <li>4、返回类型：int</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：计算两个日期之间的天数</li>
	 * </ul>
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDaysBetweenDates(Date start, Date end) {
		boolean negative = false;
		// Date start_date = new Date(start);
		// Date end_date = new Date(end);
		if (end.before(start)) {
			negative = true;
			Date temp = start;
			start = end;
			end = temp;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(start);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		GregorianCalendar calEnd = new GregorianCalendar();
		calEnd.setTime(end);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);
		if (cal.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR)) {
			if (negative)
				return (calEnd.get(Calendar.DAY_OF_YEAR) - cal
						.get(Calendar.DAY_OF_YEAR))
						* -1;
			return calEnd.get(Calendar.DAY_OF_YEAR)
					- cal.get(Calendar.DAY_OF_YEAR);
		}
		int counter = 0;
		while (calEnd.after(cal)) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			counter++;
		}
		if (negative)
			return counter * -1;
		return counter;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:45 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到某天的日期和星期</li>
	 * </ul>
	 * 
	 * @param baseDay
	 * @return
	 */
	public static final String getDateWithWeek(String baseDay) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = new java.util.Date();
		String rtn = "";
		if (baseDay.equals("")) {
			formatter = new SimpleDateFormat("yyyy-MM-dd E");
			rtn = formatter.format(cal.getTime());
		} else {
			try {
				d = formatter.parse(baseDay);
				cal.setTime(d);
				formatter = new SimpleDateFormat("yyyy-MM-dd E");
				rtn = formatter.format(cal.getTime());
			} catch (ParseException ex) {

				// 如果传入的日期有问题,则直接返回当天的时间
				formatter = new SimpleDateFormat("yyyy-MM-dd E");
				rtn = formatter.format(cal.getTime());
			}
			cal = null;
			formatter = null;
			d = null;
		}
		return rtn;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:18:53 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：根据 日期 得到 字符串</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateToString(Date date) {
		String returnValue = "";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			returnValue = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:19:07 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：获得2007－01－02 22：22：22形式的时间</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;

	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:19:15 AM</li>
	 * <li>4、返回类型：Date</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：根据日期字符串 返回日期</li>
	 * </ul>
	 * 
	 * @param source
	 * @return
	 */
	public static Date getDateByString(String source) {
		SimpleDateFormat s = new SimpleDateFormat();
		Date dd = null;
		try {
			dd = s.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dd;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:19:26 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：获取指定格式"yyyy-MM-dd"的日期表达形式</li>
	 * </ul>
	 * 
	 * @param foramtStyle
	 * @param date
	 * @return
	 */
	public static String getFormatDate(String foramtStyle, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(foramtStyle);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:19:53 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：得到时间 yyyymmddhhmmss</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getyyyyMMDDHHMISS() {
		String dt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Calendar cal = Calendar.getInstance();
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Jul 15, 2010</li>
	 * <li>3、开发时间：11:20:07 AM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：获得当前日期，根据传进的分隔符，返回不同的形式 getCurrentDate("-");</li>
	 * </ul>
	 * 
	 * @param splitFlag
	 * @return
	 */
	public static String getCurrentDate(String splitFlag) {
		String dt = "";
		String source = "yyyy" + splitFlag + "MM" + splitFlag + "dd";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(source);
			Calendar cal = Calendar.getInstance();
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 获得20070102形式的时间
	 * 
	 * @return
	 */
	public static String getLogdate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getSysDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;

	}

	/**
	 * 根据传入的字符串，获取日期
	 * 
	 * @param dateValue
	 * @return
	 */
	public static Date getDate(String dateValue) {
		@SuppressWarnings("unused")
		DateFormat format = DateFormat.getDateInstance();
		Date d = null;
		String str[] = dateValue.split("[-]");
		// System.out.println(str.length);
		// System.out.println(dateValue.length());
		if (str.length == 1 && dateValue.length() == 8) {
			String dd = dateValue.substring(0, 4) + "-"
					+ dateValue.substring(4, 6) + "-"
					+ dateValue.substring(6, 8);
			// System.out.println(dd);

			// d=format.parse(dd);
			d = java.sql.Date.valueOf(dd);

		} else {
			if (str.length == 3 && dateValue.length() == 10) {
				/*
				 * try { d=format.parse(dateValue); } catch (ParseException e) { //
				 */
				d = java.sql.Date.valueOf(dateValue);
			}
		}
		return d;
	}

	// 获得两个日期(字符串)之间的天数
	public static int getDiffDays(String begin_dt, String end_dt) {
		Date end = java.sql.Date.valueOf(end_dt);
		Date begin = java.sql.Date.valueOf(begin_dt);
		int days = getDaysBetweenDates(begin, end);
		return days;
	}

	/**
	 * 指定日期，加上指定天数的正常工作日 遇周六、周日顺延
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	@SuppressWarnings( { "static-access", "deprecation" })
	public static Date addDay(Date date, int day) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, day);
		date = cal.getTime();

		if (date.getDay() == 6) {
			cal.add(cal.DATE, 2);
		} else if (date.getDay() == 0) {
			cal.add(cal.DATE, 1);
		}
		date = cal.getTime();
		/*
		 * System.out.println(date.getDay());
		 * System.out.println(cal.getTime().toLocaleString());
		 */
		return date;
	}

	/**
	 * 
	 * <ul>
	 * <li>1、开发作者：王亮</li>
	 * <li>2、开发日期：Oct 21, 2010</li>
	 * <li>3、开发时间：5:28:51 PM</li>
	 * <li>4、返回类型：String</li>
	 * <li>5、方法含义：</li>
	 * <li>6、方法说明：</li>
	 * </ul>
	 * 
	 * @param dateString
	 * @param month
	 * @param dateForm
	 * @return
	 */
	public static String addMonth(String dateString, int month, String dateForm) {
		Date date = stringToDate(dateString, dateForm);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.MONTH, month);
		date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(dateForm);

		return formatter.format(date);
	}

	/**
	 * 指定日期，加上指定天数的正常工作日 遇周六、周日顺延
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	@SuppressWarnings( { "static-access", "deprecation" })
	public static String addDay(String dateValue, int day) {
		Date date = getDate(dateValue);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, day);
		date = cal.getTime();

		if (date.getDay() == 6) {// 周六
			cal.add(cal.DATE, 2);
		} else if (date.getDay() == 0) {// 周日
			cal.add(cal.DATE, 1);
		}
		date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 获取某一天是一周中的第几天 ，其中0表示周日 1,2,3,4,5,6 分别标示周一到周六
	 * 
	 * @param datevale
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getWeekDate(String datevale) {
		Date date = getDate(datevale);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		date = cal.getTime();
		return date.getDay();
	}

	/**
	 * 天数固定加一
	 * 
	 * @param dateValue
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String addDay(String dateValue) {
		Date date = getDate(dateValue);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, 1);
		date = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}

	public static String addDayByNum(String dateValue, int dayNum) {
		Date date = getDate(dateValue);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, dayNum);
		date = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 天数固定加指定的数值
	 * 
	 * @param dateValue
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String addDays(String dateValue, int dayNum) {
		Date date = getDate(dateValue);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, dayNum);
		date = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 天数固定减一
	 * 
	 * @param dateValue
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String smallDay(String dateValue) {
		Date date = getDate(dateValue);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, -1);
		date = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 年固定加一
	 * 
	 * @param dateValue
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String addYear(String dateValue, int year) {
		Date date = getDate(dateValue);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.YEAR, year);
		date = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 公用的比较两个日期的大小
	 * 
	 * @param dateValue
	 * @param dateValues
	 * @return
	 */
	public static boolean compareDateCommon(Date d, Date d1) {
		int flag = d.compareTo(d1);
		if (flag <= 0) {
			return true;
		}

		System.out.println(flag);
		return false;
	}

	/**
	 * 公用的比较两个日期的大小
	 * 
	 * @param dateValue
	 * @param dateValues
	 * @return
	 */
	public static boolean compareDateCommonString(String dateValue,
			String dateValues) {
		Date d = getDate(dateValue);
		Date d1 = getDate(dateValues);

		int flag = d.compareTo(d1);
		if (flag <= 0) {
			return true;
		}

		System.out.println(flag);
		return false;
	}

	/**
	 * 返回两个日期之间的天数
	 * 
	 * @param firstDay
	 * @param secondDay
	 * @return
	 */
	public static int getDays(String firstDay, String secondDay) {
		long day = 0;
		Calendar calendar = Calendar.getInstance();
		java.util.Date first = DateUtils.getDate(firstDay);
		java.util.Date second = DateUtils.getDate(secondDay);
		calendar.setTime(first);
		long timethis = calendar.getTimeInMillis();
		calendar.setTime(second);
		long timeend = calendar.getTimeInMillis();
		day = (long) (timeend - timethis) / (1000 * 60 * 60 * 24);
		return (int) day;
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date stringToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	// 计算当月最后一天,返回字符串
	public String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 上月第一天
	public String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获取当月第一天
	public String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获取当天时间
	public static String getNowTime(String dateformat) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
		String hehe = dateFormat.format(now);
		return hehe;
	}

	// 获得当前日期与本周日相差的天数
	private int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	// 获得下周星期日的日期
	public String getNextSunday() {

		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上月最后一天的日期
	public String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得下个月第一天的日期
	public String getNextMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得下个月最后一天的日期
	public String getNextMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 加一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得明年最后一天的日期
	public String getNextYearEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获得明年第一天的日期
	public String getNextYearFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		str = sdf.format(lastDate.getTime());
		return str;

	}

	// 获得本年有多少天
	@SuppressWarnings("unused")
	private int getMaxYear() {
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		return MaxYear;
	}

	private int getYearPlus() {
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1) {
			return -MaxYear;
		} else {
			return 1 - yearOfNumber;
		}
	}

	// 获得本年第一天的日期
	public String getCurrentYearFirst() {
		int yearPlus = this.getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus);
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		return preYearDay;
	}

	// 获得本年最后一天的日期 *
	public String getCurrentYearEnd() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		return years + "-12-31";
	}

	// 获得上年第一天的日期 *
	public String getPreviousYearFirst() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);
		years_value--;
		return years_value + "-1-1";
	}

	/**
	 * 判断是否是当天日期
	 * 
	 * @param args
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static boolean isToday(String args) {
		boolean result = false;
		FileUtils fileUtils = new FileUtils();
		String sysTimeYYYYMMDD = fileUtils.timeStamp(false);// 系统时间
		if (args != null && !"".equals(args)) {// 参数值不为空
			if (args.equals(sysTimeYYYYMMDD)) {// 参数值与系统时间相等
				result = true;
			}
		}
		return result;
	}

	public static void main(String args[]) throws ParseException {
		System.out.println(getStringDateByFormat("2014-10-10", "yyyy-MM-dd", "yyyy年MM月dd日"));
	}

	/**
	 * 根据strDate取得num天之后的日期
	 * 
	 * @param dateTime
	 * @param num
	 * @return
	 * @throws ParseException
	 */
	public static String getAfterDateByNum(String strDate, int num)
			throws ParseException {
		String futureDate = null;
		Date date = null;
		date = stringToDate(strDate, "yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + num);
		date = cal.getTime();
		futureDate = getFormatDate("yyyy-MM-dd", date);
		return futureDate;
	}

	/**
	 * 根据strDate取得num天之前的日期
	 * 
	 * @param strDate
	 * @param num
	 * @return
	 * @throws ParseException
	 */
	public static String getBeforeDateByNum(String strDate, int num)
			throws ParseException {
		String futureDate = null;
		Date date = null;
		date = stringToDate(strDate, "yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - num);
		date = cal.getTime();
		futureDate = getFormatDate("yyyy-MM-dd", date);
		return futureDate;
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

	/**
	 * 取得指定格式的日期
	 * 
	 * @param stringDate
	 * @param stringDateFormat stringDate的日期格式类型
	 * @param stringFormat 要转换的日期类型
	 * @return
	 */
	public static String getStringDateByFormat(String stringDate, String stringDateFormat,
			String stringFormat) {
		String stringDateTime = null;
		Date date = stringToDate(stringDate, stringDateFormat);
		SimpleDateFormat dateFormat = new SimpleDateFormat(stringFormat);
		try {
			stringDateTime = dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringDateTime;
	}

	/**
	 * 是否闰年
	 * 
	 * @param year
	 *            年
	 * @return
	 */
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * 获得本季度
	 * 
	 * @return
	 */
	public String getThisSeasonTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days
				+ ";" + years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	/**
	 * 获取某年某月的最后一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 最后一天
	 */
	private int getLastDayOfMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		return 0;
	}

	/**
	 * 
	 * 返回制定日期所在的周是一年中的第几个周。<br>
	 * 
	 * created by wangmj at 20060324.<br>
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * 范围1-12<br>
	 * 
	 * @param day
	 * 
	 * @return int
	 * 
	 */

	public static int getWeekOfYear(String year, String month, String day) {

		Calendar cal = new GregorianCalendar();

		cal.clear();

		cal.set(new Integer(year).intValue(),

		new Integer(month).intValue() - 1, new Integer(day).intValue());

		return cal.get(Calendar.WEEK_OF_YEAR);

	}

	/**
	 * 
	 * 返回当前日期是星期几。例如：星期日、星期一、星期六等等。
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * 格式为 yyyy/MM/dd 或者 yyyy-MM-dd
	 * 
	 * @return 返回当前日期是星期几
	 * 
	 */

	public static String getChinaDayOfWeek(String date) {

		String[] weeks = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四",

		"星期五", "星期六" };

		int week = getDayOfWeek(date);

		return weeks[week - 1];

	}

	/**
	 * 
	 * 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * 
	 * 
	 * @return 返回一个代表当期日期是星期几的数字。1表示星期天、2表示星期一、7表示星期六。
	 * 
	 */

	public static int getDayOfWeek(Date date) {

		Calendar cal = new GregorianCalendar();

		cal.setTime(date);

		return cal.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 
	 * 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * "yyyy/MM/dd",或者"yyyy-MM-dd"
	 * 
	 * @return 返回一个代表当期日期是星期几的数字。1表示星期天、2表示星期一、7表示星期六。
	 * 
	 */

	public static int getDayOfWeek(String date) {

		String[] temp = null;

		if (date.indexOf("/") > 0) {

			temp = date.split("/");

		}

		if (date.indexOf("-") > 0) {

			temp = date.split("-");

		}

		return getDayOfWeek(temp[0], temp[1], temp[2]);

	}

	/**
	 * 
	 * 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * month是从1开始的12结束
	 * 
	 * @param day
	 * 
	 * @return 返回一个代表当期日期是星期几的数字。1表示星期天、2表示星期一、7表示星期六。
	 * 
	 */

	public static int getDayOfWeek(String year, String month, String day) {

		Calendar cal = new GregorianCalendar(new Integer(year).intValue(),

		new Integer(month).intValue() - 1, new Integer(day).intValue());

		return cal.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 
	 * 返回指定为年度为year月度month的月份内，第weekOfMonth个星期的第dayOfWeek天是当月的几号。<br>
	 * 
	 * 00 00 00 01 02 03 04 <br>
	 * 
	 * 05 06 07 08 09 10 11<br>
	 * 
	 * 12 13 14 15 16 17 18<br>
	 * 
	 * 19 20 21 22 23 24 25<br>
	 * 
	 * 26 27 28 29 30 31 <br>
	 * 
	 * 2006年的第一个周的1到7天为：05 06 07 01 02 03 04 <br>
	 * 
	 * 2006年的第二个周的1到7天为：12 13 14 08 09 10 11 <br>
	 * 
	 * 2006年的第三个周的1到7天为：19 20 21 15 16 17 18 <br>
	 * 
	 * 2006年的第四个周的1到7天为：26 27 28 22 23 24 25 <br>
	 * 
	 * 2006年的第五个周的1到7天为：02 03 04 29 30 31 01 。本月没有就自动转到下个月了。
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * 形式为yyyy <br>
	 * 
	 * @param month
	 * 
	 * 形式为MM,参数值在[1-12]。<br>
	 * 
	 * @param weekOfMonth
	 * 
	 * 在[1-6],因为一个月最多有6个周。<br>
	 * 
	 * @param dayOfWeek
	 * 
	 * 数字在1到7之间，包括1和7。1表示星期天，7表示星期六<br>
	 * 
	 * -6为星期日-1为星期五，0为星期六 <br>
	 * 
	 * @return <type>int</type>
	 * 
	 */

	public static int getDayofWeekInMonth(String year, String month,

	String weekOfMonth, String dayOfWeek) {

		Calendar cal = new GregorianCalendar();

		// 在具有默认语言环境的默认时区内使用当前时间构造一个默认的 GregorianCalendar。

		int y = new Integer(year).intValue();

		int m = new Integer(month).intValue();

		cal.clear();// 不保留以前的设置

		cal.set(y, m - 1, 1);// 将日期设置为本月的第一天。

		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, new Integer(weekOfMonth)

		.intValue());

		cal.set(Calendar.DAY_OF_WEEK, new Integer(dayOfWeek).intValue());

		return cal.get(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 
	 * 根据指定的年月 返回指定月份（yyyy-MM）有多少天。
	 * 
	 * 
	 * 
	 * @param time
	 * 
	 * yyyy-MM
	 * 
	 * @return 天数，指定月份的天数。
	 * 
	 */

	public static int getDaysOfCurMonth(final String time) {

		if (time.length() != 7) {

			throw new NullPointerException("参数的格式必须是yyyy-MM");

		}

		String[] timeArray = time.split("-");

		int curyear = new Integer(timeArray[0]).intValue(); // 当前年份

		int curMonth = new Integer(timeArray[1]).intValue();// 当前月份

		if (curMonth > 12) {

			throw new NullPointerException("参数的格式必须是yyyy-MM，而且月份必须小于等于12。");

		}

		int mArray[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,

		31 };

		// 判断闰年的情况 ，2月份有29天；

		if ((curyear % 400 == 0)

		|| ((curyear % 100 != 0) && (curyear % 4 == 0))) {

			mArray[1] = 29;

		}

		if (curMonth == 12) {

			return mArray[0];

		}

		return mArray[curMonth - 1];

		// 如果要返回下个月的天数，注意处理月份12的情况，防止数组越界；

		// 如果要返回上个月的天数，注意处理月份1的情况，防止数组越界；

	}

	/**
	 * 
	 * 
	 * 
	 * @return 当前月份有多少天；
	 * 
	 */

	public static int getDaysOfCurMonth() {

		int curyear = new Integer(getCurrentYear()).intValue(); // 当前年份

		int curMonth = new Integer(getCurrentMonth()).intValue();// 当前月份

		int mArray[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,

		31 };

		// 判断闰年的情况 ，2月份有29天；

		if ((curyear % 400 == 0)

		|| ((curyear % 100 != 0) && (curyear % 4 == 0))) {

			mArray[1] = 29;

		}

		return mArray[curMonth - 1];

		// 如果要返回下个月的天数，注意处理月份12的情况，防止数组越界；

		// 如果要返回上个月的天数，注意处理月份1的情况，防止数组越界；

	}

	/**
	 * 
	 * 取得当前日期的年份，以yyyy格式返回.
	 * 
	 * 
	 * 
	 * @return 当年 yyyy
	 * 
	 */

	public static String getCurrentYear() {

		return getFormatCurrentTime("yyyy");

	}

	/**
	 * 
	 * 取得当前日期的月份，以MM格式返回.
	 * 
	 * 
	 * 
	 * @return 当前月份 MM
	 * 
	 */

	public static String getCurrentMonth() {

		return getFormatCurrentTime("MM");

	}

	/**
	 * 
	 * 根据给定的格式，返回时间字符串。
	 * 
	 * <p>
	 * 
	 * 格式参照类描绘中说明.和方法getFormatDate是一样的。
	 * 
	 * 
	 * 
	 * @param format
	 * 
	 * 日期格式字符串
	 * 
	 * @return String 指定格式的日期字符串.
	 * 
	 */

	public static String getFormatCurrentTime(String format) {

		return getFormatDateTime(new Date(), format);

	}

	/**
	 * 
	 * 根据给定的格式与时间(Date类型的)，返回时间字符串。最为通用。<br>
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * 指定的日期
	 * 
	 * @param format
	 * 
	 * 日期格式字符串
	 * 
	 * @return String 指定格式的日期字符串.
	 * 
	 */

	public static String getFormatDateTime(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(date);

	}

	/**
	 * 
	 * 起始年月yyyy-MM与终止月yyyy-MM之间跨度的月数。
	 * 
	 * 
	 * 
	 * @param beginMonth
	 * 
	 * 格式为yyyy-MM
	 * 
	 * @param endMonth
	 * 
	 * 格式为yyyy-MM
	 * 
	 * @return 整数。
	 * 
	 */

	public static int getInterval(String beginMonth, String endMonth) {

		int intBeginYear = Integer.parseInt(beginMonth.substring(0, 4));

		int intBeginMonth = Integer.parseInt(beginMonth.substring(beginMonth

		.indexOf("-") + 1));

		int intEndYear = Integer.parseInt(endMonth.substring(0, 4));

		int intEndMonth = Integer.parseInt(endMonth.substring(endMonth

		.indexOf("-") + 1));

		return ((intEndYear - intBeginYear) * 12)

		+ (intEndMonth - intBeginMonth) + 1;

	}

	/**
	 * 1 第一季度 2 第二季度 3 第三季度 4 第四季度 318. * 319. *
	 * 
	 * @param date
	 *            320. *
	 * @return 321.
	 */
	public static int getSeason(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return season;
	}

	/*
	 * 取得季度月 @param date @return
	 */
	public static Date[] getSeasonDate(Date date) {
		Date[] season = new Date[3];

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int nSeason = getSeason(date);
		if (nSeason == 1) {// 第一季度
			c.set(Calendar.MONTH, Calendar.JANUARY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.FEBRUARY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MARCH);
			season[2] = c.getTime();
		} else if (nSeason == 2) {// 第二季度
			c.set(Calendar.MONTH, Calendar.APRIL);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MAY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.JUNE);
			season[2] = c.getTime();
		} else if (nSeason == 3) {// 第三季度
			c.set(Calendar.MONTH, Calendar.JULY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.AUGUST);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			season[2] = c.getTime();
		} else if (nSeason == 4) {// 第四季度
			c.set(Calendar.MONTH, Calendar.OCTOBER);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.NOVEMBER);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			season[2] = c.getTime();
		}
		return season;
	}

	/**
	 * 取得季度已过天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getPassDayOfSeason(Date date) {
		int day = 0;

		Date[] seasonDates = getSeasonDate(date);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);

		if (month == Calendar.JANUARY || month == Calendar.APRIL
				|| month == Calendar.JULY || month == Calendar.OCTOBER) {// 季度第一个月
			day = getPassDayOfMonth(seasonDates[0]);
		} else if (month == Calendar.FEBRUARY || month == Calendar.MAY
				|| month == Calendar.AUGUST || month == Calendar.NOVEMBER) {// 季度第二个月
			day = getDayOfMonth(seasonDates[0])
					+ getPassDayOfMonth(seasonDates[1]);
		} else if (month == Calendar.MARCH || month == Calendar.JUNE
				|| month == Calendar.SEPTEMBER || month == Calendar.DECEMBER) {// 季度第三个月
			day = getDayOfMonth(seasonDates[0]) + getDayOfMonth(seasonDates[1])
					+ getPassDayOfMonth(seasonDates[2]);
		}
		return day;
	}

	/**
	 * 取得季度剩余天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDayOfSeason(Date date) {
		return getDayOfSeason(date) - getPassDayOfSeason(date);
	}

	/**
	 * 取得季度天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfSeason(Date date) {
		int day = 0;
		Date[] seasonDates = getSeasonDate(date);
		for (Date date2 : seasonDates) {
			day += getDayOfMonth(date2);
		}
		return day;
	}

	/**
	 * 取得季度最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfSeason(Date date) {
		return getLastDateOfMonth(getSeasonDate(date)[2]);
	}

	/**
	 * 取得季度第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfSeason(Date date) {
		return getFirstDateOfMonth(getSeasonDate(date)[0]);
	}

	/**
	 * 取得月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得月的剩余天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDayOfMonth(Date date) {
		int dayOfMonth = getDayOfMonth(date);
		int day = getPassDayOfMonth(date);
		return dayOfMonth - day;
	}

	/**
	 * 取得月已经过的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getPassDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(String date, String formate) {
		Calendar c = Calendar.getInstance();
		c.setTime(stringToDate(date, formate));
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	public static String getFormatDate(String consigndate) {
		String dt = consigndate.replaceAll("-", "");
		return dt;

	}
	/**
	    * 日期加-
	    * @param date
	    * @return
	    */
	   public static String getDateNotSplit(String date){
		   if(date!=null&&!date.trim().equals("")&&date.length()>=8){
			   if(date.contains("-")){
				   return date;
			   }
			   String result=date.substring(0, 4)+"-"+date.substring(4,6)+"-"+date.substring(6, 8);
			   return result;
		   }
		   return "";
		  
		   
	   }

}
