package com.muishao.common.dto;

import com.muishao.common.enums.StatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    /**登录用户名*/
	@ApiModelProperty("登录用户名")
    private String account;
    /**登录用户密码*/
	@ApiModelProperty("登录用户密码")
    private String password;
    /**用户类型 1-管理员 2-普通用户 3-客户经理*/
	@ApiModelProperty("用户类型 1-管理员 2-普通用户 3-客户经理")
    private Integer userType;
    /**用户状态 1-启用 0-禁用*/
	@ApiModelProperty("用户状态 1-启用 0-禁用")
    private Integer enable;
    /**用户有效期*/
	@ApiModelProperty("用户有效期")
    private Date continueTime;
    /**用户错误登录次数*/
	@ApiModelProperty("用户错误登录次数")
	private Integer totalCount;
    /**是否锁定 1-锁定 0-未锁*/
    @ApiModelProperty("是否锁定 1-锁定 0-未锁")
    private Boolean locked = false;
    /**账号是否过期 */
	@ApiModelProperty("账号是否过期")
    private Boolean accountExpired = false;
    /**凭证是否过期*/
	@ApiModelProperty("凭证是否过期")
    private Boolean credentialsExpired = false;



    public Boolean getEnable() {
        return StatusEnum.YES.code == enable;
    }

    public Boolean getAccountExpired() {
        //如果有效期已过,则设置账号为过期
        return continueTime.before(new Date());
    }
}
