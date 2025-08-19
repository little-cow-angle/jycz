package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.mapper.CollegeMapper;
import gene.recombine.stuhubsys.mapper.MajorMapper;
import gene.recombine.stuhubsys.service.CollegeService;
import gene.recombine.stuhubsys.entity.College;
import gene.recombine.stuhubsys.entity.Major;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Resource
    CollegeMapper mapper;
    @Resource
    MajorMapper majorMapper;

    @Override
    public Collection<College> list() {
        return mapper.list();
    }

    @Override
    public List<Major> listMajor(Long collegeId) {
        return majorMapper.getMajorListByCollegeId(collegeId);
    }
}
