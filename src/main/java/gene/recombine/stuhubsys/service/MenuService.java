package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<Menu> getMenuByUserType(String userType);
}
