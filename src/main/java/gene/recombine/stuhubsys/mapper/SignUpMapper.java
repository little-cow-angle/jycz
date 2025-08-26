package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.vo.StudentVolunteerVO;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface SignUpMapper extends BaseMapper<SignUpRecordDTO> {
    @Select("select * from sign_up_record where student_id = #{studentId}")
    Collection<SignUpRecordDTO> countByStudentId(String studentId);
    @MapKey("volunteerOrder")
    Map<Integer, Object> selectByStudentId(@Param("studentId") Long studentId);
    @Insert("insert into sign_up_record (student_id, ep_id, `order`) values (#{studentId},#{epId},#{order})")
    void add(SignUpRecordDTO record);
    @Select("select count(*) from student where student_id = #{studentId}")
    Integer isStudent(String studentId);
    @Select("select * from sign_up_record where student_id = #{studentId}")
    Collection<SignUpRecordDTO> getOwnList(String studentId);
    @Update("update enrollment_plan set count = count + 1 where id = #{epId}")
    void addCount(Integer epId);
    // 方式2：使用 Lambda 表达式（更推荐）
    IPage<SignUpRecordDTO> selectSignUpPage(IPage<SignUpRecordDTO> page, @Param("epId") Integer epId);

    void recruit(Integer id);
    @Update("update sign_up_record set status = #{operate},update_time = NOW() where id=#{id}")
    void operate(Integer id, Integer operate);

    @MapKey("major_name")
    List<Map<String, Object>> getHotMajorSignUpList();

    IPage<StudentVolunteerVO> getSignUpList(IPage<StudentVolunteerVO> page);
}
