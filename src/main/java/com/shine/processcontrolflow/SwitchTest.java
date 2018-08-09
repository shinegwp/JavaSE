package com.shine.processcontrolflow;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 上午11:28:17
* @describe
*/
public class SwitchTest {

	public static void main(String[] args) {
		switch (1) {//char byte short int string boolean enum
		case 1:     //case中的值不可相同
			System.out.println("1");
			break;
        case 2:
			System.out.println(2);
			break;
		default:
			System.out.println(3);
			break;
		}
	}
}
