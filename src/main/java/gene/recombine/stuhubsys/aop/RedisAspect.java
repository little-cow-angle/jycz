package gene.recombine.stuhubsys.aop;

import com.alibaba.fastjson.JSON;

import gene.recombine.stuhubsys.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Base64;
@Component
@Aspect

public class RedisAspect {
    @Autowired
    private RedisUtils redisUtils;
    @Around("@annotation(gene.recombine.stuhubsys.aop.RedisByteBase64Storage)")
    public ResponseEntity<byte[]> byteBase64Storage(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = getKey(joinPoint);
        String base64Data = redisUtils.getString(key);
        byte[] decode;
        if(base64Data!=null&& !base64Data.isEmpty()){
            decode = Base64.getDecoder().decode(base64Data);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.txt")
                    .body(decode);
        }
        ResponseEntity<byte[]> result = (ResponseEntity<byte[]>)joinPoint.proceed();
        decode = result.getBody();
        if(decode!=null&& decode.length>0){
            base64Data = Base64.getEncoder().encodeToString(decode);
            redisUtils.setString(key,base64Data);
        }
        return result;
    }
    @Around("@annotation(gene.recombine.stuhubsys.aop.RedisStringStorage)")
    public String byteStringStorage(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = getKey(joinPoint);
        String comment = redisUtils.getString(key);
        if(comment!=null&& !comment.isEmpty()){
            return comment;
        }
        String result = (String) joinPoint.proceed();
        if(result!=null&& !result.isEmpty()){
            redisUtils.setString(key,result);
        }
        return result;
    }
    @Around("@annotation(gene.recombine.stuhubsys.aop.RedisObjectStorage)")
    public Object JsonStringStorage(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = getKey(joinPoint);
        String JSONString = redisUtils.getString(key);
        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法声明的返回类型（Class）
        Class<?> returnType = signature.getReturnType();

        if(JSONString!=null&& !JSONString.isEmpty()){
            return JSON.parseObject(JSONString,returnType);
        }
        Object result = joinPoint.proceed();
        if(result!=null){
            redisUtils.setString(key,JSON.toJSONString(result));
        }
        return result;
    }
    private static String getKey(ProceedingJoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder(joinPoint.getSignature().getName());
        sb.append(":");
        for (Object arg : joinPoint.getArgs()) {
            sb.append(arg.toString());
        }
        String key =sb.append(":").toString();
        return key;
    }
}
