package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import gene.recombine.stuhubsys.entity.Student;
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
        String scoreRange = "CASE " + " WHEN gao_kao < 450 THEN '(0, 450)'"
            + " WHEN gao_kao >= 450 AND gao_kao < 515 THEN '[450, 515)'"
            + " WHEN gao_kao >= 515 AND gao_kao < 600 THEN '[515, 600)'"
            + " WHEN gao_kao >= 600 THEN '[600, 750]'"
            + " ELSE '无数据' END AS score_range";
        wrapper.select(scoreRange, "count(*) as count").groupBy("score_range");
        return studentMapper.selectMaps(wrapper);
    }
}
