package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface MajorService extends IService<Major> {
    List<Major> listMajor(Long collegeId);
    List<Major> getMajorListByName(String majorName);
}
