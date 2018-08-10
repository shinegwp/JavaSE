package com.shine.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月10日 下午4:01:49
* @describe
*/
/*
 * 一、使用 NIO 完成网络通信的三个核心：
 * 
 * 1. 通道（Channel）：负责连接
 * 		
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 * 
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 * 
 * 2. 缓冲区（Buffer）：负责数据的存取
 * 
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 * 
 */
public class BlockingNIOTest {

	//客户端
		@Test
		public void client() throws IOException{
			//1. 获取通道
			SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 2464));
			
			FileChannel inChannel = FileChannel.open(Paths.get("src/main/java/com/shine/nio/1.jpg"), StandardOpenOption.READ);
			
			//2. 分配指定大小的缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			//3. 读取本地文件，并发送到服务端
			while(inChannel.read(buf) != -1){
				buf.flip();
				sChannel.write(buf);
				buf.clear();
			}
			sChannel.shutdownOutput();
			
			//4. 接收服务端的反馈
			int len = 0;
			while((len = sChannel.read(buf)) != -1){
				buf.flip();
				System.out.println(new String(buf.array(), 0, len));
				buf.clear();
			}
			//5. 关闭通道
			inChannel.close();
			sChannel.close();
		}
		
		//服务端
		@Test
		public void server() throws IOException{
			//1. 获取通道
			ServerSocketChannel ssChannel = ServerSocketChannel.open();
			
			FileChannel outChannel = FileChannel.open(Paths.get("src/main/java/com/shine/nio/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
			//2. 绑定连接
			ssChannel.bind(new InetSocketAddress(2464));
			
			//3. 获取客户端连接的通道
			SocketChannel sChannel = ssChannel.accept();
			
			//4. 分配指定大小的缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			//5. 接收客户端的数据，并保存到本地
			while(sChannel.read(buf) != -1){
				buf.flip();
				outChannel.write(buf);
				buf.clear();
			}
			//6. 发送反馈给客户端
			buf.put("服务端接收数据成功".getBytes());
			buf.flip();
			sChannel.write(buf);
			
			//7. 关闭通道
			sChannel.close();
			outChannel.close();
			ssChannel.close();
			
		}
}
