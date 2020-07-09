package org.scau.mall.service.config.redis;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class DefaultRedisServiceImpl implements RedisService {

  private RedisTemplate<String, String> redisTemplate;

  public DefaultRedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  /**
   * 字符串转为byte数组类型(统一编码)
   * 
   * @param key
   * @return
   */
  public byte[] strToByte(String key) {
    try {
      return key.getBytes(StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException e) {
      return null;
    }
  }

  public String bytesToStr(byte[] bs) {
    try {
      return new String(bs, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException e) {
      return null;
    }
  }

  /**
   * 从指定的列表右边出队,添加到目的列表中
   * 
   * @param srckey 源列表
   * @param dstkey 　目的列表
   * @return
   */
  public String rpoppush(final String srckey, final String dstkey) {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        try {
          return new String(connection.rPopLPush(strToByte(srckey), strToByte(dstkey)), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
        return "";
      }
    });
  }

  /**
   * 获取指定列表的范围数据
   * 
   * @param key 　列表名
   * @param start 　开始位置
   * @param end 　结束位置
   * @return
   */
  public List<String> lrange(final String key, final int start, final int end) {
    return redisTemplate.execute(new RedisCallback<List<String>>() {
      List<String> result = new ArrayList<String>();

      public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
        List<byte[]> bytelist = connection.lRange(strToByte(key), start, end);
        for (byte[] b : bytelist) {
          try {
            result.add(new String(b, StandardCharsets.UTF_8.toString()));
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return result;
      }
    });
  }

  /**
   * 从队列的左边取出一条数据
   * 
   * @param key 　列表名
   * @return
   */
  public String lpop(final String key) {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        byte[] result = connection.lPop(strToByte(key));
        if (result != null) {
          try {
            return new String(result, StandardCharsets.UTF_8.toString());
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return "";
      }
    });
  }
  
  /**
   * 从队列的左边取出一条数据
   * 
   * @param key 　列表名
   * @return
   */
  public List<String> blpop(final int timeout,final String key) {
    return redisTemplate.execute(new RedisCallback<List<String>>() {
      public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
    	List<String> resultList = new ArrayList<String>();
        List<byte[]> result = connection.bLPop(timeout, strToByte(key));
        for(byte[] temp:result){
        	if (temp != null) {
        		try {
        			resultList.add(new String(temp, StandardCharsets.UTF_8.toString()));
        		} catch (UnsupportedEncodingException e) {
        			e.printStackTrace();
        		}
        	}
        }
        return resultList;
      }
    });
  }
  
  /**
   * 从列表右边添加数据
   * 
   * @param key 列表名
   * @param values 数据
   * @return
   */
  public long rpush(String key, String... values) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0;
        for (String v : values) {
          connection.rPush(strToByte(key), strToByte(v));
        }
        return result;
      }
    });
  }

  /**
   * 从列表右边添加数据,并且设置列表的存活时间
   * 
   * @param key 列表名
   * @param liveTime 存活时间(单位 秒)
   * @param values 数据
   * @return
   */
  public long rpush(final String key, final int liveTime, final String... values) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0;
        for (String v : values) {
          connection.rPush(strToByte(key), strToByte(v));
        }
        if (liveTime > 0) {
          connection.expire(strToByte(key), liveTime);
        }
        return result;
      }
    });
  }

  /**
   * 从队列的右边取出一条数据
   * 
   * @param key 列表名
   * @return
   */
  public String rpop(final String key) {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        byte[] result = connection.rPop(strToByte(key));
        if (result != null) {
          try {
            return new String(result, StandardCharsets.UTF_8.toString());
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return "";
      }
    });
  }

  /**
   * 把一个值添加到对应列表中
   * 
   * @param key 列表名
   * @param index 　添加的位置
   * @param value 　数据
   * @return
   */
  public String lset(final String key, final long index, final String value) {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        connection.lSet(strToByte(key), index, strToByte(value));
        return "success";
      }
    });
  }

  /**
   * 把所有数据添加到一个列表中
   * 
   * @param key 列表名
   * @param values 　数据
   * @return
   */
  public long lpush(String key, String... values) {
    return this.lpush(key, 0, values);
  }

  /**
   * 把所有数据添加到一个列表中,并且设置列表的存活时间
   * 
   * @param key 列表名
   * @param values 数据
   * @param liveTime 存活时间--单位(秒)
   * @return
   */
  public long lpush(final String key, final int liveTime, final String... values) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0;
        for (String v : values) {
          result = connection.lPush(strToByte(key), strToByte(v));
        }
        if (liveTime > 0) {
          connection.expire(strToByte(key), liveTime);
        }
        return result;
      }
    });
  }

  /**
   * 返回列表的长度
   * 
   * @param key
   * @return
   */
  public long llen(final String key) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.lLen(strToByte(key));
      }
    });
  }

  /**
   * 删除列表中对应值的元素
   * 
   * @param key 列表名
   * @param count 删除多少个相同的元素
   * @param value 数据
   * @return
   */
  public long lrem(final String key, final long count, final String value) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.lRem(strToByte(key), count, strToByte(value));
      }
    });
  }

  /**
   * 通过key删除
   * 
   * @param keys 参数数组
   */
  public long del(final String... keys) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0;
        for (String k : keys) {
          result = connection.del(strToByte(k));
        }
        return result;
      }
    });
  }

  /**
   * 添加key value 并且设置存活时间(byte)
   * 
   * @param key
   * @param value
   * @param liveTime
   */
  public void set(final byte[] key, final byte[] value, final int liveTime) {
    redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        connection.set(key, value);
        if (liveTime > 0) {
          connection.expire(key, liveTime);
        }
        return 1L;
      }
    });

  }

  /**
   * 添加key value 并且设置存活时间
   * 
   * @param key
   * @param value
   * @param liveTime 单位秒
   */
  public void set(String key, String value, int liveTime) {
    this.set(strToByte(key), strToByte(value), liveTime);

  }

  /**
   * 添加key value
   * 
   * @param key
   * @param value
   */
  public void set(String key, String value) {
    this.set(key, value, 0);
  }

  /**
   * 添加key value (字节)(序列化)
   * 
   * @param key
   * @param value
   */
  public void set(byte[] key, byte[] value) {
    this.set(key, value, 0);
  }

  /**
   * 获取redis value (String)
   * 
   * @param key
   * @return
   */
  public String get(final String key) {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        byte[] result = connection.get(strToByte(key));
        if (result != null) {
          try {
            return new String(result, StandardCharsets.UTF_8.toString());
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return "";
      }
    });
  }

  /**
   * 获取redis value (byte[])
   * 
   * @param key
   * @return
   */
  public byte[] get(final byte[] key) {
    return redisTemplate.execute(new RedisCallback<byte[]>() {
      public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
        byte[] result = connection.get(key);
        return result;
      }
    });
  }

  /**
   * 如果key不存在添加key value 并且设置存活时间(byte)，当key已经存在时，就不做任何操作
   * 
   * @param key
   * @param value
   * @param liveTime
   */
  public long setnx(final byte[] key, final byte[] value, final int liveTime) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0l;
        boolean isSuccess = connection.setNX(key, value);
        if (isSuccess) {
          if (liveTime > 0) {
            connection.expire(key, liveTime);
          }
          result = 1l;
        }
        return result;
      }
    });
  }

  /**
   * 如果key不存在添加key value 并且设置存活时间，当key已经存在时，就不做任何操作
   * 
   * @param key
   * @param value
   * @param liveTime 单位秒
   */
  public long setnx(String key, String value, int liveTime) {
    return this.setnx(strToByte(key), strToByte(value), liveTime);

  }

  /**
   * 如果key不存在添加key value，当key已经存在时，就不做任何操作
   * 
   * @param key
   * @param value
   */
  public long setnx(String key, String value) {
    return this.setnx(key, value, 0);
  }

  /**
   * 如果key不存在添加key value (字节)(序列化)，当key已经存在时，就不做任何操作
   * 
   * @param key
   * @param value
   */
  public long setnx(byte[] key, byte[] value) {
    return this.setnx(key, value, 0);

  }

  /**
   * 通过正则匹配keys
   * 
   * @param pattern
   * @return
   */
  public Set<String> keys(final String pattern) {
    return redisTemplate.execute(new RedisCallback<Set<String>>() {
      public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {
        Set<String> result = new HashSet<String>();
        Set<byte[]> data = connection.keys(strToByte(pattern));
        for (byte[] d : data) {
          try {
            result.add(new String(d, StandardCharsets.UTF_8.toString()));
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return result;
      }
    });
  }

  /**
   * 检查key是否已经存在
   * 
   * @param key
   * @return
   */
  public boolean exists(final String key) {
    return redisTemplate.execute(new RedisCallback<Boolean>() {
      public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.exists(strToByte(key));
      }

    });
  }

  /**
   * 清空redis 所有数据
   * 
   * @return
   */
  public String flushDB() {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        connection.flushDb();
        return "success";
      }
    });
  }

  /**
   * 查看redis里有多少数据
   */
  public long dbSize() {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.dbSize();
      }
    });
  }

  /**
   * 检查是否连接成功
   * 
   * @return
   */
  public String ping() {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.ping();
      }
    });
  }

  /**
   * 设置key的生命周期
   * 
   * @param key
   * @param seconds 单位(秒)
   * @return
   */
  public boolean expire(final String key, final int seconds) {
    return redisTemplate.execute(new RedisCallback<Boolean>() {
      public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.expire(strToByte(key), seconds);
      }
    });
  }

  /**
   * 自增长
   * 
   * @param key
   * @return
   */
  public long incr(final String key) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.incr(strToByte(key));
      }

    });
  }

  /**
   * 自增长
   * 
   * @param key
   * @param len 增长步长
   * @return
   */
  public long incrBy(final String key, final long len) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.incrBy(strToByte(key), len);
      }
    });

  }

  /**
   * 自增长
   * 
   * @param key
   * @param len 增长步长
   * @return
   */
  public double incrBy(final String key, final double len) {
    return redisTemplate.execute(new RedisCallback<Double>() {
      public Double doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.incrBy(strToByte(key), len);
      }
    });
  }

  public Object eval(final String luaCommand) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.eval(strToByte(luaCommand), null, 0);
      }
    });
  }

  /**
   * 添加key 哈希表
   * 
   * @param key
   * @param map
   * @throws UnsupportedEncodingException
   */
  public void hMSet(String key, Map<String, String> map) {
    this.hMSet(key, map, 0);
  }

  /**
   * 添加key 哈希表 并且设置存活时间
   * 
   * @param key
   * @param map
   * @param liveTime
   * @throws UnsupportedEncodingException
   */
  public void hMSet(String key, Map<String, String> map, int liveTime) {
    Map<byte[], byte[]> hashes = new LinkedHashMap<byte[], byte[]>();
    for (Entry<String, String> entry : map.entrySet()) {
      hashes.put(strToByte(entry.getKey()), strToByte(entry.getValue()));
    }
    this.hMSet(strToByte(key), hashes, liveTime);
  }

  /**
   * 添加key hashes 并且设置存活时间(byte)
   * 
   * @param key
   * @param hashes 哈希表
   * @param liveTime
   */
  public void hMSet(final byte[] key, Map<byte[], byte[]> hashes, final int liveTime) {
    redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        connection.hMSet(key, hashes);
        if (liveTime > 0) {
          connection.expire(key, liveTime);
        }
        return 1L;
      }
    });

  }

  /**
   * 获取redis value (Map<String, String>)
   * 
   * @param key
   * @return
   */
  public Map<String, String> hMGet(final String key) {
    return redisTemplate.execute(new RedisCallback<Map<String, String>>() {
      public Map<String, String> doInRedis(RedisConnection connection) throws DataAccessException {
        Map<byte[], byte[]> result = connection.hGetAll(strToByte(key));
        Map<String, String> hashes = new LinkedHashMap<String, String>();
        if (result != null && !result.isEmpty()) {
          try {
            for (Entry<byte[], byte[]> entry : result.entrySet()) {
              hashes.put(new String(entry.getKey(), StandardCharsets.UTF_8.toString()), new String(entry.getValue(),
                  StandardCharsets.UTF_8.toString()));
            }
            return hashes;
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return hashes;
      }
    });
  }

  /**
   * 添加到set
   * 
   * @param key
   * @param values
   * @return
   */
  public long sadd(String key, String... values) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0;
        for (String v : values) {
          result += connection.sAdd(strToByte(key), strToByte(v));
        }
        return result;
      }
    });
  }

  /**
   * 从set中取值
   * 
   * @param key
   * @return
   */
  public String spop(final String key) {
    return redisTemplate.execute(new RedisCallback<String>() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        byte[] result = connection.sPop(strToByte(key));
        if (result != null) {
          try {
            return new String(result, StandardCharsets.UTF_8.toString());
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
        return "";
      }
    });
  }

  public long scard(final String key) {
    return redisTemplate.execute(new RedisCallback<Long>() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.sCard(strToByte(key));
      }
    });
  }

  public boolean sismember(final String key, final String value) {
    return redisTemplate.execute(new RedisCallback<Boolean>() {
      @Override
      public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.sIsMember(strToByte(key), strToByte(value));
      }
    });
  }

  @Override
  public void srem(String key, String value) {
    redisTemplate.execute(new RedisCallback<Void>() {
      @Override
      public Void doInRedis(RedisConnection connection) throws DataAccessException {
        connection.sRem(strToByte(key), strToByte(value));
        return null;
      }
    });
  }

}
