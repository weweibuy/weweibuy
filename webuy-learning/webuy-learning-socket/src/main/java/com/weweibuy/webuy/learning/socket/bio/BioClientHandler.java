package com.weweibuy.webuy.learning.socket.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.Socket;
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
        InputStream inputStream = socket.getInputStream();
        while (true) {
            byte[] byteBuff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(byteBuff)) != -1) {
                String message = new String(byteBuff, 0, len);
                log.info("收到客户端信息: {}", message);
                socket.getOutputStream().write(("hello client" + message).getBytes());
            }
            Thread.sleep(500);
        }
    }
}
