package gene.recombine.stuhubsys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gene.recombine.stuhubsys.dto.ScoreDTO;
import gene.recombine.stuhubsys.dto.TextbookDTO;
import gene.recombine.stuhubsys.entity.Course;
import gene.recombine.stuhubsys.entity.Textbook;
import gene.recombine.stuhubsys.mapper.CourseMapper;
import gene.recombine.stuhubsys.service.ScoreService;
import gene.recombine.stuhubsys.service.TextbookService;
import gene.recombine.stuhubsys.mapper.TextbookMapper;
import gene.recombine.stuhubsys.vo.ScoreVO;
import gene.recombine.stuhubsys.vo.TextbookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextbookServiceImpl extends ServiceImpl<TextbookMapper, Textbook>
    implements TextbookService{
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private TextbookMapper textbookMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<TextbookVO> getTextbookListWithSelectedCourses(Long studentId) {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setStudentId(studentId);
        scoreDTO.setPageNo(1);
        scoreDTO.setPageSize(999);
        IPage<ScoreVO> scorePage = scoreService.getSelectedCourses(scoreDTO);
        List<ScoreVO> scoreVOList = scorePage.getRecords();
        List<TextbookDTO> textbookDTOList = new ArrayList<>();
        for (ScoreVO scoreVO : scoreVOList) {
            TextbookDTO textbookDTO = new TextbookDTO();
            textbookDTO.setCourseId(scoreVO.getCourseId());
            textbookDTO.setTextbookId(scoreVO.getTextbookId());
            textbookDTOList.add(textbookDTO);
        }

        return textbookMapper.getTextbookListByStudentId(textbookDTOList);
    }

    @Override
    public IPage<TextbookVO> getTextbookListWithPage(TextbookDTO textbookDTO) {
        IPage<TextbookVO> page = new Page<>(textbookDTO.getPageNo(), textbookDTO.getPageSize());
        return baseMapper.getAllTextbooks(page);
    }

    @Override
    @Transactional
    public int addTextbook(Textbook textbook) {
        int  i = textbookMapper.insert(textbook);

        if (textbook.getCourseId() != null) {
            Long textbookId = textbook.getTextbookId();
            courseMapper.updateCourseTextbookId(textbook.getCourseId(), textbookId);
        }

        return i;
    }

    @Override
    @Transactional
    public int updateTextbook(Textbook textbook) {
        Textbook oldTextbook = textbookMapper.selectById(textbook.getTextbookId());
        Long oldCourseId = oldTextbook.getCourseId();
        Long newCourseId = textbook.getCourseId();

        int i = textbookMapper.updateById(textbook);

        if (newCourseId != null && !newCourseId.equals(oldCourseId)) {
            courseMapper.updateCourseTextbookId(textbook.getCourseId(), textbook.getTextbookId());
        }

        return i;
    }
}




