package com.example.dao.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lxy on 18-6-27.
 */
public interface UserMapper {

//    @Cacheable(key = "users2")
    @Select("select * from users2")
    public List<User> selectUsers();


//    @Cacheable(key = "users2") TODO 用户自动缓存
    @Select("select * from users2 where name=#{name}")
    public User selectUserByName(@Param("name") String name);
}
