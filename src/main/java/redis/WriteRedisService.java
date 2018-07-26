package redis;

public interface WriteRedisService {
    /**
     * set String
     * @param key
     * @param value
     */
    public void set(String key,String value);


    /**
     * set String 设置失效时间  单位秒
     * @param key
     * @param value
     * @param expried
     */
    public void set(String key,String value,long expried);


    /**
     * 缓存对象
     * @param key
     * @param o
     */
    public void set(String key, Object o);


    /**
     * 缓存对象并设置失效时间 单位秒
     * @param key
     * @param o
     * @param expired
     */
    public void set(String key, Object o, long expired);

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public void  del(String key);

}
