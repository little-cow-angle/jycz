package gene.recombine.stuhubsys.service.impl;

import gene.recombine.stuhubsys.common.exception.AppException;
import gene.recombine.stuhubsys.utils.LinuxStorageUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    private static String base;

    static {
        String osName = System.getProperty("os.name", "").toLowerCase();

        if (osName.startsWith("windows")) {
            // Windows 路径，使用双反斜杠转义
            base = "G:\\IdeaProjects\\attachment";
        } else if (osName.contains("linux") || osName.contains("unix") || osName.contains("sunos")) {
            // Linux/Unix 路径
            base = "/usr/data/attachments";
        }

        // 确保路径以分隔符结尾
        if (!base.endsWith(File.separator)) {
            base += File.separator;
        }
    }
    public String uploadFile(MultipartFile file){
        return LinuxStorageUtils.upLoad(base,file);
    }
    public ResponseEntity<Resource> downloadFile(String path) throws IOException {
        return LinuxStorageUtils.download(base+path);
    }

    public void delete(String path) {
        LinuxStorageUtils.delete(base+path);
    }
}
