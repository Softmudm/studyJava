package test;

import java.util.Scanner;

public class TestWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * while打印上午学习，下午编程，直到输入“y”才完成任务
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		String putin = sc.next();
		while (!"y".equals(putin)) {
			System.out.println("上午学习，下午编程");
			putin = sc.next();
		}
		System.out.println("完成任务");
		sc.close();
		/**
		 * 2006年培养学员8万人，每年增长25%，请问按此增长速度，到哪一年培训学员人数将达到20万人？
		 */
		int year = 2006;
		int student = 80000;
		float growth = 0.25F;
		while(student<200000) {
			student *=(1+growth);
			year++;
		}
		System.out.println(year+"年培训学员人数将达到20万人。实际人数："+student);
		/**
		 * 计算100以内偶数之和
		 */
		int num = 1;
		int sum = 0;
		while(num<100) {
			if(num%2==0) {
				sum +=num;
			}
			num++;
		}
		System.out.println("100以内偶数之和为:"+sum);
	}

}
