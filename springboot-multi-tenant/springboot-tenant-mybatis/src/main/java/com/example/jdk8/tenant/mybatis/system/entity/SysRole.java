package com.example.jdk8.tenant.mybatis.system.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 角色表
 */
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    /**
    * 角色id
    */
    private Integer id;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 角色描述
    */
    private String description;

    /**
    * 菜单权限
    */
    private String menuRights;

    /**
    * 节点权限
    */
    private String nodeRights;

    /**
    * 父id
    */
    private Integer parentId;

    /**
    * 角色类型
    */
    private Byte type;

    /**
    * 创建时间
    */
    private Date createTime;

    private Date updateTime;

    /**
    * 状态
    */
    private Boolean isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuRights() {
        return menuRights;
    }

    public void setMenuRights(String menuRights) {
        this.menuRights = menuRights;
    }

    public String getNodeRights() {
        return nodeRights;
    }

    public void setNodeRights(String nodeRights) {
        this.nodeRights = nodeRights;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}