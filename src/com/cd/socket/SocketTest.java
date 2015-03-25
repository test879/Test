package com.cd.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ServerSocket server = null;
        try {
            server = new ServerSocket(9003);
        } catch (IOException e) {
        	e.printStackTrace();
            return;
        }
		Socket conn = null;
		try {
			conn = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		StringBuffer serverIpId = new StringBuffer("127.0.0.2");
		StringBuffer portNoId = new StringBuffer("9003"); 
		
		String returnString = "";
		DataInputStream in = null;
		DataOutputStream out = null;
		Socket socket = null;
		String message = "天下无贼！！！";
		
		try {
			// 初始化
			String serverIp = new String(serverIpId);
			int portNo=Integer.parseInt(new String(portNoId));
			socket = new Socket(serverIp, portNo);
			int backtimeout = 42000;
			socket.setSoTimeout(backtimeout);// 设置超时时间
			in = new DataInputStream(new BufferedInputStream(socket
					.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(socket
					.getOutputStream()));
			String sendEncode = "UTF-8";// 发送字符集的设置
			byte[] outb = new byte[message.getBytes(sendEncode).length];
			outb = message.getBytes(sendEncode);
			out.write(outb);
			out.flush();
			// 报文长度
			byte[] msglength = new byte[8];
			in.read(msglength, 0, 8);
			int len = Integer.parseInt(new String(msglength));// 报文长度
			Thread.sleep(1);
			byte[] inb = new byte[len];
			in.readFully(inb, 0, len);
			String recvencode = "UTF-8";// 接收字符集的设置
			returnString = new String(inb, recvencode);

		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
		try {
			System.out.println(conn.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
