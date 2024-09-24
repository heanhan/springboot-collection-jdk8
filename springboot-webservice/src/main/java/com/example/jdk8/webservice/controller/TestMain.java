package com.example.jdk8.webservice.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-09-19
 */
@Slf4j
public class TestMain {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            log.info("无线循环方法");
            //设置阻塞方法
            Socket socket = serverSocket.accept();
            log.info("跳出阻塞");
            handleSocket(socket);

        }
    }

    //处理打印客户端的信息
    private static void handleSocket(Socket socket) throws IOException {
        //定一个一个数据
        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read();
        if (read == -1) {
            socket.close();
        }
        log.info("打印接收的结果：{}",new String(bytes,0,read));
    }
}
