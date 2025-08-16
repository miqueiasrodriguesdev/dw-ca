package com.miqueias_r.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WalletCleanArchitecture {
    public static void main(String[] args) {
        SpringApplication.run(WalletCleanArchitecture.class, args);
    }
}
