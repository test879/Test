/**
 * FileName: DllTest.java <br/>
 */
package com.dll;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;

/**
 * Project: Test <br/>
 * Class: com.dll.DllTest <br/>
 * Description: <������Ĺ���>. <br/>
 * Copyright: Copyright (c) 2015 <br/>
 * Makedate: 2015��11��11�� ����11:55:18 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
public class DllTest {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 * @throws NativeException
	 */
	public static void main(String[] args) throws NativeException {

		JNative.setLoggingEnabled(true);
		try {
			JNative getUrl = new JNative("EhfscliaxDll.dll", "getUrl"); // ���� getUrl ������<span
																		// style="font-family: Arial, Helvetica, sans-serif;">JNative����</span>
			getUrl.setRetVal(Type.STRING); // ���÷���ֵ����Ϊ��String
			getUrl.setParameter(0, "127.0.0.1"); // ��˳�����÷�����Ҫ�Ĳ���ֵ
			getUrl.setParameter(1, 10087);
			getUrl.setParameter(2, 123);
			getUrl.invoke(); // ���÷���
			System.out.println(getUrl.getRetVal()); // �������ֵ
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			JNative getPlayUrl = new JNative("EhfscliaxDll.dll", "getPlayUrl");
			getPlayUrl.setRetVal(Type.INT); // �˷�����DLL�ж���ķ���ֵ����Ϊ��const wchar_t*��������÷���ֵ����Ϊ��String����ֻ�ܻ�ȡ������ֵ�ĵ�һ���ַ�

			String mgrIp = "127.0.0.1";
			Pointer ptr = Pointer.createPointerFromString(mgrIp);

			getPlayUrl.setParameter(0, ptr);
			getPlayUrl.setParameter(1, 10087);
			getPlayUrl.setParameter(2, 123);
			getPlayUrl.invoke();
			// �������getRetValAsInt�ǻ�ȡ����ֵ��ָ���ַ��<span
			// style="font-family: Arial, Helvetica, sans-serif;">getUnicodeMemoryAsString������ָ���ַ���ڴ��ж�ȡ�ַ���</span>
			String url = JNative.getUnicodeMemoryAsString(getPlayUrl.getRetValAsInt());
			System.out.println(url);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
