package mina;
 
import java.util.Date; 
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import java.util.Collection;
import java.util.Map;
import org.apache.mina.core.service.IoAcceptor;
 
public class TimeHandler extends IoHandlerAdapter
{

    public IoSession mysession = null;
    public TimeHandler another = null;
    int i=0;
    IoAcceptor myacceptor = null;
    //捕获异常
    @Override
    public void exceptionCaught(IoSession session, Throwable cause ) throws Exception
    {
        cause.printStackTrace();
    }
    //消息接收
    @Override
    public void messageReceived(IoSession session, Object message ) throws Exception
    {
        mysession = session;
        String str = message.toString();
        if(str.trim().equalsIgnoreCase("quit")) 
        {
            session.closeNow();
            return;
        }
        System.out.println("mymessage>>>>>>>>>>"+str);
        Date date = new Date();
        session.write(date.toString()+"hahahahah");
        System.out.println("i = "+i++);
        if (str.equals("show"))
        { 
            test(session);
        }
        else if (str.equals("shutdown"))
        {
            Collection<IoSession> sessions = session.getService().getManagedSessions().values();
            for (IoSession s : sessions) 
            {
                System.out.println(s.getId());
                s.closeNow();
            }
            System.out.println("before unbind");
            //myacceptor.unbind();
            if (myacceptor!=null)
            {
               System.out.println("is not null");
               session.getService().dispose(true);
            }
            System.out.println("after unbind");
            //
            return;
        }
        else if (str.equals("other"))
        {
            Collection<IoSession> sessions = session.getService().getManagedSessions().values();
            for (IoSession s : sessions) 
            {
                System.out.println(s.getId());
                s.write("hahaaha OK from number is "+session.getId());
            }   
        }
        else if (str.equals("to1"))
        {
            Collection<IoSession> sessions = session.getService().getManagedSessions().values();
            for (IoSession s : sessions) 
            {
                if (s.getId() == 1)
                    s.write("just 1 from number is "+session.getId());
            }
        }
        else if (str.equals("to2"))
        {
            Collection<IoSession> sessions = session.getService().getManagedSessions().values();
            for (IoSession s : sessions) 
            {
                if (s.getId() == 2)
                s.write("just 2 from number is "+session.getId());
            }  
        }
        else if (str.equals("to3"))
        {
            Collection<IoSession> sessions = session.getService().getManagedSessions().values();
            for (IoSession s : sessions) 
            {
                if (s.getId() == 3)
                s.write("just 3 from number is "+session.getId());
            }          
        }
        
    }
    
    public void test(IoSession session)
    {
        Collection<IoSession> sessions = session.getService().getManagedSessions().values();

        for (IoSession s : sessions) 
        {
           System.out.println(s.getId());
        }
    }
    
    
    //会话空闲
    @Override
    public void sessionIdle(IoSession session, IdleStatus status ) throws Exception
    {
        System.out.println("IDLE" + session.getIdleCount(status));
    }
}
