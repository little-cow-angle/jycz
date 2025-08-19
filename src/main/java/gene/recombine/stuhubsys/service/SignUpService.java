package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;

import java.util.Collection;

public interface SignUpService {
    void add(SignUpRecordDTO record);

    Collection<SignUpRecordDTO> getOwnList();

    IPage<SignUpRecordDTO> list(Integer epId, Integer page, Integer size);

    void operate(Integer id, Integer operate);
}
