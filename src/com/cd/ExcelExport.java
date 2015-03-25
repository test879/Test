/**
 * FileName: ExcelExport.java <br/>
 */
package com.cd;

import java.io.File;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Project: Test <br/>
 * Class: com.cd.ExcelExport <br/>
 * Description: <������Ĺ���>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Makedate: 2014-10-14 ����12:35:33 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class ExcelExport {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Attrib> attribList  = new ArrayList<Attrib>();
		
		for(int i = 0;i<10;i++) {
			Attrib att = new Attrib();
			att.setAttribName("�� "+ i +" ��");
			att.setId(i);
			attribList.add(att);
		}
		
		createDeviceXLS("���","���2",attribList);

	}

	private static boolean createDeviceXLS(String deviceID, String deviceName, ArrayList<Attrib> attribList) {
		// String filePath = ServerUtil.serverPath + "model/" + deviceID +
		// ".xls";
		// String filePath = "d:/2.xls";
		String fileName = "���ڴ�����ϸ�������ģ��";
		String filePath = "c:/" + fileName + ".xls";
		File modelFile = new File(filePath);
		if (modelFile.exists())
			modelFile.delete();
		try {
			// open file.
			WritableWorkbook book = Workbook.createWorkbook(modelFile);

			// create Sheet named "Sheet_1". 0 means this is 1st page.
			WritableSheet sheet = book.createSheet("���ڴ���", 0);
			if (attribList != null && !attribList.isEmpty()) {
				for (int i = 0; i < attribList.size(); i++) {
					Attrib attrib = attribList.get(i);
					String labelName = attrib.getAttribName() + ":" + attrib.getId();
					Label label = new Label(0, i, labelName);
					// add defined cell above to sheet instance.
					sheet.addCell(label);
				}
			}
			book.write();
			book.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
