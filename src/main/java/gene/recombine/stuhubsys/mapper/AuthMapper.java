package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.entity.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface AuthMapper {

    Map<String, String> login(String ID, String password);
    @Select("select teacher_id from teacher where teacher_id=#{id} and name=#{name};")
    Teacher getAdmin(String id, String name);
}
