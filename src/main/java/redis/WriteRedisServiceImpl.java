package redis;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("WriteRedisService")
public class WriteRedisServiceImpl implements WriteRedisService {

    private static RedisTemplate<String, String> redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        //默认过期时间1小时
        redisTemplate.expire(key, RedisCache.DEFAULT_EXPIRED_TIME, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, String value, long expried) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expried, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, Object o) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(o));
        redisTemplate.expire(key, RedisCache.DEFAULT_EXPIRED_TIME, TimeUnit.SECONDS);

    }

    @Override
    public void set(String key, Object o, long expired) {
        redisTemplate.opsForValue().set(key,JSON.toJSONString(o));
        redisTemplate.expire(key,expired, TimeUnit.SECONDS);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    public static RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public static void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        WriteRedisServiceImpl.redisTemplate = redisTemplate;
    }
}
