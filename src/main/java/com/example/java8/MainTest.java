package com.example.java8;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-13 下午2:55
 */
public class MainTest {

    public static void main(String[] args){
        //实现该接口
        LambdaItemInterface lambdaItemInterface = (x,y) -> x+y;
        System.out.print(lambdaItemInterface.doMathOperator(1,2));
    }
}
