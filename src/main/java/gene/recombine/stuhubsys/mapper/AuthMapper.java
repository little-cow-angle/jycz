package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.dto.UserDTO;
import gene.recombine.stuhubsys.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Map;

public interface AuthMapper {
    Map<String, String> login(String ID, String password);
    @Select("select teacher_id from teacher where teacher_id=#{id} and name=#{name};")
    Teacher getAdmin(String id, String name);

    UserDTO getInfo(String id, String name);

    void setInfo(@Param("isAdmin") boolean isAdmin,
                   @Param("entryDate") String entryDate,
                   @Param("id") String id,
                   @Param("sex") String sex,
                   @Param("birth") LocalDate birth,
                   @Param("gaoKaoId") String gaoKaoId,
                   @Param("gaoKao") String gaoKao,
                   @Param("phone") String phone,
                   @Param("email") String email,
                   @Param("major") String major,
                   @Param("collegeId") Integer collegeId,
                   @Param("workAddress") String workAddress,
                   @Param("position") String position);
}
