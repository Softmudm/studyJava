/**  
* <p>Title: User.java</p>  
* <p>Description: </p>   
* @author wx  
* @date 2020��5��27��
*/  
package com.sz.zhiling;

/**  
* <p>Title: User</p>  
* <p>Description: �û���</p>  
* @author wx  
* @date 2020��5��27��  
*/
public class User {
	private String name;	//����
	private String password;//����
	private int age;		//����
	private String sex;		//�Ա�
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(String name, String password, int age, String sex) {
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}
	public User() {
	}
}
