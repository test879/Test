package com.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * javaʵ��FTP�ϴ�
 * 
 * @author dell
 *
 */
public class FtpUpload {

	String localfilename;
	String remotefilename;
	FTPClient ftpClient;

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
	 */
	public void connectServer(String ip, int port, String user, String password) {

		try {
			ftpClient = new FTPClient();
			ftpClient.connect(ip, port);// ����FTP������
			ftpClient.login(user, password);// ��½FTP������
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				System.out.println("δ���ӵ�FTP���û������������");
				ftpClient.disconnect();
			} else {
				System.out.println("FTP���ӳɹ���");
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
	 * �رշ�����
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
	 * �ļ��ϴ�
	 * 
	 * @param path
	 *            Զ��·��
	 * @param localfilename
	 *            �����ļ���
	 * @param remotefilename
	 *            Զ���ļ���
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
			// ����PassiveMode����
			ftpClient.enterLocalPassiveMode();
			// �����Զ��������ķ�ʽ����
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setControlEncoding("UTF-8");
			// ��Զ��Ŀ¼�Ĵ���
			String remoteFileName = remotefilename;
			if (remotefilename.contains("/")) {
				remoteFileName = remotefilename.substring(remotefilename.lastIndexOf("/") + 1);
				// ����������Զ��Ŀ¼�ṹ������ʧ��ֱ�ӷ���
				if (!CreateDirecroty(remotefilename)) {
					throw new Exception("�ļ�Ŀ¼����ʧ��");
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
			throw new Exception("����Ʊ������ʧ��");

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
	 * ����Զ�̷������ļ�
	 * 
	 * @param remote
	 * @return
	 * @throws IOException
	 */
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote.substring(0, remote.lastIndexOf("/") + 1);

		// ���Զ��Ŀ¼�����ڣ���ݹ鴴��Զ�̷�����Ŀ¼
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
						System.out.println("����Ŀ¼ʧ��");
						success = false;
						return success;
					}
				}
				start = end + 1;
				end = directory.indexOf("/", start);
				// �������Ŀ¼�Ƿ񴴽����
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}
}