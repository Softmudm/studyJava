package test;

import java.util.Arrays;

/**
 * 探究值传递和引用传递的区别
 * @author Administrator
 *
 */
public class TestArgs {

	public TestArgs() {
		// TODO Auto-generated constructor stub
	}
	public static void swap(int a,int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
	}
	public static void swap(String m,String n) {
		String temp;
		temp = m;
		m = n;
		n = temp;
	}
	public static void swap(int[] a) {
		for(int i=0;i<a.length;i++) {
			a[i] = 6;
		}
		//return a;
	}
	public static void change(StringBuffer o) {
		o.append(",World");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 2;
		swap(a,b);
		System.out.println("a="+a+"b="+b);
		String m = "11";
		String n = "22";
		swap(m,n);
		System.out.println("m="+m+"n="+n);
		int[] o = {1,2,3,4,5,6};
		swap(o);
		System.out.println(Arrays.toString(o));
		StringBuffer str = new StringBuffer("Hello");
		change(str);
		System.out.println(str);
	}

}
