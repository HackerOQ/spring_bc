package com.muisaho.ribbonconsumer.controller;

import com.muisaho.ribbonconsumer.service.SysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/7$ 9:24$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/7$ 9:24$
 * @UpdateRemark: 修改内容
 */
@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private SysService sysService;

    @RequestMapping(value = "/ribbon/consumer")
    public String testRibbon() {
        long start = System.currentTimeMillis();
        String s = sysService.testRibbon();
        long end = System.currentTimeMillis();
        log.info("spend time "+(end-start));
        return s;
    }
}
