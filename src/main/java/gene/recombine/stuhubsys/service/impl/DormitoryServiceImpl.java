package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.entity.Dormitory;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.mapper.CollegeMapper;
import gene.recombine.stuhubsys.mapper.MajorMapper;
import gene.recombine.stuhubsys.mapper.StudentMapper;
import gene.recombine.stuhubsys.service.DormitoryService;
import gene.recombine.stuhubsys.mapper.DormitoryMapper;
import gene.recombine.stuhubsys.vo.DormitoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory>
    implements DormitoryService{

    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;

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
    @Transactional
    public int deleteDormitory(Long dormId) {
        studentMapper.updateStudentDormToNull(dormId);
        int deleteRows = dormitoryMapper.deleteById(dormId);
        if (deleteRows == 0) {
            throw new RuntimeException("宿舍不存在，删除失败");
        }
        return deleteRows;
    }

    @Override
    public IPage<DormitoryVO> getDormitoryList(DormitoryDTO dormitoryDTO) {
        IPage<DormitoryVO> page = new Page<>(dormitoryDTO.getPageNo(), dormitoryDTO.getPageSize());
        QueryWrapper<Dormitory> queryWrapper = new QueryWrapper<>();
        queryWrapper
            .eq(null != dormitoryDTO.getPark(), "d.park", dormitoryDTO.getPark())
            .eq(null != dormitoryDTO.getBuilding(), "d.building", dormitoryDTO.getBuilding())
            .eq(null != dormitoryDTO.getFloor(), "d.floor", dormitoryDTO.getFloor())
            .eq(null != dormitoryDTO.getDormNumber(), "d.dorm_number", dormitoryDTO.getDormNumber());

        // 判断是否有学生相关的查询条件，无则直接查询
        boolean needStudentFilter = StringUtils.isNotBlank(dormitoryDTO.getStudentName())
            || (dormitoryDTO.getMajorId() != null)
            || (dormitoryDTO.getCollegeId() != null);

        if (!needStudentFilter) {
            return dormitoryMapper.getDormitoryList(page, queryWrapper);
        }

        QueryWrapper<Student> stuQueryWrapper = new QueryWrapper<>();
        stuQueryWrapper
            .select("distinct dorm_id").isNotNull("dorm_id")
            .like(StringUtils.isNotBlank(dormitoryDTO.getStudentName()), "student_name", dormitoryDTO.getStudentName())
            .eq(null != dormitoryDTO.getCollegeId(), "college_id", dormitoryDTO.getCollegeId())
            .eq(null != dormitoryDTO.getMajorId(), "major_id", dormitoryDTO.getMajorId());

        List<Object> dormIdObjs = studentMapper.selectObjs(stuQueryWrapper);

        if (dormIdObjs == null || dormIdObjs.isEmpty()) {
            return new Page<>(0, 0);
        }

        List<Long> dormIds = dormIdObjs.stream()
            .filter(Objects::nonNull)
            .map(o -> Long.valueOf(o.toString()))
            .distinct()
            .toList();

        queryWrapper.in("d.dorm_id", dormIds);

        return dormitoryMapper.getDormitoryList(page, queryWrapper);
    }
}




