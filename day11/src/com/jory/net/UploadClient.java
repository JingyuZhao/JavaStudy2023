package com.jory.net;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadClient {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("test_image.png");
        Socket socket = new Socket("127.0.0.1",9889);
        OutputStream outputStream = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes))!= -1) {
            outputStream.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream inputStream1 = socket.getInputStream();
        while ((len = inputStream1.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        outputStream.close();
        inputStream.close();
        inputStream1.close();
        socket.close();
    }
}
