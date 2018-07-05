package com.example.service;

import com.sun.istack.internal.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-26 下午6:48
 */
public class RedisObjectSerializer implements RedisSerializer {

    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();


    @Override
    public byte[] serialize(@Nullable Object o) throws SerializationException {
        return serializer.convert(o);
    }

    @Override
    public Object deserialize(@Nullable byte[] bytes) throws SerializationException {
        return deserializer.convert(bytes);
    }
}
