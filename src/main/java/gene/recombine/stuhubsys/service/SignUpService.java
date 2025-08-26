package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.vo.SignUpRecordVO;

import java.util.Collection;
import java.util.List;

public interface SignUpService {
    void add(List<SignUpRecordDTO> records);
    Collection<SignUpRecordDTO> getOwnList();
    SignUpRecordVO getStudentVolunteer(Long id);
    IPage<SignUpRecordDTO> list(Integer epId, Integer page, Integer size);
    void operate(Integer id, Integer operate);
}
