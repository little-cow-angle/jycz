package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.common.exception.AppExceptionMsg;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.mapper.SignUpMapper;
import gene.recombine.stuhubsys.service.SignUpService;
import gene.recombine.stuhubsys.utils.UserContext;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gene.recombine.stuhubsys.vo.SignUpRecordVO;
import gene.recombine.stuhubsys.vo.StudentVolunteerVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public SignUpRecordVO getStudentVolunteer(Long id) {
        Map<Integer, Object> volunteerMap = signUpMapper.selectByStudentId(id);
        Map<Integer, String> orderMajorMap = new HashMap<>();
        volunteerMap.forEach((order, volunteerObj) -> {
            Map<String, Object> volunteerObjMap = (Map<String, Object>) volunteerObj;
            String majorName = volunteerObjMap.getOrDefault("volunteerMajor", "未填报").toString();
            orderMajorMap.put(order, majorName);
        });

        SignUpRecordVO vo = new SignUpRecordVO();
        vo.setFirstVolunteer(orderMajorMap.getOrDefault(1, "未填报"));
        vo.setSecondVolunteer(orderMajorMap.getOrDefault(2, "未填报"));
        vo.setThirdVolunteer(orderMajorMap.getOrDefault(3, "未填报"));

        return vo;
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

    @Override
    public IPage<StudentVolunteerVO> getVolunteerList(Integer page, Integer size) {
        IPage<StudentVolunteerVO> volunteerPage = new Page<>(page, size);
        volunteerPage = signUpMapper.getSignUpList(volunteerPage);
        for (StudentVolunteerVO vo : volunteerPage.getRecords()) {
            vo.setSignUpRecord(getStudentVolunteer(vo.getStudentId()));
        }
        return volunteerPage;
    }
}