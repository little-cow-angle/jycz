package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.common.enums.MessageType;
import gene.recombine.stuhubsys.dto.MessageDTO;
import gene.recombine.stuhubsys.dto.SignUpRecordDTO;
import gene.recombine.stuhubsys.mapper.MessageMapper;
import gene.recombine.stuhubsys.mapper.SignUpMapper;
import gene.recombine.stuhubsys.service.MessageService;
import gene.recombine.stuhubsys.utils.LinuxStorageUtils;
import gene.recombine.stuhubsys.utils.UserContext;
import gene.recombine.stuhubsys.vo.notice;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private SignUpMapper signUpMapper;
    @Autowired
    private FileService fileService;
    private static String waitForOperate="您的第{}志愿还在审核过程中，请耐心等待";
    private static String accept="恭喜你同学！你的第{}志愿已通过！";
    private static String reject="很遗憾，您的第{}志愿未通过。";
    private static String errorStatus="您的第{}志愿状态异常，请联系老师进行处理！";
    @Override
    public List<MessageDTO> getAdminMessage() {
        List<MessageDTO> MessageList = new ArrayList<>();

        Integer count=messageMapper.countNeedOperate();
        if(count!=0){
            //1.代办申请
            MessageDTO needOperate = new MessageDTO();
            needOperate.setType(MessageType.WORK);
            needOperate.setHead("您有"+count.toString()+"学生申请待处理！");
            needOperate.setCreateTime(LocalDateTime.now());
            MessageList.add(needOperate);
        }
        //2.公告查询
        List<MessageDTO> notice=getAdminNotice();
        MessageList.addAll(notice);
        return MessageList;
    }

    @Override
    public List<MessageDTO> getStudentMessage() {
        List<MessageDTO> MessageList = new ArrayList<>();
        //1.志愿状态消息
        Collection<SignUpRecordDTO> signUpList = signUpMapper.getOwnList((String) UserContext.get("userID"));
        if(!signUpList.isEmpty()){
            for (SignUpRecordDTO item : signUpList) {
                MessageDTO message = new MessageDTO();
                message.setType(MessageType.WORK);
                message.setCreateTime(item.getUpdateTime());
                switch (item.getStatus()){
                    case 1:
                        message.setHead(waitForOperate.replace("{}",item.getOrder().toString()));
                        break;
                    case 2:
                        message.setHead(accept.replace("{}",item.getOrder().toString()));
                        break;
                    case 3:
                        message.setHead(reject.replace("{}",item.getOrder().toString()));
                        break;
                    default:
                        message.setHead(errorStatus.replace("{}",item.getOrder().toString()));
                }
                MessageList.add(message);
            }
        }
        //2.公告查询
        List<MessageDTO> notice=getStudentNotice();
        MessageList.addAll(notice);
        return MessageList;
    }

    @Override
    public ResponseEntity<org.springframework.core.io.Resource> download(String path) throws IOException {
        return fileService.downloadFile(path);
    }

    private List<MessageDTO> getAdminNotice() {
        List<notice> list =messageMapper.getNotice(3);
       return convertoMessage(list);
    }
    private List<MessageDTO> getStudentNotice() {
        List<notice> list =messageMapper.getNotice(2);
        return convertoMessage(list);
    }

    private List<MessageDTO> convertoMessage(List<notice> list) {

        List<MessageDTO> MessageList = new ArrayList<>();
        for (notice notice : list) {
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setHead(notice.getHead());
            messageDTO.setFiles(messageMapper.getFiles(notice.getId()));
            messageDTO.setType(MessageType.NOTICE);
            messageDTO.setMessage(notice.getPayload());
            messageDTO.setCreateTime(notice.getCreateTime());
            MessageList.add(messageDTO);
        }
        return MessageList;
    }
}
