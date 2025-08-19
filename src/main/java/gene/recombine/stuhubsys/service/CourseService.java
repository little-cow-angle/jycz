package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.CourseAddDTO;
import gene.recombine.stuhubsys.dto.CourseDTO;
import gene.recombine.stuhubsys.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.vo.CourseVO;

public interface CourseService extends IService<Course> {
    CourseVO findCourseById(long id);
    int saveCourse(CourseAddDTO courseAddDTO);
    IPage<CourseVO> getCourseVOListPage(CourseDTO courseDTO);
}
