package com.shine.array;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 上午11:49:21
* @describe  //存放再堆中，大数组直接进入永久代
*/
public class ArrayTest {

	public static void main(String[] args) {
		//创建
		int[] a;
		int a1[];
		//动态初始化
		int[] b1 = new int[3];
		
		
		//静态初始化
		int[] c1 = new int[]{1,2,3};
		int[] c2 = {1,2,3};
		
		//多维数组
		//动态初始化
		int[][] arr = new int[3][2];
		int[][] arr1 = new int[3][];
		//int[][] arr2 = new int[][3];错误的初始化
		
		//静态初始化
		int[][] arrs = new int[][]{{}};
		int[][] arrs2 = {{}};
		//只有一个方法   length
		
	}
}
