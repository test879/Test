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
 * <li>1、开发日期：Apr 2, 2011</li>
 * <li>2、开发时间：11:51:18 AM</li>
 * <li>3、类型名称：Base64Util</li>
 * <li>4、类型意图：</li>
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

	public static String getEncodeImage(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		if (imgFilePath == null || imgFilePath == "") {
			return "";
		}
		File file = new File(imgFilePath);
		if (!file.exists()) {
			return "";
		}
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	// 对字节数组字符串进行Base64解码并生成图片
	public static boolean getDecodeImage(String imgStr, String imgFilePath) {
		if (imgStr == null || imgStr == "") // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
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
		// 测试从图片文件转换为Base64编码
		String strImg = getEncodeImage("/C://testXml//zz///send//01605_1000000000000005_F.jpg");
		System.out.println(strImg);
		// 测试从Base64编码转换为图片文件

		// File file = new File("d:\\44.jpg");
		//
		// byte[] data = null;
		// // 读取图片字节数组
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
