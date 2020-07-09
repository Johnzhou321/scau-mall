package org.scau.mall.service.config.cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存key生成器
 * @Description: 
 * @author: zhouguangming
 * @date: 2020年7月8日 下午10:36:51
 * @version: V1.0
 * @Copyright: xrk
 */
@Configuration
public class CacheKeyGenerator {
	
	@Bean
	public KeyGenerator simpleKey() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName()+":");
				for (Object param : params) {
					sb.append(param.toString());
				}
				return sb.toString();
			}
		};
	}
	
	@Bean
	public KeyGenerator objectId() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName()+":");
				try {
					sb.append(params[0].getClass().getMethod("getId", null).invoke(params[0], null).toString());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				
				return sb.toString();
			}
		};
	}
}
