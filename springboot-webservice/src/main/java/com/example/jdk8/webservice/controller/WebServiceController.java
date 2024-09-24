package com.example.jdk8.webservice.controller;

import com.example.jdk8.webservice.service.SoapClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh
 * @description: webservice 的请求层控制器
 * @date 2024-09-18
 */


@RestController
public class WebServiceController {

    private final SoapClientService soapClientService;

    public WebServiceController(SoapClientService soapClientService) {
        this.soapClientService = soapClientService;
    }

    @GetMapping("/call-soap-service")
    public String callSoapService() {
        try {
            return soapClientService.callWebService();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
