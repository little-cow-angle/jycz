package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.entity.Dormitory;
import gene.recombine.stuhubsys.service.DormitoryService;
import gene.recombine.stuhubsys.mapper.DormitoryMapper;
import gene.recombine.stuhubsys.vo.DormitoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory>
    implements DormitoryService{

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<String> getParkList() {
        return dormitoryMapper.getParkList();
    }

    @Override
    public List<String> getBuildingList(String park) {
        return dormitoryMapper.getBuildingList(park);
    }

    @Override
    public List<Integer> getFloorList(String park, String building) {
        return dormitoryMapper.getFloorList(park, building);
    }

    @Override
    public IPage<DormitoryVO> getDormitoryList(DormitoryDTO dormitoryDTO) {
        IPage<DormitoryVO> page = new Page<>(dormitoryDTO.getPageNo(), dormitoryDTO.getPageSize());
        QueryWrapper<Dormitory> queryWrapper = new QueryWrapper<>();
        queryWrapper
            .eq(null != dormitoryDTO.getPark(), "park", dormitoryDTO.getPark())
            .eq(null != dormitoryDTO.getBuilding(), "building", dormitoryDTO.getBuilding())
            .eq(null != dormitoryDTO.getFloor(), "floor", dormitoryDTO.getFloor())
            .eq(null != dormitoryDTO.getDormNumber(), "dorm_number", dormitoryDTO.getDormNumber());
        return dormitoryMapper.getDormitoryList(page, queryWrapper);
    }
}




