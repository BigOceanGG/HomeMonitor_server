package com.ocean.enums;

/**
 * 中文简体所有提示信息
 * 错误码命名规则：例如B100001
 * 第1位：B-业务提示错误 E-系统异常Exception
 * 第2位：0-公共  1-登录 2-认证模块
 * 第3-4位：00-判空错误 01-格式错误 02-判断已存在 03-信息不足 04-业务错误 05-不匹配
 * 第5-7位：根据001开始定义
 */
public enum ENEnum{
    SEND_MAIL_VALIDATE_CODE_SUCCESSFUL("Send a cellphone verification code successfully",""),
    SEND_MAIL_VALIDATE_CODE_FAILED("Sending a cellphone verification code failed","E000001"),
    SEND_SMS_VALIDATE_CODE_SUCCESSFUL("Send a cellphone verification code successfully",""),
    SEND_SMS_VALIDATE_CODE_FAILED("Sending a cellphone verification code failed","E000002"),

    /**
     * Login error code
     */
    CELLPHONE_NOT_NULL("The phone number is not empty","B100001"),
    WRONG_PHONE_NUMBER_FORMAT("Wrong phone number format","B101001"),
    PASSWORD_NOT_NULL("Password is not empty","B100002"),
    CONFIRM_PASSWORD_NOT_NULL("Confirm password is not empty","B100003"),
    INCORRECT_PASSWORD_FORMAT("Incorrect password format","B101002"),
    INCORRECT_CONFIRM_PASSWORD_FORMAT("Incorrect confirm password format","B101003"),

    LOGIN_SUCCESSFUL("Login successful",""),
    LOGIN_FAILED("Incorrect user and password input","E100001"),
    ACCOUNT_EXISTS("This account already exists","B102001"),
    ACCOUNT_NOT_EXISTS("The account does not exist","B102002"),
    REGISTER_SUCCESSFUL("registration success",""),
    REGISTER_FAILED("registration failed","E100002"),
    UPDATE_PASSWORD_SUCCESSFUL("Update password successful",""),
    UPDATE_PASSWORD_FAILED("Update password failed","E100003"),
    PASSAGES_NOT_MATCH("The input and confirm passages do not match","B105000"),
    VERIFICATION_CODE_ERROR("Verification code error","B105001"),
    VERIFICATION_CODE_NULL("Verification code is not empty","B100004"),
    VERIFICATION_CODE_NOT_EXISTS("Verification code is not exists","B102003"),
    ORIGIN_NOT_NULL("Origin is not null","B100005"),
    OLD_PASSWORD_NOT_NULL("Old password is not null","B100006"),
    INCORRECT_OLD_PASSWORD_FORMAT("Incorrect old password format","B101004"),
    OLD_PASSWORD_NOT_MATCH("The original password does not match","B105002"),
    PASSWORD_NOT_THE_SAME("The new password and the old password cannot be the same","B105003"),
    VERIFICATION_CODE_SUCCESSFUL("Verification code verification successfully",""),
    USER_EXISTS_PASSWORD_IS_EMPTY("Product upgrade uses block chain data can not be tampered with encryption technology for authentication registration; old users need to click \"forget password\" to reset password and login again.","B105004"),
    VERIFICATION_CODE_FAILED("Verification code failed","E100004"),

    GET_USER_LIST_SUCCESSFUL("Query user list successfully", ""),
    GET_USER_LIST_FAILED("Failed to query user list", "E200001"),
    UPDATE_USER_ENABLED_SUCCESSFUL("Disabled, enabling users to succeed", ""),
    UPDATE_USER_ENABLED_FAILED("Disabled, failed to start user", "E200002"),

    UPDATE_IDENTITY_STATE_SUCCESSFUL("Query the user's real name authentication list successfully.", ""),
    UPDATE_IDENTITY_STATE_FAILED("Failed to query the user's real name authentication list", "E200003"),

    GET_USER_IDENTITY_LIST_FAILED("Failure to authenticated user's real name authentication information", "E200004"),
    GET_USER_IDENTITY_LIST_SUCCESSFUL("Authenticated user's real name authentication information is successful.", ""),

    GET_USER_IDENTITY_FAILED("Failed to authenticated users' real name authentication information", "E200005"),
    GET_USER_IDENTITY_SUCCESSFUL("Authenticated user's real name authentication information is successful.", ""),

    ADD_APP_STATE_SUCCESSFUL("Add application success", ""),
    ADD_APP_STATE_FAILED("Add application failed", "E200006"),

    UPDATE_APP_STATE_SUCCESSFUL("Update application success", ""),
    UPDATE_APP_STATE_FAILED("Update application failed", "E200007"),

    FIND_APP_STATE_SUCCESSFUL("Query application success", ""),
    FIND_APP_STATE_FAILED("Query application failed", "E200008"),

    AUTH_LOGIN_SUCCESSFUL("Authorization login success", ""),
    AUTH_LOGIN_FAILED("Authorization login failed", "E200009");


    // Member variables
    protected String msg;
    protected String code;
    // Construction method

    private ENEnum(String msg,String code) {
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
