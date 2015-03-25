package com.cd.arrays;

import java.util.Arrays;

public class TestArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arraysInt = {2,4,6,8,9,8,5,3,3677,2,2,45,3,7};

		Arrays.sort(arraysInt);
		
		for(int p : arraysInt){
			System.out.println(p);
			
		}
		
	}

}
