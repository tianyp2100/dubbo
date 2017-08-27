package me.loveshare;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@Slf4j
@SpringBootApplication(scanBasePackages = {"me.loveshare"})
@ImportResource(value = {"classpath:dubbo-context.xml"}) //加入dubbo的xml文件
public class MemberApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApiApplication.class, args);
        log.info("\n--------------------------------Member Api Application start successful.--------------------------------\n");
    }
}
