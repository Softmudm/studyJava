/**  
* <p>Title: Controller.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020年5月27日
*/  
package com.sz.zhiling;

import java.util.Scanner;

/**  
* <p>Title: Controller</p>  
* <p>Description:控制类 </p>  
* @author wx  
* @date 2020年5月27日  
*/
public class Controller {
	
	private static Scanner input = new Scanner(System.in);
	private static Student[] student = new Student[100];
	private static Teacher[] teacher = new Teacher[10];
	static {
		student[0] = new Student("S001","甲","jia",99,"男");
		student[1] = new Student("S002","乙","yi",98,"女");
		student[2] = new Student("S003","丙","bing",97,"男");
		
		teacher[0] = new Teacher("T001","张三","zhangsan",100,"男");
	}
	//判断一个String能不能转int
	public static boolean stringToInt(String str){
		if(str == null){ //验证是否为空
			return false;
		}
		return str.matches("\\d+"); //使用正则表达式判断该字符串是否为数字，第一个\是转义符，\d+表示匹配1个或 //多个连续数字，"+"和"*"类似，"*"表示0个或多个
	}
	//首页
	private static void firstPage() {
		System.out.println("==========学生管理系统==========");
		System.out.println("\t\040\040\0401.登陆");
		System.out.println("\t\040\040\0402.退出");
		System.out.println("============================");
	}
	//登陆判断返回登录信息null为登陆失败
	private static User judgeLogin(String name,String password) {
		User user = null;
		for(Student stu:student) {
			if(stu != null && name.equals(stu.getName()) && password.equals(stu.getPassword())) {
				user = stu;
			}
		}
		for(Teacher tea:teacher) {
			if(tea != null && name.equals(tea.getName()) && password.equals(tea.getPassword())) {
				user = tea;
			}
		}
		return user;
	}
	//主页面登录方法
	private static void login() {
		while(true) {
			System.out.println("请输入账号:");
			String inName = input.next();
			System.out.println("请输入密码:");
			String inPassword = input.next();
			User loginUser = judgeLogin(inName,inPassword);
			if(loginUser != null) {
				if(loginUser instanceof Student) {
					System.out.println(loginUser.getName()+"学生,登陆成功!");
					studentPage((Student)loginUser);
				}else {
					System.out.println(loginUser.getName()+"老师,登陆成功!");
					teacherPage((Teacher)loginUser);
				}
				break;
			}else {
				System.out.println("登陆失败!");
			}
		}
	}
	//学生显示自己信息方法
	private static void showMine(Student stu) {
		System.out.println("====个人信息====");
		System.out.println("编号:"+stu.getStuNum());
		System.out.println("姓名:"+stu.getName());
		System.out.println("年龄:"+stu.getAge());
		System.out.println("性别:"+stu.getSex());
		System.out.println("==============");
		System.out.println("按0返回主菜单!");
		String a = "1";
		do {
			a = input.next();	
		}while(!"0".equals(a));
	}
	//改密码方法(共用)
	private static void updatePws(User user) {
		while(true) {
			System.out.println("====修改密码====");
			System.out.println("请输入原始密码:");
			String newPassword = input.next();
			if(newPassword.equals(user.getPassword())) {
				while(true) {
					System.out.println("请输入新密码:");
					String newPsw1 = input.next();
					System.out.println("请确认新密码:");
					String newPsw2 = input.next();
					if(newPsw1.equals(newPsw2)) {
						user.setPassword(newPsw1);
						System.out.println("密码修改成功!");
						break;
					}else {
						System.out.println("两次输入密码不一致，请重新输入!");
					}					
				}
				break;
			}else {
				System.out.println("原始密码错误!(按0返回主菜单;按任意键继续尝试)");
				String b = input.next();
				if("0".equals(b)) {
					break;
				}
			}
		}
	}
	//增加学生
	private static void addStudent() {
		while(true) {
			System.out.println("===========增加学生===========");
			System.out.println("请输入名称:");
			String addName = input.next();
			System.out.println("请输入年龄:");
			int addAge = 18;
			while(true) {
				String addAgeS = input.next();
				if(stringToInt(addAgeS) && Integer.parseInt(addAgeS)>0 && Integer.parseInt(addAgeS)<200) {
					addAge = Integer.parseInt(addAgeS);
					break;
				}else{
					System.out.println("输入不合法，请重新输入!");
				}
			}
			System.out.println("请输入性别:");
			String addSex = input.next();
			String addPsw;
			while(true) {					
				System.out.println("请输入密码:");
				String addpsw1 = input.next();
				System.out.println("请确认密码:");
				String addpsw2 = input.next();
				if(addpsw1.equals(addpsw2)) {
					addPsw = addpsw1;
					break;
				}else {
					System.out.println("两次密码不一致，请重新输入!");
				}
			}
			String stuNum = "000";
			boolean addFlag = false;
			for(int i=0;i<student.length;i++) {
				if(student[i] !=null) {
					stuNum = student[i].getStuNum();
				}else{
					String s = ""+(Integer.parseInt(stuNum.substring(1))+1);
					while(s.length()<3) {
						s = "0"+s;
					}
					String addStuNum = "S"+s;
					student[i] = new Student(addStuNum,addName,addPsw,addAge,addSex);
					addFlag = true;
					break;
				}
			}
			if(addFlag) {
				System.out.println("添加学生成功!");
			}else {
				System.out.println("学生列表已满，请联系管理员!");
			}
			System.out.println("输入0返回上级菜单，输入任意键继续增加学生!");
			String p = input.next();
			if("0".equals(p)) {
				break;
			}
		}
	}
	//删除学生
	private static void deleteStudent() {
		System.out.println("===========删除学生===========");
		System.out.println("请输入要删除的学生的编号:");
		String deleteNum = input.next();
		boolean deleteFlag = false;
		for(int i=0;i<student.length;i++) {
			if(student[i] != null && deleteNum.equals(student[i].getStuNum())) {
				while(i<(student.length-1) && student[i+1] != null) {
					student[i] = student[i+1];
					i++;
				}
				student[i] = null;
				deleteFlag = true;
				break;
			}
		}					
		if(deleteFlag) {
			System.out.println("删除成功!");
		}else {					
			System.out.println("删除失败，列表中没有此学生!");
		}
	}
	//显示所有学生
	private static void showAllStu() {
		while(true) {
			System.out.println("===========学生列表===========");
			System.out.println("编号\t姓名\t年龄\t性别");
			for(Student s:student) {
				if(s != null) {						
					System.out.println(s.getStuNum()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getSex());
				}
			}
			System.out.println("输入0返回上级菜单!");
			String o = input.next();
			if("0".equals(o)) {
				break;
			}
		}
	}
	//修改学生
	private static void updateStudent() {
		System.out.println("===========修改学生===========");
		System.out.println("请输入要修改的学生的编号:");
		String updateNum = input.next();
		boolean updateFlag = false;
		for(int i=0;i<student.length;i++) {
			if(student[i] != null && updateNum.equals(student[i].getStuNum())) {
				System.out.println("====学生信息====");
				System.out.println("编号:"+student[i].getStuNum());
				System.out.println("姓名:"+student[i].getName());
				System.out.println("年龄:"+student[i].getAge());
				System.out.println("性别:"+student[i].getSex());
				System.out.println("==============");
				System.out.println("请输入修改的名称:");
				String updateName = input.next();
				System.out.println("请输入修改的年龄:");
				int updateAge = 18;
				while(true) {
					String updateAgeS = input.next();
					if(stringToInt(updateAgeS) && Integer.parseInt(updateAgeS)>0 && Integer.parseInt(updateAgeS)<200) {
						updateAge = Integer.parseInt(updateAgeS);
						break;
					}else{
						System.out.println("输入不合法，请重新输入!");
					}
				}
				System.out.println("请输入修改的性别:");
				String updateSex = input.next();
				String updatePsw;
				while(true) {					
					System.out.println("请输入修改的密码:");
					String updatepsw1 = input.next();
					System.out.println("请确认密码:");
					String updatepsw2 = input.next();
					if(updatepsw1.equals(updatepsw2)) {
						updatePsw = updatepsw1;
						break;
					}else {
						System.out.println("两次密码不一致，请重新输入!");
					}
				}
				student[i].setName(updateName);
				student[i].setPassword(updatePsw);
				student[i].setAge(updateAge);
				student[i].setSex(updateSex);
				updateFlag = true;
				break;
			}
		}					
		if(updateFlag) {
			System.out.println("修改成功!");
		}else {					
			System.out.println("修改失败，列表中没有此学生!");
		}
	}
	//学生界面
	private static void studentPage(Student stu) {
		while(true) {
			System.out.println("==========学生功能==========");
			System.out.println("\t1.查看信息");
			System.out.println("\t2.修改密码");
			System.out.println("\t3.退出");
			System.out.println("============================");
			System.out.println("请输入操作的序号(1~3):");
			String choose2 = input.next();
			switch(choose2) {
			case "1" :
				showMine(stu);
				break;
			case "2" :
				updatePws(stu);
				break;
			case "3" :
				return;
			default:
				System.out.println("请输入正确的操作选项(1~3)!");
			}
		}
	}
	//老师界面
	private static void teacherPage(Teacher tea) {
		while(true) {
			System.out.println("==========老师功能==========");
			System.out.println("\t1.增加学生");
			System.out.println("\t2.删除学生");
			System.out.println("\t3.查看学生");
			System.out.println("\t4.修改学生");
			System.out.println("\t5.修改密码");
			System.out.println("\t6.退出");
			System.out.println("============================");
			System.out.println("请输入操作的序号(1~6):");
			String choose2 = input.next();
			switch(choose2) {
			case "1" :
				addStudent();
				break;
			case "2" :
				deleteStudent();
				break;
			case "3" :
				showAllStu();
				break;
			case "4" :
				updateStudent();
				break;
			case "5" :
				updatePws(tea);
				break;
			case "6" :
				return;
			default:
				System.out.println("请输入正确的操作选项(1~6)!");
			}
		}
	}
	private static void start() {
		// TODO Auto-generated method stub
		while(true) {
			firstPage();
			int choose1 = 100;
			String str1 = input.next();
			if(stringToInt(str1)) {
				choose1 = Integer.parseInt(str1);		
			}
			switch(choose1) {
			case 1:
				login();
				break;
			case 2:
				System.out.println("谢谢使用!");
				System.exit(0);
			default:
				System.out.println("请输入正确的操作选项(1或者2)!");
			}
		}
	}
	/**  
	 * <p>Title: main</p> 
	 * <p>Description: 主方法入口</p>  
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
}
