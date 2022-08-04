package gaozhi.online.peoplety.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO  系统属性
 * @date 2022/8/4 21:28
 */
@Data
@Component
public class SystemPropertyConfig {
    @Value("${spring.application.name}")
    private String applicationName;
}
