package gene.recombine.stuhubsys.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


// test
@Tag(name = "测试接口", description = "测试接口")
@RestController
public class HelloWorldController {
    @Autowired
    StringRedisTemplate redisTemplate;
    public static String token = UUID.randomUUID().toString();
    /**
     * 第一个接口
     */
    @GetMapping("hello")
    public String helloWorld(){
        //保存用户登录的Token
        redisTemplate.opsForValue().set("Token::" + token, token + "保存的用户信息", 2000, TimeUnit.SECONDS);
        return "helloWorld";
    }
    /**
     * 第二个接口
     * @return 保存的token值
     */
    @GetMapping("getRedisValue")
    public String getRedisValue(){
        return redisTemplate.opsForValue().get("Token::" + token);
    }
}
