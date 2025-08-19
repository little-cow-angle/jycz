package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> selectTeacherByTeacherName(String teacherName);
}




