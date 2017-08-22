/**
 * Created by Tony on 2017/8/22.
 * RPC的服务接口实现服务类
 */
public class HelloService implements Hello {

    @Override
    public String hello(Integer a, Integer b, String s) {
        String result = s + ": " + a + " + " + b + " = " + (a + b) + " .";
        System.out.println(result);
        return result;
    }
}
