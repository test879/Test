/*
 * Copyright (C) 2012 Oki Electric Industry Co., Ltd.
 * $HeadURL$
 */
package com.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * 
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class DirList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File path = new File("D:\\e-rad\\70_LIBπ‹¿Ì\\20121120_05\\");
			String[] list;
			if (args.length == 0)
				list = path.list();
			else
				list = path.list(new DirFilter(args[0]));
			for (int i = 0; i < list.length; i++)
				System.out.println(list[i]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class DirFilter implements FilenameFilter {
	String afn;

	DirFilter(String afn) {
		this.afn = afn;
	}

	public boolean accept(File dir, String name) {
		// Strip path information:
		String f = new File(name).getName();
		return f.indexOf(afn) != -1;
	}
}