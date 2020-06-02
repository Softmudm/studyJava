package com.sz.zhiling.ATM;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**  
* <p>Title: Account</p>  
* <p>Description: 控制类</p>  
* @author wx  
* @date 2020年6月1日  
*/
public class ATMManager {
	//实例化一个日志对象 ； 
	/*
	 * 注意：log4j的配置文件放在与src平级的resources文件夹中，resources通过NEW-SOURCE FOLDER来创建
	 */
	private static Logger logger = Logger.getLogger(ATMManager.class.getName());
	private static Scanner sc = new Scanner(System.in);
	private static Account[] account = new Account[100];
	
	static {
		account[0] = new Account("jia","jia","18711348888","hunan",10000F);
		account[1] = new Account("123","123","18711347777","beijing",100F);
	}
	
	/**
	 * 这是一个方法
	 */
	public static void main(String[] args) {
		
		System.out.println("日志正在监控中。。。");
//		logger.debug("这是debug级别的日志 !!!!!!。。。");
//		logger.info("这是info级别的日志 。。。");
//		logger.warn("这是warn级别的日志 。。。");
//		logger.error("这是error级别的日志 。。。");
//		logger.fatal("这是fatal级别的日志 。。。");
		start();
	}
	private static void start() {
		// TODO Auto-generated method stub
		while(true) {		
			System.out.println("=======ATM登陆界面=======");
			System.out.println("请输入账号:");
			String loginName = sc.next();
			System.out.println("请输入密码:");
			String loginPassword = sc.next();
			Account ac = login(loginName,loginPassword);
			if(ac != null) {
				logger.debug("用户"+ac.getName()+"登陆成功!");
				System.out.println("登陆成功!");
				while(true) {
					boolean jumpFlag= false;
					System.out.println("=======ATM功能界面=======");
					System.out.println("\t1.查看余额");
					System.out.println("\t2.修改密码");
					System.out.println("\t3.存款");
					System.out.println("\t4.取款");
					System.out.println("\t5.转账");
					System.out.println("\t6.注销");
					System.out.println("\t7.退出");
					System.out.println("======================");
					System.out.println("请输入操作序号:");
					String choose = sc.next();
					switch(choose) {
					case "1":
						showMoney(ac);
						break;
					case "2":
						updatePsw(ac);
						jumpFlag = true;
						break;
					case "3":
						saveMoney(ac);
						break;
					case "4":
						takeMoney(ac);
						break;
					case "5":
						turnMoney(ac);
						break;
					case "6":
						jumpFlag = true;
						break;
					case "7":
						System.out.println("退出成功!");
						System.exit(1);
					default:
						System.out.println("输入错误，请输入正确序号(1~6)!");
					}
					if(jumpFlag) {
						break;
					}
				}
			}else {
				logger.debug("登陆失败!");
				System.out.println("账号或密码错误，请重新输入!");
			}
		}
	}
	//登陆方法，返回null登陆失败。
	private static Account login(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		for(Account ac:account) {
			if(ac != null) {
				if(loginName.equals(ac.getName()) && loginPassword.equals(ac.getPassword())) {
					return ac;
				}
			}
		}
		return null;
	}
	//查看余额
	private static void showMoney(Account ac) {
		// TODO Auto-generated method stub
		System.out.println("=========查看余额=========");
		System.out.println(ac.getName()+"您好，您的余额为:"+ac.getMoney());
	}
	//修改密码
	private static void updatePsw(Account ac) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("=========修改密码=========");
			System.out.println("请输入原密码:");
			String oldPsw = sc.next();
			if(oldPsw.equals(ac.getPassword())) {
				while(true) {
					System.out.println("请输入新密码:");
					String newPsw1 = sc.next();
					System.out.println("请确认新密码:");
					String newPsw2 = sc.next();
					if(newPsw1.equals(newPsw2)) {
						logger.debug(ac.getName()+"将密码"+ac.getPassword()+"修改为:"+newPsw1);
						ac.setPassword(newPsw1);
						System.out.println("密码修改成功!请重新登陆!");
						break;
					}else {
						System.out.println("两次密码不一致，请重新输入!");
					}
				}
				break;
			}else {
				System.out.println("原密码错误，请重新输入!");
			}
		}
	}
	//存款
	private static void saveMoney(Account ac) {
		// TODO Auto-generated method stub
			System.out.println("=========存款=========");
			System.out.println("请输入存款金额:");
			try {
				float savemoney = sc.nextFloat();
				if(savemoney>0) {				
					ac.setMoney(ac.getMoney()+savemoney);
					logger.debug(ac.getName()+"存款"+savemoney);
					System.out.println("存款"+savemoney+"成功!您的账户余额为:"+ac.getMoney());
				}else {
					System.out.println("存款金额必须为正数!");
				}
			}catch(InputMismatchException ex) {
				System.out.println("金额只能输入数字!");
				sc.next();
			}	
	}
	//取款
	private static void takeMoney(Account ac) {
		// TODO Auto-generated method stub
		System.out.println("=========取款=========");
		System.out.println("请输入取款金额:");
		try {
			float takemoney = sc.nextFloat();
			if(takemoney>0) {
				float countmoney = ac.getMoney()-takemoney;
				if(countmoney>=0) {			
					ac.setMoney(countmoney);
					logger.debug(ac.getName()+"取款"+takemoney);
					System.out.println("取款"+takemoney+"成功!您的账户余额为:"+ac.getMoney());
				}else {
					System.out.println("余额不足，取款失败!");
				}
			}else {
				System.out.println("取款金额必须为正数!");
			}
		}catch(InputMismatchException ex) {
			System.out.println("金额只能输入数字!");
			sc.next();
		}
	}
	//转账
	private static void turnMoney(Account ac) {
		// TODO Auto-generated method stub
		System.out.println("=========转账=========");
		System.out.println("请输入对方账户:");
		String turnname = sc.next();
		Account ac2 = null;//存放收款人对象
		boolean flag = false;
		for(Account ac1:account) {
			if(ac1!=null) {
				if(turnname.equals(ac1.getName()) && (!ac.equals(ac1))) {
					ac2 = ac1;
					flag = true;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("请输入转账金额:");
			try {
				float turnmoney = sc.nextFloat();
				if(turnmoney>0) {
					float countmoney = (ac.getMoney()-turnmoney);
					if(countmoney>=0) {
						ac.setMoney(countmoney);
						ac2.setMoney(ac2.getMoney()+turnmoney);
						System.out.println("转账成功，余额为"+ac.getMoney());
						logger.debug(ac.getName()+"向"+ac2.getName()+"转账"+turnmoney);
					}else {
						System.out.println("余额不足，转账失败!");
					}
				}else {
					System.out.println("转账金额必须为正数!");
				}
			}catch(InputMismatchException ex) {
				System.out.println("金额只能输入数字!");
				sc.next();
			}	
		}else {
			System.out.println("输入账户不存在!(不能输入自己账户!)");
		}
	}
}
