import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import javax.xml.bind.DatatypeConverter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class Gt06Decoder extends ChannelInboundHandlerAdapter {

    @Override
  public   void channelRead(ChannelHandlerContext arg1, Object msg) {
        try {
            while (true) {
                boolean end = false;

                byte[] messagebyte=(byte []) msg;
                try {
                        String hex = "";
                        String asciiString = Arrays.toString(messagebyte);
                        System.out.println("ASCII = " + asciiString);
                        hex = DatatypeConverter.printHexBinary(messagebyte);
                        System.out.println("clientdata::::" + hex);

                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Override
    public void exceptionCaught(
            ChannelHandlerContext ctx, Throwable cause )
    {
        cause.printStackTrace();
        ctx.close();
    }
}


