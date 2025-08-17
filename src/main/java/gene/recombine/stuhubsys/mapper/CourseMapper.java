package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper extends BaseMapper<Course> {
    CourseVO selectCourseById(long id);
    IPage<CourseVO> getCourseListPage(IPage<CourseVO> page, @Param("ew") QueryWrapper<Course> queryWrapper);
    int updateCourseTextbookId(@Param("courseId") long courseId, @Param("textbookId") long textbookId);
}




