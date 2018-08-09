package com.shine.primitive;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 上午10:56:49
* @describe
*/
public class CharTest {

	public static void main(String[] args) {
		char c16 = 0xA;
		char c10 = 0;
		char c8 = 07;
		char c2 = 0b1;//JDK1.7以下不成立
		
		char csz = '高';
		char cse = ' ';
		//char csn = '';单引号中必须有一个字符
		
		char ch = '\n';
		char cu = '\u0001';//Unicode值
		
	}
}
