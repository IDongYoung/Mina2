package mina;
 
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.example.gettingstarted.timeserver.TimeServerHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import java.util.Collection;
import org.apache.mina.core.session.IoSession; 
 
public class MinaTimeServer
 {
    private static final int PORT = 8888;
   
    public static void main(String[] args) 
    { 
        System.out.println("1");
    	IoAcceptor acceptor = new NioSocketAcceptor(); //socket接收器
        System.out.println("2");
        acceptor.getFilterChain().addLast("logger",new LoggingFilter()); //添加日志记录
        System.out.println("3");
        acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));  //添加编码解码器
        System.out.println("4");
        
        TimeHandler t = new TimeHandler();
        
        
        acceptor.setHandler(t); //添加处理器(用于接收数据后处理处理数据逻辑)
        System.out.println("5");
        acceptor.getSessionConfig().setReadBufferSize(2048 ); //设置读取数据缓存单位byte
        System.out.println("6");
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10 ); //设置多长时间后接收器开始空闲
        System.out.println("7");
        try {
        System.out.println("8");
            acceptor.bind(new InetSocketAddress(PORT)); //绑定某个端口，作为数据入口
            //acceptor.dispose(true);  
        System.out.println("9");
        }
        catch (IOException e) 
        {
        System.out.println("10");
            e.printStackTrace();
        System.out.println("11");
        }
        t.myacceptor = acceptor;
        System.out.println("12");
    }
}
