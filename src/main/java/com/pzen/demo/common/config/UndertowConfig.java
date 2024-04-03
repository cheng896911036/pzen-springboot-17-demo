package com.pzen.demo.common.config;

import io.undertow.Undertow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现Undertow多端口启用 http  https
 *
 * @author pzen
 */
@Configuration
public class UndertowConfig {

    Logger log = LoggerFactory.getLogger(UndertowConfig.class);

    @Value("${server.port}")
    private Integer httpsPort;

    @Value("${server.http-port}")
    private Integer httpPort;

    @Bean
    public ServletWebServerFactory undertowFactory() {
        UndertowServletWebServerFactory undertowFactory = new UndertowServletWebServerFactory();
        UndertowBuilderCustomizer undertowBuilderCustomizer = new UndertowBuilderCustomizer() {
            @Override
            public void customize(Undertow.Builder builder) {
                builder.addHttpListener(httpPort, "0.0.0.0");
            }
        };
        undertowFactory.addBuilderCustomizers(undertowBuilderCustomizer);
        log.info("Undertow Application is listening on HTTP port::{}", httpPort);
        log.info("Undertow Application is listening on HTTPS port::{}", httpsPort);
        return undertowFactory;
    }
}
