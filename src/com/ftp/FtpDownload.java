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
 * javaʵ��FTP����
 * 
 * @author
 *
 */
public class FtpDownload {

	String localfilename;
	String remotefilename;
	public FtpClient ftpClient;

	/**
	 * ���ӷ�����
	 * 
	 * @param ip
	 *            ip��ַ
	 * @param port
	 *            �˿�
	 * @param user
	 *            �û���
	 * @param password
	 *            ����
	 * @param path
	 *            ·��
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
			throw new Exception("����ftpʧ��");
		}
		return isSuccess;
	}

	/**
	 * �رշ�����
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
	 * ����·�����ļ���������Զ�̵��ļ�
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
			// ȡ��ͼƬ����
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
	 * ���� : ���ҵ��ͼƬ���ز�ת��Ϊbase64����. <br/>
	 * <p>
	 * 
	 * @param imageName
	 * @return
	 * @throws Exception
	 */
	public void byte2Base64Str(Message msg, String imageStrFlag, String imageName) throws Exception {

		// ȡ��ͼƬbyte����
		byte[] by = downloadByte(imageName, msg);
		String encStr = "";
		if (0 < by.length) {

			// ͼƬ���ݾ���base64����
			encStr = Base64Util.getEncodeString(by);

			msg.setValue(imageStrFlag + "Ӱ���С", encStr.length());
			msg.setValue(imageStrFlag + "Ӱ������", encStr.trim());
		}
		// StringUtil.printMsg(logger, "���:" + encStr);
	}

	public static void main(String agrs[]) throws Exception {
		// FtpDownload ftpupload = new FtpDownload();
		// Message msg = new Message();
		// ftpupload.byte2Base64Str(msg, "����", "01605_1000000000000005_F.jpg");
		// msg.listAll();
	}
}
