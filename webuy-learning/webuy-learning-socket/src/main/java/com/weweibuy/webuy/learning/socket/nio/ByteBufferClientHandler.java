package com.weweibuy.webuy.learning.socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Callable;

/**
 * @author durenhao
 * @date 2019/10/1 11:31
 **/
@Slf4j
public class ByteBufferClientHandler implements Callable<String> {

    private SocketChannel socket;

    @Override
    public String call() throws Exception {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int len = 0;
        StringBuilder stringBuilder = new StringBuilder();
        socket.read(allocate);
            String s1 = new String(allocate.array(), "utf-8");
            stringBuilder.append(s1);
            allocate.clear();
        log.info("收到请求数据: {}", stringBuilder);
        socket.shutdownInput();
        String s = "HTTP/1.1 200 OK\r\n" +  //响应头第一行
                "Content-Type: application/json; charset=utf-8\r\n" +  //简单放一个头部信息
                "\r\n" +  //这个空行是来分隔请求头与请求体的
                "{\"data\": \"hello client byteBuffer\"}\r\n";
        allocate.clear();
        ByteBuffer put = allocate.put(s.getBytes());
        put.flip();
        socket.write(put);
        socket.close();
        log.info("关闭连接");
        return "";
    }
    public ByteBufferClientHandler(SocketChannel accept) {
        socket = accept;
    }
}
