package com.zjp.test.client.api;

import com.zjp.test.common.UserDomain;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserApi {

    @Headers({"Content-Type: application/json"})
    @RequestLine("GET /user/find/{id}")
    UserDomain findById(@Param("id") Integer id);

}
