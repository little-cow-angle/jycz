package gene.recombine.stuhubsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class notice {
    private int id;
    private Short type;
    private String head;
    private String payload;
    private LocalDateTime createTime;
    private LocalDateTime expiredTime;
    private Short status;
}
