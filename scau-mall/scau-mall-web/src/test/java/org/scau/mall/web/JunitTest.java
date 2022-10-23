package org.scau.mall.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes= {MallWebApplication.class})
public class JunitTest {
    
//    @Autowired
//    private FastFileStorageClient storageClient;
    
    @Test
    public void uploadTest() throws IOException, MyException {
        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(filePath);
        //ClientGlobal.initByProperties("fastdfs-client.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
        NameValuePair[] pairs = null;
        try {
            String fileId = client1.upload_file1("D:\\document\\课余学习资料\\前端\\vuejs实现电商后台\\资料\\imgs\\bg.jpg", "jpg", pairs);
            System.out.println(fileId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 文件上传
     */
//    @Test
//    public void uploadTest() {
//        InputStream is = null;
//        try
//        {
//            // 获取文件源
//            File source = new File("D:\\document\\课余学习资料\\前端\\vuejs实现电商后台\\资料\\imgs\\bg.jpg");
//            // 获取文件流
//            is = new FileInputStream(source);
//            // 进行文件上传
////            StorePath storePath = storageClient.uploadFile(is, source.length(), FilenameUtils.getExtension(source.getName()), null);
////            // 获得文件上传后访问地址
////            String fullPath = storePath.getFullPath();
////            // 打印访问地址
////            System.out.println("fullPath = " + fullPath);
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try
//            {
//                if(is != null)
//                {
//                    // 关闭流资源
//                    is.close();
//                }
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
}
