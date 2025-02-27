//package com.example.jdk8.langChain4J.controller;
//
//import dev.langchain4j.model.chat.response.ChatResponse;
//import dev.langchain4j.model.input.Prompt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequestMapping("/ollama")
//@RestController
//public class OllamaClientController {
//
//    @Autowired
//    @Qualifier("ollamaChatClient")
//    private OllamaChatClient ollamaChatClient;
//
//    /**
//     * http://localhost:8088/ollama/chat/v1?msg=天空为什么是蓝色的？
//     */
//    @GetMapping("/chat/v1")
//    public String ollamaChat(@RequestParam String msg) {
//        return this.ollamaChatClient.call(msg);
//    }
//
//    /**
//     * http://localhost:8088/ollama/chat/v2?msg=人为什么要不断的追求卓越？
//     */
//    @GetMapping("/chat/v2")
//    public Object ollamaChatV2(@RequestParam String msg) {
//        Prompt prompt = new Prompt(msg);
//        ChatResponse chatResponse = ollamaChatClient.call(prompt);
//        return chatResponse;
//    }
//
//    /**
//     * http://localhost:8088/ollama/chat/v3?msg=你认为老牛同学的文章如何？
//     */
//    @GetMapping("/chat/v3")
//    public Object ollamaChatV3(@RequestParam String msg) {
//        Prompt prompt = new Prompt(
//                msg,
//                OllamaOptions.create()
//                        .withModel("qwen:0.5b")
//                        .withTemperature(0.4F));
//        ChatResponse chatResponse = ollamaChatClient.call(prompt);
//        return chatResponse.getResult().getOutput().getContent();
//    }
//
//}