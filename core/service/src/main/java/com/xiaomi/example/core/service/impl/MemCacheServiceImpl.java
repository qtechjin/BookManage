package com.xiaomi.example.core.service.impl;

import com.xiaomi.example.core.service.MemCacheService;
import net.spy.memcached.MemcachedClient;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by liujin on 2017/7/6.
 */
public class MemCacheServiceImpl implements MemCacheService {

    private MemcachedClient memcachedClient;

    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    private Logger logger = Logger.getLogger(MemCacheServiceImpl.class);

    @Override
    public boolean set(String key, Object value, int expire) {
        logger.info(key + " 加入缓存,值:" + value);
        Future<Boolean> flag  = memcachedClient.set(key,expire, value);
        return getBoolean(flag);
    }

    @Override
    public Object get(String key) {
        return memcachedClient.get(key);
    }

    @Override
    public Object asyncGet(String key) {
        Object myObj = null;
        Future<Object> future = memcachedClient.asyncGet(key);
        try {

            myObj = future.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.warn("获取" + key + "的时候出现错误,原因:", e);
            future.cancel(false);
        }
        return myObj;
    }

    @Override
    public Map<String, Object> getMulti(String[] keys) {
        return memcachedClient.getBulk(keys);
    }

    @Override
    public Map<String, Object> getMulti(Collection<String> keys) {
        return memcachedClient.getBulk(keys);
    }

    @Override
    public boolean replace(String key, Object value, int expire) {
        Future<Boolean>  flag = memcachedClient.replace(key, expire, value);
        return getBoolean(flag);
    }

    @Override
    public boolean delete(String key) {
        Future<Boolean>  flag = memcachedClient.delete(key );
        return getBoolean(flag);
    }

    @Override
    public boolean flush() {
        Future<Boolean>  flag = memcachedClient.flush();
        return getBoolean(flag);
    }

    private boolean getBoolean(Future<Boolean> flag) {
        try {
            Boolean bool = flag.get();
            return bool.booleanValue();
        } catch (Exception e) {
            flag.cancel(false);
            return false;
        }
    }


    public void shutdown() {
        memcachedClient.shutdown();
    }
}
