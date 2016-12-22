package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 封装redis数据访问操作
 */
public class RedisDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JedisPool jedisPool;//连接池

    public RedisDao(String ip,int port){
        jedisPool = new JedisPool(ip,port);
    }

    //需要缓存 的数据结构,用于生成scheme校验
    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public Seckill getSeckill(int seckillId){
        //redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:"+seckillId;
                //radis没有实现内部序列化操作
                //get得到的是byte[]，因此要反序列化得到Object(Seckill)
                //采用自定义序列化  protostuff目前效率最高  protostuff:pojo
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes!=null){
                    //缓存中获取到
                    Seckill seckill = schema.newMessage();   //空对象
                    ProtostuffIOUtil.mergeFrom(bytes,seckill,schema);   //seckill被反序列
                    return seckill;
                }
            }
            finally {
                jedis.close();
            }
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill){
    	//object-->序列化-->byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:"+seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, 
                		LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));//缓存器
                //setex 超时缓存 单位秒
                int timeout = 60 * 60;  //一个小时
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            }
            finally {
                jedis.close();
            }
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

}
