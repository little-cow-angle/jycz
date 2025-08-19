package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.mapper.EnrollmentPlanMapper;
import gene.recombine.stuhubsys.service.EnrollmentPlanService;
import gene.recombine.stuhubsys.vo.EnrollmentPlanVO;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentPlanServiceImpl extends ServiceImpl<EnrollmentPlanMapper, EnrollmentPlan>
    implements EnrollmentPlanService{

    @Override
    public IPage<EnrollmentPlanVO> getEnrollmentPlanPages(EnrollmentPlanDTO enrollmentPlanDTO) {
        QueryWrapper<EnrollmentPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper
            .like(StringUtils.isNotBlank(enrollmentPlanDTO.getMajorName()), "major_name", enrollmentPlanDTO.getMajorName())
            .eq(null != enrollmentPlanDTO.getType(), "type", enrollmentPlanDTO.getType());
        Page<EnrollmentPlanVO> page = new Page<>(enrollmentPlanDTO.getPageNo(), enrollmentPlanDTO.getPageSize());
        return baseMapper.getEnrollmentPlans(page, queryWrapper);
    }
}




