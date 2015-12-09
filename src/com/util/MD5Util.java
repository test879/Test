package com.util;

import java.io.IOException;
import java.security.MessageDigest;


public class MD5Util {
	public static void main(String args[]) throws IOException {
		String imageStr = Base64Util.getEncodeImage("C://testXml//zz//recv//2.jpg");

//		Base64Util.getDecodeImage(imageStr, "C:/testXml/zz/1.jpg");
		
		System.out.println(imageStr);
//		System.out.println(encodeImage(imageStr));

//		String msg = "";
//		String fileName = "C:/testXml/zz/bimage.txt";
//		FileInputStream fis = new FileInputStream(fileName);// 小额
//		byte b[] = new byte[fis.available()];
//		fis.read(b);
//		msg = new String(b, "GBK");
//		BASE64Decoder decoder = new BASE64Decoder();
//		System.out.println(encodeImage(new String(decoder.decodeBuffer(msg))));
	}

	public static String encodeImage(String message) {

		char a = 32; // 空格
		char bs = 10;// 回车
		char cs = 13;// 换行
		message = message.replace(cs, a);
		message = message.replace(" ", "");
		String md5Str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(message.getBytes("UTF-8"));
			byte b[] = md.digest();

			md5Str = byteToHexString(b);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Str;
	}

	/**
	 * 将指定byte数组转换成16进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHexString(byte[] b) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}

}
