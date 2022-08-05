package gaozhi.online.peoplety.config;

import feign.Contract;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO  feign 配置
 * @date 2022/7/30 15:01
 */
@Slf4j
@Configuration
@EnableFeignClients(basePackages = {"gaozhi.online.peoplety.log"})
public class FeignConfiguration {

    /**
     * @return feign.Contract
     * @description: 废除 使用自带契约
     * @author http://gaozhi.online
     * @date: 2022/8/5 13:47
     */
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                        .getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String values = request.getHeader(name);
                        // 跳过 content-length body是跟Content-Length，可能导致Content-length长度跟body不一致
                        if (name.equals("content-length")) {
                            continue;
                        }
                        requestTemplate.header(name, values);
                    }
                }
            }
        };
    }
}
