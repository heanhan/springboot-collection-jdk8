package com.example.jdk8.test.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2024/11/15 上午10:17
 */
public class TestMethod {

//    public static void main(String[] args) {
//        String age="";
//        String age1="男/女";
//        String age2="男";
//        String age3="女";
//        System.out.println(age.length());
//        System.out.println(age1.length());
//        System.out.println(age2.length());
//        System.out.println(age3.length());
//    }

    public static void main(String[] args) {
        String jsonStr = "{\"field\":[[{\"ADMISSION_TIME\":{\"new\":\"2025-06-25 16:30:00\",\"old\":\"2025-05-25 16:30:00\"}}]],\"patient_id\":\"002580746500\",\"newId\":\"更新#2025-07-10 16:41:24#002580746500#1#\",\"visit_id\":\"1\",\"type\":\"binganshouye\"}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        JSONObject fieldJSON = new JSONObject();
        fillFieldJSON(jsonObject, fieldJSON);
        System.out.println(fieldJSON.toJSONString());
    }


    private static void fillFieldJSON(JSONObject jsonObject, JSONObject fieldJSON) {
        JSONArray docArray = jsonObject.getJSONArray("field");
        if (docArray == null) return;
        for (int i = 0; i < docArray.size(); i++) {
            JSONArray innerArray = docArray.getJSONArray(i);
            for (int j = 0; j < innerArray.size(); j++) {
                JSONObject oneDocField = innerArray.getJSONObject(j);
                for (Map.Entry<String, Object> entry : oneDocField.entrySet()) {
                    String fieldName = entry.getKey();
                    Object fieldValue = entry.getValue();
                    JSONArray fieldArray = (JSONArray) fieldJSON.computeIfAbsent(fieldName, k -> new JSONArray());
                    fieldArray.add(fieldValue);
                }
            }
        }
    }
}
