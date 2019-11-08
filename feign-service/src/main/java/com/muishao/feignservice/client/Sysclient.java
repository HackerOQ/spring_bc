package com.muishao.feignservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/8$ 15:09$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/8$ 15:09$
 * @UpdateRemark: 修改内容
 */
@FeignClient("sys-service")
public interface Sysclient {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
     public String index();
}
