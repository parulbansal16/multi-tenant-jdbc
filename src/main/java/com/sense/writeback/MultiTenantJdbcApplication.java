package com.sense.writeback;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.sense.writeback", exclude = SecurityAutoConfiguration.class)
public class MultiTenantJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiTenantJdbcApplication.class, args);
    }
}
