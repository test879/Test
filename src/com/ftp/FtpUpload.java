package com.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * java实现FTP上传
 * 
 * @author dell
 *
 */
public class FtpUpload {

	String localfilename;
	String remotefilename;
	FTPClient ftpClient;

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
	 */
	public void connectServer(String ip, int port, String user, String password) {

		try {
			ftpClient = new FTPClient();
			ftpClient.connect(ip, port);// 连接FTP服务器
			ftpClient.login(user, password);// 登陆FTP服务器
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				System.out.println("未连接到FTP，用户名或密码错误。");
				ftpClient.disconnect();
			} else {
				System.out.println("FTP连接成功。");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("not login");
			System.out.println(ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭服务器
	 */
	public void closeConnect() {
		try {
			if (!ftpClient.isConnected()) {
				ftpClient.disconnect();
				System.out.println("disconnect success");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("not disconnect");
			System.out.println(ex);
		}
	}

	/**
	 * 文件上传
	 * 
	 * @param path
	 *            远程路径
	 * @param localfilename
	 *            本地文件名
	 * @param remotefilename
	 *            远程文件名
	 * @throws Exception
	 * @throws Exception
	 */
	public String upload(InputStream is, String remotefilename) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("Syspara");
		String ip = rb.getString("ftpsocket");
		int port = 21;
		String user = rb.getString("user");
		String password = rb.getString("password");
		String imagepath = rb.getString("imagePath") + "/" + "recv";
		if (rb.getString("ftppath") != null) {
			remotefilename = rb.getString("ftppath") + imagepath + "/" + remotefilename;
		} else {
			remotefilename = imagepath + "/" + remotefilename;
		}
		try {
			connectServer(ip, port, user, password);
			// 设置PassiveMode传输
			ftpClient.enterLocalPassiveMode();
			// 设置以二进制流的方式传输
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setControlEncoding("UTF-8");
			// 对远程目录的处理
			String remoteFileName = remotefilename;
			if (remotefilename.contains("/")) {
				remoteFileName = remotefilename.substring(remotefilename.lastIndexOf("/") + 1);
				// 创建服务器远程目录结构，创建失败直接返回
				if (!CreateDirecroty(remotefilename)) {
					throw new Exception("文件目录创建失败");
				}
			}

			ftpClient.storeFile(remoteFileName, is);

			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			closeConnect();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("not upload");
			System.out.println(ex);
			throw new Exception("保存票据数据失败");

		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			closeConnect();
		}
		return imagepath;
	}

	/**
	 * 创建远程服务器文件
	 * 
	 * @param remote
	 * @return
	 * @throws IOException
	 */
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote.substring(0, remote.lastIndexOf("/") + 1);

		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !ftpClient.changeWorkingDirectory(new String(directory))) {

			int start = 0;
			int end = 0;

			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}

			end = directory.indexOf("/", start);
			while (true) {
				String subDirectory = new String(remote.substring(0, end));
				if (!ftpClient.changeWorkingDirectory(subDirectory)) {
					if (ftpClient.makeDirectory(subDirectory)) {
						ftpClient.changeWorkingDirectory(subDirectory);
					} else {
						System.out.println("创建目录失败");
						success = false;
						return success;
					}
				}
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}
}