package test;

import java.util.Scanner;

/**
 * if练习demo
 * @author Administrator
 *
 */

public class TestIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 如果我中了5000万我就去买车买房，用户输入奔驰就买奔驰，用户输入宝马就买宝马 否则就买奥迪，如果有别墅就买别墅否则就买电梯房
		        如果我中500万我就买车，如果有宝马就买宝马 否则就买大众
		        如果没中奖，我就要去上班，如果我有1000块钱，中午吃点菜，否则就吃快餐
		 */
		int money = 0,moneyaftercar,moneyafterhouse,mymoney;//中奖金额,买车剩余，买房剩余，身上本来的钱
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入中奖金额：");
		if(sc.hasNextInt()) {
			money = sc.nextInt();
		}else {
			System.out.println("输入不是数字");
			System.exit(0);
		}
		if(money>=5000) {
			System.out.println("中奖"+money+"万，买什么车？");
			String car = sc.next();
			if("奔驰".equals(car)) {
				moneyaftercar = money-1500;
				System.out.println("已购买奔驰，剩余"+moneyaftercar+"万元");
			}else if("宝马".equals(car)) {
				moneyaftercar = money-1000;
				System.out.println("已购买宝马，剩余"+moneyaftercar+"万元");
			}else {
				moneyaftercar = money-500;
				System.out.println("已购买奥迪，剩余"+moneyaftercar+"万元");
			}
			System.out.println("买什么房？");
			String house = sc.next();
			if("别墅".equals(house)) {
				moneyafterhouse = moneyaftercar-2000;
				System.out.println("已购买别墅，剩余"+moneyafterhouse+"万元");
			}else {
				moneyafterhouse = moneyaftercar-1000;
				System.out.println("已购买电梯房，剩余"+moneyafterhouse+"万元");
			}
		}else if(money<5000&&money>=500) {
			System.out.println("中奖"+money+"万元，买什么车：");
			String car = sc.next();
			if("宝马".equals(car)) {
				moneyaftercar = money-1000;
				System.out.println("已购买宝马，剩余"+moneyaftercar+"万元");
			}else {
				moneyaftercar = money-500;
				System.out.println("已购买大众，剩余"+moneyaftercar+"万元");
			}
		}else {
			System.out.println("啥也没中，去上班。现在有多少钱？");
			mymoney = sc.nextInt();
			if(mymoney>=1000) {
				System.out.println("中午吃点菜");
			}else {
				System.out.println("中午吃快餐");
			}
		}
		sc.close();
	}

}
