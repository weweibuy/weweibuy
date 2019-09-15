package com.weweibuy.webuy.learning.socket.bio;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author durenhao
 * @date 2019/9/15 11:12
 **/
public class BioServer {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(3, 10, 60L,
            TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new CustomizableThreadFactory("bio-server-thread-"));

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        EXECUTOR_SERVICE.submit(() -> {
            startServer(serverSocket);
            return "";
        });
    }


    private static void handleAccept(Socket accept) throws IOException {
        accept.getInputStream().read();
    }

    private static void startServer(ServerSocket serverSocket) throws IOException, InterruptedException {
        while (true) {
            Socket accept = serverSocket.accept();
            EXECUTOR_SERVICE.submit(new BioClientHandler(accept));
            Thread.sleep(500);
        }
    }
}
