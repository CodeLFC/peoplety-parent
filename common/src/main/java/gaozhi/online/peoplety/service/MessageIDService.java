package gaozhi.online.peoplety.service;

import gaozhi.online.peoplety.entity.Message;
import gaozhi.online.peoplety.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author http://gaozhi.online
 * @version 1.0
 * @description: TODO  分布式消息ID服务
 * @date 2022/9/13 20:52
 */
@Service
public class MessageIDService implements Function<Long, Long> {
    /**
     * 分布式ID的键
     */
    public static final String MESSAGE_ID_REDIS_KEY = "MESSAGE_ID_REDIS_KEY";

    {
        /**设置分布式ID的提供者*/
        Message.setIDSupplier(this);
    }

    @Autowired
    private RedisService redisService;

    @Override
    public Long apply(Long increaseSize) {
        return increaseID(increaseSize);
    }

    //增长ID
    private long increaseID(long increaseSize) {
        Long id = redisService.get(MESSAGE_ID_REDIS_KEY, Long.class);
        if (id == null) {
            id = 0L;
        }
        long newID = id + increaseSize;
        if (redisService.set(MESSAGE_ID_REDIS_KEY, id + increaseSize)) {
            return newID;
        }
        return id;
    }
}
