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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class SignUpServiceImpl implements SignUpService  {
    @Resource
    SignUpMapper signUpMapper;

    @Override
    public void add(List<SignUpRecordDTO> records) {
        String studentId = (String) UserContext.get("userId");
        Integer isStudent = signUpMapper.isStudent(studentId);
        if (isStudent == 0) {
            throw new AppException(AppExceptionMsg.SIGN_UP_NOT_STUDENT);
        }
        Collection<SignUpRecordDTO> sign = signUpMapper.countByStudentId(studentId);
        if (sign.size() >= 3) {
            throw new AppException(AppExceptionMsg.SIGN_UP_RECORD_OUT_OF_MAX_3);
        }
        for (SignUpRecordDTO record : records) {
            if (record.getOrder() == null) {
                throw new AppException(AppExceptionMsg.SIGN_UP_ORDER_IS_NULL);
            }
            Integer order=record.getOrder();
            if (orderDUPLICATED(sign, order)) {
                throw new AppException(AppExceptionMsg.SIGN_UP_ORDER_IS_DUPLICATED);
            }
            record.setStudentId(studentId);
            signUpMapper.add(record);
            signUpMapper.addCount(record.getEpId());
        }
    }

    private boolean orderDUPLICATED(Collection<SignUpRecordDTO> sign, Integer order) {
        for (SignUpRecordDTO signUpRecordDTO : sign) {
            if(Objects.equals(signUpRecordDTO.getOrder(), order)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<SignUpRecordDTO> getOwnList() {
        String studentId = (String) UserContext.get("userId");
        return signUpMapper.getOwnList(studentId);
    }

    @Override
    public IPage<SignUpRecordDTO> list(Integer epId, Integer pageCount, Integer size) {
        // 创建分页对象（current=当前页，size=每页条数）
        IPage<SignUpRecordDTO> page = new Page<>(pageCount, size);
        // 执行分页查询
        return signUpMapper.selectSignUpPage(page, epId);
    }

    @Override
    public void operate(Integer id, Integer operate) {
        //TODO 若为录取则驳回其他志愿申请
        switch (operate) {
            //返回待审核状态
            case 1:
                signUpMapper.operate(id,operate);break;
            //录取
            case 2:
                signUpMapper.recruit(id);break;
            //驳回
            case 3:
                signUpMapper.operate(id,operate);break;
            //其他
            default:
                throw new AppException(AppExceptionMsg.SIGN_UP_UNKNOWN_COMMAND);
        }
    }
}