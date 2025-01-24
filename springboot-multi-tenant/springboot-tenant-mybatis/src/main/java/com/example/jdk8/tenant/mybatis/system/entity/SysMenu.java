package com.example.jdk8.tenant.mybatis.system.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 菜单表
 */
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {
    /**
    * 菜单id
    */
    private Integer id;

    /**
    * 菜单名称
    */
    private String name;

    /**
    * 菜单标题
    */
    private String title;

    /**
    * 菜单地址
    */
    private String menuUrl;

    /**
    * 父id
    */
    private Integer parentId;

    /**
    * 菜单排序
    */
    private Integer listOrder;

    /**
    * 菜单图标
    */
    private String icon;

    private Boolean isShow;

    /**
    * 菜单类型 1：pc  2：小程序
    */
    private Boolean type;

    /**
    * 菜单状态
    */
    private Boolean isDel;

    /**
    * 创建时间
    */
    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
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
}