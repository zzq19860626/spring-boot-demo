package com.zjp.test.server.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PropertiesConfiguration {

    @Value("${skeleton.test.userClient.url}")
    private String userClientUrl;

}
