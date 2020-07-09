package org.scau.mall.service.config.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {

    /**
     * 从指定的列表右边出队,添加到目的列表中
     * 
     * @param srckey 源列表
     * @param dstkey 　目的列表
     * @return
     */
    public String rpoppush(final String srckey, final String dstkey);

    /**
     * 获取指定列表的范围数据
     * 
     * @param key 　列表名
     * @param start 　开始位置
     * @param end 　结束位置
     * @return
     */
    public List<String> lrange(final String key, final int start, final int end);

    /**
     * 从队列的左边取出一条数据
     * 
     * @param key 　列表名
     * @return
     */
    public String lpop(final String key);
    
    /**
     * 从队列的左边取出一条数据--阻塞式
     * 
     * @param key 　列表名
     * @return
     */
    public List<String> blpop(final int timeout,final String key);

    /**
     * 从列表右边添加数据
     * 
     * @param key 列表名
     * @param values 数据
     * @return
     */
    public long rpush(String key, String... values);

    /**
     * 从列表右边添加数据,并且设置列表的存活时间
     * 
     * @param key 列表名
     * @param liveTime 存活时间(单位 秒)
     * @param values 数据
     * @return
     */
    public long rpush(final String key, final int liveTime, final String... values);

    /**
     * 从队列的右边取出一条数据
     * 
     * @param key 列表名
     * @return
     */
    public String rpop(final String key);

    /**
     * 把一个值添加到对应列表中
     * 
     * @param key 列表名
     * @param index 　添加的位置
     * @param value 　数据
     * @return
     */
    public String lset(final String key, final long index, final String value);

    /**
     * 把所有数据添加到一个列表中
     * 
     * @param key 列表名
     * @param values 　数据
     * @return
     */
    public long lpush(String key, String... values);

    /**
     * 把所有数据添加到一个列表中,并且设置列表的存活时间
     * 
     * @param key 列表名
     * @param values 数据
     * @param liveTime 存活时间--单位(秒)
     * @return
     */
    public long lpush(final String key, final int liveTime, final String... values);

    /**
     * 返回列表的长度
     * 
     * @param key
     * @return
     */
    public long llen(final String key);
    /**
     * 删除列表中对应值的元素
     * 
     * @param key 列表名
     * @param count 删除多少个相同的元素
     * @param value 数据
     * @return
     */
    public long lrem(final String key, final long count, final String value);
    /**
     * 通过key删除
     * 
     * @param key
     */
    public long del(final String... keys);

    /**
     * 添加key value 并且设置存活时间(byte)
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(final byte[] key, final byte[] value, final int liveTime);

    /**
     * 添加key value 并且设置存活时间
     * 
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    public void set(String key, String value, int liveTime);

    /**
     * 添加key value
     * 
     * @param key
     * @param value
     */
    public void set(String key, String value);

    /**
     * 添加key value (字节)(序列化)
     * 
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value);
    /**
     * 获取redis value (String)
     * 
     * @param key
     * @return
     */
    public String get(final String key);

    /**
     * 获取redis value (byte[])
     * 
     * @param key
     * @return
     */
    public byte[] get(final byte[] key);

    /**
     * 如果key不存在添加key value 并且设置存活时间(byte)，当key已经存在时，就不做任何操作
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public long setnx(final byte[] key, final byte[] value, final int liveTime);

    /**
     * 如果key不存在添加key value 并且设置存活时间，当key已经存在时，就不做任何操作
     * 
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    public long setnx(String key, String value, int liveTime);

    /**
     * 如果key不存在添加key value，当key已经存在时，就不做任何操作
     * 
     * @param key
     * @param value
     */
    public long setnx(String key, String value);

    /**
     * 如果key不存在添加key value (字节)(序列化)，当key已经存在时，就不做任何操作
     * 
     * @param key
     * @param value
     */
    public long setnx(byte[] key, byte[] value);

    /**
     * 通过正则匹配keys
     * 
     * @param pattern
     * @return
     */
    public Set<String> keys(final String pattern);

    /**
     * 检查key是否已经存在
     * 
     * @param key
     * @return
     */
    public boolean exists(final String key);

    /**
     * 清空redis 所有数据
     * 
     * @return
     */
    public String flushDB();

    /**
     * 查看redis里有多少数据
     */
    public long dbSize();

    /**
     * 检查是否连接成功
     * 
     * @return
     */
    public String ping();

    /**
     * 设置key的生命周期
     * 
     * @param key
     * @param seconds 单位(秒)
     * @return
     */
    public boolean expire(final String key, final int seconds);

    /**
     * 自增长
     * 
     * @param key
     * @param length 增长步长
     * @return
     */
    public long incr(final String key);

    /**
     * 自增长
     * 
     * @param key
     * @param length 增长步长
     * @return
     */
    public long incrBy(final String key, final long len);

    /**
     * 自增长
     * 
     * @param key
     * @param length 增长步长
     * @return
     */
    public double incrBy(final String key, final double len);

    public Object eval(final String luaCommand);

    /**
     * 添加key 哈希表
     * 
     * @param key
     * @param map
     */
    public void hMSet(String key, Map<String, String> hashes);

    /**
     * 添加key 哈希表 并且设置存活时间
     * 
     * @param key
     * @param map
     * @param liveTime
     */
    public void hMSet(String key, Map<String, String> hashes, int liveTime);

    /**
     * 添加key hashes 并且设置存活时间(byte)
     * 
     * @param key
     * @param hashes 哈希表
     * @param liveTime
     */
    public void hMSet(final byte[] key, Map<byte[], byte[]> hashes, final int liveTime);

    /**
     * 获取redis value (Map<String, String>)
     * 
     * @param key
     * @return
     */
    public Map<String, String> hMGet(final String key);

    /**
     * 添加到set
     * 
     * @param key
     * @param values
     * @return
     */
    public long sadd(String key, String... values);

    /**
     * 从set中取值
     * 
     * @param key
     * @return
     */
    public String spop(final String key);

    /**
     * 从set中删除
     * 
     * @param key
     * @param member
     */
    public void srem(final String key, final String value);

    /**
     * 统计数量
     * 
     * @param key
     * @return
     */
    public long scard(final String key);

    /**
     * 是否存在
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean sismember(final String key, final String value);


}
