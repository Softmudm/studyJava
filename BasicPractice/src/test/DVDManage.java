package test;

import java.util.Scanner;

public class DVDManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD[] dvds = new DVD[6];
		dvds[0] = new DVD(1,false,"��������",1,16);
		dvds[1] = new DVD(2,true,"��¥��",0,12);
		dvds[2] = new DVD(3,true,"ˮ䰴�",0,30);
		Scanner sc = new Scanner(System.in);
		int choose = 7;
		String addName,deleteName,lendName,returnName;
		int lendDate = 1;
		int returnDate = 1;
		int lend = 1;
		while(true) {
			System.out.println("   DVD����");
			System.out.println("-------------");
			System.out.println("1.����\t2.�鿴");
			System.out.println("3.ɾ��\t4.���");
			System.out.println("5.�黹\t6.�˳�");
			System.out.println("-------------");
			System.out.println("��ѡ�����:");
			if(sc.hasNextInt()) {	
				choose = sc.nextInt();
			}
			switch(choose) {
			case 1 :
				System.out.println("------->����DVD");
				System.out.println("����������DVD������:");
				addName = sc.next();
				addDVD(dvds,addName);
//				System.out.println("����0���ز˵�:");
//				if(sc.nextInt()==0) {					
//					break;
//				}
				break;
			case 2 :
				System.out.println("------->�鿴DVD");
				searchDVD(dvds);
				break;
			case 3 :
				System.out.println("------->ɾ��DVD");
				System.out.println("������Ҫɾ��DVD������:");
				deleteName = sc.next();
				deleteDVD(dvds,deleteName);
				break;
			case 4 :
				System.out.println("------->���DVD");
				System.out.println("��������DVD������:");
				lendName = sc.next();
				System.out.println("��������DVD������:");
				while(true) {		
					if(sc.hasNextInt()) {
						lendDate = sc.nextInt();
						if(lendDate>=1 && lendDate<=31) {
							break;
						}else {
							System.out.println("������1~31��������");
						}
					}else {
						System.out.println("������1~31��������");
					}
				}
				lendDVD(dvds,lendName,lendDate);
				break;
			case 5 :
				System.out.println("------->�黹DVD");
				System.out.println("������黹DVD������:");
				returnName = sc.next();
				lend = seclectDateByName(dvds,returnName);
				System.out.println("������黹DVD������:");
				while(true) {		
					if(sc.hasNextInt()) {
						returnDate = sc.nextInt();
						if(returnDate>=lend && returnDate<=31) {
							break;
						}else {
							System.out.println("�黹���ڲ���С�ڽ�����ڣ�");
						}
					}else {
						System.out.println("������1~31��������");
					}
				}
				returnDVD(dvds,returnName,returnDate);
				break;
			case 6 :
				System.out.println("ллʹ�ã�");
				System.exit(1);
			default : 
				System.out.println("��������ȷ�Ĳ�����");
			}
		}
		//sc.close();
	}
	/*
	 * ���ӵķ���
	 */
	public static void addDVD(DVD[] dvds,String addName) {
		boolean flag = false;
		for(int i=0;i<dvds.length;i++) {
			if(dvds[i]==null) {
				dvds[i] = new DVD(i+1,true,addName,0,0);
				System.out.println("������"+addName+"���ɹ���");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("��������������ʧ�ܣ�");
		}
	}
	/*
	 * �鿴�ķ���
	 */
	public static void searchDVD(DVD[] dvds) {
		System.out.println("----------------------------------------------");
		System.out.println("���\t״̬\t����\t\t�������\t�������");
		String state;
		String date;
		for(int i=0;i<dvds.length;i++) {
			if(dvds[i]==null) {
				break;
			}
			if(dvds[i].isState()) {
				state = "�ɽ�";
			}else {
				state = "�ѽ��";
			}
			if(dvds[i].getDate()==0) {
				date = "\t";
			}else {
				date = dvds[i].getDate()+"��";
			}
			System.out.println(dvds[i].getId()+"\t"+state+"\t��"+dvds[i].getName()+"��\t"+date+"\t"+dvds[i].getTime()+"��");
		}
		System.out.println("----------------------------------------------");
	}
	/*
	 * ɾ���ķ���
	 */
	public static void deleteDVD(DVD[] dvds,String deleteName) {
		boolean flag = false;
		int n;
		for(int i=0;i<dvds.length;i++) {					//ѭ���Ա�DVD�б�
			if(dvds[i]!=null) {								//�ǿ��ж�
				if(deleteName.equals(dvds[i].getName())) {	//ƥ��Ҫɾ����DVD����
					if(dvds[i].isState()) {					//�ж�Ҫɾ����DVD״̬
						n = i+1;
						if((n<dvds.length&&dvds[n]==null) || (n>=dvds.length)) {//ɾ����DVD���б������һ��
							dvds[n-1] = null;
						}else {							
							while(n<dvds.length&&dvds[n]!=null) {
								dvds[n].setId(dvds[n].getId()-1);
								dvds[n-1] = dvds[n];
								dvds[n] = null;
								n++;
							}
						}
						System.out.println("ɾ����"+deleteName+"���ɹ���");
					}else {
						System.out.println("ɾ����"+deleteName+"��ʧ��,DVDΪ���״̬��������ɾ����");
					}
					flag = true;
				}
			}else {
				break;
			}
		}
		if(!flag) {
			System.out.println("ɾ����"+deleteName+"��ʧ��,û���ҵ�ƥ����Ϣ��");
		}
	}
	/*
	 * ����ķ���
	 */
	public static void lendDVD(DVD[] dvds,String lendName,int lendDate) {
		boolean flag = false;
		for(int i=0;i<dvds.length;i++) {					//ѭ���Ա�DVD�б�
			if(dvds[i]!=null) {								//�ǿ��ж�
				if(lendName.equals(dvds[i].getName())) {	//ƥ��Ҫ�����DVD����
					if(dvds[i].isState()) {					//�ж�Ҫ�����DVD״̬
						dvds[i].setState(false);
						dvds[i].setDate(lendDate);
						dvds[i].setTime(dvds[i].getTime()+1);
						System.out.println("����"+lendDate+"�ս����"+lendName+"���ɹ���");
					}else {
						System.out.println("�����"+lendName+"��ʧ��,DVDΪ���״̬��");
					}
					flag = true;
				}
			}else {
				break;
			}
		}
		if(!flag) {
			System.out.println("�����"+lendName+"��ʧ��,û���ҵ�ƥ����Ϣ��");
		}
	}
	/*
	 * �黹����
	 */
	public static void returnDVD(DVD[] dvds,String returnName,int returnDate) {
		boolean flag = false;
		for(int i=0;i<dvds.length;i++) {					//ѭ���Ա�DVD�б�
			if(dvds[i]!=null) {								//�ǿ��ж�
				if(returnName.equals(dvds[i].getName())) {	//ƥ��Ҫ�黹��DVD����
					if(!dvds[i].isState()) {				//�ж�Ҫ�黹��DVD״̬
						dvds[i].setState(true);
						System.out.println("�黹��"+returnName+"���ɹ���");
						System.out.println("������ڣ�"+dvds[i].getDate()+"��");
						System.out.println("�黹���ڣ�"+returnDate+"��");
						System.out.println("Ӧ�����(Ԫ)��"+(returnDate-dvds[i].getDate()));
						dvds[i].setDate(0);
					}else {
						System.out.println("�黹��"+returnName+"��ʧ��,��DVD��û�б������");
					}
					flag = true;
				}
			}else {
				break;
			}
		}
		if(!flag) {
			System.out.println("�黹��"+returnName+"��ʧ��,û���ҵ�ƥ����Ϣ��");
		}
	}
	/*
	 * ��ѯ�������
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
