package com.weweibuy.webuy.learning.socket.bio.simple;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author durenhao
 * @date 2019/9/23 23:09
 **/
@Slf4j
public class SimpleServer {


    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            //建立连接
            Socket socket = serverSocket.accept();

            //获得客户端传来的数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "utf-8"));
            }
            log.info("服务端收到了消息: {}", sb);

            //接收到数据后，回显收到的数据
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(new String("hello client").getBytes("utf-8"));

            inputStream.close();
            outputStream.close();
            socket.close();
            Thread.sleep(300);
        }

    }
}
