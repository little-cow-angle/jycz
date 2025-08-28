package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.dto.StudentDTO;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.service.StudentService;
import gene.recombine.stuhubsys.mapper.StudentMapper;
import gene.recombine.stuhubsys.vo.StudentDormVO;
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
    public IPage<StudentDormVO> getStudentDormVOs(DormitoryDTO dormitoryDTO) {
        IPage<Student> page = new Page<>(dormitoryDTO.getPageNo(), dormitoryDTO.getPageSize());
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        if (dormitoryDTO.getPark() != null && !dormitoryDTO.getPark().isEmpty()) {
            queryWrapper.eq("d.park", dormitoryDTO.getPark());
        }
        if (dormitoryDTO.getBuilding() != null && !dormitoryDTO.getBuilding().isEmpty()) {
            queryWrapper.eq("d.building", dormitoryDTO.getBuilding());
        }
        if (dormitoryDTO.getFloor() != null) {
            queryWrapper.eq("d.floor", dormitoryDTO.getFloor());
        }
        if (dormitoryDTO.getDormNumber() != null) {
            queryWrapper.eq("d.dorm_number", dormitoryDTO.getDormNumber());
        }
        if (dormitoryDTO.getStudentName() != null && !dormitoryDTO.getStudentName().isEmpty()) {
            queryWrapper.like("s.student_name", dormitoryDTO.getStudentName());
        }
        if (dormitoryDTO.getStudentId() != null && !dormitoryDTO.getStudentId().isEmpty()) {
            queryWrapper.eq("s.student_id", dormitoryDTO.getStudentId());
        }
        if (dormitoryDTO.getCollegeId() != null) {
            queryWrapper.eq("c.id", dormitoryDTO.getCollegeId());
        }
        if (dormitoryDTO.getMajorId() != null) {
            queryWrapper.eq("m.major_id", dormitoryDTO.getMajorId());
        }

        queryWrapper.orderByAsc("s.student_id");
        return studentMapper.selectStudentDormPage(page, queryWrapper);
    }


    @Override
    public StudentVO getStudentById(Long id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public void setStudentBedNumber(StudentDTO studentDTO) {
        Student student = studentMapper.selectById(studentDTO.getStudentId());
        int count = studentMapper.countBedNumber(student.getStudentId(), student.getDormId(), studentDTO.getBedNumber());
        if (count > 0) {
            throw new AppException(AppExceptionMsg.TRANSACTION_BED_NUMBER_HAS_EXISTED);
        }
        studentMapper.setBedNumber(studentDTO);
    }
}