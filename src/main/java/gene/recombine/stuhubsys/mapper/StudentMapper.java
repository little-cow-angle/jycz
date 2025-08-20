package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.StudentDormVO;
import gene.recombine.stuhubsys.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    int updateStudentDormToNull(@Param("dormId") Long dormId);
    List<StudentDormVO> selectStudentsByDormIds(@Param("dormIds") List<Long> dormIds);
    IPage<StudentVO> getStudentPages(IPage<StudentVO> page, @Param("ew") QueryWrapper<Student> ew);
}