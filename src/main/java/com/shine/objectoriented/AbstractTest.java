package com.shine.objectoriented;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 下午3:11:28
* @describe
*/
public abstract class AbstractTest {

	
	//abstract不能修饰属性私有方法、构造器、静态方法、final方法
	public AbstractTest() {//可以有构造器，但不能被实例化
		// TODO Auto-generated constructor stub
	}
	
	public static String name;
	public String name1;
	private String name2;
	public static final String name3 = "da";
	
	
	public abstract void persion();
	protected abstract void persion1();
	abstract void persion2();
//	private abstract void persion3();//不能被private修饰
	
	
}
interface InterfaceTest{//接口只能被public和interface修饰
//	public static String name;
//	protected String name1="dasf";
//	private String name= "dsa";
	public static String name3 = "dsaf";
	public  String name4 = "da";//只能被public、static、final修饰，且默认为final，必须进行赋值.因为不存在静态块
	
	
	public abstract void persion();
//	protected abstract void persion1();
	abstract void persion2();//
//	private abstract void persion3();//不能被private修饰
}