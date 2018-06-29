package com.example.dao.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by lxy on 18-6-27.
 */
public interface UserMapper {

    @Cacheable(key = "users2")
    @Select("select * from users2")
    public List<User> selectUsers();
}
