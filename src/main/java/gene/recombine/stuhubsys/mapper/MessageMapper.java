package gene.recombine.stuhubsys.mapper;
import gene.recombine.stuhubsys.dto.AttachmentDTO;
import gene.recombine.stuhubsys.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageMapper{
    @Select("select count(*) from sign_up_record where status=1")
    Integer countNeedOperate();
    @Select("select *from notice where type=#{type} and type=1 and status=#{1} and expired_time > NOW()")
    List<Notice> getNotice(Integer type);
    @Select("select path from notice_file where notice_id=#{id}")
    List<String> getFiles(int id);
    @Select("select *from notice_file where notice_id=#{id}")
    List<AttachmentDTO> getAttachment(Integer id);
    @Select("select path from notice_file where id=#{id}")
    String getPathById(Integer id);
    @Insert("INSERT INTO notice_file ( notice_id, path, type, name) values (#{id},#{path},#{type},#{name})")
    void addAttacment(String name, String type, String path, Integer id);

    Integer releaseNotice(Notice notice);
    @Delete("delete from notice where id=#{id}")
    void delete(Integer id);
    @Select("select path from notice_file where notice_id=#{id}")
    List<String> getAttachmentPath(Integer id);
    @Delete("delete from notice_file where notice_id=#{id}")
    void deleteFile(Integer id);
    @Update("update notice set head=#{head},payload=#{payload} ")
    void updateNotice(Integer id, String head, String payload);
    @Select("SELECT *from notice where teacher_id=#{userId}")
    List<Notice> getNoticeByTeacherID(String userId);
}
