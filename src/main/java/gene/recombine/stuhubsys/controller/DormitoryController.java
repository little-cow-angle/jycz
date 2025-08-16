package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.DormitoryDTO;
import gene.recombine.stuhubsys.entity.Dormitory;
import gene.recombine.stuhubsys.service.DormitoryService;
import gene.recombine.stuhubsys.vo.DormitoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dormitory")
@Tag(name = "宿舍管理")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping("add")
    @Operation(summary = "新增宿舍信息")
    public CommonResult addDormitory(@RequestBody Dormitory dormitory) {
        return CommonResult.success(dormitoryService.save(dormitory));
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "删除宿舍信息")
    public CommonResult deleteDormitory(@PathVariable("id") Long id) {
        return CommonResult.success(dormitoryService.deleteDormitory(id));
    }

    @PostMapping("query")
    @Operation(summary = "查询宿舍信息")
    public CommonResult<IPage<DormitoryVO>> queryDormitory(@RequestBody DormitoryDTO dormitoryDTO) {
        return CommonResult.success(dormitoryService.getDormitoryList(dormitoryDTO));
    }

    @GetMapping("park")
    @Operation(summary = "获取园区列表")
    public CommonResult<List<String>> getParkList() {
        return CommonResult.success(dormitoryService.getParkList());
    }

    @GetMapping("building")
    @Operation(summary = "获取楼栋列表")
    @Parameter(name = "park", description = "园区名", in = ParameterIn.QUERY, required = true)
    public CommonResult<List<String>> getBuildingList(@RequestParam("park") String park) {
        return CommonResult.success(dormitoryService.getBuildingList(park));
    }

    @GetMapping("floor")
    @Operation(summary = "获取楼层列表")
    @Parameter(name = "park", description = "园区名", in = ParameterIn.QUERY, required = true)
    @Parameter(name = "building", description = "楼栋号", in = ParameterIn.QUERY, required = true)
    public CommonResult<List<Integer>> getFloorList(@RequestParam("park") String park, @RequestParam("building") String building) {
        return CommonResult.success(dormitoryService.getFloorList(park, building));
    }

}
