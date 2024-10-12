package com.example.jdk8.mdc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-10-12
 */

@Slf4j
@RestController
public class TestController {


    @Resource(name = "taskExecutor")
    private Executor executor;

    @PostMapping("/pool")
    public String pool() throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            log.info("线程池里面");
            try{
                Thread.sleep(1000);
            } catch (Exception ignored){}

            return "";
        }, executor);
        future.thenApplyAsync( value ->{
            log.info("线程池组合操作");
            try{
                Thread.sleep(1000);
            } catch (Exception ignored) {}
            return value + "1";
        }, executor);
        return future.get();
    }

}
