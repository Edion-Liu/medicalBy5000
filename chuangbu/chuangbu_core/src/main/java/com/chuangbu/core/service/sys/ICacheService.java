package com.chuangbu.core.service.sys;

public interface ICacheService {

	public boolean set(String key, String value);  
    
    public String get(String key);

	public void cleanAll();
    
}
