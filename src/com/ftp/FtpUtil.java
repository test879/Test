package com.ftp;

import java.util.ResourceBundle;

import com.cd.StringUtil;

/**
 * javaʵ��FTP�ϴ�
 * 
 * @author dell
 *
 */
public class FtpUtil {

	// Ĭ�Ϸ�������·��
	String remotefilename = "/server/cis/ftpdata";

	public static void main(String agrs[]) {

		FtpUtil fu = new FtpUtil();
		try {
			System.out.println(fu.getImageNamePath("123.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * ���� : ȡ��ͼƬ�洢·��. <br/>
	 * <p>
	 * 
	 * @param imagePathWay
	 *            ͼƬ�洢λ�� send recv
	 * @param imageName
	 *            ͼƬ����
	 * @return
	 */
	public String getImageNamePath(String imagePathWay) {
		ResourceBundle rb = ResourceBundle.getBundle("Syspara");

		if (!"".equals(StringUtil.nullToString(rb.getString("imagePath")))) {
			String remotefilenamePath = "";
			if (!"".equals(StringUtil.nullToString(rb.getString("ftppath")))) {
				remotefilenamePath = rb.getString("ftppath");
			}
			remotefilename = remotefilenamePath + rb.getString("imagePath");
		}

		remotefilename += "/" + imagePathWay;
		return remotefilename;
	}
}