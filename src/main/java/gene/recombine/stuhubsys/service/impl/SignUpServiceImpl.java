package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.mapper.SignUpMapper;
import gene.recombine.stuhubsys.service.SignUpService;
import gene.recombine.stuhubsys.utils.UserContext;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SignUpServiceImpl implements SignUpService  {
    @Resource
    SignUpMapper signUpMapper;

    @Override
    public void add(SignUpRecordDTO record) {
        String studentId =(String) UserContext.get("userId");
        Integer isStudent=signUpMapper.isStudent(studentId);
        if(isStudent==0){
            throw new AppException(AppExceptionMsg.SIGN_UP_NOT_STUDENT);
        }
        Integer count=signUpMapper.countByStudentId(studentId);
        if(count>=3){
            throw new AppException(AppExceptionMsg.SIGN_UP_RECORD_OUT_OF_MAX_3);
        }
        record.setStudentId(studentId);
        signUpMapper.add(record);
        signUpMapper.addCount(record.getEpId());
    }

    @Override
    public Collection<SignUpRecordDTO> getOwnList() {
        String studentId=(String) UserContext.get("userId");
        Collection<SignUpRecordDTO> list=signUpMapper.getOwnList(studentId);
        return list;
    }

    @Override
    public IPage<SignUpRecordDTO> list(Integer epId, Integer pageCount, Integer size) {
        // 创建分页对象（current=当前页，size=每页条数）
        IPage<SignUpRecordDTO> page = new Page<>(pageCount, size);

        // 执行分页查询
        return signUpMapper.selectSignUpPage(page, epId);

    }

    @Override
    public IPage<SignUpRecordDTO> operate(Integer id, Integer operate) {
        //TODO 若为录取则删除其他
        if(operate==2){}
        return null;
    }
}
