package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.dto.AuthLoginDto;
import gene.recombine.stuhubsys.vo.CourseVO;

public interface AuthService {
    CourseVO findCourseById(long id);

    String login(AuthLoginDto auth);
}
