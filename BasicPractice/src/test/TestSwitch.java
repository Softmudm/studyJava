package test;

import java.util.Scanner;

public class TestSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int choose = 4;
		int num = 0;
		int year = 0;
		while(true) {
			System.out.println("***********������������************");
			System.out.println("\t1.�ж���������ż��");
			System.out.println("\t2.�ж������Ƿ�����");
			System.out.println("\t3.�˳�");
			System.out.println("*********************************");
			System.out.println("�������������ţ�");
			if(sc.hasNextInt()) {
				choose = sc.nextInt();
			}if(choose==3) {
				System.out.println("ллʹ�ã�");
				break;
			}
			switch(choose) {
			case 1:
				System.out.println("������Ҫ�жϵ����֣�");
				if(sc.hasNextInt()) {
					num = sc.nextInt();
				}else {
					System.out.println("��������������");
					continue;
				}
				if(num>=0) {
					if(judgeNum(num)) {
						System.out.println(num+"��ż����");
					}else {
						System.out.println(num+"��������");
					}
				}else {
					System.out.println("��������������");
				}
				break;
			case 2:
				System.out.println("������Ҫ�жϵ����(������λ��)��");
				if(sc.hasNextInt()) {
					year = sc.nextInt();
				}else {
					System.out.println("��������ȷ��ݣ�");
					continue;
				}
				if(year>=1000&&year<=9999) {
					if(judgeYear(year)) {
						System.out.println(year+"�����꣡");
					}else {
						System.out.println(year+"��ƽ�꣡");
					}
				}else {
					System.out.println("��������ȷ��ݣ�");
				}
				break;
			/*case 3:
				System.out.println("ллʹ�ã�");
				System.exit(0);
				break;*/
			default:
				System.out.println("��������ȷ�Ĳ�����ţ�");
				break;
			
			}
		}	
		sc.close();
	}
	/**
	 * ��������һ�������������������������ż��
	 */
	public static boolean judgeNum(int num) {
		if(num%2==0) {
			return true;//ż��
		}else {
			return false;//����
		}
	}
	/**
	 * ��������һ�����,�жϸ�����ǲ�������
	 */
	public static boolean judgeYear(int num) {
		if(judgeNum(num)) {
			if(num%100==0) {
				if((num/100)%4==0) {
					return true;//����
				}else {
					return false;//ƽ��
				}
			}else {
				if((num%100)%4==0) {
					return true;
				}else {
					return false;
				}
			}
		}else {
			return false;
		}
	}

}