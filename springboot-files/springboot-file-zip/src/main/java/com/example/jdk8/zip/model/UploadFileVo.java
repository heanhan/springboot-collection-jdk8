package com.example.jdk8.zip.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description : TODO
 * @Author : zhaojh
 * @Date : 2024/11/26 22:07
 */

@Data
public class UploadFileVo {

    private MultipartFile texFile;

    private MultipartFile files;
}
