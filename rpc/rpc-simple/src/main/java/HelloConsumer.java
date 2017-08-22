import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by Tony on 2017/8/22.
 * 服务消费者  -- 基于TCP协议实现简单的RPC
 */
public class HelloConsumer {

    static final String ip = "127.0.0.1";
    static final int port = 20172;

    public static void main(String[] args) {
        try {
            //接口名称
            String interfaceName = Hello.class.getName();
            //需要远程执行的方法
            Method method = Hello.class.getMethod("hello", Integer.class, Integer.class, String.class);
            //需要传递到远程的参数
            Object[] arguments = {444, 666, "keke"};

            Socket socket = new Socket(ip, port);

            //将方法名称和参数传递到远程
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF(interfaceName);
            output.writeUTF(method.getName());
            output.writeObject(method.getParameterTypes());
            output.writeObject(arguments);

            //从远程读取方法的执行结果
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Object result = input.readObject();

            System.out.println("Remote execute result:" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
