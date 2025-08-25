package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.entity.EnrollLimit;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.vo.EnrollmentPlanVO;

import java.util.List;

public interface EnrollmentPlanService extends IService<EnrollmentPlan> {
    EnrollmentPlanVO getEnrollmentPlanById(Long id);
    String setEnrollLimit(EnrollLimit enrollLimit);
    EnrollLimit getEnrollLimit();
    IPage<EnrollmentPlanVO> getEnrollmentPlanPages(EnrollmentPlanDTO enrollmentPlanDTO);
    List<EnrollmentPlanVO> getEnrollmentPlanListByMajorName(String majorName);
}
