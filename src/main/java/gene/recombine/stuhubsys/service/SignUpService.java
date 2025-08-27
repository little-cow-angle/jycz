package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.vo.SignUpRecordVO;
import gene.recombine.stuhubsys.vo.StudentVolunteerVO;

import java.util.Collection;
import java.util.List;

public interface SignUpService {
    void add(List<SignUpRecordDTO> records);
    Collection<SignUpRecordDTO> getOwnList();
    SignUpRecordVO getStudentVolunteer(Long id);
    IPage<SignUpRecordDTO> list(Integer epId, Integer page, Integer size);
    void operate(Integer id, Integer operate);
    IPage<StudentVolunteerVO> getVolunteerList(Integer page, Integer size);

    IPage<SignUpRecordDTO> getVolunteerList1(Integer page, Integer size, Integer collegeId);
}
