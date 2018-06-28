package com.example.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-27 下午6:26
 */
@Configuration
@Deprecated
public class SqlSessionFactoryConfig extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
