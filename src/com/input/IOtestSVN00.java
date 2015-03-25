package com.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1，将c盘下的e-rad文件夹删除掉。
 * 2，将日本来的execl中的内容(也即路径)复制到c:/fileTest.txt中(若没有，那么自己建一个fileTest.txt)。
 * 3，将变量pathPre改成erad代码的路径。如果已经是C:\\workspace\\e-rad\\，那么就不用改了。
 * 4，下面程序生成的文件在c:/e-rad中。
 * 5，在变量error中输出的路径是存在问题的。
 * 
 * @author Administrator
 */
public class IOtestSVN00 {
	
	static String SISAN_DATE = "20121211_01";
	
	
	public static void main(String[] args) throws IOException {
		test("d:\\e-rad\\70_LIB管理\\fileTest.txt");
		if (error.size() > 0) System.out.println("下面的是存在问题的：请对应！！！");
		for(String str:error) System.out.println(str); System.out.println("\n执行完毕");
	}

	static String copyPath = "D:\\e-rad\\70_LIB管理\\";
	static String SISAN = "\\資産\\";
	static String PROJECT_PATH = "e-rad\\";
	static String pathPre = "C:\\workspace\\e-rad\\";
	static List<String> error = new ArrayList<String>();
	static void test(String filePa) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(new File(filePa))));
		String line;
		while ((line = br.readLine()) != null && (line = line.trim()) != "") {
			line = line.replace("/", "\\");
			if (line.contains(PROJECT_PATH)) {
				String strLine = line;
				line = line.substring(line.lastIndexOf(PROJECT_PATH)+PROJECT_PATH.length());
				FileInputStream br2 = null;
				FileOutputStream bw2 = null;
				try {
					File pathIn = new File(pathPre+line);
					br2 = new FileInputStream(pathIn);
					File pathOut = new File(copyPath+SISAN_DATE+SISAN+PROJECT_PATH+line.substring(0, line.lastIndexOf("\\")));
					if (!pathOut.exists()) { pathOut.mkdirs(); }
					bw2 = new FileOutputStream(new File(pathOut.getPath()+line.substring(line.lastIndexOf("\\"))));
					byte [] b = new byte[(int)pathIn.length()];
					br2.read(b); bw2.write(b);
					br2.close(); bw2.close();
				} catch (Exception e) {
					error.add(strLine);
				} finally {
					if (br2 != null) br2.close();
					if (bw2 != null) bw2.close();
				}
			} else error.add(line);
		}
	}
}