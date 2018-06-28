package com.example.demo;

import com.example.dao.mapper.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-27 下午4:13
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private  StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/set")
    public void set(String key , String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    @RequestMapping(value = "/get")
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping(value = "/users")
    public List<User> users(){
        return userMapper.selectUsers();
    }
}
