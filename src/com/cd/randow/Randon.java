package com.cd.randow;

public class Randon {

	/**
	 * 描述 : <描述函数实现的功能>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getThreadId(0));
	}
	
	/**
     * 由当前系统时间的毫秒数以及五位的随机数产生18位的线程唯一标识
     * @return
     */
    public static String getThreadId(int randomLength){
    	int b=(int)(Math.random()*10000);//产生随机数
    	String bs=String.valueOf(b);
		while(bs.length()<randomLength){//生成固定五位长度的随机数
			bs="0".concat(bs);
		}
    	
		return String.valueOf(System.currentTimeMillis()).concat(bs);
    }

}
