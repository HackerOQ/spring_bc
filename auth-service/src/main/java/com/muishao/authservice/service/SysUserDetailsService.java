package com.muishao.authservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/5$ 16:56$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/5$ 16:56$
 * @UpdateRemark: 修改内容
 */
public class SysUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
