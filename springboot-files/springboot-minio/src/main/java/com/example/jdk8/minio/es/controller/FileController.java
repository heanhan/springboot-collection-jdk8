package com.example.jdk8.minio.es.controller;


import com.example.jdk8.minio.es.entity.FileTable;
import com.example.jdk8.minio.es.service.FileTableService;
import com.example.jdk8.minio.es.utils.MinioUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/22 下午3:52
 */
@RestController
@RequestMapping("/file")
public class FileController {


    private final FileTableService fileTableService;

    public FileController(MinioUtils minioUtils, FileTableService fileTableService) {
        this.fileTableService = fileTableService;
    }


    /**
     * 文件上传
     * @param file  文件
     * @param bucketName  桶名称
     * @return
     */
    @GetMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, String bucketName) {
        fileTableService.uploadFile(file, bucketName);
        return "文件上传成功";
    }

    /**
     * 简单测试一个查询高亮
     *
     * @param id
     * @return
     */
    @GetMapping("/getInfoHighlight")
    public List<FileTable> getInfoHighlight(Long id) {
        return fileTableService.getInfoHighlight(id);
    }

}

