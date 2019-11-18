import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Nettygt06server {
    private int port;
    public static  void main(String [] args) throws  InterruptedException{
        new Nettygt06server(10202).run();
    }
    public Nettygt06server(int port) {
        this.port = port;
    }
    public void run() throws  InterruptedException{

        EventLoopGroup bossGroup = new NioEventLoopGroup() ;
        EventLoopGroup workGroup=new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer());
            bootstrap.bind(port).sync().channel().closeFuture().sync();


        }catch(Exception ex){
            ex.getMessage();
        }finally {

            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
