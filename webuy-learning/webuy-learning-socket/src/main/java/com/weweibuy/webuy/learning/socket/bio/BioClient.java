package com.weweibuy.webuy.learning.socket.bio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author durenhao
 * @date 2019/9/15 11:31
 **/
@Slf4j
public class BioClient {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 10, 60L,
            TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new CustomizableThreadFactory("bio-client-thread-"));

    private static String msg = "hello server";

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        sendMsg(socket);
        Thread.sleep(3000);
    }


    private static void sendMsg(Socket socket) throws Exception {

        final OutputStream outputStream = socket.getOutputStream();
        final InputStream inputStream = socket.getInputStream();

        log.info("客户端准备写出数据");
        outputStream.write(msg.getBytes());
        socket.shutdownOutput();

        log.info("客户端准备读数据");
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes, 0, len));
        }
        log.info("收到服务端数据: {}", stringBuilder.toString());

    }


}
