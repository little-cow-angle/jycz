package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.service.EnrollmentPlanService;
import gene.recombine.stuhubsys.mapper.EnrollmentPlanMapper;
import org.springframework.stereotype.Service;

/**
* @author ShiRyant
* @description 针对表【enrollment_plan】的数据库操作Service实现
* @createDate 2025-08-13 10:16:27
*/
@Service
public class EnrollmentPlanServiceImpl extends ServiceImpl<EnrollmentPlanMapper, EnrollmentPlan>
    implements EnrollmentPlanService{

    @Override
    public IPage<EnrollmentPlan> getEnrollmentPlanPages(EnrollmentPlanDTO enrollmentPlanDTO) {
        LambdaQueryWrapper<EnrollmentPlan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
            .like(StringUtils.isNotBlank(enrollmentPlanDTO.getProvince()), EnrollmentPlan::getProvince, enrollmentPlanDTO.getProvince())
            .eq(null != enrollmentPlanDTO.getYear(), EnrollmentPlan::getYear, enrollmentPlanDTO.getYear())
            .eq(null != enrollmentPlanDTO.getMajorId(), EnrollmentPlan::getMajorId, enrollmentPlanDTO.getMajorId());
        Page<EnrollmentPlan> enrollmentPlanPage = new Page<>(enrollmentPlanDTO.getPageNo(), enrollmentPlanDTO.getPageSize());
        return page(enrollmentPlanPage, queryWrapper);
    }
}




