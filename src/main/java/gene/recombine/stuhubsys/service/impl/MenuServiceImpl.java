package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.entity.Menu;
import gene.recombine.stuhubsys.service.MenuService;
import gene.recombine.stuhubsys.mapper.MenuMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuByUserType(String userType) {
        List<Menu> menus = menuMapper.selectMenuByUserType(userType);
        Map<Long, Menu> menuMap = new HashMap<>();
        List<Menu> menuTree = new ArrayList<>();

        for (Menu menu : menus) {
            menuMap.put(menu.getMenuId(), menu);
        }

        for (Menu menu : menus) {
            if (menu.getParentId() == 0) {
                menuTree.add(menu);
            } else {
                Menu parent = menuMap.get(menu.getParentId());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(menu);
                }
            }
        }
        return menuTree;
    }
}