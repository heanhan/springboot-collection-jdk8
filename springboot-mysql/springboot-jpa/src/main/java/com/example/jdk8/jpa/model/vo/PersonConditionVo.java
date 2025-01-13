package com.example.jdk8.jpa.model.vo;


import lombok.Data;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:17
 */

@Data
public class PersonConditionVo {

    private long id;

    private String userName;

    //性别
    private Boolean sex;

    private String startTime;//开始时间

    private String endTime;// 结束时间



}
