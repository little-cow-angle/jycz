package gene.recombine.stuhubsys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.TextbookDTO;
import gene.recombine.stuhubsys.entity.Textbook;
import com.baomidou.mybatisplus.extension.service.IService;
import gene.recombine.stuhubsys.vo.TextbookVO;

import java.util.List;

public interface TextbookService extends IService<Textbook> {
    List<TextbookVO> getTextbookListWithSelectedCourses(Long studentId);
    IPage<TextbookVO> getTextbookListWithPage(TextbookDTO textbookDTO);
    int addTextbook(Textbook textbook);
    int updateTextbook(Textbook textbook);
}
