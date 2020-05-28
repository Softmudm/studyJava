/**  
* <p>Title: Controller.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020��5��27��
*/  
package com.sz.zhiling;

import java.util.Scanner;

/**  
* <p>Title: Controller</p>  
* <p>Description:������ </p>  
* @author wx  
* @date 2020��5��27��  
*/
public class Controller {
	
	private static Scanner input = new Scanner(System.in);
	private static Student[] student = new Student[100];
	private static Teacher[] teacher = new Teacher[10];
	static {
		student[0] = new Student("S001","��","jia",99,"��");
		student[1] = new Student("S002","��","yi",98,"Ů");
		student[2] = new Student("S003","��","bing",97,"��");
		
		teacher[0] = new Teacher("T001","����","zhangsan",100,"��");
	}
	//�ж�һ��String�ܲ���תint
	public static boolean stringToInt(String str){
		if(str == null){ //��֤�Ƿ�Ϊ��
			return false;
		}
		return str.matches("\\d+"); //ʹ��������ʽ�жϸ��ַ����Ƿ�Ϊ���֣���һ��\��ת�����\d+��ʾƥ��1���� //����������֣�"+"��"*"���ƣ�"*"��ʾ0������
	}
	//��ҳ
	private static void firstPage() {
		System.out.println("==========ѧ������ϵͳ==========");
		System.out.println("\t\040\040\0401.��½");
		System.out.println("\t\040\040\0402.�˳�");
		System.out.println("============================");
	}
	//��½�жϷ��ص�¼��ϢnullΪ��½ʧ��
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
	//��ҳ���¼����
	private static void login() {
		while(true) {
			System.out.println("�������˺�:");
			String inName = input.next();
			System.out.println("����������:");
			String inPassword = input.next();
			User loginUser = judgeLogin(inName,inPassword);
			if(loginUser != null) {
				if(loginUser instanceof Student) {
					System.out.println(loginUser.getName()+"ѧ��,��½�ɹ�!");
					studentPage((Student)loginUser);
				}else {
					System.out.println(loginUser.getName()+"��ʦ,��½�ɹ�!");
					teacherPage((Teacher)loginUser);
				}
				break;
			}else {
				System.out.println("��½ʧ��!");
			}
		}
	}
	//ѧ����ʾ�Լ���Ϣ����
	private static void showMine(Student stu) {
		System.out.println("====������Ϣ====");
		System.out.println("���:"+stu.getStuNum());
		System.out.println("����:"+stu.getName());
		System.out.println("����:"+stu.getAge());
		System.out.println("�Ա�:"+stu.getSex());
		System.out.println("==============");
		System.out.println("��0�������˵�!");
		String a = "1";
		do {
			a = input.next();	
		}while(!"0".equals(a));
	}
	//�����뷽��(����)
	private static void updatePws(User user) {
		while(true) {
			System.out.println("====�޸�����====");
			System.out.println("������ԭʼ����:");
			String newPassword = input.next();
			if(newPassword.equals(user.getPassword())) {
				while(true) {
					System.out.println("������������:");
					String newPsw1 = input.next();
					System.out.println("��ȷ��������:");
					String newPsw2 = input.next();
					if(newPsw1.equals(newPsw2)) {
						user.setPassword(newPsw1);
						System.out.println("�����޸ĳɹ�!");
						break;
					}else {
						System.out.println("�����������벻һ�£�����������!");
					}					
				}
				break;
			}else {
				System.out.println("ԭʼ�������!(��0�������˵�;���������������)");
				String b = input.next();
				if("0".equals(b)) {
					break;
				}
			}
		}
	}
	//����ѧ��
	private static void addStudent() {
		while(true) {
			System.out.println("===========����ѧ��===========");
			System.out.println("����������:");
			String addName = input.next();
			System.out.println("����������:");
			int addAge = 18;
			while(true) {
				String addAgeS = input.next();
				if(stringToInt(addAgeS) && Integer.parseInt(addAgeS)>0 && Integer.parseInt(addAgeS)<200) {
					addAge = Integer.parseInt(addAgeS);
					break;
				}else{
					System.out.println("���벻�Ϸ�������������!");
				}
			}
			System.out.println("�������Ա�:");
			String addSex = input.next();
			String addPsw;
			while(true) {					
				System.out.println("����������:");
				String addpsw1 = input.next();
				System.out.println("��ȷ������:");
				String addpsw2 = input.next();
				if(addpsw1.equals(addpsw2)) {
					addPsw = addpsw1;
					break;
				}else {
					System.out.println("�������벻һ�£�����������!");
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
				System.out.println("���ѧ���ɹ�!");
			}else {
				System.out.println("ѧ���б�����������ϵ����Ա!");
			}
			System.out.println("����0�����ϼ��˵��������������������ѧ��!");
			String p = input.next();
			if("0".equals(p)) {
				break;
			}
		}
	}
	//ɾ��ѧ��
	private static void deleteStudent() {
		System.out.println("===========ɾ��ѧ��===========");
		System.out.println("������Ҫɾ����ѧ���ı��:");
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
			System.out.println("ɾ���ɹ�!");
		}else {					
			System.out.println("ɾ��ʧ�ܣ��б���û�д�ѧ��!");
		}
	}
	//��ʾ����ѧ��
	private static void showAllStu() {
		while(true) {
			System.out.println("===========ѧ���б�===========");
			System.out.println("���\t����\t����\t�Ա�");
			for(Student s:student) {
				if(s != null) {						
					System.out.println(s.getStuNum()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getSex());
				}
			}
			System.out.println("����0�����ϼ��˵�!");
			String o = input.next();
			if("0".equals(o)) {
				break;
			}
		}
	}
	//�޸�ѧ��
	private static void updateStudent() {
		System.out.println("===========�޸�ѧ��===========");
		System.out.println("������Ҫ�޸ĵ�ѧ���ı��:");
		String updateNum = input.next();
		boolean updateFlag = false;
		for(int i=0;i<student.length;i++) {
			if(student[i] != null && updateNum.equals(student[i].getStuNum())) {
				System.out.println("====ѧ����Ϣ====");
				System.out.println("���:"+student[i].getStuNum());
				System.out.println("����:"+student[i].getName());
				System.out.println("����:"+student[i].getAge());
				System.out.println("�Ա�:"+student[i].getSex());
				System.out.println("==============");
				System.out.println("�������޸ĵ�����:");
				String updateName = input.next();
				System.out.println("�������޸ĵ�����:");
				int updateAge = 18;
				while(true) {
					String updateAgeS = input.next();
					if(stringToInt(updateAgeS) && Integer.parseInt(updateAgeS)>0 && Integer.parseInt(updateAgeS)<200) {
						updateAge = Integer.parseInt(updateAgeS);
						break;
					}else{
						System.out.println("���벻�Ϸ�������������!");
					}
				}
				System.out.println("�������޸ĵ��Ա�:");
				String updateSex = input.next();
				String updatePsw;
				while(true) {					
					System.out.println("�������޸ĵ�����:");
					String updatepsw1 = input.next();
					System.out.println("��ȷ������:");
					String updatepsw2 = input.next();
					if(updatepsw1.equals(updatepsw2)) {
						updatePsw = updatepsw1;
						break;
					}else {
						System.out.println("�������벻һ�£�����������!");
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
			System.out.println("�޸ĳɹ�!");
		}else {					
			System.out.println("�޸�ʧ�ܣ��б���û�д�ѧ��!");
		}
	}
	//ѧ������
	private static void studentPage(Student stu) {
		while(true) {
			System.out.println("==========ѧ������==========");
			System.out.println("\t1.�鿴��Ϣ");
			System.out.println("\t2.�޸�����");
			System.out.println("\t3.�˳�");
			System.out.println("============================");
			System.out.println("��������������(1~3):");
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
				System.out.println("��������ȷ�Ĳ���ѡ��(1~3)!");
			}
		}
	}
	//��ʦ����
	private static void teacherPage(Teacher tea) {
		while(true) {
			System.out.println("==========��ʦ����==========");
			System.out.println("\t1.����ѧ��");
			System.out.println("\t2.ɾ��ѧ��");
			System.out.println("\t3.�鿴ѧ��");
			System.out.println("\t4.�޸�ѧ��");
			System.out.println("\t5.�޸�����");
			System.out.println("\t6.�˳�");
			System.out.println("============================");
			System.out.println("��������������(1~6):");
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
				System.out.println("��������ȷ�Ĳ���ѡ��(1~6)!");
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
				System.out.println("ллʹ��!");
				System.exit(0);
			default:
				System.out.println("��������ȷ�Ĳ���ѡ��(1����2)!");
			}
		}
	}
	/**  
	 * <p>Title: main</p> 
	 * <p>Description: ���������</p>  
	 * @param args  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}
}
