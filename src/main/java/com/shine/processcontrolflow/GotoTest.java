package com.shine.processcontrolflow;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 上午11:38:05
* @describe
*/
public class GotoTest {

	
	public static void main(String[] args) {
		
		
		a : for (int i = 0;i < 1;i++) {
			d: System.out.println();
			b : for (;;) {
				c : for (;;) {
					break b;
				}
                //System.out.println("b");编译器判断词条语句无法执行
			}
	        System.out.println("a");
	        continue a;//只能作用于外部循环体
		}
	    
		System.out.println("kaishi 并 结束");
	}
}
