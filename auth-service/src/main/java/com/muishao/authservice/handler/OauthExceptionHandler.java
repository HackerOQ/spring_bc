/*
package com.muishao.authservice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muishao.common.base.ResultData;
import com.muishao.common.base.RetCode;
import com.muishao.common.dto.UserDTO;
import com.muishao.common.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

*/
/**
 * @Project Sunyard_HBBank
 * @Date 2018/9/30 4:06
 * @Created by Efy
 * @Description TODO
 *//*

@Slf4j
public class OauthExceptionHandler implements AccessDeniedHandler, WebResponseExceptionTranslator {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisUtil redisUtil;


    //最大错误次数
    @Value("${security.oauth2.resource.max-login-error-times}")
    private int maxLoginErrorTimes;
    //锁定时长(单位:分钟)
    @Value("${security.oauth2.resource.lock-time}")
    private int lockTime;


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        String result = objectMapper.writeValueAsString(ResultData.failed(RetCode.ACCESS_DENIED));
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(result);
    }

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) {
        UserDTO user = AuthenticationContext.getUser();
        OAuth2Exception exception = null;
        String errorMessage = translate(e.getMessage());
        if(errorMessage != null && errorMessage.startsWith("用户名或密码错误")){
            user.setTotalCount(user.getTotalCount() + 1);
            String timesKey = RedisKeyEnum.LOGIN_FAILED_TIMES.build(user.getAccount());
            redisUtil.set(timesKey,String.valueOf(user.getTotalCount()), TimeUnit.MINUTES.toSeconds((long)lockTime));

            errorMessage = String.format(errorMessage,user.getTotalCount(),maxLoginErrorTimes,lockTime);
        }
        exception = OAuth2Exception.create(OAuth2Exception.INVALID_GRANT,errorMessage);
        ResponseEntity<OAuth2Exception> entity = new ResponseEntity<>(exception, HttpStatus.valueOf(exception.getHttpErrorCode()));
        return entity;
    }

    private String translate(String message){
        if(message == null) {
            return message;
        }
        if(message.matches("坏的凭证|Bad credentials")){
            return "用户名或密码错误(次数%d/%d,超过最大次数将会锁定%d分钟)";
        }else if(message.matches("User account is locked")){
            return "用户账号已被锁定";
        }else if(message.matches("User account has expired")){
            return "用户账号已过期";
        }
        return message;
    }

}
*/
