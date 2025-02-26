package com.example.jdk8.redis.single.model.vo;


import lombok.Data;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/2/26 下午2:10
 */

@Data
public class UserAddVo {

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String userName;

    //性别
    private Boolean sex;

    //身高
    private Long height;

    //爱好 爱好之间使用 逗号（,）隔开
    private String hobby;
}
