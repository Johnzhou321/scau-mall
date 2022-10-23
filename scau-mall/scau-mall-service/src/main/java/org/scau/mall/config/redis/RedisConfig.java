package org.scau.mall.config.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis配置类
 * @Description: 
 * @author: zhouguangming
 * @date: 2020年7月8日 下午4:48:15
 * @version: V1.0
 * @Copyright: xrk
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	
	/**
	 * redis缓存管理类
	 * @Description: 
	 * @author: zhouguangming
	 * @date: 2020年7月8日 下午4:53:36
	 * @version: V1.0
	 * @Copyright: xrk
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(43200);//12小时
		return cacheManager;
	}
}
