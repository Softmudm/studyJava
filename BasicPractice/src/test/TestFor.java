package test;

import java.util.Scanner;

public class TestFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ��ӡ99�˷���
		 */
		for(int x=1;x<=9;x++) {
			for(int y=1;y<=x;y++) {
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}
		/**
		 * ��ӡ      *
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
		 * ��ӡ      *
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
		 * һ��Ԫ��һ��ֻ�����ٶ�С��ÿֻ5�ǣ�����ÿֻ2Ԫ��ĸ��ÿֻ3Ԫ��������100ԪǮҪ����100ֻ��������г����п��ܵĹ�������(����forѭ��Ƕ��)
		 */
		int t =0;
		for(int small=0;small<=100;small++) {
			for(int middle=0;middle<=50;middle++) {
				for(int large=0;large<=33;large++) {
					if(((small*0.5)+(middle*2)+(large*3))==100&&(small+middle+large)==100) {//���������ͼ۸񶼸պõ���100
						t++;
						System.out.println("����"+t+":С��"+small+"ֻ,����"+middle+"ֻ,ĸ��"+large+"ֻ��");
					}
				}
			}
		}
		/**
		 * ��ӡ1-100֮�ڵ���������
		 */
		int u=0;
		System.out.println();
		System.out.println("��ӡ1-100֮�ڵ���������:");
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
		System.out.println("\n����һ����"+u+"��");
		System.out.println();
		/**
		 * ����һ������,�жϸ������Ƿ�������
		 */
		Scanner sc = new Scanner(System.in);
		int num;
		String str;
		while(true) {
			System.out.println("������һ����������");
			if(sc.hasNextInt()) {
				num = sc.nextInt();
				if(num>0) {
					if(judgePrimeNumber(num)) {
						System.out.println(num+"��������");
						break;
					}else {
						System.out.println(num+"����������");
						break;
					}
				}else if(num==1){
					System.out.println("1�Ȳ�������Ҳ���Ǻ���");
					continue;
				}else {
					System.out.println("0����������������������һ����������");
					continue;
				}
			}else {
				str = sc.next();
				System.out.println(str+"����������������������һ����������");
				continue;
			}
		}	
		sc.close();
	}
	/**
	 * �ж��Ƿ�������(��2��ʼ)��true����             false������
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
