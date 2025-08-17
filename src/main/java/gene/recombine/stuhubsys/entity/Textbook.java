package gene.recombine.stuhubsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@TableName(value ="textbook")
@Data
public class Textbook {
    @TableId(type = IdType.AUTO)
    @Schema(description = "教材id")
    private Long textbookId;
    @Schema(description = "教材名")
    private String textbookName;
    @Schema(description = "作者")
    private String author;
    @Schema(description = "出版社")
    private String publisher;
    @Schema(description = "价格")
    private Double price;
    @Schema(description = "课程id")
    private Long courseId;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        gene.recombine.stuhubsys.entity.Textbook other = (gene.recombine.stuhubsys.entity.Textbook) that;
        return (this.getTextbookId() == null ? other.getTextbookId() == null : this.getTextbookId().equals(other.getTextbookId()))
            && (this.getTextbookName() == null ? other.getTextbookName() == null : this.getTextbookName().equals(other.getTextbookName()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getPublisher() == null ? other.getPublisher() == null : this.getPublisher().equals(other.getPublisher()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTextbookId() == null) ? 0 : getTextbookId().hashCode());
        result = prime * result + ((getTextbookName() == null) ? 0 : getTextbookName().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getPublisher() == null) ? 0 : getPublisher().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", textbookId=").append(textbookId);
        sb.append(", textbookName=").append(textbookName);
        sb.append(", author=").append(author);
        sb.append(", publisher=").append(publisher);
        sb.append(", price=").append(price);
        sb.append(", courseId=").append(courseId);
        sb.append("]");
        return sb.toString();
    }
}