import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

public class ChatServerInitializer extends ChannelInitializer<SocketChannel>  {
    @Override
    protected void initChannel(io.netty.channel.socket.SocketChannel arg0)  {
        try {


            ChannelPipeline pipeline = arg0.pipeline();
            pipeline.addLast("decoder", new Gt06Decoder());





        }catch (Exception ex)
        {
            ex.getMessage();
        }
    }
}
