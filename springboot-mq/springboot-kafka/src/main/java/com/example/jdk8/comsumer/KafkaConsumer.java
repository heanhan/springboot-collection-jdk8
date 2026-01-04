package com.example.jdk8.comsumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@ConditionalOnProperty(name = "kafka.enabled", havingValue = "true")
public class KafkaConsumer {


    @Value("${spring.kafka.listener.enabled}")
    private boolean listenerEnabled;


    @KafkaListener(topics = "${spring.kafka.listener.topics}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
        if (!listenerEnabled) {
            return;
        }
        log.info("Received message key: {}", key);
        JSONObject jsonObject = JSONObject.parseObject(key);
        String docName = jsonObject.getString("type");
        String patientId = jsonObject.getString("patient_id");
        String visitId = jsonObject.getString("visit_id");
        // 中台改成按就诊次发送 该字段改为数组
        JSONArray docJSON = jsonObject.containsKey("doc") ? jsonObject.getJSONArray("doc") : new JSONArray();
        String type = extractType(jsonObject);
        JSONObject fieldJSON = new JSONObject();
        if ("更新".equals(type)) {
            fillFieldJSON(jsonObject, fieldJSON);
        }
        log.info("开始执行业务的逻辑处理");
//        eventService.sendEventMessage(patientId, visitId, docName, docJSON, type, fieldJSON);


    }

    private String extractType(JSONObject jsonObject) {
        if (jsonObject.containsKey("newId")) {
            String newId = jsonObject.getString("newId");
            String[] messageArray = newId.split("#");
            return messageArray[0];
        }
        return "";
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

