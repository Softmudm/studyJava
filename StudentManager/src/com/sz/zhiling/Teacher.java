/**  
* <p>Title: Teacher.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020��5��27��
*/  
package com.sz.zhiling;

/**  
* <p>Title: Teacher</p>  
* <p>Description:��ʦ�� </p>  
* @author wx  
* @date 2020��5��27��  
*/
public class Teacher extends User {
	private String teaNum;//��ʦ���

	public String getTeaNum() {
		return teaNum;
	}
	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String teaNum,String name, String password, int age, String sex) {
		super(name, password, age, sex);
		this.teaNum = teaNum;
		// TODO Auto-generated constructor stub
	}
}
