package com.shine.objectoriented;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 下午3:06:53
* @describe
*/
public final class FinalTest {//final修饰的类不能被继承，其中的方法不能被重写
    //String System  StringBuffer都是
	public final String NAME = "shine";//final修饰的变量为常量，只能被赋值一次
	
	public final static int AGE;//若被static修饰，可在静态块中赋值
	static {
		AGE = 1;
	}
}
