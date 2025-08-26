package gene.recombine.stuhubsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private int id;
    private Short type;
    private String head;
    private String payload;
    private LocalDateTime createTime;
    private LocalDateTime expiredTime;
    private Short status;
    private String teacherId;
}
