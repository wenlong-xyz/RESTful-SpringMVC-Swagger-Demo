package pers.well.dao;


import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;



@Repository("redisDao")
public class RedisDAO {

    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOps;

    @Resource(name="redisTemplate")
    private RedisOperations<String, String> redisOps ;



    public void set(String key, String value) {
        valueOps.set(key, value);
    }

    public String get(String key) {
        return  valueOps.get(key);
    }

    public boolean setexpress(String key,Date date){
        return redisOps.expireAt(key, date);
    }
    public boolean setexpress(String key,long timeout){
        return redisOps.expire(key, timeout, TimeUnit.MINUTES);
    }
    public void delete(String key) {
        redisOps.delete(key);
    }


}

