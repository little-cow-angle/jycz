package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.EnrollmentPlanVO;
import org.apache.ibatis.annotations.Param;

public interface EnrollmentPlanMapper extends BaseMapper<EnrollmentPlan> {
    IPage<EnrollmentPlanVO> getEnrollmentPlans(Page<EnrollmentPlanVO> page, @Param("ew") QueryWrapper<EnrollmentPlan> ew);
}




