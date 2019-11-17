package com.weweibuy.webuy.learning.socket.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author durenhao
 * @date 2019/11/9 22:27
 **/
@Slf4j
@ChannelHandler.Sharable
public class SimpleChannelHandlerAdapter extends ChannelInboundHandlerAdapter {


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        log.info("SimpleChannelHandlerAdapter .. 发生异常", cause);
        ctx.fireExceptionCaught(cause);
    }



}
