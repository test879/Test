package com.cd.form;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueryBankInfoForm qbIform = new QueryBankInfoForm();
		if(qbIform instanceof BaseActionForm){
			System.out.println("2222");
		} else {
			System.out.println("222111");
		}
	}

}
