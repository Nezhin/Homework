package handlers;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import data.DataPackage;

import java.util.ArrayList;
import java.util.List;

public class ServerHandler extends SimpleChannelInboundHandler<DataPackage> {
    private static final List<Channel> channels = new ArrayList<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Клиент подключился: " + ctx);
        channels.add(ctx.channel());
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataPackage dataPackage) throws Exception {
        System.out.println("Получено сообщение: " + dataPackage.getMsg());
    }



    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("Клиент вышел из сети");
        channels.remove(ctx.channel());
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Клиент  отвалился");
        channels.remove(ctx.channel());
        ctx.close();
    }
}