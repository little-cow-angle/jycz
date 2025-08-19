package gene.recombine.stuhubsys.utils;

import lombok.extern.slf4j.Slf4j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * 工具类用于将多个文件压缩成一个ZIP文件。
 */
@Slf4j
public class ZipUtils {
    /**
     * 将多个文件压缩成一个ZIP文件。
     * @param paths 文件路径数组
     * @return ZIP文件的字节数组
     * @throws IOException 如果文件读取或压缩过程中发生IO异常
     */
    public static byte[] zipFiles(Path[] paths) throws IOException {
        ByteArrayOutputStream baous = new ByteArrayOutputStream();
        try (ZipOutputStream zos = new ZipOutputStream(baous)) {
            for (Path path : paths) {
                log.info(path.toString());
                byte[] bytes = Files.readAllBytes(path);

                // 获取文件名并去除空格
                String fileName = path.getFileName().toString();
                if (fileName.contains(" ")) {
                    fileName = fileName.replace(" ", ""); // 移除所有空格
                    log.info("检测到文件名含空格，已处理为: " + fileName);
                }

                ZipEntry zipEntry = new ZipEntry(fileName); // 使用处理后的文件名
                zos.putNextEntry(zipEntry);
                zos.write(bytes);
                zos.closeEntry();
            }
            log.info("压缩成功");
        }
        return baous.toByteArray();
    }
//    public static byte[] zipFiles(Path[] paths) throws IOException {
//
//        ByteArrayOutputStream baous = new ByteArrayOutputStream(); // 创建字节输出流，用于存储ZIP文件内容
//        try (ZipOutputStream zos = new ZipOutputStream(baous)) { // 创建ZIP输出流
//            for (Path path : paths) { // 遍历文件路径数组
//                log.info(path.toString());
//                byte[] bytes = Files.readAllBytes(path); // 读取文件内容到字节数组
//                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString()); // 创建ZIP条目
//                zos.putNextEntry(zipEntry); // 开始一个新的ZIP条目
//                zos.write(bytes); // 将文件内容写入ZIP条目
//                zos.closeEntry(); // 关闭当前ZIP条目
//            }
//            log.info("压缩成功");
//        }
//        return baous.toByteArray(); // 将压缩后的ZIP文件内容转换为字节数组并返回
//    }
}

