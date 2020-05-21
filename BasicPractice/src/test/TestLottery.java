package test;

import java.util.Arrays;
import java.util.Scanner;

public class TestLottery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ˫ɫ����ϰ
		 */
		int[] result = lottery();
		System.out.println("�н��Ĳ�Ʊ����Ϊ��"+Arrays.toString(result));
		Scanner sc = new Scanner(System.in);
		System.out.println("ǰ6������Ϊ�������(1~33)");
		System.out.println("���һ������Ϊ�������(1~16)");
		System.out.println("�����빺��Ĳ�Ʊ����:");
		int n = 0;
		int temp;
		boolean flag = true;
		int[] num = new int[7];
		while(n<7) {
			if(sc.hasNextInt()) {
				temp = sc.nextInt();
				if(n<6) {
					flag = true;
					if(temp>=1 && temp<=33) {
						for(int i=0;i<num.length-1;i++) {
							if(temp == num[i]) {
								flag = false;
							}
						}
						if(flag) {
							num[n] = temp;
							n++;
						}else {
							System.out.println("���������ظ����֣����������룡");
						}
					}else {
						System.out.println("����ֻ����������(1~33)�����������룡");
					}	
				}else if(n == 6) {
					if(temp>=1 && temp<=16) {
						num[n] = temp;
						n++;
						break;
					}else {
						System.out.println("����ֻ����������(1~16)�����������룡");
					}	
				}
			}else {
				System.out.println("ֻ���������֣����������룡");
			}
		}
		System.out.println("������Ĳ�Ʊ����Ϊ��"+Arrays.toString(num));
		String kinds;
		int red = 0;
		int blue = 0;
		for(int i=0;i<result.length-1;i++) {
			for(int j=0;j<num.length-1;j++) {
				if(result[i]==num[j]) {
					red++;
				}
			}
		}
		if(result[6]==num[6]) {
			blue++;
		}
		kinds = red+"+"+blue;
		if(blue==1 || red>3) {
			System.out.println("��ϲ������"+kinds);
			switch(kinds) {
			case "6+1":
				System.out.println("����1000��Ԫ��");
				break;
			case "6+0":
				System.out.println("����500��Ԫ��");
				break;
			case "5+1":
				System.out.println("����3000Ԫ��");
				break;
			case "5+0":
			case "4+1":
				System.out.println("����200Ԫ��");
				break;
			case "4+0":
			case "3+1":
				System.out.println("����10Ԫ��");
				break;
			case "2+1":
			case "1+1":
			case "0+1":
				System.out.println("����5Ԫ��");
				break;
			}
		}else {
			System.out.println("лл�ݹˣ�");
		}
		sc.close();
	}
	/*
	 * ��Ʊ��������ɷ���
	 */
	public static int[] lottery() {
		int[] result = new int[7];
		int[] pool = new int[33];
		int temp;
		for(int i=0;i<pool.length;i++) {
			pool[i] = i+1;
		}
		for(int j=0;j<6;j++) {
			temp = (int)(Math.random()*(pool.length));//�������ȡ��һ���±�
			result[j] = pool[temp];
			int[] newPool = new int[pool.length-1];
			for(int n=0;n<pool.length-1;n++) {
				if(n<temp) {
					newPool[n] = pool[n];
				}
				if(n>temp) {
					newPool[n-1] = pool[n];
				}
			}
			pool = newPool;
		}
		result[6] = (int)(Math.random()*16+1);
		return result;
//		int[] result = new int[7];
//		int n = 0;
//		int temp;
//		boolean flag;
//		while(n<6) {
//			flag = true;
//			temp = (int)(Math.random()*33+1);
//			for(int i=0;i<6;i++) {
//				if(temp==result[i]) {
//					flag = false;
//				}
//			}
//			if(flag) {
//				result[n] = temp;
//				n++;
//			}
//		}
//		result[6] = (int)(Math.random()*16+1);
//		return result;
	}
}
