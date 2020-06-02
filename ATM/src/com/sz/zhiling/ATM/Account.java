package com.sz.zhiling.ATM;

/**  
* <p>Title: Account</p>  
* <p>Description: 账户类</p>  
* @author wx  
* @date 2020年6月1日  
*/
public class Account {
	private String name;		//名称，账户
	private String password;	//密码
	private String telephone;	//电话
	private String address;		//地址
	private float money;		//金额
	
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	//有参构造方法
	public Account(String name, String password, String telephone, String address, float money) {
		super();
		this.name = name;
		this.password = password;
		this.telephone = telephone;
		this.address = address;
		this.money = money;
	}
	//无参构造方法
	public Account() {
		super();
	}
}
