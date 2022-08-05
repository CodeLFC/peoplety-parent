package gaozhi.online.peoplety.exception.enums;


import gaozhi.online.base.result.Result;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 用户
 * @date 2022/1/19 22:36
 */
public enum UserExceptionEnum implements Result.ResultEnum {
    USER_AUTH_ERROR(2000,"API请求权限校验失败:请重新登陆，您的账号有被盗用的风险，请及时修改密码"),
    USER_PASS_ERROR(2001,"密码错误"),
    USER_ACCOUNT_FORBIDDEN(2002,"账号已被禁用"),
    USER_ACCOUNT_CANCEL(2003,"账号已注销"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在"),
    VERIFY_CODE_NOT_EXIST(2006,"请向服务器请求验证码"),
    VERIFY_CODE_NOT_VALIDATE(2007,"验证码失效"),
    VERIFY_CODE_ERROR(2008,"验证码错误"),
    VERIFY_CODE_REQUEST_ERROR(2009,"请求验证码失败"),
    VERIFY_CODE_EMAIL_ERROR(2010,"接收验证码的邮箱地址不正确"),
    USER_STATUS_ERROR(2011,"用户身份无效"),
    USER_CANT_RECOMMEND_SELF(2012,"用户不应该推荐自己"),
    EMAIL_SEND_FAIL(2013,"服务器忙，邮件发送被拒绝，请使用短信方式或稍后再试");
    private final int  code;
    private final String message;

    UserExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
