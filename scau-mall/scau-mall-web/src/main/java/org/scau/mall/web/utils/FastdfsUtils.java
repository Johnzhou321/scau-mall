package org.scau.mall.web.utils;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public class FastdfsUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(FastdfsUtils.class);

    public static String uploadFile(MultipartFile multipartFile) {

        //ip地址
        String imgUrl =  "";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
        String tracker = FastdfsUtils.class.getResource("/fdfs_client.conf").getPath();// 获得配置文件的路径

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            logger.error("init error msg={}", e.getMessage());
        }

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            logger.error("trackerServer error msg={}", e.getMessage());
        }

        // 通过tracker获得一个Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);

        try {

            byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象

            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();// a.jpg
            logger.info(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i+1);

            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

            for (String uploadInfo : uploadInfos) {
                imgUrl += "/"+uploadInfo;
            }
        } catch (Exception e) {
            logger.error("upload error ,msg={}", e.getMessage());
        }
        return imgUrl;
    }
}


