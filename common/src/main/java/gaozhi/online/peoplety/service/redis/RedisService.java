package gaozhi.online.peoplety.service.redis;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO
 * @date 2022/7/13 21:26
 */

@Service
@Slf4j
public class RedisService {
    @Autowired
    private Gson gson;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public <T> T get(final String key, Class<T> tClass) {
        String res = redisTemplate.opsForValue().get(key);
         log.debug("redis key:{} value:{}",key, res);
        return gson.fromJson(res, tClass);
    }

    /**
     * 写入缓存
     */
    public <T> boolean set(final String key, T value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, gson.toJson(value));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @description: 添加到队列中
     * @param: key
     * @param: value
     * @return: boolean
     * @author LiFucheng
     * @date: 2022/7/16 12:27
     */
    public <T> boolean listLeftPush(final String key, T value) {
        boolean result = false;
        try {
            redisTemplate.opsForList().leftPush(key, gson.toJson(value));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <T> boolean listLeftPush(final String key, List<T> list) {
        boolean result = false;
        List<String> values = new ArrayList<>(list.size());
        for (T v : list) {
            values.add(gson.toJson(v));
        }
        try {
            redisTemplate.opsForList().leftPushAll(key, values);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @description: 获取列表中所有的内容
     * @param: key
     * @param: tClass
     * @return: java.util.List<T>
     * @author LiFucheng
     * @date: 2022/7/16 12:47
     */
    public <T> List<T> listPopAll(final String key, Class<T> tClass) {
        List<String> res = redisTemplate.opsForList().range(key, 0, -1);
        log.info("redis key:" + key + " list:" + res);
        if (res == null) {
            return new ArrayList<>();
        }
        delete(key);
        List<T> result = new ArrayList<>(res.size());
        for (String e : res) {
            result.add(gson.fromJson(e, tClass));
        }
        return result;
    }

    /**
     * 删除缓存
     */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}