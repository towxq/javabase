package redis;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReadRedisTemplate")
public class ReadRedisServiceImpl implements ReadRedisService {
    private static RedisTemplate<String, String> redisTemplate;

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return  JSON.parseObject(redisTemplate.opsForValue().get(key),clazz);
    }


    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {


        return JSON.parseArray(redisTemplate.opsForValue().get(key), clazz);
    }

    public static RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public static void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        ReadRedisServiceImpl.redisTemplate = redisTemplate;
    }
}
