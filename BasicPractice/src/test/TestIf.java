package test;

import java.util.Scanner;

/**
 * if��ϰdemo
 * @author Administrator
 *
 */

public class TestIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���������5000���Ҿ�ȥ���򷿣��û����뱼�۾��򱼳ۣ��û����뱦������� �������µϣ�����б�������������������ݷ�
		        �������500���Ҿ��򳵣�����б�������� ����������
		        ���û�н����Ҿ�Ҫȥ�ϰ࣬�������1000��Ǯ������Ե�ˣ�����ͳԿ��
		 */
		int money = 0,moneyaftercar,moneyafterhouse,mymoney;//�н����,��ʣ�࣬��ʣ�࣬���ϱ�����Ǯ
		Scanner sc = new Scanner(System.in);
		System.out.println("�������н���");
		if(sc.hasNextInt()) {
			money = sc.nextInt();
		}else {
			System.out.println("���벻������");
			System.exit(0);
		}
		if(money>=5000) {
			System.out.println("�н�"+money+"����ʲô����");
			String car = sc.next();
			if("����".equals(car)) {
				moneyaftercar = money-1500;
				System.out.println("�ѹ��򱼳ۣ�ʣ��"+moneyaftercar+"��Ԫ");
			}else if("����".equals(car)) {
				moneyaftercar = money-1000;
				System.out.println("�ѹ�����ʣ��"+moneyaftercar+"��Ԫ");
			}else {
				moneyaftercar = money-500;
				System.out.println("�ѹ���µϣ�ʣ��"+moneyaftercar+"��Ԫ");
			}
			System.out.println("��ʲô����");
			String house = sc.next();
			if("����".equals(house)) {
				moneyafterhouse = moneyaftercar-2000;
				System.out.println("�ѹ��������ʣ��"+moneyafterhouse+"��Ԫ");
			}else {
				moneyafterhouse = moneyaftercar-1000;
				System.out.println("�ѹ�����ݷ���ʣ��"+moneyafterhouse+"��Ԫ");
			}
		}else if(money<5000&&money>=500) {
			System.out.println("�н�"+money+"��Ԫ����ʲô����");
			String car = sc.next();
			if("����".equals(car)) {
				moneyaftercar = money-1000;
				System.out.println("�ѹ�����ʣ��"+moneyaftercar+"��Ԫ");
			}else {
				moneyaftercar = money-500;
				System.out.println("�ѹ�����ڣ�ʣ��"+moneyaftercar+"��Ԫ");
			}
		}else {
			System.out.println("ɶҲû�У�ȥ�ϰࡣ�����ж���Ǯ��");
			mymoney = sc.nextInt();
			if(mymoney>=1000) {
				System.out.println("����Ե��");
			}else {
				System.out.println("����Կ��");
			}
		}
		sc.close();
	}

}
