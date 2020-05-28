/**  
* <p>Title: Student.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020年5月27日
*/  
package com.sz.zhiling;

/**  
* <p>Title: Student</p>  
* <p>Description:学生类 </p>  
* @author wx  
* @date 2020年5月27日  
*/
public class Student extends User {
	private String stuNum;//学生编号

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
