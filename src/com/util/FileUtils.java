package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import jxl.CellType;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FileUtils {

	// �����ļ���
	public static void createWorkBag(String workPath) {
		File file = new File(workPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	// ��ʱ��Ϊ�ļ��õ�·��
	public static String createTimeBagRead(String basePath, String timeStamp) {
		String path = "";
		// String time = timeStamp3(timeStamp);
		path = path + timeStamp.substring(0, 4) + "/"
				+ timeStamp.substring(4, 6) + "/" + timeStamp.substring(6, 8)
				+ "/";
		basePath = basePath + path;
		return basePath;
	}

	// ��ʱ��Ϊ�ļ�����·��
	public static String createTimeBag(String basePath, String timeStamp) {
		String path = "";
		// String time = timeStamp3(timeStamp);
		path = path + timeStamp.substring(0, 4) + "\\"
				+ timeStamp.substring(4, 6) + "\\" + timeStamp.substring(6, 8)
				+ "\\";
		basePath = basePath + path;
		createWorkBag(basePath);
		return basePath;
	}

	// ����ת������ һγ���� ת���� 2γ����
	public static String[][] getArray(String[] name) {
		int length = name.length;
		String[][] outValue = new String[length][1];
		for (int i = 0; i < length; i++) {
			outValue[i][0] = name[i];
		}
		return outValue;
	}

	public static void createFile(String filePath, InputStream input) {
		try {
			byte[] by = new byte[8192];
			File file = new File(filePath);
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(file));
			BufferedInputStream in = new BufferedInputStream(input);
			int line;
			while ((line = in.read(by)) != -1) {
				out.write(by, 0, line);
			}
			out.flush();
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createFileInc(String filePath, String resource) {
		try {
			File file = new File(filePath);
			PrintWriter pw = new PrintWriter(new FileOutputStream(file));
			pw.println(resource);
			pw.close();
		} catch (IOException e) {
		}
	}

	// ���ݴ������ļ���ʽ�����ж�ת��,��ϳ� XXXX.xls
	public static String processFileTail(String fileName, String synax) {
		String resultFileName = "";
		int dot = fileName.indexOf(".");
		if (dot > 0) {
			resultFileName = fileName.substring(0, dot) + synax;
		} else {
			resultFileName = fileName + synax;
		}
		return resultFileName;
	}

	// �õ����ڵ�ϵͳʱ��
	public static String timeStamp(boolean boo) {
		String currentTime = "";
		String parameter = "";
		if (boo) {
			parameter = "yyyyMMddHHmmss";
		} else {
			parameter = "yyyyMMdd";
		}
		Calendar a = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat(parameter);
		currentTime = s.format(a.getTime());
		return currentTime;
	}

	// ��ʱ��Ϊ�ļ�����·��
	public static String createTimeBag(String basePath) {
		String path = "";
		String timeStamp = timeStamp(false);
		path = path + timeStamp.substring(0, 4) + "\\"
				+ timeStamp.substring(4, 6) + "\\" + timeStamp.substring(6, 8)
				+ "\\";
		basePath = basePath + path;
		createWorkBag(basePath);
		return basePath;
	}

	/**
	 * ת���ļ�Ŀ¼ ת���ļ�Ŀ¼����ͬ�ڸ����ļ���ת�ƺ�ֻ����Ŀ¼�д��ڸ��ļ���
	 * 
	 * @param filename
	 *            �ļ���
	 * @param oldpath
	 *            ��Ŀ¼ ��ʽ folder/
	 * @param newpath
	 *            ��Ŀ¼ ��ʽ folder/
	 * @param cover
	 *            ����Ŀ¼�´��ں�ת���ļ�������ͬ�ļ������ļ�ʱ���Ƿ񸲸���Ŀ¼���ļ���cover=true���Ḳ��ԭ�ļ������򲻲���
	 * @throws MessageException
	 */
	public static Boolean changeDirectory(String filename, String oldpath,
			String newpath, boolean cover) {
		try {
			if (!oldpath.equals(newpath)) {
				File foldernewpath = new File(newpath);
				if (!foldernewpath.isDirectory()) {
					foldernewpath.mkdir();
				}
				File oldfile = new File(oldpath + filename);
				File newfile = new File(newpath + filename);
				if (newfile.exists()) {// ���ڴ�ת��Ŀ¼�£��Ѿ����ڴ�ת���ļ�
					if (cover) {// ����
						newfile.delete();// ��ɾ���Ѿ����ڵ�ͬ���ļ� ��ת��
						return oldfile.renameTo(newfile);
					} else {
						newfile = new File(
								newpath
										+ filename
										+ "_1");
						// System.out.println("����Ŀ¼�㲻���ڣ�"+filename);
						return oldfile.renameTo(newfile);
					}
				} else {
					return oldfile.renameTo(newfile);
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * �ж� �����ļ��ǲ��Ǵ���
	 * 
	 * @param filename
	 *            �ļ����� ��ʽΪ c:/s/folderpath/ECDS-20100301.txt
	 */
	public static Boolean isExistFile(String filename) {
		File file = new File(filename);
		if (file.exists())
			return true;
		else
			return false;
	}

	/**
	 * ȡ����Ŀ��Ŀ¼�ļ�������·�� �ո��滻�� 20%
	 * 
	 * @return
	 */
	public static String getFolderPath() {
		String allpath = FileUtils.class.getResource("").getPath().replaceAll(
				"%20", " ");
		String folderPath = allpath.substring(1, allpath.indexOf("WEB-INF"));
		System.out.println("the folderPath is" + folderPath);
		return folderPath;
	}

	/**
	 * �滻�ļ�·���� б��ͳһ�滻Ϊ\
	 * 
	 * @param a
	 */
	public static String replaceAllPathSeparator(String path) {
		String rePath = path.replaceAll("[/]", "\\\\");
		return rePath;
	}

	/**
	 * ѭ��ɾ�� ֽƱ�ļ�
	 * 
	 * @param indexFilename
	 *            �������ļ���
	 * @param List
	 *            �����������������ļ�������
	 * @param folderPath
	 *            ����ļ����ļ���
	 * @param moveFolderPath
	 *            �ƶ����ļ���
	 * @throws MessageException
	 */
	@SuppressWarnings("unchecked")
	public static void deleteAllFiles(String indexFilename, List listnames,
			String folderPath, String moveFolderPath) {
		for (int i = 0; i < listnames.size(); i++) {
			String filenamekey[] = (String[]) listnames.get(i);
			FileUtils.changeDirectory(filenamekey[1], folderPath,
					moveFolderPath, false);
		}

		FileUtils.changeDirectory(indexFilename, folderPath, moveFolderPath,
				false);
	}

	public static void main(String[] a) {
		System.out.print("2007-05-02".substring(5, 10));
		System.out.println(createTimeBag("g:\\"));
		// System.out.println(FileUtils.copyOsdevFile("D:\\ECDS\\exception.xls","D:\\ECDS\\ecds_2010-05-17\\ecds_ex_2010-05-17.xls","��������"));
	}

	/**
	 * ��ָ����Ŀ¼�½�һ��xls�ļ���ʾ������Ϣ
	 * 
	 * @param oldpath
	 *            ��Ҫcopy��ԭʼ�ĵ�·��
	 * @param newpath
	 *            copy֮��ŵ����ĵ�·��
	 * @return str ���ص�ֵ����ǡ��ɹ����ͱ�ʾ�������
	 */
	@SuppressWarnings("finally")
	public static String copyOsdevFile(String oldpath, String newpath,
			String extext) {
		String str = "";
		try {
			if (FileUtils.isExistFile(oldpath)) {
				Workbook rwb = Workbook.getWorkbook(new File(oldpath));
				WritableWorkbook wwb = Workbook.createWorkbook(
						new File(newpath), rwb);// copy
				WritableSheet ws = wwb.getSheet(0);
				WritableCell wc = ws.getWritableCell(1, 1);
				// �жϵ�Ԫ�������,������Ӧ��ת��
				if (wc.getType() == CellType.LABEL) {
					Label label = (Label) wc;
					label.setString(extext);
				}
				wwb.write();
				wwb.close();
				rwb.close();
			} else {
				str = "�Ҳ���ָ����Ŀ¼";
			}
			str = "�ɹ�";
		} catch (Exception ex) {
			ex.printStackTrace();
			str = ex.getMessage();
		} finally {
			return str;
		}
	}

	/**
	 * ����·��ȡ��·���µ������ļ���
	 * 
	 * @param filename
	 * @return
	 */
	public static String[] getAllFile(String filename) {
		File file = new File(filename);
		String[] fileList = null;
		try {
			fileList = file.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

	/**
	 * ɾ���ļ��������ǵ����ļ����ļ���
	 * 
	 * @param fileName
	 *            ��ɾ�����ļ���
	 * @return �ļ�ɾ���ɹ�����true,���򷵻�false
	 */
	public static boolean deleteFileOrFolde(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("ɾ���ļ�ʧ�ܣ�" + fileName + "�ļ�������");
			return false;
		} else {
			if (file.isFile()) {

				return deleteFile(fileName);
			} else {
				return deleteDirectory(fileName);
			}
		}
	}

	/**
	 * ɾ�������ļ�
	 * 
	 * @param fileName
	 *            ��ɾ���ļ����ļ���
	 * @return �����ļ�ɾ���ɹ�����true,���򷵻�false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
			return true;
		} else {
			System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
			return false;
		}
	}

	/**
	 * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�
	 * 
	 * @param dir
	 *            ��ɾ��Ŀ¼���ļ�·��
	 * @return Ŀ¼ɾ���ɹ�����true,���򷵻�false
	 */
	public static boolean deleteDirectory(String dir) {
		// ���dir�����ļ��ָ�����β���Զ������ļ��ָ���
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("ɾ��Ŀ¼ʧ��" + dir + "Ŀ¼�����ڣ�");
			return false;
		}
		boolean flag = true;
		// ɾ���ļ����µ������ļ�(������Ŀ¼)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// ɾ����Ŀ¼
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("ɾ��Ŀ¼ʧ��");
			return false;
		}
		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} else {
			System.out.println("ɾ��Ŀ¼" + dir + "ʧ�ܣ�");
			return false;
		}
	}

	/**
	 * ���Ƶ����ļ�
	 * 
	 * @param oldPath
	 *            String ԭ�ļ�·�� �磺c:/fqf.txt
	 * @param newPath
	 *            String ���ƺ�·�� �磺f:/fqf.txt
	 * @return boolean
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // �ļ�����ʱ
				InputStream inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // �ֽ��� �ļ���С
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("���Ƶ����ļ���������");
			e.printStackTrace();
		}
	}

	/**
	 * ���������ļ�������
	 * 
	 * @param oldPath
	 *            String ԭ�ļ�·�� �磺c:/fqf
	 * @param newPath
	 *            String ���ƺ�·�� �磺f:/fqf/ff
	 * @return boolean
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			(new File(newPath)).mkdirs(); // ����ļ��в����� �������ļ���
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// ��������ļ���
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("���������ļ������ݲ�������");
			e.printStackTrace();
		}
	}

	/**
	 * �ƶ��ļ���ָ��Ŀ¼
	 * 
	 * @param oldPath
	 *            String �磺c:/fqf.txt
	 * @param newPath
	 *            String �磺d:/fqf.txt
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		deleteFile(oldPath);
	}

	/**
	 * ɾ��ָ���ļ����������ļ�
	 * 
	 * @param path
	 *            �ļ�����������·��
	 * @return
	 * @return
	 */
	public static boolean deleteAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) {
			return bea;
		}
		if (!file.isDirectory()) {
			return bea;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				deleteAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
				deleteDirectory(path + "/" + tempList[i]);// ��ɾ�����ļ���
				bea = true;
			}
		}
		return bea;
	}

}