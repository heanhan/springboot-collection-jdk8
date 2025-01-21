package com.example.jdk8.jpa.model.vo;


import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zhaojh
 * @version 1.0
 * @description 单个Person 接收参数VO
 * @date 2025/1/15 下午2:16
 */

@Data
public class PersonAddVo {

    private Long id;

    @ExcelProperty(value = "姓名",index = 1)
    private String userName;

    @ExcelProperty(value = "性别", index = 2)
    private Boolean sex;

    @ExcelProperty(value = "身高",index = 3)
    private Double height;

    @ExcelProperty(value = "爱好",index = 4)
    private String hover;

    @ExcelProperty(value = "个人介绍",index = 5)
    private String selfInfo;

}
