package com.pzen.demo.common.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.web.embedded.undertow.ConfigurableUndertowWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * @author pzen
 */

//@Component
public class UndertowWebServerFactoryCustomizer implements WebServerFactoryCustomizer<ConfigurableUndertowWebServerFactory> {

    @Override
    public void customize(ConfigurableUndertowWebServerFactory factory) {
        // 自定义 Undertow 参数，例如设置 IO 线程数
        factory.addBuilderCustomizers(builder -> builder.setIoThreads(8));

        // 设置 worker 线程数
        factory.addBuilderCustomizers(builder -> builder.setWorkerThreads(256));

        // 其他配置选项
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
    }
}
