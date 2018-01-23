import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author zhugr
 *
 */
public class Jredis1 {

	final static String HOST = "10.149.252.106";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Jedis jedis = Jredis1.getInstance();
		Jedis jedis = RedisUtil.getJedis();
		//是否连接
		System.out.println("ping : " + jedis.ping());
		
		//字符串
		jedis.set("name", "hello");
		String out = jedis.get("name");
		System.out.println(out);
		
		//列表
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");   
        jedis.lpush("site-list", "baidu");
        //取出
        List<String> list = jedis.lrange("site-list", 0, 3);
        for(String v : list){
        	System.out.println(v);
        }
        //keys 实例
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext())
        {
        	String key = iterator.next();
        	System.err.println("key : " + key);
        }
        RedisUtil.returnResource(jedis);
	}
	public static Jedis getInstance(){
		Jedis jedis = new Jedis(HOST);
		jedis.auth("123");
		return jedis;
	}
}
