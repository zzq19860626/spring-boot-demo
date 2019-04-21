package com.zjp.test.client.client;

import com.zjp.test.client.api.UserApi;
import com.zjp.test.common.UserDomain;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;


public class UserClient {

    private UserApi userApi;


    public UserClient(String url) {
        userApi = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(UserApi.class, url);
    }

    public UserDomain findByUserId(Integer userId) {
        return userApi.findById(userId);
    }

}
