package test;

import java.util.Scanner;

public class DVDManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD[] dvds = new DVD[6];
		dvds[0] = new DVD(1,false,"三国演义",1,16);
		dvds[1] = new DVD(2,true,"红楼梦",0,12);
		dvds[2] = new DVD(3,true,"水浒传",0,30);
		Scanner sc = new Scanner(System.in);
		int choose = 7;
		String addName,deleteName,lendName,returnName;
		int lendDate = 1;
		int returnDate = 1;
		int lend = 1;
		while(true) {
			System.out.println("   DVD管理");
			System.out.println("-------------");
			System.out.println("1.新增\t2.查看");
			System.out.println("3.删除\t4.借出");
			System.out.println("5.归还\t6.退出");
			System.out.println("-------------");
			System.out.println("请选择操作:");
			if(sc.hasNextInt()) {	
				choose = sc.nextInt();
			}
			switch(choose) {
			case 1 :
				System.out.println("------->新增DVD");
				System.out.println("请输入新增DVD的名字:");
				addName = sc.next();
				addDVD(dvds,addName);
//				System.out.println("输入0返回菜单:");
//				if(sc.nextInt()==0) {					
//					break;
//				}
				break;
			case 2 :
				System.out.println("------->查看DVD");
				searchDVD(dvds);
				break;
			case 3 :
				System.out.println("------->删除DVD");
				System.out.println("请输入要删除DVD的名字:");
				deleteName = sc.next();
				deleteDVD(dvds,deleteName);
				break;
			case 4 :
				System.out.println("------->借出DVD");
				System.out.println("请输入借出DVD的名字:");
				lendName = sc.next();
				System.out.println("请输入借出DVD的日期:");
				while(true) {		
					if(sc.hasNextInt()) {
						lendDate = sc.nextInt();
						if(lendDate>=1 && lendDate<=31) {
							break;
						}else {
							System.out.println("请输入1~31的整数！");
						}
					}else {
						System.out.println("请输入1~31的整数！");
					}
				}
				lendDVD(dvds,lendName,lendDate);
				break;
			case 5 :
				System.out.println("------->归还DVD");
				System.out.println("请输入归还DVD的名字:");
				returnName = sc.next();
				lend = seclectDateByName(dvds,returnName);
				System.out.println("请输入归还DVD的日期:");
				while(true) {		
					if(sc.hasNextInt()) {
						returnDate = sc.nextInt();
						if(returnDate>=lend && returnDate<=31) {
							break;
						}else {
							System.out.println("归还日期不能小于借出日期！");
						}
					}else {
						System.out.println("请输入1~31的整数！");
					}
				}
				returnDVD(dvds,returnName,returnDate);
				break;
			case 6 :
				System.out.println("谢谢使用！");
				System.exit(1);
			default : 
				System.out.println("请输入正确的操作！");
			}
		}
		//sc.close();
	}
	/*
	 * 增加的方法
	 */
	public static void addDVD(DVD[] dvds,String addName) {
		boolean flag = false;
		for(int i=0;i<dvds.length;i++) {
			if(dvds[i]==null) {
				dvds[i] = new DVD(i+1,true,addName,0,0);
				System.out.println("新增《"+addName+"》成功！");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("货架已满，增加失败！");
		}
	}
	/*
	 * 查看的方法
	 */
	public static void searchDVD(DVD[] dvds) {
		System.out.println("----------------------------------------------");
		System.out.println("序号\t状态\t名称\t\t借出日期\t借出次数");
		String state;
		String date;
		for(int i=0;i<dvds.length;i++) {
			if(dvds[i]==null) {
				break;
			}
			if(dvds[i].isState()) {
				state = "可借";
			}else {
				state = "已借出";
			}
			if(dvds[i].getDate()==0) {
				date = "\t";
			}else {
				date = dvds[i].getDate()+"日";
			}
			System.out.println(dvds[i].getId()+"\t"+state+"\t《"+dvds[i].getName()+"》\t"+date+"\t"+dvds[i].getTime()+"次");
		}
		System.out.println("----------------------------------------------");
	}
	/*
	 * 删除的方法
	 */
	public static void deleteDVD(DVD[] dvds,String deleteName) {
		boolean flag = false;
		int n;
		for(int i=0;i<dvds.length;i++) {					//循环对比DVD列表
			if(dvds[i]!=null) {								//非空判断
				if(deleteName.equals(dvds[i].getName())) {	//匹配要删除的DVD名字
					if(dvds[i].isState()) {					//判断要删除的DVD状态
						n = i+1;
						if((n<dvds.length&&dvds[n]==null) || (n>=dvds.length)) {//删除的DVD是列表中最后一张
							dvds[n-1] = null;
						}else {							
							while(n<dvds.length&&dvds[n]!=null) {
								dvds[n].setId(dvds[n].getId()-1);
								dvds[n-1] = dvds[n];
								dvds[n] = null;
								n++;
							}
						}
						System.out.println("删除《"+deleteName+"》成功！");
					}else {
						System.out.println("删除《"+deleteName+"》失败,DVD为借出状态，不允许删除！");
					}
					flag = true;
				}
			}else {
				break;
			}
		}
		if(!flag) {
			System.out.println("删除《"+deleteName+"》失败,没有找到匹配信息！");
		}
	}
	/*
	 * 借出的方法
	 */
	public static void lendDVD(DVD[] dvds,String lendName,int lendDate) {
		boolean flag = false;
		for(int i=0;i<dvds.length;i++) {					//循环对比DVD列表
			if(dvds[i]!=null) {								//非空判断
				if(lendName.equals(dvds[i].getName())) {	//匹配要借出的DVD名字
					if(dvds[i].isState()) {					//判断要借出的DVD状态
						dvds[i].setState(false);
						dvds[i].setDate(lendDate);
						dvds[i].setTime(dvds[i].getTime()+1);
						System.out.println("您于"+lendDate+"日借出《"+lendName+"》成功！");
					}else {
						System.out.println("借出《"+lendName+"》失败,DVD为借出状态！");
					}
					flag = true;
				}
			}else {
				break;
			}
		}
		if(!flag) {
			System.out.println("借出《"+lendName+"》失败,没有找到匹配信息！");
		}
	}
	/*
	 * 归还方法
	 */
	public static void returnDVD(DVD[] dvds,String returnName,int returnDate) {
		boolean flag = false;
		for(int i=0;i<dvds.length;i++) {					//循环对比DVD列表
			if(dvds[i]!=null) {								//非空判断
				if(returnName.equals(dvds[i].getName())) {	//匹配要归还的DVD名字
					if(!dvds[i].isState()) {				//判断要归还的DVD状态
						dvds[i].setState(true);
						System.out.println("归还《"+returnName+"》成功！");
						System.out.println("借出日期："+dvds[i].getDate()+"日");
						System.out.println("归还日期："+returnDate+"日");
						System.out.println("应付金额(元)："+(returnDate-dvds[i].getDate()));
						dvds[i].setDate(0);
					}else {
						System.out.println("归还《"+returnName+"》失败,该DVD还没有被借出！");
					}
					flag = true;
				}
			}else {
				break;
			}
		}
		if(!flag) {
			System.out.println("归还《"+returnName+"》失败,没有找到匹配信息！");
		}
	}
	/*
	 * 查询借出日期
	 */
	public static int seclectDateByName(DVD[] dvds,String name) {
		boolean flag = false;
		int n = -1;
		for(int i=0;i<dvds.length;i++) {
			if(dvds[i]!=null) {
				if(name.equals(dvds[i])) {
					flag = true;
					n = dvds[i].getDate();
					break;
				}
			}
		}
		if(flag) {
			return n;
		}else {
			return -1;
		}
	}
}
