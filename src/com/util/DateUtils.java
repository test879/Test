package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

	// ������������֮�������
	public static int getDaysBetween(Date start, Date end) {
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
				return (calEnd.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR)) * -1;
			return calEnd.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
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

	// �����������(�ַ���)֮�������
	public static int getDiffDays(String begin_dt, String end_dt) {
		Date end = java.sql.Date.valueOf(end_dt);
		Date begin = java.sql.Date.valueOf(begin_dt);
		int days = getDaysBetween(begin, end);
		return days;
	}

	// �ж��ַ������ڴ�С
	// 2007-04-12 2006-12-31
	private boolean bigDate(String begin, String end) {
		java.sql.Date de = java.sql.Date.valueOf(begin);
		java.sql.Date de2 = java.sql.Date.valueOf(end);
		return de.getTime() > de2.getTime();
	}

	/**
	 * ��õ�ǰ���ڣ����ݴ����ķָ��������ز�ͬ����ʽ getCurrentDate("-");
	 * 
	 * ���� 2007-04-12
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
	 * �õ�ʱ�� yyyymmdd
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
	 * �õ�ʱ�� yyyymmddhhmmss
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
	 * �õ�ʱ�� yyyy-mm-dd hh:mm:ss
	 * 
	 * @return
	 */
	public static String getyyyy_MM_DDHHMISS() {
		String dt = "";
		try {
			// TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			dt = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * ���� ���� �õ� �ַ���
	 * 
	 * @param a
	 */
	public static String getDateToStr(Date date) {
		String returnValue = "";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			returnValue = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public static void main(String[] a) {
		 System.out.print(getyyyy_MM_DDHHMISS());

//		SimpleDateFormat dateFormatterChina = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");// ��ȡʱ��
//		dateFormatterChina.setTimeZone(timeZoneChina);// ����ϵͳʱ��
//		Date curDate = new Date();// ��ȡϵͳʱ��
//
//		System.out.println(dateFormatterChina.format(curDate));
		// System.out.println("user.timezone = " + System.getProperty("user.timezone"));
		// System.out.println(" user.country = " + System.getProperty("user.country"));
		// System.out.println("    java.home = " + System.getProperty("java.home"));
	}

	/**
	 * �ж��Ƿ�Ϊ�������һ��
	 * 
	 * @param theDate
	 * @param days
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
	 * ����ĳ����֮��N�������
	 * 
	 * @param theDate
	 * @param days
	 * @return Date
	 */
	public static java.sql.Date getDate(Date theDate, int days) {
		Calendar c = new GregorianCalendar();
		c.setTime(theDate);
		c.add(GregorianCalendar.DATE, days);
		return new java.sql.Date(c.getTime().getTime());
	}

	/**
	 * ���������ַ��� ��������
	 * 
	 * @param source
	 * @return
	 */
	public static Date getDate(String source) {
		SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dd = new Date();
		try {
			dd = s.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dd;
	}

	/**
	 * ���������ַ��� ��������
	 * 
	 * @param source
	 * @return
	 */
	public static Date getDate(String source, String sytax) {
		SimpleDateFormat s = new SimpleDateFormat(sytax);
		Date dd = new Date();
		if (StringUtils.nullToString(source).equals(""))
			return null;
		try {
			dd = s.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dd;
	}

	/**
	 * �õ�ĳ������ں�����
	 * 
	 * @param:none
	 * @return yyyy-mm-dd ����n
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
	 * ��ĳ������,�õ���༸�������
	 * 
	 * @param String
	 *            baseDay:��׼���� int days:��������
	 * @return yyyy-mm-dd ����n
	 */
	public static final String getBefDateWithWeek(String baseDay, int days) {
		Calendar cal = Calendar.getInstance();
		java.util.Date d = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String rtn = "";
		try {
			d = formatter.parse(baseDay);
			cal.setTime(d);
		} catch (ParseException ex) {
		}
		cal.add(Calendar.DATE, days);
		// formatter = new SimpleDateFormat("yyyy-MM-dd");
		rtn = formatter.format(cal.getTime());
		cal = null;
		d = null;
		formatter = null;
		return rtn;
	}

	/**
	 * �õ�ĳ�����ڵ����ڵ�����һ�������յ�����
	 * 
	 * @param:baseDay ��ĳ��
	 * @return yyyy-mm-dd ����n
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
		int monday;
		int sunday;

		GregorianCalendar gc;
		gc = new GregorianCalendar(year, month - 1, day); // /month-1����Ϊ����1�Ǵ���2�£�2����3�¡�������
		int today = gc.get(Calendar.DAY_OF_WEEK); // ������������ڼ�������---���� ���� 1---7

		if (today == 1)
			today = 8;
		gc.add(Calendar.DATE, -today + 2); // ������-today+1 ��ñ��ܵ�һ��---���յģ�Ҫ�����һ��ֻ��+2��
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
	 * �õ�ĳ�����ڵ��µ�ǰһ���µ�1�ź���һ���µ�1��
	 * 
	 * @param:baseDay ��ĳ��
	 * @return yyyy-mm-dd ����n
	 */
	public static final String[] getPreAndNextDayOfMonth(String baseDay) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		java.util.Date d = new java.util.Date();
		if (baseDay.equals("")) {
			baseDay = formatter.format(cal.getTime());
		}
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
}
