package test;

import java.util.Arrays;
import java.util.Scanner;

public class TestArray {	
	/**
	 * 数组练习
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 数组扩容
		 */
		int[] before = new int[5];
		for(int i=0;i<before.length;i++) {
			before[i] = i+1;
		}
		int[] after = Arrays.copyOf(before,6);
		after[5] = 6;
		System.out.println(Arrays.toString(after));
		/*
		 * 数组删除
		 */
		System.out.println("要删除第几个：");
		Scanner sc = new Scanner(System.in);
		int delete = 0;
		while(true) {
			if(sc.hasNextInt()) {
				delete=sc.nextInt()-1;
				if(delete>=0&&delete<after.length) {
					break;
				}else {
					System.out.println("请输入正确的数字！");
					//sc.next();
				}
			}else {
				System.out.println("请输入数字！");
				sc.next();
			}
		}
		for(int i=delete;i<after.length;i++) {
			if((i+1)==after.length) {
				break;
			}
			after[i]=after[i+1];
		}
		int[] last = Arrays.copyOf(after, 5);
		System.out.println(Arrays.toString(last));
		sc.close();
	}	
}
