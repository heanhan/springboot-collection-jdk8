package com.example.jdk8.langChain4J.controller;


import com.example.jdk8.langChain4J.service.IdExtractorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/5/7 下午12:25
 */
@RestController
public class TestController {

    @Resource
    private IdExtractorService idExtractorService;

    @GetMapping("/extract-ids")
    public List<String> extractIds() throws IOException {
        return idExtractorService.extractIds();
    }
}
