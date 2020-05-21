package test;

import java.util.Scanner;

public class TestFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 打印99乘法表
		 */
		for(int x=1;x<=9;x++) {
			for(int y=1;y<=x;y++) {
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}
		/**
		 * 打印      *
		 *     ***
		 *    *****
		 *   *******
		 *  *********
		 * ***********
		 */
		for(int m=1;m<=6;m++) {
			for(int n=6;n>m;n--) {
				System.out.print("\40");
			}
			for(int o=0;o<(m*2-1);o++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		/**
		 * 打印      *
		 *     ***
		 *    *****
		 *   *******
		 *  *********
		 * ***********
		 *  *********
		 *   *******
		 *    *****
		 *     ***
		 *      * 
		 */
		for(int p=1;p<=5;p++) {
			for(int q=1;q<=p;q++) {
				System.out.print("\40");
			}
			for(int r=11;r>=2*p+1;r--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		/**
		 * 一百元买一百只鸡：假定小鸡每只5角，公鸡每只2元，母鸡每只3元。现在有100元钱要求买100只鸡，编程列出所有可能的购鸡方案(三个for循环嵌套)
		 */
		int t =0;
		for(int small=0;small<=100;small++) {
			for(int middle=0;middle<=50;middle++) {
				for(int large=0;large<=33;large++) {
					if(((small*0.5)+(middle*2)+(large*3))==100&&(small+middle+large)==100) {//鸡的数量和价格都刚好等于100
						t++;
						System.out.println("方案"+t+":小鸡"+small+"只,公鸡"+middle+"只,母鸡"+large+"只。");
					}
				}
			}
		}
		/**
		 * 打印1-100之内的所有质数
		 */
		int u=0;
		System.out.println();
		System.out.println("打印1-100之内的所有质数:");
		for(int s=2;s<=100;s++) {
			if(judgePrimeNumber(s)) {
				System.out.print(s+"\40");
				u++;
			}
		}
//		for(int s=2;s<=100;s++) {
//			u=0;
//			for(int v=2;v<s;v++) {
//				if(s%v==0) {
//					u++;
//				}
//			}
//			if(u==0) {
//				System.out.println(s);
//			}
//		}
		System.out.println("\n质数一共有"+u+"个");
		System.out.println();
		/**
		 * 给定一个数字,判断该数字是否是质数
		 */
		Scanner sc = new Scanner(System.in);
		int num;
		String str;
		while(true) {
			System.out.println("请输入一个正整数：");
			if(sc.hasNextInt()) {
				num = sc.nextInt();
				if(num>0) {
					if(judgePrimeNumber(num)) {
						System.out.println(num+"是质数！");
						break;
					}else {
						System.out.println(num+"不是质数！");
						break;
					}
				}else if(num==1){
					System.out.println("1既不是质数也不是合数");
					continue;
				}else {
					System.out.println("0不是正整数，请重新输入一个正整数：");
					continue;
				}
			}else {
				str = sc.next();
				System.out.println(str+"不是正整数，请重新输入一个正整数：");
				continue;
			}
		}	
		sc.close();
	}
	/**
	 * 判断是否是质数(从2开始)。true：是             false：不是
	 */
	public static boolean judgePrimeNumber(int num) {
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
