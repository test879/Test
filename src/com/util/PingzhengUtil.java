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
		map.put("A100", "��ͨ���");
		map.put("A108", "�ֽ���");
		map.put("A101", "�������ʽ�㻮");
		map.put("A102", "������");
		map.put("A301", "�ɷ�ҵ��");
		map.put("A109", "ί���տ�(����)");
		map.put("A110", "���ճи�(����)");
		map.put("A201", "֧Ʊ");
		map.put("A203", "���л�Ʊ");
		map.put("A204", "���б�Ʊ");

		map.put("A111", "��ҵ��Ʊ");
		map.put("A112", "�������");
		map.put("A113", "�羳֧��");
		map.put("A105", "�˻�");
		map.put("A400", "����");

	}

	public PingzhengUtil() {
		super();

	}

	public static String getPmtTpDesc(String code) {
		return map.get(code);
	}

	/**
	 * 
	 * ���� : ������ӡ�ַ���ƴ�ú����±༭ <br/>
	 * <p>
	 * 
	 * @param xmlMsg
	 *            ԭxml
	 * @param addTopWeight
	 *            ��ԭ���ĸ߶������
	 * @return �޸ĺ�Ĵ�ӡ�ַ���
	 */
	@SuppressWarnings("rawtypes")
	public static String editEvidenceBatchPrintXml(String xmlMsg, int addTopWeight) {

		// ����Xml�ַ���
		StringBuffer sb = new StringBuffer();

		try {
			Document doc = DocumentHelper.parseText(xmlMsg);
			doc.setXMLEncoding("GBK");
			Element root = doc.getRootElement();
			Element foo;
			// ȡ��Page��ǩ�и�Ԫ��
			Iterator iteratorPage = root.elementIterator("Page");
			int j = 0;
			// ѭ����ǩ�������ǰ��¼Ϊż��ʱ������Page�¸�����ǩ�ĵĸ߶�
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
			// ��</Page><Page>�ָ�XML�ļ���
			String[] recordXmlArr = doc.asXML().split("</Page><Page>");
			// �Ȱ�xmlͷ�͵�һ����¼�����ϡ�
			sb.append(recordXmlArr[0]);
			// ����¼����Ϊ1��ʱ
			if (recordXmlArr.length != 1) {

				// �ӵڶ�����ʼѭ��
				for (int currentFlg = 1; currentFlg < recordXmlArr.length; currentFlg++) {
					// ��ǰ��¼��ż���ж�
					if (currentFlg % 2 != 0) {
						// ��ǰΪ������ʱ
						sb.append(recordXmlArr[currentFlg]).append("</Page>");
					} else {
						// ��ǰ��¼Ϊż��ʱ
						sb.append("<Page>").append(recordXmlArr[currentFlg]);
					}
				}
				// ����¼Ϊ������¼�ǣ�</Page>��ǩȥ��
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
	 * ���� : ������ӡ�ַ���ƴ�ú����±༭ <br/>
	 * <p>
	 * 
	 * @param xmlMsg
	 *            ԭxml
	 * @return �޸ĺ�Ĵ�ӡ�ַ���
	 */
	@SuppressWarnings("rawtypes")
	public static String editExchargePrintXml(String... xmlMsg) {

		// ��ӡ����Ϊһ��ʱ
		if(1==xmlMsg.length) {
			return xmlMsg[0];
		}

		// ����Xml�ַ���
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
					// ȡ��Page��ǩ�и�Ԫ��
					Iterator iteratorPage = root.elementIterator("Page");
					// ѭ����ǩ�������ǰ��¼Ϊż��ʱ������Page�¸�����ǩ�ĵĸ߶�
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
	 * ���ڴ����տ�����ϸ��Ϣƾ֤��ӡģ�帳ֵ
	 * @param cpe ƾ֤��ӡʵ����
	 * @param msg ƾ֤��ӡģ��
	 * @throws UnsupportedEncodingException 
	 */
	public static String buildRegularDetail(Object ...obj) throws UnsupportedEncodingException{

		// ��ӡ����ƴ��
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< obj.length; i+=2){
			sb.append(StringUtils.getFixLengthRigthBlank(obj[i].toString(), Integer.parseInt(obj[i+1].toString())));
		}
		sb.append("\n");
		return sb.toString();
	}
}
