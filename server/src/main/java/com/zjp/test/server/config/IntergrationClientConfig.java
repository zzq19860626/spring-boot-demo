package com.zjp.test.server.config;

import com.zjp.test.client.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IntergrationClientConfig {


    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @Bean
    public UserClient userClient() {
        return new UserClient(propertiesConfiguration.getUserClientUrl());
    }

}



