package com.cd.xml;

/**
 * 
 * <ul>
 * <li>1���������ڣ�Jul 17, 2010</li>
 * <li>2������ʱ�䣺10:54:49 PM</li>
 * <li>3���������ƣ�PicpMessageException</li>
 * <li>4��������ͼ��Message�쳣����</li>
 * </ul>
 * 
 * 
 */
public class PicpMessageException extends Exception {
	private static final long serialVersionUID = 1L;

	public PicpMessageException() {
		super();
	}

	public PicpMessageException(String msg) {
		super(msg);
	}

	public PicpMessageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PicpMessageException(Throwable cause) {
		super(cause);
	}
}