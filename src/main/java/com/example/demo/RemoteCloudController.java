package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-7-5 下午4:30
 */
@org.springframework.web.bind.annotation.RestController
public class RemoteCloudController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DiscoveryClient discoveryClient;

    public int add(int a, int b){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("/add,host:" + serviceInstance.getHost() + ",serviceId:" + serviceInstance.getServiceId() );
        return a+b;
    }

}
