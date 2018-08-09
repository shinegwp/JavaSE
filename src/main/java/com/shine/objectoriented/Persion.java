package com.shine.objectoriented;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 下午2:45:28
* @describe
*/
public class Persion {//这是一个典型的Javabean
    //构造器又叫构造函数
	public Persion() {
		// TODO Auto-generated constructor stub
	}
	public Persion(String name, int age) {
		this();//this，访问属性，先找本类再找父类，调用方法找本类，调用构造器找本类且必须在第一条语句执行
		this.name = name;
	}
	public static String sex;//类成员，子类可以访问
	public String name;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Gwp extends Persion{
	public Gwp() {//继承
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println(Gwp.sex);
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {//重写
		this.age = age * 2;
		super.setAge(age);
	}
	public void setAge(int age, int x) {//重载
		this.age = age * x;
	}
}