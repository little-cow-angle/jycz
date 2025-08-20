package gene.recombine.stuhubsys.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> getStuDistributionByColumn(String column);
    List<Map<String, Object>> getStuDistributionByScore();
    List<Map<String, Object>> getHotMajorList();
}
