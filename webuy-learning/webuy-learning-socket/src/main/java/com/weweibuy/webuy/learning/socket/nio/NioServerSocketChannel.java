package com.weweibuy.webuy.learning.socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author durenhao
 * @date 2019/10/1 11:24
 **/
@Slf4j
public class NioServerSocketChannel {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    private static Selector selector;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        run(serverSocketChannel);
    }


    private static void run(ServerSocketChannel serverSocketChannel) throws IOException, InterruptedException {
        while (selector.select() > 0) {
            log.info("等待客户端连接");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    SocketChannel channel = (SocketChannel) next.channel();
                    EXECUTOR_SERVICE.submit(new ByteBufferClientHandler(channel));
                }
                iterator.remove();
            }
            Thread.sleep(200);

        }
    }


}
