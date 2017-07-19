package com.xiaomi.example.core.service;

import java.util.Collection;
import java.util.Map;

/**
 * Created by liujin on 2017/7/6.
 */
public interface MemCacheService {

    public boolean set(String key, Object value, int expire);

    public Object get(String key);

    public Object asyncGet(String key);

    public Map<String, Object> getMulti(String []keys);

    public Map<String, Object> getMulti(Collection<String> keys);

    public boolean replace(String key, Object value, int expire);

    public boolean delete(String key);

    public boolean flush();

    public void shutdown();

}
