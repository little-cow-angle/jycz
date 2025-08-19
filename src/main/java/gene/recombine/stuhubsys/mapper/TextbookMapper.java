package gene.recombine.stuhubsys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import gene.recombine.stuhubsys.dto.TextbookDTO;
import gene.recombine.stuhubsys.entity.Textbook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gene.recombine.stuhubsys.vo.TextbookVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TextbookMapper extends BaseMapper<Textbook> {
    List<TextbookVO> getTextbookListByStudentId(@Param("textbookDTOList") List<TextbookDTO> textbookDTOList);
    IPage<TextbookVO> getAllTextbooks(IPage<TextbookVO> page);
}




