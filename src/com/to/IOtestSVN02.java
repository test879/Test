package com.to;

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
public class IOtestSVN02 {
	public static void main(String[] args) throws IOException {
		test("e:\\fileTest.txt");
		if (error.size() > 0) System.out.println("下面的是存在问题的：请对应！！！");
		for(String str:error) System.out.println(str); System.out.println("\n执行完毕");
	}

	static String pathPre = "C:\\workspace\\20121201\\e-rad\\";
	static List<String> error = new ArrayList<String>();
	static void test(String filePa) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(new File(filePa))));
		String line;
		while ((line = br.readLine()) != null && (line = line.trim()) != "") {
			line = line.replace("/", "\\");
			if (line.contains("e-rad\\")) {
				String strLine = line;
				line = line.substring(line.lastIndexOf("e-rad\\")+"e-rad\\".length());
				FileInputStream br2 = null;
				FileOutputStream bw2 = null;
				try {
					File pathIn = new File(pathPre+line);
					br2 = new FileInputStream(pathIn);
					File pathOut = new File("c:\\e-rad\\"+line.substring(0, line.lastIndexOf("\\")));
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