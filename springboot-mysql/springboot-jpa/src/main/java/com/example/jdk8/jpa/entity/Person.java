package com.example.jdk8.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:07
 */

@Data
@Table(name = "t_person")
@Entity
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    /**
     *
     * @Id 表名该字段为主键
     * @Column: 映射数据库表中字段名
     * @GeneratedValue  主键增长策略（strategy）：生成策略有如下集中方式
     *                      1、GenerationType.IDENTITY  ：支持mysql 的主键自增
     *                      2、GenerationType.SEQUENCE  ：序列方式，根据底层数据库的序列来生成主键，条件是数据库支持序列 ,使用 Oracle
     *                      3、GenerationType.TABLE  ：使用一个特定的数据库表格来保存主键。
     *                      4、GenerationType.AUTO  ：主键由程序控制,自动根据数据类型选择主键该数据支持的生成模式
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "height")
    private Double height;

    @Column(name = "hover")
    private String hover;

    @Column(name = "self_info")
    private String selfInfo;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "last_modifier_id")
    private Long lastModifierId;

    @Column(name = "last_modified_time")
    private Date lastModifiedTime;

    @Column(name = "is_deleted")
    private int isDeleted;

}
