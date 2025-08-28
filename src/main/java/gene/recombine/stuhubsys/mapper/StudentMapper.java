package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.dto.StudentDTO;
import gene.recombine.stuhubsys.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.StudentDormVO;
import gene.recombine.stuhubsys.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    int updateStudentDormToNull(@Param("dormId") Long dormId);
    StudentVO selectStudentById(@Param("studentId") Long studentId);
    int countBedNumber(@Param("studentId") Long studentId, @Param("dormId") Long dormId, @Param("bedNumber") Integer bedNumber);
    List<StudentDormVO> selectStudentsByDormIds(@Param("dormIds") List<Long> dormIds);
    IPage<StudentVO> getStudentPages(IPage<StudentVO> page, @Param("ew") QueryWrapper<Student> ew);
    List<StudentDormVO> getStudentDormVOs(@Param("dormitoryDTO") DormitoryDTO dormitoryDTO, @Param("offset") Integer offset);
    IPage<StudentDormVO> selectStudentDormPage(IPage<Student> page, @Param("ew") QueryWrapper<Student> ew);
    int setBedNumber(StudentDTO studentDTO);
}