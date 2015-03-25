package com.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

	/**
	 *  nullת��ɿ�
	 * @param resource
	 * @return
	 */
	public static String nullToString(String resource){
		if(resource==null||resource.equals("null")){
    		resource="";
		}
    	return resource.trim();
	}

	/**
	 *  nullת���0
	 * @param resource
	 * @return
	 */
	public static String nullToZero(String resource){
		if(resource==null)
    		resource="0";
		if(resource.equals(""))
			resource="0";
    	return resource;
	}
	
	public static String ridName(String fileName){
		String returnName = "";
		int pot = fileName.lastIndexOf(".");
		returnName = fileName.substring(pot,fileName.length());
		return returnName;
	}
	
	/**
	 * convert a string array into a string, each element in array will be
	 * delimited by "," if an array = {"0000", "1111", "2222"}, the return
	 * string will be : 0000,1111,2222
	 * 
	 * @param values
	 *            string array
	 * @return converted string, if values is null, null will be return
	 *  
	 */
	public static String strArrayToString(String[] values) {
		if (values == null)
			return "";

		int i = 0, length = values.length;
		String str = "";
		for (i = 0; i < length; i++) {
			str += values[i];
			if (i != length - 1) {
				str += ",";
			}
		}
		return str;
	}
	
	
  	/**
   	 * �ָ��ִ�
   	 * @param source ԭʼ�ַ�
   	 * @param delim �ָ��
   	 * @return �ַ�������
   	 */
   	public static String[] split(String source,String delim){
   	  int i = 0;
   	  int l = 0;
   	  if (source == null || delim == null) return new String[0];
   	  if (source.equals("") || delim.equals("")) return new String[0];

   	  StringTokenizer st = new StringTokenizer(source,delim);
   	  l = st.countTokens();
   	  String[] s = new String[l];
   	  while(st.hasMoreTokens()){
   		s[i++] = st.nextToken();
   	  }
   	  return s;
     }	
   	
    /**
     * list �� string ,��ӷָ���  '|'
     * 
     * return "a|b|c|d|e|f|g|";
     * @param list
     * @return
     */
	public static String listToString(List list){
		String returnSource = "";
		Iterator it = list.iterator();
		while(it.hasNext()){
			returnSource = returnSource + toString((List) it.next()) + "\n";
		}
		return returnSource;
	}
	public static String toString(List list){
		String source = "";
		Iterator it = list.iterator();
		while(it.hasNext()){
			source = source + it.next()+"|"; 
		}
		return source;
	}
	
	
	//����ת������ һγ���� ת���� 2γ����
	//new String{"1","2","3","4"};
	//return newString[][]{{"1"},{"2"},{"3"},{"4"}}
	public static String[][] getArray(String [] name){
		int length = name.length;
		String [][] outValue = new String[length][1];
		for(int i=0;i<length;i++){
			outValue[i][0]=name[i];
		}
		return outValue;
	}
	
	public static String getRidLast(String resource,int dot){
		if(!resource.equals("")){
			resource = resource.substring(0,resource.length()-dot);
		}
		return resource;
	}
	
	public static String ridArg(String source,String prefix){
		if(source==null) source="";
		if(source.startsWith(prefix)){
			source = source.substring(prefix.length(),source.length());
		}
		return source;
	}
	
	/**
	 * �������� �ַ��� �� 2007-09-11  ת���� 20070911
	 */
	public static String changeDate(String source){
		if(source==null)
			source="";
		if(source.equals(""))
			return source;
		if(source.length()<9)
			return source;
		String returnValue = "";
		returnValue = source.substring(0,4)+source.substring(5,7)+source.substring(8,10);
		return returnValue;
	}
	
	public static Object stringToInteger(String source){
		if(source==null||source.equals("")){
			return "";
		}else{
			return new Integer(source.trim());
		}
	}
	
	/**
	 * ȥ�� ���  2007-08  �õ�  200708
	 * @return
	 */
	public static String getRidMonth(String source){
		if(nullToString(source).equals(""))
			return "";
		source = source.substring(0,4)+source.substring(5,7);
		return source;
	}
	
	 /** ������ת��Ϊָ�������ַ���
	    * exp:1 --> 00001 (lpMaxLengthΪ5)
	    * @param lpInt 
	    * @param lpMaxLength
	    * @return
	    * 
	    * @pdOid fe6ac6f6-a63e-4c8c-85d0-4cf0abf013ec */
	   public static String intToStr(int lpInt, int lpMaxLength) {
	     int length, i;
	     String returnValue = "";
	   
	     length = Integer.toString(lpInt).length();
	     if (length < lpMaxLength){
	       i = lpMaxLength - length;
	       while( i > 0) {
	         returnValue = returnValue + "0";
	         i--;
	       }
	       returnValue = returnValue + Integer.toString(lpInt);
	     }else{
	       returnValue = Integer.toString(lpInt);
	     }
	    return returnValue;
	   }
	
	   
	   /** ���������ַ����������λ���Ŀյ��ַ��������ַ���ȫ��0���ǿ��ַ���ȱ��λ����벹��λ��
	    * 
	    * @param strn
	    * @return
	    * 
	    * @pdOid a9ab0da9-e381-4966-b48e-d48c5abe32f3 */
	   public static String getNullStr(String strn,int appointLength) {
		   StringBuffer str=new StringBuffer(); 
		   if( strn == null)
			   for(int i=0;i<appointLength;i++){
				   str.append(" ");
			   }
		   else{
			   int count=appointLength-strn.trim().length();
			   for(int i=0;i<count;i++){
				   str.append(" ");
			   }
			   str.append(strn.trim());
		   }
			   
		   return str.toString();
	}

	/**
	 * �Ҳ��ո�
	 * @param value
	 * @param length
	 * @return
	 */
	public static String getFixLengthRigthBlank(String value,int length){
		return getFixLengthRigthByte(value,length,(byte)32);
	}
	
	/**
	 * �Ҳ��ַ�
	 * @param value
	 * @param length
	 * @return
	 */
	public static String  getFixLengthRigthByte(String value,int length,byte c){
		String result="";
		try {
			if(value==null){
				value="";
			}
			byte b[]=value.getBytes("GBK");
			if(b.length==length){
				return value;
			}
			
			if(b.length>length){
				value=value.substring(0,length/2);
				b=value.getBytes("GBK");
			}
			
			byte btemp[]=new byte[length];
			int count=0;
			
			for(byte t:b){
				btemp[count]=t;
				count++;
			}
			
			int tempcount=length-b.length;
			
			while(tempcount!=0){
				btemp[count]=c;
				count++;
				tempcount--;
			}
			result= new String(btemp,0,btemp.length,"GBK");
//			int count=length-b.length;
//			for(int i=0;i<count;i++){
//				result+="&#160;";
//			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
