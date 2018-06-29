package com.millinch.spring.boot.autoconfigure.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * @author xuejike
 */
public class SpringShiroCacheManager implements CacheManager,Destroyable {
    private org.springframework.cache.CacheManager cacheManager;

    public SpringShiroCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        if (s == null ){
            return null;
        }
        return new ShiroSpringCache<K,V>(s,cacheManager);
    }

    @Override
    public void destroy() throws Exception {

    }
}
