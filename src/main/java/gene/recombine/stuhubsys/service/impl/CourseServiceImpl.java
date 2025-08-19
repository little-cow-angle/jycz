package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.CourseAddDTO;
import gene.recombine.stuhubsys.dto.CourseDTO;
import gene.recombine.stuhubsys.entity.Course;
import gene.recombine.stuhubsys.entity.Textbook;
import gene.recombine.stuhubsys.mapper.TextbookMapper;
import gene.recombine.stuhubsys.service.CourseService;
import gene.recombine.stuhubsys.mapper.CourseMapper;
import gene.recombine.stuhubsys.vo.CourseVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    @Resource
    private CourseMapper courseMapper;
    @Resource
    private TextbookMapper textbookMapper;

    @Override
    public CourseVO findCourseById(long id) {
        return courseMapper.selectCourseById(id);
    }

    @Override
    @Transactional
    public int saveCourse(CourseAddDTO courseAddDTO) {
        if (courseAddDTO.getTextbook() != null) {
            textbookMapper.insert(courseAddDTO.getTextbook());
        }
        int affectedRows = courseMapper.insertCourse(courseAddDTO);
        Long courseId = courseAddDTO.getCourseId();

        if (courseId != null && courseAddDTO.getTextbook() != null) {
            Textbook textbook = courseAddDTO.getTextbook();
            textbook.setCourseId(courseId);
            textbookMapper.updateById(textbook);
        }
        return affectedRows;
    }

    @Override
    public IPage<CourseVO> getCourseVOListPage(CourseDTO courseDTO) {
        IPage<CourseVO> page = new Page<>(courseDTO.getPageNo(), courseDTO.getPageSize());
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper
            .like(StringUtils.isNotBlank(courseDTO.getCourseName()), "course_name", courseDTO.getCourseName())
            .like(StringUtils.isNotBlank(courseDTO.getTeacherName()), "t.name", courseDTO.getTeacherName())
            .like(StringUtils.isNotBlank(courseDTO.getMajorName()), "m.major_name", courseDTO.getMajorName())
            .eq(null != courseDTO.getCourseType(), "course_type", courseDTO.getCourseType())
            .eq(null != courseDTO.getMajorId(), "m.major_id", courseDTO.getMajorId());
        return baseMapper.getCourseListPage(page, wrapper);
    }

}




