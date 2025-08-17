package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.entity.Dormitory;
import gene.recombine.stuhubsys.entity.Student;
import gene.recombine.stuhubsys.mapper.StudentMapper;
import gene.recombine.stuhubsys.service.DormitoryService;
import gene.recombine.stuhubsys.mapper.DormitoryMapper;
import gene.recombine.stuhubsys.vo.DormitoryVO;
import gene.recombine.stuhubsys.vo.StudentDormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory>
    implements DormitoryService{

    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;

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
            .eq(dormitoryDTO.getPark() != null, "d.park", dormitoryDTO.getPark())
            .eq(dormitoryDTO.getBuilding() != null, "d.building", dormitoryDTO.getBuilding())
            .eq(dormitoryDTO.getFloor() != null, "d.floor", dormitoryDTO.getFloor())
            .eq(dormitoryDTO.getDormNumber() != null, "d.dorm_number", dormitoryDTO.getDormNumber());

        boolean needStudentFilter = StringUtils.isNotBlank(dormitoryDTO.getStudentName())
            || dormitoryDTO.getMajorId() != null
            || dormitoryDTO.getCollegeId() != null;

        if (needStudentFilter) {
            QueryWrapper<Student> stuQueryWrapper = new QueryWrapper<>();
            stuQueryWrapper
                .select("distinct dorm_id")
                .isNotNull("dorm_id")
                .like(StringUtils.isNotBlank(dormitoryDTO.getStudentName()), "student_name", dormitoryDTO.getStudentName())
                .eq(dormitoryDTO.getMajorId() != null, "major_id", dormitoryDTO.getMajorId())
                .eq(dormitoryDTO.getCollegeId() != null, "college_id", dormitoryDTO.getCollegeId());

            List<Object> dormIdObjs = studentMapper.selectObjs(stuQueryWrapper);
            if (dormIdObjs == null || dormIdObjs.isEmpty()) {
                // 没有匹配到学生则返回空页面（保留分页信息）
                page.setRecords(Collections.emptyList());
                page.setTotal(0);
                return page;
            }

            List<Long> dormIds = dormIdObjs.stream()
                .filter(Objects::nonNull)
                .map(o -> Long.valueOf(o.toString()))
                .distinct()
                .collect(Collectors.toList());

            queryWrapper.in(!dormIds.isEmpty(), "d.dorm_id", dormIds);
        }

        page = dormitoryMapper.getDormitoryList(page, queryWrapper);

        List<DormitoryVO> dorms = page.getRecords();
        if (dorms == null || dorms.isEmpty()) {
            return page;
        }

        List<Long> resultDormIds = dorms.stream()
            .map(DormitoryVO::getDormId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());

        if (!resultDormIds.isEmpty()) {
            List<StudentDormVO> students = studentMapper.selectStudentsByDormIds(resultDormIds);

            Map<Long, List<StudentDormVO>> stuMap = students.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(StudentDormVO::getDormId));

            for (DormitoryVO dvo : dorms) {
                List<StudentDormVO> list = stuMap.getOrDefault(dvo.getDormId(), Collections.emptyList());
                dvo.setStudentList(list);
            }
        } else {
            dorms.forEach(d -> d.setStudentList(Collections.emptyList()));
        }

        page.setRecords(dorms);
        return page;
    }
}