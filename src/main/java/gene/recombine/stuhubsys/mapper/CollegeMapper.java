package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.vo.College;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

public interface CollegeMapper {
    @Select("select * from college")
    Collection<College> list();
}
