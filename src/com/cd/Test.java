package com.cd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;

public class Test {

	/**
	 * @param args
	 * @throws DocumentException
	 */
	public static void main(String[] args) throws DocumentException {

	
	System.out.println("0001".replace("&lt;", "<").replace("&gt;", ">"));
	
	}
	
	
	public static void buildRegularDetail(List list, List list2){
		List list1 = list2;
		try{
			// 数据的大小
			int j = 0;
			int count = 0;
			for(int i=0;i<list1.size();i++){
				StringBuffer sb = new StringBuffer();
				sb.append("\n");
				sb.append("<![CDATA[");
				sb.append("记录"+i);
				sb.append("\n");
				if(list.size() - count * i < 70) {
					count = list.size() - count * i;
				} else {
					count = 70;
				}
				for(;j < count;j++){
					
				}
				sb.append("]]>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
