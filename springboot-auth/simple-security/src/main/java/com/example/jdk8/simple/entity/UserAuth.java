package com.example.jdk8.simple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Date;

/**
 * 用户账号
 *
 * @author zhaojh
 * @since 2024-08-18
 */
@Data
@Entity
@Table(name = "user_auth")
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth implements UserDetails {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 用户信息id
     */
    private Integer userInfoId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录类型
     */
    private Integer loginType;

    /**
     * 用户登录ip
     */
    private String ipAddr;

    /**
     * ip来源
     */
    private String ipSource;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    //权限角色集合
    @Transient
    private Collection<? extends GrantedAuthority> athorities;

    /**
     * 返回授予用户的权限
     * @return 用户权限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return athorities;
    }

    /**
     * 用户的帐户是否已过期。过期的帐户无法进行身份验证
     * @return  true： 如果用户的帐户有效（即未过期）
     *          false：如果不再有效（即过期）
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是否被锁定或解锁。锁定的用户无法进行身份验证。
     * @return  true if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户的凭据（密码）是否已过期。过期的凭据会阻止身份验证。
     * @return true：如果用户的凭据有效（即未过期）
     *         false：如果不再有效（即过期）
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 指示用户是启用还是禁用。无法对禁用的用户进行身份验证。
     * @return  true if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
