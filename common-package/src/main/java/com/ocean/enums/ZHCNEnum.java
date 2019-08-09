package com.ocean.enums;

/**
 * 中文简体所有提示信息
 * 错误码命名规则：例如B100001
 * 第1位：B-业务提示错误 E-系统异常Exception
 * 第2位：0-公共 1-登录 2-认证
 * 第3-4位：00-判空错误 01-格式错误 02-判断已存在 03-信息不足 04-业务错误 05-不匹配或验证错误
 * 第5-7位：根据001开始定义
 */
public enum ZHCNEnum {
    SEND_MAIL_VALIDATE_CODE_SUCCESSFUL("发送邮箱验证码成功",""),
    SEND_MAIL_VALIDATE_CODE_FAILED("发送邮箱验证码失败","E000001"),
    SEND_SMS_VALIDATE_CODE_SUCCESSFUL("发送手机验证码成功",""),
    SEND_SMS_VALIDATE_CODE_FAILED("发送手机验证码失败","E000002"),

    /**
     * 登录错误码
     */
    CELLPHONE_NOT_NULL("手机号不为空","B100001"),
    WRONG_PHONE_NUMBER_FORMAT("手机号格式错误","B101001"),
    PASSWORD_NOT_NULL("密码不为空","B100002"),
    CONFIRM_PASSWORD_NOT_NULL("确认密码不为空","B100003"),
    INCORRECT_PASSWORD_FORMAT("密码格式错误","B101002"),
    INCORRECT_CONFIRM_PASSWORD_FORMAT("确认密码格式错误","B101003"),

    LOGIN_SUCCESSFUL("登录成功",""),
    LOGIN_FAILED("输入用户和密码错误","E100001"),
    ACCOUNT_EXISTS("该账号已存在","B102001"),
    ACCOUNT_NOT_EXISTS("该账号不存在","B102002"),
    REGISTER_SUCCESSFUL("注册成功",""),
    REGISTER_FAILED("注册失败","E100002"),
    UPDATE_PASSWORD_SUCCESSFUL("修改密码成功",""),
    UPDATE_PASSWORD_FAILED("修改密码失败","E100003"),
    PASSAGES_NOT_MATCH("输入密码和确认密码不匹配","B105000"),
    VERIFICATION_CODE_ERROR("验证码错误","B105001"),
    VERIFICATION_CODE_NULL("验证码不为空","B100004"),
    VERIFICATION_CODE_NOT_EXISTS("验证码不存在","B102003"),
    ORIGIN_NOT_NULL("来源不为空","B100005"),
    OLD_PASSWORD_NOT_NULL("旧密码不为空","B100006"),
    INCORRECT_OLD_PASSWORD_FORMAT("旧密码格式错误","B101004"),
    OLD_PASSWORD_NOT_MATCH("输入原密码不匹配","B105002"),
    PASSWORD_NOT_THE_SAME("新密码和旧密码不能相同","B105003"),
    VERIFICATION_CODE_SUCCESSFUL("验证码校验成功",""),
    USER_EXISTS_PASSWORD_IS_EMPTY("产品升级采用区块链数据不可篡改加密技术进行身份认证注册登录；老用户需点击“忘记密码”重新设置密码再登录。","B105004"),
    VERIFICATION_CODE_FAILED("验证码校验失败","E100004"),

    GET_USER_LIST_SUCCESSFUL("查询用户列表成功", ""),
    GET_USER_LIST_FAILED("查询用户列表失败", "E200001"),
    UPDATE_USER_ENABLED_SUCCESSFUL("禁用，启动用户成功", ""),
    UPDATE_USER_ENABLED_FAILED("禁用，启动用户失败", "E200002"),

    UPDATE_IDENTITY_STATE_SUCCESSFUL("查询用户实名认证列表成功", ""),
    UPDATE_IDENTITY_STATE_FAILED("查询用户实名认证列表失败", "E200003"),

    GET_USER_IDENTITY_LIST_FAILED("审核用户实名认证信息失败", "E200004"),
    GET_USER_IDENTITY_LIST_SUCCESSFUL("审核用户实名认证信息成功", ""),

    GET_USER_IDENTITY_FAILED("查询用户实名认证信息失败", "E200005"),
    GET_USER_IDENTITY_SUCCESSFUL("查询用户实名认证信息成功", ""),

    ADD_APP_STATE_SUCCESSFUL("新增接入应用成功", ""),
    ADD_APP_STATE_FAILED("新增接入应用失败", "E200006"),

    UPDATE_APP_STATE_SUCCESSFUL("更新接入应用成功", ""),
    UPDATE_APP_STATE_FAILED("更新接入应用失败", "E200007"),

    FIND_APP_STATE_SUCCESSFUL("查询接入应用成功", ""),
    FIND_APP_STATE_FAILED("查询接入应用失败", "E200008"),

    AUTH_LOGIN_SUCCESSFUL("授权登录成功",""),
    AUTH_LOGIN_FAILED("授权登录错误","E200009");

    // 成员变量
    protected String msg;
    protected String code;

    // 构造方法
    private ZHCNEnum(String msg, String code) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
