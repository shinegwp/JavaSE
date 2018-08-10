package com.shine.networkprogramming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * @author 高伟鹏
 * @email gaoweipeng3@gmail.com
 * @version 创建时间：2018年8月10日 上午11:31:52
 * @describe  进行了单向发送信息，回馈信息，与文件发送
 */



// 网络编程实际上就是Socket的编程
public class TCPTest {
	
	//文件传输
	@Test
	public void clientFile()throws Exception{
		//1.创建Socket的对象
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 2464);
		//2.从本地获取一个文件发送给服务端
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("src/main/java/com/shine/networkprogramming/1.jpg"));
		byte[] b = new byte[1024];
		int len;
		while((len = fis.read(b)) != -1){
			os.write(b,0,len);
		}
		socket.shutdownOutput();
		//3.接收来自于服务端的信息
		InputStream is = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len1;
		while((len1 = is.read(b1)) != -1){
			String str = new String(b1,0,len1);
			System.out.print(str);
		}
		//4.关闭相应的流和Socket对象
		is.close();
		os.close();
		fis.close();
		socket.close();
	}
	@Test
	public void serverFile() throws Exception{
		//1.创建一个ServerSocket的对象
		ServerSocket ss = new ServerSocket(2464);
		//2.调用其accept()方法，返回一个Socket的对象
		Socket s = ss.accept();
		//3.将从客户端发送来的信息保存到本地
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("src/main/java/com/shine/networkprogramming/2.jpg"));
		byte[] b = new byte[1024];
		int len;
		while((len = is.read(b)) != -1){
			fos.write(b, 0, len);
		}
		System.out.println("收到来自于" + s.getInetAddress().getHostAddress() + "的文件");
		//4.发送"接收成功"的信息反馈给客户端
		OutputStream os = s.getOutputStream();
		os.write("你发送的图片我已接收成功！".getBytes());
		//5.关闭相应的流和Socket及ServerSocket的对象
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
	
	
    /**
     * 客户端给服务端发送信息，服务端将信息打印到控制台上，同时发送“已收到信息”给客户端
     */
	@Test
	public void clientUp() {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 2464);
			os = socket.getOutputStream();
			os.write("我是高伟鹏".getBytes());
			// shutdownOutput():执行此方法，显式的告诉服务端发送完毕！
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	// 服务端
	@Test
	public void serverUp() {
		System.out.println("已经执行");
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(2464);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
			os = s.getOutputStream();
			os.write("我已收到你的信息".getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
	/**
	 * 客户端给服务端发送信息。服务端输出此信息到控制台上
	 * @throws Exception
	 */
	// 客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			// 1.创建一个Socket的对象，通过构造器指明服务端的IP地址，以及其接收程序的端口号
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 2464);
			// 2.getOutputStream()：发送数据，方法返回OutputStream的对象
			os = socket.getOutputStream();
			// 3.具体的输出过程
			os.write("我是高伟鹏，请多关照".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4.关闭相应的流和Socket对象
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 服务端
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		try {
			// 1.创建一个ServerSocket的对象，通过构造器指明自身的端口号
			ss = new ServerSocket(2464);
			// 2.调用其accept()方法，返回一个Socket的对象
			s = ss.accept();
			// 3.调用Socket对象的getInputStream()获取一个从客户端发送过来的输入流
			is = s.getInputStream();
			// 4.对获取的输入流进行的操作
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
			}
			System.out.println("收到来自于" + s.getInetAddress().getHostAddress() + "的连接");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.关闭相应的流以及Socket、ServerSocket的对象
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
