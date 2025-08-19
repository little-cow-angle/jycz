package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
    List<Teacher> getTeacherListByName(String teacherName);
}
