package test;

import java.util.Scanner;

public class TestWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * while��ӡ����ѧϰ�������̣�ֱ�����롰y�����������
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("�����룺");
		String putin = sc.next();
		while (!"y".equals(putin)) {
			System.out.println("����ѧϰ��������");
			putin = sc.next();
		}
		System.out.println("�������");
		sc.close();
		/**
		 * 2006������ѧԱ8���ˣ�ÿ������25%�����ʰ��������ٶȣ�����һ����ѵѧԱ�������ﵽ20���ˣ�
		 */
		int year = 2006;
		int student = 80000;
		float growth = 0.25F;
		while(student<200000) {
			student *=(1+growth);
			year++;
		}
		System.out.println(year+"����ѵѧԱ�������ﵽ20���ˡ�ʵ��������"+student);
		/**
		 * ����100����ż��֮��
		 */
		int num = 1;
		int sum = 0;
		while(num<100) {
			if(num%2==0) {
				sum +=num;
			}
			num++;
		}
		System.out.println("100����ż��֮��Ϊ:"+sum);
	}

}
