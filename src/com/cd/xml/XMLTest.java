package com.cd.xml;


import java.io.IOException;
import java.io.StringWriter;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.XMLContext;

public class XMLTest {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 组报文
	 * 
	 * @param mappingfile
	 *            报文映射文件
	 * @param obj
	 *            实体类
	 * @return xml报文
	 * @throws PicpMessageException
	 */
	public String createXML(String mappingfile, Object obj) throws PicpMessageException {
		String msgXml = "";
		Mapping map = null;
		StringWriter sw = null;
		Marshaller mm = null;
		XMLContext xmlcont = null;
		try {
			xmlcont = new XMLContext();
			map = xmlcont.createMapping();
			map.loadMapping(mappingfile);
			/*
			 * map.loadMapping(mappingfile); sw = new StringWriter(); mm = new Marshaller(sw);
			 */

			mm = xmlcont.createMarshaller();
			sw = new StringWriter();
			mm.setWriter(sw);
			// mm.marshal(sw);

			mm.setMapping(map);
			mm.marshal(obj);
			msgXml = sw.toString();
			sw.close();
			xmlcont = null;
			sw = null;
			map = null;
			mm = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sw != null) {
					sw.close();
					sw = null;
				}
				xmlcont = null;
				map = null;
				mm = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return msgXml;
	}
}
