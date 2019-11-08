package edu.mum.cs.ea.configmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigManagementServiceApplication.class, args);
    }

}
