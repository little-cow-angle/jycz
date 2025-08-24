package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.StudentDTO;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.service.StudentService;
import gene.recombine.stuhubsys.mapper.StudentMapper;
import gene.recombine.stuhubsys.vo.StudentVO;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage<StudentVO> getStudentPages(StudentDTO studentDTO) {
        IPage<StudentVO> page = new Page<>(studentDTO.getPageNo(), studentDTO.getPageSize());
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper
            .like(StringUtils.isNotBlank(studentDTO.getStudentName()), "student_name", studentDTO.getStudentName())
            .like(StringUtils.isNotBlank(studentDTO.getStudentAddress()), "student_address", studentDTO.getStudentAddress())
            .eq(null != studentDTO.getCollegeId(), "college_id", studentDTO.getCollegeId())
            .eq(null != studentDTO.getMajorId(), "major_id", studentDTO.getMajorId());
        return baseMapper.getStudentPages(page, wrapper);
    }

    @Override
    public StudentVO getStudentById(Long id) {
        return studentMapper.selectStudentById(id);
    }
}




