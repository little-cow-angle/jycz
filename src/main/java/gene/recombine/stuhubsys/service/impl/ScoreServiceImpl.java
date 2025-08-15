package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.ScoreDTO;
import gene.recombine.stuhubsys.entity.Score;
import gene.recombine.stuhubsys.service.ScoreService;
import gene.recombine.stuhubsys.mapper.ScoreMapper;
import gene.recombine.stuhubsys.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public IPage<ScoreVO> getSelectedCourses(ScoreDTO scoreDTO) {
        IPage<ScoreVO> page = new Page<>(scoreDTO.getPageNo(), scoreDTO.getPageSize());
        return scoreMapper.getSelectedCourseList(page, scoreDTO.getStudentId());
    }

    @Override
    public IPage<ScoreVO> getAvailableCourses(ScoreDTO scoreDTO) {
        List<Long> selectedCourseIds = scoreMapper.getCourseIdsByStudentId(scoreDTO.getStudentId());
        IPage<ScoreVO> page = new Page<>(scoreDTO.getPageNo(), scoreDTO.getPageSize());
        return scoreMapper.getAvailableCourseList(page, scoreDTO.getStudentId(), selectedCourseIds);
    }
}




