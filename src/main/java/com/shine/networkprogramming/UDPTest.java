package com.shine.networkprogramming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

/**
 * @author 高伟鹏
 * @email gaoweipeng3@gmail.com
 * @version 创建时间：2018年8月10日 下午1:20:34
 * @describe类 1.DatagramSocket 和 DatagramPacket 实现了基于 UDP 协议网络程序。
 *             2.UDP数据报通过数据报套接字 DatagramSocket 发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
 *             3.DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号。
 *             4.UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接
 */
public class UDPTest {
    /**
     * DatagramSocket与DatagramPacket
     * 建立发送端，接收端
     * 建立数据包
     * 调用Socket的发送、接收方法
     * 关闭Socket
     */
	// 发送端
	@Test
	
	public void send() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "你好，我是要发送的数据".getBytes();
			// 创建一个数据报：每一个数据报不能大于64k，都记录着数据信息，发送端的IP、端口号,以及要发送到
			// 的接收端的IP、端口号。
			DatagramPacket pack = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 2464);
			ds.send(pack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();

			}
		}
	}

	// 接收端
	@Test
	public void rceive() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(2464);
			byte[] b = new byte[1024];
			DatagramPacket pack = new DatagramPacket(b, 0, b.length);
			ds.receive(pack);

			String str = new String(pack.getData(), 0, pack.getLength());
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();

			}
		}
	}
}
