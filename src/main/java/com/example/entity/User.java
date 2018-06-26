package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-26 下午6:44
 */
@Setter
@Getter
@AllArgsConstructor
public class User implements Serializable{

//    private static final long serialVersionUID = -1L;

    private String name;
    private String password;
}
