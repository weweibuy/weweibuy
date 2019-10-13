package com.weweibuy.webuy.learning.socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author durenhao
 * @date 2019/10/1 11:24
 **/
@Slf4j
public class NioServerSocketChannel {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        run(serverSocketChannel);
    }


    private static void run(ServerSocketChannel serverSocketChannel) throws IOException, InterruptedException {
        boolean blocking = serverSocketChannel.isBlocking();
        log.info("is blocking : {}", blocking);
        while (true) {
            log.info("等待客户端连接");
            SocketChannel accept = serverSocketChannel.accept();
            EXECUTOR_SERVICE.submit(new ByteBufferClientHandler(accept));
            Thread.sleep(100);
        }
    }


}
