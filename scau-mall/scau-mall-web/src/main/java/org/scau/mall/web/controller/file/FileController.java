package org.scau.mall.web.controller.file;


import org.scau.mall.vo.resp.CommonRespone;
import org.scau.mall.web.config.PropertieConfig;
import org.scau.mall.web.utils.FastdfsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件控制了
 * FileController: FileController.java.
 *
 * <br>==========================
 * <br> 公司：广州向日葵信息科技有限公司
 * <br> 开发：John@xiangrikui.com
 * <br> 创建时间：2022年3月13日
 * <br> 修改时间：2022年3月13日
 * <br> 版本：1.0
 * <br> JDK版本：1.8
 * <br>==========================
 */
@RestController
public class FileController {
    
    @Autowired
    public PropertieConfig config;
    
    @PostMapping("/fdfs_upload")
    public CommonRespone<Object> fileUpload(@RequestParam("file")MultipartFile file) {
        String path = FastdfsUtils.uploadFile(file);
        path = config.domainUrl + path;
        return CommonRespone.success((Object)path);
    }
}
