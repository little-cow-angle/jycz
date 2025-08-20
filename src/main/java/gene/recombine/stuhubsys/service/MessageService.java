package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.dto.MessageDTO;
import gene.recombine.stuhubsys.entity.Major;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface MessageService {
    List<MessageDTO> getAdminMessage();

    List<MessageDTO> getStudentMessage();

    ResponseEntity<Resource> download(String path) throws IOException;
}
