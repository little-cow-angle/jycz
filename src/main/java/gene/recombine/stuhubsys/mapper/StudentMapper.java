package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper extends BaseMapper<Student> {
    int updateStudentDormToNull(@Param("dormId") Long dormId);
}




