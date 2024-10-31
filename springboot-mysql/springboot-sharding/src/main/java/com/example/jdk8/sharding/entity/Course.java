package com.example.jdk8.sharding.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description 课程表实体  对应数据库 course
 * @version 1.0
 * @author zhaojh
 * @date 2024/10/30 下午3:55
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course implements Serializable {

    //课程id
    private Long cid;

    //课程名称
    private String cname;

    //用户id
    private Long userId;

    //课程状态
    private String cstatus;
}
