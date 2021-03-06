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

	// 生成文件包
	public static void createWorkBag(String workPath) {
		File file = new File(workPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	// 以时间为文件得到路径
	public static String createTimeBagRead(String basePath, String timeStamp) {
		String path = "";
		// String time = timeStamp3(timeStamp);
		path = path + timeStamp.substring(0, 4) + "/"
				+ timeStamp.substring(4, 6) + "/" + timeStamp.substring(6, 8)
				+ "/";
		basePath = basePath + path;
		return basePath;
	}

	// 以时间为文件生成路径
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

	// 数组转换，把 一纬数组 转换成 2纬数组
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

	// 根据传进的文件格式进行判断转换,组合成 XXXX.xls
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

	// 得到现在的系统时刻
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

	// 以时间为文件生成路径
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
	 * 转移文件目录 转移文件目录不等同于复制文件，转移后只有新目录中存在该文件。
	 * 
	 * @param filename
	 *            文件名
	 * @param oldpath
	 *            旧目录 格式 folder/
	 * @param newpath
	 *            新目录 格式 folder/
	 * @param cover
	 *            若新目录下存在和转移文件具有相同文件名的文件时，是否覆盖新目录下文件，cover=true将会覆盖原文件，否则不操作
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
				if (newfile.exists()) {// 若在待转移目录下，已经存在待转移文件
					if (cover) {// 覆盖
						newfile.delete();// 先删除已经存在的同名文件 在转移
						return oldfile.renameTo(newfile);
					} else {
						newfile = new File(
								newpath
										+ filename
										+ "_1");
						// System.out.println("在新目录便不存在："+filename);
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
	 * 判断 索引文件是不是存在
	 * 
	 * @param filename
	 *            文件名称 格式为 c:/s/folderpath/ECDS-20100301.txt
	 */
	public static Boolean isExistFile(String filename) {
		File file = new File(filename);
		if (file.exists())
			return true;
		else
			return false;
	}

	/**
	 * 取得项目根目录文件夹物理路径 空格替换掉 20%
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
	 * 替换文件路径的 斜杠统一替换为\
	 * 
	 * @param a
	 */
	public static String replaceAllPathSeparator(String path) {
		String rePath = path.replaceAll("[/]", "\\\\");
		return rePath;
	}

	/**
	 * 循环删除 纸票文件
	 * 
	 * @param indexFilename
	 *            索引的文件名
	 * @param List
	 *            存放在索引里的其他文件的名字
	 * @param folderPath
	 *            存放文件跟文件夹
	 * @param moveFolderPath
	 *            移动的文件夹
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
		// System.out.println(FileUtils.copyOsdevFile("D:\\ECDS\\exception.xls","D:\\ECDS\\ecds_2010-05-17\\ecds_ex_2010-05-17.xls","错误西西"));
	}

	/**
	 * 从指定的目录新建一个xls文件显示错误信息
	 * 
	 * @param oldpath
	 *            你要copy的原始文档路径
	 * @param newpath
	 *            copy之后放到的文档路径
	 * @return str 返回的值如果是“成功”就表示拷贝完成
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
				// 判断单元格的类型,做出相应的转换
				if (wc.getType() == CellType.LABEL) {
					Label label = (Label) wc;
					label.setString(extext);
				}
				wwb.write();
				wwb.close();
				rwb.close();
			} else {
				str = "找不到指定的目录";
			}
			str = "成功";
		} catch (Exception ex) {
			ex.printStackTrace();
			str = ex.getMessage();
		} finally {
			return str;
		}
	}

	/**
	 * 根据路径取得路径下的所有文件名
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
	 * 删除文件，可以是单个文件或文件夹
	 * 
	 * @param fileName
	 *            待删除的文件名
	 * @return 文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFileOrFolde(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("删除文件失败：" + fileName + "文件不存在");
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
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("删除单个文件" + fileName + "成功！");
			return true;
		} else {
			System.out.println("删除单个文件" + fileName + "失败！");
			return false;
		}
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true,否则返回false
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("删除目录失败" + dir + "目录不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("删除目录失败");
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			System.out.println("删除目录" + dir + "成功！");
			return true;
		} else {
			System.out.println("删除目录" + dir + "失败！");
			return false;
		}
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
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
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		deleteFile(oldPath);
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
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
				deleteAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				deleteDirectory(path + "/" + tempList[i]);// 再删除空文件夹
				bea = true;
			}
		}
		return bea;
	}

}
