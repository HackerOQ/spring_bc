package com.muishao.common.base;

/**
 * 返回状态码
 */
public enum RetCode {
    OK(0, "操作成功"),

    OK_SELECT(1, "命中成功"),

    FAILED(-1, "操作失败"),

    FAILED_NULL(-1000, "没有可挂接资金！"),

    EXCEPTION(-2, "服务器异常，请联系系统管理员"),

    ACCESS_DENIED(-3, "当前用户无此权限"),

    TOKEN_OVERTIME(-4, "登录凭证已失效,请重新登录"),

    JSON_EXCEPTION(901, "JSON格式异常"),

    DATA_EXIST(1000, "数据已存在"),

    UNAUTHORIZED(1001, "用户名或密码错误"),

    DATA_NOT_EXIST(1002, "数据不存在"),

    DATA_INVALID(1003, "参数不合法"),

    ACCOUNTSTATUS_DISABLE(1004, "账号已被禁用"),

    CODE_EXIST(1000, "客户名称或统一信用代码已存在"),

    DATA_STATUS_CHANGED(1005, "数据状态已变更，请刷新页面"),

    FILE_TYPE_INVALID(1007, "文件格式不正确"),

    FILE_SIZE_INVALID(1008, "文件大小不正确"),

    COMPANY_ISUSE(1009, "客户已被项目使用，不能删除"),

    ASSETS_ISUSE(1009, "资产已被项目使用，不能删除"),

    CODE_ERROR(1010, "验证码错误"),

    BANK_ACCOUNT_EXIST(1011, "银行帐号已存在"),

    BUSINESS_PROJECT_STAGE_CHANGE(2001, "项目阶段已变更，请刷新页面"),

    FRAMENUMBER_EXIST(1012, "车架号已存在"),

    IS_BLACKLIST(1013, "客户为黑名单企业"),

    END_DAY_DOING(100021, "日终执行中，禁止交易"),
    END_DAY_PROCESSING(100022, "日终处理中"),

    HOOK_SERIAL_EXIST(10066, "已存在挂接关系，请换条数据进行操作"),

    TEMPBALANCE_IS_ZERO(10086, "该流水暂存金额为0，请换条数据进行操作"),

    HOOK_EXIST(10067, "该借据还款计划已挂接其他流水,不用进行挂接操作"),

    PAID_EXIST(10068, "该编号已经存在，不能重复插入"),

    MD5_EXCEPTION(1314, "获取文件MD5码值异常"),

    SAVE_EXCEPTION(1315, "待上传文件存入本地异常"),

    GUARANTEEWAYMAIN_EXISTS(10099, "该担保方式对应科目已存在，请选择其他担保方式"),

    CHANNELNO_EXIST(10069, "渠道号已经存在，不能重复插入"),

    UNUSEDATE(7777, "新启用时间必须大于当前系统时间"),

    REFER(8888, "提交只能针对状态为未复核的数据提交"),

    EARLYDATE(8262, "新生效日期必须大于当前系统日期"),

    NEWEND(1571, "新到期日期必须大于原到期日期"),

    FOURTIME(5852, "展期生效日期必须大于当前日期且小于原到期日期"),

    CHECK001(8889, "复核只能针对状态为复核中的数据复核"),

    TESTNOW(6827, "试算日期必须等于当前日期"),

    FAILED_DATA_VALIDATION(2999, "未通过数据校验"),

    TEMPLATE_ERROR(3999, "导入模版信息错误"),

    FAILED_SEE(1211, "发票识别失败"),

    FAILED_UPLOAD_IMAGE(1214, "上传文件至影像平台失败"),

    FAILED_INVOICE(1213, "发票验真失败"),

    ILLEGAL(8384, "当期限单位选择'天'的时候,还款方式只能选择'一次性利随本清',还款类型只能选择到期日还款,还款周期只能选择日"),

    USERID_FAILED(1215, "获取用户信息失败，请尝试重新登录。"),

    GSXML_FAILED(1216, "生成人行登记报文失败"),

    REGIS_FAILED(1217, "应收账款登记失败"),

    CANCEL_FAILED(1218, "应收账款注销登记失败"),

    DELETE_FAILED(1219, "删除失败，只能删除本人导入的数据！"),

    ;

    public int code;
    public String msg;

    RetCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
