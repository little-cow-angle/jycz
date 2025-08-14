package gene.recombine.stuhubsys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.ScoreDTO;
import gene.recombine.stuhubsys.entity.Score;
import gene.recombine.stuhubsys.service.ScoreService;
import gene.recombine.stuhubsys.vo.ScoreVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("score")
@Tag(name = "学生选课")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @PostMapping("elective")
    @Operation(summary = "选择课程")
    public CommonResult electiveCourse(@RequestBody ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setCourseId(scoreDTO.getCourseId());
        score.setStudentId(scoreDTO.getStudentId());
        return CommonResult.success(scoreService.save(score));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "退选课程")
    public CommonResult deleteScore(@PathVariable("id") Long id) {
        return CommonResult.success(scoreService.removeById(id));
    }

    @PostMapping("get-score-list")
    @Operation(summary = "选课结果查询")
    public CommonResult<IPage<ScoreVO>> getScoreList(@RequestBody ScoreDTO scoreDTO) {
        return CommonResult.success(scoreService.getSelectedCourses(scoreDTO));
    }
}
