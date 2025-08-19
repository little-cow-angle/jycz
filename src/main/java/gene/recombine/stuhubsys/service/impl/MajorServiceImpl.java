package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.entity.Major;
import gene.recombine.stuhubsys.service.MajorService;
import gene.recombine.stuhubsys.mapper.MajorMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
    implements MajorService{

    @Resource
    private MajorMapper majorMapper;

    @Override
    public List<Major> listMajor(Long collegeId) {
        return majorMapper.getMajorListByCollegeId(collegeId);
    }

    @Override
    public List<Major> getMajorListByName(String majorName) {
        return majorMapper.getMajorListByMajorName(majorName);
    }

}