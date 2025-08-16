package gene.recombine.stuhubsys.filter;

import com.alibaba.fastjson.JSONObject;

import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.entity.Teacher;
import gene.recombine.stuhubsys.mapper.AuthMapper;
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

@Slf4j
@Component
public class AuthorityFilter implements MyFilter {
    @Autowired
    private AuthMapper authMapper;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("我是权限控制过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url= request.getRequestURI();
        log.info("url:{}",url);
        String method=request.getMethod();
        //TODO 在这里添加老师相关的方法接口的路径
        if(url.toLowerCase().contains("test/auth")


        ){
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
        String id=(String) UserContext.get("userId");
        String name=(String) UserContext.get("username");
        Teacher admin=authMapper.getAdmin(id,name);
        return admin != null;
    }
}
