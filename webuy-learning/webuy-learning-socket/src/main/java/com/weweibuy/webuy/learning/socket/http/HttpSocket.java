package com.weweibuy.webuy.learning.socket.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author durenhao
 * @date 2020/6/9 22:26
 **/
@Slf4j
public class HttpSocket {

    public static void main(String[] args) throws IOException {

        int i = RandomUtils.nextInt(1000, 30000);
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("localhost", i);
//        SocketAddress rsocketAddress = new InetSocketAddress("www.baidu.com", 80);
        SocketAddress rsocketAddress = new InetSocketAddress("localhost", 9000);
//        socket.bind(socketAddress);
        socket.connect(rsocketAddress);

        //获取输入流，即从服务器获取的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //获取输出流，即我们写出给服务器的数据
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String str = "GET /hello HTTP/1.1\n" +
                "Content-Type: application/json\n" +
                "token: token_123\n" +
                "Accept: */*\n" +
                "Content-Length: 39\n" +
                "Host: www.baidu.com\n" +
                "Connection: Keep-Alive\n" +
                "User-Agent: Apache-HttpClient/4.5.10 (Java/1.8.0_121)\n" +
                "Accept-Encoding: gzip,deflate\n" +
                "\n" +
                "{\"code\":\"0\",\"msg\":\"成功\",\"data\":null}";

        bufferedWriter.write(str);
        bufferedWriter.flush();

        String str1 = "";

         byte[] buf = new byte[1024];
         int len = 0;
        StringBuffer buffer = new StringBuffer();

        while ((len = inputStream.read(buf)) != -1){
            buffer.append(new String(buf));
            System.err.println(new String(buf));
         }

        log.info("响应数据: {}", buffer);
    }


}
