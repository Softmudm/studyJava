package test;

import java.util.Arrays;
import java.util.Scanner;

public class TestArray {	
	/**
	 * ������ϰ
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * ��������
		 */
		int[] before = new int[5];
		for(int i=0;i<before.length;i++) {
			before[i] = i+1;
		}
		int[] after = Arrays.copyOf(before,6);
		after[5] = 6;
		System.out.println(Arrays.toString(after));
		/*
		 * ����ɾ��
		 */
		System.out.println("Ҫɾ���ڼ�����");
		Scanner sc = new Scanner(System.in);
		int delete = 0;
		while(true) {
			if(sc.hasNextInt()) {
				delete=sc.nextInt()-1;
				if(delete>=0&&delete<after.length) {
					break;
				}else {
					System.out.println("��������ȷ�����֣�");
					//sc.next();
				}
			}else {
				System.out.println("���������֣�");
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
