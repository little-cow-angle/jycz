package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.ScoreDTO;
import gene.recombine.stuhubsys.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.vo.ScoreVO;

public interface ScoreService extends IService<Score> {
    IPage<ScoreVO> getSelectedCourses(ScoreDTO scoreDTO);
    IPage<ScoreVO> getAvailableCourses(ScoreDTO scoreDTO);
}
