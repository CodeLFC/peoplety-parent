package gaozhi.online.peoplety.service.log;

import gaozhi.online.base.log.ILogService;
import gaozhi.online.base.log.LogAop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 控制层日志
 * @date 2022/8/4 17:17
 */
@Component
@Aspect
public class ControllerLogAop extends LogAop {
    @Override
    @Pointcut("execution(* gaozhi.online.peoplety.*.controller.*.*(..))")
    public void pointcut() {

    }

    @Autowired
    @Override
    public void setSysLogService(ILogService sysLogService) {
        super.setSysLogService(sysLogService);
    }
}
