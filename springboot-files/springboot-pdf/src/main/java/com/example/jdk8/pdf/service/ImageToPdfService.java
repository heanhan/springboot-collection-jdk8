package com.example.jdk8.pdf.service;


import java.io.IOException;

/**
 * @author zhaojh
 * @version 1.0
 * @description 图片转换成pdf
 * @date 2024/11/5 上午11:47
 */
public interface ImageToPdfService {

    void convertImageToPdf(String imagePath, String pdfPath) throws IOException;
}
