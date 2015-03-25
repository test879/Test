/**
 * FileName: telnetTest.java <br/>
 */
package com.dataLog;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.util.NetTelnet;

/**
 * Project: Test <br/>
 * Class: com.dataLog.telnetTest <br/>
 * Description: <描述类的功能>. <br/>
 * Copyright: Copyright (c) 2015 <br/>
 * Makedate: 2015年3月6日 下午2:06:26 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class TelnetTest {
	static FTPClient netftpClient;
	
	public static String ip;
	public static int port;
	public static String user;
	public static String pwd;
	public static String pmtsPath;
	public static String pmtsCode;
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("Socket_IP_Port");
		pmtsPath = rb.getString("path_A");
		ip = rb.getString("code_ftpip_A");
		port = Integer.parseInt(rb.getString("code_ftpport_A"));
		user = rb.getString("code_name_A");
		pwd = rb.getString("code_pwd_A");
		pmtsCode = rb.getString("pmtscode_A");
	}
	/**
	 * <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inodeNo = "";
		NetTelnet netTelnet = null;
		TelnetTest test = new TelnetTest();
		try {
			netTelnet = new NetTelnet(ip,user,user,"23");
//			netTelnet.
			test.connectServer();
			// 这是apache的下载是apache的
			netftpClient.changeWorkingDirectory("/pmts/log/20150304/msg/");
			netftpClient.setRestartOffset(0);// 断点续传
			netftpClient.setControlEncoding("UTF-8");
			netftpClient.enterLocalPassiveMode();
			int i = netftpClient.sendCommand("ls -i success.msg");
			System.out.println(i);
			netftpClient.disconnect();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			netTelnet.disconnect();
		}
	}
	public boolean connectServer() throws Exception {
		boolean isSuccess = false;
		try {
			ResourceBundle rb = ResourceBundle.getBundle("Socket_IP_Port");
			netftpClient = new FTPClient();
			isSuccess = connect(netftpClient);
		} catch (Exception ex) {
			throw new Exception("Connect ftp server error:" + ex.getMessage());
		}
		return isSuccess;
	}
	/**
	 * 连接到ftp服务器
	 * 
	 * @param ftpClient
	 * @return 连接成功返回true，否则返回false
	 * @throws FTPClientException
	 */
	private boolean connect(FTPClient ftpClient) throws Exception {
		try {
			ftpClient.connect(ip, port);

			// 连接后检测返回码来校验连接是否成功
			ftpClient.enterLocalPassiveMode();
			int reply = ftpClient.getReplyCode();

			if (FTPReply.isPositiveCompletion(reply)) {
				// 登陆到ftp服务器
				if (ftpClient.login(user, pwd)) {
					ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
					return true;
				}
			} else {
				ftpClient.disconnect();
				throw new Exception("FTP server refused connection.");
			}
		} catch (IOException e) {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect(); // 断开连接
				} catch (IOException e1) {
					throw new Exception("Could not disconnect from server.", e1);
				}

			}
			throw new Exception("Could not connect to server.", e);
		}
		return false;
	}
}
