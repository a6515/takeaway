package com.example.takeawaypro.controller;

import com.example.takeawaypro.bean.Result;
import com.example.takeawaypro.utils.QiniuUploader;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@CrossOrigin
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file, HttpServletResponse response,@RequestHeader(name = "Authorization") String token) {
        System.out.println("开始接受文件");
        String originalFilename = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        try {
            file.transferTo(new File("C:\\Users\\杰杰\\Desktop\\yimajia\\" + filename));
           String url= QiniuUploader.Qiniuup("C:\\Users\\杰杰\\Desktop\\yimajia\\" + filename);

            return Result.success(url);
        } catch (IOException e) {
            response.setStatus(997);  //文件超限
            // 捕获并处理 IO 异常
            return Result.error("上传失败: 文件保存失败");
        }
    }

}
