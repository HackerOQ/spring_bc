package com.muishao.common.base;

/**
 * @author zqiang qiangzaiqqq@163.com
 * @description
 * @date created at 11:44 2019/8/9
 */
public enum RuleCode {
    OK("0", "操作成功"),

    RULE00_ERRORCENTER("00_errorCenter", "调用规则00报错"),
    RULE00_REFUSE("00_refuse", "规则00未命中"),

    RULE01_ERRORCENTER("01_errorCenter", "调用规则01报错"),
    RULE01_MORE_DEATIL("01_moreDetail", "未查询到多借据运用合同详情信息"),
    RULE01_MORE_NOINTER("01_more_nointer", "合作模式未查询到起息日"),
    RULE01_EXTERMAL_APPROVAL_FAILED("01_extermalApprovalFailed", "审批类型为非内部审批"),
    //RULE01_INFOMATION_FAILED("01_informationFailed", "运用合同、财报信息、产品信息、或项目信息配置不全"),
    RULE01_CONTRACT_DETAIL_NULL("01_contractDetailNull", "配置数据不全:运用合同明细"),
    RULE01_PROD_RULE_NULL("01_prodRuleNull", "配置数据不全:产品规则"),
    RULE01_FINANCE_NULL("01_financeNull", "配置数据不全:财报信息"),
    RULE01_PROJECT_SCALE_NULL("01_projectScaleNull", "配置数据不全:自动审批比例"),
    RULE01_AUTO_SCALE_NULL("01_autoScaleNull", "配置数据不全:总笔数、自动审批笔数"),


    RULE01_TUNE_FAILED("01_tuneFailed", "尽调资料不全"),
    RULE01_FINANCE_DEBTRATIO_FAILED("01_financeDebtRatioFailed", "资产总计为0或者资产负债率不在有效范围内"),
    RULE01_ASSET_FAILED("01_assetFailed", "资产规模不在设置范围内"),
    RULE01_INCOME_FAILED("01_incomeFailed", "收入指标不在设置范围内"),
    RULE01_PROFIT_FAILED("01_profitFailed", "利润指标不在设置范围内"),
    RULE01_REGION_FAILED("01_regionFailed", "注册地检查未通过"),
    RULE01_REMAIN_FAILED("01_remainFailed", "产品剩余额度检查未通过"),
    RULE01_SINGLE_AMOUNT_FAILED("01_singleAmountFailed", "产品单笔金额限制检查未通过"),
    RULE01_INTEREST_FAILED("01_interestFailed", "产品利率区间限制检查未通过"),
    RULE01_CONTRACT_LIMIT_FAILED("01_contractLimitFailed", "借据期限检查未通过"),
    RULE01_RECIEVABLE_FAILED("01_recievableFailed", "应收账款余额检查未通过"),
    RULE01_TIME_FAILED("01_timeFailed", "多借据模式：到期日不符拒绝"),
    RULE01_AMOUNT_CHECK_FAILED("01_amountCheckFailed", "多借据模式：金额不符拒绝"),
    RULE01_MORE_STATE_FAILED("01_moreStateFailed", "多借据模式：合同状态不符拒绝"),

    RULE02_ERRORCENTER("02_errorCenter", "调用规则02报错"),
    RULE02_REFUSE("02_refuse", "规则02未命中"),
    RULE02_AUTO_FAILED("02_autoFailed", "自动挂接失败"),

    RULE03_ERRORCENTER("03_errorCenter", "调用规则03报错"),
    RULE03_REFUSE("03_refuse", "规则03未命中"),

    RULE04_ERRORCENTER("04_errorCenter", "调用规则04报错"),
    RULE04_REFUSE("04_refuse", "规则04未命中"),
    RULE04_REGIS_TYPE_FAILED("04_regisTypeFailed", "产品类型为其他，项目配置为登记，冲突，请修改项目信息！"),
    RULE04_REVIEW_FAILED("04_reviewfailed", "审核失败"),
    //RULE04_REGIS_FAILED("04_regisfailed", "登记失败"),

    RULE05_ERRORCENTER("05_errorCenter", "调用规则05报错"),
    RULE05_REFUSE("05_refuse", "规则05拒件"),
    RULE05_REGIS_TYPE_FAILED("05_regisTypeFailed", "产品类型为其他，项目配置为登记，冲突，请修改项目信息！"),

    ;

    public String code;
    public String msg;

    RuleCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
