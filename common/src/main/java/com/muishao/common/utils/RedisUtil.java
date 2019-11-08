package com.muishao.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shikang
 * @Description: redis&#x64cd;&#x4f5c;
 * @Date: Created in 2018/1/16 10:45
 */
@Component
@Slf4j
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redis;

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean setString(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redis.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            log.error("调用redis【setString】方法异常:{}",e);
        }

        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param expireTime
     * @return
     */
    public boolean set(final String key,Long expireTime){
        boolean result = false;
        try {
            redis.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("调用redis【set】方法异常:{}",e);
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redis.opsForValue();
            operations.set(key, value);
            redis.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("调用redis【set】方法异常:{}",e);
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param expireTime
     * @return
     */
    public boolean set(final String key,Long expireTime,TimeUnit timeUnit){
        return set(key,"1",expireTime,timeUnit);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public boolean delKey(final String key) {
        boolean result = false;
        try {
            redis.delete(key);
            result = true;
        } catch (Exception e) {
            log.error("调用redis【delKey】方法异常:{}",e);
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redis.opsForValue();
            operations.set(key, value);
            redis.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("调用redis【set】方法异常:{}",e);
        }
        return result;
    }

    /**
     * 批量删除对应的value
     * @param keys
     */
    public void removeAll(final String... keys) {
        try {
            Set<String> keySet = new HashSet<>();
            for (String key : keys) {
                keySet.add(key);
            }
            redis.delete(keySet);
        }catch (Exception e){
            log.error("调用redis【removeAll】方法异常:{}",e);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        try {
            Set<String> keys = redis.keys(pattern);
            if (keys.size() > 0) {
                redis.delete(keys);
            }
        }catch (Exception e){
            log.error("调用redis【removePattern】方法异常:{}",e);
        }
    }

    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        try {
            if (exists(key)) {
                redis.delete(key);
            }
        }catch (Exception e){
            log.error("调用redis【remove】方法异常:{}",e);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        try{
            return redis.hasKey(key);
        }catch (Exception e){
            log.error("调用redis【exists】方法异常:{}",e);
        }
        return false;
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String getString(final String key) {
        try {
            String result = null;
            ValueOperations<String, String> operations = redis.opsForValue();
            result = operations.get(key);
            return result;
        }catch (Exception e){
            log.error("调用redis【getString】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 生成序列号
     * @param key
     * @return
     */
    public Long increment(final String key) {
        try {
            ValueOperations<String, String> operations = redis.opsForValue();
            long no = operations.increment(key,1L);
            redis.expire(key,1L,TimeUnit.SECONDS);
            return no;
        }catch (Exception e){
            log.error("调用redis【increment】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 生成序列号
     * @param key
     * @return
     */
    public Long increment(final String key,long second) {
        try {
            ValueOperations<String, String> operations = redis.opsForValue();
            long no = operations.increment(key,1L);
            redis.expire(key,second,TimeUnit.SECONDS);
            return no;
        }catch (Exception e){
            log.error("调用redis【increment】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value){
        try {
            HashOperations<String, Object, Object> hash = redis.opsForHash();
            hash.put(key, hashKey, value);
        }catch (Exception e){
            log.error("调用redis【hmSet】方法异常:{}",e);
        }
    }

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public String hmGet(String key, Object hashKey){
        try {
            HashOperations<String, String, String> hash = redis.opsForHash();
            return hash.get(key, hashKey);
        }catch (Exception e){
            log.error("调用redis【hmGet】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     */
    public void hmDel(String key, String... hashKey){
        try {
            HashOperations<String, Object, Object> hash = redis.opsForHash();
            hash.delete(key, hashKey);
        }catch (Exception e){
            log.error("调用redis【hmDel】方法异常:{}",e);
        }
    }

    /**
     * 哈希获取数据
     * @param key
     * @return
     */
    public Map<Object,Object> hGetAll(String key){
        try {
            HashOperations<String, Object, Object> hash = redis.opsForHash();
            return hash.entries(key);
        }catch (Exception e){
            log.error("调用redis【hGetAll】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 列表添加
     * @param k
     * @param v
     */
    public void lPush(String k,String v){
        try {
            ListOperations<String, String> list = redis.opsForList();
            list.leftPush(k, v);
        }catch (Exception e){
            log.error("调用redis【lPush】方法异常:{}",e);
        }
    }

    /**
     * 列表获取
     * @param k
     */
    public String lPop(String k){
        try {
            ListOperations<String, String> list = redis.opsForList();
            return list.leftPop(k);
        }catch (Exception e){
            log.error("调用redis【lPop】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<String> lRange(String k, long l, long l1){
        try {
            ListOperations<String, String> list = redis.opsForList();
            return list.range(k,l,l1);
        }catch (Exception e){
            log.error("调用redis【lRange】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void add(String key,String value){
        try{
            SetOperations<String, String> set = redis.opsForSet();
            set.add(key,value);
        }catch (Exception e){
            log.error("调用redis【add】方法异常:{}",e);
        }
     }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<String> setMembers(String key){
        try{
            SetOperations<String, String> set = redis.opsForSet();
            return set.members(key);
        }catch (Exception e){
            log.error("调用redis【setMembers】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,String value,double scoure){
        try {
            ZSetOperations<String, String> zset = redis.opsForZSet();
            zset.add(key, value, scoure);
        }catch (Exception e){
            log.error("调用redis【zAdd】方法异常:{}",e);
        }
    }

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<String> rangeByScore(String key,double scoure,double scoure1){
        try{
            ZSetOperations<String, String> zset = redis.opsForZSet();
            return zset.rangeByScore(key, scoure, scoure1);
        }catch (Exception e){
            log.error("调用redis【rangeByScore】方法异常:{}",e);
        }
        return null;
    }

    /**
     * 写入缓存设置时效时间
     * @param key           key
     * @param expireTime    超时时间
     * @param timeUnit      超时时间单位
     * @return
     */
    public boolean expire(final String key,Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            redis.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            log.error("调用redis【expire】方法异常:{}",e);
        }
        return result;
    }

    /**
     * 执行lua脚本
     * @return
     */
    public boolean eval(ResourceScriptSource scriptSource, List<String> keys, Object... val) {
        boolean result = false;
        try {
            DefaultRedisScript script = new DefaultRedisScript();
            script.setScriptSource(scriptSource);
            redis.execute(script,new StringRedisSerializer(),new StringRedisSerializer(), keys, val);
            result = true;
        } catch (Exception e) {
            log.error("调用redis【eval】方法异常:{}",e);
        }
        return result;
    }

    /**
     * 获取list长度
     * @param k
     */
    public long llen(String k){
        try{
            ListOperations<String, String> list = redis.opsForList();
            return list.size(k);
        }catch (Exception e){
            log.error("调用redis【llen】方法异常:{}",e);
        }
        return 0L;
    }




}
 