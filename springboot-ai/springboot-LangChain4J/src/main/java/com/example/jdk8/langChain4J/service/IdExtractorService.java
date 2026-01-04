package com.example.jdk8.langChain4J.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/5/7 下午12:26
 */
@Service
public class IdExtractorService {

    public List<String> extractIds() throws IOException {
        // 从 resources 目录加载文件
        ClassPathResource resource = new ClassPathResource("data.json");
        String content = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()), "UTF-8");

        // 解析 JSON 数据
        JSONArray jsonArray = JSON.parseArray(content);
        List<String> ids = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String id = jsonObject.getString("_id");
            if (id != null) {
                ids.add(id);
            }
        }

        return ids;
    }
}
