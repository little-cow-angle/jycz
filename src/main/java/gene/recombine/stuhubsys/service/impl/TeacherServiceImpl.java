package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.entity.Teacher;
import gene.recombine.stuhubsys.service.TeacherService;
import gene.recombine.stuhubsys.mapper.TeacherMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeacherListByName(String teacherName) {
        if (teacherName == null || teacherName.isEmpty()) {
            return teacherMapper.selectList(null);
        }
        return teacherMapper.selectTeacherByTeacherName(teacherName);
    }
}