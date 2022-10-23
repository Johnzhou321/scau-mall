package org.scau.mall.config.redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * redis配置类
 * @Description: redis配置类
 * @author: zhouguangming
 * @date: 2020年7月8日 下午3:18:21
 * @version: V1.0
 * @Copyright: xrk
 */
public class SpringDataRedisConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringDataRedisConfiguration.class);
	/**
     * redis的地址
     */
    @Value("${redis.hostname}")
    private String hostName;
    /**
     * redis的端口
     */
    @Value("${redis.port}")
    private int port;
    /**
     * redis的密码
     */
    @Value("${redis.password}")
    private String password;
    /**
     * redis连接池 最大连接数
     */
    @Value("${redis.pool.maxTotal}")
    private int maxTotal;
    /**
     * redis连接池 最大空闲连接数
     */
    @Value("${redis.pool.maxIdle}")
    private int maxIdle;
    /**
     * redis连接池 获取连接时的最大等待毫秒数
     */
    @Value("${redis.pool.maxWait}")
    private int maxWait;

    /**
     * redis连接池 获取连接的时候检查有效性, 默认false
     */
    @Value("${redis.pool.testOnBorrow:false}")
    private boolean testOnBorrow;

    /**
     * 是否使用redis cluster集群
     */
    @Value("${redis.use_cluster}")
    public boolean useCluster;
    /**
     * 集群节点
     */
    @Value("${redis.cluster.nodes}")
    public String jedisClusterNodes;
    /**
     * 超时时间
     */
    @Value("${redis.cluster.timeout}")
    public int jedisClusterTimeout;
    /**
     * 允许的最大重定向次数
     */
    @Value("${redis.cluster.maxRedirections}")
    public int jedisClusertMaxRedirections;

    @Autowired
    JedisPoolConfig jedisPoolConfig;
    
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
    	JedisPoolConfig poolConfig = new JedisPoolConfig();
    	poolConfig.setMaxIdle(maxIdle);
    	poolConfig.setMaxTotal(maxTotal);
    	poolConfig.setMaxWaitMillis(maxWait);
    	poolConfig.setTestOnBorrow(testOnBorrow);
    	return poolConfig;
    }
    
    @Bean
    public RedisClusterConfiguration redisClusterConfiguration() {
    	List<String> nodes = Arrays.asList(jedisClusterNodes.split(","));
    	RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(nodes);
    	redisClusterConfiguration.setMaxRedirects(6);
    	return redisClusterConfiguration;
    }
    
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisClusterConfiguration redisClusterConfiguration) {
    	JedisConnectionFactory jcf = null;
    	if (this.useCluster) {
    		jcf = new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfig);
    	}else {
    		jcf = new JedisConnectionFactory(jedisPoolConfig);
    		jcf.setHostName(hostName);
    		jcf.setPort(port);
    		jcf.setPassword(password);
    	}
    	return jcf;
    }
    
    @Bean
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
    	RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
    	redisTemplate.setConnectionFactory(jedisConnectionFactory);
    	StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    	RedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();
    	
    	redisTemplate.setKeySerializer(stringRedisSerializer);
    	redisTemplate.setValueSerializer(jdkSerializer);
    	redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    
    @Bean
    public RedisService redisService(RedisTemplate<String, String> redisTemplate) {
    	if (logger.isDebugEnabled()) {
            logger.debug("useCluster={}", this.useCluster);
        }
        return new DefaultRedisServiceImpl(redisTemplate);
    }
}
