package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.mapper.CollegeMapper;
import gene.recombine.stuhubsys.mapper.MajorMapper;
import gene.recombine.stuhubsys.service.CollegeService;
import gene.recombine.stuhubsys.entity.College;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Resource
    CollegeMapper mapper;

    @Override
    public Collection<College> list() {
        return mapper.list();
    }

}
