package com.jory.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    public static void main(String[] args) throws IOException {
        //1.创建服务器并指定端口号ServerSocket
        ServerSocket serverSocket = new ServerSocket(9889);
        //2.accept获取客户端对象 Socket
        Socket socket = serverSocket.accept();
        //3.getInputStream获取网络字节输入流
        InputStream inputStream = socket.getInputStream();
        //4.使用字节输入流read方法读取客户端发送的数据
        byte[] bytes= new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //5.getOutputStream获取网络字节输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端收到消息了".getBytes());
        socket.close();
        serverSocket.close();
    }
}
