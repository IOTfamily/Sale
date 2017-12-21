package com.iot.sale.Base.config;


import com.iot.sale.Base.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author:
 * @createDate: 16/6/21
 * @company: (C) Copyright 2016
 * @since: JDK 1.8
 * @Description:统一错误编码
 ******************************************/
public class ErrorCodeConfig {

    public static final String OK = "OK";

    public static final String ERR_SYSTEM = "ERR_SYSTEM";
    public static final String ERR_SYSTEM_JSON = "ERR_SYSTEM_JSON";
    public static final String ERR_SYSTEM_NULLPOINT = "ERR_SYSTEM_NULLPOINT";

    public static final String ERR_SYS_SID_INVALID = "ERR_SYS_SID_INVALID";
    public static final String ERR_SYS_AUTH_REJECT = "ERR_SYS_AUTH_REJECT";
    public static final String ERR_SYS_PARAM_MISSING = "ERR_SYS_PARAM_MISSING";
    public static final String ERR_SYS_EXPIRED_REQUEST = "ERR_SYS_EXPIRED_REQUEST";
    public static final String ERR_SYS_API_NOTFOUND = "ERR_SYS_API_NOTFOUND";
    public static final String ERR_SYS_SERVICE_EXCEPTION = "ERR_SYS_SERVICE_EXCEPTION";
    public static final String ERR_SYS_REPEAT_LOGIN = "ERR_SYS_REPEAT_LOGIN";
    public static final String ERR_SYS_TOKEN_ERROR = "ERR_SYS_TOKEN_ERROR";
    public static final String ERR_LOG_PARAM_MISSING = "ERR_LOG_PARAM_MISSING";
    public static final String ERR_LOG_NOT_PERMISSION = "ERR_LOG_NOT_PERMISSION";
    public static final String ERR_LOG_OPERATION_FAILURE = "ERR_LOG_OPERATION_FAILURE";
    public static final String ERR_LOG_PARAM_FORMAT_ERROR = "ERR_LOG_PARAM_FORMAT_ERROR";
    public static final String ERR_LOG_PARAM_INCOMPLETE = "ERR_LOG_PARAM_INCOMPLETE";
    public static final String ERR_LOG_MOBILE_FREQUENT_SEND = "ERR_LOG_MOBILE_FREQUENT_SEND";
    public static final String ERR_LOG_VERIFY_CODE_INVALID = "ERR_LOG_VERIFY_CODE_INVALID";
    public static final String ERR_LOG_VERIFY_CODE_FORMAT = "ERR_LOG_VERIFY_CODE_FORMAT";
    public static final String ERR_LOG_VERIFY_CODE_SEND_FALSE = "ERR_LOG_VERIFY_CODE_SEND_FALSE";
    public static final String ERR_LOG_UPLOAD_FAILURE = "ERR_LOG_UPLOAD_FAILURE";
    public static final String ERR_LOG_INVALID_PHONE_NUMBER = "ERR_LOG_INVALID_PHONE_NUMBER";
    public static final String ERR_LOG_PHONE_NUMBER_EXIST = "ERR_LOG_PHONE_NUMBER_EXIST";
    public static final String ERR_LOG_DEVICE_REG_IS_DENY = "ERR_LOG_DEVICE_REG_IS_DENY";
    public static final String ERR_LOG_REG_FAILURE = "ERR_LOG_REG_FAILURE";
    public static final String ERR_LOG_REG_PASSWD_IS_NULL = "ERR_LOG_REG_PASSWD_IS_NULL";
    public static final String ERR_LOG_REG_VALIDATE_FAILURE = "ERR_LOG_REG_VALIDATE_FAILURE";
    public static final String ERR_LOG_LOGIN_MOBILE_NOT_FIND = "ERR_LOG_LOGIN_MOBILE_NOT_FIND";
    public static final String ERR_LOG_LOGIN_PASSWORD_ERROR = "ERR_LOG_LOGIN_PASSWORD_ERROR";
    public static final String ERR_LOG_LOGIN_ERROR = "ERR_LOG_LOGIN_ERROR";
    public static final String ERR_LOG_LOGIN_LOCK_ERROR = "ERR_LOG_LOGIN_LOCK_ERROR";
    public static final String ERR_LOG_LOGOUT_ERROR = "ERR_LOG_LOGOUT_ERROR";
    public static final String ERR_LOG_MOBILE_NOT_FOUND = "ERR_LOG_MOBILE_NOT_FOUND";
    public static final String ERR_MODIFY_PASSWD_ERROR = "ERR_MODIFY_PASSWD_ERROR";
    public static final String ERR_MODIFY_PASSWD_INVALID = "ERR_MODIFY_PASSWD_INVALID";
    public static final String ERR_LOG_LOAN_SUBMIT_FAILURE = "ERR_LOG_LOAN_SUBMIT_FAILURE";
    public static final String ERR_LOG_LOAN_NOT_FOUND = "ERR_LOG_LOAN_NOT_FOUND";
    public static final String ERR_LOG_LOAN_SUBMIT_REVIEW_FAILURE = "ERR_LOG_LOAN_SUBMIT_REVIEW_FAILURE";
    public static final String ERR_LOG_LOAN_NOT_PERMISSION = "ERR_LOG_LOAN_NOT_PERMISSION";
    public static final String ERR_LOG_LOAN_NOT_COMPLETE_PROFILE = "ERR_LOG_LOAN_NOT_COMPLETE_PROFILE";
    public static final String ERR_LOG_LOAN_REPEAT_SUBMIT_REVIEW = "ERR_LOG_LOAN_REPEAT_SUBMIT_REVIEW";
    public static final String ERR_LOG_LOAN_REVOKE_FORBIDDEN = "ERR_LOG_LOAN_REVOKE_FORBIDDEN";
    public static final String ERR_LOG_LOAN_NOT_MATCH_CONDITION = "ERR_LOG_LOAN_NOT_MATCH_CONDITION";
    public static final String ERR_LOG_LOAN_EXIST_LOAN = "ERR_LOG_LOAN_EXIST_LOAN";
    public static final String ERR_LOG_LOAN_EXIST_VOUCH = "ERR_LOG_LOAN_EXIST_VOUCH";
    public static final String ERR_LOG_LOAN_GUARANTOR_NOT_ENOUGH = "ERR_LOG_LOAN_GUARANTOR_NOT_ENOUGH";
    public static final String ERR_LOG_INVITE_CODE_NOT_FOUND = "ERR_LOG_INVITE_CODE_NOT_FOUND";
    public static final String ERR_LOG_MY_LAON_LIST_ERROR = "ERR_LOG_MY_LAON_LIST_ERROR";
    public static final String ERR_LOG_REPAY_INFO_NOT_FOUND = "ERR_LOG_REPAY_INFO_NOT_FOUND";
    public static final String ERR_LOG_REPAY_FORBIDDEN = "ERR_LOG_REPAY_FORBIDDEN";
    public static final String ERR_LOG_REPAY_ACCOUNT_LOW = "ERR_LOG_REPAY_ACCOUNT_LOW";
    public static final String ERR_LOG_REPAY_FUNDS_INVALID = "ERR_LOG_REPAY_FUNDS_INVALID";
    public static final String ERR_LOG_REPAY_SYSTEM_MAINTAIN = "ERR_LOG_REPAY_SYSTEM_MAINTAIN";
    public static final String ERR_LOG_MY_GUARANT_LIST_ERROR = "ERR_LOG_MY_GUARANT_LIST_ERROR";
    public static final String ERR_LOG_GUARANT_INFO_NOT_FOUND = "ERR_LOG_GUARANT_INFO_NOT_FOUND";
    public static final String ERR_LOG_GUARANT_RECORD_EXIST = "ERR_LOG_GUARANT_RECORD_EXIST";
    public static final String ERR_LOG_GUARANT_GUARANTOR_IS_FULL = "ERR_LOG_GUARANT_GUARANTOR_IS_FULL";
    public static final String ERR_LOG_GUARANT_CREATE_FAILURE = "ERR_LOG_GUARANT_CREATE_FAILURE";
    public static final String ERR_LOG_GUARANT_GUARANTOR_IS_SELF = "ERR_LOG_GUARANT_GUARANTOR_IS_SELF";
    public static final String ERR_LOG_GUARANT_NO_MATCH_CONDITION = "ERR_LOG_GUARANT_NO_MATCH_CONDITION";
    public static final String ERR_LOG_GUARANT_LOAN_EXIST = "ERR_LOG_GUARANT_LOAN_EXIST";
    public static final String ERR_LOG_GUARANT_HAS_VOUCHING = "ERR_LOG_GUARANT_HAS_VOUCHING";
    public static final String ERR_LOG_GUARANT_DENY_DELETE_GUARANTOR = "ERR_LOG_GUARANT_DENY_DELETE_GUARANTOR";
    public static final String ERR_LOG_ACCOUNT_QUERY_ERROR = "ERR_LOG_ACCOUNT_QUERY_ERROR";
    public static final String ERR_LOG_ACCOUNT_HISTORY_ERROR = "ERR_LOG_ACCOUNT_HISTORY_ERROR";
    public static final String ERR_LOG_ACCOUNT_BANKCARD_ERROR = "ERR_LOG_ACCOUNT_BANKCARD_ERROR";
    public static final String ERR_LOG_ACCOUNT_BANKCARD_ADD_ERROR = "ERR_LOG_ACCOUNT_BANKCARD_ADD_ERROR";
    public static final String ERR_LOG_ACCOUNT_BANKCARD_NOT_FOUND = "ERR_LOG_ACCOUNT_BANKCARD_NOT_FOUND";
    public static final String ERR_LOG_ACCOUNT_INVALID_AMOUNT = "ERR_LOG_ACCOUNT_INVALID_AMOUNT";
    public static final String ERR_LOG_CREATE_RECHARGE_ORDER_FAILURE = "ERR_LOG_CREATE_RECHARGE_ORDER_FAILURE";
    public static final String ERR_LOG_ACCOUNT_RECHARGE_FAILURE = "ERR_LOG_ACCOUNT_RECHARGE_FAILURE";
    public static final String ERR_LOG_CREATE_CASH_ORDER_FAILURE = "ERR_LOG_CREATE_CASH_ORDER_FAILURE";
    public static final String ERR_LOG_ACCOUNT_CASH_FAILURE = "ERR_LOG_ACCOUNT_CASH_FAILURE";
    public static final String ERR_LOG_ACCOUNT_RECHARGE_RESULT_UNKNOWN = "ERR_LOG_ACCOUNT_RECHARGE_RESULT_UNKNOWN";
    public static final String ERR_LOG_ACCOUNT_ORDER_NOT_FOUND = "ERR_LOG_ACCOUNT_ORDER_NOT_FOUND";
    public static final String ERR_LOG_ACCOUNT_BANK_BIND_NOT_SUPPORT = "ERR_LOG_ACCOUNT_BANK_BIND_NOT_SUPPORT";
    public static final String ERR_LOG_USER_NOT_FOUND = "ERR_LOG_USER_NOT_FOUND";
    public static final String ERR_LOG_USER_IDENTITY_NOT_FOUND = "ERR_LOG_USER_IDENTITY_NOT_FOUND";
    public static final String ERR_LOG_USER_EDU_NOT_FOUND = "ERR_LOG_USER_EDU_NOT_FOUND";
    public static final String ERR_LOG_USER_CONTACT_NOT_FOUND = "ERR_LOG_USER_CONTACT_NOT_FOUND";
    public static final String ERR_LOG_USER_PARAM_MISSING_NAME = "ERR_LOG_USER_PARAM_MISSING_NAME";
    public static final String ERR_LOG_USER_PARAM_ILLEGAL_NAME = "ERR_LOG_USER_PARAM_ILLEGAL_NAME";
    public static final String ERR_LOG_USER_PARAM_MISSING_IC_NUMBER = "ERR_LOG_USER_PARAM_MISSING_IC_NUMBER";
    public static final String ERR_LOG_USER_PARAM_INVALID_IC_NUMBER = "ERR_LOG_USER_PARAM_INVALID_IC_NUMBER";
    public static final String ERR_LOG_USER_PARAM_MISSING_BINDING_PHONE = "ERR_LOG_USER_PARAM_MISSING_BINDING_PHONE";
    public static final String ERR_LOG_USER_PARAM_INVALID_BINDIGN_PHONE = "ERR_LOG_USER_PARAM_INVALID_BINDIGN_PHONE";
    public static final String ERR_LOG_USER_PARAM_MISSING_BINDIGN_VCODE = "ERR_LOG_USER_PARAM_MISSING_BINDIGN_VCODE";
    public static final String ERR_LOG_USER_PARAM_MISSING_IMAGE = "ERR_LOG_USER_PARAM_MISSING_IMAGE";
    public static final String ERR_LOG_USER_SUBMIT_IDENTITY_ERROR = "ERR_LOG_USER_SUBMIT_IDENTITY_ERROR";
    public static final String ERR_LOG_USER_IC_NOT_MATCH = "ERR_LOG_USER_IC_NOT_MATCH";
    public static final String ERR_LOG_USER_IC_EXIST = "ERR_LOG_USER_IC_EXIST";
    public static final String ERR_LOG_USER_NOT_EXIST = "ERR_LOG_USER_NOT_EXIST";
    public static final String ERR_LOG_USER_PARAM_MISSING_SCHOOL = "ERR_LOG_USER_PARAM_MISSING_SCHOOL";
    public static final String ERR_LOG_USER_PARAM_MISSING_MAJOR = "ERR_LOG_USER_PARAM_MISSING_MAJOR";
    public static final String ERR_LOG_USER_PARAM_MISSING_EDUCATION = "ERR_LOG_USER_PARAM_MISSING_EDUCATION";
    public static final String ERR_LOG_USER_PARAM_MISSING_TIME = "ERR_LOG_USER_PARAM_MISSING_TIME";
    public static final String ERR_LOG_USER_SUBMIT_SCHOOL_ERROR = "ERR_LOG_USER_SUBMIT_SCHOOL_ERROR";
    public static final String ERR_LOG_USER_SUBMIT_CONTACT_ERROR = "ERR_LOG_USER_SUBMIT_CONTACT_ERROR";
    public static final String ERR_LOG_USER_CONTACT_SAME_TEL_ERROR = "ERR_LOG_USER_CONTACT_SAME_TEL_ERROR";
    public static final String ERR_LOG_QUERY_SCHOOL_ERROR = "ERR_LOG_QUERY_SCHOOL_ERROR";
    public static final String ERR_LOG_USER_INVALID_BANKCARD = "ERR_LOG_USER_INVALID_BANKCARD";
    public static final String ERR_LOG_USER_INVALID_CC_CARD = "ERR_LOG_USER_INVALID_CC_CARD";
    public static final String ERR_LOG_USER_BANK_INFO_NO_MATCH = "ERR_LOG_USER_BANK_INFO_NO_MATCH";
    public static final String ERR_LOG_USER_BASIC_INFO_EXIST = "ERR_LOG_USER_BASIC_INFO_EXIST";
    public static final String ERR_LOG_USER_DENY_MODIFY_JOBINFO = "ERR_LOG_USER_DENY_MODIFY_JOBINFO";
    public static final String ERR_LOG_USER_PROFILE_EXIST = "ERR_LOG_USER_PROFILE_EXIST";
    public static final String ERR_LOG_USER_CREATE_BIND_CARD_ORDER_FAILURE = "ERR_LOG_USER_CREATE_BIND_CARD_ORDER_FAILURE";
    public static final String ERR_LOG_USER_BIND_CARD_FAILURE = "ERR_LOG_USER_BIND_CARD_FAILURE";
    public static final String ERR_LOG_USER_BIND_CC_CARD_FAILURE = "ERR_LOG_USER_BIND_CC_CARD_FAILURE";
    public static final String ERR_LOG_USER_UPDATE_BIND_CARD_ORDER_FAILURE = "ERR_LOG_USER_UPDATE_BIND_CARD_ORDER_FAILURE";
    public static final String ERR_LOG_USER_REPEAT_BIND_CARD = "ERR_LOG_USER_REPEAT_BIND_CARD";
    public static final String ERR_LOG_USER_BIND_CARD_CONF_FAILURE = "ERR_LOG_USER_BIND_CARD_CONF_FAILURE";
    public static final String ERR_LOG_USER_COM_ENTRY_DATE_INVALID = "ERR_LOG_USER_COM_ENTRY_DATE_INVALID";
    public static final String ERR_LOG_USER_ENTRY_DATE_INVALID = "ERR_LOG_USER_ENTRY_DATE_INVALID";
    public static final String ERR_LOG_USER_SCHOOL_ENTRY_END_DATE_INVALID = "ERR_LOG_USER_SCHOOL_ENTRY_END_DATE_INVALID";
    public static final String ERR_LOG_USER_CONTACT_IS_SELF_PHONE = "ERR_LOG_USER_CONTACT_IS_SELF_PHONE";
    public static final String ERR_LOG_EMAIL_NOT_VALID = "ERR_LOG_EMAIL_NOT_VALID";
    public static final String ERR_LOG_TEL_NOT_VALID = "ERR_LOG_TEL_NOT_VALID";
    public static final String ERR_LOG_BANK_CARD_AUTH_FUND_IS_NULL = "ERR_LOG_BANK_CARD_AUTH_FUND_IS_NULL";
    public static final String ERR_LOG_BANK_CARD_REPEAT_AUTH = "ERR_LOG_BANK_CARD_REPEAT_AUTH";
    public static final String ERR_LOG_BANK_CARD_NOT_FOUND = "ERR_LOG_BANK_CARD_NOT_FOUND";
    public static final String ERR_LOG_BANK_CARD_AUTH_FAILURE = "ERR_LOG_BANK_CARD_AUTH_FAILURE";
    public static final String ERR_LOG_BANK_CARD_AUTH_WRONG = "ERR_LOG_BANK_CARD_AUTH_WRONG";
    public static final String ERR_QB_LOG_LOAN_SUBMIT_FAILURE = "ERR_QB_LOG_LOAN_SUBMIT_FAILURE";
    public static final String ERR_QB_LOG_LOAN_CREATE_ORDER_FAILURE = "ERR_QB_LOG_LOAN_CREATE_ORDER_FAILURE";
    public static final String ERR_QB_LOG_REPAY_TOO_FAST = "ERR_QB_LOG_REPAY_TOO_FAST";
    public static final String ERR_QB_LOG_REPAY_NEED_GOON = "ERR_QB_LOG_REPAY_NEED_GOON";
    public static final String ERR_QB_LOG_REPAY_RECHARGING = "ERR_QB_LOG_REPAY_RECHARGING";
    public static final String ERR_QB_LOG_REPAY_FUNDS_OVERFLOW = "ERR_QB_LOG_REPAY_FUNDS_OVERFLOW";
    public static final String ERR_QB_LOG_REPAY_CREATE_ORDER_FAILURE = "ERR_QB_LOG_REPAY_CREATE_ORDER_FAILURE";
    public static final String ERR_QB_LOG_REPAY_ORDER_INVALID = "ERR_QB_LOG_REPAY_ORDER_INVALID";
    public static final String ERR_QB_LOG_REPAY_PAY_FAILED = "ERR_QB_LOG_REPAY_PAY_FAILED";
    public static final String ERR_QB_LOG_CREDITCARD_INFO_EXIST = "ERR_QB_LOG_CREDITCARD_INFO_EXIST";
    public static final String ERR_QB_INFO_CHECKED_ERROR = "ERR_QB_INFO_CHECKED_ERROR";
    public static final String ERR_QB_BEYOND_MAX_QUARANTOR_COUNT = "ERR_QB_BEYOND_MAX_QUARANTOR_COUNT";
    public static final String ERR_QB_GUARANTEE_SELF_NOT_ALLOW = "ERR_QB_GUARANTEE_SELF_NOT_ALLOW";
    public static final String ERR_QB_GUARANTEE_CIRCLE = "ERR_QB_GUARANTEE_CIRCLE";
    public static final String ERR_QB_DULICATE_GUARANTEE = "ERR_QB_DULICATE_GUARANTEE";
    public static final String ERR_QB_BEYOND_MAX_QUARANTEE_PERIOD = "ERR_QB_BEYOND_MAX_QUARANTEE_PERIOD";
    public static final String ERR_QB_BEYOND_FUNDS_RANGE = "ERR_QB_BEYOND_FUNDS_RANGE";
    public static final String ERR_QB_SELF_HAS_QUARANTEE = "ERR_QB_SELF_HAS_QUARANTEE";
    public static final String ERR_QB_SELF_HAS_QUARANT = "ERR_QB_SELF_HAS_QUARANT";
    public static final String ERR_LCG_HAS_APPLICATIONED = "ERR_LCG_HAS_APPLICATIONED";
    public static final String ERR_LCG_BEYOND_MAX_APPLICATION_FUNDS = "ERR_LCG_BEYOND_MAX_APPLICATION_FUNDS";
    public static final String ERR_LOG_APPLY_ORDER_NOT_FOUND = "ERR_LOG_APPLY_ORDER_NOT_FOUND";
    public static final String ERR_MC_INFO_NO_EXIST = "ERR_MC_INFO_NO_EXIST";
    public static final String ERR_INVITE_CODE_NOT_MATCH = "ERR_INVITE_CODE_NOT_MATCH";
    public static final String ERR_INVITE_CODE_INVAILD = "ERR_INVITE_CODE_INVAILD";
    public static final String ERR_LOG_APPLY_REQ_NOT_FOUND = "ERR_LOG_APPLY_REQ_NOT_FOUND";
    public static final String ERR_LOG_APPLY_REQ_SAVE_ERROR = "ERR_LOG_APPLY_REQ_SAVE_ERROR";
    public static final String ERR_LOG_APPLY_MERCHANT_ERROR = "ERR_LOG_APPLY_MERCHANT_ERROR";
    public static final String ERR_LOG_PAY_PASSWORD_ERROR = "ERR_LOG_PAY_PASSWORD_ERROR";
    public static final String ERR_LOG_PAY_LOCK_ERROR = "ERR_LOG_PAY_LOCK_ERROR";
    public static final String ERR_LOG_RECHARGE_MONRY_MIN = "ERR_LOG_RECHARGE_MONRY_MIN";
    public static final String ERR_SYS_PERMISSION_DENIED = "ERR_SYS_PERMISSION_DENIED";
    public static final String ERR_WECHAT_INVALID_CREDENTAIL = "ERR_WECHAT_INVALID_CREDENTAIL";

    public static final String ERR_LOG_LOGIN_FORBID = "ERR_LOG_LOGIN_FORBID";
    public static final String ERR_LOG_CHANEL_INVAILD = "ERR_LOG_CHANEL_INVAILD";
    public static final String ERR_CHECK_PARAMS = "ERR_CHECK_PARAMS";

    public static final String ERR_JSON_FORMAT = "ERR_JSON_FORMAT";
    public static final String ERR_VERIFY_SIGNATURE_ERROR = "ERR_VERIFY_SIGNATURE_ERROR";



    public static Map<String, String> map = new HashMap<>();
    static {
        map.put(OK, "调用成功");

        map.put(ERR_SYSTEM, "系统异常");
        map.put(ERR_SYSTEM_JSON, "内部数据错误");
        map.put(ERR_SYSTEM_NULLPOINT, "数据未同步");

        map.put(ERR_SYS_SID_INVALID, "用户登录已失效,请重新登录.");
        map.put(ERR_SYS_AUTH_REJECT, "非法的请求");
        map.put(ERR_SYS_PARAM_MISSING, "缺少关键性参数");
        map.put(ERR_SYS_EXPIRED_REQUEST, "访问请求已过期");
        map.put(ERR_SYS_API_NOTFOUND, "请求的接口不存在");
        map.put(ERR_SYS_SERVICE_EXCEPTION, "系统异常,请稍后再试!");
        map.put(ERR_SYS_REPEAT_LOGIN, "请不要重复登录.");
        map.put(ERR_SYS_TOKEN_ERROR, "非法请求,请登录后重试");
        map.put(ERR_LOG_PARAM_MISSING, "缺少关键性参数");
        map.put(ERR_LOG_NOT_PERMISSION, "抱歉,你无权操作");
        map.put(ERR_LOG_OPERATION_FAILURE, "操作失败，请稍候再试");
        map.put(ERR_LOG_PARAM_FORMAT_ERROR, "参数格式错误");
        map.put(ERR_LOG_PARAM_INCOMPLETE, "数据填写不完整");
        map.put(ERR_LOG_MOBILE_FREQUENT_SEND, "您操作频率过快,请稍后再试.");
        map.put(ERR_LOG_VERIFY_CODE_INVALID, "验证码已失效");
        map.put(ERR_LOG_VERIFY_CODE_FORMAT, "验证码格式错误");
        map.put(ERR_LOG_VERIFY_CODE_SEND_FALSE, "验证码发送失败");
        map.put(ERR_LOG_UPLOAD_FAILURE, "文件上传失败");
        map.put(ERR_LOG_INVALID_PHONE_NUMBER, "不是有效的手机号码");
        map.put(ERR_LOG_PHONE_NUMBER_EXIST, "号码已被注册");
        map.put(ERR_LOG_DEVICE_REG_IS_DENY, "设备操作受限,请明天再试!");
        map.put(ERR_LOG_REG_FAILURE, "注册失败,请稍后再试.");
        map.put(ERR_LOG_REG_PASSWD_IS_NULL, "请设置你的登录密码.");
        map.put(ERR_LOG_REG_VALIDATE_FAILURE, "验证码错误或已失效.");
        map.put(ERR_LOG_LOGIN_MOBILE_NOT_FIND, "手机号不存在");
        map.put(ERR_LOG_LOGIN_PASSWORD_ERROR, "密码错误");
        map.put(ERR_LOG_LOGIN_ERROR, "登录失败，请稍后再试!");
        map.put(ERR_LOG_LOGIN_LOCK_ERROR, "登录失败次数过多,账号暂时被锁定,请明天再试!");
        map.put(ERR_LOG_LOGOUT_ERROR, "用户注销失败");
        map.put(ERR_LOG_MOBILE_NOT_FOUND, "手机号未注册");
        map.put(ERR_MODIFY_PASSWD_ERROR, "密码修改失败，请稍后再试");
        map.put(ERR_MODIFY_PASSWD_INVALID, "密码格式为,6-20位字母或数字");
        map.put(ERR_LOG_LOAN_SUBMIT_FAILURE, "借款信息提交失败");
        map.put(ERR_LOG_LOAN_NOT_FOUND, "借款信息不存在");
        map.put(ERR_LOG_LOAN_SUBMIT_REVIEW_FAILURE, "提交审核失败");
        map.put(ERR_LOG_LOAN_NOT_PERMISSION, "抱歉，你没有相关权限");
        map.put(ERR_LOG_LOAN_NOT_COMPLETE_PROFILE, "请先完善个人资料");
        map.put(ERR_LOG_LOAN_REPEAT_SUBMIT_REVIEW, "请不要重复提交审核");
        map.put(ERR_LOG_LOAN_REVOKE_FORBIDDEN, "不允许取消借款");
        map.put(ERR_LOG_LOAN_NOT_MATCH_CONDITION, "你不符合此项借款的条件");
        map.put(ERR_LOG_LOAN_EXIST_LOAN, "你当前已有一笔借款");
        map.put(ERR_LOG_LOAN_EXIST_VOUCH, "你当前正在为别人担保");
        map.put(ERR_LOG_LOAN_GUARANTOR_NOT_ENOUGH, "保人数量不足，无法提交审核");
        map.put(ERR_LOG_INVITE_CODE_NOT_FOUND, "保人邀请码不存在");
        map.put(ERR_LOG_MY_LAON_LIST_ERROR, "借款记录查询失败");
        map.put(ERR_LOG_REPAY_INFO_NOT_FOUND, "暂无还款信息");
        map.put(ERR_LOG_REPAY_FORBIDDEN, "尚未进入还款阶段");
        map.put(ERR_LOG_REPAY_ACCOUNT_LOW, "账户余额不足");
        map.put(ERR_LOG_REPAY_FUNDS_INVALID, "偿还金额异常，请刷新页面后重试");
        map.put(ERR_LOG_REPAY_SYSTEM_MAINTAIN, "夜间系统维护，暂时不能还款");
        map.put(ERR_LOG_MY_GUARANT_LIST_ERROR, "担保记录查询失败");
        map.put(ERR_LOG_GUARANT_INFO_NOT_FOUND, "担保记录不存在");
        map.put(ERR_LOG_GUARANT_RECORD_EXIST, "你已有一笔担保，不允许再次担保");
        map.put(ERR_LOG_GUARANT_GUARANTOR_IS_FULL, "你来晚了，担保人名额已满");
        map.put(ERR_LOG_GUARANT_CREATE_FAILURE, "担保失败，请稍候再试");
        map.put(ERR_LOG_GUARANT_GUARANTOR_IS_SELF, "抱歉，你不能为自己的借款担保");
        map.put(ERR_LOG_GUARANT_NO_MATCH_CONDITION, "抱歉，你不符合担保条件");
        map.put(ERR_LOG_GUARANT_LOAN_EXIST, "您有一笔借款，不允许同时担保");
        map.put(ERR_LOG_GUARANT_HAS_VOUCHING, "担保已生效，不能删除担保人");
        map.put(ERR_LOG_GUARANT_DENY_DELETE_GUARANTOR, "当前状态不允许删除保人");
        map.put(ERR_LOG_ACCOUNT_QUERY_ERROR, "账户余额查询失败");
        map.put(ERR_LOG_ACCOUNT_HISTORY_ERROR, "账户交易明细查询失败");
        map.put(ERR_LOG_ACCOUNT_BANKCARD_ERROR, "银行卡信息查询失败");
        map.put(ERR_LOG_ACCOUNT_BANKCARD_ADD_ERROR, "银行卡信息提交失败");
        map.put(ERR_LOG_ACCOUNT_BANKCARD_NOT_FOUND, "没有找到银行卡信息");
        map.put(ERR_LOG_ACCOUNT_INVALID_AMOUNT, "金额无效");
        map.put(ERR_LOG_CREATE_RECHARGE_ORDER_FAILURE, "创建充值订单失败");
        map.put(ERR_LOG_ACCOUNT_RECHARGE_FAILURE, "充值失败");
        map.put(ERR_LOG_CREATE_CASH_ORDER_FAILURE, "创建提现订单失败");
        map.put(ERR_LOG_ACCOUNT_CASH_FAILURE, "提现失败");
        map.put(ERR_LOG_ACCOUNT_RECHARGE_RESULT_UNKNOWN, "充值结果未知");
        map.put(ERR_LOG_ACCOUNT_ORDER_NOT_FOUND, "订单不存在");
        map.put(ERR_LOG_ACCOUNT_BANK_BIND_NOT_SUPPORT, "暂时不支持该银行绑卡");
        map.put(ERR_LOG_USER_NOT_FOUND, "查询用户资料失败");
        map.put(ERR_LOG_USER_IDENTITY_NOT_FOUND, "查询用户身份信息失败");
        map.put(ERR_LOG_USER_EDU_NOT_FOUND, "查询用户学校信息失败");
        map.put(ERR_LOG_USER_CONTACT_NOT_FOUND, "查询用户联系人信息失败");
        map.put(ERR_LOG_USER_PARAM_MISSING_NAME, "真实姓名不能为空");
        map.put(ERR_LOG_USER_PARAM_ILLEGAL_NAME, "真实姓名不许输入非法字符(2~20位字符, 仅支持中文)");
        map.put(ERR_LOG_USER_PARAM_MISSING_IC_NUMBER, "身份证号码不能为空");
        map.put(ERR_LOG_USER_PARAM_INVALID_IC_NUMBER, "身份证号码格式录入有误");
        map.put(ERR_LOG_USER_PARAM_MISSING_BINDING_PHONE, "银行卡绑定的手机号码不能为空");
        map.put(ERR_LOG_USER_PARAM_INVALID_BINDIGN_PHONE, "银行卡绑定的手机号码格式录入有误");
        map.put(ERR_LOG_USER_PARAM_MISSING_BINDIGN_VCODE, "验证码不能为空");
        map.put(ERR_LOG_USER_PARAM_MISSING_IMAGE, "请提供相关照片");
        map.put(ERR_LOG_USER_SUBMIT_IDENTITY_ERROR, "身份信息提交失败");
        map.put(ERR_LOG_USER_IC_NOT_MATCH, "姓名和身份证号不匹配");
        map.put(ERR_LOG_USER_IC_EXIST, "身份证号已经被注册");
        map.put(ERR_LOG_USER_NOT_EXIST, "抱歉，用户不存在");
        map.put(ERR_LOG_USER_PARAM_MISSING_SCHOOL, "请选择学校");
        map.put(ERR_LOG_USER_PARAM_MISSING_MAJOR, "专业不能为空");
        map.put(ERR_LOG_USER_PARAM_MISSING_EDUCATION, "请选择学历");
        map.put(ERR_LOG_USER_PARAM_MISSING_TIME, "请选择入学时间");
        map.put(ERR_LOG_USER_SUBMIT_SCHOOL_ERROR, "提交学校信息失败");
        map.put(ERR_LOG_USER_SUBMIT_CONTACT_ERROR, "提交联系人信息失败");
        map.put(ERR_LOG_USER_CONTACT_SAME_TEL_ERROR, "不允许输入相同的联系人电话");
        map.put(ERR_LOG_QUERY_SCHOOL_ERROR, "查询学校信息失败");
        map.put(ERR_LOG_USER_INVALID_BANKCARD, "不是有效的银行借记卡");
        map.put(ERR_LOG_USER_INVALID_CC_CARD, "不是有效的信用卡");
        map.put(ERR_LOG_USER_BANK_INFO_NO_MATCH, "银行卡与所填信息不匹配");
        map.put(ERR_LOG_USER_BASIC_INFO_EXIST, "用户基本信息已存在");
        map.put(ERR_LOG_USER_DENY_MODIFY_JOBINFO, "有借款或担保时不允许修改个人资料和职业信息");
        map.put(ERR_LOG_USER_PROFILE_EXIST, "用户信息已存在");
        map.put(ERR_LOG_USER_CREATE_BIND_CARD_ORDER_FAILURE, "基本信息提交失败");
        map.put(ERR_LOG_USER_BIND_CARD_FAILURE, "绑定银行卡失败");
        map.put(ERR_LOG_USER_BIND_CC_CARD_FAILURE, "绑定信用卡失败");
        map.put(ERR_LOG_USER_UPDATE_BIND_CARD_ORDER_FAILURE, "绑定银行卡失败");
        map.put(ERR_LOG_USER_REPEAT_BIND_CARD, "信息已经提交，不允许重复提交");
        map.put(ERR_LOG_USER_BIND_CARD_CONF_FAILURE, "绑定银行卡失败");
        map.put(ERR_LOG_USER_COM_ENTRY_DATE_INVALID, "入职时间填写错误");
        map.put(ERR_LOG_USER_ENTRY_DATE_INVALID, "入学时间填写错误");
        map.put(ERR_LOG_USER_SCHOOL_ENTRY_END_DATE_INVALID, "入学与毕业时间填写错误");
        map.put(ERR_LOG_USER_CONTACT_IS_SELF_PHONE, "联系方式不能是自己的手机号");
        map.put(ERR_LOG_EMAIL_NOT_VALID, "邮箱格式不正确");
        map.put(ERR_LOG_TEL_NOT_VALID, "电话号码格式不正确");
        map.put(ERR_LOG_BANK_CARD_AUTH_FUND_IS_NULL, "银行卡认证金额不能为空");
        map.put(ERR_LOG_BANK_CARD_REPEAT_AUTH, "请勿重复进行银行卡认证");
        map.put(ERR_LOG_BANK_CARD_NOT_FOUND, "请先填写基本信息");
        map.put(ERR_LOG_BANK_CARD_AUTH_FAILURE, "认证失败");
        map.put(ERR_LOG_BANK_CARD_AUTH_WRONG, "认证失败");
        map.put(ERR_QB_LOG_LOAN_SUBMIT_FAILURE, "提现信息提交失败");
        map.put(ERR_QB_LOG_LOAN_CREATE_ORDER_FAILURE, "创建订单失败");
        map.put(ERR_QB_LOG_REPAY_TOO_FAST, "当前有一笔还款正在处理");
        map.put(ERR_QB_LOG_REPAY_NEED_GOON, "当前有一笔还款未处理，请继续还款");
        map.put(ERR_QB_LOG_REPAY_RECHARGING, "您有一笔还款正在扣款，请稍后再还。");
        map.put(ERR_QB_LOG_REPAY_FUNDS_OVERFLOW, "还款金额超过所选还款项的应还款，请重新选择");
        map.put(ERR_QB_LOG_REPAY_CREATE_ORDER_FAILURE, "创建订单失败");
        map.put(ERR_QB_LOG_REPAY_ORDER_INVALID, "还款订单异常，请返回后重新还款");
        map.put(ERR_QB_LOG_REPAY_PAY_FAILED, "还款支付失败");
        map.put(ERR_QB_LOG_CREDITCARD_INFO_EXIST, "已通过信用卡实名认证");
        map.put(ERR_QB_INFO_CHECKED_ERROR, "信息校验失败");
        map.put(ERR_QB_BEYOND_MAX_QUARANTOR_COUNT, "保人个数超限");
        map.put(ERR_QB_GUARANTEE_SELF_NOT_ALLOW, "自己不能给自己担保");
        map.put(ERR_QB_GUARANTEE_CIRCLE, "已经有人帮您担保，不可为他人担保");
        map.put(ERR_QB_DULICATE_GUARANTEE, "重复担保");
        map.put(ERR_QB_BEYOND_MAX_QUARANTEE_PERIOD, "超过最大担保期限");
        map.put(ERR_QB_BEYOND_FUNDS_RANGE, "超过担保金额范围");
        map.put(ERR_QB_SELF_HAS_QUARANTEE, "邀请人已经帮别人担保了，不能被担保");
        map.put(ERR_QB_SELF_HAS_QUARANT, "已经帮别人担保了，不能被担保");
        map.put(ERR_LCG_HAS_APPLICATIONED, "已经提交过0息购申请");
        map.put(ERR_LCG_BEYOND_MAX_APPLICATION_FUNDS, "超过最大借款金额");
        map.put(ERR_LOG_APPLY_ORDER_NOT_FOUND, "暂无订单信息");
        map.put(ERR_MC_INFO_NO_EXIST, "商户信息不存在");
        map.put(ERR_INVITE_CODE_NOT_MATCH, "邀请码与商户信息不匹配");
        map.put(ERR_INVITE_CODE_INVAILD, "邀请码已失效");
        map.put(ERR_LOG_APPLY_REQ_NOT_FOUND, "您的借款申请不存在");
        map.put(ERR_LOG_APPLY_REQ_SAVE_ERROR, "申请提交失败");
        map.put(ERR_LOG_APPLY_MERCHANT_ERROR, "商户申请信息不完整");
        map.put(ERR_LOG_PAY_PASSWORD_ERROR, "密码错误,请重新输入");
        map.put(ERR_LOG_PAY_LOCK_ERROR, "错误次数过多,请24小时后再试");
        map.put(ERR_LOG_RECHARGE_MONRY_MIN, "充值金额小于最低充值金额");
        map.put(ERR_SYS_PERMISSION_DENIED, "产品处于内测阶段,敬请期待");
        map.put(ERR_WECHAT_INVALID_CREDENTAIL, "微信授权过期,上传图片失败");

        map.put(ERR_LOG_LOGIN_FORBID,"账号被封禁或删除，请与管理员联系");
        map.put(ERR_LOG_CHANEL_INVAILD,"合作机构编码错误，请与管理员联系");
        map.put(ERR_CHECK_PARAMS, "入参校验失败");
        map.put(ERR_JSON_FORMAT, "错误Json格式");
        map.put(ERR_VERIFY_SIGNATURE_ERROR, "签名验证失败");
    }

    /**
     * errorcode 是否已经定义了
     *
     * @param errorCode
     * @return
     */
    public static boolean hasErrorCode(String errorCode) {
        if (StringUtil.isNull(errorCode)) {
            return false;
        }

        return map.containsKey(errorCode);
    }

    /**
     * 通过errorcode查询errormessage
     *
     * @param errorCode
     * @return
     */
    public static String getErrorMsg(String errorCode) {
        if (map.containsKey(errorCode)) {
            return map.get(errorCode);
        } else {
            return "未定义错误";
        }
    }
}