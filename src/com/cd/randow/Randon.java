package com.cd.randow;

public class Randon {

	/**
	 * ���� : <��������ʵ�ֵĹ���>. <br/>
	 * <p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getThreadId(0));
	}
	
	/**
     * �ɵ�ǰϵͳʱ��ĺ������Լ���λ�����������18λ���߳�Ψһ��ʶ
     * @return
     */
    public static String getThreadId(int randomLength){
    	int b=(int)(Math.random()*10000);//���������
    	String bs=String.valueOf(b);
		while(bs.length()<randomLength){//���ɹ̶���λ���ȵ������
			bs="0".concat(bs);
		}
    	
		return String.valueOf(System.currentTimeMillis()).concat(bs);
    }

}
