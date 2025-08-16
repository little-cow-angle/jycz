package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface SignUpMapper extends BaseMapper<SignUpRecordDTO> {
    @Select("select count(*) from sign_up_record where student_id=#{studentId}")
    Integer countByStudentId(String studentId);
    @Insert("insert into sign_up_record (student_id, ep_id, data) values (#{studentId},#{epId},#{data})")
    void add(SignUpRecordDTO record);
    @Select("select count(*) from student where student_id=#{studentId}")
    Integer isStudent(String studentId);
    @Select("select * from sign_up_record where student_id=#{studentId}")
    Collection<SignUpRecordDTO> getOwnList(String studentId);
    @Update("update enrollment_plan set count=count+1 where id=#{epId}")
    void addCount(Integer epId);


    // 方式2：使用 Lambda 表达式（更推荐）
    IPage<SignUpRecordDTO> selectSignUpPage(IPage<SignUpRecordDTO> page, @Param("epId") Integer epId);
}
