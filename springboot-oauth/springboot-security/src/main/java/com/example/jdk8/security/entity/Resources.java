package com.example.jdk8.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 权限表
 * @author: zhaojh
 * @date: 2024-09-24
 **/

@Entity
@Table(name ="resources")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resources {
    /**
     * 权限id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 权限名
     */
    private String resourceName;

    /**
     * 权限路径
     */
    private String url;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 父权限id
     */
    private Integer parentId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否禁用
     */
    private Integer isDisable;

    /**
     * 是否匿名访问
     */
    private Integer isAnonymous;

}
