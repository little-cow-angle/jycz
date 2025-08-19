package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.entity.EnrollLimit;
import gene.recombine.stuhubsys.dto.EnrollmentPlanDTO;
import gene.recombine.stuhubsys.entity.EnrollmentPlan;
import gene.recombine.stuhubsys.mapper.EnrollmentPlanMapper;
import gene.recombine.stuhubsys.service.EnrollmentPlanService;
import gene.recombine.stuhubsys.vo.EnrollmentPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


@Service
public class EnrollmentPlanServiceImpl extends ServiceImpl<EnrollmentPlanMapper, EnrollmentPlan>
    implements EnrollmentPlanService{

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String setEnrollLimit(EnrollLimit enrollLimit) {
        String startTime = new SimpleDateFormat("yyyy-MM-dd").format(enrollLimit.getStartTime());
        String endTime = new SimpleDateFormat("yyyy-MM-dd").format(enrollLimit.getEndTime());

        redisTemplate.opsForValue().set("enroll:startTime", startTime);
        redisTemplate.opsForValue().set("enroll:endTime", endTime);
        redisTemplate.opsForValue().set("enroll:limitNumber", enrollLimit.getLimitNumber().toString());

        return "设置限制成功";
    }

    @Override
    public EnrollLimit getEnrollLimit() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime, endTime;
        try {
            startTime = sdf.parse(redisTemplate.opsForValue().get("enroll:startTime"));
            endTime = sdf.parse(redisTemplate.opsForValue().get("enroll:endTime"));
        } catch (ParseException e) {
            throw new RuntimeException("系统异常");
        }

        Integer limitNumber = Integer.parseInt(Objects.requireNonNull(redisTemplate.opsForValue().get("enroll:limitNumber")));
        return new EnrollLimit(startTime, endTime, limitNumber);
    }

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




