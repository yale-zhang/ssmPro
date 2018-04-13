package com.yale.ssm.cache;

import com.yale.ssm.util.ProtoStuffSerializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * cache 缓存
 *
 */
@Component
public class RedisCache {

    public final static String CAHCENAME="cache";//缓存名
    public final static int CAHCETIME=60;//默认缓存时间

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

   public <T> Boolean putCache(String key,T obj){
       final byte[] bkey = key.getBytes();
       final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
       Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
           @Override
           public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
               return connection.setNX(bkey, bvalue);
           }
       });
       return result;
   }

    public <T> void putCacheWithExpireTime(String key,T obj,final long expireTime){
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                 connection.setEx(bkey,expireTime, bvalue);
                return true;
            }
        });
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
        return result;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, final long expireTime) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
        return result;
    }
    /**
     * 精确删除key
     *
     * @param key
     */
    public void deleteCache(String key) {
        redisTemplate.delete(key);
    }
    /**
     * 模糊删除key
     *
     * @param pattern
     */
    public void deleteCacheWithPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }

    /**
     * 清空所有缓存
     */
    public void clearCache() {
        deleteCacheWithPattern(RedisCache.CAHCENAME+"|*");
    }
}
