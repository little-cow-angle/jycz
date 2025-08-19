package gene.recombine.stuhubsys.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 工具类用于构建包含文件下载的ResponseEntity。
 */
public class ResponseEntityUtils {
    /**
     * 构建文件下载的ResponseEntity。
     * @param fileName 文件名
     * @param fileContent 文件内容（字节数组）
     * @return 包含文件下载的ResponseEntity
     */
    public static ResponseEntity<byte[]> buildFileDownloadResponse(String fileName, byte[] fileContent) {
        try {
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()); // 对文件名进行URL编码
            HttpHeaders headers = new HttpHeaders(); // 创建HTTP响应头
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 设置内容类型为二进制流
            headers.setContentDispositionFormData("attachment", fileName); // 设置内容处置，指示浏览器下载文件
            return ResponseEntity.ok() // 创建200 OK响应
                    .headers(headers) // 设置响应头
                    .body(fileContent); // 设置响应体为文件内容
        } catch (Exception e) {
            return ResponseEntity.status(500) // 创建500 Internal Server Error响应
                    .body("Error occurred while creating the file download response".getBytes()); // 设置响应体为错误信息
        }
    }
}
