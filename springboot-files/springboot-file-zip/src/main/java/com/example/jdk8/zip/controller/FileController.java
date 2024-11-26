package com.example.jdk8.zip.controller;

import com.example.jdk8.result.ResultBody;
import com.example.jdk8.zip.model.UploadFileVo;
import com.example.jdk8.zip.utils.FileZip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description : TODO
 * @Author : zhaojh
 * @Date : 2024/11/26 22:01
 */

@Slf4j
@RestController
public class FileController {

    @PostMapping(value = "/uploadFile")
    public ResultBody<Object> uploadFile(UploadFileVo uploadFileVo) {
        MultipartFile texFile = uploadFileVo.getTexFile();
        MultipartFile file = uploadFileVo.getFiles();

        try {
            String path="/Users/zhaojh/Downloads/test";
            // 创建上传目录
            File uploadDir = new File(path);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            // 保存原文件
            File originalFile = new File(path +File.separator+ file.getOriginalFilename());
            file.transferTo(originalFile);
            String absolutePath = originalFile.getAbsolutePath();
            // 压缩文件并保存
            String zipFileName = path+File.separator + file.getOriginalFilename()+ ".zip";
            FileZip.compress(absolutePath,zipFileName);
            //删除原文件
            log.info("message", "文件上传成功！");
        } catch (IOException e) {
            log.info("message", "文件上传失败：" + e.getMessage());
        }
        return ResultBody.success();
    }
}
