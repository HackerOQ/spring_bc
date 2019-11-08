package com.muishao.authservice.config;

import com.muishao.common.enums.GrantTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import javax.validation.Valid;

/**
 * @Description: java类作用描述
 * @Author: oq
 * @CreateDate: 2019/11/5$ 12:08$
 * @UpdateUser: yc
 * @UpdateDate: 2019/11/5$ 12:08$
 * @UpdateRemark: 修改内容
 */
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
//                .accessDeniedHandler()
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId)
                .secret(clientSecret)
                .scopes("server")
                .authorizedGrantTypes(GrantTypeEnum.PASSWORD.code,
                        GrantTypeEnum.CLIENT.code,
                        GrantTypeEnum.IMPLICIT.code,
                        GrantTypeEnum.REFRESH_TOKEN.code,
                        GrantTypeEnum.CODE.code
                        );        //配置一个客户端,用来给oauth2的4种认证方式授权,也可配置多个,分别给不同方式授权

    }
    //定义授权和令牌端点和令牌服务
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
        endpoints.authenticationManager(authenticationManager);
//                .userDetailsService()
//                .tokenServices()
    }
}
