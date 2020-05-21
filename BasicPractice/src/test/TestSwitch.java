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
			System.out.println("***********请输入操作序号************");
			System.out.println("\t1.判断数字奇数偶数");
			System.out.println("\t2.判断年数是否闰年");
			System.out.println("\t3.退出");
			System.out.println("*********************************");
			System.out.println("请输入操作的序号：");
			if(sc.hasNextInt()) {
				choose = sc.nextInt();
			}if(choose==3) {
				System.out.println("谢谢使用！");
				break;
			}
			switch(choose) {
			case 1:
				System.out.println("请输入要判断的数字：");
				if(sc.hasNextInt()) {
					num = sc.nextInt();
				}else {
					System.out.println("请输入正整数！");
					continue;
				}
				if(num>=0) {
					if(judgeNum(num)) {
						System.out.println(num+"是偶数！");
					}else {
						System.out.println(num+"是奇数！");
					}
				}else {
					System.out.println("请输入正整数！");
				}
				break;
			case 2:
				System.out.println("请输入要判断的年份(仅限四位数)：");
				if(sc.hasNextInt()) {
					year = sc.nextInt();
				}else {
					System.out.println("请输入正确年份！");
					continue;
				}
				if(year>=1000&&year<=9999) {
					if(judgeYear(year)) {
						System.out.println(year+"是闰年！");
					}else {
						System.out.println(year+"是平年！");
					}
				}else {
					System.out.println("请输入正确年份！");
				}
				break;
			/*case 3:
				System.out.println("谢谢使用！");
				System.exit(0);
				break;*/
			default:
				System.out.println("请输入正确的操作序号！");
				break;
			
			}
		}	
		sc.close();
	}
	/**
	 * 任意输入一个数字输出该数字是奇数还是偶数
	 */
	public static boolean judgeNum(int num) {
		if(num%2==0) {
			return true;//偶数
		}else {
			return false;//奇数
		}
	}
	/**
	 * 任意输入一个年份,判断该年份是不是闰年
	 */
	public static boolean judgeYear(int num) {
		if(judgeNum(num)) {
			if(num%100==0) {
				if((num/100)%4==0) {
					return true;//闰年
				}else {
					return false;//平年
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