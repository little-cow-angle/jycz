package gene.recombine.stuhubsys.mapper;

import gene.recombine.stuhubsys.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectMenuByUserType(String userType);
    List<Menu> selectMenuByName(String menuName);
}