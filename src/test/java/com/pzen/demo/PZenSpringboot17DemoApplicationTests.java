package com.pzen.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PZenSpringboot17DemoApplicationTests {

    @Test
    void contextLoads() {
        // 创建被测试类的实例
        MyClass myClass = new MyClass();

        // 调用方法并捕获结果
        String result = myClass.getHelloWorld();

        // 使用断言验证结果是否符合预期
        assertEquals("hello world", result);
    }

}
class MyClass {
    public String getHelloWorld() {
        return "hello world";
    }
}
