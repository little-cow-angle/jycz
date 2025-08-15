package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.entity.Dormitory;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.vo.DormitoryVO;

import java.util.List;

public interface DormitoryService extends IService<Dormitory> {
    List<String> getParkList();
    List<String> getBuildingList(String park);
    List<Integer> getFloorList(String park, String building);
    IPage<DormitoryVO> getDormitoryList(DormitoryDTO dormitoryDTO);
}
