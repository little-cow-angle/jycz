package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.dto.AuthLoginDto;
import gene.recombine.stuhubsys.mapper.AuthMapper;
import gene.recombine.stuhubsys.service.AuthService;
import gene.recombine.stuhubsys.utils.JWTUtils;
import gene.recombine.stuhubsys.vo.AuthInfo;
import gene.recombine.stuhubsys.vo.CourseVO;
import gene.recombine.stuhubsys.vo.Person;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Resource
    AuthMapper authMapper;
    @Override
    public CourseVO findCourseById(long id) {
        return null;
    }

    @Override
    public String login(AuthLoginDto auth) {
        Map<String, String> result = authMapper.login(auth.getId(), auth.getPassword());

        if (result == null) {
            throw new AppException(AppExceptionMsg.AUTH_PASSWORD_ERROR);
        }
        if(result.size() != 1) {
            throw new AppException(AppExceptionMsg.AUTH_PASSWORD_ERROR);
        }

        String[] info = new String[0];
        for (String s : result.keySet()) {
             info = result.get(s).split(":");
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", info[0]);
        map.put("username", info[1]);
        map.put("character", info[2]);
        log.info("登录成功");
        return JWTUtils.GenerateJWTCode(map);
    }
}
