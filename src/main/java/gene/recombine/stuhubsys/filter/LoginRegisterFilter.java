package gene.recombine.stuhubsys.filter;

import com.alibaba.fastjson.JSONObject;

import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.utils.JWTUtils;
import gene.recombine.stuhubsys.utils.UserContext;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class LoginRegisterFilter implements Filter {

    @Override
    public void destroy() {
        UserContext.clear();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url= request.getRequestURI();
        log.info("url:{}",url);
        if(
//                url.toLowerCase().contains("doc")||
//                url.toLowerCase().contains("favicon")||
//                url.toLowerCase().contains("login")||
//                url.toLowerCase().contains("webjars")
                true
                ){
            log.info("登录或注册请求请求，放行");
            filterChain.doFilter(request, response);
            return;
        }
        String jwt=request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("令牌不存在");
            CommonResult err= CommonResult.error(new AppException(AppExceptionMsg.AUTH_NOT_LOGIN));
            response.getWriter().write(JSONObject.toJSONString(err));
            return;
        }
        try {
            //TODO 将token中的用户信息存到ThreadLocal中
            Claims claims = JWTUtils.ParseJWT(jwt);
            if(claims==null){
                log.info("令牌不合法");
                CommonResult err=CommonResult.error(new AppException(AppExceptionMsg.AUTH_NOT_LOGIN));
                response.getWriter().write(JSONObject.toJSONString(err));
                return;
            }
            log.info("解析成功");
            String username=claims.get("username",String.class);
            Integer userId=claims.get("userId",Integer.class);
            Integer character=claims.get("character",Integer.class);
            log.info("username:{},userId:{},character:{}",username,userId,character);
            UserContext.set("username",username);
            UserContext.set("userId",userId);
            UserContext.set("character",character);

        }catch (Exception e){
            log.info("令牌不合法");
            CommonResult err=CommonResult.error(new AppException(AppExceptionMsg.AUTH_NOT_LOGIN));
            response.getWriter().write(JSONObject.toJSONString(err));
            return;
        }
        log.info("令牌合法");

        filterChain.doFilter(request, response);
    }

}
