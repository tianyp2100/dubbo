import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tony on 2017/8/22.
 * 服务提供着  -- 基于TCP协议实现简单的RPC
 */
public class HelloProvider {

    static final int port = 20172;

    static Map<String, Object> services = new HashMap<String, Object>();

    static {
        services.put("Hello", new HelloService());
    }

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Service provider start successful, port:" + port);
            while (true) {
                System.out.println("Waits for the next request.");
                Socket socket = server.accept();
                /*******************解析请求信息*******************/
                //读取服务信息
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                //接口名称
                String interfaceName = input.readUTF();
                //方法名称
                String methodName = input.readUTF();
                //参数类型
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                //参数对象
                Object[] arguments = (Object[]) input.readObject();

                /*******************执行调用*******************/
                //得到接口的class
                Class serviceInterfaceClass = Class.forName(interfaceName);
                //取得服务的实现对象
                Object service = services.get(interfaceName);
                //获得要调用的方法
                Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, arguments);

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (!server.isClosed()) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
