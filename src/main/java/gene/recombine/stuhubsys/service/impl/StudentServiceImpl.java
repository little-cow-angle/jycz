package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.service.StudentService;
import gene.recombine.stuhubsys.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




