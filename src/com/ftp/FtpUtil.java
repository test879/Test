package com.ftp;

import java.util.ResourceBundle;

import com.cd.StringUtil;

/**
 * java实现FTP上传
 * 
 * @author dell
 *
 */
public class FtpUtil {

	// 默认服务器中路径
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
	 * 描述 : 取得图片存储路径. <br/>
	 * <p>
	 * 
	 * @param imagePathWay
	 *            图片存储位置 send recv
	 * @param imageName
	 *            图片名称
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