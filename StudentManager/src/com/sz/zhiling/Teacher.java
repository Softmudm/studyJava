/**  
* <p>Title: Teacher.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020年5月27日
*/  
package com.sz.zhiling;

/**  
* <p>Title: Teacher</p>  
* <p>Description:教师类 </p>  
* @author wx  
* @date 2020年5月27日  
*/
public class Teacher extends User {
	private String teaNum;//教师编号

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
