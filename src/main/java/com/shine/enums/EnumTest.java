package com.shine.enums;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 下午4:21:54
* @describe
*/
public enum EnumTest {

	RED(30){
		public  EnumTest nextLamp(){
			return GREEN;
		}
	},
	GREEN(45){
		public  EnumTest nextLamp(){
			return YELLOW;
		}			
	},
	YELLOW(5){
		public  EnumTest nextLamp(){
			return RED;
		}			
	};
	//需实现的抽象方法
	public abstract EnumTest nextLamp();
	//实例属性
	private int time;
	//私有化的构造函数
	private EnumTest(int time){this.time = time;}

	public static void main(String[] args) {
		//获取所有属性
		Object[] obj = EnumTest.values();
		for (Object o : obj) {
			System.out.println(o);
		}
		//将一个字符串转化为对应的枚举类型的对象
		System.out.println(EnumTest.valueOf("RED"));
		System.out.println(EnumTest.RED.nextLamp());
	}
}
