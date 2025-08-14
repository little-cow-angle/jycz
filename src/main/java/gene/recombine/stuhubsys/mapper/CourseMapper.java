package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

/**
* @author ShiRyant
* @description 针对表【course】的数据库操作Mapper
* @createDate 2025-08-14 10:28:02
* @Entity gene.recombine.stuhubsys.entity.Course
*/
public interface CourseMapper extends BaseMapper<Course> {
    CourseVO selectCourseWithTeacher(long id);
    IPage<CourseVO> getCourseListPage(IPage<CourseVO> page, @Param("ew")LambdaQueryWrapper<CourseVO> queryWrapper);
}




