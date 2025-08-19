package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.dto.AuthLoginDTO;
import gene.recombine.stuhubsys.dto.UserDTO;
import gene.recombine.stuhubsys.vo.CourseVO;

public interface AuthService {
    CourseVO findCourseById(long id);

    String login(AuthLoginDTO auth);

    UserDTO getInfo();

    void setInfo(UserDTO user);
}
