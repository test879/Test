package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <ul>
 * <li>1���������ڣ�Apr 2, 2011</li>
 * <li>2������ʱ�䣺11:51:18 AM</li>
 * <li>3���������ƣ�Base64Util</li>
 * <li>4��������ͼ��</li>
 * </ul>
 * 
 * @author
 * 
 */
public class Base64Util {

	public static String getEncodeString(byte[] by) {
		if (0 == by.length) {
			return null;
		}
		BASE64Encoder enc = new BASE64Encoder();

		String encStr = enc.encode(by).replace("\n", "");

		return encStr;
	}

	public static String getDecodeString(String base64) {
		if (base64 == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(base64);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getEncodeImage(String imgFilePath) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
		if (imgFilePath == null || imgFilePath == "") {
			return "";
		}
		File file = new File(imgFilePath);
		if (!file.exists()) {
			return "";
		}
		byte[] data = null;
		// ��ȡͼƬ�ֽ�����
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}

	// ���ֽ������ַ�������Base64���벢����ͼƬ
	public static boolean getDecodeImage(String imgStr, String imgFilePath) {
		if (imgStr == null || imgStr == "") // ͼ������Ϊ��
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// �����쳣����
					bytes[i] += 256;
				}
			}
			// ����jpegͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			// FileOutputStream os=new FileOutputStream("d:/cao.jpg");
			// os.write(b);
			// os.close();
			return new String(b, "UTF-8");
		} catch (Exception e) {
			return null;
		}
	}

	public static String getFromBASE64Gbk(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			// FileOutputStream os=new FileOutputStream("d:/cao.jpg");
			// os.write(b);
			// os.close();
			return new String(b, "GBK");
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// ���Դ�ͼƬ�ļ�ת��ΪBase64����
		String strImg = getEncodeImage("/C://testXml//zz///send//01605_1000000000000005_F.jpg");
		System.out.println(strImg);
		// ���Դ�Base64����ת��ΪͼƬ�ļ�

		// File file = new File("d:\\44.jpg");
		//
		// byte[] data = null;
		// // ��ȡͼƬ�ֽ�����
		// InputStream in;
		// try {
		// in = new FileInputStream("d:\\44.jpg");
		// data = new byte[in.available()];
		// in.read(data);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// getDecodeImage(new String(data), "d:\\133333.jpg");
		//
		// String s = "123123";
		// System.out.println("s=" + s);
		// String base64 = getEncodeString(s);
		// System.out.println("base64=" + base64);
		// String s2 = getDecodeString(base64);
		// System.out.println("s2=" + s2);

	}

}
