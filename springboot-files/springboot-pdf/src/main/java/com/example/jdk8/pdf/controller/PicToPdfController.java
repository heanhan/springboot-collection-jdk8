package com.example.jdk8.pdf.controller;


import com.example.jdk8.pdf.service.ImageToPdfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @description 图片和pdf 相互之间的转换
 * @version 1.0
 * @author zhaojh
 * @date 2024/09/5 上午11:43
 */

@Slf4j
@RequestMapping(value = "/toPdf")
@RestController
public class PicToPdfController {

    @Resource
    private ImageToPdfService imageToPdfService;

    @PostMapping(value = "/picToPdf")
    public ResponseEntity<?>picToPdf(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select an image to upload.");
        }
        // 临时存储上传的图片
        Path tempFile = Files.createTempFile("upload-", ".png");
        Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

        // 转换图片为PDF
        String outputPath = "output.pdf";
        imageToPdfService.convertImageToPdf(tempFile.toString(), outputPath);
        // 清理临时文件
        Files.delete(tempFile);
        // 返回PDF文件
        FileSystemResource resource = new FileSystemResource(new File(outputPath));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
