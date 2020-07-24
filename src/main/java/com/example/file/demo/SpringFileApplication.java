package com.example.file.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 启动项目
 * @author lks
 */
@Slf4j
@SpringBootApplication
public class SpringFileApplication {

    public static void main(String[] args) {
        ConfigurableEnvironment env = SpringApplication.run(SpringFileApplication.class, args).getEnvironment();
        log.info("\n\t" +
                        "项目名称 '{}' 启动~~~~~ \n\t" +
                        "环境类型: {}\n\t" +
                        "日志级别: {}" +
                        "\n",
                env.getProperty("spring.application.name"),
                env.getActiveProfiles(),
                env.getProperty("logging.level.ROOT"));
    }

}
