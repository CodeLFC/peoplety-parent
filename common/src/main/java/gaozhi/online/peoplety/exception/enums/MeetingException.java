package gaozhi.online.peoplety.exception.enums;

import gaozhi.online.base.result.Result;

/**
* @description: TODO 会议异常
* @author http://gaozhi.online
* @date 2022/12/13 16:50
* @version 1.0
*/
public enum  MeetingException implements Result.ResultEnum{
    MEETING_NOT_EXISTED(3001,"会议不存在"),
    MEETING_HAS_EXISTED(3002,"会议已存在"),
    MEETING_IS_BANED(3003,"会议被封禁")
    ;
    private final int  code;
    private final String message;

    MeetingException(int code, String message) {
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
