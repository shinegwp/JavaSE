package com.shine.operator;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 上午11:12:15
* @describe
*/
public class BitTest {

	public static void main(String[] args) {
		int target = 8;
		System.out.println("左移1位后"+(target<<1));
		System.out.println("右移2位"+(target>>2));
		System.out.println("进行与运算"+(target&2));//都为1，则为1
		System.out.println("进行或运算"+(target|2));//都为0则为0
		System.out.println("进行异或运算"+(target^2));//相同为0，不同为1
		
		System.out.println(true?9:0);
		System.out.println(false?9:0);
//		
//		左移1位后16
//		右移2位2
//		进行与运算0
//		进行或运算10
//		进行异或运算10
//		9
//		0

	}
}
