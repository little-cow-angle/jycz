package gene.recombine.stuhubsys.filter;

import com.alibaba.fastjson.JSONObject;

import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.utils.UserContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Slf4j
@Component
public class AuthorityFilter implements MyFilter {
    @Autowired
    private ApplicationContext context;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("我是权限控制过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url= request.getRequestURI();
        log.info("url:{}",url);
        String method=request.getMethod();
        if(false){
            log.info("管理员方法");
            if(isAdmin()){
                filterChain.doFilter(request, response);
                log.info("放行");
                return;
            }
            log.info("权限不足");
            CommonResult err= CommonResult.error(new AppException(AppExceptionMsg.AUTH_ADMIN_NOT_MATCHED));
            response.getWriter().write(JSONObject.toJSONString(err));
            return;
        }
        log.info("非管理员方法");
        log.info(String.valueOf(Thread.currentThread().getId()));
        filterChain.doFilter(request, response);
    }

    private boolean isAdmin() {

        return true;
    }
}
