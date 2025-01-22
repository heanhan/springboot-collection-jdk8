package com.example.jdk8.tenant.mybatis.system.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: zhaojh
 * @ClassName: AddDataSourceReqVo
 * @CreateDate: 2025-01-22
 * @Description: 添加租户数据源信息请求VO
 */
@Data
public class AddDataSourceReqVo {

    @NotNull(message = "租户id不能为空")
    private Integer tenantId;

    @NotBlank(message = "数据库url不能为空")
    private String url;

    @NotBlank(message = "数据库username不能为空")
    private String username;

    @NotBlank(message = "数据库password不能为空")
    private String password;
}
