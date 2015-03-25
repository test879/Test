package com.util;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

/**
 * 利用apache net 开源包，使用telnet方式获取AIX主机信息
 * 
 * @version 1.2
 */
public class NetTelnet {

	// Telnet对象
	private TelnetClient telnet = new TelnetClient();

	private InputStream in;

	private PrintStream out;

	// 提示符。每个服务器都不一样 请注意修改~ #
	private String prompt = "#";

	// telnet端口
	private String port;

	// 用户
	private String user;

	// 密码
	private String password;

	// IP地址
	private String ip;

	public NetTelnet(String ip1, String user1, String password1, String port1) {

		try {
			// AIX主机IP
			this.ip = ip1;
			this.password = password1;
			this.user = user1;
			this.port = port1;
			telnet.connect(ip, Integer.parseInt(port));
			System.out.println("开始获取输入流...");
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());
			// 登录
			readUntil("login: ");
			write(user);
			readUntil("Password: ");
			write(password);
			readUntil(prompt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取分析结果
	 * 
	 * @param pattern
	 * @return
	 */
	public String readUntil(String pattern) {
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			StringBuffer sb = new StringBuffer();
			InputStreamReader br = new InputStreamReader(in);
			char ch = (char) br.read();
			while (true) {
				//System.out.print(ch);
				sb.append(ch);
				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}
				ch = (char) br.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("return null");
		return null;
	}

	/**
	 * 写
	 * 
	 * @param value
	 */
	public void write(String value) {
		try {
			out.println(value);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向目标发送命令字符串
	 * 
	 * @param command
	 * @return
	 */
	public String sendCommand(String command) {
		try {
			write(command);
			return readUntil(prompt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭连接
	 * 
	 */
	public void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String getTimeNetTelnet(String ip,String user,String pass,String port){
		NetTelnet nettelnet = null;
		String result = null;
		try {
			nettelnet = new NetTelnet("192.168.0.202", "root", "root","23");
			result = sendCommand("date -d today +'%Y%m%d'");
			nettelnet.disconnect();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			nettelnet.disconnect();
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("开始执行telnet......");
			NetTelnet telnet = new NetTelnet("192.168.0.124", "root", "root","23");
			/*System.out.println("开始发送hostname命令");
			String result = telnet.sendCommand("cd zy");
			System.out.println("显示结果");
			System.out.println(result);
			result = telnet.sendCommand("sh print.sh");
			System.out.println("显示结果");
			System.out.println(result);*/
			
			String result = telnet.sendCommand("cd /pmts/log/20150304/msg/");
			
			String resultLog = telnet.sendCommand("ls -i success.msg");
			String[] ss = resultLog.split(" ");
			
//			for (String string : ss) {
//				System.out.println(string);
//			}
			System.out.println(ss[2].split("\r\n")[1]);
			
//			System.out.println("---");
//			System.out.println(result.substring(result.lastIndexOf("["), result.lastIndexOf("[")+8));
			
			// 最后一定要关闭
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
