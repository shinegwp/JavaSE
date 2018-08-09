package com.shine.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 下午3:49:07
* @describe
*/
public class CheckedException {

	public static void main(String[] args) {
		//捕获异常
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:a.txt");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//对异常进行处理
		} finally {
			//必须执行的代码
			try {
				fis.close();
			} catch (IOException e) {//处理流关闭异常
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//抛出异常
	public void throwsException() throws Exception{
		FileInputStream fis = new FileInputStream("");
	}
	public void throwException() throws Exception{
		try {
			FileInputStream fis = new FileInputStream("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("这是异常信息");
		}
	}
	
	
	
}
