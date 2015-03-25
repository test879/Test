package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class PingzhengUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static HashMap<String, String> map = new HashMap();

	static {
		map.put("A100", "普通汇兑");
		map.put("A108", "现金汇款");
		map.put("A101", "公益性资金汇划");
		map.put("A102", "国库汇款");
		map.put("A301", "缴费业务");
		map.put("A109", "委托收款(划回)");
		map.put("A110", "托收承付(划回)");
		map.put("A201", "支票");
		map.put("A203", "银行汇票");
		map.put("A204", "银行本票");

		map.put("A111", "商业汇票");
		map.put("A112", "外汇清算");
		map.put("A113", "跨境支付");
		map.put("A105", "退汇");
		map.put("A400", "其他");

	}

	public PingzhengUtil() {
		super();

	}

	public static String getPmtTpDesc(String code) {
		return map.get(code);
	}

	/**
	 * 
	 * 描述 : 批量打印字符串拼好后，重新编辑 <br/>
	 * <p>
	 * 
	 * @param xmlMsg
	 *            原xml
	 * @param addTopWeight
	 *            在原来的高度上添加
	 * @return 修改后的打印字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String editEvidenceBatchPrintXml(String xmlMsg, int addTopWeight) {

		// 储存Xml字符串
		StringBuffer sb = new StringBuffer();

		try {
			Document doc = DocumentHelper.parseText(xmlMsg);
			doc.setXMLEncoding("GBK");
			Element root = doc.getRootElement();
			Element foo;
			// 取得Page标签中各元素
			Iterator iteratorPage = root.elementIterator("Page");
			int j = 0;
			// 循环标签，如果当前记录为偶数时，调整Page下各个标签的的高度
			while (iteratorPage.hasNext()) {
				foo = (Element) iteratorPage.next();
				if (j % 2 != 0) {
					List list = foo.elements();
					for (int k = 0; k < list.size(); k++) {
						Element el = (Element) list.get(k);
						Attribute at = el.attribute("Top");
						at.setValue(String.valueOf(Integer.valueOf(at.getStringValue()) + addTopWeight));
					}
				}
				j++;
			}
			// 以</Page><Page>分割XML文件。
			String[] recordXmlArr = doc.asXML().split("</Page><Page>");
			// 先把xml头和第一条记录储存上。
			sb.append(recordXmlArr[0]);
			// 但记录数不为1条时
			if (recordXmlArr.length != 1) {

				// 从第二条开始循环
				for (int currentFlg = 1; currentFlg < recordXmlArr.length; currentFlg++) {
					// 当前记录奇偶数判断
					if (currentFlg % 2 != 0) {
						// 当前为奇数条时
						sb.append(recordXmlArr[currentFlg]).append("</Page>");
					} else {
						// 当前记录为偶数时
						sb.append("<Page>").append(recordXmlArr[currentFlg]);
					}
				}
				// 最后记录为奇数记录是，</Page>标签去除
				if (sb.indexOf("</Document></Page>") != -1) {
					sb.replace(sb.indexOf("</Document></Page>"), sb.length(), "</Document>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * 描述 : 批量打印字符串拼好后，重新编辑 <br/>
	 * <p>
	 * 
	 * @param xmlMsg
	 *            原xml
	 * @return 修改后的打印字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String editExchargePrintXml(String... xmlMsg) {

		// 打印条数为一条时
		if(1==xmlMsg.length) {
			return xmlMsg[0];
		}

		// 储存Xml字符串
		StringBuffer sb = new StringBuffer();
		StringBuffer sbNext = new StringBuffer();

		Document docFirst;
		try {
			docFirst = DocumentHelper.parseText(xmlMsg[0]);
			docFirst.setXMLEncoding("GBK");
			Element rootFirst = docFirst.getRootElement();
			Element fooFirst;
			Iterator iteratorPageSetUp = rootFirst.elementIterator("PageSetUp");
			if (iteratorPageSetUp.hasNext()) {
				fooFirst = (Element) iteratorPageSetUp.next();
				if(3==xmlMsg.length) {
					fooFirst.element("Height").setText(String.valueOf(285000));
				} else {
					fooFirst.element("Height").setText(String.valueOf(190000));
				}
			}
			sb.append(docFirst.asXML());
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		for(int i = 1; i< xmlMsg.length;i++) {
			try {
				Document doc = DocumentHelper.parseText(xmlMsg[i]);
				doc.setXMLEncoding("GBK");
				Element root = doc.getRootElement();
//				if(i==0) {
//					Element fooFirst;
//					Iterator iteratorPageSetUp = root.elementIterator("PageSetUp");
//					if (iteratorPageSetUp.hasNext()) {
//						fooFirst = (Element) iteratorPageSetUp.next();
//						fooFirst.element("Height").setText(String.valueOf(Integer.valueOf(fooFirst.element("Height").getText()) + addTopWeight*xmlMsg.length));
//					}
//					sb.append(doc.asXML());
//				}else {
					Element foo;
					// 取得Page标签中各元素
					Iterator iteratorPage = root.elementIterator("Page");
					// 循环标签，如果当前记录为偶数时，调整Page下各个标签的的高度
					while (iteratorPage.hasNext()) {
						foo = (Element) iteratorPage.next();
						sbNext.append(foo.asXML());
					}
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		String returnStr = "";
//			String ss = sbNext.toString().replaceAll("<Page>", "").replaceAll("</Page>", "");
//			System.out.println();
//			returnStr = sb.toString().replace("</Page>", ss).replace("</Document>", "</Page></Document>");
			
//			System.out.println(sbNext.toString());
		returnStr = sb.toString().replace("</Page>", "</Page>"+sbNext.toString());
		return returnStr;
	}
	
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\print\\three/1.txt");
		FileInputStream fis=new FileInputStream(file);
		byte[] b=new byte[fis.available()];
		fis.read(b);
		String msg=new String(b,"utf-8");
		
		File file2=new File("C:\\print\\three/2.txt");
		FileInputStream fis2=new FileInputStream(file2);
		byte[] b2=new byte[fis2.available()];
		fis2.read(b2);
		String msg2=new String(b2,"utf-8");
//		
		File file3=new File("C:\\print\\three/3.txt");
		FileInputStream fis3=new FileInputStream(file3);
		byte[] b3=new byte[fis3.available()];
		fis3.read(b3);
		String msg3=new String(b3,"utf-8");

		String ss = editExchargePrintXml(msg, msg2, msg3);
		String swfefw = editEvidenceBatchPrintXml(ss, 97500);
		
		String fe = editEvidenceBatchPrintXml(swfefw, 97500*2);

		System.out.println(fe);
//		System.out.println(ss);
	}

	/**
	 * 定期贷记收款人详细信息凭证打印模板赋值
	 * @param cpe 凭证打印实体类
	 * @param msg 凭证打印模板
	 * @throws UnsupportedEncodingException 
	 */
	public static String buildRegularDetail(Object ...obj) throws UnsupportedEncodingException{

		// 打印数据拼接
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< obj.length; i+=2){
			sb.append(StringUtils.getFixLengthRigthBlank(obj[i].toString(), Integer.parseInt(obj[i+1].toString())));
		}
		sb.append("\n");
		return sb.toString();
	}
}
