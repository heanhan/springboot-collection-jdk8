package com.example.jdk8.minio.es.utils;


import lombok.SneakyThrows;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/22 下午3:58
 */
public class FileUtils {

    private static final List<String> FILE_TYPE;


    static {
        FILE_TYPE = Arrays.asList("pdf", "doc", "docx", "text");
    }


    @SneakyThrows
    public static String readFileContent(File file, String fileType) {
        file.
        if (!FILE_TYPE.contains(fileType)) {
            return null;
        }
        // 使用PdfBox读取pdf文件内容
        if ("pdf".equalsIgnoreCase(fileType)) {
            return readPdfContent(inputStream);
        } else if ("doc".equalsIgnoreCase(fileType) || "docx".equalsIgnoreCase(fileType)) {
            return readDocOrDocxContent(inputStream);
        } else if ("tex".equalsIgnoreCase(fileType)) {
            return readTextContent(inputStream);
        }

        return null;
    }


    /**
     * @description: 读取pdf文件
     * @date: 2025/1/22
     * @param: inputStream
     **/
    @SneakyThrows
    private static String readPdfContent(InputStream inputStream) {
        // 加载PDF文档
        // pdfbox 到了3.0.3 版本 PDDocument.load() 改为 Loader.loadPDF()
        PDDocument pdDocument = Loader.loadPDF(new File(""));
        // 创建PDFTextStripper对象, 提取文本
        PDFTextStripper textStripper = new PDFTextStripper();
        // 提取文本
        String content = textStripper.getText(pdDocument);
        // 关闭PDF文档
        pdDocument.close();
        return content;
    }

/**
 * @description: 读取word 文件
 * @date: 2025/1/22
 * @param: inputStream
 **/
    private static String readDocOrDocxContent(InputStream inputStream) {
        try {
            // 加载DOC文档
            XWPFDocument document = new XWPFDocument(inputStream);
            // 2. 提取文本内容
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            return extractor.getText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

/**
 * @description: 读取文本文件
 * @date: 2025/1/22
 * @param: inputStream
 **/
    private static String readTextContent(InputStream inputStream) {
        StringBuilder content = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            int ch;
            while ((ch = isr.read()) != -1) {
                content.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return content.toString();
    }

}

