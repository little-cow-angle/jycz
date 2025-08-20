package gene.recombine.stuhubsys.mapper;
import gene.recombine.stuhubsys.vo.notice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper{
    @Select("select count(*) from sign_up_record where status=1")
    Integer countNeedOperate();
    @Select("select *from notice where type=#{type} and type=1 and status=#{1} and expired_time > NOW()")
    List<notice> getNotice(Integer type);
    @Select("select path from notice_file where notice_id=#{id}")
    List<String> getFiles(int id);
}
