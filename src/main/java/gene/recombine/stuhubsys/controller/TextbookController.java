package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.TextbookDTO;
import gene.recombine.stuhubsys.entity.Textbook;
import gene.recombine.stuhubsys.service.TextbookService;
import gene.recombine.stuhubsys.vo.TextbookVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("textbook")
@Tag(name = "教材管理")
public class TextbookController {

    @Autowired
    private TextbookService textbookService;

    @GetMapping("student/query")
    @Operation(summary = "获取已选课程对应教材(学生)")
    public CommonResult<List<TextbookVO>> getSelectCoursesTextbookList(@RequestParam("studentId") Long studentId) {
        return CommonResult.success(textbookService.getTextbookListWithSelectedCourses(studentId));
    }

    @PostMapping("teacher/queryAll")
    @Operation(summary = "获取全部教材(教师)")
    public CommonResult<IPage<TextbookVO>> getTextbookListWithPage(@RequestBody TextbookDTO textbookDTO) {
        return CommonResult.success(textbookService.getTextbookListWithPage(textbookDTO));
    }

    @PostMapping("teacher/add")
    @Operation(summary = "新增教材(教师)")
    public CommonResult addTextbook(@RequestBody Textbook textbook) {
        return CommonResult.success(textbookService.addTextbook(textbook));
    }

    @PutMapping("teacher/update")
    @Operation(summary = "更新教材(教师)")
    public CommonResult updateTextbook(@RequestBody Textbook textbook) {
        return CommonResult.success(textbookService.updateTextbook(textbook));
    }

    @DeleteMapping("teacher/delete/{id}")
    @Operation(summary = "删除教材(教师)")
    @Parameter(name = "id", description = "课程id")
    public CommonResult deleteTextbook(@PathVariable("id") Long id) {
        return CommonResult.success(textbookService.removeById(id));
    }
}
