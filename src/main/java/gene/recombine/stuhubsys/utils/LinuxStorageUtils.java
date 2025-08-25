package gene.recombine.stuhubsys.utils;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


public class LinuxStorageUtils {

    public static String upLoad(String BasePath, MultipartFile file) {
        String relativePath = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String Path = BasePath +relativePath;
        try {
            // 检查文件是否为空
            if (file.isEmpty()) {
                return "文件不能为空";
            }
            File dest = new File(Path);
            // 保存文件到指定路径
            file.transferTo(dest);
            return relativePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ResponseEntity<Resource> download(String filePath) throws IOException {
        // 1. 参数校验
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("文件路径不能为空");
        }

        // 2. 规范化路径并检查文件
        Path normalizedPath = Paths.get(filePath).normalize();
        Resource resource;

        try {
            resource = new UrlResource(normalizedPath.toUri());
        } catch (MalformedURLException e) {
            throw new IOException("无效的文件路径: " + filePath, e);
        }

        // 3. 检查文件是否存在和可读
        if (!resource.exists()) {
            throw new FileNotFoundException("文件不存在: " + normalizedPath);
        }
        if (!resource.isReadable()) {
            throw new IOException("文件不可读: " + normalizedPath);
        }

        // 4. 获取文件名并设置响应头
        String filename = normalizedPath.getFileName().toString();
        HttpHeaders headers = new HttpHeaders();

        // 设置内容类型（根据文件扩展名自动判断）
        String contentType = determineContentType(filename);
        headers.setContentType(MediaType.parseMediaType(contentType));

        // 设置内容长度（可选）
        try {
            long contentLength = Files.size(normalizedPath);
            headers.setContentLength(contentLength);
        } catch (IOException e) {
            // 如果获取长度失败，可以忽略，不设置Content-Length头
        }

        // 设置下载文件名（处理中文文件名编码问题）
        String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8.toString())
                .replaceAll("\\+", "%20");
        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + encodedFilename + "\"; filename*=utf-8''" + encodedFilename);

        // 5. 构建响应
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    // 根据文件扩展名确定Content-Type
    private static String determineContentType(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        switch (extension) {
            case "pdf":
                return "application/pdf";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "png":
                return "image/png";
            case "xls":
                return "application/vnd.ms-excel";
            case "xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "doc":
                return "application/msword";
            case "docx":
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "ppt":
                return "application/vnd.ms-powerpoint";
            case "pptx":
                return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            case "zip":
                return "application/zip";
            case "txt":
                return "text/plain";
            case "csv":
                return "text/csv";
            case "json":
                return "application/json";
            case "xml":
                return "application/xml";
            default:
                return "application/octet-stream";
        }
    }

    public static void delete(String filePath) {
        File file = new File(filePath);
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) {
           try {
               file.delete();
//               log.info("windows删除成功");
           }catch (Exception e){
               e.printStackTrace();
           }
        }else if (osName.contains("Linux")) {
            try {
                // 使用ProcessBuilder执行rm命令
                ProcessBuilder processBuilder = new ProcessBuilder("/bin/rm", "-f", filePath);
                Process process = processBuilder.start();

                // 等待命令执行完成
                int exitCode = process.waitFor();
                if (exitCode == 0) {
//                    log.info("文件删除成功");
                } else {
//                    log.info("文件删除失败，错误码：{}", exitCode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
