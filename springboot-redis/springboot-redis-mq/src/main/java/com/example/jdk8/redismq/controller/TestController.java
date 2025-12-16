package com.example.jdk8.redismq.controller;

import com.example.jdk8.result.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author zhaojh0912
 * Description TODO
 * CreateDate 2025/12/15 22:06
 * Version 1.0
 */

@Slf4j
@RequestMapping(value = "/test")
@RestController
public class TestController {

    /**
     * 生产消息
     * @return Object
     */
    @PostMapping(value = "/sendMessage2Reis")
    public ResultBody<Object> sendMessage2Reis(){
        return ResultBody.success();
    }
}
