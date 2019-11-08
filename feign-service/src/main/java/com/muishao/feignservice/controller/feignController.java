package com.muishao.feignservice.controller;

import com.muishao.feignservice.client.Sysclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/8$ 15:11$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/8$ 15:11$
 * @UpdateRemark: 修改内容
 */
@RestController
public class feignController {
    @Autowired
    private Sysclient sysclient;
    @RequestMapping("/feign")
    public String feignTest(){
       return "feign test!"+ sysclient.index();
    }
}
