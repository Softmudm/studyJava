/**  
* <p>Title: Student.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020��5��27��
*/  
package com.sz.zhiling;

/**  
* <p>Title: Student</p>  
* <p>Description:ѧ���� </p>  
* @author wx  
* @date 2020��5��27��  
*/
public class Student extends User {
	private String stuNum;//ѧ�����

	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String stuNum,String name, String password, int age, String sex) {
		super(name, password, age, sex);
		this.stuNum = stuNum;
		// TODO Auto-generated constructor stub
	}
}
