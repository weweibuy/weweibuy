package com.weweibuy.webuy.backstage.test.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SocketServer
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 21:36
 **/
@Slf4j
@ServerEndpoint(value = "/socketServer")
@Component
public class SocketServer {

//    private static CopyOnWriteArraySet<SocketServer> webSocketSet = new CopyOnWriteArraySet<SocketServer>();

    private static ConcurrentHashMap<String, SocketServer> webSocketMap = new ConcurrentHashMap<>(16);

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    public void sendMessage(String msg) {
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void sendMessage(SocketMessageInfo messageInfo) {
        try {
            SocketServer socketServer = webSocketMap.get(messageInfo.getSessionKey());
            socketServer.getSession().getBasicRemote().sendText(messageInfo.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.error("sessionID {}  uri {}; ", session.getId(), session.getRequestURI());
        log.error("来自客户端的消息:" + message);
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketMap.put(session.getId(), this);
        String sessionKey = WebSocketUtil.getRemoteAddress(session).getHostName();
        webSocketMap.put(sessionKey, this);
        log.error("客户端 {} 连接成功", session.getId());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        log.error("移除客户端。。。");
        InetSocketAddress remoteAddress = WebSocketUtil.getRemoteAddress(this.session);
    }

     /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误  {}", error.getMessage());
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message) throws IOException {
//        for (SocketServer item : webSocketSet) {
//            item.sendMessage(message);
//        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
