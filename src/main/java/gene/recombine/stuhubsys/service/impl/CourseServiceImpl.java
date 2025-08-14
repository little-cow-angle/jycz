package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.CourseDTO;
import gene.recombine.stuhubsys.entity.Course;
import gene.recombine.stuhubsys.service.CourseService;
import gene.recombine.stuhubsys.mapper.CourseMapper;
import gene.recombine.stuhubsys.vo.CourseVO;
import gene.recombine.stuhubsys.entity.Teacher;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author ShiRyant
* @description 针对表【course】的数据库操作Service实现
* @createDate 2025-08-14 10:28:02
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    @Resource
    private CourseMapper courseMapper;
    @Override
    public CourseVO findCourseById(long id) {
        return courseMapper.selectCourseWithTeacher(id);
    }

    @Override
    public IPage<CourseVO> getCourseVOListPage(CourseDTO courseDTO) {
        IPage<CourseVO> page = new Page<>(courseDTO.getPageNo(), courseDTO.getPageSize());
        LambdaQueryWrapper<CourseVO> wrapper = new LambdaQueryWrapper<>();
        wrapper
            .like(StringUtils.isNotBlank(courseDTO.getCourseName()), CourseVO::getCourseName, courseDTO.getCourseName())
            .like(StringUtils.isNotBlank(courseDTO.getTeacherName()), CourseVO::getTeacherName, courseDTO.getTeacherName())
            .eq(null != courseDTO.getCourseType(), CourseVO::getCourseType, courseDTO.getCourseType());
        return baseMapper.getCourseListPage(page, wrapper);
    }
}




