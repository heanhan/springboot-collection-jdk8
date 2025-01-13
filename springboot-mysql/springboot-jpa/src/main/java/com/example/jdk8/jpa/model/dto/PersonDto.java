package com.example.jdk8.jpa.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;

    private String userName;

    private Boolean sex;

    private Double height;

    private String hover;

    private String selfInfo;

    private Long creatorId;

    private Date createdTime;

    private Long lastModifierId;

    private Date lastModifiedTime;

    private Boolean isDeleted;
}
