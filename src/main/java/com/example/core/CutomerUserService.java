package com.example.core;

import com.example.dao.mapper.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-25 下午7:45
 */
public class CutomerUserService implements UserDetailsService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if(user.isEnabled()==false){
            throw new LockedException("用户帐号已被冻结");
        }
        return user;
    }
}
