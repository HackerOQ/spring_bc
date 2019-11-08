package com.muisaho.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/8$ 11:08$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/8$ 11:08$
 * @UpdateRemark: 修改内容
 */
@Service
public class SysService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "sysFallBack")
    public String testRibbon(){
        return restTemplate.getForEntity("http://sys-service/user", String.class).getBody();
    }
    public String sysFallBack(){
        return "error";
    }
}
