package me.loveshare.member;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMemberService {

    public static void main(String[] args) throws Exception {
        String[] configLocations = new String[]{"classpath*:META-INF/spring/*.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
        context.start();
        System.out.println("\n--------------------------------Member Service start successful.--------------------------------\n");
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
