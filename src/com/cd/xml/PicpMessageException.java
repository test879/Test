package com.cd.xml;

/**
 * 
 * <ul>
 * <li>1、开发日期：Jul 17, 2010</li>
 * <li>2、开发时间：10:54:49 PM</li>
 * <li>3、类型名称：PicpMessageException</li>
 * <li>4、类型意图：Message异常对象</li>
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
