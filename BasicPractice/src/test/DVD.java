package test;

public class DVD {
	private int id;//���
	private boolean state;//״̬��true-�ɽ� false-�ѽ��
	private String name;//����
	private int date;//�������
	private int time;//����
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public DVD(){
		
	}
	public DVD(int id,boolean state,String name,int date,int time) {
		this.id = id;
		this.state = state;
		this.name = name;
		this.date = date;
		this.time = time;
	}
}
