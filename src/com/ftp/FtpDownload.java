package com.ftp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.packer.Message;
import com.util.Base64Util;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;

/**
 * java实现FTP下载
 * 
 * @author
 *
 */
public class FtpDownload {

	String localfilename;
	String remotefilename;
	public FtpClient ftpClient;

	/**
	 * 连接服务器
	 * 
	 * @param ip
	 *            ip地址
	 * @param port
	 *            端口
	 * @param user
	 *            用户名
	 * @param password
	 *            密码
	 * @param path
	 *            路径
	 * @throws Exception
	 */
	public boolean connectServer(String ip, int port, String user, String password, String path) throws Exception {
		boolean isSuccess = false;
		try {
			ftpClient = new FtpClient();
			ftpClient.openServer(ip, port);
			ftpClient.login(user, password);
			System.out.println("login success!");
			ftpClient.cd(path);
			ftpClient.binary();
			isSuccess = true;
		} catch (IOException ex) {
			System.out.println("not login");
			System.out.println(ex);
			throw new Exception("连接ftp失败");
		}
		return isSuccess;
	}

	/**
	 * 关闭服务器
	 */
	public void closeConnect() {
		try {
			ftpClient.closeServer();
			System.out.println("disconnect success");
		} catch (IOException ex) {
			System.out.println("not disconnect");
			System.out.println(ex);
		}
	}

	/**
	 * 根据路径和文件名，下载远程的文件
	 * 
	 * @param remoteFile
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public byte[] downloadByte(String remoteFile, Message msg) throws Exception {
		byte[] bytes = null;
		byte[] rturnBytes = null;
		TelnetInputStream is = null;
		String path = "";
		try {
			ResourceBundle rb = ResourceBundle.getBundle("Syspara");
			String ip = rb.getString("ftpsocket");
			int port = 21;
			String user = rb.getString("user");
			String password = rb.getString("password");

			FtpUtil ftpUtils = new FtpUtil();
			// 取得图片名称
			path = ftpUtils.getImageNamePath("send");

			connectServer(ip, port, user, password, path);
			ftpClient.binary();
			is = ftpClient.get(remoteFile);
			Thread.sleep(3);
			bytes = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			System.out.println(is.available() + "-----");
			int c;
			while ((c = is.read(bytes)) != -1) {
				bos.write(bytes, 0, c);
			}
			rturnBytes = bos.toByteArray();
			System.out.println(bos.size() + "-----");
			System.out.println("download success");
			is.close();
			is = null;

		} catch (Exception ex) {
			System.out.println("not download");
			System.out.println(ex);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			closeConnect();
		}
		return rturnBytes;
	}

	/**
	 * 
	 * 描述 : 提出业务图片下载并转换为base64编码. <br/>
	 * <p>
	 * 
	 * @param imageName
	 * @return
	 * @throws Exception
	 */
	public void byte2Base64Str(Message msg, String imageStrFlag, String imageName) throws Exception {

		// 取得图片byte数据
		byte[] by = downloadByte(imageName, msg);
		String encStr = "";
		if (0 < by.length) {

			// 图片数据尽心base64编码
			encStr = Base64Util.getEncodeString(by);

			msg.setValue(imageStrFlag + "影像大小", encStr.length());
			msg.setValue(imageStrFlag + "影像数据", encStr.trim());
		}
		// StringUtil.printMsg(logger, "输出:" + encStr);
	}

	public static void main(String agrs[]) throws Exception {
		// FtpDownload ftpupload = new FtpDownload();
		// Message msg = new Message();
		// ftpupload.byte2Base64Str(msg, "正面", "01605_1000000000000005_F.jpg");
		// msg.listAll();
	}
}
