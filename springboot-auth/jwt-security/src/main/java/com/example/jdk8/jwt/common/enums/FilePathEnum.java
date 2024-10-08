package com.example.jdk8.jwt.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: zhaojh
 * @date: 2024-08-18
 **/
@Getter
@AllArgsConstructor
public enum FilePathEnum {
    /**
     * 头像路径
     */
    AVATAR("avatar/", "头像路径"),
    /**
     * 文章图片路径
     */
    ARTICLE("articles/", "文章图片路径"),
    /**
     * 音频路径
     */
    VOICE("voice/", "音频路径");

    /**
     * 路径
     */
    private final String path;

    /**
     * 描述
     */
    private final String desc;

}
