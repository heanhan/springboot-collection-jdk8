package com.example.jdk8.jpa.model.vo;


import lombok.Data;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:17
 */

@Data
public class PersonPageVo {

    private String userName;

    private String startTime;//开始时间

    private String endTime;// 结束时间

    private Integer size;//分页大小

    private Integer index;// 当前页


}
