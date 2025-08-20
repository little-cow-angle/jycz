package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.dto.AuthLoginDTO;
import gene.recombine.stuhubsys.dto.UserDTO;
import gene.recombine.stuhubsys.entity.Teacher;
import gene.recombine.stuhubsys.mapper.AuthMapper;
import gene.recombine.stuhubsys.service.AuthService;
import gene.recombine.stuhubsys.service.MenuService;
import gene.recombine.stuhubsys.utils.JWTUtils;
import gene.recombine.stuhubsys.utils.UserContext;
import gene.recombine.stuhubsys.vo.CourseVO;
import gene.recombine.stuhubsys.vo.LoginUserVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Resource
    AuthMapper authMapper;
    @Autowired
    MenuService menuService;

    @Override
    public CourseVO findCourseById(long id) {
        return null;
    }

    @Override
    public LoginUserVO login(AuthLoginDTO auth) {
        Map<String, String> result = authMapper.login(auth.getId(),auth.getPassword());

        if (result == null || result.size() != 1) {
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

        LoginUserVO loginUserVO = new LoginUserVO();
        loginUserVO.setUserId(Long.parseLong(info[0]));
        loginUserVO.setUsername(info[1]);
        loginUserVO.setUserType(info[2]);
        loginUserVO.setToken(JWTUtils.GenerateJWTCode(map));
        loginUserVO.setMenus(menuService.getMenuByUserType(info[2]));

        return loginUserVO;
    }

    @Override
    public UserDTO getInfo() {
        String id = (String)UserContext.get("userId");
        String name = (String)UserContext.get("username");
        return authMapper.getInfo(id,name);
    }

    @Override
    public void setInfo(UserDTO user) {
        boolean flag = isAdmin();
        authMapper.setInfo(
                flag,
                user.getEntryDate(), // 入学年份
                (String)UserContext.get("userId"),
                user.getSex(), // 性别
                user.getBirth(), // 生日
                user.getGaoKaoId(), // 高考证号
                user.getGaoKao(), // 高考成绩
                user.getPhone(), // 电话
                user.getEmail(), // 邮箱
                user.getMajor(), // 专业
                user.getCollegeName(), // 所属学院
                user.getWorkAddress(), // 办公室地址
                user.getPosition() // 职位
        );
    }

    private boolean isAdmin() {
        String id = (String) UserContext.get("userId");
        String name = (String) UserContext.get("username");
        Teacher admin = authMapper.getAdmin(id,name);
        return admin != null;
    }
}
