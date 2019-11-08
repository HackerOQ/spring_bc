package com.muishao.common.base;

import lombok.Data;

/**
 * 功能描述:
 * 模块:
 * 作者:江玉亮
 * 邮箱:yul.jiang@sunyard.com
 * 创建时间:2018/10/25 17:00
 * ************************************
 * ************************************
 * 修改人:
 * 修改时间:
 * 修改内容:
 * 1.
 * 2.
 */
@Data
public class BaseModel {
    private String code;//响应代码	 	0为成功，其他为失败。公共参数
    private String msg;//描述信息	 	公共参数

}
