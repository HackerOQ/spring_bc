package com.muishao.common.enums;

import lombok.AllArgsConstructor;

/**
 * 数据状态枚举
 *
 * @author liudong
 * @date 2018年4月23日
 */
@AllArgsConstructor
public enum StatusEnum {
    /**
     * 二值状态
     */
    NO(0,"否"),
    YES(1,"是"),

    /**
     * 数据状态
     */
    DELETE(0, "删除"),
    NORMAL(1, "正常"),


    ;

    public static StatusEnum getByCode(int code,String prefix){
        for(StatusEnum temp : values()){
            if(!temp.name().startsWith(prefix.toUpperCase())
                    || temp.code != code) {
                continue;
            }
            return temp;
        }
        return null;
    }

    public int code;
    public String msg;
}
