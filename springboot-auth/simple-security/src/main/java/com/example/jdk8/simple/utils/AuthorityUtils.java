package com.example.jdk8.simple.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhaojh
 * @description: 封装权限的工具类
 * @date 2024-09-27
 */
public abstract class AuthorityUtils {
    public static final List<GrantedAuthority> NO_AUTHORITIES = Collections.emptyList();

    /**
     * Creates a array of GrantedAuthority objects from a comma-separated string
     * representation (e.g. "ROLE_A, ROLE_B, ROLE_C").
     *
     * @param authorityString the comma-separated string
     * @return the authorities created by tokenizing the string
     */
    public static List<GrantedAuthority> commaSeparatedStringToAuthorityList(
            String authorityString) {
        return createAuthorityList(StringUtils
                .tokenizeToStringArray(authorityString, ","));
    }

    /**
     * Converts an array of GrantedAuthority objects to a Set.
     * @return a Set of the Strings obtained from each call to
     * GrantedAuthority.getAuthority()
     */
    public static Set<String> authorityListToSet(
            Collection<? extends GrantedAuthority> userAuthorities) {
        Set<String> set = new HashSet<String>(userAuthorities.size());

        for (GrantedAuthority authority : userAuthorities) {
            set.add(authority.getAuthority());
        }

        return set;
    }

    public static List<GrantedAuthority> createAuthorityList(String... roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(roles.length);

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}
