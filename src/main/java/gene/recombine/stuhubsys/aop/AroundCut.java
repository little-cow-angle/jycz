package gene.recombine.stuhubsys.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AroundCut {
    @Autowired
    StringRedisTemplate redisTemplate;

    public static final String POINT_CUT = "execution(* gene.recombine.springboot.controller.StudentController.*(..)) || " +
            "execution(* gene.recombine.springboot.controller.GradeController.*(..))";


//    @Around(AroundCut.POINT_CUT)
//    public CommonResult checkToken(ProceedingJoinPoint pjp) throws Throwable {
//        //获取token
//        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Token");
//        System.out.println("Token: " + token);
//        //验证
//        String userInfoString = redisTemplate.opsForValue().get("Token::" + token);
//        if(StringUtils.isBlank(userInfoString)){//token失效
//            return CommonResult.error(GlobalErrorCodeConstants.UNAUTHORIZED);
//        }
//        return (CommonResult) pjp.proceed();
//    }
}

