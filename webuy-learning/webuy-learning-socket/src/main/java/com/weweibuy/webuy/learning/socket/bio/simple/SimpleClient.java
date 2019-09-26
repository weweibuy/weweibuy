package com.weweibuy.webuy.learning.socket.bio.simple;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author durenhao
 * @date 2019/9/23 23:11
 **/
@Slf4j
public class SimpleClient {


    public static void main(String[] args) throws IOException {
        //指定目标主机ip与端口
        Socket socket = new Socket("localhost", 8888);

        //想服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        //接收用户输入
        String message = "hello client";
        outputStream.write(message.getBytes("utf-8"));
        outputStream.flush();
        //终止发送数据，客户端现在只接收数据
        //如果不加shutdownOutput，服务器端一直阻塞在read()方法中，导致客户端无法收到服务端回显的数据
        //shutdownOutput只关闭客户端向服务端的输出流，并不会关闭整个Socket的连接
        socket.shutdownOutput();

        //从服务端接收数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "utf-8"));
        }
        log.info("来自服务端的回显: {}", sb);

        //调用close方法，会直接关闭整个Socket连接
        outputStream.close();
        inputStream.close();
        socket.close();
    }


}
