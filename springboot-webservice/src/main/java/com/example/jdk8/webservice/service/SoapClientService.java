package com.example.jdk8.webservice.service;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-18
 */

@Service
public class SoapClientService {

    private final String endpointUrl = "http://example.com/service"; // 替换为实际的 WebService 地址

    public String callWebService() throws Exception {
        String soapRequest =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:example=\"http://example.com/\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "       <example:SomeMethod>\n" +
                        "           <example:parameter>value</example:parameter>\n" +
                        "       </example:SomeMethod>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(endpointUrl);
            post.setHeader("Content-Type", "text/xml;charset=UTF-8");
            post.setEntity(new StringEntity(soapRequest));
            HttpResponse response = httpClient.execute(post);
            return response.getEntity().toString(); // 处理响应
        }catch (Exception e){
            return null;
        }
    }
}
