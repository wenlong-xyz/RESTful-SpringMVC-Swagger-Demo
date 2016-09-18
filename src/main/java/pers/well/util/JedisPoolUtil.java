package pers.well.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 多线程情况下 使用JedisTool实现Jedis对象的创建与销毁
 *
 * ！！！已经使用被 RedisTemplate 替代
 * @author wenlong
 *
 */
@Deprecated
public class JedisPoolUtil {
	private static JedisPool jedisPool;
	//最大连接数
	private static final int MAX_CONNECT_NUM = 100;
	//最长阻塞时间,单位是毫秒
	private static final int MAX_BLOCK_TIME = 1000;
	//最大空闲连接数
	private static final int MAX_IDLE_NUM = 10;
	private static String IP = "10.109.247.82";
	private static int PORT = 6379;
	
	/**
	 * 建立连接池
	 */
	private static void createJedisPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(MAX_CONNECT_NUM);
		config.setMaxWaitMillis(MAX_BLOCK_TIME);
		config.setMaxIdle(MAX_IDLE_NUM);
		
		jedisPool = new JedisPool(config, IP, PORT);
	}
	
	/**
	 * 初始化JedisPool
	 */
	private static synchronized void poolInit(){
		if(jedisPool == null){
			createJedisPool();
		}
	}
	
	/**
	 * 获得Jedis实例
	 * @return
	 */
	public static Jedis getJedis(){
		if(jedisPool == null){
			poolInit();
		}
		return jedisPool.getResource();
	}
	
	/**
	 * 归还Jedis实例
	 * @param jedis
	 */
	public static void returnJedis(Jedis jedis){
		jedisPool.returnResource(jedis);
	}
}