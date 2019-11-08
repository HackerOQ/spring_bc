package com.muishao.sysservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/5$ 15:16$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/5$ 15:16$
 * @UpdateRemark: 修改内容
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private DiscoveryClient client;
    private Integer count=0;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        count++;
        System.out.println("=============="+count);
        int sleepTime = new Random().nextInt(10000);
        Thread.sleep(sleepTime);
        ServiceInstance instances = client.getInstances("sys-service").get(0);
        String host = instances.getHost();
        int port = instances.getPort();
        String serviceId = instances.getServiceId();
        String s = "sleepTime:" + sleepTime + ","+"count:"+count+","+ host + ":" + port + "==========" + serviceId;
        System.out.println(s);
        return s;
    }
}
