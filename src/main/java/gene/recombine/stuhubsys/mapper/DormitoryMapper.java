package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.entity.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.DormitoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryMapper extends BaseMapper<Dormitory> {
    List<String> getParkList();
    List<String> getBuildingList(String park);
    List<Integer> getFloorList(String park, String building);
    IPage<DormitoryVO> getDormitoryList(IPage<DormitoryVO> page, @Param("ew") QueryWrapper<Dormitory> queryWrapper);
}




