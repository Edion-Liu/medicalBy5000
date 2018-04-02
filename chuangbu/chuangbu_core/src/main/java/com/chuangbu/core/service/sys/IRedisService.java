package com.chuangbu.core.service.sys;

import java.util.List;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年9月10日 下午8:46:14
 */

public interface IRedisService {

	public boolean set(String key, String value);  
    
    public String get(String key);  
      
    public boolean expire(String key,long expire);  
      
    public <T> boolean setList(String key ,List<T> list);  
      
    public <T> List<T> getList(String key,Class<T> clz);  
      
    public long lpush(String key,Object obj);  
      
    public long rpush(String key,Object obj);  
      
    public String lpop(String key);  
}
