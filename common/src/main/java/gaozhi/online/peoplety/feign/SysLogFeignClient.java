package gaozhi.online.peoplety.feign;

import gaozhi.online.base.log.SysLog;
import gaozhi.online.base.result.Result;
import gaozhi.online.peoplety.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 用户服务
 * @date 2022/7/29 19:08
 */
@FeignClient(value = "app-peoplety-log", configuration = FeignConfiguration.class)
public interface SysLogFeignClient {
    /**
    * @description:  写日志
    * @param sysLog
     * @return gaozhi.online.base.result.Result
    * @author http://gaozhi.online
    * @date: 2022/8/5 13:23
    */
    @PostMapping("/sys_log/post/log")
    Result writeLog(@RequestBody SysLog sysLog);
}
