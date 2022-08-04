package gaozhi.online.peoplety.service.log;

import com.google.gson.Gson;
import gaozhi.online.base.log.ILogService;
import gaozhi.online.base.log.SysLog;
import gaozhi.online.peoplety.entity.Token;
import gaozhi.online.peoplety.config.SystemPropertyConfig;
import gaozhi.online.peoplety.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO  控制层日志
 * @date 2022/8/4 16:16
 */
@Service
@Slf4j
public class ControllerLogServiceImpl implements ILogService {
    @Autowired
    private SystemPropertyConfig systemPropertyConfig;
    @Autowired
    private SysLogService sysLogService;

    @Override
    public void handle(SysLog log) {
        log.setType(systemPropertyConfig.getApplicationName());
        sysLogService.insert(log);
    }
}
