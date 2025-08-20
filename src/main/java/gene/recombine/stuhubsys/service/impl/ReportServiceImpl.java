package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.mapper.SignUpMapper;
import gene.recombine.stuhubsys.mapper.StudentMapper;
import gene.recombine.stuhubsys.service.ReportService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private SignUpMapper signUpMapper;

    @Override
    public List<Map<String, Object>> getStuDistributionByColumn(String column) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.groupBy(column);
        wrapper.select(column, "count(*) as count");
        return studentMapper.selectMaps(wrapper);
    }

    @Override
    public List<Map<String, Object>> getStuDistributionByScore() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        String scoreRange = "CASE " + " WHEN gao_kao < 535 THEN '(0, 535)'"
            + " WHEN gao_kao >= 535 AND gao_kao < 555 THEN '[535, 555)'"
            + " WHEN gao_kao >= 555 AND gao_kao < 575 THEN '[555, 575)'"
            + " WHEN gao_kao >= 575 AND gao_kao < 595 THEN '[575, 595)'"
            + " WHEN gao_kao >= 595 THEN '[595, 750)'"
            + " ELSE '无数据' END AS score_range";
        wrapper.select(scoreRange, "count(*) as count").groupBy("score_range").orderByAsc("MIN(gao_kao)");
        return studentMapper.selectMaps(wrapper);
    }

    @Override
    public List<Map<String, Object>> getHotMajorList() {
        return signUpMapper.getHotMajorSignUpList();
    }
}
