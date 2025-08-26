package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.common.result.CommonResult;
import gene.recombine.stuhubsys.dto.AttachmentDTO;
import gene.recombine.stuhubsys.dto.MessageDTO;
import gene.recombine.stuhubsys.entity.Major;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MessageService {
    List<MessageDTO> getAdminMessage();

    List<MessageDTO> getStudentMessage();

    ResponseEntity<byte[]> download(Integer Id) throws IOException;

    List<AttachmentDTO> getAttachment(Integer id);

    void uploadAttachment(MultipartFile file, Integer id);

    Integer release(String head, String payload);

    void delete(Integer id);

    void update(Integer id, String head, String payload);

    List<MessageDTO> get();
}
