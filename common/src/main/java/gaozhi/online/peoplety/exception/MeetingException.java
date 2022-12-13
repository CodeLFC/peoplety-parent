package gaozhi.online.peoplety.exception;

import gaozhi.online.base.exception.BusinessRuntimeException;
import gaozhi.online.base.result.Result;

/**
* @description: TODO 会议异常
* @author http://gaozhi.online
* @date 2022/12/13 16:49
* @version 1.0
*/
public class MeetingException extends BusinessRuntimeException {
    public MeetingException(Result.ResultEnum exception) {
        super(exception);
    }

    public MeetingException(Result.ResultEnum exception, String msg) {
        super(exception, msg);
    }
}
