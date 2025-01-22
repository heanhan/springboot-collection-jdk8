package com.example.jdk8.tenant.mybatis.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: zhaojh
 * @Package: com.zhaojh.demo.dynamic
 * @ClassName: TenantDataInfo
 * @CreateDate: 2021/5/27 17:48
 * @Description: 租户数据连接信息
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("sys_tenant_data")
public class TenantData implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tenantId;

    private String url;

    private String username;

    private String password;

    /**
     * 状态
     */
    private Boolean isDel;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
