package gaozhi.online.peoplety.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO Redis服务
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
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public String getFromMap(final String mapName, final String key) {
        BoundHashOperations<String, String, String> opsForHash = redisTemplate.boundHashOps(mapName);
        return opsForHash.get(key);
    }

    public void add2Map(final String mapName, final String key, final String value) {
        BoundHashOperations<String, String, String> opsForHash = redisTemplate.boundHashOps(mapName);
        opsForHash.put(key, value);
    }

    /**
     * 写入缓存
     */
    public void set(final String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public <T> T get(final String key, Class<T> tClass) {
        String res = redisTemplate.opsForValue().get(key);
        log.debug("redis key:{} value:{}", key, res);
        return gson.fromJson(res, tClass);
    }

    /**
     * 写入缓存
     */
    public <T> void set(final String key, T value) {
        redisTemplate.opsForValue().set(key, gson.toJson(value));
    }

    /**
     * @description: 添加到队列中
     * @param: key
     * @param: value
     * @return: boolean
     * @author LiFucheng
     * @date: 2022/7/16 12:27
     */
    public <T> void listLeftPush(final String key, T value) {
        redisTemplate.opsForList().leftPush(key, gson.toJson(value));
    }

    public <T> void listLeftPush(final String key, List<T> list) {
        List<String> values = new ArrayList<>(list.size());
        for (T v : list) {
            values.add(gson.toJson(v));
        }
        redisTemplate.opsForList().leftPushAll(key, values);
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
    public void delete(final String key) {
        redisTemplate.delete(key);
    }
}