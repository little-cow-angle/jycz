package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.vo.EnrollmentPlanVO;

public interface EnrollmentPlanService extends IService<EnrollmentPlan> {
    IPage<EnrollmentPlanVO> getEnrollmentPlanPages(EnrollmentPlanDTO enrollmentPlanDTO);
}
