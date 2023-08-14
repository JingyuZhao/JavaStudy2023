package com.jory.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket localHost = new Socket("127.0.0.1",9889);
        OutputStream outputStream = localHost.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
        String input = scanner.next();
        outputStream.write(input.getBytes());
        InputStream inputStream = localHost.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        localHost.close();
    }

}
