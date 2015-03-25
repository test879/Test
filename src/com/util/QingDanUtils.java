package com.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entity.ReportModelOfCyEntity;

public class QingDanUtils {
	public final static int BUSINESS_SEND_HEAND_LEN = 177;
	public final static int BUSINESS_RCV_HEAND_LEN = 165;

	/**
	 * 来往报清单表头 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param head
	 * @param startDt
	 * @param endDt
	 * @param bank
	 * @param curr
	 * @param total
	 * @param dir
	 * @return
	 */
	public static String getBussiness_Send_Head(List dataList, String head,
			String startDt, String endDt, String bank, int curr, int total,
			String dir) {
		StringBuffer sb = new StringBuffer();
		int headLen = 0;
		int length = 0;
		if (dir.equals("O")) {
			length = BUSINESS_SEND_HEAND_LEN;
		} else {
			length = BUSINESS_RCV_HEAND_LEN;
		}
		try {
			headLen = head.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((length - headLen) / 2 == 0) {
			sb.append(getSplit((length - headLen) / 2));
			sb.append(head);
			sb.append(getSplit((length - headLen) / 2));
		} else {
			sb.append(getSplit((length - headLen + 1) / 2));
			sb.append(head);
			sb.append(getSplit((length - headLen + 1) / 2));
		}
		String date = startDt + "->" + bank;
		try {
			headLen = date.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((length - headLen) / 2 == 0) {
			sb.append(getSplit((length - headLen) / 2));
			sb.append(date);
			sb.append(getSplit((length - headLen) / 2));
		} else {
			sb.append(getSplit((length - headLen + 1) / 2));
			sb.append(date);
			sb.append(getSplit((length - headLen + 1) / 2));
		}
		String temp = null;
		if (dir.equals("O")) {
			temp = "支付发起行：";
		} else {
			temp = "支付接收行：";
		}
		String bankhead = temp + bank + "              打印时间："
				+ DateUtils.getyyyy_MM_DDHHMISS() + "  第" + curr + "页/共"
				+ total + "页";

		try {
			headLen = bankhead.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((length - headLen) / 2 == 0) {
			sb.append(getSplit((length - headLen) / 2));
			sb.append(bankhead);
			sb.append(getSplit((length - headLen) / 2));
		} else {
			sb.append(getSplit((length - headLen + 1) / 2));
			sb.append(bankhead);
			sb.append(getSplit((length - headLen + 1) / 2));
		}
		return sb.toString();
	}

	public static String getBussinessEnd(String usNm, String dir) {
		StringBuffer sb = new StringBuffer();
		int headLen = 0;
		int length = 0;
		if (dir.equals("O")) {
			length = BUSINESS_SEND_HEAND_LEN;
		} else {
			length = BUSINESS_RCV_HEAND_LEN;
		}
		sb.append(getSplit(length));

		String end = getFixBlank(20) + "会计：" + getFixBlank(20) + "主管："
				+ getFixBlank(20) + "打印：";

		try {
			headLen = end.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ((BUSINESS_SEND_HEAND_LEN - headLen) / 2 == 0) {
			sb.append(getSplit((BUSINESS_SEND_HEAND_LEN - headLen) / 2));
			sb.append(end);
			sb.append(getSplit((BUSINESS_SEND_HEAND_LEN - headLen) / 2));
		} else {
			sb.append(getSplit((BUSINESS_SEND_HEAND_LEN - headLen + 1) / 2));
			sb.append(end);
			sb.append(getSplit((BUSINESS_SEND_HEAND_LEN - headLen + 1) / 2));
		}

		return sb.toString();
	}

	public static String getSplit(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public static String getFixBlank(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	/**
	 * 
	 * 描述 : 数据添加. <br/>
	 * <p>
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String setData(List dataList, String dir)
			throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < dataList.size(); i++) {
			ReportModelOfCyEntity cpe = (ReportModelOfCyEntity) dataList.get(i);
			if ("O".equals(dir)) {
				sb.append(PingzhengUtil.buildRegularDetail(cpe.getWorkdt(), 32,
						cpe.getCoretransid(), 30, cpe.getMsgtp(), 14,
						cpe.getAmount(), 15, cpe.getDbtracct(), 20,
						cpe.getCdtracct(), 32, cpe.getBrnchid(), 15,
						cpe.getStatus(), 9, cpe.getSignerid(), 6,
						cpe.getCheckerid(), 6));
			} else {
				sb.append(PingzhengUtil.buildRegularDetail(cpe.getWorkdt(), 32,
						cpe.getCoretransid(), 30, cpe.getMsgtp(), 14,
						cpe.getAmount(), 15, cpe.getDbtracct(), 20,
						cpe.getCdtracct(), 32, cpe.getBrnchid(), 15,
						cpe.getStatus(), 9));
			}
		}
		return sb.toString();
	}

}
