package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MajorMapper extends BaseMapper<Major> {
    List<Major> getMajorListByCollegeId(Long collegeId);
}




