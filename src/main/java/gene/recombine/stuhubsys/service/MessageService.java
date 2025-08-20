package gene.recombine.stuhubsys.service;

import gene.recombine.stuhubsys.dto.MessageDTO;
import gene.recombine.stuhubsys.entity.Major;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getAdminMessage();

    List<MessageDTO> getStudentMessage();
}
