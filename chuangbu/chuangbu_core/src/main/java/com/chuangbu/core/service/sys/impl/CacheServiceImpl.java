package com.chuangbu.core.service.sys.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chuangbu.core.service.sys.ICacheService;

@Service
public class CacheServiceImpl implements ICacheService {
	private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);
	private static ConcurrentHashMap<String , String> cacheMap = new ConcurrentHashMap<String , String>();
	
//	@Autowired
//  private IRedisService redisService;
	
	@Override
	public boolean set(String key, String value) {
		cacheMap.put(key, value);
		return false;
	}

	@Override
	public String get(String key) {
		return cacheMap.get(key);
	}

	@Override
	public void cleanAll() {
		logger.info("清理全部缓存开始");
		cacheMap.clear();
		logger.info("清理全部缓存结束");
	}

}
