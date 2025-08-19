package gene.recombine.stuhubsys.utils;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Getter
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final Random random = new Random();
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value,300+random.nextInt(100), TimeUnit.SECONDS);
    }
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    public void setObject(String key, Object value) {
        String json= JSON.toJSONString(value);
        setString(key, json);
    }
    public <T> T getObject(String key, Class<T> clazz) {
        String s = stringRedisTemplate.opsForValue().get(key);
        return JSON.parseObject(s, clazz);
    }
}
