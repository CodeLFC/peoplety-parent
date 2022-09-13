package gaozhi.online.peoplety.config;

import com.google.gson.Gson;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO 一些组件
 * @date 2022/9/13 16:00
 */
@Configuration
public class ComponentConfig {
    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        // 设置超时
        requestFactory.setConnectTimeout(60 * 1000);
        requestFactory.setReadTimeout(60 * 1000);

        //利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        return restTemplate;
    }
}
