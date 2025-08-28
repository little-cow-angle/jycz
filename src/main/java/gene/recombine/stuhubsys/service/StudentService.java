package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.dto.StudentDTO;
import gene.recombine.stuhubsys.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.vo.StudentDormVO;
import gene.recombine.stuhubsys.vo.StudentVO;

public interface StudentService extends IService<Student> {
    IPage<StudentVO> getStudentPages(StudentDTO studentDTO);
    IPage<StudentDormVO> getStudentDormVOs(DormitoryDTO dormitoryDTO);
    StudentVO getStudentById(Long id);
    void setStudentBedNumber(StudentDTO studentDTO);
}
