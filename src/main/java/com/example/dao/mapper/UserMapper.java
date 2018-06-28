package com.example.dao.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lxy on 18-6-27.
 */
public interface UserMapper {

    @Select("select * from users")
    public List<User> selectUsers();
}
