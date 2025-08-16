package gene.recombine.stuhubsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PageBean {
    private Integer size;
    private List page;
}
