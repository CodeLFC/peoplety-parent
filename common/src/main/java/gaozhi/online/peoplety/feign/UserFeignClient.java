package gaozhi.online.peoplety.feign;

import gaozhi.online.base.interceptor.HeaderChecker;
import gaozhi.online.base.result.Result;
import gaozhi.online.peoplety.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO 用户服务
 * @date 2022/7/29 19:08
 */
@FeignClient(value = "app-peoplety-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @PostMapping("/general/user/post/check_auth")
    Result checkAuth(@RequestHeader(HeaderChecker.accessToken) String token, @RequestHeader(HeaderChecker.rpcURLKey) String url, @RequestHeader(HeaderChecker.rpcClientIp) String ip,@RequestHeader(HeaderChecker.rpcPrivilege) String isPrivilege);
}
