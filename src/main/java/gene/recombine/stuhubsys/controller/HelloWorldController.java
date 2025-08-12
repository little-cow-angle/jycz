package gene.recombine.stuhubsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloWorldController {

    @Autowired
    StringRedisTemplate redisTemplate;
    public static String token = UUID.randomUUID().toString();

    /**
     * 第一个接口
     */
    @RequestMapping("hello")
    public String helloWorld(){
        //保存用户登录的Token
        redisTemplate.opsForValue().set("Token::" + token, token + "保存的用户信息", 2000, TimeUnit.SECONDS);
        return "helloWorld";
    }

    /**
     * 第二个接口
     * @return 保存的token值
     */
    @RequestMapping("getRedisValue")
    public String getRedisValue(){
        return redisTemplate.opsForValue().get("Token::" + token);
    }
}
