package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.entity.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper extends BaseMapper<Score> {
    IPage<ScoreVO> getSelectedCourseList(IPage<ScoreVO> page, @Param("studentId") Long studentId);
}




