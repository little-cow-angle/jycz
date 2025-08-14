package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.CourseDTO;
import gene.recombine.stuhubsys.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.vo.CourseVO;

/**
* @author ShiRyant
* @description 针对表【course】的数据库操作Service
* @createDate 2025-08-14 10:28:02
*/
public interface CourseService extends IService<Course> {
    CourseVO findCourseById(long id);
    IPage<CourseVO> getCourseVOListPage(CourseDTO courseDTO);
}
