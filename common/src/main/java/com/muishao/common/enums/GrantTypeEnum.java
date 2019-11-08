package com.muishao.common.enums;

/**
 * @Author: liudong
 * @Description: 获取token方式
 * @Date: 2018年5月5日
 */
public enum GrantTypeEnum {

    PASSWORD("password", "账号密码方式授权"),
    CLIENT("client_credentials", "客户端方式授权"),
    CODE("authorization_code", "认证码方式授权"),
    IMPLICIT("implicit", "简化方式授权"),
    REFRESH_TOKEN("refresh_token", "更新token");

    public String code;
    public String msg;

    GrantTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}