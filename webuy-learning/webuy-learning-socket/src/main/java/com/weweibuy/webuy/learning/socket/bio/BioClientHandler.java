package com.weweibuy.webuy.learning.socket.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

/**
 * @author durenhao
 * @date 2019/9/15 11:33
 **/
@Slf4j
public class BioClientHandler implements Callable<String> {

    private Socket socket;

    public BioClientHandler(Socket accept) {
        socket = accept;
    }

    @Override
    public String call() throws Exception {
        log.info("有客户端连接");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(outputStream, Charset.forName("UTF-8")));


        String line = bufferedReader.readLine();
        log.info("[SimpleHttpCommandCenter] socket income: " + line
                + "," + socket.getInetAddress());


        StringBuilder stringBuilder = new StringBuilder();
        String str = null;
        if ((str = bufferedReader.readLine()) != null) {
            stringBuilder.append(str);
        }

        log.info("请求数据: {}", stringBuilder);
        printWriter.print("HTTP/1.1 200 OK\r\n" +  //响应头第一行
                "Content-Type: application/json; charset=utf-8\r\n" +  //简单放一个头部信息
                "\r\n" +  //这个空行是来分隔请求头与请求体的
                "{\"data\": \"hello client\"}\r\n");
        printWriter.flush();
        bufferedReader.close();
        printWriter.checkError();
        socket.close();
        return "";
    }
}
