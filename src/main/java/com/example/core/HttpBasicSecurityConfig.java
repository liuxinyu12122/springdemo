package com.example.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-13 上午11:43
 */
@Configuration
@EnableWebSecurity
public class HttpBasicSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/","/hello").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")//为空会报错
                .permitAll();
    }

    @Bean
    public UserDetailsService cutomerUserService() {
        //内存用户
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("lxy")
//                        .password("123")
//                        .roles("USER","ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
        //数据库用户
        return new CutomerUserService();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new CustomerPasswordEncoder();
    }

    @Autowired
    public  void configureGloabal(AuthenticationManagerBuilder auth) throws Exception{
        //JDBC方式
//        auth.jdbcAuthentication().dataSource(dataSource);
        //自定义方式
        auth.userDetailsService(cutomerUserService()).passwordEncoder(passwordEncoder());
//                .withUser("cjm").password("123").roles("USER","ADMIN");
    }


    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
