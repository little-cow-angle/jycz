package gene.recombine.stuhubsys.controller;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.entity.Menu;
import gene.recombine.stuhubsys.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
@Tag(name = "菜单")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("{name}")
    @Operation(summary = "查询菜单")
    public CommonResult<List<Menu>> getMenuByName(@PathVariable("name") String name) {
        return CommonResult.success(menuService.getMenuByName(name));
    }
}