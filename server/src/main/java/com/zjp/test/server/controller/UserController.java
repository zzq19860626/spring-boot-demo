package com.zjp.test.server.controller;

import com.zjp.test.client.client.UserClient;
import com.zjp.test.common.UserDomain;
import com.zjp.test.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(value = "用户查询接口")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserClient userClient;


    @ApiResponses(value = {@ApiResponse(code = 401, message = "请求未通过认证.")})
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public UserDomain findUser(@PathVariable Integer id) {
        log.info("测试请求到这里了～～～～·");
        return userService.findById(id);
    }


    @ApiResponses(value = {@ApiResponse(code = 401, message = "请求未通过认证.")})
    @RequestMapping(value = "/findTestClient/{id}", method = RequestMethod.GET)
    public UserDomain findUserTest(@PathVariable Integer id) {
        return userClient.findByUserId(id);
    }
}
