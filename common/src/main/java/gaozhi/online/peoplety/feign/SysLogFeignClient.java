package gaozhi.online.peoplety.feign;

import gaozhi.online.base.result.Result;
import gaozhi.online.peoplety.config.FeignConfiguration;
import gaozhi.online.peoplety.entity.SysLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
* @description: TODO 日志服务
* @author http://gaozhi.online
* @date 2022/12/1 21:20
* @version 1.0
*/
@FeignClient(value = "app-peoplety-log", configuration = FeignConfiguration.class)
public interface SysLogFeignClient {
    @PostMapping("/post/log")
    Result postLog(@RequestBody SysLog sysLog);
}
