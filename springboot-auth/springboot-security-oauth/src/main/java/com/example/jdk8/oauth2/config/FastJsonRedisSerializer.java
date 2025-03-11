package com.example.jdk8.oauth2.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.ObjectUtils;

import java.nio.charset.Charset;

/**
 * @Description : 自定义一个基于FastJson的序列化工具
 * @Author : zhaojh
 * @Date : 2025/2/11 16:10
 */

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    //设置字符集的编码格式
    private final static Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    //创建一个字节码的对象
    private Class<T> clazz;

    /*
    * 构造函数
    */
    public FastJsonRedisSerializer(Class<T> clazz){
        super();
        this.clazz=clazz;

    }
    /**
     * 序列化
     *
     * @param t object to serialize
     * @return the equivalent binary data.
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        //如果对象为空
        if(ObjectUtils.isEmpty(t)){
            return new byte[0];
        }
        //不为空的处理 实现序列化的过程
        byte[] bytes = JSON.toJSONString(t, SerializerFeature.WriteClassName,
                // 是否输出值为null的字段,默认为false
                SerializerFeature.WriteMapNullValue,
                // List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty)
                .getBytes(DEFAULT_CHARSET);
        return bytes;
    }

    /**
     * 反序列化数据
     * @param bytes
     * @return T
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return (T) JSON.parseObject(str, clazz);
    }
}
