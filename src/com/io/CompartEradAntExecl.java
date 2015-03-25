/*
 * Copyright (C) 2012 Oki Electric Industry Co., Ltd.
 * $HeadURL$
 */
package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 文件比对。
 * 
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class CompartEradAntExecl {

	/**
	 * 版本番号
	 */
	private static final String RELEASE_HANPO = "\\20121211_03";



	/**
	 * 【申請書】MULTI_IT_20121109_02.xlsの"○"のPAｔｈ
	 */
	private static final String EXCEL_PATH = "D:\\e-rad\\70_LIB管理\\fileTest.txt";

	/**
	 * LIB管理ファルダ
	 */
	private static final String FOLDER_PATH = "D:\\e-rad\\70_LIB管理";

	private static final String SISAN = "\\資産";

	private static final String SS = "資産\\";

	private static Map<String, String> folderMap = new HashMap<String, String>();

	private static List<String> errorsFolder = new ArrayList<String>();

	private static Map<String, String> excelMap = new HashMap<String, String>();

	private static List<String> errorsExcel = new ArrayList<String>();

	/**
	 * 空文字列の定数値。<BR>
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		getFolderFilesPath(new File(new StringBuilder().append(FOLDER_PATH).append(RELEASE_HANPO).append(SISAN)
				.toString()));

		getExcelFilesPath(EXCEL_PATH);

		// 比较
		compareExcelAndFolderSource();

		if (errorsFolder.size() != 0) {

			System.out.println("申請書中有而資産中没有：");
			for (String errorsPath : errorsFolder) {

				System.out.println(errorsPath);
			}

		}

		if (errorsExcel.size() != 0) {
			System.out.println("資産中有而申請書中没有：");
			for (String errorsPath : errorsExcel) {

				System.out.println(errorsPath);
			}
		}

		System.out.println("执行完了!");
	}

	/**
	 * 取得文件中的路径。
	 */
	public static void getExcelFilesPath(String excelPath) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(excelPath)));
			String line = "";
			while ((line = br.readLine()) != null) {
				excelMap.put(line, EMPTY_STRING);
			}
		} catch (Exception e) {
			System.out.println("没找到设置的路径！！！！请设置正确的路径。");
		}
	}

	/**
	 * 取得Folder中所有文件的路径。
	 */
	private static void getFolderFilesPath(File folderFile) {

		File[] file = folderFile.listFiles();

		for (int i = 0; i < file.length; i++) {

			if (file[i].isFile()) {
				folderMap.put(file[i].getPath().substring(file[i].getPath().indexOf(SS) + 3).replace("\\", "/"),
						EMPTY_STRING);
			} else {
				getFolderFilesPath(file[i]);
			}
		}
	}

	/**
	 * 查看两个文件是否匹对。
	 */
	@SuppressWarnings("unchecked")
	private static void compareExcelAndFolderSource() {

		Collection<?> excel = excelMap.entrySet();

		Iterator it = excel.iterator();
		while (it.hasNext()) {
			String nextKey = it.next().toString();
			// 文件夹-> excel
			if (folderMap.containsKey(nextKey.substring(0, nextKey.indexOf("=")))) {
				continue;
			} else {
				errorsFolder.add(nextKey.substring(0, nextKey.indexOf("=")));
			}
		}

		Collection<?> folder = folderMap.entrySet();

		Iterator folderIt = folder.iterator();
		while (folderIt.hasNext()) {
			String nextKey = folderIt.next().toString();
			// 文件夹-> excel
			if (excelMap.containsKey(nextKey.substring(0, nextKey.indexOf("=")))) {
				continue;
			} else {
				errorsExcel.add(nextKey.substring(0, nextKey.indexOf("=")));
			}
		}
	}
}