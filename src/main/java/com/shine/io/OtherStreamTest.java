package com.shine.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import org.junit.Test;

/**
 * @author 高伟鹏
 * @email gaoweipeng3@gmail.com
 * @version 创建时间：2018年8月9日 下午9:03:12
 * @describe
 */
public class OtherStreamTest {

	@Test
	public void test4() {
		createObj();
		readObj();
	}

	// （一）先写入对象
	public static void createObj() {

		ObjectOutputStream objOP = null;
		try {
			// 1.创建目标路径
			File file = new File("src/main/java/com/shine/io/gwp3.txt");
			// 2.创建流通道
			FileOutputStream fos = new FileOutputStream(file);
			// 3.创建对象输出流
			objOP = new ObjectOutputStream(fos);
			// 4.创建类对象，并初始化
			Student stu = new Student("高伟鹏", "男", 22);
			// 5.向目标路径文件写入对象
			objOP.writeObject(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 6.关闭资源
		try {
			objOP.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 再读取对象
	public static void readObj() {
		
		ObjectInputStream objIP = null;
		try {
			File file = new File("src/main/java/com/shine/io/gwp3.txt");
			FileInputStream fis = new FileInputStream(file);
			objIP = new ObjectInputStream(fis);
			Student stu = (Student) objIP.readObject();
			System.out.println("\n name:" + stu.name + "\n sex:" + stu.sex + "\n age:" + stu.age);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 读取对象数据，需要将对象流强制转换为 要写入对象的类型
		try {
			objIP.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		DataOutputStream dos = null;
		try { // 创建连接到指定文件的数据输出流对象
			File file = new File("src/main/java/com/shine/io/gwp2.dat");
			FileOutputStream fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			dos.writeUTF("ab中国"); // 写UTF字符串
			dos.writeBoolean(false); // 写入布尔值
			dos.writeLong(1234567890L); // 写入长整数
			System.out.println("写文件成功!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 关闭流对象
			try {
				if (dos != null) {
					// 关闭过滤流时,会自动关闭它包装的底层节点流
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * 标准的输入输出流： 标准的输出流：System.out 标准的输入流：System.in
	 */
	@Test
	public void test2() {
		BufferedReader br = null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str;
			while (true) {
				System.out.println("请输入字符串：");
				str = br.readLine();
				if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
					break;
				}
				String str1 = str.toUpperCase();
				System.out.println(str1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	/*
	 * 如何实现字节流与字符流之间的转换： 转换流：InputStreamReader OutputStreamWriter 编码：字符串
	 * --->字节数组 解码：字节数组--->字符串
	 */
	@Test
	public void test1() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// 解码
			File file = new File("src/main/java/com/shine/io/gwp.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			// 编码
			File file1 = new File("src/main/java/com/shine/io/gwp1.txt");
			FileOutputStream fos = new FileOutputStream(file1);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			bw = new BufferedWriter(osw);
			String str;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}

// 创建要写入磁盘的类，这个类需要实现接口 Serializable（可系列化的）
class Student implements Serializable {

	// 在这里保证了serialVersionUID 的唯一性，防止属性变量的临时改变，从而造成写入id与读取id不同
	private static final long serialVersionUID = 1L;

	String name;
	transient String sex; // transient修饰属性，表示暂时的，则这个属性不会被写入磁盘
	transient int age;

	public Student(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
}