package gaozhi.online.peoplety.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import gaozhi.online.base.log.SysLog;
import gaozhi.online.peoplety.entity.Friend;
import gaozhi.online.peoplety.mapper.LogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 系统日志服务
 * @date 2022/8/4 21:57
 */
@Service
public class SysLogService {
    @Resource
    private LogMapper logMapper;

    public int insert(SysLog sysLog) {
        return logMapper.insert(sysLog);
    }

    public PageInfo<SysLog> selectAll(long startTime, long endTime, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> logs = logMapper.selectAll(startTime, endTime);
        return new PageInfo<>(logs);
    }
}
