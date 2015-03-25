package com.algorithm;

import java.util.ArrayList;

public class s68 {
	private static ArrayList<String> list = new ArrayList<String>();

	public static ArrayList<String> getList() {
		return list;
	}

	public static void printList() {
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static void getMax() {
		String min = list.get(0);
		for (int i = 0; i < list.size(); i++)
			if (min.compareTo(list.get(i)) > 0) // min > string，那么min就不是最小的，调换
			{
				min = list.get(i);
			}
		System.out.println("the min of the compose is " + min);
	}

	public static void swap(int[] str, int i, int j) {
		int temp = new Integer(0);
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	public static void arrange(int[] str, int st, int len) {
		if (st == len - 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				// System.out.print(str[i]+ "  ");
				sb.append(str[i]);
			}
			list.add(sb.toString());
			// System.out.println();
			// total++;
		} else {
			for (int i = st; i < len; i++) {
				swap(str, st, i);
				arrange(str, st + 1, len);
				swap(str, st, i);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList list = new ArrayList();
		// s68 s = new s68();
		// list = s.defact(687);
		// for (int i = 0; i < list.size(); i ++)
		// {
		// System.out.print(list.get(i)+ "  ");
		// }
//		String str[] = { "32", "45", "78" };
//		int val[] = { 532, 45, 78 };
//		arrange(val, 0, 3);
//		printList();
//		getMax();
		
		int val[] = { 45, 123};
		arrange(val, 0, 2);
		printList();
		getMax();
	}
}