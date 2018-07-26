package redis;

import java.util.List;

public interface ReadRedisService {

    /**
     * 获取缓存对象
     * @param key
     * @param clazz
     * @return
     */
    public <T> T get(String key, Class<T> clazz);


    public <T> List<T> getList(String key, Class<T> clazz);


    /**
     * 判断当前key值是否存在
     * @param key
     */
    public  boolean hasKey(String key);


    /**
     * get
     * @param key
     * @return
     */
    public  String get(String key);


}
