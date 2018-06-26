package com.example.core;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-26 下午12:46
 */
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandeler(HttpServletRequest req, Exception e) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
