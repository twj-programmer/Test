package me.hmhb.test;

import jakarta.annotation.Resource;
import me.hmhb.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class TestApplicationTests {

    @Resource
    ApplicationContext context;

    @Resource
    MyService myService;

    @Test
    void contextLoads() {
        System.out.println("你好");
        myService.test();
    }
}
