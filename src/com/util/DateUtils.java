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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:17:17 AM</li>
	 * <li>4���������ͣ�boolean</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����Ƚ����ڴ�С</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:17:31 AM</li>
	 * <li>4���������ͣ�boolean</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����ж��Ƿ�Ϊ�������һ��</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:17:43 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ʱ�� yyyy-mm-dd hh:mm:ss</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:17:52 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ʱ�� yyyy-mm-dd hh-mm-ss</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:17:52 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ʱ�� yyyy-mm-dd hh-mm-ss</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:01 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵������ָ����ʽ�õ���ǰ�������ں�ʱ�� yyyy-mm-dd hh:mm:ss</li>
	 * </ul>
	 * 
	 * @param workDate
	 * @return
	 */
	public static String getWorkDate_yyyy_MM_DDHHMISS(String workDate) {
		String returnDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(sdf.parse(workDate));// ϵͳ����
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String dTime = sdfTime.format(cal.getTime());// ��������ʱ��
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
			String date = sdf.format(new Date());// ϵͳ����
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String dTime = sdfTime.format(cal.getTime());// ��������ʱ��
			returnDate = date + "T" + dTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnDate;
	}

	/**
	 * 
	 * <ul>
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:09 AM</li>
	 * <li>4���������ͣ�String[]</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ĳ�����ڵ��µ�ǰһ���µ�1�ź���һ���µ�1��</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:17 AM</li>
	 * <li>4���������ͣ�String[]</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ĳ�����ڵ����ڵ�����һ�������յ�����</li>
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
		gc = new GregorianCalendar(year, month - 1, day); // /month-1����Ϊ����1�Ǵ���2�£�2����3�¡�������
		int today = gc.get(Calendar.DAY_OF_WEEK); // �������������ڼ�������---���� ���� 1---7

		if (today == 1)
			today = 8;
		gc.add(Calendar.DATE, -today + 2); // ������-today+1
		// ��ñ��ܵ�һ��---���յģ�Ҫ�����һ��ֻ��+2��
		String start = formatter.format(gc.getTime());
		gc.add(Calendar.DATE, 6); // //������һ�䵽�������������Լ���5��
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:27 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ʱ�� yyyymmdd</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:35 AM</li>
	 * <li>4���������ͣ�int</li>
	 * <li>5���������壺</li>
	 * <li>6������˵����������������֮�������</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:45 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ĳ������ں�����</li>
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

				// ������������������,��ֱ�ӷ��ص����ʱ��
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:18:53 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�������� ���� �õ� �ַ���</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:19:07 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�������2007��01��02 22��22��22��ʽ��ʱ��</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:19:15 AM</li>
	 * <li>4���������ͣ�Date</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�������������ַ��� ��������</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:19:26 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵������ȡָ����ʽ"yyyy-MM-dd"�����ڱ�����ʽ</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:19:53 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵�����õ�ʱ�� yyyymmddhhmmss</li>
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Jul 15, 2010</li>
	 * <li>3������ʱ�䣺11:20:07 AM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵������õ�ǰ���ڣ����ݴ����ķָ��������ز�ͬ����ʽ getCurrentDate("-");</li>
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
	 * ���20070102��ʽ��ʱ��
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
	 * ���ݴ�����ַ�������ȡ����
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

	// �����������(�ַ���)֮�������
	public static int getDiffDays(String begin_dt, String end_dt) {
		Date end = java.sql.Date.valueOf(end_dt);
		Date begin = java.sql.Date.valueOf(begin_dt);
		int days = getDaysBetweenDates(begin, end);
		return days;
	}

	/**
	 * ָ�����ڣ�����ָ������������������ ������������˳��
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
	 * <li>1���������ߣ�����</li>
	 * <li>2���������ڣ�Oct 21, 2010</li>
	 * <li>3������ʱ�䣺5:28:51 PM</li>
	 * <li>4���������ͣ�String</li>
	 * <li>5���������壺</li>
	 * <li>6������˵����</li>
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
	 * ָ�����ڣ�����ָ������������������ ������������˳��
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

		if (date.getDay() == 6) {// ����
			cal.add(cal.DATE, 2);
		} else if (date.getDay() == 0) {// ����
			cal.add(cal.DATE, 1);
		}
		date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * ��ȡĳһ����һ���еĵڼ��� ������0��ʾ���� 1,2,3,4,5,6 �ֱ��ʾ��һ������
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
	 * �����̶���һ
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
	 * �����̶���ָ������ֵ
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
	 * �����̶���һ
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
	 * ��̶���һ
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
	 * ���õıȽ��������ڵĴ�С
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
	 * ���õıȽ��������ڵĴ�С
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
	 * ������������֮�������
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
	 * �õ��������ڼ�ļ������
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
	 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd
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

	// ���㵱�����һ��,�����ַ���
	public String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
		lastDate.add(Calendar.MONTH, 1);// ��һ���£���Ϊ���µ�1��
		lastDate.add(Calendar.DATE, -1);// ��ȥһ�죬��Ϊ�������һ��

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ���µ�һ��
	public String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
		lastDate.add(Calendar.MONTH, -1);// ��һ���£���Ϊ���µ�1��
		// lastDate.add(Calendar.DATE,-1);//��ȥһ�죬��Ϊ�������һ��

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ��ȡ���µ�һ��
	public String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ��ȡ����ʱ��
	public static String getNowTime(String dateformat) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// ���Է�����޸����ڸ�ʽ
		String hehe = dateFormat.format(now);
		return hehe;
	}

	// ��õ�ǰ�����뱾������������
	private int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// ��ý�����һ�ܵĵڼ��죬�������ǵ�һ�죬���ڶ��ǵڶ���......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // ��Ϊ���й����һ��Ϊ��һ�����������1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	// ������������յ�����
	public String getNextSunday() {

		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// ����������һ�������
	public String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// ��һ����
		lastDate.set(Calendar.DATE, 1);// ����������Ϊ���µ�һ��
		lastDate.roll(Calendar.DATE, -1);// ���ڻع�һ�죬Ҳ���Ǳ������һ��
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ����¸��µ�һ�������
	public String getNextMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// ��һ����
		lastDate.set(Calendar.DATE, 1);// ����������Ϊ���µ�һ��
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ����¸������һ�������
	public String getNextMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// ��һ����
		lastDate.set(Calendar.DATE, 1);// ����������Ϊ���µ�һ��
		lastDate.roll(Calendar.DATE, -1);// ���ڻع�һ�죬Ҳ���Ǳ������һ��
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ����������һ�������
	public String getNextYearEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// ��һ����
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ��������һ�������
	public String getNextYearFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// ��һ����
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		str = sdf.format(lastDate.getTime());
		return str;

	}

	// ��ñ����ж�����
	@SuppressWarnings("unused")
	private int getMaxYear() {
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DAY_OF_YEAR, 1);// ��������Ϊ�����һ��
		cd.roll(Calendar.DAY_OF_YEAR, -1);// �����ڻع�һ�졣
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		return MaxYear;
	}

	private int getYearPlus() {
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// ��õ�����һ���еĵڼ���
		cd.set(Calendar.DAY_OF_YEAR, 1);// ��������Ϊ�����һ��
		cd.roll(Calendar.DAY_OF_YEAR, -1);// �����ڻع�һ�졣
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1) {
			return -MaxYear;
		} else {
			return 1 - yearOfNumber;
		}
	}

	// ��ñ����һ�������
	public String getCurrentYearFirst() {
		int yearPlus = this.getYearPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, yearPlus);
		Date yearDay = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);
		return preYearDay;
	}

	// ��ñ������һ������� *
	public String getCurrentYearEnd() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// ���Է�����޸����ڸ�ʽ
		String years = dateFormat.format(date);
		return years + "-12-31";
	}

	// ��������һ������� *
	public String getPreviousYearFirst() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// ���Է�����޸����ڸ�ʽ
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);
		years_value--;
		return years_value + "-1-1";
	}

	/**
	 * �ж��Ƿ��ǵ�������
	 * 
	 * @param args
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static boolean isToday(String args) {
		boolean result = false;
		FileUtils fileUtils = new FileUtils();
		String sysTimeYYYYMMDD = fileUtils.timeStamp(false);// ϵͳʱ��
		if (args != null && !"".equals(args)) {// ����ֵ��Ϊ��
			if (args.equals(sysTimeYYYYMMDD)) {// ����ֵ��ϵͳʱ�����
				result = true;
			}
		}
		return result;
	}

	public static void main(String args[]) throws ParseException {
		System.out.println(getStringDateByFormat("2014-10-10", "yyyy-MM-dd", "yyyy��MM��dd��"));
	}

	/**
	 * ����strDateȡ��num��֮�������
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
	 * ����strDateȡ��num��֮ǰ������
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
	 * ��String���͵�����ת����DATA����
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
	 * ȡ��ָ����ʽ������
	 * 
	 * @param stringDate
	 * @param stringDateFormat stringDate�����ڸ�ʽ����
	 * @param stringFormat Ҫת������������
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
	 * �Ƿ�����
	 * 
	 * @param year
	 *            ��
	 * @return
	 */
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * ��ñ�����
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// ���Է�����޸����ڸ�ʽ
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days
				+ ";" + years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	/**
	 * ��ȡĳ��ĳ�µ����һ��
	 * 
	 * @param year
	 *            ��
	 * @param month
	 *            ��
	 * @return ���һ��
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
	 * �����ƶ��������ڵ�����һ���еĵڼ����ܡ�<br>
	 * 
	 * created by wangmj at 20060324.<br>
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * ��Χ1-12<br>
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
	 * ���ص�ǰ���������ڼ������磺�����ա�����һ���������ȵȡ�
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * ��ʽΪ yyyy/MM/dd ���� yyyy-MM-dd
	 * 
	 * @return ���ص�ǰ���������ڼ�
	 * 
	 */

	public static String getChinaDayOfWeek(String date) {

		String[] weeks = new String[] { "������", "����һ", "���ڶ�", "������", "������",

		"������", "������" };

		int week = getDayOfWeek(date);

		return weeks[week - 1];

	}

	/**
	 * 
	 * ����ָ�����ꡢ�¡��շ��ص�ǰ�����ڼ���1��ʾ�����졢2��ʾ����һ��7��ʾ��������
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * 
	 * 
	 * @return ����һ�������������������ڼ������֡�1��ʾ�����졢2��ʾ����һ��7��ʾ��������
	 * 
	 */

	public static int getDayOfWeek(Date date) {

		Calendar cal = new GregorianCalendar();

		cal.setTime(date);

		return cal.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 
	 * ����ָ�����ꡢ�¡��շ��ص�ǰ�����ڼ���1��ʾ�����졢2��ʾ����һ��7��ʾ��������
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * "yyyy/MM/dd",����"yyyy-MM-dd"
	 * 
	 * @return ����һ�������������������ڼ������֡�1��ʾ�����졢2��ʾ����һ��7��ʾ��������
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
	 * ����ָ�����ꡢ�¡��շ��ص�ǰ�����ڼ���1��ʾ�����졢2��ʾ����һ��7��ʾ��������
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * month�Ǵ�1��ʼ��12����
	 * 
	 * @param day
	 * 
	 * @return ����һ�������������������ڼ������֡�1��ʾ�����졢2��ʾ����һ��7��ʾ��������
	 * 
	 */

	public static int getDayOfWeek(String year, String month, String day) {

		Calendar cal = new GregorianCalendar(new Integer(year).intValue(),

		new Integer(month).intValue() - 1, new Integer(day).intValue());

		return cal.get(Calendar.DAY_OF_WEEK);

	}

	/**
	 * 
	 * ����ָ��Ϊ���Ϊyear�¶�month���·��ڣ���weekOfMonth�����ڵĵ�dayOfWeek���ǵ��µļ��š�<br>
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
	 * 2006��ĵ�һ���ܵ�1��7��Ϊ��05 06 07 01 02 03 04 <br>
	 * 
	 * 2006��ĵڶ����ܵ�1��7��Ϊ��12 13 14 08 09 10 11 <br>
	 * 
	 * 2006��ĵ������ܵ�1��7��Ϊ��19 20 21 15 16 17 18 <br>
	 * 
	 * 2006��ĵ��ĸ��ܵ�1��7��Ϊ��26 27 28 22 23 24 25 <br>
	 * 
	 * 2006��ĵ�����ܵ�1��7��Ϊ��02 03 04 29 30 31 01 ������û�о��Զ�ת���¸����ˡ�
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * ��ʽΪyyyy <br>
	 * 
	 * @param month
	 * 
	 * ��ʽΪMM,����ֵ��[1-12]��<br>
	 * 
	 * @param weekOfMonth
	 * 
	 * ��[1-6],��Ϊһ���������6���ܡ�<br>
	 * 
	 * @param dayOfWeek
	 * 
	 * ������1��7֮�䣬����1��7��1��ʾ�����죬7��ʾ������<br>
	 * 
	 * -6Ϊ������-1Ϊ�����壬0Ϊ������ <br>
	 * 
	 * @return <type>int</type>
	 * 
	 */

	public static int getDayofWeekInMonth(String year, String month,

	String weekOfMonth, String dayOfWeek) {

		Calendar cal = new GregorianCalendar();

		// �ھ���Ĭ�����Ի�����Ĭ��ʱ����ʹ�õ�ǰʱ�乹��һ��Ĭ�ϵ� GregorianCalendar��

		int y = new Integer(year).intValue();

		int m = new Integer(month).intValue();

		cal.clear();// ��������ǰ������

		cal.set(y, m - 1, 1);// ����������Ϊ���µĵ�һ�졣

		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, new Integer(weekOfMonth)

		.intValue());

		cal.set(Calendar.DAY_OF_WEEK, new Integer(dayOfWeek).intValue());

		return cal.get(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 
	 * ����ָ�������� ����ָ���·ݣ�yyyy-MM���ж����졣
	 * 
	 * 
	 * 
	 * @param time
	 * 
	 * yyyy-MM
	 * 
	 * @return ������ָ���·ݵ�������
	 * 
	 */

	public static int getDaysOfCurMonth(final String time) {

		if (time.length() != 7) {

			throw new NullPointerException("�����ĸ�ʽ������yyyy-MM");

		}

		String[] timeArray = time.split("-");

		int curyear = new Integer(timeArray[0]).intValue(); // ��ǰ���

		int curMonth = new Integer(timeArray[1]).intValue();// ��ǰ�·�

		if (curMonth > 12) {

			throw new NullPointerException("�����ĸ�ʽ������yyyy-MM�������·ݱ���С�ڵ���12��");

		}

		int mArray[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,

		31 };

		// �ж��������� ��2�·���29�죻

		if ((curyear % 400 == 0)

		|| ((curyear % 100 != 0) && (curyear % 4 == 0))) {

			mArray[1] = 29;

		}

		if (curMonth == 12) {

			return mArray[0];

		}

		return mArray[curMonth - 1];

		// ���Ҫ�����¸��µ�������ע�⴦���·�12���������ֹ����Խ�磻

		// ���Ҫ�����ϸ��µ�������ע�⴦���·�1���������ֹ����Խ�磻

	}

	/**
	 * 
	 * 
	 * 
	 * @return ��ǰ�·��ж����죻
	 * 
	 */

	public static int getDaysOfCurMonth() {

		int curyear = new Integer(getCurrentYear()).intValue(); // ��ǰ���

		int curMonth = new Integer(getCurrentMonth()).intValue();// ��ǰ�·�

		int mArray[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,

		31 };

		// �ж��������� ��2�·���29�죻

		if ((curyear % 400 == 0)

		|| ((curyear % 100 != 0) && (curyear % 4 == 0))) {

			mArray[1] = 29;

		}

		return mArray[curMonth - 1];

		// ���Ҫ�����¸��µ�������ע�⴦���·�12���������ֹ����Խ�磻

		// ���Ҫ�����ϸ��µ�������ע�⴦���·�1���������ֹ����Խ�磻

	}

	/**
	 * 
	 * ȡ�õ�ǰ���ڵ���ݣ���yyyy��ʽ����.
	 * 
	 * 
	 * 
	 * @return ���� yyyy
	 * 
	 */

	public static String getCurrentYear() {

		return getFormatCurrentTime("yyyy");

	}

	/**
	 * 
	 * ȡ�õ�ǰ���ڵ��·ݣ���MM��ʽ����.
	 * 
	 * 
	 * 
	 * @return ��ǰ�·� MM
	 * 
	 */

	public static String getCurrentMonth() {

		return getFormatCurrentTime("MM");

	}

	/**
	 * 
	 * ���ݸ����ĸ�ʽ������ʱ���ַ�����
	 * 
	 * <p>
	 * 
	 * ��ʽ�����������˵��.�ͷ���getFormatDate��һ���ġ�
	 * 
	 * 
	 * 
	 * @param format
	 * 
	 * ���ڸ�ʽ�ַ���
	 * 
	 * @return String ָ����ʽ�������ַ���.
	 * 
	 */

	public static String getFormatCurrentTime(String format) {

		return getFormatDateTime(new Date(), format);

	}

	/**
	 * 
	 * ���ݸ����ĸ�ʽ��ʱ��(Date���͵�)������ʱ���ַ�������Ϊͨ�á�<br>
	 * 
	 * 
	 * 
	 * @param date
	 * 
	 * ָ��������
	 * 
	 * @param format
	 * 
	 * ���ڸ�ʽ�ַ���
	 * 
	 * @return String ָ����ʽ�������ַ���.
	 * 
	 */

	public static String getFormatDateTime(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(date);

	}

	/**
	 * 
	 * ��ʼ����yyyy-MM����ֹ��yyyy-MM֮���ȵ�������
	 * 
	 * 
	 * 
	 * @param beginMonth
	 * 
	 * ��ʽΪyyyy-MM
	 * 
	 * @param endMonth
	 * 
	 * ��ʽΪyyyy-MM
	 * 
	 * @return ������
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
	 * 1 ��һ���� 2 �ڶ����� 3 �������� 4 ���ļ��� 318. * 319. *
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
	 * ȡ�ü����� @param date @return
	 */
	public static Date[] getSeasonDate(Date date) {
		Date[] season = new Date[3];

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int nSeason = getSeason(date);
		if (nSeason == 1) {// ��һ����
			c.set(Calendar.MONTH, Calendar.JANUARY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.FEBRUARY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MARCH);
			season[2] = c.getTime();
		} else if (nSeason == 2) {// �ڶ�����
			c.set(Calendar.MONTH, Calendar.APRIL);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MAY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.JUNE);
			season[2] = c.getTime();
		} else if (nSeason == 3) {// ��������
			c.set(Calendar.MONTH, Calendar.JULY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.AUGUST);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			season[2] = c.getTime();
		} else if (nSeason == 4) {// ���ļ���
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
	 * ȡ�ü����ѹ�����
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
				|| month == Calendar.JULY || month == Calendar.OCTOBER) {// ���ȵ�һ����
			day = getPassDayOfMonth(seasonDates[0]);
		} else if (month == Calendar.FEBRUARY || month == Calendar.MAY
				|| month == Calendar.AUGUST || month == Calendar.NOVEMBER) {// ���ȵڶ�����
			day = getDayOfMonth(seasonDates[0])
					+ getPassDayOfMonth(seasonDates[1]);
		} else if (month == Calendar.MARCH || month == Calendar.JUNE
				|| month == Calendar.SEPTEMBER || month == Calendar.DECEMBER) {// ���ȵ�������
			day = getDayOfMonth(seasonDates[0]) + getDayOfMonth(seasonDates[1])
					+ getPassDayOfMonth(seasonDates[2]);
		}
		return day;
	}

	/**
	 * ȡ�ü���ʣ������
	 * 
	 * @param date
	 * @return
	 */
	public static int getRemainDayOfSeason(Date date) {
		return getDayOfSeason(date) - getPassDayOfSeason(date);
	}

	/**
	 * ȡ�ü�������
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
	 * ȡ�ü������һ��
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfSeason(Date date) {
		return getLastDateOfMonth(getSeasonDate(date)[2]);
	}

	/**
	 * ȡ�ü��ȵ�һ��
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfSeason(Date date) {
		return getFirstDateOfMonth(getSeasonDate(date)[0]);
	}

	/**
	 * ȡ�������һ��
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
	 * ȡ���µ�ʣ������
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
	 * ȡ�����Ѿ���������
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
	 * ȡ��������
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
	 * ȡ��������
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
	 * ȡ���µ�һ��
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
	    * ���ڼ�-
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