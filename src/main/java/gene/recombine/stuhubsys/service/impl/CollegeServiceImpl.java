package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.mapper.CollegeMapper;
import gene.recombine.stuhubsys.service.CollegeService;
import gene.recombine.stuhubsys.vo.College;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Resource
    CollegeMapper mapper;

    @Override
    public Collection<College> list() {
        Collection<College> list = mapper.list();
        return list;
    }
}
