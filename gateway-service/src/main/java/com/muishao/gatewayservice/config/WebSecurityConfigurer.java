package com.muishao.gatewayservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/5$ 11:11$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/5$ 11:11$
 * @UpdateRemark: 修改内容
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
   }
}
